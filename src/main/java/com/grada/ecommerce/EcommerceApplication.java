package com.grada.ecommerce;

import com.grada.ecommerce.Data.*;
import com.grada.ecommerce.Models.Customer.Bought;
import com.grada.ecommerce.Models.Customer.Cart;
import com.grada.ecommerce.Models.Customer.Customer;
import com.grada.ecommerce.Models.Customer.Review;
import com.grada.ecommerce.Models.Product.Product;
import com.grada.ecommerce.Models.Seller.Seller;
import com.grada.ecommerce.Models.Seller.Sells;
import com.grada.ecommerce.Models.User;
import com.grada.ecommerce.Services.ProductService;
import com.grada.ecommerce.Services.SellerService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

@SpringBootApplication
@EnableNeo4jRepositories
public class EcommerceApplication {


	public static void main(String[] args)
	{
		SpringApplication.run(EcommerceApplication.class, args);
	}
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }
	@Bean
	CommandLineRunner demo(UserRepository userRepository , SellerService sellerService, ProductService productService, CustomerRepository CustomerRepository, BoughtRepository boughtRepository
                            , ReviewRepository reviewRepository, CartRepository cartRepository, WishlistRepository wishlistRepository)
	{
		return args ->
		{

		    Optional<Customer> optcustomer = CustomerRepository.findById(new Long(51));
		    Customer customer = optcustomer.get();

		    customer.cart.AddtoCart(productService.findProductByID(new Long(65)), customer);

            //customer.wishList.AddProduct(customer, productService.findProductByID(new Long(46)));

            cartRepository.save(customer.cart);
            //wishlistRepository.save(customer.wishList);
            CustomerRepository.save(customer);



		    /*
            User user1 = new User("sellerusername",encoder().encode("sellerpassword"),"Seller");
            User user2 = new User("customerusername",encoder().encode("sellerpassword"),"Buyer");
            User user3 = new User("adminusername",encoder().encode("adminpassword"),"Admin");
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
            */
		    ///adding seller and adding an product
            //start
			/*Seller seller = new Seller("RandomSeller", 4.5f, "randomseller@random.com", 123456789L,
					1234567890L, "1-123","Random Street","Random City", "Random State",
					"123456789", "123456789",123456789L, "SBI123"); */

			/*HashSet<String> imgUrl = new HashSet<>();
			imgUrl.add("www.randomimage.com/image1.png");
            imgUrl.add("www.randomimage.com/image2.png");
            imgUrl.add("www.randomimage.com/image3.png"); */
         /*   Seller seller = sellerService.findSellerById(41192);
            Optional<Customer> customer = CustomerRepository.findById(new Long(41193));
			for(int i = 0 ; i<10 ; i++)
            {String imgUrl = "www.randomimage.com/image1.png";
            long pid = 1234567 + i;
            Product product = new Product(String.valueOf(pid),"Random Product", 5.0f, "Random Description", imgUrl, "Random Brand");

            Sells sells = new Sells();
            sells.AddProductBySeller(product, seller, i);

            Bought bought = new Bought();
            bought.CustomerBought(product, customer.get(), seller);


            CustomerRepository.save(customer.get());
            Review review = new Review("Random Review Text",4.3f, "Random Review Summary",
                    123456788d, "Random TIme");
            bought.CustomerReviewed(review);
            boughtRepository.save(bought);


                //sellerService.addSeller(seller);
            }
            //end*/




            ///Customer buying an product
            //start
            /*Customer Customer = new Customer("Random Customer", "customermail@mail.com", 123456789,
                    "1-123","customer street","customer city", "customer state" );
            //Customer.cart.productList.add(product);
            Bought bought = new Bought();
            bought.CustomerBought(product, Customer, seller);

            CustomerRepository.save(Customer); */
            //end

            ///Customer



            //Customer reviewing an product
            //start
            //47 was an Customer id can change.
            //Bought  bought1 =  CustomerRepository.findById(new Long(65)).get().bought.get(0);
           /* Review review = new Review("Random Review Text",4.3f, "Random Review Summary",
                    123456788d, "Random TIme");
            bought.CustomerReviewed(review);
            boughtRepository.save(bought); */
            //end

            /*String imgUrl = "www.randomimage.com/image1.png";
            Product product1 = new Product("id1", "Random Product2", 2.0f, "Random Description", imgUrl, "Random Brand");
            Product product2 = new Product("id2", "Random Product3", 4.0f, "Random Description", imgUrl, "Random Brand");
            Product product3 = new Product("id3", "Random Product4", 3.0f, "Random Description", imgUrl, "Random Brand");

            productService.addProduct(product1);
            productService.addProduct(product2);
            productService.addProduct(product3); */

           /* String prefix = "c:\\adb\\new_meta_";
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

            } */





        };
	}
}
