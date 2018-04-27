package com.grada.ecommerce.Models.Customer;

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
    public Customer(String name)
    {
        this.name = name;
    }

    @Id
    @GeneratedValue
    public Long id;

    public String name;


    @Relationship(type = "HAS", direction = Relationship.OUTGOING)
    public Cart cart;

    @Relationship(type = "HAS", direction = Relationship.OUTGOING)
    public WishList wishList;

    @Relationship(type = "BOUGHT", direction = Relationship.OUTGOING)
    public List<Bought> bought = new ArrayList<>();

}
