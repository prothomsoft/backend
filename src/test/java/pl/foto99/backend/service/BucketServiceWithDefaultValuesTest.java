package pl.foto99.backend.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@SpringBootTest
class BucketServiceWithDefaultValuesTest {

    @Autowired
    BucketServiceWithDefaultValues bucketService;

    @Test
    @Disabled
    public void listBucket(){
        bucketService.listBuckets(Optional.empty());
    }

    @Test
    @Disabled
    public void createBucket(){
        bucketService.createDefaultBucket(Optional.empty());
    }

    @Test
    @Disabled
    public void listBucketObjects(){
        bucketService.listDefaultBucketContent(Optional.empty());
    }

    @Test
    @Disabled
    public void deleteAllFilesDefaultBucket(){
        bucketService.deleteDefaultBucketContent(Optional.empty());
        bucketService.listDefaultBucketContent(Optional.empty());
    }

    @Test
    @Disabled
    public void uploadFile() throws IOException {
        String remoteFileName = "myfile"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH_mm_ss"))
                + ".txt";
        InputStream resourceAsStream = BucketServiceWithDefaultValuesTest.class.getResourceAsStream("/myfileforunittests.txt");
        long numberOfBytes = resourceAsStream.available();
        bucketService.uploadFileToDefaultBucket(resourceAsStream, numberOfBytes, remoteFileName, Optional.empty());
        bucketService.listDefaultBucketContent(Optional.empty());
    }
}