package pl.foto99.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.foto99.backend.config.BucketConfig;

@SpringBootApplication
@EnableJpaRepositories
@EnableConfigurationProperties(value = {BucketConfig.class})
public class BackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}
