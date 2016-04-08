package com.movies.services;
import com.movies.CustomerRepository;
import com.movies.domains.Customer;
import com.movies.model.CustomerEntity;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;


public class CustomerServiceTest {

    @Test
    public void findById() {
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setFirstName("Richard");
        customerEntity.setLastName("Chamberlain");

        CustomerRepository mockCustomerRepository = mock(CustomerRepository.class);
        when(mockCustomerRepository.findOne(5L)).thenReturn(customerEntity);

        CustomerService customerService = new CustomerService(mockCustomerRepository);

        Customer expected = customerService.findOne(5L);

        assertThat(expected.getFirstName()).isEqualTo("Richard");
    }

    @Test
    public void convert_shouldConvertEntityToDomainObject() {
        CustomerHelper customerHelper = new CustomerHelper();
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setLastName("a");
        customerEntity.setFirstName("b");
        customerEntity.setCustomerId(1L);

        CustomerRepository mockCustomerRepository = mock(CustomerRepository.class);

        CustomerService customerService = new CustomerService(mockCustomerRepository);
        Customer customer = customerHelper.convert(customerEntity);


        assertThat(customer.getFirstName()).isEqualTo("b");

    }

    @Test
    public void addACustomer() {
        CustomerRepository mockCustomerRepository = mock(CustomerRepository.class);
        CustomerService customerService = new CustomerService(mockCustomerRepository);
        CustomerHelper mockCustomerHelper = mock(CustomerHelper.class);

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setLastName("a");
        customerEntity.setFirstName("b");
        customerEntity.setCustomerId(1L);

        doReturn(customerEntity).when(mockCustomerRepository).save(customerEntity);
        doReturn(customerEntity).when(mockCustomerHelper).create(any(Customer.class));

        customerService.add(customerEntity);

        verify(mockCustomerRepository).save(customerEntity);
    }

}
