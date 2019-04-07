package com.gkskfhdlstmapk.hanpinetree.bcsd_mvcpattern;

public class NoticeBoardItem {
    String title;
    String name;
    String time;

    public NoticeBoardItem(String title, String name, String time) {
        this.title = title;
        this.name = name;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "NoticeBoardItem{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
