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
        Byte a = 1;
        Byte b = 1;
        Byte c = 127;
        Byte d = 127;
        System.out.println(a==b);
        System.out.println(c==d);
    }
}
