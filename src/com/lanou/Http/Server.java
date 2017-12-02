package com.lanou.Http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dllo on 17/11/14.
 */
public class Server extends Thread{

    private int port =9999;


    @Override
    public void run() {
        try {
            ServerSocket ss =new ServerSocket(port);




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
