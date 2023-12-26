package com.eaydu.omni.log.bean;

public class LogMemoryStatistics {
    public int memoryAppUsageInKbytes;
    public double memoryAppUsageRatio;
    public double memoryTotalUsageRatio;

    public LogMemoryStatistics() {
    }

    public LogMemoryStatistics(double d, double d2, int i) {
        this.memoryAppUsageRatio = d;
        this.memoryTotalUsageRatio = d2;
        this.memoryAppUsageInKbytes = i;
    }
}
