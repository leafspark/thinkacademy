package com.tal.app.thinkacademy.live.business.emoji.bean;

import java.io.Serializable;

public class EmojiBean<T> implements Serializable {
    private String name;
    private T resource;
    private int type;

    public EmojiBean() {
    }

    public EmojiBean(String str, int i) {
        this.name = str;
        this.type = i;
    }

    public EmojiBean(String str, int i, T t) {
        this.name = str;
        this.type = i;
        this.resource = t;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public T getResource() {
        return this.resource;
    }

    public void setResource(T t) {
        this.resource = t;
    }
}
