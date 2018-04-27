package com.grada.ecommerce.Controllers;

import com.grada.ecommerce.Models.Seller.Seller;
import com.grada.ecommerce.Models.Seller.Sells;
import com.grada.ecommerce.Services.ProductService;
import com.grada.ecommerce.Services.SellerService;
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

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView SellerRegistration()
    {
        ModelAndView modelAndView = new ModelAndView("seller_register");
        modelAndView.addObject("seller", new Seller());
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView AddSeller(@ModelAttribute Seller seller)
    {
       sellerService.addSeller(seller);
       ModelAndView modelAndView = new ModelAndView("seller_analytics");
       modelAndView.addObject("message", "Seller Added successfully");
       return modelAndView;
    }


}
