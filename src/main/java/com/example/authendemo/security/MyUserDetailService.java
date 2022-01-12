package com.example.authendemo.security;

import com.example.authendemo.entity.User;
import com.example.authendemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    //tìm username trong DB, lấy ra đối tượng username với các role của username đó,
    // sau đó tạo ra 1 đối tượng username của spring
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User existUser = repository.findByUsername(username);
        if (existUser == null) throw new UsernameNotFoundException("User not found.");
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(existUser.getRole()));
        org.springframework.security.core.userdetails.User userSpring
                = new org.springframework.security.core.userdetails.User(
                existUser.getUsername(), existUser.getPassword(), authorities);
        return userSpring;
    }
}
