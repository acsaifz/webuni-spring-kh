package hu.acsaifz.studentmanagementsystem.service;

import hu.acsaifz.studentmanagementsystem.aspect.ServiceUnavailableRetry;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Random;

@RequiredArgsConstructor
@Service
public class EducationRegistryService {

    @ServiceUnavailableRetry
    public int getFreeSemestersByStudentId(String studentId) {
        Random random = new Random();
        if (Math.random() >= 0.5) {
            throw new HttpServerErrorException(HttpStatus.SERVICE_UNAVAILABLE);
        }
        return random.nextInt(0,13);
    }
}
