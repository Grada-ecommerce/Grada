package com.grada.ecommerce.Services;


import com.grada.ecommerce.Data.CustomerRepository;
import com.grada.ecommerce.Models.Customer.Customer;
import com.grada.ecommerce.Models.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.CustomRepositoryImplementationDetector;
import org.springframework.stereotype.Service;

@Service
public class WishlistService
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






    }



}
