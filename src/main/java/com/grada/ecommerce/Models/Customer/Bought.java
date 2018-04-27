package com.grada.ecommerce.Models.Customer;

import com.grada.ecommerce.Models.Product.Product;
import com.grada.ecommerce.Models.Seller.Seller;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Bought
{

    public  Bought() { }

    @Id
    @GeneratedValue
    public Long id;

    @Relationship(type = "BOUGHT", direction = Relationship.OUTGOING)
    public Product product;

    @Relationship(type = "BOUGHT", direction = Relationship.INCOMING)
    public Customer Customer;

    @Relationship(type = "SOLDBY", direction = Relationship.INCOMING)
    public Seller seller;

    @Relationship(type = "RATEDANDREVIEWED", direction = Relationship.OUTGOING)
    public Review review;

    public boolean CustomerBought(Product product, Customer Customer, Seller seller)
    {
        this.product = product;
        this.Customer = Customer;
        this.seller = seller;
        //product.boughtBy.add(Customer);
        seller.soldProducts.add(this);
        Customer.bought.add(this);
        return true;
    }

    public boolean CustomerReviewed(Review rev)
    {
        this.review = rev;
        rev.bought = this;
        return true;
    }

}
