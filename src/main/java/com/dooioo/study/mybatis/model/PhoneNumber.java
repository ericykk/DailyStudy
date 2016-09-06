package com.dooioo.study.mybatis.model;

/**
 * description:
 * author:yangkang
 * Date:16/8/22
 * Time:10:09
 * version 1.0.0
 */
public class PhoneNumber {
    private Integer id;
    private String phoneNum;
    private String imei;
    private Integer empNo;
    private String empName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
