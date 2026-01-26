package com.example.multipartfile.service;


import com.example.multipartfile.dto.PhotoDto;
import com.example.multipartfile.entity.Photo;
import com.example.multipartfile.repository.PhotoRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PhotoService {

    private PhotoRepository photoRepository;
    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }
    public PhotoDto saveNewPhoto(MultipartFile file) throws IOException {

        if (file == null){
            throw new BadRequestException("Empty file");
        }

        if(file.isEmpty()){
            throw new BadRequestException("Empty file");
        }

        if(file.getSize() > 5 * 1024 * 1024){
            throw new BadRequestException("The file is too large !!!");
        }


        Photo photo = new Photo();
        photo.setSize(file.getSize());
        photo.setImage(file.getBytes());
        photo.setFileType(file.getContentType());

        photoRepository.save(photo);

        return PhotoDto.builder()
                .fileType(photo.getFileType())
                .size(photo.getSize())
                .image(photo.getImage())
                .build();
    }


}
