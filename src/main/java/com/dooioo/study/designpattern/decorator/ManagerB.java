package com.dooioo.study.designpattern.decorator;

/**
 * description:具体装饰角色
 * author:Eric
 * Date:16/9/6
 * Time:14:20
 * version 1.0.0
 */
public class ManagerB extends Manager {

    public ManagerB(Project project) {
        super(project);
    }

    public void doStartWork() {
        System.out.println("项目经理B前期工作!");
    }

    public void doEndWork() {
        System.out.println("项目经理B后期工作");
    }
}
