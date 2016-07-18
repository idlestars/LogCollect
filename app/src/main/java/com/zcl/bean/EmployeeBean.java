package com.zcl.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 夜未央 on 2016/7/13.
 */
public class EmployeeBean {
    private String name;//
    private int age;
    private String eprj;
    private String eunit;
    private String workface;
    private String entryDate;
    private String worktype;
    private String tel;


    public EmployeeBean(String name) {
        this.name = name;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new Date());//格式化数据
        this.entryDate = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEprj() {
        return eprj;
    }

    public void setEprj(String eprj) {
        this.eprj = eprj;
    }

    public String getEunit() {
        return eunit;
    }

    public void setEunit(String eunit) {
        this.eunit = eunit;
    }

    public String getWorkface() {
        return workface;
    }

    public void setWorkface(String workface) {
        this.workface = workface;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getWorktype() {
        return worktype;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
