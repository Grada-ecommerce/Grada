package com.grada.ecommerce.Controllers;


import com.grada.ecommerce.Models.Customer.Customer;
import com.grada.ecommerce.Models.Seller.Seller;
import com.grada.ecommerce.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/customer")
@Controller
public class CustomerController
{

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView CustomerRegistration()
    {
        ModelAndView modelAndView = new ModelAndView("customer_register");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView AddCustomer(@ModelAttribute Customer customer)
    {
        customerService.AddCustomer(customer);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("message", "Customer Added successfully");
        return modelAndView;
    }

}
