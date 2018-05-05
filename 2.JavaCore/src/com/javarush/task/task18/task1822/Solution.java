package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String FileOne = reader.readLine();
        BufferedReader FileReader = new BufferedReader(new FileReader(FileOne));
        reader.close();
        String line;
        // StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        while ((line = FileReader.readLine()) != null) {
            list.add(line);
        }
        FileReader.close();
        char[] third = new char[3];
        list.get(0).getChars(0, 3, third, 0);
        boolean starts = !(new String(third).matches("\\w"));
        if (starts) list.set(0, list.get(0).substring(3));
        for (String x : list) {
            if (x.startsWith(args[0]+" ") ){
                System.out.println(x);
            }
        }
    }
}
