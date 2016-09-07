package com.eric.study.designpattern.decorator;

/**
 * description:具体装饰角色
 * author:Eric
 * Date:16/9/6
 * Time:14:19
 * version 1.0.0
 */
public class ManagerA extends Manager {

    public ManagerA(Project project) {
        super(project);
    }

    public void doStartWork() {
        System.out.println("项目经理A前期工作!");
    }

    public void doEndWork() {
        System.out.println("项目经理A后期工作");
    }
}
