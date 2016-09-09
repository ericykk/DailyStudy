package com.eric.daily.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * description:
 * author:yangkang
 * Date:16/8/10
 * Time:13:39
 * version 1.0.0
 */
public class NioTest {

    /**
     * 采用流的方式读取数据
     */
    public static  void oldIoTest(){
        try {
            FileInputStream inputStream = new FileInputStream("/Users/yangkang/Desktop/daily/NIO/知识清单");
            byte [] buffer = new byte[1024];
            inputStream.read(buffer);
            System.out.println(new String(buffer));
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 采用NIO的方式读取数据
     */
    public static void newIoTest(){
        try{
            FileInputStream inputStream = new FileInputStream("/Users/yangkang/Desktop/daily/NIO/知识清单");
            //为该文件输入流生成唯一的文件通道  FileChannel
            FileChannel channel = inputStream.getChannel();
            //开辟一个长度为1024的字节缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            channel.read(buffer);
            System.out.println(new String(buffer.array()));
            System.out.println(buffer.isDirect() + ", " + buffer.isReadOnly());
            channel.close();
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void copyFile(){
        try{
            //获取源文件和目标文件的输入输出流
            FileInputStream inputStream = new FileInputStream("/Users/yangkang/Desktop/daily/NIO/知识清单");
            FileOutputStream outputStream = new FileOutputStream("/Users/yangkang/Desktop/daily/NIO/知识清单copy");
            //获取输入输出通道
            FileChannel inChannel = inputStream.getChannel();
            FileChannel outChannel = outputStream.getChannel();
            //创建缓冲区
            ByteBuffer buffer =  ByteBuffer.allocate(1024);

            while(true){
                //clear方法重设缓冲区，使它可以接受读入的数据
                buffer.clear();
                //从输入通道中将数据读到缓冲区
                int rl = inChannel.read(buffer);
                //read方法返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回-1
                if(rl ==-1){
                    break;
                }
                //flip方法让缓冲区可以将新读入的数据写入另一个通道
                buffer.flip();
                //从输出通道中将数据写入缓冲区
                outChannel.write(buffer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String [] args){
        oldIoTest();
        newIoTest();
        copyFile();
    }



}
