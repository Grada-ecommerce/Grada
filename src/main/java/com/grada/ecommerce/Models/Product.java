package com.grada.ecommerce.Models;


import com.grada.ecommerce.Models.Seller;
import org.neo4j.ogm.annotation.*;


import java.util.HashSet;
import java.util.Set;


@NodeEntity
public class Product
{
    public  Product()
    {
    }

    public Product(String title, Double price, int quantity, float rating, String description, String url, String company)
    {
        this.title  = title;
        this.Rating = rating;
        this.Description = description;
        this.Price = price;
        this.Quantity = quantity;
        this.URL = url;
        this.Company = company;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "title")
    public String title;

    public float Rating;
    public String Description;

    public Double Price;
    public int Quantity;

    public String Company;
    public String URL;


    @Override
    public String toString()
    {
        return this.title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    @Relationship(type = "Sells", direction = Relationship.INCOMING)
    public Seller Seller;

}
