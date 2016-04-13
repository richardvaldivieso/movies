package com.movies.repository;


import com.movies.model.CustomerEntity;
import com.sun.tools.javac.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends
        CrudRepository<CustomerEntity, Long> {
    List<CustomerEntity> findByLastName(String lastName);
}