package com.example.multipartfile.dto;


import jakarta.persistence.Lob;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhotoDto {

    private Long size;
    private String fileType;
    @Lob
    private byte[] image;


}

