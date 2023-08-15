package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Maison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaisonRepo extends JpaRepository<Maison,Long> {
}
