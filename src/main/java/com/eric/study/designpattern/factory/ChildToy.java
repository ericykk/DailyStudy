package com.eric.study.designpattern.factory;

/**
 * description:
 * author:yangkang
 * Date:16/8/19
 * Time:13:55
 * version 1.0.0
 */
public class ChildToy implements IToy{

    public String getName() {
        return "ChildToy";
    }

    public float price() {
        return 10.5f;
    }

    public void play() {
        System.out.println("Do you want to play ChildToy?");
    }
}
