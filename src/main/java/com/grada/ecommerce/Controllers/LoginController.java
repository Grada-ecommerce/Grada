package com.grada.ecommerce.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController
{

    @RequestMapping(value = "/login")
    public ModelAndView LoginPage(@RequestParam(value = "error", required = false) String error,
                                  @RequestParam(value = "logout", required = false) String logout)
    {
        ModelAndView modelAndView = new ModelAndView();

        if(error != null)
        {
            modelAndView.addObject("error","Invalid Credentials");
        }
        if(logout != null)
        {
            modelAndView.addObject("message","logged out sucessfully");
        }

        modelAndView.setViewName("login");
        return modelAndView;
    }
    }
