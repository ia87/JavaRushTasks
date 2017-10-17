package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String tokens[] = getTokens("level22.lesson13.task01", ".");
        for (String s :
                tokens) {
            System.out.println(s);
        }


    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        String tokens[] = new String[stringTokenizer.countTokens()];
        int tokensCount = stringTokenizer.countTokens();
        for (int i = 0; i < tokensCount; i++) {
            tokens[i] = stringTokenizer.nextToken();
        }
        return tokens;
    }
}
