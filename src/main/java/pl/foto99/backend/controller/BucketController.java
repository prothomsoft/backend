package pl.foto99.backend.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.foto99.backend.service.BucketService;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/buckets")
public class BucketController {

    private final BucketService bucketService;

    @GetMapping("/")
    public ResponseEntity<String> getBucketsList() {
        return new ResponseEntity<>("Buckets list: " + bucketService.getBucketsList(), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createBucket(@RequestParam String bucketName) {
        bucketService.createBucket(bucketName);
        return new ResponseEntity<>("Bucket has been created.", HttpStatus.OK);
    }

    @GetMapping("/listbucketcontent")
    public ResponseEntity<String> listBucketContent(@RequestParam String bucketName) {
        return new ResponseEntity<>("Buckets list: " + bucketService.listBucketContent(bucketName), HttpStatus.OK);
    }

    @PostMapping(value = "/deletecontent")
    public ResponseEntity<String> deleteBucketContent(@RequestParam String bucketName) {
        bucketService.deleteBucketContent(bucketName);
        return new ResponseEntity<>("Bucket content has been deleted.", HttpStatus.OK);
    }
}
