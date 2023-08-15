package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.Services.IPlage;
import com.bezkoder.springjwt.Services.Ihotel;
import com.bezkoder.springjwt.models.Hotel;
import com.bezkoder.springjwt.models.Plage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class PlageController {

    @Autowired
    IPlage iplage;
    @GetMapping("getPlageById/{id}")
    public Plage retrievePlageById(@PathVariable("id") Long id){
        return iplage.retrievePlageById(id);
    }


    @DeleteMapping("deletePlage")
    public void deletePlage(@RequestBody Plage h) throws AccessDeniedException {
        iplage.deletePlage(h);
    }
    @GetMapping("/getAllPlageWithImage")
    public List<Plage> retrieveAllPlageWithImage(){
        return  iplage.getAllPlagesAndImage();
    }
    @PostMapping("/addPlageWithImg")
    public Plage addPlageAndImage(@RequestParam("nom")String nom, @RequestParam("description") String description, @RequestParam("pays") String pays,  @RequestParam("prix")double prix,@RequestParam("image") MultipartFile image) throws IOException {
        return iplage.addPlageAndImage(nom,  description,  pays,prix, image);
    }

    @PutMapping("/updatePlageWithImg")
    public Plage updatePlageAndImage(@RequestParam("id")long id,@RequestParam("nom")String nom, @RequestParam("description") String description,@RequestParam("pays") String pays,@RequestParam("prix")double prix,@RequestParam("image") MultipartFile image) throws IOException
    {
        return iplage.updatePlageAndImage(id,nom,  description,  pays,prix,image);
    }
}
