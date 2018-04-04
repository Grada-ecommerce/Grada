package com.grada.ecommerce.Services;

import com.grada.ecommerce.Data.Mock.ProductRepository;
import com.grada.ecommerce.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService
{

    ProductRepository productRepository;


    @Autowired
    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public Iterable<Product> products()
    {
        this.productRepository = productRepository;
        return productRepository.findAll();
    }

    public void UpdateProduct(Product product)
    {
        productRepository.save(product);
        return;
    }

    public boolean addProduct(Product product)
    {
        if(product == null)
            return false;
        productRepository.save(product);
        return true;
    }

    public boolean deleteProduct(Product product)
    {
        if(product == null)
            return false;

        productRepository.delete(product);
        return true;
    }

    public Product findProductByID(Long id)
    {
        if(id == null)
            return null;
        Product product = productRepository.findProductById(id);

        if(product == null)
            return null;

        return product;
    }
}
