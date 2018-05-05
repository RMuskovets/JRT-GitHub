package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    private static final String PUNCT = "\\p{Punct}";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(br.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(br.readLine()));
        String all="", line;
        while ((line = reader.readLine()) != null) all+=line;
        writer.write(all.replaceAll(PUNCT, "").replaceAll("\n", ""));
        br.close();
        reader.close();
        writer.close();
    }
}
