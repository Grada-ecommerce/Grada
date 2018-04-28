/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grada.ecommerce.Controllers.Api;

import com.grada.ecommerce.Models.Product.ShortProduct;
import com.grada.ecommerce.Services.ProductService;
import java.io.BufferedReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import java.io.UnsupportedEncodingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import org.apache.http.util.EntityUtils;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author Rishabh Gupta
 */
@RequestMapping("/api/data")
@RestController
public class RecommendationRestController {
    @Autowired
    ProductService productService;

    @RequestMapping("/itembased")
    public Iterable<ShortProduct> getItemBasedRecommendation(@RequestParam(value = "productid", defaultValue = "B000234I3U") String productid) throws UnsupportedEncodingException, IOException, ParseException
    {
     DefaultHttpClient httpClient = new DefaultHttpClient();
     HttpPost postRequest = new HttpPost("https://ussouthcentral.services.azureml.net/workspaces/8f6b883f8e2845da90a66417ada2867f/services/a80ead583a104bd4b1ac80335d8b4bb9/execute?api-version=2.0&details=true");
     postRequest.addHeader("Authorization","Bearer z4Sfmp87N4MR51czxdMYTxO/SNCuViKMctObU4fLMFXU+VLuQQlzo+6YSzUGI9zwYA/F84sNV8bkKL8rS0wRKg==");
     postRequest.addHeader("Accept", "application/json");
     postRequest.addHeader("Content-type", "application/json");
     String json = "{\"Inputs\":{\"input1\": {\"ColumnNames\": [\"product_id\"],\"Values\":[[\"" + productid+ "\"]]}},\"GlobalParameters\": {}}";
     StringEntity stringEntity = new StringEntity(json);
     stringEntity.setContentType("application/json");
     postRequest.setEntity(stringEntity);
     HttpResponse response = httpClient.execute(postRequest);
       // System.out.println(response.getEntity().getContent());  
       httpClient.getConnectionManager().shutdown();
        String data = EntityUtils.toString(response.getEntity());
        JSONParser parser = new JSONParser();
        JSONObject jSONObject = (JSONObject)parser.parse(data);
        JSONArray jSONArray = (JSONArray)((JSONObject)((JSONObject)(((JSONObject)jSONObject.get("Results")).get("output1"))).get("value")).get("Values");
        JSONArray productrecs = (JSONArray)jSONArray.get(0);
        Object[] productrecsa = productrecs.toArray();
        HashSet<ShortProduct> finalitemsrecommended = new HashSet<>();
        for(int i = 1;i<11;i++)
        {System.out.println(String.valueOf(productrecsa[i]));
         finalitemsrecommended.add(productService.findProductByProductId(String.valueOf(productrecsa[i])));
        }
    
        return finalitemsrecommended;
        
    }

     @RequestMapping("/userbased")
    public Iterable<ShortProduct> getUserBasedRecommendation(@RequestParam(value = "customerid", defaultValue = "ADJAGYEMW7KWN") String customerid) throws UnsupportedEncodingException, IOException, ParseException
    {
     DefaultHttpClient httpClient = new DefaultHttpClient();
     HttpPost postRequest = new HttpPost("https://ussouthcentral.services.azureml.net/workspaces/8f6b883f8e2845da90a66417ada2867f/services/66fe652dd63c46899f4794a2a6b6ee3c/execute?api-version=2.0&details=true");
     postRequest.addHeader("Authorization","Bearer 6fQf4Y1WE+De013zjS6bAyU157r2n7kk5jiQ2KH4OfAOUpQ1Rt23v9uMb/uGxXluP2WeFSgMt6KLJLoogqvBYw==");
     postRequest.addHeader("Accept", "application/json");
     postRequest.addHeader("Content-type", "application/json");
     String json = "{\"Inputs\":{\"input1\": {\"ColumnNames\": [\"user_id\"],\"Values\":[[\""+ customerid + "\"]]}},\"GlobalParameters\": {}}";
     StringEntity stringEntity = new StringEntity(json);
     stringEntity.setContentType("application/json");
     postRequest.setEntity(stringEntity);
     HttpResponse response = httpClient.execute(postRequest);
       // System.out.println(response.getEntity().getContent());  
       httpClient.getConnectionManager().shutdown();
        String data = EntityUtils.toString(response.getEntity());
        JSONParser parser = new JSONParser();
        JSONObject jSONObject = (JSONObject)parser.parse(data);
        JSONArray jSONArray = (JSONArray)((JSONObject)((JSONObject)(((JSONObject)jSONObject.get("Results")).get("output1"))).get("value")).get("Values");
        JSONArray productrecs = (JSONArray)jSONArray.get(0);
        Object[] productrecsa = productrecs.toArray();
        HashSet<ShortProduct> finalitemsrecommended = new HashSet<>();
        for(int i =1;i<11;i++)
        {System.out.println(String.valueOf(productrecsa[i]));
         finalitemsrecommended.add(productService.findProductByProductId(String.valueOf(productrecsa[i])));
        }
    
        return finalitemsrecommended;
        
    }
    
    @RequestMapping("/nonrated")
    public Iterable<ShortProduct> getNonRatedRecommendation(@RequestParam(value = "customerid", defaultValue = "ADJAGYEMW7KWN") String customerid) throws UnsupportedEncodingException, IOException, ParseException
    {
     DefaultHttpClient httpClient = new DefaultHttpClient();
     HttpPost postRequest = new HttpPost("https://ussouthcentral.services.azureml.net/workspaces/8f6b883f8e2845da90a66417ada2867f/services/27b1a6b4c0d243afa34158605b2891d2/execute?api-version=2.0&details=true");
     postRequest.addHeader("Authorization","Bearer DH7oBPsCqSiKzF87y4YzgkpTiezmqOW+o2KCy29ZY/hZRyQNhFRq/VVz0LmVX7t0NdxGQDcQJEfJGZBmJ3rPHQ==");
     postRequest.addHeader("Accept", "application/json");
     postRequest.addHeader("Content-type", "application/json");
     String json = "{\"Inputs\":{\"input1\": {\"ColumnNames\": [\"user_id\",\"product_id\"],\"Values\":[[\"" + customerid + "\",\"value\"]]}},\"GlobalParameters\": {}}";
     StringEntity stringEntity = new StringEntity(json);
     stringEntity.setContentType("application/json");
     postRequest.setEntity(stringEntity);
     HttpResponse response = httpClient.execute(postRequest);
       // System.out.println(response.getEntity().getContent());  
       httpClient.getConnectionManager().shutdown();
        String data = EntityUtils.toString(response.getEntity());
        JSONParser parser = new JSONParser();
        JSONObject jSONObject = (JSONObject)parser.parse(data);
        JSONArray jSONArray = (JSONArray)((JSONObject)((JSONObject)(((JSONObject)jSONObject.get("Results")).get("output1"))).get("value")).get("Values");
        JSONArray productrecs = (JSONArray)jSONArray.get(0);
        Object[] productrecsa = productrecs.toArray();
        HashSet<ShortProduct> finalitemsrecommended = new HashSet<>();
        for(int i = 1;i<11;i++)
        {System.out.println(String.valueOf(productrecsa[i]));
         finalitemsrecommended.add(productService.findProductByProductId(String.valueOf(productrecsa[i])));
        }
    
        return finalitemsrecommended;
        
    }
    
    
    
    
    
}
