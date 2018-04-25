package com.grada.ecommerce.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grada.ecommerce.Models.Relations.Sells;
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

    @Id @GeneratedValue public Long ID;


    public String name;

    public float Rating;

    public String EmailAddress;

    public Double PhoneNumber;

   // @Relationship(type = "lives", direction = Relationship.OUTGOING)
   // public Address Address;

    public String DoorNumber;
    public String Street;
    public String City;
    public String State;


    /*@JsonIgnore
    @Relationship(type = "Sells", direction = Relationship.OUTGOING)
    public Set<Product> Products; */

    @Relationship(type = "SELLS", direction = Relationship.OUTGOING)
    public Set<Sells> Products = new HashSet<>();

    public Sells SellerSells(Product product, double price)
    {
        final Sells sells = new Sells(this, product, price);
        Products.add(sells);
        product.Sellers.add(sells);
        return sells;
    }


    //used for updating the ratings with less cost
    @JsonIgnore
    public long NumRatings;

    /*public void AddProducts(Product sells)
    {
        if(this.Products == null)
        {
            this.Products = new HashSet<Product>();
        }
        this.Products.add(sells);
    } */

}
