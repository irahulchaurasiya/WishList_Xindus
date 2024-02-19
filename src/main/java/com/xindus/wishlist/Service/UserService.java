package com.xindus.wishlist.Service;


import com.xindus.wishlist.Exception.UserNotFoundException;
import com.xindus.wishlist.Models.User;
import com.xindus.wishlist.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class UserService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElse(null);

        if (user == null) {
            throw new UserNotFoundException("User : " + username + "not found");
        }
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("user");
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Set.of(authority));
    }
}
