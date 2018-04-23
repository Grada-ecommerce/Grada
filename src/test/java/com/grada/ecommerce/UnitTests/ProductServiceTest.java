package com.grada.ecommerce.UnitTests;

import com.grada.ecommerce.Data.ProductRepository;
import com.grada.ecommerce.Services.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ProductServiceTest
{
    private ProductService productService;
    private ProductRepository productRepositoryMock;


    @Before
    public void setUp()
    {
        productRepositoryMock = Mockito.mock(ProductRepository.class);
        productService = new ProductService(productRepositoryMock);
    }

    @Test
    public void createProductSuccessfully() throws Exception
    {
        //
    }
}
