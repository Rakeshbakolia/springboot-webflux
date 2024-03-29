package com.techi.springbootwebflux.service;

import com.techi.springbootwebflux.dto.Customer;
import com.techi.springbootwebflux.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public List<Customer> loadAllCustomers() {
        long start = System.currentTimeMillis();
        List<Customer> customers = customerRepo.getCustomers();
        long end = System.currentTimeMillis();
        System.out.println("total execution time - " + (end - start));
        return customers;
    }

    public Flux<Customer> loadAllCustomersStream() {
        long start = System.currentTimeMillis();
        Flux<Customer> customers = customerRepo.getCustomersStream();
        long end = System.currentTimeMillis();
        System.out.println("total execution time - " + (end - start));
        return customers;
    }


}
