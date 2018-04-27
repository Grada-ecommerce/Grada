package com.grada.ecommerce.Controllers.Api;


import com.grada.ecommerce.Models.Seller.Seller;
import com.grada.ecommerce.Services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SellerRestController
{

    @Autowired
    SellerService sellerService;

    @RequestMapping("/api/seller/{id}")
    public Seller GetSeller(@PathVariable("id") long id)
    {
        Seller seller = sellerService.findSellerById(id);
        //System.out.println(id);
        if(seller == null)
            return sellerService.findSellerById(id);

        return seller;
    }

    //not working
    @RequestMapping(value = "/api/seller/add/", method = RequestMethod.POST)
    public String AddSeller(@RequestBody Seller seller)
    {
        System.out.println(seller.name);
        if(seller == null )
            return "Seller is null";
        sellerService.addSeller(seller);
        return "Seller added";
    }

    @RequestMapping("/api/seller/delete")
    public String DeleteSeller(@RequestParam(value = "id", defaultValue = "0") long id)
    {
        if(id == 0)
            return "Invalid Seller";
        Seller seller = sellerService.findSellerById(id);

        if(seller == null)
            return "Seller not found";


        sellerService.deleteSeller(seller);
        return "Deleted Seller";

    }

    //breaks
    @RequestMapping(value = "/api/seller/edit", method = RequestMethod.POST)
    public Seller EditSeller(@RequestBody Seller seller)
    {
        if(seller.ID < 0)
            return null;

        Seller sellerOld = sellerService.findSellerById(seller.ID);

        if(sellerOld == null)
            return null;

        //seller.Products = sellerOld.Products;

        DeleteSeller(sellerOld.ID);
        sellerService.addSeller(seller);
        return seller;
    }

}
