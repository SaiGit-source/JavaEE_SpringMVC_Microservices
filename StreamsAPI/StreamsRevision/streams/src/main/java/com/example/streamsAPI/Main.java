package com.example.streamsAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // Code to demonstrate Streams API will go here
        Integer[] scores = {90, 80, 70, 60, 50};
        Stream<Integer> scoresStream = Arrays.stream(scores); // create a stream variable

        List<String> shoppingList = new ArrayList();
        shoppingList.add("coffee");
        shoppingList.add("bread");
        shoppingList.add("pineapple");
        shoppingList.add("milk");
        shoppingList.add("pasta");
        Stream<String> shoppingListStream = shoppingList.stream(); // create a stream variable
        // shoppingListStream.sorted().forEach(item -> System.out.println(item));
        /*         
        shoppingListStream
        .sorted()
        .map(item -> item.toUpperCase())
        .forEach(item -> System.out.println(item));
        */

        shoppingListStream
        .sorted()
        .filter(item -> item.startsWith("p")) // filter is a functional interface
        .map(item -> item.toUpperCase()) // map is a functional interface that takes a function as input and the original data is not modified, it creates a new stream with the modified data
        .forEach(item -> System.out.println(item));

        List<String> sortedShoppingList = shoppingList.stream()
        .sorted()
        .map(item -> item.toUpperCase())
        .filter(item -> item.startsWith("P"))
        .collect(Collectors.toList());

        System.out.println(sortedShoppingList); // note Streams dont store things, they are just a pipeline of operations that can be performed on the data, they are not a data structure that can store data, they are just a way to process data in a functional way

        Stream<String> lettersStream = Stream.of("a", "b", "c", "d", "e"); // create a stream variable


    }

}
