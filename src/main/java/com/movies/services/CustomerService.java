package com.movies.services;

import com.movies.model.CustomerEntity;
import com.movies.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(CustomerEntity customerEntity){
        customerRepository.save(customerEntity);

    }
}
