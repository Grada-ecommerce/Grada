package com.grada.ecommerce.Data;

import com.grada.ecommerce.Models.Customer.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long>
{

}
