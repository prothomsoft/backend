package pl.foto99.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.foto99.backend.config.BucketConfig;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.exception.SdkServiceException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UploadFileService {

    private final BucketConfig bucketConfig;
    private final S3Client s3Client;

    public String uploadFile(MultipartFile file, String fileName) {
        try {
            log.info("Uploading " + fileName + " to bucket " + bucketConfig.getBucketName());
            final PutObjectResponse putObjectResponse = s3Client.putObject(getPutObjectRequest(fileName), getFileRequestBody(file));
            log.info("putObjectResult = " + putObjectResponse);
        } catch (IOException e) {
            log.info("Exception e:" + e);
        } catch (SdkServiceException ase) {
            log.error("Caught an AmazonServiceException, which " + "means your request made it "
                    + "to Amazon S3, but was rejected with an error response" + " for some reason.", ase);
            log.info("Error Message:    " + ase.getMessage());
            log.info("Key:       " + fileName);
            throw ase;
        } catch (SdkClientException ace) {
            log.error("Caught an AmazonClientException, which " + "means the client encountered "
                    + "an internal error while trying to " + "communicate with S3, "
                    + "such as not being able to access the network.", ace);
            log.error("Error Message: {}, {}", fileName, ace.getMessage());
            throw ace;
        }
        return findUploadURL(fileName);
    }

    public String getUploadedURLs(MultipartFile[] files) {
        return Arrays.stream(files).filter(file -> !file.isEmpty()).map(file -> findUploadURL(file.getOriginalFilename())).collect(Collectors.joining(","));
    }

    private String findUploadURL(String originalFileName) {
        GetUrlRequest request = GetUrlRequest.builder()
                .bucket(bucketConfig.getBucketName())
                .key(originalFileName)
                .build();
        return s3Client.utilities().getUrl(request).toString();
    }

    private RequestBody getFileRequestBody(MultipartFile file) throws IOException {
        return RequestBody.fromInputStream(file.getInputStream(), file.getSize());
    }

    private PutObjectRequest getPutObjectRequest(String keyName) {
        return PutObjectRequest.builder()
                .bucket(bucketConfig.getBucketName())
                .key(keyName)
                .build();
    }
}