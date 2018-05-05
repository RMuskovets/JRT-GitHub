package com.javarush.task.task18.task1803;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/*
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(reader.readLine()));
        reader.close();
        int[] list = new int[stream.available()];
        for (int i = 0; i < list.length; i++) {
            list[i] = stream.read();
        }
        stream.close();
        HashMap<Integer, Integer> map = new HashMap<>();
        // Добавляю повторяющиеся байты в мапу, ключ - байт, значение - количество повторов.
        for (int aList : list) {
            if (Collections.frequency(Arrays.asList(to(list)), aList) > 1) {
                if (map.containsKey(aList)) {
                    int znach = map.get(aList);
                    znach++;
                    map.remove(aList);
                    map.put(aList, znach);
                } else
                    map.put(aList, 2);
            }
        }
        //Нахожу максимальное количество повторов.
        int a = 0;
        for (Map.Entry entry : map.entrySet()) {
            if (a==0)
                a = (Integer) entry.getValue();
            else {
                int b = (Integer) entry.getValue();
                if(a>b) {
                    a = b;
                }
            }
        }
        //Вывожу все байты с максимальным количеством повторов.
        if(a>0){
            for (Map.Entry entry : map.entrySet()) {
                if(a == (Integer) entry.getValue())
                    //    System.out.print(entry.getKey() + " " + entry.getValue() + " ");
                    System.out.print(entry.getKey() + " ");
            }
        }
    }

    private static Integer[] to(int[] v) {
        Integer[] x = new Integer[v.length];
        for (int i = 0; i < v.length; ++i) x[i]=v[i];
        return x;
    }
}