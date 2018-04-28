package com.grada.ecommerce.Services;

import com.grada.ecommerce.Data.ProductRepository;
import com.grada.ecommerce.Models.Product.Product;
import com.grada.ecommerce.Models.Product.ShortProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Iterable<Product> products(Pageable pageable)
    {
        return productRepository.findAll(pageable);
    }



    public Iterable<ShortProduct> products(PageRequest pageRequest)
    {
        //this.productRepository = productRepository;
        //return productRepository.findByTitleLike("*", pageRequest);
        return null;
    }

    public Iterable<ShortProduct> shortProductsByTitle(String title)
    {
        Iterable<ShortProduct> s =  productRepository.findByTitleLike(title);
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
    
     public ShortProduct findProductByProductId(String pid)
    {
        return productRepository.findProductByProductid(pid);
    }
}
