package com.grada.ecommerce.Models.Relations;

import com.grada.ecommerce.Models.Product;
import com.grada.ecommerce.Models.Seller;
import org.neo4j.ogm.annotation.*;


@RelationshipEntity(type = "SELLS")
public class Sells
{
    @Id
    @GeneratedValue
    private long id;

    @Property public double price;
    @StartNode public Seller seller;
    @EndNode public Product product;

   /* public Sells()
    {

    }*/

    public Sells(Seller seller,Product product, double price)
    {
        this.seller = seller;
        this.product = product;
        this.price = price;
    }

}

/*@RelationshipEntity(type = "Sells")
public class Sells
{

    public Sells()
    {

    }

    public Sells(Double price, int quantity , Seller seller, Product product)
    {
        this.Price = price;
        this.Quantity = quantity;
        this.Seller = seller;
        this.Product = product;
    }



    @Id @GeneratedValue long ID;

    public Double Price;
    public int Quantity;

    @StartNode
    private Seller Seller;

    @EndNode
    private Product Product;

    public void setSeller(Seller seller)
    {
        this.Seller = seller;
    }

    public void setProduct(Product product)
    {
        this.Product = product;
    }
} */
