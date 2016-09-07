package com.eric.study.designpattern.factory;

/**
 * description:
 * author:yangkang
 * Date:16/8/19
 * Time:14:00
 * version 1.0.0
 */
public class WomenToy implements IToy{
    public String getName() {
        return "WomenToy";
    }

    public float price() {
        return 20;
    }

    public void play() {
        System.out.println("Do you want to play WomenToy?");
    }
}
