package com.javarush.task.task20.task2026;

import java.lang.reflect.Array;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        byte[][] b = a.clone();
//        System.arraycopy(a,0,b,0);

        int count=0,
            xStart=-1,
            xEnd=-1,
            yStart=-1,
            yEnd=-1;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                if (b[i][j]==1 && xStart==-1) {
                    xStart=j;
//                    xEnd=j;
                    yStart=i;
                }
                if (b[i][j]==0 && xStart!=-1) {
                    xEnd=j-1;
                }
                if (b[i][j]==1 && j==b[0].length-1) {
                    xEnd=j;
                }
                if (xEnd >= xStart && xEnd!=-1 && xStart!=-1) {
                    for (int k = i; k < b.length; k++) {
                        if (b[k][xEnd] == 1 && (k!=b.length-1)) yEnd = k;
                        else if ((b[k][xEnd] == 1 && k==b.length-1) || (b[k][xEnd]!=1)) {
                            if (k==b.length-1) yEnd = k;
                            count++;
                            for (int l = yStart; l <= yEnd; l++) {
                                for (int m = xStart; m <= xEnd; m++) {
                                    b[l][m]=0;
                                }
                            }
//                            System.out.println(xStart);
//                            System.out.println(xEnd);
//                            System.out.println(yStart);
//                            System.out.println(yEnd);
                            xStart=-1;
                            xEnd=-1;
                            yStart=-1;
                            yEnd=-1;
                            break;
                        }
                    }
                }
            }
            
        }
        return count;
    }
}
