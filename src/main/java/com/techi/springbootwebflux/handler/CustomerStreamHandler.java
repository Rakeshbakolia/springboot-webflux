package com.techi.springbootwebflux.handler;

import com.techi.springbootwebflux.dto.Customer;
import com.techi.springbootwebflux.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {

    @Autowired
    private CustomerRepo customerRepo;

    public Mono<ServerResponse> getCustomers(ServerRequest serverRequest){
        Flux<Customer> customersStream = customerRepo.getCustomersStream();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customersStream, Customer.class);
    }
}
