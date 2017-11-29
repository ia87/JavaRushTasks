package com.javarush.task.task25.task2506;

/**
 * Created by ac on 28.11.2017.
 */
public class LoggingStateThread extends Thread{
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        Thread.State state = thread.getState();
        System.out.println(state);
        while (thread.getState()!=State.TERMINATED) {
            Thread.State currState;
            if ((currState=thread.getState())!= state) {
                System.out.println(thread.getState());
                state = currState;
            }
        }
        System.out.println(thread.getState());
    }
}
