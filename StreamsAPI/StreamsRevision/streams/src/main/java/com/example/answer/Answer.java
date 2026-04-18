// Java code​​​​​​‌‌‌‌‌​​​‌​​‌​‌​‌‌​​‌‌‌​​‌ below
// Write your answer here, and then test your code.
// Your job is to implement the findLargest() method.
package com.example.answer;

import java.util.List;
import java.util.stream.Collectors;


class Answer {

    // Change these boolean values to control whether you see
    // the expected result and/or hints.
    static boolean showExpectedResult = false;
    static boolean showHints = false;

    // Return the largest number in the 'numbers' array
    static List<String> applyFilters(List<String> words) {
        // Your code goes here.
        List<String> filtered = words.stream()
        .filter(item -> item.length() > 5)
        .filter(item -> item.startsWith("G"))
        .collect(Collectors.toList());

        return filtered;
    }

    public static void main(String[] args) {
        List<String> words = List.of("Hello", "World", "Java", "Streams", "API", "Functional", "Programming", "Guides");
        List<String> result = applyFilters(words);
        System.out.println(result); // Expected output: [Guides]
    }

}
