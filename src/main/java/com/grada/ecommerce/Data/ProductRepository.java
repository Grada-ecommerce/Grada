package com.grada.ecommerce.Data;

import com.grada.ecommerce.Models.Product.Product;
import com.grada.ecommerce.Models.Product.ShortProduct;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long>
{
    //Collection<Product> findByTitleLike(@Param("title") String title);
    //Collection<ShortProduct> findByTitleLike(String title, PageRequest pageRequest);
    Collection<ShortProduct> findByTitleLike(String title);
    ShortProduct findProductByProductid(@Param("productid") String productid);
    //Collection<ShortProduct> findAllByTitleLike(@Param("title") String title);

    //Product findProductById(@Param("id") Long id);
}
