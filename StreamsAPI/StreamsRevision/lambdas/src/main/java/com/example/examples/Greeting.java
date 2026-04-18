package com.example.examples;

/*
Java Lambdas and Streams

When Java 8 was released, two new biggest features were Lambdas and Streams
*/


// Functional interface is an interface that has only one abstract method. It can have multiple default and static methods. It is used to represent a single abstract method (SAM) type, which can be implemented using a lambda expression or method reference.


@FunctionalInterface
public interface Greeting {

    void sayHello(String name);

}
