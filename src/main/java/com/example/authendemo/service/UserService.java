package com.example.authendemo.service;

import com.example.authendemo.entity.User;
import com.example.authendemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        user.setStatus(1);
        return userRepository.save(user);
    }

    public User update(User user) {
        if (!userRepository.findById(user.getId()).isPresent()) return null;
        return userRepository.save(user);
    }

    public boolean delete(Long id) {
        if (!userRepository.findById(id).isPresent()) return false;
        userRepository.deleteById(id);
        return true;

    }

    public User getDetail(Long id) {
        return userRepository.getById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
