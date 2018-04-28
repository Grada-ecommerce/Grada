package com.grada.ecommerce;

import com.grada.ecommerce.Data.BoughtRepository;
import com.grada.ecommerce.Data.ReviewRepository;
import com.grada.ecommerce.Data.CustomerRepository;
import com.grada.ecommerce.Models.Customer.Bought;
import com.grada.ecommerce.Models.Customer.Customer;
import com.grada.ecommerce.Models.Customer.Review;
import com.grada.ecommerce.Models.Product.Product;
import com.grada.ecommerce.Models.Seller.Seller;
import com.grada.ecommerce.Models.Seller.Sells;
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
	CommandLineRunner demo(SellerService sellerService, ProductService productService, CustomerRepository CustomerRepository, BoughtRepository boughtRepository
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




            ///Customer buying an product
            //start
           /* Customer Customer = new Customer("Random Customer", "customermail@mail.com", 123456789,
                    "1-123","customer street","customer city", "customer state" );
            Bought bought = new Bought();
            bought.CustomerBought(product, Customer, seller);

            CustomerRepository.save(Customer); */
            //end

            ///Customer



            //Customer reviewing an product
            //start
            //47 was an Customer id can change.
            /*Bought  bought1 =  CustomerRepository.findById(new Long(65)).get().bought.get(0);
            Review review = new Review("Random Review Text",4.3f, "Random Review Summary",
                    123456788d, "Random TIme");
            bought1.CustomerReviewed(review);
            boughtRepository.save(bought1);  */
            //end

            /*String imgUrl = "www.randomimage.com/image1.png";
            Product product1 = new Product("id1", "Random Product2", 2.0f, "Random Description", imgUrl, "Random Brand");
            Product product2 = new Product("id2", "Random Product3", 4.0f, "Random Description", imgUrl, "Random Brand");
            Product product3 = new Product("id3", "Random Product4", 3.0f, "Random Description", imgUrl, "Random Brand");

            productService.addProduct(product1);
            productService.addProduct(product2);
            productService.addProduct(product3); */


        };
	}
}
