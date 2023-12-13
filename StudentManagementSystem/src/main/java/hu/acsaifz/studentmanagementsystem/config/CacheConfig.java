package hu.acsaifz.studentmanagementsystem.config;

import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public org.infinispan.configuration.cache.Configuration pagedCourses() {
        return new ConfigurationBuilder()
                .memory().maxCount(10000L)
                .expiration().maxIdle(10000L)
                .expiration().wakeUpInterval(2000L)
                .build();
    }
}
