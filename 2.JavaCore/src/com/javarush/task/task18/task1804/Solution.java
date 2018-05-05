package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String fileName = buf .readLine();
        buf .close();
        FileInputStream fis = new FileInputStream(fileName);
        ArrayList<Integer> resArr = new ArrayList<>();
        while (fis.available()>0){
            int data = fis.read();
            resArr.add(data);
        }
        fis.close();
        HashMap<Integer,Integer> repMap = new HashMap<>();
        for (int i=0;i<resArr.size();i++){
            int count=1;
            for (int j=0;j<resArr.size();j++){
                if (resArr.get(i)==resArr.get(j)) count++;
            }
            repMap.put(resArr.get(i),count);
        }
        int min = Collections.min(repMap.values());
        for (Map.Entry<Integer,Integer> pr : repMap.entrySet()){
            if (pr.getValue()==min) System.out.print(pr.getKey() + " ");
        }
        System.out.println("");
    }
}
