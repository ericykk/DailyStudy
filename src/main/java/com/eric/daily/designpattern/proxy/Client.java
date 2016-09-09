package com.eric.daily.designpattern.proxy;

/**
 * description:客户端
 * author:Eric
 * Date:16/9/6
 * Time:15:37
 * version 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        HouseAgent agent = new HouseAgent();
        agent.sellHouse();
    }
}
