package com.techi.springbootwebflux.router;

import com.techi.springbootwebflux.handler.CustomerHandler;
import com.techi.springbootwebflux.handler.CustomerStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    private CustomerHandler customerHandler;

    @Autowired
    private CustomerStreamHandler customerStreamHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
                .GET("/router/customers",(request)->customerHandler.loadCustomers(request))
                .GET("/router/customers/stream", (request -> customerStreamHandler.getCustomers(request)))
                .build();
    }

}
