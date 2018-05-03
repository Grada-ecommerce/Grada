package com.grada.ecommerce.Models.Customer;

import com.grada.ecommerce.Models.Product.Product;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class WishList
{
    @Id
    @GeneratedValue
    public Long id;

    public WishList() { }

    @Relationship(type = "HAS", direction = Relationship.INCOMING)
    public Customer customer;

    public WishList(List<Product> productList)
    {
        this.productList = productList;
    }

    @Relationship(type = "HAS", direction = Relationship.OUTGOING)
    List<Product> productList = new ArrayList<>();

    public void AddProduct(Customer customer, Product product)
    {
        this.customer = customer;
        this.productList.add(product);
    }

}
