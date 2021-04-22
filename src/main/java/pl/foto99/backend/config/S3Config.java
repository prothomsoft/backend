package pl.foto99.backend.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
@RequiredArgsConstructor
public class S3Config {

    private final BucketConfig bucketConfig;

    @Bean(destroyMethod = "close")
    public S3Client s3Client() {

        ProfileCredentialsProvider profileCredentialsProvider = ProfileCredentialsProvider
                .builder()
                .profileName(bucketConfig.getProfileName())
                .build();

        return S3Client.builder()
                .region(Region.of(bucketConfig.getBucketRegion()))
                .credentialsProvider(profileCredentialsProvider)
                .build();
    }
}
