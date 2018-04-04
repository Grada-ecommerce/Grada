package com.grada.ecommerce;

import com.grada.ecommerce.Data.Mock.ProductRepository;
import com.grada.ecommerce.Data.Mock.SellerRepository;
import com.grada.ecommerce.Models.Mobile;
import com.grada.ecommerce.Models.Product;
import com.grada.ecommerce.Models.Seller;
import com.grada.ecommerce.Services.ProductService;
import com.grada.ecommerce.Services.SellerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.SecurityDataConfiguration.class,
//})
@EnableNeo4jRepositories
//@EntityScan("com.grada.ecommerce.Models")
public class EcommerceApplication {

	//@Autowired
	//ProductRepository productRepository;
	public static void main(String[] args)
	{
		SpringApplication.run(EcommerceApplication.class, args);
	}

	/*@Bean
	CommandLineRunner demo(SellerService sellerService, ProductService productService)
	{
		return args ->
		{

			//Seller seller = new Seller("Fake Sellers", 3.5f,"fakemail@fakeorg.com", 9999999999d);

			//Seller seller = sellerService.findSellerByName("Fake Sellers");



			//run only once during database setup
			/*Iterable<Product> products = productService.products();
			products.forEach(product ->
            {
                product.Seller = seller;
                productService.UpdateProduct(product);
            }); */
	//	};
	//} */
}
