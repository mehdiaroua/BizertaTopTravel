package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepo extends JpaRepository<Bus,Long> {
}
