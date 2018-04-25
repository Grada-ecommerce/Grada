package com.grada.ecommerce.Models;

import java.util.HashMap;

public class Review
{

    public Review()
    {

    }

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

}
