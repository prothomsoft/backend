package pl.foto99.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@RequiredArgsConstructor
public class BucketService {
    final String DEFAULT_BUCKET_NAME = "javabucketdomel";

    private S3Client getClient(AwsCredentialsProvider provider) {
        Region region = Region.EU_WEST_3;
        S3Client s3 = S3Client.builder()
                .region(region)
                .credentialsProvider(provider)
                .build();
        return s3;
    }

    public void uploadFile(AwsCredentialsProvider provider) throws IOException {
        S3Client s3 = getClient(provider);
        String bucketName = DEFAULT_BUCKET_NAME;
        String remoteFilename = "myfile"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH_mm_ss"))
                + ".txt";

        InputStream resourceAsStream = BucketService.class.getResourceAsStream("/myfile.txt");

        s3.putObject(PutObjectRequest
                        .builder()
                        .bucket(bucketName)
                        .key(remoteFilename)
                        .build(),
                RequestBody.fromInputStream(resourceAsStream, resourceAsStream.available())
        );

        s3.close();
    }
}
