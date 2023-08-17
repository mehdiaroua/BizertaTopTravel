package com.bezkoder.springjwt.Services;

import com.bezkoder.springjwt.models.Hotel;
import com.bezkoder.springjwt.repository.HotelRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;

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

public class HotelService implements Ihotel{

    HotelRepo hotelrepo;

    @Override
    public List<Hotel> getAllHotelsAndImage() {
        List<Hotel> hotel = hotelrepo.findAll();
        for (Hotel Item : hotel) {
            if (Item.getImageData() != null) {
                try {
                    String imageBase64 = Base64.getEncoder().encodeToString(Item.getImageData());
                    Item.setImageBase64(imageBase64);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return hotel;
    }

    @Override
    public Hotel addHotelAndImage(String nom, String description, String pays,double prix, MultipartFile image) throws IOException {
        Hotel pt = new Hotel();
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
        hotelrepo.save(pt);
        return pt;
    }

    @Override
    public Hotel updateHotelAndImage(long id, String nom, String description, String pays,double prix, MultipartFile image) throws IOException {
        Hotel pt = new Hotel();
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
        hotelrepo.save(pt);
        return pt;
    }

    @Override
    public Hotel retrieveHotelById(Long id) {
        return hotelrepo.findById(id).orElse(null);
    }

    @Override
    public void deleteHotel(Hotel h) throws AccessDeniedException {
        hotelrepo.delete(h);
    }

    public List<Hotel> searchHotelsByNomPays(String pays, String nom) {
        return hotelrepo.findByPaysContainingIgnoreCaseAndNomContainingIgnoreCase(pays, nom);
    }


}
