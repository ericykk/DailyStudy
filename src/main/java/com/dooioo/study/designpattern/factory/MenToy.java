package com.dooioo.study.designpattern.factory;

/**
 * description:
 * author:yangkang
 * Date:16/8/19
 * Time:13:58
 * version 1.0.0
 */
public class MenToy implements IToy{
    public String getName() {
        return "MenToy";
    }

    public float price() {
        return 20;
    }

    public void play() {
        System.out.println("Do you want to play MenToy?");
    }
}
