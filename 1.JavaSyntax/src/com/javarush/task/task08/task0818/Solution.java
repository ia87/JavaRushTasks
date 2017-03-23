package com.javarush.task.task08.task0818;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("xasdxcsc", 100);
        map.put("xsdcvasdxcsc", 1200);
        map.put("xasdxsdvcsc", 1030);
        map.put("xasdxcsvhc", 1004);
        map.put("xasdxcssadc", 1040);
        map.put("xasdxcssdc", 1007);
        map.put("xasdxcsdcc", 200);
        map.put("xasdxcsvsvc", 300);
        map.put("xasdxcsvsc", 400);
        map.put("xasdxcsdcsc", 100);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> m : map.entrySet()){
            if (m.getValue() < 400) list.add(m.getKey());
        }
        for (String s :
                list) {
            if (map.containsKey(s)) map.remove(s);
        }

    }

    public static void main(String[] args) {

        removeItemFromMap(createMap());

    }
}