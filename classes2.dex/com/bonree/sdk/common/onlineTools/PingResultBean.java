package com.bonree.sdk.common.onlineTools;

public class PingResultBean {
    public double avg;
    public double lostPercent;
    public double max;
    public double min;
    public String pingResult;
    public int received;
    public int send;

    public String toString() {
        return "PingResultBean{send=" + this.send + ", received=" + this.received + ", lostPercent=" + this.lostPercent + ", min=" + this.min + ", max=" + this.max + ", avg=" + this.avg + ", pingResult='" + this.pingResult + '\'' + '}';
    }
}
