package com.grada.ecommerce.Models.Product;

import java.util.Set;

public interface ShortProduct
{
    public float getRating();
    public String getTitle();
    public Double getPrice();
    public Set<String> getImgUrl();

}
