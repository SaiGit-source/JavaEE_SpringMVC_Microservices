package com.designpatterns.creational.builder;

public class PhoneBuilder {

    private String brand;
    private String model;
    private int storage;
    private int ram;
    private boolean has5G;

    public PhoneBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public PhoneBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public PhoneBuilder setStorage(int storage) {
        this.storage = storage;
        return this;
    }

    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public PhoneBuilder setHas5G(boolean has5G) {
        this.has5G = has5G;
        return this;
    }

    public Phone build() {
        return new Phone(brand, model, storage, ram, has5G);
    }

}
