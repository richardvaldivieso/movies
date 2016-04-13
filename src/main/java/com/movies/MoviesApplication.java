package com.movies;

import com.movies.model.CustomerEntity;
import com.movies.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class MoviesApplication {
    private static final Logger log = LoggerFactory.getLogger(MoviesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new CustomerEntity("Jack", "Bauer"));
			repository.save(new CustomerEntity("Chloe", "O'Brian"));
			repository.save(new CustomerEntity("Kim", "Bauer"));
			repository.save(new CustomerEntity("David", "Palmer"));
			repository.save(new CustomerEntity("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (CustomerEntity customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			CustomerEntity customer = repository.findOne(1L);
			log.info("CustomerEntity found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
//			log.info("CustomerEntity found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			for (CustomerEntity bauer : repository.findByLastName("Bauer")) {
//				log.info(bauer.toString());
//			}
//			log.info("");
		};
	}
}
