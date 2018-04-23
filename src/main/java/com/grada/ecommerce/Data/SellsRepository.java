package com.grada.ecommerce.Data;

import com.grada.ecommerce.Models.Relations.Sells;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellsRepository extends CrudRepository<Sells,Long>
{

}
