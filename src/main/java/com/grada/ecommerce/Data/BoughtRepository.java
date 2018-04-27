package com.grada.ecommerce.Data;

import com.grada.ecommerce.Models.Customer.Bought;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BoughtRepository extends PagingAndSortingRepository<Bought, Long>
{


}
