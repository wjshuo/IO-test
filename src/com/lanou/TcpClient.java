package com.lanou;

import java.io.*;
import java.net.Socket;

/**
 * Created by dllo on 17/11/14.
 */
public class TcpClient extends Thread{
    private String ip="172.16.16.208";
    private int port=9999;

    @Override
    public void run() {
        try {
            //通过Socket连接ip和端口
            Socket socket=new Socket(ip,port);
            //客户端发送图片,为输出流
            OutputStream os =socket.getOutputStream();
            //输出图片,通过输入流把文件读成字节数组byte[];
            File file=new File("/Users/dllo/Desktop/a.jpg");
            //将文件输入流转换为输入流
            InputStream is =new FileInputStream(file);
            //字节流读取图片或者文档
            int len=0;
            //将读取到的字节先存储到数组中
            byte[] bytes=new byte[1024];
            while ((len=is.read(bytes))!=-1){
                os.write(bytes,0,len);//将客户端的输出流对象写入字节数组,且全部写入
            }
            //关流操作
            is.close();
            os.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
