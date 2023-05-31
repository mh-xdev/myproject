package com.example;

import io.micronaut.runtime.Micronaut;
import one.microstream.enterprise.cluster.nodelibrary.micronaut.MicronautMicrostreamClusterController;

public class Application {

    public static void main(final String[] args) {
        final var ctx = Micronaut.run(Application.class, args);
        new MicronautMicrostreamClusterController().load(ctx);
    }
}
