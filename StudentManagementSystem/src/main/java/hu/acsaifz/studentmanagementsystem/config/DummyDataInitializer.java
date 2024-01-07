package hu.acsaifz.studentmanagementsystem.config;

import hu.acsaifz.studentmanagementsystem.service.InitDbService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class DummyDataInitializer implements CommandLineRunner {

    private final InitDbService initDbService;

    @Override
    public void run(String... args) throws Exception {
        initDbService.clearDb();
        initDbService.initDb();
        //Egy kis időeltolás a könnyebb verzió lekérdezéshez
        log.info("Waiting 5 sec for course modification.");
        Thread.sleep(5000);
        initDbService.modifyDb();
    }
}
