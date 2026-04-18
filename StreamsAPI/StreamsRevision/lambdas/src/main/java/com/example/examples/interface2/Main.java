package com.example.examples.interface2;


import java.util.Random;
import java.util.function.IntBinaryOperator;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = (int x, int y) -> {
            Random random = new Random();
            int randomNumber = random.nextInt(50);
            return x * y + randomNumber;
        };

        System.out.println(calculator.calculate(1, 2) );

        // https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html for functions

        IntBinaryOperator calculator1 = (int x, int y) -> {
            Random random = new Random();
            int randomNumber = random.nextInt(50);
            return x * y + randomNumber;
        };

        System.out.println(calculator1.applyAsInt(1, 2));

    }

}
