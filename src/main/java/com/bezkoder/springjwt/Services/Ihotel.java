package com.bezkoder.springjwt.Services;

import com.bezkoder.springjwt.models.Hotel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.List;

public interface Ihotel {
    public List<Hotel> getAllHotelsAndImage();
    public Hotel addHotelAndImage(String nom, String description, String pays, double prix, MultipartFile image) throws IOException;
    public Hotel updateHotelAndImage(long id, String nom, String description, String pays,double prix,  MultipartFile image) throws IOException;
    Hotel retrieveHotelById(Long id);
    void deleteHotel(Hotel h) throws AccessDeniedException;
}
