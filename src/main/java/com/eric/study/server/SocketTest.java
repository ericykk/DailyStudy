package com.eric.study.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * description:
 * author:yangkang
 * Date:16/7/12
 * Time:15:28
 * version 1.0.0
 */
public class SocketTest {

    public static void main(String [] args){

        try{
            Socket socket = new Socket("127.0.0.1",8085);
            OutputStream os = socket.getOutputStream();
            boolean autoflush = true;
            PrintWriter out = new PrintWriter(socket.getOutputStream(),autoflush);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //发送一个HTTP请求到web 服务器端
            out.println("GET /index.jsp HTTP/1.1");
            out.println("Host:localhost:8080");
            out.println("Connection:Close");
            out.println();
            //读取响应
            boolean loop = true;
            StringBuffer sb = new StringBuffer(8096);
            while(loop){
                if(in.ready()){
                    int i=0;
                    while(i!=-1){
                        i = in.read();
                        sb.append((char)i);
                    }
                }
                loop = false;
            }

            Thread.currentThread().sleep(50);
            //响应结果到显示平台
            System.out.println(sb.toString());
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
