package com.grada.ecommerce.Models.Seller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grada.ecommerce.Models.Customer.Bought;
import com.grada.ecommerce.Models.Customer.Review;
import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Seller
{

    public Seller()
    {

    }

    public Seller(String name, float rating, String emailAddress, Long aadhar, Long phoneNumber, String houseNumber, String street, String city, String state,
                  String panno, String gstno, Long bankaccountno, String bankifsccode)
    {
        //this.username = username;
        //this.password = password;
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

    public String name;

    public float Rating;

    public String email;
    public Long aadharno;
    public Long PhoneNumber;

    public String HouseNumber;
    public String Street;
    public String City;
    public String State;
    public String panno;
    public String gstno;
    public Long bankaccountno;
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
