package com.grada.ecommerce.Data;

import com.grada.ecommerce.Models.Customer.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long>
{

}
