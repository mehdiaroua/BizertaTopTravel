package com.bezkoder.springjwt.Services;
import com.bezkoder.springjwt.models.Bus;
import com.bezkoder.springjwt.models.User;

import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.payload.request.SignupRequest;

import java.util.List;
import java.util.Set;

public interface IUser {
    User addUser(User user, Set<Role> roles);
    User retrieveUserById(Long id);
    List<User> retrieveAllUser();
    void deleteUser(Long id);
    List<User> searchUsersByUsername(String username);
    User updateUser(Long id , User b) ;
    Set<Role> getRoles(Long id);
}
