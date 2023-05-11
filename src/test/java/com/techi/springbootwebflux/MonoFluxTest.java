package com.techi.springbootwebflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono(){
        Mono<String> monoString = Mono.just("techi");
        monoString.subscribe(System.out::println);
    }
}
