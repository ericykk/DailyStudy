package com.eric.study.nio;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * description:stream刷新缓冲区
 * author:Eric
 * Date:16/9/6
 * Time:10:46
 * version 1.0.0
 */
public class StreamFlushTest {

    public static void main(String[] args){
        OutputStream os = null;
        try{
            FileOutputStream fos = new FileOutputStream("flushTest");
            os = new BufferedOutputStream(fos, 512);
            //将内容写到缓冲区
            os.write('a');
            os.write('b');
            os.write('c');
            //强制刷新缓冲区 将缓冲区内容写入文件
            os.flush();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
