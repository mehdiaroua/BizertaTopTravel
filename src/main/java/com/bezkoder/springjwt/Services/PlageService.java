package com.bezkoder.springjwt.Services;

import com.bezkoder.springjwt.models.Hotel;
import com.bezkoder.springjwt.models.Plage;
import com.bezkoder.springjwt.repository.PlageRepo;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
@Service
@AllArgsConstructor
public class PlageService implements IPlage{
    PlageRepo plagerepo;
    @Override
    public List<Plage> getAllPlagesAndImage() {
        List<Plage> plage = plagerepo.findAll();
        for (Plage Item : plage) {
            if (Item.getImageData() != null) {
                try {
                    String imageBase64 = Base64.getEncoder().encodeToString(Item.getImageData());
                    Item.setImageBase64(imageBase64);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return plage;
    }

    @Override
    public Plage addPlageAndImage(String nom, String description, String pays, double prix, MultipartFile image) throws IOException {
        Plage pt = new Plage();
        pt.setNom(nom);
        pt.setDescription(description);
        pt.setPays(pays);
        pt.setPrix(prix);
        // pt.setNutrition(nutritionRepository.findById(nutritionId).orElse(null));
        //pt.setUser(userRepository.findById(user).orElse(null));
        byte[] imageData = image.getBytes();
        System.err.println(imageData.toString());
        pt.setImageData(imageData);
        // Save the image file to a folder named 'images' in your project directory
        Path directory = Paths.get("images");
        if (!Files.exists(directory)) {Files.createDirectories(directory);}
        Path imagePath = directory.resolve(UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(image.getOriginalFilename()));
        Files.write(imagePath, imageData);
        plagerepo.save(pt);
        return pt;    }

    @Override
    public Plage updatePlageAndImage(long id, String nom, String description, String pays, double prix, MultipartFile image) throws IOException {
        Plage pt = new Plage();
        pt.setId(id);
        pt.setNom(nom);
        pt.setDescription(description);
        pt.setPays(pays);
        pt.setPrix(prix);

        byte[] imageData = image.getBytes();
        System.err.println(imageData.toString());
        pt.setImageData(imageData);
        // Save the image file to a folder named 'images' in your project directory
        Path directory = Paths.get("images");
        if (!Files.exists(directory)) {Files.createDirectories(directory);}
        Path imagePath = directory.resolve(UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(image.getOriginalFilename()));
        Files.write(imagePath, imageData);
        plagerepo.save(pt);
        return pt;    }

    @Override
    public Plage retrievePlageById(Long id) {
        return plagerepo.findById(id).orElse(null);    }

    @Override
    public void deletePlage(Plage h) throws AccessDeniedException {
        plagerepo.delete(h);


    }
    public List<Plage> searchPlagesByNomPays(String pays, String nom) {
        return plagerepo.findByPaysContainingIgnoreCaseAndNomContainingIgnoreCase(pays, nom);
    }
}
