package com.movies.services;

import com.movies.CustomerRepository;
import com.movies.domains.Customer;
import com.movies.model.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    private CustomerHelper customerHelper = new CustomerHelper();

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findOne(Long customerId) {
        return customerHelper.convert(customerRepository.findOne(customerId));
    }


    public Customer add(CustomerEntity customerEntity) {

        CustomerEntity returned = customerRepository.save(customerEntity);
        return customerHelper.convert(returned);
    }


}
