/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grada.ecommerce.Services;
import com.grada.ecommerce.Data.UserRepository;
import com.grada.ecommerce.Models.MyUserPrincipal;
import com.grada.ecommerce.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rishabh Gupta
 */
@Service
public class MyUserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    
    public MyUserDetailsService() {

        super();

    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final User user = userRepository.findUserByUsername(username);

        if (user == null) {

            throw new UsernameNotFoundException(username);

        }

        return new MyUserPrincipal(user);

    }
    
}
