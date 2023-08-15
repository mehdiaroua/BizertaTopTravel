package com.bezkoder.springjwt.Services;

import com.bezkoder.springjwt.models.Maison;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.List;

public interface IMaison {
    public List<Maison> getAllMaisonAndImage();
    public Maison addMaisonAndImage(String nom, String description, String pays,double prix, MultipartFile image) throws IOException;
    public Maison updateMaisonAndImage(long id, String nom, String description, String pays,double prix,  MultipartFile image) throws IOException;
    Maison retrieveMaisonById(Long id);
    void deleteMaison(Maison m) throws AccessDeniedException;
}
