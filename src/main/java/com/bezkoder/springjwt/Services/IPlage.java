package com.bezkoder.springjwt.Services;

import com.bezkoder.springjwt.models.Plage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.List;

public interface IPlage {
    public List<Plage> getAllPlagesAndImage();
    public Plage addPlageAndImage(String nom, String description, String pays, double prix, MultipartFile image) throws IOException;
    public Plage updatePlageAndImage(long id, String nom, String description, String pays,double prix,  MultipartFile image) throws IOException;
    Plage retrievePlageById(Long id);
    void deletePlage(Plage h) throws AccessDeniedException;
}
