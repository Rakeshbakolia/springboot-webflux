package com.techi.springbootwebflux.repository;

import com.techi.springbootwebflux.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerRepo {

    public static void sleepExecution(int i) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getCustomers() {
        return IntStream
                .rangeClosed(1, 50)
                .peek(CustomerRepo::sleepExecution)
                .peek(i -> System.out.println("processing count - " + i))
                .mapToObj(i -> new Customer(i, "Customer" + i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomersStream() {
        return Flux.range(1,50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("processing count - " + i))
                .map(i -> new Customer(i, "Customer" + i));
    }
}
