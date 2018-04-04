package com.grada.ecommerce.Models;

import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Seller
{

    public Seller()
    {

    }

    public Seller(String name, float rating, String emailAddress, Double phoneNumber)
    {
        this.name = name;
        this.Rating = rating;
        this.EmailAddress = emailAddress;
        this.PhoneNumber = phoneNumber;
    }

    @Id @GeneratedValue Long ID;


    public String name;

    public float Rating;

    public String EmailAddress;

    public Double PhoneNumber;

    @Relationship(type = "Sells", direction = Relationship.OUTGOING)
    public Set<Product> Products;

    /*public void AddProducts(Product sells)
    {
        if(this.Products == null)
        {
            this.Products = new HashSet<Product>();
        }
        this.Products.add(sells);
    } */

}
