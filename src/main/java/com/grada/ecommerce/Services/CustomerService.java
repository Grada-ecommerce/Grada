package com.grada.ecommerce.Services;

import com.grada.ecommerce.Data.CustomerRepository;
import com.grada.ecommerce.Models.Customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService
{
    CustomerRepository CustomerRepository;

    @Autowired
    public CustomerService(CustomerRepository CustomerRepository)
    {
        this.CustomerRepository = CustomerRepository;
    }

    public Iterable<Customer> Customers()
    {
        return CustomerRepository.findAll();
    }

    public Customer FindCustomerByID(long id)
    {
        Optional<Customer> tempCustomer =  CustomerRepository.findById(id);

        if(! tempCustomer.isPresent())
            return null;

        return tempCustomer.get();
    }

    public boolean AddCustomer(Customer Customer)
    {
        if(Customer == null)
            return false;

        CustomerRepository.save(Customer);
        return true;
    }


    public boolean DeleteCustomer(Customer Customer)
    {
        if(Customer == null)
            return false;

        Optional<Customer> optionalCustomer = CustomerRepository.findById(Customer.id);
        if(!optionalCustomer.isPresent())
            return false;

        CustomerRepository.delete(optionalCustomer.get());
        return true;
    }



}
