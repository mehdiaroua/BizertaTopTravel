package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Plage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlageRepo extends JpaRepository<Plage,Long> {
}
