package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }


    @Override
    public void run() {
        State state = null;

        while (true) {
            State stateNew = thread.getState();
            if (stateNew != state) {
                state = stateNew;
                System.out.println(state);
            }

            if (state == State.TERMINATED)
                break;
        }

    }
}