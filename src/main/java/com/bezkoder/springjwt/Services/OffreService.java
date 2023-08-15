package com.bezkoder.springjwt.Services;

import com.bezkoder.springjwt.models.Bus;
import com.bezkoder.springjwt.models.Offre;
import com.bezkoder.springjwt.repository.OffreRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
@AllArgsConstructor
public class OffreService implements IOffre{
    OffreRepo offrerepo;
    @Override
    public Offre addOffre(Offre b) {
        return offrerepo.save(b);    }

    @Override
    public Offre updateOffre(Long id, Offre b) {
        Offre o = offrerepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("bus with id " + id + " not found"));

        o.setDescription(b.getDescription());
        o.setPays(b.getPays());
        o.setTypeEx(b.getTypeEx());


        return offrerepo.save(o);
    }

    @Override
    public Offre retrieveOffreById(Long id) {
        return offrerepo.findById(id).orElse(null);    }

    @Override
    public List<Offre> retrieveAllOffre() {
        return offrerepo.findAll();    }

    @Override
    public void deleteOffre(Long id) {
        offrerepo.deleteById(id);

    }
}
