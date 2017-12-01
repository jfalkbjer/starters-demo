package com.resurs.hello.service;

import com.resurs.hello.service.model.Salutation;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HelloService {
    private final String salutationPrefix;

    public Salutation getSalutationForUser(String user) {
        return new Salutation(String.format("%s %s!", salutationPrefix, user));
    }

}
