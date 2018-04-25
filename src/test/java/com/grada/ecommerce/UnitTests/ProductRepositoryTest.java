package com.grada.ecommerce.UnitTests;


import com.grada.ecommerce.Data.ProductRepository;
import com.grada.ecommerce.Models.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest
{
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ProductRepository productRepository;


    @Before
    public void setUp()
    {
        testEntityManager.persist(new Product("TestProduct", 200d, 10, 4.5f, "Short Description","short url","short company"));
    }

    @Test
    public void testfindByTitle()
    {
        //Object[] products = productRepository.findByTitleLike("TestProduct").toArray();

       // Optional<Product> productsActual = (Optional<Product>) products[0];

        //assertEquals("TestProduct", productsActual.get().title);
    }
}
