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

    public Seller(String username, String password, String name, float rating, String emailAddress, int aadhar, String phoneNumber, String houseNumber, String street, String city, String state,
                  String panno, String gstno, int bankaccountno, String bankifsccode)
    {
        this.username = username;
        this.password = password;
        this.name = name;
        this.Rating = rating;
        this.email = emailAddress;
        this.aadharno = aadhar;
        this.PhoneNumber = phoneNumber;
        this.HouseNumber = houseNumber;
        this.Street = street;
        this.City = city;
        this.State = state;
        this.panno = panno;
        this.gstno = gstno;
        this.bankaccountno = bankaccountno;
        this.bankifsccode = bankifsccode;
    }

    @Id @GeneratedValue public Long ID;
    public String username;
    public String password;

    public String name;

    public float Rating;

    public String email;
    public int aadharno;
    public String PhoneNumber;

    public String HouseNumber;
    public String Street;
    public String City;
    public String State;
    public String panno;
    public String gstno;
    public int bankaccountno;
    public String bankifsccode;
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
