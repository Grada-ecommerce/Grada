package com.grada.ecommerce.Models.Customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import java.util.ArrayList;
import java.util.List;


@NodeEntity
public class Customer
{

    public Customer() { }
    public Customer(String name, String email, long phoneNumber, String houseNumber, String street, String city, String state)
    {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.state = state;
    }

    @Id
    @GeneratedValue
    public Long id;

    public String name;
    public String email;
    public Long phoneNumber;

    public String houseNumber;
    public String street;
    public String city;
    public String state;

    @Relationship(type = "HAS", direction = Relationship.OUTGOING)
    public Cart cart = new Cart();

    @Relationship(type = "HAS", direction = Relationship.OUTGOING)
    public WishList wishList = new WishList();

    @JsonIgnore
    @Relationship(type = "BOUGHT", direction = Relationship.OUTGOING)
    public List<Bought> bought = new ArrayList<>();

}
