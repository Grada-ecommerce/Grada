package com.grada.ecommerce.UnitTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grada.ecommerce.Controllers.ProductController;
import com.grada.ecommerce.Services.ProductService;
import com.grada.ecommerce.Services.SellerService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class ProductControllerTest
{
    @Autowired
    private MockMvc mockMvc;


    @MockBean
    ProductService productService;

    @MockBean
    SellerService sellerService;


    @Before
    public void setUp()
    {
        mockMvc = MockMvcBuilders.standaloneSetup(new ProductController(productService, sellerService)).build();
    }

    @Test
    public void testProductIndex() throws Exception
    {
        /*this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andDo(print()); */
    }

    @Test
    public void testProductAdd() throws Exception
    {
       /* this.mockMvc.perform(get("/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("add"))
                .andDo(print()); */
    }
}
