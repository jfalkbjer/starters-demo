package com.resurs.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.resurs.hello.service.HelloService;
import com.resurs.hello.service.model.Salutation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class HelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

    /**
     * You need to configure the bean yourself. Let someone else create the bean
     * and just let me configure the salutation prefix.
     */
    @Bean
    public HelloService helloService(@Value("${salutation.prefix:Hello}") String salutationPrefix) {
        return new HelloService(salutationPrefix);
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

}
