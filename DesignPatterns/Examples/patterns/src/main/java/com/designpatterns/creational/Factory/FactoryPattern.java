package com.designpatterns.creational.Factory;

// Factory Pattern is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. It promotes loose coupling by eliminating the need to bind application-specific classes into the code. The Factory Pattern is also known as the Factory Method Pattern.
// Consider different phones use different operating systems, we can create a `PhoneFactory` class that will generate objects of different phone types based on the input provided.
// the idea is i can add new OS to the program without modifying the existing code, which promotes the Open/Closed Principle.

public class FactoryPattern {

    public static void main(String[] args) {
        OperatingSystemFactory osf = new OperatingSystemFactory();
        OS obj = osf.getInstance("Open");
        obj.spec();
        obj = osf.getInstance("Closed");
        obj.spec();
        obj = osf.getInstance("Secure");
        obj.spec();
    }
}
