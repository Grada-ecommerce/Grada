/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grada.ecommerce.Data;

import com.grada.ecommerce.Models.User;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * @author Rishabh Gupta
 */
public interface UserRepository extends CrudRepository<User, Long> {
     User findUserByUsername(final String username);
     
}
