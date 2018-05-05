package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName = args[0];

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        TreeMap<String,Double > map = new TreeMap<>();


        while(reader.ready())
        {
            String file = reader.readLine();
            String []arr = file.split(" ");

            if(!map.containsKey(arr[0]))
            {
                map.put(arr[0],Double.parseDouble(arr[1]));
            }else
            {
                map.put(arr[0],map.get(arr[0])+Double.parseDouble(arr[1]));
            }
        }

        reader.close();

        for(Map.Entry<String,Double> pair : map.entrySet())
        {
            System.out.println(pair.getKey()+" "+pair.getValue());
        }

    }
}