    package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        Pair pair;
                fileName = br.readLine();
//        fileName="d:/1.txt";
        List<String> words = new ArrayList<>();
        br.close();
        BufferedReader br1 = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();
        while (br1.ready()) {
            stringBuilder.append(br1.readLine()).append(" ");
        }

        Collections.addAll(words, stringBuilder.toString().split(" "));
        List<String> wordsCopy = new ArrayList<>(words);
//        Collections.copy(wordsCopy, words);

        for (String s :
                words) {
            String reverse = new StringBuilder(s).reverse().toString();
            wordsCopy.remove(s);
            if (wordsCopy.contains(reverse)) {
                pair = new Pair();
                pair.first = s;
                pair.second = reverse;
                if (!result.contains(pair)) result.add(pair);
            }
        }

//        words.forEach(x-> System.out.println(x));
        result.forEach(x-> System.out.println(x));

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !(first.equals(pair.first) || first.equals(pair.second))  : pair.first != null) return false;
            return second != null ? second.equals(pair.second) || second.equals(pair.first): pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
