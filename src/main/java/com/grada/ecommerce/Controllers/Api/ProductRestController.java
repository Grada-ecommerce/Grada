package com.grada.ecommerce.Controllers.Api;

import com.grada.ecommerce.Models.Product.ShortProduct;
import com.grada.ecommerce.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/product")
@RestController
public class ProductRestController
{

    @Autowired
    ProductService productService;


    @RequestMapping("/")
    public Iterable<ShortProduct> getShortProductsByTitle(@RequestParam(value="title") String title)
    {
        if(title == null)
            return null;
        //System.out.println(title);
        return productService.shortProductsByTitle(title);
    }

}
