package com.tal.app.thinkacademy.live.core.backplay.http.response;

import com.tal.app.thinkacademy.live.core.backplay.http.bean.MetaDataEvent;
import com.tal.app.thinkacademy.live.core.backplay.http.bean.TimePeriod;
import java.util.List;

public class MetaDataEntity {
    public List<MetaDataEvent> event;
    private long gotoClassTime;
    private int isStreamTime;
    private List<TimePeriod> streamTime;

    public List<MetaDataEvent> getEvent() {
        return this.event;
    }

    public void setEvent(List<MetaDataEvent> list) {
        this.event = list;
    }

    public long getGotoClassTime() {
        return this.gotoClassTime;
    }

    public void setGotoClassTime(long j) {
        this.gotoClassTime = j;
    }

    public List<TimePeriod> getStreamTime() {
        return this.streamTime;
    }

    public void setStreamTime(List<TimePeriod> list) {
        this.streamTime = list;
    }

    public int getIsStreamTime() {
        return this.isStreamTime;
    }

    public void setIsStreamTime(int i) {
        this.isStreamTime = i;
    }
}
