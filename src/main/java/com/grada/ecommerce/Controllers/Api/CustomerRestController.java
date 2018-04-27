package com.grada.ecommerce.Controllers.Api;


import com.grada.ecommerce.Models.Customer.Customer;
import com.grada.ecommerce.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerRestController
{
    @Autowired
    CustomerService CustomerService;


    @RequestMapping("/api/Customer")
    public Customer GetCustomer(@RequestParam(value = "id", defaultValue = "0") long id)
    {
        Customer Customer = CustomerService.FindCustomerByID(id);
        if(Customer == null)
            return null;

        return Customer;
    }

    @RequestMapping(value = "api/Customer/add", method = RequestMethod.POST)
    public String AddCustomer(@RequestBody Customer Customer)
    {
        if(Customer == null )
            return "Customer is null";
        CustomerService.AddCustomer(Customer);
        return "Customer added";
    }

    @RequestMapping("api/Customer/delete")
    public String DeleteCustomer(@RequestParam(value = "id", defaultValue = "0") long id)
    {

        Customer tempCustomer = CustomerService.FindCustomerByID(id);
        if(tempCustomer == null)
            return "Customer not found";

        CustomerService.DeleteCustomer(tempCustomer);
        return "Deleted Customer";

    }

    //breaks
    @RequestMapping(value = "api/Customer/edit", method = RequestMethod.POST)
    public Customer EditCustomer(@RequestBody Customer Customer)
    {
        if(Customer.id < 0)
            return null;

        Customer CustomerOld = CustomerService.FindCustomerByID(Customer.id);

        if(Customer == null)
            return null;

        CustomerService.AddCustomer(Customer);
        return Customer;
    }







}
