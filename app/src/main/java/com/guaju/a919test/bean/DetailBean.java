package com.guaju.a919test.bean;

/**
 * Created by guaju on 2017/9/25.
 */

public class DetailBean {
    int iconID;
    String title;
    String desc;
    String time;

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public DetailBean(int iconID, String title, String desc, String time) {
        this.iconID = iconID;
        this.title = title;
        this.desc = desc;
        this.time = time;
    }

    @Override
    public String toString() {
        return "DetailBean{" +
                "iconID=" + iconID +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
