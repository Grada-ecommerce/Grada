/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grada.ecommerce.Controllers.Api;

import com.grada.ecommerce.Models.Product.ShortProduct;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rishabh Gupta
 */
@RequestMapping("/api/data")
@RestController
public class SalesPredictionRestController {
    
     @RequestMapping("/salesprediction")
    public String getSalesPrediction() throws UnsupportedEncodingException, IOException, ParseException
    {
     DefaultHttpClient httpClient = new DefaultHttpClient();
     HttpPost postRequest = new HttpPost("https://ussouthcentral.services.azureml.net/workspaces/59a44b51380d41ef974eea66625766de/services/af43924023ec480da8c1d9ddbb85eeed/execute?api-version=2.0&details=true");
     postRequest.addHeader("Authorization","Bearer 7YjW3kxTq5UbB3W//RC6jbtLwvs479+stPKbV+8ZjMDwdsp5yu7r+9NAjBsNagqu4rlhngnAKQXFygKk3SJQwQ==");
     postRequest.addHeader("Accept", "application/json");
     postRequest.addHeader("Content-type", "application/json");
     String json = "{\"Inputs\":{\"input1\": {\"ColumnNames\": [\"Col1\"],\"Values\":[[\"ABCD\"]]}},\"GlobalParameters\": {}}";
     StringEntity stringEntity = new StringEntity(json);
     stringEntity.setContentType("application/json");
     postRequest.setEntity(stringEntity);
     HttpResponse response = httpClient.execute(postRequest);
       // System.out.println(response.getEntity().getContent());  
       
        String data = EntityUtils.toString(response.getEntity());
        JSONParser parser = new JSONParser();
        JSONObject jSONObject = (JSONObject)parser.parse(data);
        JSONArray jSONArray = (JSONArray)((JSONObject)((JSONObject)(((JSONObject)jSONObject.get("Results")).get("output1"))).get("value")).get("Values");
        JSONArray productrecs = (JSONArray)jSONArray.get(0);
        Object[] productrecsa = productrecs.toArray();
       
        System.out.println(String.valueOf(productrecsa[0]));
         System.out.println(String.valueOf(productrecsa[1]));
        String finalscript = "{\"script\" :\"" + String.valueOf(productrecsa[0]) + "\",\"div\": \"" + String.valueOf(productrecsa[1])+ "\"}";
        System.out.println(finalscript);
        httpClient.getConnectionManager().shutdown(); 
        return finalscript;
        
    }
}
