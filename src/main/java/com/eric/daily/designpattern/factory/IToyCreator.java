package com.eric.daily.designpattern.factory;

/**
 * description:
 * author:yangkang
 * Date:16/8/19
 * Time:14:04
 * version 1.0.0
 */
public interface IToyCreator {
    <T extends IToy> IToy createToy(Class<T> clazz);
}
