package pl.foto99.backend.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.foto99.backend.config.BucketConfig;
import software.amazon.awssdk.auth.credentials.*;

import java.io.IOException;

@SpringBootTest
class BucketServiceTest {

    @Autowired
    BucketService bucketService;

    @Autowired
    BucketConfig bucketConfig;

    @Test
    @Disabled
    public void uploadFileWithBasicCredentialsFromConfiguration() throws IOException {
        AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials
                .create(bucketConfig.getAccessId(), bucketConfig.getSecretKey());
        StaticCredentialsProvider staticCredentialsProvider = StaticCredentialsProvider.create(awsBasicCredentials);
        bucketService.uploadFile(staticCredentialsProvider);
    }

    @Test
    public void uploadFileWithDefaultCredentialsProvider() throws IOException {
        DefaultCredentialsProvider defaultCredentialsProvider = DefaultCredentialsProvider.create();
        bucketService.uploadFile(defaultCredentialsProvider);
    }

    @Test
    public void uploadFileWithProfileCredentialsProvider() throws IOException {
        ProfileCredentialsProvider profileCredentialsProvider = ProfileCredentialsProvider
                .builder()
                .profileName("javas3pa")
                .build();
        bucketService.uploadFile(profileCredentialsProvider);
    }
}