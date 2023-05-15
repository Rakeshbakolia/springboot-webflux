package com.techi.springbootwebflux.handler;

import com.techi.springbootwebflux.dto.Customer;
import com.techi.springbootwebflux.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {

    @Autowired
    private CustomerRepo customerRepo;

    public Mono<ServerResponse> loadCustomers(ServerRequest request){
        Flux<Customer> customerList = customerRepo.getCustomerList();
        return ServerResponse.ok().body(customerList, Customer.class);
    }
}
