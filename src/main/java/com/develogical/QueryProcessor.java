package com.develogical;

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
        return "";
    }
}
