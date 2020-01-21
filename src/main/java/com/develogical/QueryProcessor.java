package com.develogical;

import java.util.ArrayList;
import java.util.Arrays;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist;";
        }
        if (query.toLowerCase().contains("largest")) {
            String numbers = query.toLowerCase().split(": ")[2];
            int[] array = Arrays.asList(numbers.split(", ")).stream().mapToInt(Integer::parseInt).toArray();
            int max = array[0];
            for(int i = 1; i<array.length; i++) {
                if(max < array[i]) {
                    max = array[i];
                }
            }

            return String.valueOf(max);
        }

        if (query.toLowerCase().contains("are primes:")) {
            String numbers = query.toLowerCase().split(": ")[2];
            int[] array = Arrays.asList(numbers.split(", ")).stream().mapToInt(Integer::parseInt).toArray();
            int max = array[0];
            String primes = "";
            for(int i = 0; i<array.length; i++) {
                int prime = 0;
                for(int j = 2; j < array[i]/2; j++) {
                    if(array[i] % j == 0) {
                        prime = 1;
                    }
                }
                if(prime == 0) {
                    primes = primes + String.valueOf(array[i]) + ", ";
                }
            }

            primes = primes.substring(0, primes.length() - 2);
            return primes;
        }

        if (query.toLowerCase().contains("who played James Bond in the film Dr No")) {
            return "Sean Connery";
        }
        if (query.toLowerCase().contains("banana")) {
            return "yellow";
        }

        if (query.toLowerCase().contains("plus")) {
            String numbers = query.toLowerCase().split(": ")[1];
            String first = numbers.split("is ")[1];
            int[] array = Arrays.asList(first.split(" plus ")).stream().mapToInt(Integer::parseInt).toArray();
            int sum = 0;
            for(int i = 0; i<array.length; i++) {
                sum += array[i];
            }
            return String.valueOf(sum);
        }

        return "";
    }


}
