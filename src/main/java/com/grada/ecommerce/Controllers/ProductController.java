package com.grada.ecommerce.Controllers;

import com.grada.ecommerce.Models.Product.Product;
import com.grada.ecommerce.Services.ProductService;
import com.grada.ecommerce.Services.SellerService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProductController
{

    final ProductService productService;
    final SellerService sellerService;

    @Autowired
    public ProductController(ProductService productService, SellerService sellerService)
    {
        this.productService = productService;
        this.sellerService = sellerService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView Index(Model model)
    {
       ModelAndView modelAndView = new ModelAndView("index");
       return modelAndView;
    }

    //do not delete
    /*@RequestMapping(value = "/user-register")
    public String UserRegister(Model model)
    {
        //Iterable<Product> products  = productService.products();
        //model.addAttribute("products", products);
        return "user_register";
    } */

    /*
    //do not delete
    @RequestMapping(value = "/seller-register")
    public String SellerRegister(Model model)
    {
        //Iterable<Product> products  = productService.products();
        //model.addAttribute("products", products);
        return "seller_register";
    } */

    /*
    //do not delete
    @RequestMapping(value = "/seller-analytics")
    public String SellerAna(Model model)
    {
        //Iterable<Product> products  = productService.products();
        //model.addAttribute("products", products);
        return "seller_analytics";
    } */


    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ModelAndView ShowProduct(@PathVariable("id") Product product, Model model)
    {
        ModelAndView modelAndView = new ModelAndView("product_desc");
        modelAndView.addObject("product", product);
        return modelAndView;
    }


    @RequestMapping(value = "/product/add")
    public ModelAndView AddProduct(Model model)
    {
        ModelAndView modelAndView = new ModelAndView("addProduct");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public ModelAndView AddProduct(@ModelAttribute Product product)
    {
        productService.addProduct(product);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("message", "Added " + product.title);
        return modelAndView;
    }

    @RequestMapping(value = "/product/delete", method = RequestMethod.GET)
    public String DeleteProduct(Model model)
    {
        model.addAttribute("product", new Product());
        return "delete";
    }

    @RequestMapping(value = "/product/delete", method = RequestMethod.POST)
    public String DeleteProduct(@ModelAttribute Product product)
    {
        productService.deleteProduct(product);
        return "redirect:/";
    }


    /*
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String LoginPage(Model model)
    {
        return "login";
    } */

    /*
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String Authenticate(Model model, String username, String password)
    {
        if (username.equalsIgnoreCase("seller@fake.com") && password.equals("fakeseller"))
        {
            Iterable<Product> products  = productService.products();
            model.addAttribute("products", products);
            return "loggedin";
        }

        else
            return "redirect:/login";
    } */

    @RequestMapping(value = "/product/policy", method = RequestMethod.GET)
    public String PolicyPage()
    {
        return "policies";
    }
}
