package com.example.multipartfile.controller;

import com.example.multipartfile.dto.PhotoDto;
import com.example.multipartfile.service.PhotoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;



@AllArgsConstructor
@RestController
@RequestMapping("api/")
public class Controller {


    private final PhotoService photoService;

    @PostMapping(value = "image/save/{file}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    public ResponseEntity<PhotoDto> savePhotoInDb(MultipartFile file) throws IOException {
        return new ResponseEntity(photoService.saveNewPhoto(file), HttpStatus.OK);


    }

}
