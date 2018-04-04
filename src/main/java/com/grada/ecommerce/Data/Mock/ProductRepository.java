package com.grada.ecommerce.Data.Mock;

import com.grada.ecommerce.Models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ProductRepository extends CrudRepository<Product, Long>
{
    Collection<Product> findByTitleLike(@Param("title") String title);
    Product findProductById(@Param("id") Long id);
}
