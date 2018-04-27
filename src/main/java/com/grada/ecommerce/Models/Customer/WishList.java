package com.grada.ecommerce.Models.Customer;

import com.grada.ecommerce.Models.Product.Product;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

public class WishList
{

    public WishList() { }

    public WishList(List<Product> productList)
    {
        this.productList = productList;
    }

    @Relationship(type = "HAS", direction = Relationship.INCOMING)
    public List<Product> productList = new ArrayList<Product>();

}
