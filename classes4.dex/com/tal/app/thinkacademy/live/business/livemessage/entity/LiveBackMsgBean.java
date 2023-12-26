package com.tal.app.thinkacademy.live.business.livemessage.entity;

import java.util.ArrayList;

public class LiveBackMsgBean {
    private ArrayList<LiveBackMessageEntity> list;

    public ArrayList<LiveBackMessageEntity> getList() {
        return this.list;
    }

    public void setList(ArrayList<LiveBackMessageEntity> arrayList) {
        this.list = arrayList;
    }

    public String toString() {
        return "LiveBackMsgBean{list=" + this.list + '}';
    }
}
