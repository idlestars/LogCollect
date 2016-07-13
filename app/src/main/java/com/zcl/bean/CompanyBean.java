package com.zcl.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 夜未央 on 2016/7/13.
 */
public class CompanyBean {
    private String name;//
    private String manager;
    private int numeEployee;
    private int numeEquip;
    private String entryDate;
    public CompanyBean(String name) {
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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getNumeEployee() {
        return numeEployee;
    }

    public void setNumeEployee(int numeEployee) {
        this.numeEployee = numeEployee;
    }

    public int getNumeEquip() {
        return numeEquip;
    }

    public void setNumeEquip(int numeEquip) {
        this.numeEquip = numeEquip;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }
}
