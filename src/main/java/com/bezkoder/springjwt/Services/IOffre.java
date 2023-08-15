package com.bezkoder.springjwt.Services;

import com.bezkoder.springjwt.models.Bus;
import com.bezkoder.springjwt.models.Offre;

import java.util.List;

public interface IOffre {
    Offre addOffre(Offre b);
    Offre updateOffre(Long id ,Offre b) ;
    Offre retrieveOffreById(Long id);
    List<Offre> retrieveAllOffre();
    void deleteOffre(Long id);
}
