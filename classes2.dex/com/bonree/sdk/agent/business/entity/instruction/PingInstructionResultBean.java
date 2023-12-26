package com.bonree.sdk.agent.business.entity.instruction;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class PingInstructionResultBean extends InstructionResultBean {
    @SerializedName("avgt")
    private double averageTime;
    @SerializedName("maxt")
    private double maximumTime;
    @SerializedName("mint")
    private double minimumTime;
    @SerializedName("plr")
    private double packageLossRate;
    @SerializedName("pr")
    private String pingResult;
    @SerializedName("rp")
    private int receivePackage;
    @SerializedName("sp")
    private int sendPackage;

    public void setPingResult(String str) {
        this.pingResult = str;
    }

    public void setSendPackage(int i) {
        this.sendPackage = i;
    }

    public void setReceivePackage(int i) {
        this.receivePackage = i;
    }

    public void setPackageLossRate(double d) {
        this.packageLossRate = d;
    }

    public void setMaximumTime(double d) {
        this.maximumTime = d;
    }

    public void setMinimumTime(double d) {
        this.minimumTime = d;
    }

    public void setAverageTime(double d) {
        this.averageTime = d;
    }

    public String toString() {
        return "PingInstructionResultBean{pingResult='" + this.pingResult + '\'' + ", sendPackage=" + this.sendPackage + ", receivePackage=" + this.receivePackage + ", packageLossRate=" + this.packageLossRate + ", maximumTime=" + this.maximumTime + ", minimumTime=" + this.minimumTime + ", averageTime=" + this.averageTime + '}';
    }
}
