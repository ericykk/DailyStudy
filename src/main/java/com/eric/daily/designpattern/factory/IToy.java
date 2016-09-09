package com.eric.daily.designpattern.factory;

/**
 * description:
 * author:yangkang
 * Date:16/8/19
 * Time:13:52
 * version 1.0.0
 */
public interface IToy {
    /**
     * 名字
     * @return
     */
    String getName();

    /**
     * 价格
     * @return
     */
    float price();

    /**
     * 玩玩具
     */
    void play();

}
