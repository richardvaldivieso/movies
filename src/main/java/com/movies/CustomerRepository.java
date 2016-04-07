package com.movies;


import com.movies.model.Customer;
import com.sun.tools.javac.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends
        CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
}