package com.grada.ecommerce.Controllers.Api;


import com.grada.ecommerce.Models.Seller.Seller;
import com.grada.ecommerce.Models.User.User;
import com.grada.ecommerce.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserRestController
{
    @Autowired
    UserService userService;


    @RequestMapping("/api/user")
    public User GetUser(@RequestParam(value = "id", defaultValue = "0") long id)
    {
        User user = userService.FindUserByID(id);
        if(user == null)
            return null;

        return user;
    }

    @RequestMapping(value = "api/user/add", method = RequestMethod.POST)
    public String AddUser(@RequestBody User user)
    {
        if(user == null )
            return "User is null";
        userService.AddUser(user);
        return "User added";
    }

    @RequestMapping("api/user/delete")
    public String DeleteUser(@RequestParam(value = "id", defaultValue = "0") long id)
    {

        User tempUser = userService.FindUserByID(id);
        if(tempUser == null)
            return "User not found";

        userService.DeleteUser(tempUser);
        return "Deleted User";

    }

    //breaks
    @RequestMapping(value = "api/user/edit", method = RequestMethod.POST)
    public User EditUser(@RequestBody User user)
    {
        if(user.id < 0)
            return null;

        User userOld = userService.FindUserByID(user.id);

        if(user == null)
            return null;

        userService.AddUser(user);
        return user;
    }







}
