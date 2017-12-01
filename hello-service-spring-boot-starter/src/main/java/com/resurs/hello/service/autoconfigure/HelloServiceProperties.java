package com.resurs.hello.service.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "salutation")
public class HelloServiceProperties {

    private static final String DEFAULT_PREFIX = "Hello";

    /**
     * Set the prefix to use for the salutation.
     */
    private String prefix = DEFAULT_PREFIX;

}
