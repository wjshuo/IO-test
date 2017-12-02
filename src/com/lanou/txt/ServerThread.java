package com.lanou.txt;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dllo on 17/11/15.
 * 接受
 */
public class ServerThread extends Thread {
    private String outPath="b.txt";
    private int port=8086;
    private BufferedReader br;
    private BufferedWriter bw;

    @Override
    public void run() {
        try {
            System.out.println(">等待连接...");
            //利用ServerSocket服务连接来获取端口号
            ServerSocket ss=new ServerSocket(port);
            //利用连接来接收服务连接对象
            Socket socket=ss.accept();
            //获取ip地址
            System.out.println(ss.getInetAddress()+">已接入...");
            //服务端此时为输入,利用输入流来获取连接输入.
            InputStream is= socket.getInputStream();

            //InputStreamReader 是字节流通向字符流的桥梁：
            // 它使用指定的 charset 读取字节并将其解码为字符。
            // 它使用的字符集可以由名称指定或显式给定，或者可以接受平台默认的字符集。
            //bufferedreader将字节流转换为带有缓冲字符流,将输入的字节流转换成带有缓冲区的字符流然后读取.
            br = new BufferedReader(new InputStreamReader(is));
            //将文本写入字符输出流，缓冲各个字符，从而提供单个字符、数组和字符串的高效写入。
            //将缓冲字符输出流输出到新创建的文件中.
            bw = new BufferedWriter(new FileWriter(new File(outPath)));
            //字符流的读取方法
            String line="";
            while ((line=br.readLine())!=null){
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
            //关流
            bw.close();
            br.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
