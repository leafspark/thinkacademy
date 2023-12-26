package com.luck.picture.lib.entity;

public class MediaExtraInfo {
    private long duration;
    private int height;
    private int width;

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public String toString() {
        return "MediaExtraInfo{width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + '}';
    }
}
