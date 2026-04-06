package com.designpatterns.structural.adapter;

// Adapter pattern is a structural design pattern that allows objects with incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces, enabling them to communicate and collaborate effectively. The adapter pattern is often used when integrating legacy systems or third-party libraries into new applications.
// Lets say we need to write an assignment with a Pen. We already have abstraction for Pen but we need to create Implementation for Pen but we already have implementation for Pilot Pen. 
// To use PilotPen implementation in the place of Pen, we need to create an adapter class that implements the Pen interface and internally uses an instance of PilotPen to perform the required operations. This way, we can use the PilotPen implementation without modifying the existing code that relies on the Pen interface.
// Pen Adapter takes in PilotPen and returns a Pen object. This way we can use PilotPen implementation in the place of Pen without modifying the existing code that relies on the Pen interface.
// PenAdapter class implements the Pen interface and internally uses an instance of PilotPen to perform the required operations. This allows us to use the PilotPen (another class) implementation without modifying the existing code that relies on the Pen interface.

public class AdapterPattern {

    public static void main(String[] args) {
        Pen penAdapter = new PenAdapter(new PilotPen());
        AssignmentWork assignmentWork = new AssignmentWork();
        assignmentWork.setPen(penAdapter);
        assignmentWork.doAssignment("Writing an assignment.");
    }

}

/* Output
Writing an assignment.
 */