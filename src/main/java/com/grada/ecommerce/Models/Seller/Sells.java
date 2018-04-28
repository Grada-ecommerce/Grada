package com.grada.ecommerce.Models.Seller;

import com.grada.ecommerce.Models.Product.Product;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Sells
{

    @Id @GeneratedValue
    public Long id;

    public Sells(){}

    public int quantity;

    public double price;

    @Relationship(type = "SELLS", direction = Relationship.OUTGOING)
    public Product product;

    @Relationship(type = "SELLS", direction = Relationship.INCOMING)
    public Seller seller;

    public boolean AddProductBySeller(Product product, Seller seller, int quantity)
    {
        this.quantity = quantity;
        this.product = product;
        this.seller = seller;
        product.Sellers.add(this);
        seller.Products.add(this);
        return true;
    }
}
