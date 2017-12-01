package com.resurs.hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.resurs.hello.service.HelloService;
import com.resurs.hello.service.autoconfigure.EnableHelloService;
import com.resurs.hello.service.model.Salutation;

import lombok.extern.slf4j.Slf4j;

@EnableHelloService
@Slf4j
@SpringBootApplication
public class HelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

    @Component
    public class BootstrapCommandLineRunner implements CommandLineRunner {
        private final HelloService helloService;

        public BootstrapCommandLineRunner(HelloService helloService) {
            this.helloService = helloService;
        }

        @Override
        public void run(String... args) throws Exception {
            Salutation salutation = helloService.getSalutationForUser("Julia");
            log.info(salutation.getMessage());
        }
    }

    @Bean
    public HelloService helloService() {
        return new HelloService("My bean say hello to");
    }

}
