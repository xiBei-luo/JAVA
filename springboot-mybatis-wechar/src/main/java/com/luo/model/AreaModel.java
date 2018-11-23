package com.luo.model;


import java.util.Date;

/**
 * Created by Luowenlv on 2018/9/29,9:38
 */
public class AreaModel {
    private Integer area_id;
    private String area_name;
    private Integer priority;
    private Date create_time;
    private Date edit_last_time;

    public AreaModel(Integer area_id, String area_name, Integer priority, Date create_time, Date edit_last_time) {
        this.area_id = area_id;
        this.area_name = area_name;
        this.priority = priority;
        this.create_time = create_time;
        this.edit_last_time = edit_last_time;
    }

    public AreaModel() {
    }

    public Integer getArea_id() {
        return area_id;
    }

    public void setArea_id(Integer area_id) {
        this.area_id = area_id;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getEdit_last_time() {
        return edit_last_time;
    }

    public void setEdit_last_time(Date edit_last_time) {
        this.edit_last_time = edit_last_time;
    }

    @Override
    public String toString() {
        return "AreaModel{" +
                "area_id=" + area_id +
                ", area_name='" + area_name + '\'' +
                ", priority=" + priority +
                ", create_time=" + create_time +
                ", edit_last_time=" + edit_last_time +
                '}';
    }
}
