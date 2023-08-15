package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel,Long> {
}
