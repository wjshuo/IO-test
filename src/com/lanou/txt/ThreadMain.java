package com.lanou.txt;

/**
 * Created by dllo on 17/11/15.
 */
public class ThreadMain {
    public static void main(String[] args) {
        new ServerThread().start();
        try {

            Thread.sleep(3000);
            new ClientThread().start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
