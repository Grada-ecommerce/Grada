package com.grada.ecommerce;

import com.grada.ecommerce.Data.BoughtRepository;
import com.grada.ecommerce.Data.ReviewRepository;
import com.grada.ecommerce.Data.UserRepository;
import com.grada.ecommerce.Models.Customer.User;
import com.grada.ecommerce.Services.ProductService;
import com.grada.ecommerce.Services.SellerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
public class EcommerceApplication {


	public static void main(String[] args)
	{
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(SellerService sellerService, ProductService productService, UserRepository userRepository, BoughtRepository boughtRepository
                            ,ReviewRepository reviewRepository)
	{
		return args ->
		{
		    ///adding seller and adding an product
            //start
			/*Seller seller = new Seller("RandomSeller", 4.5f, "randomseller@random.com", 123456789L,
					1234567890L, "1-123","Random Street","Random City", "Random State",
					"123456789", "123456789",123456789L, "SBI123"); */

			/*HashSet<String> imgUrl = new HashSet<>();
			imgUrl.add("www.randomimage.com/image1.png");
            imgUrl.add("www.randomimage.com/image2.png");
            imgUrl.add("www.randomimage.com/image3.png"); */

			/*String imgUrl = "www.randomimage.com/image1.png";


            Product product = new Product("Random Product", 5.0f, "Random Description", imgUrl, "Random Brand");

            Sells sells = new Sells();
            sells.AddProductBySeller(product, seller, 10);
            sellerService.addSeller(seller); */
            //end




            ///user buying an product
            //start
          /*  Customer user = new Customer("Random Customer");
            Bought bought = new Bought();
            bought.UserBought(product, user, seller);

            userRepository.save(user); */
            //end

            ///user



            //user reviewing an product
            //start
            //47 was an user id can change.
            /*Bought  bought1 =  userRepository.findById(new Long(65)).get().bought.get(0);
            Review review = new Review("Random Review Text",4.3f, "Random Review Summary",
                    123456788d, "Random TIme");
            bought1.UserReviewed(review);
            boughtRepository.save(bought1); */
            //end


		};
	}
}
