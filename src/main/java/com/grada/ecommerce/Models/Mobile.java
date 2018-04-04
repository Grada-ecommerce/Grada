package com.grada.ecommerce.Models;

import org.neo4j.ogm.annotation.*;

@NodeEntity
public class Mobile extends Product
{

    public  Mobile()
    {
        super();
    }

    public Mobile(String title, Double price, int quantity, float rating, String description, String ram, String url, String company)
    {
        super(title, price, quantity, rating, description, url, company);
    }

    public String Ram;

}


