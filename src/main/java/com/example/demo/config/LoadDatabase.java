package com.example.demo.config;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger LOG = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            LOG.info("Preloading " + repository.save(new Employee("Bilbo Sacquet", "burglar")));
            LOG.info("Preloading " + repository.save(new Employee("Frodo Sacquet", "burglar")));
            LOG.info("Preloading " + repository.save(new Employee("Sam Gamegie", "grubby-faced")));
            LOG.info("Preloading " + repository.save(new Employee("Peregrin Touque", "alcoholic")));
            LOG.info("Preloading " + repository.save(new Employee("Meriadoc Brandebouc", "alcoholic")));
            LOG.info("Preloading " + repository.save(new Employee("Boromir Arandur", "prince")));
            LOG.info("Preloading " + repository.save(new Employee("Faramir Arandur ", "prince")));
            LOG.info("Preloading " + repository.save(new Employee("Gandalf le Gris", "mage")));
            LOG.info("Preloading " + repository.save(new Employee("Aragorn Telcontar ", "king")));
            LOG.info("Preloading " + repository.save(new Employee("Eomer Eadig", "king")));
        };
    }
}
