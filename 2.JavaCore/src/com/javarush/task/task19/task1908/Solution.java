package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String delim = " ";
        String regexNum = "\\d+";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String a = in.readLine(), b = in.readLine();
        in.close();
        BufferedReader br = new BufferedReader(new FileReader(a));
        BufferedWriter bw = new BufferedWriter(new FileWriter(b));
        String line;
        StringBuilder all = new StringBuilder();
        while ((line = br.readLine()) != null) {
            for (String word: line.split(delim)) {
                if (word.matches(regexNum)) {
                    int x = Integer.parseInt(word);
                    all.append(x).append(' ');
                }
            }
        }
        br.close();
        bw.write(all.delete(all.length() - 1, all.length()).toString());
        bw.close();
    }
}
