package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        if (N <= 0) return new long[0];
        long start=System.currentTimeMillis();
        StringBuilder stringBuffer= new StringBuilder(Long.toString(N));
        ArrayList<Integer> list = new ArrayList<>();
        long[] result = new long [stringBuffer.length()];
        for (int i = 0; i < stringBuffer.length(); i++) {
            list.add(Integer.parseInt(String.valueOf(stringBuffer.charAt(i))));
        }
        int b=0;
        Collections.sort(list);
        if (list.size() > 1)
        list.remove(list.size()-1);
        while (list.get(0) == 0) {
            list.remove(0);
        }
        list = new ArrayList<>(new HashSet<>(list));
        for (Integer l: list) {
            result[b]= (long) Math.pow(l,stringBuffer.length());
            System.out.println(result[b]);
            b++;
        }
        System.out.println("Размер массива="+stringBuffer.length());
        long end=System.currentTimeMillis();
        System.out.println("Время "+(end - start)+" ms");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/(1024*1024) + " MB");
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        System.out.println(Arrays.toString(getNumbers(((long)Integer.MAX_VALUE) * 8)));
        System.out.println(Arrays.toString(getNumbers(((byte)Integer.MAX_VALUE))));
        System.out.println(Arrays.toString(getNumbers(9)));
    }
}
