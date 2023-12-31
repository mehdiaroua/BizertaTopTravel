package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.Services.HotelService;
import com.bezkoder.springjwt.Services.Ihotel;
import com.bezkoder.springjwt.models.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/test")
public class HotelController {
    @Autowired
    Ihotel ihotel;
    @Autowired
    HotelService hotelService;
    @GetMapping("getHotelById/{id}")
    public Hotel retrieveHotelById(@PathVariable("id") Long id){
        return ihotel.retrieveHotelById(id);
    }


    @DeleteMapping("deleteHotel")
    public void deleteHotel(@RequestBody Hotel h) throws AccessDeniedException {
        ihotel.deleteHotel(h);
    }
    @GetMapping("/getAllHotelWithImage")
    public List<Hotel> retrieveAllHotelWithImage(){
        return  ihotel.getAllHotelsAndImage();
    }
    @PostMapping("/addHotelWithImg")
    public Hotel addHotelAndImage(@RequestParam("nom")String nom, @RequestParam("description") String description, @RequestParam("pays") String pays,  @RequestParam("prix")double prix,@RequestParam("image") MultipartFile image) throws IOException {
        return ihotel.addHotelAndImage(nom,  description,  pays,prix, image);
    }

    @PutMapping("/updateHotelWithImg")
    public Hotel updateHotelAndImage(@RequestParam("id")long id,@RequestParam("nom")String nom, @RequestParam("description") String description,@RequestParam("pays") String pays,@RequestParam("prix")double prix,@RequestParam("image") MultipartFile image) throws IOException
    {
        return ihotel.updateHotelAndImage(id,nom,  description,  pays,prix,image);
    }
    @GetMapping("/searchHotels")
    public List<Hotel> searchHotelsByNomPays(
            @RequestParam(name = "pays") String pays,
            @RequestParam(name = "nom") String nom) {

        return hotelService.searchHotelsByNomPays(pays, nom);
    }
}
