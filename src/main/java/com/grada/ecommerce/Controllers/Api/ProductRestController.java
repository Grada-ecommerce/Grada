package com.grada.ecommerce.Controllers.Api;

import com.grada.ecommerce.Data.ProductRepository;
import com.grada.ecommerce.Models.Customer.Review;
import com.grada.ecommerce.Models.Product.Product;
import com.grada.ecommerce.Models.Product.ShortProduct;
import com.grada.ecommerce.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/product")
@RestController
public class ProductRestController
{

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;


    private PageRequest gotoPage(int page)
    {
        PageRequest request = new PageRequest(page,2);
        return request;
    }


    @RequestMapping("/page/")
    public Iterable<Product> getProduct(@RequestParam("page") int page, @RequestParam("prop") String prop, @RequestParam("ord") String order)
    {
        //System.out.println(page + prop + order);

        Sort.Direction direction = null;
        if(order.equals("asc"))
            direction = Sort.Direction.ASC;
        else if(order.equals("desc"))
            direction = Sort.Direction.DESC;

        if(prop.equals("rating"))
            prop = "rating";
        else if(prop.equals("price"))
        {
            prop = "price";
        }
        else if(prop.equals("popularity"))
        {
            prop = "popularity";
        }


        //Iterable<ShortProduct> products =  productService.products(new PageRequest(page, 2, direction, prop));
        Pageable pageable = PageRequest.of(page, 2, direction, prop);
        Page<Product> products = productRepository.findAll(pageable);
        return products;
    }

    @RequestMapping("/review/{id}")
    public Iterable<Review> getReviews(@PathVariable("id") Long id)
    {
        Product product = productService.findProductByID(id);
        return product.reviews;
    }

    @RequestMapping("/review/add/{id}")
    public void AddReview(@PathVariable("id") long id, @RequestBody Review review)
    {
        if(review == null)
            return;

        Product product = productService.findProductByID(id);
        product.reviews.add(review);
    }

}
