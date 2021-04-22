package pl.foto99.backend.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import pl.foto99.backend.service.UploadFileService;
import java.util.Arrays;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UploadFileController {

    private final UploadFileService uploadFileService;

    @PostMapping(value = "/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestPart(value = "file") MultipartFile file) {
        String reportURL = file.isEmpty() ? "" : uploadFileService.uploadFile(file, file.getOriginalFilename());
        return new ResponseEntity<>("File URL: " + reportURL, HttpStatus.OK);
    }

    @PostMapping(value = "/uploadFiles")
    public ResponseEntity<String> uploadFiles(@RequestPart("files") MultipartFile[] files) {
        Arrays.stream(files).filter(file -> !file.isEmpty()).forEach(file -> uploadFileService.uploadFile(file, file.getOriginalFilename()));
        return new ResponseEntity<>("Files URLs: " + uploadFileService.getUploadedURLs(files), HttpStatus.OK);
    }
}
