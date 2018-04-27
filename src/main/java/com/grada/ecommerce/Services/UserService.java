/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grada.ecommerce.Services;

import com.grada.ecommerce.Data.UserRepository;
import com.grada.ecommerce.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rishabh Gupta
 */
@Service
public class UserService{
    
    UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    
    public boolean addUser(User u)
    {
        if(u==null)
            return false;
        userRepository.save(u);
        return true;
        
    }
    
}
