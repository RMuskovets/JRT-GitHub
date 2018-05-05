package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            throw new IllegalArgumentException();
        }
        Map<Character, Integer> map = new TreeMap<>();
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        byte [] b = new byte[fileInputStream.available()];
        fileInputStream.read(b);
        fileInputStream.close();
        char[] c;
        c = new String(b).toCharArray(); // Присвоили массив символов из char
        for(char ch : c){
            if(map.containsKey(ch)){
                int val = map.get(ch) + 1;
                map.put(ch, val);
            } else {
                map.put(ch, 1);
            }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()  + " " + entry.getValue());
        }
    }

    private Character[] convert(char[] c) {
        Character x[] = new Character[c.length];
        for (int i = 0; i < x.length; i++) x[i] = c[i];
        return x;
    }
}
