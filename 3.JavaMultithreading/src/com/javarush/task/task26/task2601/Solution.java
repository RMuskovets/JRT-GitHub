package com.javarush.task.task26.task2601;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {

        double median;

        Arrays.sort(array);
        int middle = array.length / 2;
        if(array.length % 2 == 1)
            median = array[middle];
        else
            median = ( array[middle-1] + array[middle] ) / 2.0;

        Comparator<Integer> comparatorByMedian = (o1, o2) -> {
            int result1 = Math.abs((int) ((double) o1 - median));
            int result2 = Math.abs( (int)((double)o2 - median) );
            int addendum = (result1 == result2) ? ((o1 > o2) ? 1 : -1) : 0;

            return (result1 - result2) * 10 + addendum;
        };

        Arrays.sort(array, comparatorByMedian);

        return array;
    }
}
