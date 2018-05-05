package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fn1 = r.readLine(); //считываем имена трех файлов
        String fn2 = r.readLine();
        String fn3 = r.readLine();
        FileOutputStream fos = new FileOutputStream(fn1, true);
        FileInputStream fis = new FileInputStream(fn2);
        FileInputStream fis2 = new FileInputStream(fn3);
        r.close();

        byte[] bufferfn2 = new byte[fis.available()];
        byte[] bufferfn3 = new byte[fis2.available()];
        fis.read(bufferfn2);
        fis2.read(bufferfn3);

        fos.write(bufferfn2);
        fos.write(bufferfn3);
        fis.close();
        fis2.close();
        fos.close();
    }
}
