package com.grada.ecommerce.Models.Customer;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Review
{
    @Id
    @GeneratedValue
    public Long id;

    public Review() { }

    public Review(String reviewText, float overall, String summary, double unixReviewTime, String reviewTime)
    {
        this.reviewText = reviewText;
        this.overall = overall;
        this.summary = summary;
        this.unixReviewTime = unixReviewTime;
        this.reviewTime = reviewTime;
    }


    public String reviewText;
    public float overall;
    public String summary;
    public double unixReviewTime;
    public String reviewTime;

    @Relationship(type = "RATEDANDREVIEWED", direction = Relationship.INCOMING)
    public Bought bought;

}
