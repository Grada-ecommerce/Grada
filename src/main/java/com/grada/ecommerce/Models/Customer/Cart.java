package com.grada.ecommerce.Models.Customer;

import com.grada.ecommerce.Models.Product.Product;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

public class Cart
{

    public Cart() { }

    public Cart(List<Product> productList)
    {
        this.productList = productList;
    }

    public double cartPrice = getCartPrice();
    public int cartQuantity = getCartQuantitiy();

    @Relationship(type = "HAS", direction = Relationship.INCOMING)
    public List<Product> productList;

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


}
