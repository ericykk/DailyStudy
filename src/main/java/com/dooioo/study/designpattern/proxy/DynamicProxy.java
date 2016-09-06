package com.dooioo.study.designpattern.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * description:模拟动态代理的实现
 * author:Eric
 * Date:16/9/6
 * Time:17:17
 * version 1.0.0
 */
public class DynamicProxy {

    public static void main(String[] args) {
        //被代理类对象
        RealSubject real = new RealSubject();
        ProxyHandler handler = new ProxyHandler(real);
        //获取被代理对象的实例
        Subject proxySubject  = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),RealSubject.class.getInterfaces(),handler);
        proxySubject.doAction();
        //生成动态代理类的class文件
//        createProxyClassFile();
    }


    /**
     * 生成动态代理类的class字节码文件 即动态代理的内部实现的代码
     */
    public static void createProxyClassFile() {

        String name = "ProxySubject";
        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[] {Subject.class});

        FileOutputStream out = null;
        try
        {   out = new FileOutputStream(name + ".class");
            out.write(data);
            out.flush();
        } catch( Exception e ) {
            e.printStackTrace();
        }finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
