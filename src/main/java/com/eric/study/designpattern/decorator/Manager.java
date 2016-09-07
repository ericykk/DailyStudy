package com.eric.study.designpattern.decorator;

/**
 * description:装饰角色 此处假设为项目经理
 * author:Eric
 * Date:16/9/6
 * Time:14:13
 * version 1.0.0
 */
public class Manager implements Project {

    private Project project;

    public Manager(Project project){
        this.project = project;
    }

    /**
     * 编码
     */
    public void doCoding() {
        doStartWork();
        project.doCoding();
        doEndWork();
    }

    public void doStartWork(){

    }

    public void doEndWork(){

    }
}
