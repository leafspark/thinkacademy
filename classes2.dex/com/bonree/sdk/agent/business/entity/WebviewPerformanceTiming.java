package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class WebviewPerformanceTiming {
    @SerializedName("ce")
    public int ce = 0;
    @SerializedName("cs")
    public int cs = 0;
    @SerializedName("dc")
    public int dc = 0;
    @SerializedName("dclee")
    public int dclee = 0;
    @SerializedName("dcles")
    public int dcles = 0;
    @SerializedName("di")
    public int di = 0;
    @SerializedName("dl")
    public int dl = 0;
    @SerializedName("dle")
    public int dle = 0;
    @SerializedName("dls")
    public int dls = 0;
    @SerializedName("fcp")
    public int fcp = 0;
    @SerializedName("fp")
    public int fp = 0;
    @SerializedName("fs")
    public int fs = 0;
    @SerializedName("lcp")
    public int lcp = 0;
    @SerializedName("lee")
    public int lee = 0;
    @SerializedName("les")
    public int les = 0;
    @SerializedName("ns")
    public long ns = 0;
    @SerializedName("rde")
    public int rde = 0;
    @SerializedName("rds")
    public int rds = 0;
    @SerializedName("reqs")
    public int reqs = 0;
    @SerializedName("rspe")
    public int rspe = 0;
    @SerializedName("rsps")
    public int rsps = 0;
    @SerializedName("scs")
    public int scs = 0;
    @SerializedName("uee")
    public int uee = 0;
    @SerializedName("ues")
    public int ues = 0;

    public String toString() {
        return "WebviewPerformanceTiming{ns=" + this.ns + ", fs=" + this.fs + ", reqs=" + this.reqs + ", rsps=" + this.rsps + ", rspe=" + this.rspe + ", dcles=" + this.dcles + ", dclee=" + this.dclee + ", di=" + this.di + ", dc=" + this.dc + ", dl=" + this.dl + ", les=" + this.les + ", lee=" + this.lee + ", ues=" + this.ues + ", uee=" + this.uee + ", cs=" + this.cs + ", ce=" + this.ce + ", dls=" + this.dls + ", dle=" + this.dle + ", rds=" + this.rds + ", rde=" + this.rde + ", scs=" + this.scs + ", fp=" + this.fp + ", fcp=" + this.fcp + ", lcp=" + this.lcp + '}';
    }
}
