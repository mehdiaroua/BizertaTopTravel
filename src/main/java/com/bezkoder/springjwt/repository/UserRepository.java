package com.bezkoder.springjwt.repository;

import java.util.List;
import java.util.Optional;

import com.bezkoder.springjwt.models.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.User;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  List<User> findByUsernameContainingIgnoreCase(String username);
  List<User> findByRolesName(String roleName);
  Optional<User> findByUsername(String username);



  Boolean existsByUsername(String username);
  Boolean existsByEmail(String email);
  public User findByEmail(String email);
}
