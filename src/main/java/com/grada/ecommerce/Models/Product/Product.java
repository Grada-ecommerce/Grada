package com.grada.ecommerce.Models.Product;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grada.ecommerce.Models.Customer.Review;
import com.grada.ecommerce.Models.Seller.Sells;
import com.grada.ecommerce.Models.Customer.Customer;
import org.neo4j.ogm.annotation.*;


import java.util.*;


@NodeEntity
public class Product
{
    public  Product()
    {
    }

    public Product(String productid, String title, float rating, String description, String url, String company)
    {   this.productid = productid;
        this.title  = title;
        this.rating = rating;
        this.Description = description;
        this.imgUrl = url;
        this.company = company;
    }

    @Id
    @GeneratedValue
    private Long id;
    public String productid;
    public String title;

    public float rating;
    public String Description;

    public String company;
    public String imgUrl;
    public String Categories;
    public double OverallPrice;

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }


    @Override
    public String toString()
    {
        return this.title;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() { return title; }
    public float getRating() { return rating; }
    public String getImgUrl() {return imgUrl; }

    public double getPrice()
    {
        double min = Double.POSITIVE_INFINITY;
        //Collection<Double> values = sellerWithPrice.values();
        for(Sells sells : this.Sellers)
        {
            if(min > sells.price)
                min = sells.price;
        }
        return min;
    }

    public int getQuantity()
    {
        int quantity = 0;
        for (Sells sells: Sellers)
        {
            quantity += sells.quantity;
        }
        return quantity;
    }

    public int getPopularity()
    {
        return reviews.size();
    }


    //not used because of amazon dataset
    //public Map<String, String> properties;

    //for showing seller and price in product page
    //public Map<ShortSeller, Double> sellerWithPrice= new HashMap<>();

    @JsonIgnore
    @Relationship(type = "SELLS", direction = Relationship.INCOMING)
    public Set<Sells> Sellers= new HashSet<Sells>();

    @Relationship(type = "HAS", direction = Relationship.OUTGOING)
    public Set<Review> reviews = new HashSet<Review>();

    //@Relationship(type = "BOUGHT", direction = Relationship.OUTGOING)
    //public Set<Customer> boughtBy = new HashSet<Customer>();


}
