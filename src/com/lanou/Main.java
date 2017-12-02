package com.lanou;

/**
 * Created by dllo on 17/11/14.
 */
public class Main {
    public static void main(String[] args) {
        new TcpServer().start();
        try {
            Thread.sleep(3000);
            new TcpClient().start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }
}
