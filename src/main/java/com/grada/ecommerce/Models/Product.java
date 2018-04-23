package com.grada.ecommerce.Models;


import com.grada.ecommerce.Models.Relations.Sells;
import com.grada.ecommerce.Models.Seller;
import org.neo4j.ogm.annotation.*;


import java.util.HashSet;
import java.util.Map;
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
        this.rating = rating;
        this.Description = description;
        this.price = price;
        this.Quantity = quantity;
        this.URL = url;
        this.Company = company;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "title")
    public String title;

    public float rating;
    public String Description;

    public Double price;
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
    public String getTitle() { return title; }
    public float getRating() { return rating; }
    public double getPrice() { return price; }

    public Map<String, String> properties;

   // @Relationship(type = "SELLS", direction = Relationship.INCOMING)
   // public Sells Seller;

    @Relationship(type = "SELLS", direction = Relationship.INCOMING)
    public Set<Sells> Sellers = new HashSet<>();


}
