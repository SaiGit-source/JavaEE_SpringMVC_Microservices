package com.designpatterns.creational.builder;

public class Phone {
    private String brand;
    private String model;
    private int storage;
    private int ram;
    private boolean has5G;

    public Phone(String brand, String model, int storage, int ram, boolean has5G) {
        this.brand = brand;
        this.model = model;
        this.storage = storage;
        this.ram = ram;
        this.has5G = has5G;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", storage=" + storage +
                ", ram=" + ram +
                ", has5G=" + has5G +
                '}';
    }

}
