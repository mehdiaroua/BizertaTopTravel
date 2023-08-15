package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffreRepo extends JpaRepository<Offre,Long> {
}
