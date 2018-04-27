package com.grada.ecommerce.Services;

import com.grada.ecommerce.Models.Customer.Customer;
import com.grada.ecommerce.Models.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService
{

    @Autowired
    CustomerService customerService;

    @Autowired
    ProductService productService;

    public void AddProduct(Long productid, Long customerid)
    {
        Product tempProduct = productService.findProductByID(productid);

        if(tempProduct == null)
            return;

        Customer customer = customerService.FindCustomerByID(customerid);
        //customer.wishList.
        customer.cart.productList.add(tempProduct);

    }

    public void DeleteProduct(Long productid, Long customerid)
    {
        Product tempProduct = productService.findProductByID(productid);

        if(tempProduct == null)
            return;

        Customer customer = customerService.FindCustomerByID(customerid);

        if(customer.cart.productList.contains(tempProduct))
            customer.cart.productList.remove(tempProduct);
        return;
    }

}
