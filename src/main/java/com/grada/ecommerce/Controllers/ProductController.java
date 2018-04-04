package com.grada.ecommerce.Controllers;

import com.grada.ecommerce.Models.Product;
import com.grada.ecommerce.Models.Seller;
import com.grada.ecommerce.Services.ProductService;
import com.grada.ecommerce.Services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String Index(Model model)
    {
        Iterable<Product> products  = productService.products();
        model.addAttribute("products", products);
        return "product_grid";
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String ShowProduct(@PathVariable Long id, Model model)
    {
        Product product = productService.findProductByID(id);
        if(product == null)
            return "redirect:/";
        model.addAttribute("product", product);
        return "productid";
    }


    @RequestMapping(value = "/add")
    public String AddProduct(Model model)
    {
        model.addAttribute("product", new Product());
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String AddProduct(@ModelAttribute Product product)
    {
        productService.addProduct(product);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String DeleteProduct(Model model)
    {
        model.addAttribute("product", new Product());
        return "delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String DeleteProduct(@ModelAttribute Product product)
    {
        productService.deleteProduct(product);
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String LoginPage(Model model)
    {
        return "login";
    }

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
    }

    @RequestMapping(value = "/policy", method = RequestMethod.GET)
    public String PolicyPage()
    {
        return "policies";
    }
}
