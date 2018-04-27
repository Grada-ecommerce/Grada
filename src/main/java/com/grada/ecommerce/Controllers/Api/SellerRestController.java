package com.grada.ecommerce.Controllers.Api;


import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.grada.ecommerce.Models.Seller.Seller;
import com.grada.ecommerce.Services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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

    static String testURL = "https://ussouthcentral.services.azureml.net/workspaces/59a44b51380d41ef974eea66625766de/services/af43924023ec480da8c1d9ddbb85eeed/execute?api-version=2.0&details=true";
    static String testAPI = "Bearer 7YjW3kxTq5UbB3W//RC6jbtLwvs479+stPKbV+8ZjMDwdsp5yu7r+9NAjBsNagqu4rlhngnAKQXFygKk3SJQwQ==";
    @RequestMapping(value = "/api/seller/analytics/{id}", method = RequestMethod.GET)
    public String GetAnalytics(@PathVariable("id") String id)
    {
        try
        {
            HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
            String requestBody = "{ 'Inputs' : { 'input1': { 'ColumnNames': [ 'Col1'], 'Values': [ [ '" + id.trim() + "' ]] } },'GlobalParameters': {} }";
            GenericUrl url = new GenericUrl(testURL.replaceAll(" ", "%20"));
            HttpRequest request = requestFactory.buildPostRequest(url, ByteArrayContent.fromString("application/json", requestBody));
            request.getHeaders().setContentType("application/json");
            request.getHeaders().setAuthorization(testAPI);
            HttpResponse httpResponse =  request.execute();
            return httpResponse.parseAsString();
        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }
        return "Error";
    }

}
