package com.grada.ecommerce.Data.Mock;

import com.grada.ecommerce.Models.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface SellerRepository extends CrudRepository<Seller, Long>
{
    Collection<Seller> findSellersByNameLike(@Param("name") String name);
    Seller findSellersByName(@Param("name") String name);
}
