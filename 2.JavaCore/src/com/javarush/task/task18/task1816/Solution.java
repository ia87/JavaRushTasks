package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream=new FileInputStream(args[0]);
        int summ=0;
        while (fileInputStream.available()>0){
            char s=(char) fileInputStream.read();
            if(((s>='a')&&(s<='z'))||((s>='A')&&(s<='Z'))){summ++;}
        }
        fileInputStream.close();
        System.out.print(summ);

    }

}
