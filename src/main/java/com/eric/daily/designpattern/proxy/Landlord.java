package com.eric.daily.designpattern.proxy;

/**
 * description:真实对象
 * author:Eric
 * Date:16/9/6
 * Time:15:32
 * version 1.0.0
 */
public class Landlord implements House{

    /**
     * 房东卖房
     */
    public void sellHouse() {
        System.out.println("房东把房子卖掉了!");
    }
}
