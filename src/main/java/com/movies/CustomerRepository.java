package com.movies;


import com.movies.model.CustomerEntity;
import com.sun.tools.javac.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends
        JpaRepository<CustomerEntity, Long> {
    List<CustomerEntity> findByLastName(String lastName);
}