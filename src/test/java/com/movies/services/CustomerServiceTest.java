package com.movies.services;
import com.movies.CustomerRepository;
import com.movies.model.Customer;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CustomerServiceTest {

    @Test
    public void findById() {
        Customer customer = new Customer();

        customer.setFirstName("Richard");
        customer.setLastName("Chamberlain");

        CustomerRepository mockCustomerRepository = mock(CustomerRepository.class);
        when(mockCustomerRepository.findOne(anyLong())).thenReturn(customer);

//        Customer customer = mockCustomerRepository.findOne(1L);
        assertThat(customer.getFirstName()).isEqualTo("Donald");
    }

}
