package com.movies.services;
import com.movies.model.CustomerEntity;
import com.movies.repository.CustomerRepository;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class CustomerServiceTest {
    @Test
    public void addCustomerTest(){
        CustomerRepository customerRepository = mock(CustomerRepository.class);
        CustomerService customerService = new CustomerService(customerRepository);
        CustomerEntity customerEntity = new CustomerEntity("Phani","Jami");
        customerService.addCustomer(customerEntity);

        verify(customerRepository).save(customerEntity);

    }
}
