package com.eric.study.designpattern.factory;

/**
 * description:
 * author:yangkang
 * Date:16/8/19
 * Time:14:06
 * version 1.0.0
 */
public class ConcreteToyCreator implements IToyCreator{


    public <T extends IToy> IToy createToy(Class<T> clazz) {
        if(clazz ==null){
            throw new IllegalArgumentException("argument must not be null");
        }
        try{
            IToy toy = clazz.newInstance();
            toy.play();
            System.out.println(toy.getName());
            return toy;
        }catch (Exception e){
            throw new UnknownError(e.getMessage());
        }
    }
}
