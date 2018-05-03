package com.grada.ecommerce.Data;

import com.grada.ecommerce.Models.Customer.WishList;
import org.springframework.data.repository.CrudRepository;

public interface WishlistRepository extends CrudRepository<WishList, Long> {
}
