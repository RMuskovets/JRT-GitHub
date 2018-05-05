package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fs = new FileInputStream(bf.readLine());
        FileOutputStream o1 = new FileOutputStream(bf.readLine());
        FileOutputStream o2 = new FileOutputStream(bf.readLine());
        byte[] buf;
        if (fs.available()%2 == 0)
        {
            buf = new byte[fs.available()/2]; fs.read(buf);
            o1.write(buf);
            buf = new byte[fs.available()];fs.read(buf);
            o2.write(buf);
        }
        else
        {
            buf=new byte[fs.available()/2+1]; fs.read(buf);
            o1.write(buf);
            buf=new byte[fs.available()]; fs.read(buf);
            o2.write(buf);
        }


        bf.close();
        fs.close();
        o1.close();
        o2.close();
    }
}
