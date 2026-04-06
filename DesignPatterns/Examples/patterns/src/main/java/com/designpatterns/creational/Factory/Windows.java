package com.designpatterns.creational.Factory;

public class Windows implements OS {
    @Override
    public void spec() {
        System.out.println("Windows: Most secure OS");
    }

}
