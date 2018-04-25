package com.grada.ecommerce.Services;

import com.grada.ecommerce.Data.SellerRepository;
import com.grada.ecommerce.Models.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerService
{

    SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository)
    {
        this.sellerRepository = sellerRepository;
    }



    public Iterable<Seller> sellers()
    {
        return sellerRepository.findAll();
    }

    public Seller findSellerByName(String name)
    {
        if(name == null)
            return null;
        Seller seller = sellerRepository.findSellersByName(name);
        if(seller == null)
            return null;
        return seller;
    }

    public Seller findSellerById(long id)
    {
        if(Long.valueOf(id) < 0)
            return null;
        Optional<Seller> seller = sellerRepository.findById(id);

        if(seller.isPresent())
            return seller.get();
        else
            return null;
    }



    public boolean addSeller(Seller seller)
    {
        if(seller == null)
            return false;
        sellerRepository.save(seller);
        return true;
    }


    public boolean deleteSeller(Seller seller)
    {
        if(seller == null)
            return false;
        sellerRepository.delete(seller);
        return true;
    }
}
