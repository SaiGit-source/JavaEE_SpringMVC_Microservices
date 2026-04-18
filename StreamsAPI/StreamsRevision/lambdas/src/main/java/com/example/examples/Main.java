package com.example.examples;

public class Main {

    public static void main(String[] args) {
        // Using an anonymous class
        Greeting greeting1 = new HelloGreeting();
        greeting1.sayHello("Alice");

        // We override the sayHello method of the Greeting interface using an anonymous class. 
        // This is another way to implement the Greeting interface without creating a separate class.
        Greeting anotherFunctionalGreeting = new Greeting() {
            @Override
            public void sayHello(String name) {
                System.out.println("Hi, " + name + "!");
            }
        };  
        anotherFunctionalGreeting.sayHello("Charlie");  


        // Using a lambda expression
        // This is using a lambda expression to implement the Greeting interface. 
        // The lambda expression takes a String parameter and prints a greeting message.
        Greeting lambdaGreeting = name -> System.out.println("Hello, " + name + "!");
        lambdaGreeting.sayHello("Bob");

    }

}
