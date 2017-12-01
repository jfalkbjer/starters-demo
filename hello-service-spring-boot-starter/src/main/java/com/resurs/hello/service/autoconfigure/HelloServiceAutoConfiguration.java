package com.resurs.hello.service.autoconfigure;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.resurs.hello.service.HelloService;

@EnableConfigurationProperties({ HelloServiceProperties.class })
public class HelloServiceAutoConfiguration {

    @Bean
    public HelloService helloService(HelloServiceProperties helloServiceProperties) {
        return new HelloService(helloServiceProperties.getPrefix());
    }

}
