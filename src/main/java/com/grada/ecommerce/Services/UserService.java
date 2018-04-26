package com.grada.ecommerce.Services;

import com.grada.ecommerce.Data.UserRepository;
import com.grada.ecommerce.Models.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService
{
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public Iterable<User> users()
    {
        return userRepository.findAll();
    }

    public User FindUserByID(long id)
    {
        Optional<User> tempUser =  userRepository.findById(id);

        if(! tempUser.isPresent())
            return null;

        return tempUser.get();
    }

    public boolean AddUser(User user)
    {
        if(user == null)
            return false;

        userRepository.save(user);
        return true;
    }


    public boolean DeleteUser(User user)
    {
        if(user == null)
            return false;

        Optional<User> optionalUser = userRepository.findById(user.id);
        if(!optionalUser.isPresent())
            return false;

        userRepository.delete(optionalUser.get());
        return true;
    }



}
