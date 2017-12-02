package com.lanou.txt;

import java.io.*;
import java.net.Socket;

/**
 * Created by dllo on 17/11/15.
 * 客户端
 */
public class ClientThread extends Thread {
    private String ip = "172.16.16.201";
    private int port = 8086;
    private String inPath = "/Users/dllo/Desktop/bbb.txt";
    private BufferedWriter bw;
    private BufferedReader br;

    @Override
    public void run() {
        try {
            System.out.println(">请求连接...");
            //利用socket连接获取ip地址和端口号
            Socket socket = new Socket(ip, port);
            System.out.println(">连接成功...");
            //因为发送文档为输出流,利用socket连接获取输出流
            OutputStream os = socket.getOutputStream();
            //字节流创建输出字符流,再讲输出字符流转换为带缓冲区的字符流
            bw = new BufferedWriter(new OutputStreamWriter(os));
            //bufferedreader :从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。
            //可以指定缓冲区的大小，或者可使用默认的大小。大多数情况下，默认值就足够大了。
            //将输入的文档读取.
            br = new BufferedReader(new FileReader(new File(inPath)));
            //字符流的读取方法
            String line = "";
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
