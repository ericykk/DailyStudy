package com.eric.daily.designpattern.factory;

/**
 * description:
 * author:yangkang
 * Date:16/8/19
 * Time:14:13
 * version 1.0.0
 */
public class FactoryTest {

    public static void main(String [] args){
        IToyCreator iToyCreator = new ConcreteToyCreator();
        IToy toy = iToyCreator.createToy(MenToy.class);
        System.out.println(toy.getName());
    }
}
