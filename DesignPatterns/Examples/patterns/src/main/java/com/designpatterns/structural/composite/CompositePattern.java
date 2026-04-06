package com.designpatterns.structural.composite;

// Composite pattern is a structural design pattern that allows you to compose objects into tree structures to represent part-whole hierarchies. It lets clients treat individual objects and compositions of objects uniformly.
// Composite pattern is used when we create a software in a tree structure where one object can have multiple objects. It is used when we want to represent part-whole hierarchies of objects. It allows clients to work with individual objects and compositions of objects uniformly.
// that means whatever operations we perform on the leaf objects, we should be able to perform on the composite objects as well.
// i should be able to find the price of a mouse, same with peripherals and same with the computer as well. So, we should be able to perform the same operations on the leaf objects and the composite objects as well.

public class CompositePattern {
    public static void main(String[] args) {
        Component mouse = new Leaf("Mouse", 25);
        Component keyboard = new Leaf("Keyboard", 45);
        Component monitor = new Leaf("Monitor", 150);

        Composite peripherals = new Composite("Peripherals");
        peripherals.addComponent(mouse);
        peripherals.addComponent(keyboard);
        peripherals.addComponent(monitor);


        Composite cabinet = new Composite("Cabinet");
        Component cpu = new Leaf("CPU", 500);
        Component HDD = new Leaf("HDD", 100);
        Component MotherBoard = new Leaf("Motherboard", 200);
        cabinet.addComponent(cpu);
        cabinet.addComponent(HDD);
        cabinet.addComponent(MotherBoard);

        Composite computer = new Composite("Computer");
        computer.addComponent(peripherals);
        computer.addComponent(cabinet);

        computer.showPrice();
    }

}

/*
Peripherals:
Mouse: $25.0
Keyboard: $45.0
Monitor: $150.0
Cabinet:
CPU: $500.0
HDD: $100.0
Motherboard: $200.0
 */