package com.grada.ecommerce.Data;

import com.grada.ecommerce.Models.User.Bought;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BoughtRepository extends PagingAndSortingRepository<Bought, Long>
{


}
