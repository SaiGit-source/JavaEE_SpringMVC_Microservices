package com.designpatterns.creational.builder;

// Builder pattern is a design pattern that allows for the step-by-step construction of complex objects. It separates the construction of an object from its representation, allowing the same construction process to create different representations.
// when we have multiple parameters to pass into constructor, sequence is important.
// In Builder pattern, sequence of parameters is not important, and we can create an object in a step-by-step manner. It also allows for optional parameters, which can be set or left out as needed.


public class BuilderPattern {
    public static void main(String[] args) {
        Phone phone = new PhoneBuilder()
                .setBrand("Apple")
                .setModel("iPhone 13")
                .setStorage(128)
                .setRam(4)
                .setHas5G(true)
                .build();

        System.out.println(phone);
    }

}


/* Output
Phone{brand='Apple', model='iPhone 13', storage=128, ram=4, has5G=true}
 */

// gives the flexibility to create different types of phones with the same construction process and we can pass parameters in any order without worrying about the sequence. It also makes the code more readable and maintainable, especially when there are many parameters to set.

