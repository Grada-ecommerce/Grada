package com.grada.ecommerce.Models.Customer;

import com.grada.ecommerce.Models.Product.Product;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class Cart
{
    @Id
    @GeneratedValue
    public Long id;

    public Cart() { }

    public Cart(List<Product> productList)
    {
        this.productList = productList;
    }

    public double cartPrice = 0; // getCartPrice();
    public int cartQuantity = 0; // getCartQuantitiy();

    @Relationship(type = "HAS", direction = Relationship.INCOMING)
    public Customer customer;

    @Relationship(type = "HAS", direction = Relationship.OUTGOING)
    public List<Product> productList = new ArrayList<Product>();

    public double getCartPrice()
    {
        int price = 0;
        //makes sure only minimum price is selected
        for (Product product: productList)
        {
            price += product.getPrice();
        }
        return price;
    }

    public int getCartQuantitiy()
    {
        return productList.size();
    }

    public void AddtoCart(Product product, Customer customer)
    {
        this.customer = customer;
        this.productList.add(product);

    }


}
