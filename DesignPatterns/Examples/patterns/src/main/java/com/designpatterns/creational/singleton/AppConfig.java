package com.designpatterns.creational.singleton;

// AppConfig is a Singleton class.
// Rule 1: Private static field to hold the single instance.
// Rule 2: Private constructor so no one can do "new AppConfig()" from outside.
// Rule 3: Public static getInstance() method that creates the instance only once and returns it every time.

public class AppConfig {

    private static AppConfig instance; // holds the one and only instance

    private AppConfig() {
        // private constructor — prevents instantiation from outside
        System.out.println("AppConfig instance created.");
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig(); // created only the first time
        }
        return instance; // always returns the same object
    }

    public String getDbUrl() {
        return "jdbc:mysql://localhost/mydb";
    }

}
