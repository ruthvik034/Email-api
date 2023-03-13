package com.springbootemail.application.service;

import com.springbootemail.application.Repository.UsersRepository;
import com.springbootemail.application.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class CustomUserDetailsService implements UserDetailsService {
   @Autowired
   private UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users users = usersRepository.findByEmail(s);
        if (users == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(users);
    }
}
