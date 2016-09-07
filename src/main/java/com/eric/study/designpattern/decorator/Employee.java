package com.eric.study.designpattern.decorator;

/**
 * description:具体构建角色 此处为员工
 * author:Eric
 * Date:16/9/6
 * Time:14:11
 * version 1.0.0
 */
public class Employee implements Project {

    /**
     * 码农写代码
     */
    public void doCoding() {
        System.out.println("码农天天加班写代码,终于写完了!");
    }

}
