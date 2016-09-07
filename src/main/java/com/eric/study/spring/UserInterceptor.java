package com.eric.study.spring;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 * description:
 * author:yangkang
 * Date:16/6/30
 * Time:09:39
 * version 1.0.0
 */
public class UserInterceptor implements MethodInterceptor{

    public Object invoke(MethodInvocation invocation) throws Throwable {

        try{
            //拦截接口中指定的方法
            if(invocation.getMethod().getName().equals("printUserName")){
                Object [] args = invocation.getArguments();//被拦截的参数
                System.out.println("user:"+args[0]);
                invocation.getArguments()[0] = "HanMeiMei!";//修改被拦截的参数
            }
            System.out.println("执行方法名:"+invocation.getMethod().getName());
            return  invocation.proceed();//运行被拦截的printUserName方法
        }catch (Exception e){
            throw e;
        }
    }

}
