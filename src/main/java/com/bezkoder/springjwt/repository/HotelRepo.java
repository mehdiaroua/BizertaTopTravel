package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Hotel;
import com.bezkoder.springjwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepo extends JpaRepository<Hotel,Long> {
    List<Hotel> findByPaysContainingIgnoreCaseAndNomContainingIgnoreCase(String pays, String nom);
}
