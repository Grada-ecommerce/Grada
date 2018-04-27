package com.grada.ecommerce.Controllers;


import com.grada.ecommerce.Models.Customer.Customer;
import com.grada.ecommerce.Models.Seller.Seller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/customer")
@Controller
public class CustomerController
{
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView CustomerRegistration()
    {
        ModelAndView modelAndView = new ModelAndView("customer_register");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

}
