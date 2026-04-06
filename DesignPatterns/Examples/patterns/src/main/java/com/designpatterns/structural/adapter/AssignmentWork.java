package com.designpatterns.structural.adapter;

public class AssignmentWork {
    private Pen pen;

    public void doAssignment(String str) {
        pen.write(str);
    }

    public Pen getPen() {
        return pen;
    }

    public void setPen(Pen pen) {
        this.pen = pen;
    }


}
