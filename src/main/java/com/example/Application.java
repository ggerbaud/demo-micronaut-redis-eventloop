package com.example;

import io.micronaut.runtime.Micronaut;
import reactor.blockhound.BlockHound;

public class Application {

    public static void main(String[] args) {
        BlockHound.install(builder ->
            builder
                .allowBlockingCallsInside("com.fasterxml.jackson.databind.ObjectMapper", "findModules")
                .allowBlockingCallsInside("io.micronaut.core.io.service.SoftServiceLoader$ServiceLoaderIterator", "hasNext")
        );
        Micronaut.run(Application.class, args);
    }
}
