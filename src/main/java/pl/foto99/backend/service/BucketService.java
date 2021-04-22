package pl.foto99.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BucketService {

    private final S3Client s3Client;

    public void createBucket(String bucketName) {
        boolean exists = s3Client.listBuckets()
                .buckets()
                .stream()
                .anyMatch(b -> b.name().equals(bucketName));
        if (!exists) {
            log.info("Create bucket!");
            CreateBucketResponse bucket = s3Client.createBucket(CreateBucketRequest
                    .builder()
                    .bucket(bucketName)
                    .build());
            log.info("Create bucket Done - Result:{}", bucket.toString());
        } else {
            log.info("Bucket already exists!");
        }
    }

    public String getBucketsList() {
        return s3Client.listBuckets().buckets().stream().map(Bucket::name).collect(Collectors.joining(","));
    }

    public String listBucketContent(String bucketName) {
        ListObjectsResponse response = s3Client.listObjects(ListObjectsRequest
                .builder()
                .bucket(bucketName)
                .build());

        return response.contents().stream().map(S3Object::key).collect(Collectors.joining(","));
    }

    public void deleteBucketContent(String bucketName) {
        ListObjectsResponse response = s3Client.listObjects(ListObjectsRequest
                .builder()
                .bucket(bucketName)
                .build());

        response.contents().forEach(s3Object ->
                s3Client.deleteObject(
                        DeleteObjectRequest.builder()
                                .bucket(bucketName)
                                .key(s3Object.key())
                                .build()));
    }
}
