package com.grada.ecommerce.Controllers;

import com.grada.ecommerce.Models.Seller.Seller;
import com.grada.ecommerce.Models.Seller.Sells;
import com.grada.ecommerce.Models.User;
import com.grada.ecommerce.Services.ProductService;
import com.grada.ecommerce.Services.SellerService;
import com.grada.ecommerce.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/seller")
@Controller
public class SellerController
{
    @Autowired
    SellerService sellerService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView SellerRegistration()
    {
        ModelAndView modelAndView = new ModelAndView("seller_register");
        modelAndView.addObject("seller", new Seller());
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView AddSeller(@ModelAttribute Seller seller, @ModelAttribute User user)
    {
       sellerService.addSeller(seller);
       userService.addUser(user);
       ModelAndView modelAndView = new ModelAndView("seller_analytics");
       modelAndView.addObject("message", "Seller Added successfully");
       return modelAndView;
    }

    @RequestMapping(value = "/analytics", method = RequestMethod.GET)
    public ModelAndView GetSellerAnalytics()
    {
        ModelAndView modelAndView = new ModelAndView("seller_analytics");
        return modelAndView;
    }


}
