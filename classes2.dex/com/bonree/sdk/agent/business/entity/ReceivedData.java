package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.List;

public class ReceivedData {
    private List<List<String>> ED;
    private PDBean PD;
    private List<RDBean> RD;

    public String toString() {
        return "ReceivedData [PD=" + this.PD + ", RD=" + this.RD + ", ED=" + this.ED + "]";
    }

    public PDBean getPD() {
        return this.PD;
    }

    public void setPD(PDBean pDBean) {
        this.PD = pDBean;
    }

    public List<RDBean> getRD() {
        return this.RD;
    }

    public void setRD(List<RDBean> list) {
        this.RD = list;
    }

    public List<List<String>> getED() {
        return this.ED;
    }

    public void setED(List<List<String>> list) {
        this.ED = list;
    }

    public static class PDBean {
        @SerializedName("ce")
        private int ce;
        @SerializedName("cs")
        private int cs;
        @SerializedName("dc")
        private int dc;
        @SerializedName("dclee")
        private int dclee;
        @SerializedName("dcles")
        private int dcles;
        @SerializedName("di")
        private int di;
        @SerializedName("dl")
        private int dl;
        @SerializedName("dle")
        private int dle;
        @SerializedName("dls")
        private int dls;
        @SerializedName("dr")
        private int dr;
        @SerializedName("firp")
        private int firp;
        @SerializedName("firs")
        private int firs;
        @SerializedName("flag")
        private int flag;
        @SerializedName("fs")
        private int fs;
        @SerializedName("header")
        private String header;
        @SerializedName("jen")
        private int jen;
        @SerializedName("lee")
        private int lee;
        @SerializedName("les")
        private int les;
        @SerializedName("ns")
        private long ns;
        @SerializedName("pfl")
        private int pfl;
        @SerializedName("pvid")
        private String pvid;
        @SerializedName("rde")
        private int rde;
        @SerializedName("rds")
        private int rds;
        @SerializedName("reqs")
        private int reqs;
        @SerializedName("rspe")
        private int rspe;
        @SerializedName("rsps")
        private int rsps;
        @SerializedName("scs")
        private int scs;
        @SerializedName("uee")
        private int uee;
        @SerializedName("ues")
        private int ues;
        @SerializedName("url")
        private String url;

        public String toString() {
            return "PDBean{" + "ns=" + this.ns + ", url='" + this.url + '\'' + ", pvid='" + this.pvid + '\'' + ", fs=" + this.fs + ", reqs=" + this.reqs + ", rsps=" + this.rsps + ", rspe=" + this.rspe + ", dcles=" + this.dcles + ", dclee=" + this.dclee + ", di=" + this.di + ", dc=" + this.dc + ", dl=" + this.dl + ", les=" + this.les + ", lee=" + this.lee + ", ues=" + this.ues + ", uee=" + this.uee + ", cs=" + this.cs + ", ce=" + this.ce + ", dls=" + this.dls + ", dle=" + this.dle + ", rds=" + this.rds + ", rde=" + this.rde + ", scs=" + this.scs + ", flag=" + this.flag + ", firp=" + this.firp + ", firs=" + this.firs + ", dr=" + this.dr + ", jen=" + this.jen + ", pfl=" + this.pfl + ", header='" + this.header + '\'' + '}';
        }

        public long getNs() {
            return this.ns;
        }

