package com.dooioo.study.designpattern.proxy;

/**
 * description:代理对象
 * author:Eric
 * Date:16/9/6
 * Time:15:34
 * version 1.0.0
 */
public class HouseAgent implements House{

    private Landlord landlord = new Landlord();

    /**
     * 房产中介卖房
     */
    public void sellHouse() {
        System.out.println("房产中介通知房东卖房!");
        landlord.sellHouse();
    }
}
