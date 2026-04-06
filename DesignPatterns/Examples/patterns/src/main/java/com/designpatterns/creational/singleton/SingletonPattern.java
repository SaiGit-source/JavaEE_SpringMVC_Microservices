package com.designpatterns.creational.singleton;

// Singleton pattern is a creational design pattern that ensures a class has only one instance throughout the application,
// and provides a global point of access to that instance.
// Real-world analogy: A country has only one Government. No matter who asks for it, they always get the same one.
// Example: AppConfig holds database config. We don't want multiple copies of it — everyone should share the same config.

public class SingletonPattern {

    public static void main(String[] args) {
        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();
        AppConfig config3 = AppConfig.getInstance();

        System.out.println("Config 1: " + config1);
        System.out.println("Config 2: " + config2);
        System.out.println("Config 3: " + config3);

        System.out.println("config1 == config2: " + (config1 == config2)); // true
        System.out.println("config2 == config3: " + (config2 == config3)); // true

        System.out.println("DB URL: " + config1.getDbUrl());
    }

}

/* Output (hash codes will be the same — same object)
Config 1: com.designpatterns.creational.singleton.AppConfig@<hashcode>
Config 2: com.designpatterns.creational.singleton.AppConfig@<hashcode>
Config 3: com.designpatterns.creational.singleton.AppConfig@<hashcode>
config1 == config2: true
config2 == config3: true
DB URL: jdbc:mysql://localhost/mydb
 */
