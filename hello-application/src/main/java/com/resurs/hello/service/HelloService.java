package com.resurs.hello.service;

import com.resurs.hello.service.model.Salutation;

import lombok.RequiredArgsConstructor;

/**
 * Service is tightly coupled to the Hello Application. Your are not able to
 * reuse the HelloService in another project.
 */
@RequiredArgsConstructor
public class HelloService {
    private final String salutationPrefix;

    public Salutation getSalutationForUser(String user) {
        return new Salutation(String.format("%s %s!", salutationPrefix, user));
    }

}
