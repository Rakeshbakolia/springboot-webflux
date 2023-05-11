package com.techi.springbootwebflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono(){
        Mono<?> monoString = Mono.just("techi")
                .then(Mono.error(new RuntimeException("Exception")))
                .log();
        monoString.subscribe(System.out::println, (e)-> System.out.println(e.getMessage()));
    }

    @Test
    public void testFlux(){
        Flux<String> fluxString = Flux.just("Spring", "Boot", "reactive", "mono")
                .concatWithValues("flux")
                .log();
        fluxString.subscribe(System.out::println);

    }
}
