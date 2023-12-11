package hu.acsaifz.studentmanagementsystem.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

@Aspect
@Slf4j
@Component
public class ServiceUnavailableExecutor {

    @Value("${service_unavailable.number_of_retries:5}")
    private int maxRetries;

    @Value("${service_unavailable.delay_of_retry:500}")
    private int retryDelay;

    @Pointcut("@annotation(ServiceUnavailableRetry)")
    public void annotationServiceUnavailableRetry() {}

    @Around("annotationServiceUnavailableRetry()")
    public Object doServiceCall(ProceedingJoinPoint pjp) throws Throwable {
        int numberOfAttempts = 0;
        HttpServerErrorException serverErrorException;

        log.info("Trying to call a service.");
        do {
            try {
                return pjp.proceed();
            }catch (HttpServerErrorException e){
                numberOfAttempts++;
                log.info("Service unavailable. Number of attempts: {}", numberOfAttempts);
                serverErrorException = e;
                Thread.sleep(retryDelay);
            }
        } while (numberOfAttempts < maxRetries);

        throw serverErrorException;
    }
}
