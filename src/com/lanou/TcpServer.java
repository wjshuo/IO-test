package com.lanou;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dllo on 17/11/14.
 */
public class TcpServer extends Thread{
    private int port=9999;

    @Override
    public void run() {

        try {
            ServerSocket ss =new ServerSocket(port);
            Socket socket=ss.accept();
            InputStream is =socket.getInputStream();
            //客户端给服务端发图片,读取图片存到a文件中,叫b.jpg.创建输出流,连接路径a/b.jpg
            File dir=new File("a/");
            if (!dir.exists()){
                dir.mkdir();
            }
            File imgFile=new File(dir,"b.jpg");
            OutputStream os =new FileOutputStream(imgFile);
            //边读边写
            byte[]bytes=new byte[1024];
            int length=0;
            while ((length=is.read(bytes))!=-1){
                os.write(bytes,0,bytes.length);
            }//将图片转换成字节,
            os.close();
            is.close();
            socket.close();
            ss.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
