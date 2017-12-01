package com.resurs.hello.service.autoconfigure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import com.resurs.hello.service.HelloService;

public class HelloServiceAutoConfiguration {

    @Bean
    public HelloService helloService(@Value("${salutation.prefix:Hello}") String salutationPrefix) {
        return new HelloService(salutationPrefix);
    }

}
