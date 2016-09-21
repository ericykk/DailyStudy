package com.eric.daily.cache.redis.controller;

import com.eric.daily.cache.redis.service.RedisService;
import com.eric.daily.common.BaseController;
import com.eric.daily.common.JsonResult;
import com.eric.daily.configuration.annotation.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description:控制器
 * author:Eric
 * Date:16/9/21
 * Time:11:42
 * version 1.0.0
 */
@Controller
@RequestMapping(value = "/redis")
public class RedisController extends BaseController {

    @RedisCache
    @ResponseBody
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public JsonResult getRedisIndex(){
        return ok().put("index","Hello boy,Welcome to reids world!");
    }


    @RedisCache
    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public JsonResult getUserInfo(){
        return ok().put("eric","redis cache!");
    }
}
