package com.grada.ecommerce.UnitTests;


import com.grada.ecommerce.Data.Mock.SellerRepository;
import com.grada.ecommerce.Services.SellerService;
import org.junit.Before;
import org.mockito.Mockito;

public class SellerServiceTest
{

    private SellerRepository sellerRepositoryMock;
    private SellerService sellerService;


    @Before
    public  void setUp()
    {
        sellerRepositoryMock = Mockito.mock(SellerRepository.class);
        sellerService = new SellerService(sellerRepositoryMock);
    }


}
