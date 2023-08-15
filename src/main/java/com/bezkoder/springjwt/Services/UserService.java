package com.bezkoder.springjwt.Services;
import com.bezkoder.springjwt.models.Bus;
import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.User;

import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.payload.request.SignupRequest;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.velocity.exception.ResourceNotFoundException;


import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
@Service
@AllArgsConstructor
public class UserService implements IUser{
    private UserRepository repo;
    @Autowired
    PasswordEncoder encoder;
    private RoleRepository rolo;

    @Override
    public User addUser(User user, Set<Role> roles) {
        user.setRoles(roles);
        return repo.save(user);    }

    @Override
    public User retrieveUserById(Long id) {
        return repo.findById(id).orElse(null);    }

    @Override
    public List<User> retrieveAllUser() {
        return repo.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        repo.deleteById(id);

    }

    @Override
    public List<User> searchUsersByUsername(String username) {
        return repo.findByUsernameContainingIgnoreCase(username);
    }

    @Override
    public User updateUser(Long id, User b) {
        User bus = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("user with id " + id + " not found"));

        bus.setEmail(b.getEmail());
        bus.setPassword(b.getPassword());
        bus.setUsername(b.getUsername());


        return repo.save(bus);
    }
    @Transactional
    public void updateUserRole(Long userId, String roleName) {
        User user = repo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + userId));

        Role role = rolo.findByName(ERole.valueOf(roleName))
                .orElseThrow(() -> new IllegalArgumentException("Invalid role name: " + roleName));

        user.getRoles().clear();
        user.getRoles().add(role);
        repo.save(user);
    }


    @Override
    public Set<Role> getRoles(Long id) {
        User user = repo.findById(id).orElseThrow(() -> new UsernameNotFoundException("User Not Found with id: " + id));
        return user.getRoles();    }
}
