package com.dooioo.study.designpattern.factory;

import org.apache.poi.ss.formula.functions.T;

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
