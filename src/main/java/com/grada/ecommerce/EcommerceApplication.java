package com.grada.ecommerce;

import com.grada.ecommerce.Data.SellsRepository;
import com.grada.ecommerce.Models.Product;
import com.grada.ecommerce.Models.Relations.Sells;
import com.grada.ecommerce.Models.Seller;
import com.grada.ecommerce.Services.ProductService;
import com.grada.ecommerce.Services.SellerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

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

/*	@Bean
	CommandLineRunner demo(SellerService sellerService, ProductService productService, SellsRepository sellsRepository)
	{
		return args ->
		{

            Seller seller = new Seller("New Seller", 4.3f, "fakemail@fakest.fake",999999999d);
			sellerService.addSeller(seller);
            //Product product = new Product("Fake Product", 400d,10, 3.2f,"Fake Description","fakeurl.com","fake company");


            //productService.addProduct(product);

           /* Sells sells = new Sells();
            sells.price = 100;
            sells.product = product;
            sells.seller = seller;

            seller.Seller = sells;
            sellerService.addSeller(seller);

            sellsRepository.save(sells); */

           /*Sells s = seller.SellerSells(product, 100);
            System.out.println(s.price);
           sellerService.addSeller(seller); */







			//Seller seller = new Seller("Fake Sellers", 3.5f,"fakemail@fakeorg.com", 9999999999d);

			//Seller seller = sellerService.findSellerByName("Fake Sellers");



			//run only once during database setup
			/*Iterable<Product> products = productService.products();
			products.forEach(product ->
            {
                product.Seller = seller;
                productService.UpdateProduct(product);
            }); */
		};
	//}
//}
