/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grada.ecommerce.Models;

import com.grada.ecommerce.Models.Product.Product;
import java.util.HashSet;

/**
 *
 * @author Rishabh Gupta
 */
public class Mainpageitems {

    public Mainpageitems(String Title, HashSet<Product> products) {
        this.Title = Title;
        this.products = products;
    }
    
    private String Title;
    private HashSet<Product> products;
    
}
