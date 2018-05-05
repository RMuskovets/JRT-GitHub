package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        printParents(e);
    }

    private void printParents(Throwable e) {
        List<Throwable> list = new ArrayList<>(Collections.singletonList(e));
        Throwable cause = e;
        while ((cause = cause.getCause()) != null)
        {
            list.add(cause);}
        Collections.reverse(list);
        for(Throwable l:list)
            System.out.println(l.getClass().getName()+": "+l.getMessage());
    }

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            throw new RuntimeException("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        });
        t.setUncaughtExceptionHandler(new Solution());
        t.start();
    }
}
