package com.designpatterns.structural.adapter;

public class PenAdapter implements Pen {

    private final PilotPen pilotPen;

    public PenAdapter(PilotPen pilotPen) {
        this.pilotPen = pilotPen;
    }

    @Override
    public void write(String str) {
        pilotPen.mark(str);
    }

}
