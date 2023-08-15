package com.bezkoder.springjwt.models;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hotel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private String pays;
    private double prix;

    @Column(name = "image_data")
    @Lob
    private byte[] imageData;

    @Column(name = "image_type")
    private String imageType;

    @Column(name = "image_path")
    private String imagePath;


    public String getImageBase64() {
        if (imageData == null) {
            return null;
        }
        return Base64.getEncoder().encodeToString(imageData);
    }

    public void setImageBase64(String imageBase64) {
        if (imageBase64 == null) {
            imageData = null;
        } else {
            imageData = Base64.getDecoder().decode(imageBase64);
        }
    }
    @ManyToMany(mappedBy = "hotels")
    private Set<User> users = new HashSet<>();

}