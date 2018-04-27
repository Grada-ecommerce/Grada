package com.grada.ecommerce.Controllers.Api;


import com.grada.ecommerce.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/user/cart")
@RestController
public class CartRestController
{
    final CartService cartService;

    @Autowired
    public CartRestController(CartService cartService)
    {
        this.cartService = cartService;
    }

    @RequestMapping("/add")
    public void AddProduct(Long productid, Long customerid)
    {
        cartService.AddProduct(productid, customerid);
    }

    @RequestMapping("/delete")
    public void DeleteProduct(Long productid, Long customerid)
    {
        cartService.DeleteProduct(productid, customerid);
    }

}
