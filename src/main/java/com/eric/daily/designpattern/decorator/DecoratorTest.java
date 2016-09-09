package com.eric.daily.designpattern.decorator;

/**
 * description:装饰模式测试类
 * author:Eric
 * Date:16/9/6
 * Time:14:26
 * version 1.0.0
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Project project = new Employee();
        ManagerA managerA = new ManagerA(project);
        ManagerB managerB = new ManagerB(project);
        managerA.doCoding();
        managerB.doCoding();
    }
}
