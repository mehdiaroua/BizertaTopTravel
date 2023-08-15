package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.Services.IMaison;
import com.bezkoder.springjwt.models.Maison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class MaisonController {
    @Autowired
    IMaison imaison;
    @GetMapping("getMaisonById/{id}")
    public Maison retrieveMaisonById(@PathVariable("id") Long id){
        return imaison.retrieveMaisonById(id);
    }


    @DeleteMapping("deleteMaison")
    public void deleteMaison(@RequestBody Maison m) throws AccessDeniedException {
        imaison.deleteMaison(m);
    }
    @GetMapping("/getAllMaisonWithImage")
    public List<Maison> retrieveAllMaisonWithImage(){
        return  imaison.getAllMaisonAndImage();
    }
    @PostMapping("/addMaisonWithImg")
    public Maison addMaisonAndImage(@RequestParam("nom")String nom, @RequestParam("description") String description, @RequestParam("pays") String pays,  @RequestParam("prix")double prix,@RequestParam("image") MultipartFile image) throws IOException {
        return imaison.addMaisonAndImage(nom,  description,  pays,prix, image);
    }

    @PutMapping("/updateMaisonWithImg")
    public Maison updateMaisonAndImage(@RequestParam("id")long id,@RequestParam("nom")String nom, @RequestParam("description") String description,@RequestParam("pays") String pays,@RequestParam("prix")double prix,@RequestParam("image") MultipartFile image) throws IOException
    {
        return imaison.updateMaisonAndImage(id,nom,  description,  pays,prix,image);
    }
}
