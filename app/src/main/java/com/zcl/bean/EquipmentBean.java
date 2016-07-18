package com.zcl.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 夜未央 on 2016/7/13.
 */
public class EquipmentBean {
    private String name;//
    private String entryDate;
    private String leader ;


    public EquipmentBean(String name) {
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

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }
}
