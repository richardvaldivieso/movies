package com.movies.services;

import com.movies.domains.Customer;
import com.movies.model.CustomerEntity;

public class CustomerHelper {
    public Customer convert(CustomerEntity customerEntity) {
        Customer customer = new Customer();
        customer.setCustomerId(customerEntity.getCustomerId());
        customer.setFirstName(customerEntity.getFirstName());
        customer.setLastName(customerEntity.getLastName());

        return customer;
    }


    public CustomerEntity create(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName(customer.getFirstName());
        customerEntity.setLastName(customer.getLastName());

        return customerEntity;
    }
}
