package com.example.multipartfile.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
public class Photo {
    public Photo() {
    }

    public Photo(Long id, Long size, byte[] image, String fileType) {
        this.id = id;
        this.size = size;
        this.image = image;
        this.fileType = fileType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long size;

    private String fileType;

    @Lob
    private byte[] image;


}
