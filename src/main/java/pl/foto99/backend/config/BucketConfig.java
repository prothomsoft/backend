package pl.foto99.backend.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("s3")
@Data
public class BucketConfig {
    private String accessId;
    private String secretKey;
}
