package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {

    private Thread running;

    @Override
    public void run() {
        System.out.println(running.getName());
        while (true) {
            try {
                Thread.sleep(100);
                System.out.println(running.getName());
            } catch (InterruptedException e) {
            }
        }
    }

    public void start(String threadName) {
        running = new Thread(this);
        running.setName(threadName);
        running.start();

    }

    @Override
    public void stop() {
        running.interrupt();
        running.stop();
    }
}
