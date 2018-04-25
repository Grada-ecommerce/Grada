/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grada.ecommerce.Controllers.Seller;
import com.grada.ecommerce.Models.SellerRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Rishabh Gupta
 */
@Controller
public class SellerRegistrationController {
 
   
   @RequestMapping(value = "/Seller/Registration",method = RequestMethod.GET)
   public ModelAndView showRegistration()    
   {
       return new ModelAndView("sellerregistration","registration",new SellerRegistration());
       
   }
   
   
    
}