        public void setNs(long j) {
            this.ns = j;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public String getPvid() {
            return this.pvid;
        }

        public void setPvid(String str) {
            this.pvid = str;
        }

        public int getFs() {
            return this.fs;
        }

        public void setFs(int i) {
            this.fs = i;
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

        public int getDcles() {
            return this.dcles;
        }

        public void setDcles(int i) {
            this.dcles = i;
        }

        public int getDclee() {
            return this.dclee;
        }

        public void setDclee(int i) {
            this.dclee = i;
        }

        public int getDi() {
            return this.di;
        }

        public void setDi(int i) {
            this.di = i;
        }

        public int getDc() {
            return this.dc;
        }

        public void setDc(int i) {
            this.dc = i;
        }

        public int getDl() {
            return this.dl;
        }

        public void setDl(int i) {
            this.dl = i;
        }

        public int getLes() {
            return this.les;
        }

        public void setLes(int i) {
            this.les = i;
        }

        public int getLee() {
            return this.lee;
        }

        public void setLee(int i) {
            this.lee = i;
        }

        public int getUes() {
            return this.ues;
        }

        public void setUes(int i) {
            this.ues = i;
        }

        public int getUee() {
            return this.uee;
        }

        public void setUee(int i) {
            this.uee = i;
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

        public int getRds() {
            return this.rds;
        }

        public void setRds(int i) {
            this.rds = i;
        }

        public int getRde() {
            return this.rde;
        }

        public void setRde(int i) {
            this.rde = i;
        }

        public int getScs() {
            return this.scs;
        }

        public void setScs(int i) {
            this.scs = i;
        }

        public int getFlag() {
            return this.flag;
        }

        public void setFlag(int i) {
            this.flag = i;
        }

        public int getFirp() {
            return this.firp;
        }

        public void setFirp(int i) {
            this.firp = i;
        }

        public int getFirs() {
            return this.firs;
        }

        public void setFirs(int i) {
            this.firs = i;
        }

        public int getDr() {
            return this.dr;
        }

        public void setDr(int i) {
            this.dr = i;
        }

        public int getJen() {
            return this.jen;
        }

        public void setJen(int i) {
            this.jen = i;
        }

        public int getPfl() {
            return this.pfl;
        }

        public void setPfl(int i) {
            this.pfl = i;
        }

        public String getHeader() {
            return this.header;
        }

        public void setHeader(String str) {
            this.header = str;
        }
    }

    public static class RDBean {
        @SerializedName("ce")
        private double ce;
        @SerializedName("cs")
        private double cs;
        @SerializedName("des")
        private int des;
        @SerializedName("dle")
        private double dle;
        @SerializedName("dls")
        private double dls;
        @SerializedName("dr")
        private double dr;
        @SerializedName("ens")
        private int ens;
        @SerializedName("fs")
        private double fs;
        @SerializedName("name")
        private String name;
        @SerializedName("pr")
        private String pr;
        @SerializedName("reqs")
        private double reqs;
        @SerializedName("rspe")
        private double rspe;
        @SerializedName("rsps")
        private double rsps;
        @SerializedName("rt")
        private String rt;
        @SerializedName("scs")
        private double scs;
        @SerializedName("st")
        private double st;
        @SerializedName("ts")
        private int ts;

        public String toString() {
            return "RDBean{" + "st=" + this.st + ", rt='" + this.rt + '\'' + ", name='" + this.name + '\'' + ", dr=" + this.dr + ", fs=" + this.fs + ", dls=" + this.dls + ", dle=" + this.dle + ", cs=" + this.cs + ", ce=" + this.ce + ", scs=" + this.scs + ", reqs=" + this.reqs + ", rsps=" + this.rsps + ", rspe=" + this.rspe + ", ts=" + this.ts + ", ens=" + this.ens + ", des=" + this.des + ", pr='" + this.pr + '\'' + '}';
        }

        public double getSt() {
            return this.st;
        }

        public void setSt(float f) {
            this.st = (double) f;
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

        public double getDr() {
            return this.dr;
        }

        public void setDr(float f) {
            this.dr = (double) f;
        }

        public double getFs() {
            return this.fs;
        }

        public void setFs(float f) {
            this.fs = (double) f;
        }

        public double getDls() {
            return this.dls;
        }

        public void setDls(float f) {
            this.dls = (double) f;
        }

        public double getDle() {
            return this.dle;
        }

        public void setDle(float f) {
            this.dle = (double) f;
        }

        public double getCs() {
            return this.cs;
        }

        public void setCs(float f) {
            this.cs = (double) f;
        }

        public double getCe() {
            return this.ce;
        }

        public void setCe(float f) {
            this.ce = (double) f;
        }

        public double getScs() {
            return this.scs;
        }

        public void setScs(float f) {
            this.scs = (double) f;
        }

        public double getReqs() {
            return this.reqs;
        }

        public void setReqs(float f) {
            this.reqs = (double) f;
        }

        public double getRsps() {
            return this.rsps;
        }

        public void setRsps(float f) {
            this.rsps = (double) f;
        }

        public double getRspe() {
            return this.rspe;
        }

        public void setRspe(float f) {
            this.rspe = (double) f;
        }

        public int getTs() {
            return this.ts;
        }

        public void setTs(int i) {
            this.ts = i;
        }

        public int getEns() {
            return this.ens;
        }

        public void setEns(int i) {
            this.ens = i;
        }

        public int getDes() {
            return this.des;
        }

        public void setDes(int i) {
            this.des = i;
        }

        public String getPr() {
            return this.pr;
        }

        public void setPr(String str) {
            this.pr = str;
        }
    }
}
