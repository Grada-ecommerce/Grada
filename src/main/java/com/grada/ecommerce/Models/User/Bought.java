package com.grada.ecommerce.Models.User;

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

    @Relationship(type = "BOUGHT", direction = Relationship.INCOMING)
    public Product product;

    @Relationship(type = "BOUGHT", direction = Relationship.INCOMING)
    public User user;

    @Relationship(type = "SOLDBY", direction = Relationship.INCOMING)
    public Seller seller;

    @Relationship(type = "RATEDANDREVIEWED", direction = Relationship.OUTGOING)
    public Review review;

    public boolean UserBought(Product product, User user, Seller seller)
    {
        this.product = product;
        this.user = user;
        this.seller = seller;
        //product.boughtBy.add(user);
        seller.soldProducts.add(this);
        user.bought.add(this);
        return true;
    }

    public boolean UserReviewed(Review rev)
    {
        this.review = rev;
        rev.bought = this;
        return true;
    }

}
