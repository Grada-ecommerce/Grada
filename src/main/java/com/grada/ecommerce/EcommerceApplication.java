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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;

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

            String prefix = "c:\\adb\\new_meta_";
            String suffix = ".json";

            String[] file = new String[]
                    {
                            "All_Electronics",
                            "Appliances",
                            "Baby_Products",
                            "Computers",
                            "Furniture",
                            "Gift_Cards",
                            "GPS_and_Navigation",
                            "Home_Improvement",
                            "Luxury_Beauty",
                            "Magazine_Subscriptions",
                            "Rock"
                    };



            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            for (int i = 0; i < file.length; i++)
            {
                String fileName = prefix + file[i] + suffix;
                JSONObject jobj   = (JSONObject) parser.parse(new FileReader(fileName));
                JSONArray a  = (JSONArray) jobj.get("products");

                for(Object o : a)
                {
                    JSONObject obj = (JSONObject) o;
                    Product p = new Product();
                    p.title = (String) obj.get("title");
                    p.productid = (String) obj.get("asin");
                    p.imgUrl = (String) obj.get("imUrl");

                    if(obj.containsKey("price"))
                        p.OverallPrice = (double) obj.get("price");
                    else
                        p.OverallPrice = Double.POSITIVE_INFINITY;
                    p.Description = (String) obj.get("description");
                    p.company = (String) obj.get("brand");
                    p.Categories = ((ArrayList<String>) obj.get("categories")).toString();

                    productService.addProduct(p);

                }

            }



        };
	}
}
