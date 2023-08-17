package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Hotel;
import com.bezkoder.springjwt.models.Plage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlageRepo extends JpaRepository<Plage,Long> {
    List<Plage> findByPaysContainingIgnoreCaseAndNomContainingIgnoreCase(String pays, String nom);

}
