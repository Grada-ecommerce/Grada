package com.grada.ecommerce.Controllers;


import com.grada.ecommerce.Models.Customer.Customer;
import com.grada.ecommerce.Models.Seller.Seller;
import com.grada.ecommerce.Models.User;
import com.grada.ecommerce.Services.CustomerService;
import com.grada.ecommerce.Services.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
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

    @Autowired
    UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView CustomerRegistration()
    {
        ModelAndView modelAndView = new ModelAndView("customer_register");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView AddCustomer(@ModelAttribute Customer customer, @ModelAttribute User user)
    {
        userService.addUser(user);
        customerService.AddCustomer(customer);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("message", "Customer Added successfully");
        return modelAndView;
    }

    @RequestMapping(value = "/wishlist", method = RequestMethod.GET)
    public ModelAndView GetWishList()
    {
        ModelAndView modelAndView = new ModelAndView("wishlist");
        return modelAndView;
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView GetCart()
    {
        ModelAndView modelAndView = new ModelAndView("ShoppingCart");
        return modelAndView;
    }

}
