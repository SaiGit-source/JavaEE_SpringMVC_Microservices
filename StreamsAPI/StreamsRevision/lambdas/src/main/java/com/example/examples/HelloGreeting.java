package com.example.examples;

public class HelloGreeting implements Greeting {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");

    }
}
