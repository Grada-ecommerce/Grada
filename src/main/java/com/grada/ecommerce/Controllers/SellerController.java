package com.grada.ecommerce.Controllers;

import com.grada.ecommerce.Models.Seller.Seller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/seller")
@Controller
public class SellerController
{

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView SellerRegistration()
    {
        ModelAndView modelAndView = new ModelAndView("seller_register");
        modelAndView.addObject("seller", new Seller());
        return modelAndView;
    }


}
