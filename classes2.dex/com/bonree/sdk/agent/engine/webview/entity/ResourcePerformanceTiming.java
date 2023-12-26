package com.bonree.sdk.agent.engine.webview.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class ResourcePerformanceTiming {
    @SerializedName("ce")
    private int ce;
    @SerializedName("cs")
    private int cs;
    @SerializedName("dbs")
    private long dbs;
    @SerializedName("dle")
    private int dle;
    @SerializedName("dls")
    private int dls;
    @SerializedName("dura")
    private int dura;
    @SerializedName("ebs")
    private long ebs;
    @SerializedName("ec")
    private int ec;
    @SerializedName("fs")
    private int fs;
    @SerializedName("name")
    private String name;
    @SerializedName("pr")
    private String pr;
    @SerializedName("reqs")
    private int reqs;
    @SerializedName("rspe")
    private int rspe;
    @SerializedName("rsps")
    private int rsps;
    @SerializedName("rt")
    private String rt;
    @SerializedName("scs")
    private int scs;
    @SerializedName("st")
    private long st;
    @SerializedName("ts")
    private long ts;

    public long getSt() {
        return this.st;
    }

    public void setSt(long j) {
        this.st = j;
    }

    public int getEc() {
        return this.ec;
    }

    public void setEc(int i) {
        this.ec = i;
    }

    public String getRt() {
        return this.rt;
    }

    public void setRt(String str) {
        this.rt = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getDura() {
        return this.dura;
    }

    public void setDura(int i) {
        this.dura = i;
    }

    public int getFs() {
        return this.fs;
    }

    public void setFs(int i) {
        this.fs = i;
    }

    public int getDls() {
        return this.dls;
    }

    public void setDls(int i) {
        this.dls = i;
    }

    public int getDle() {
        return this.dle;
    }

    public void setDle(int i) {
        this.dle = i;
    }

    public int getCs() {
        return this.cs;
    }

    public void setCs(int i) {
        this.cs = i;
    }

    public int getCe() {
        return this.ce;
    }

    public void setCe(int i) {
        this.ce = i;
    }

    public int getScs() {
        return this.scs;
    }

    public void setScs(int i) {
        this.scs = i;
    }

    public int getReqs() {
        return this.reqs;
    }

    public void setReqs(int i) {
        this.reqs = i;
    }

    public int getRsps() {
        return this.rsps;
    }

    public void setRsps(int i) {
        this.rsps = i;
    }

    public int getRspe() {
        return this.rspe;
    }

    public void setRspe(int i) {
        this.rspe = i;
    }

    public long getTs() {
        return this.ts;
    }

    public void setTs(int i) {
        this.ts = (long) i;
    }

    public long getEbs() {
        return this.ebs;
    }

    public void setEbs(int i) {
        this.ebs = (long) i;
    }

    public long getDbs() {
        return this.dbs;
    }

    public void setDbs(int i) {
        this.dbs = (long) i;
    }

    public String getPr() {
        return this.pr;
    }

    public void setPr(String str) {
        this.pr = str;
    }
}
