package com.eric.daily.cache.redis.controller;
import com.eric.daily.common.controller.BaseController;
import com.eric.daily.common.model.JsonResult;
import com.eric.daily.configuration.annotation.RedisCache;
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
@RequestMapping(value = "/user")
public class RedisController extends BaseController {

    @RedisCache(expireTime = 300)
    @ResponseBody
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public JsonResult getRedisIndex(){
        return ok().put("index","Hello boy,Welcome to redis world!");
    }
}
