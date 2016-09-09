package com.eric.daily.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * description:实现动态代理处理程序
 * author:Eric
 * Date:16/9/6
 * Time:17:10
 * version 1.0.0
 */
public class ProxyHandler implements InvocationHandler {

    /**
     * 目标对象
     */
    private Object proxiedObject;

    public ProxyHandler(Object proxiedObject){
        this.proxiedObject = proxiedObject;
    }

    /**
     * 执行动态代理目标的方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前执行逻辑!");
        //执行具体目标的方法
        Object result = method.invoke(proxiedObject,args);
        System.out.println("代理后执行逻辑!");
        return result;
    }
}
