package com.grada.ecommerce.Data;

import com.grada.ecommerce.Models.Review;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReviewRepository extends PagingAndSortingRepository<Review, Long>
{

}
