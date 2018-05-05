package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        double p = 0.0, s = 0.0; // p = [ ], s = Pattern(".")
        {
            String fname = args[0];
            try (BufferedReader br = new BufferedReader(new FileReader(fname))) {
                String all = ""; String line;
                while ((line = br.readLine()) != null) all += line;
                for (char c : all.toCharArray()) {
                    if (c == ' ') p++;
                    s++;
                }
            } catch (IOException ignored) {
            }
        }
        System.out.println(String.format("%.2f", p/s*100));
    }
}
