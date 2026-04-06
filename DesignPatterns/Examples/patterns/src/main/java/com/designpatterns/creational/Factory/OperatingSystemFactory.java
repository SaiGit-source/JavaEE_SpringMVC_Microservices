package com.designpatterns.creational.Factory;

public class OperatingSystemFactory {
    public OS getInstance(String str) {
        if (str.equals("Open")) {
            return new Android();
        } else if (str.equals("Closed")) {
            return new iOS();
        } else if (str.equals("Secure")) {
            return new Windows();
        }
        return null;
    }

}
