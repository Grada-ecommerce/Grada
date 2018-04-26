package com.grada.ecommerce.Data;

import com.grada.ecommerce.Models.User.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{

}
