package com.grada.ecommerce.Models.Seller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grada.ecommerce.Models.Product.Product;
import com.grada.ecommerce.Models.User.Bought;
import com.grada.ecommerce.Models.User.Review;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NodeEntity
public class Seller
{

    public Seller()
    {

    }

    public Seller(String name, float rating, String emailAddress, Double phoneNumber, String doorNumber, String street, String city, String state)
    {
        this.name = name;
        this.Rating = rating;
        this.EmailAddress = emailAddress;
        this.PhoneNumber = phoneNumber;
        this.DoorNumber = doorNumber;
        this.Street = street;
        this.City = city;
        this.State = state;
    }

    @Id @GeneratedValue public Long ID;


    public String name;

    public float Rating;

    public String EmailAddress;

    public Double PhoneNumber;

    public String DoorNumber;
    public String Street;
    public String City;
    public String State;

    @Relationship(type = "SELLS", direction = Relationship.OUTGOING)
    public Set<Sells> Products = new HashSet<Sells>();

    @Relationship(type = "SOLDBY", direction = Relationship.OUTGOING)
    public Set<Bought> soldProducts = new HashSet<Bought>();

    //used for updating the ratings with less cost
    @JsonIgnore
    public long NumRatings;

    @Relationship(type = Relationship.INCOMING)
    public Set<Review> reviews = new HashSet<Review>();


}
