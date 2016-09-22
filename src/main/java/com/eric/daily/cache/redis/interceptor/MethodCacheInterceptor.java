package com.eric.daily.cache.redis.interceptor;

import com.eric.daily.cache.redis.util.RedisCacheService;
import com.eric.daily.configuration.annotation.RedisCache;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

/**
 * description:redis缓存拦截器
 * author:Eric
 * Date:16/9/21
 * Time:16:27
 * version 1.0.0
 */
public class MethodCacheInterceptor implements MethodInterceptor{

    @Autowired
    private RedisCacheService cacheService;

    /**
     * redis和数据库同步
     * 监听数据库insert delete update操作 然后更新redis缓存
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Object value = null;

        Method method = invocation.getMethod();
        //获取缓存注解
        RedisCache redisCache = method.getDeclaredAnnotation(RedisCache.class);
        //判断是否需要缓存
        if(redisCache == null){
            //返回方法执行结果
            return invocation.proceed();
        }
        //方法名
        String methodName = method.getName();
        //类型名
        String targetName = invocation.getThis().getClass().getName();
        Object [] arguments = invocation.getArguments();
        //获取缓存key
        String key = getCacheKey(targetName,methodName,arguments);

        if(cacheService.hasKey(key)){
            return cacheService.get(key);
        }
        try {
            value = invocation.proceed();
            if(value != null){
                final String cacheKey = key;
                final Object cacheValue = value;
                //添加缓存
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        cacheService.set(cacheKey,cacheValue,redisCache.expireTime());
                    }
                }).start();
            }

        }catch (Exception e){
            e.printStackTrace();
            return invocation.proceed();
        }

        return value;
    }



    /**
     * 生成缓存key
     *
     * @param targetName
     * @param methodName
     * @param arguments
     */
    private String getCacheKey(String targetName, String methodName,
                               Object[] arguments) {
        StringBuffer sbu = new StringBuffer();
        sbu.append(targetName).append("_").append(methodName);
        if ((arguments != null) && (arguments.length != 0)) {
            for (int i = 0; i < arguments.length; i++) {
                sbu.append("_").append(arguments[i]);
            }
        }
        return sbu.toString();
    }
}