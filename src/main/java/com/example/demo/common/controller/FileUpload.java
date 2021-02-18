package com.example.demo.common.controller;

import java.io.File;
import java.io.FileNotFoundException;

import com.example.demo.common.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RequiredArgsConstructor
@RestController
public class FileUpload {

    private final ResourceLoader resourceLoader;
    private final FileUploadService fileUploadService;
    private final String PATH = "C:\\spring-project\\src\\main\\resources\\static\\resources\\uploadImg\\";

    @PostMapping(value = "/fileUpload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) throws Exception {

        String uploadPath = PATH + file.getOriginalFilename();

        file.transferTo(new File(uploadPath));
        return ResponseEntity.ok().body("/resources/uploadImg/" + file.getOriginalFilename());
    }

    @GetMapping("/fileDownload/{value}")
    public ResponseEntity<Resource> resourceFileDownload(@PathVariable("value") String fileName) {
        try {
            Resource resource = resourceLoader.getResource("classpath:static/resources/uploadImg/"+ fileName);
            File file = resource.getFile();	//파일이 없는 경우 fileNotFoundException error가 난다.

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,file.getName())
                    .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(file.length()))
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM.toString())
                    .body(resource);	//파일 넘기기
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest()
                    .body(null);
        } catch (Exception e ) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
