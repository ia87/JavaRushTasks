package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    Properties prop = new Properties();
    String fileName;

    public void fillInPropertiesMap() throws Exception{
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        reader.close();

        FileInputStream in = new FileInputStream(fileName);
        load(in);
        in.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter writer = new PrintWriter(outputStream);
        for (Map.Entry<String, String> entry: properties.entrySet()){
            prop.setProperty(entry.getKey(), entry.getValue());
        }
        prop.store(outputStream, "");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        prop.clear();
        prop.load(inputStream);
        properties.clear();
        for (Map.Entry<Object, Object> pair: prop.entrySet()){
           properties.put((String) pair.getKey(), (String) pair.getValue());
        }

    }

    public static void main(String[] args) {

    }
}
