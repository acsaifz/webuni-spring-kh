package hu.acsaifz.studentmanagementsystem.config;

import hu.acsaifz.studentmanagementsystem.service.InitDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DummyDataInitializer implements CommandLineRunner {

    private final InitDbService initDbService;

    @Override
    public void run(String... args) throws Exception {
        //initDbService.clearDb();
        //initDbService.initDb();
    }
}
