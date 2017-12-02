package com.lanou.Http;

import java.io.*;
import java.net.Socket;

/**
 * Created by dllo on 17/11/14.
 */
public class Client extends Thread{
    private String ip="172.16.16.208";
    private int port =9999;


    @Override
    public void run() {
        try {
            Socket socket=new Socket(ip,port);
            OutputStream os=socket.getOutputStream();
            OutputStreamWriter osw =new OutputStreamWriter(os);
            BufferedWriter bw =new BufferedWriter(osw);


            



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
