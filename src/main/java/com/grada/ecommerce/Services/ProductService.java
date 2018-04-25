package com.grada.ecommerce.Services;

import com.grada.ecommerce.Data.ProductRepository;
import com.grada.ecommerce.Models.Product;
import com.grada.ecommerce.Models.ShortProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService
{

    ProductRepository productRepository;


    @Autowired
    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }


    @Deprecated
    public Iterable<Product> products()
    {
        //this.productRepository = productRepository;
        return productRepository.findAll();
    }

    public Iterable<ShortProduct> shortProductsByTitle(String title)
    {
        Iterable<ShortProduct> s =  productRepository.findByTitleLike(title);
        s.forEach(
                shortProduct -> System.out.println(shortProduct.getTitle())
        );
        return s;
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
        Optional<Product> product = productRepository.findById(id);

        if(!product.isPresent())
            return null;

        return product.get();
    }
}
