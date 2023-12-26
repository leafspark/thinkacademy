package com.tal.app.thinkacademy.live.core.backplay.http.bean;

import com.google.gson.annotations.SerializedName;

public class MetaDataEvent extends TimePeriod implements Comparable<MetaDataEvent> {
    public long actionDuration;
    @SerializedName("ActionTs")
    private long actionTs;
    @SerializedName("ActionTsOffset")
    private long actionTsOffset;
    @SerializedName("Category")
    private int category;
    private String ircType;
    @SerializedName("Info")
    private String properties;

    public String getIrcType() {
        return this.ircType;
    }

    public void setIrcType(String str) {
        this.ircType = str;
    }

    public String getProperties() {
        return this.properties;
    }

    public void setProperties(String str) {
        this.properties = str;
    }

    public int getCategory() {
        return this.category;
    }

    public void setCategory(int i) {
        this.category = i;
    }

    public long getActionTs() {
        return this.actionTs;
    }

    public void setActionTs(long j) {
        this.actionTs = j;
    }

    public long getActionTsOffset() {
        return this.actionTsOffset;
    }

    public void setActionTsOffset(long j) {
        this.actionTsOffset = j;
    }

    public int compareTo(MetaDataEvent metaDataEvent) {
        return (int) (getActionTs() - metaDataEvent.getActionTs());
    }

    public long getActionDuration() {
        return this.actionDuration;
    }

    public void setActionDuration(long j) {
        this.actionDuration = j;
    }
}
