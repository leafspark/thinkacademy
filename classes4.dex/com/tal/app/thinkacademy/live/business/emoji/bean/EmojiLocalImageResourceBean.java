package com.tal.app.thinkacademy.live.business.emoji.bean;

import java.io.Serializable;

public class EmojiLocalImageResourceBean implements Serializable {
    private int resId;

    public EmojiLocalImageResourceBean(int i) {
        this.resId = i;
    }

    public int getResId() {
        return this.resId;
    }

    public void setResId(int i) {
        this.resId = i;
    }
}
