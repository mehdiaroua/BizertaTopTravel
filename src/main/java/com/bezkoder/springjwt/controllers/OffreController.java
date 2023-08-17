package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.Services.IOffre;
import com.bezkoder.springjwt.models.Bus;
import com.bezkoder.springjwt.models.Offre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/test")
public class OffreController {
    @Autowired
    IOffre ioffre;
    @PostMapping("/addOffre")
    public Offre addOffre(@RequestBody Offre b){
        return ioffre.addOffre(b);

    }
    @PutMapping("/updateOffre/{id}")
    public Offre updateOffre(@PathVariable("id") Long id, @RequestBody Offre b)  {
        return ioffre.updateOffre(id,b);
    }
    @GetMapping("/getOffreById/{id}")
    public Offre retrieveOffreById(@PathVariable("id") Long id){
        return ioffre.retrieveOffreById(id);
    }
    @GetMapping("/getoffre")
    public List<Offre> retrieveAllOffre(){
        return ioffre.retrieveAllOffre();
    }
    @DeleteMapping("/deleteOffre/{id}")
    public void deleteOffre(@PathVariable("id") Long id){
        ioffre.deleteOffre(id);
    }
}
