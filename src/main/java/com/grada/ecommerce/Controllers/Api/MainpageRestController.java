/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grada.ecommerce.Controllers.Api;

import com.grada.ecommerce.Models.Mainpageitems;
import java.util.HashSet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rishabh Gupta
 */
@RequestMapping("api/mainpage")
@RestController
public class MainpageRestController {
    public Iterable<Mainpageitems> getMainPageItems()
    {  Iterable<Mainpageitems> iterable = new HashSet<Mainpageitems>();
        return iterable;
    }
    
    
}
