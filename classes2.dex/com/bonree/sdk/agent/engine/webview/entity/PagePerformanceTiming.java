package com.bonree.sdk.agent.engine.webview.entity;

import android.text.TextUtils;
import com.bonree.sdk.be.a;
import com.bonree.sdk.be.f;
import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.UUID;

public class PagePerformanceTiming {
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
    @SerializedName("fcp")
    public int fcp = 0;
    @SerializedName("fp")
    public int fp = 0;
    @SerializedName("fs")
    private int fs;
    @SerializedName("imd")
    private int imd;
    @SerializedName("lcp")
    public int lcp = 0;
    @SerializedName("lee")
    private int lee;
    @SerializedName("les")
    private int les;
    @SerializedName("ns")
    private long ns;
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

    public boolean isCustomFilter() {
        try {
            f a = a.a();
            if (!TextUtils.isEmpty(this.url)) {
                if (this.url.length() <= 2083) {
                    if (TextUtils.isEmpty(this.pvid) || this.pvid.length() > 256) {
                        this.pvid = UUID.randomUUID().toString();
                    }
                    long j = this.ns;
                    if (j < 0) {
                        j = 0;
                    }
                    this.ns = j;
                    int i = this.ues;
                    int i2 = -1;
                    if (i <= 0) {
                        i = -1;
                    }
                    this.ues = i;
                    int i3 = this.uee;
                    if (i3 <= 0) {
                        i3 = -1;
                    }
                    this.uee = i3;
                    int i4 = this.rds;
                    if (i4 <= 0) {
                        i4 = -1;
                    }
                    this.rds = i4;
                    int i5 = this.rde;
                    if (i5 <= 0) {
                        i5 = -1;
                    }
                    this.rde = i5;
                    int i6 = this.fs;
                    if (i6 < 0) {
                        i6 = 0;
                    }
                    this.fs = i6;
                    int i7 = this.dls;
                    if (i7 <= 0) {
                        i7 = -1;
                    }
                    this.dls = i7;
                    int i8 = this.dle;
                    if (i8 <= 0) {
                        i8 = -1;
                    }
                    this.dle = i8;
                    int i9 = this.cs;
                    if (i9 <= 0) {
                        i9 = -1;
                    }
                    this.cs = i9;
                    int i10 = this.scs;
                    if (i10 <= 0) {
                        i10 = -1;
                    }
                    this.scs = i10;
                    int i11 = this.ce;
                    if (i11 <= 0) {
                        i11 = -1;
                    }
                    this.ce = i11;
                    int i12 = this.reqs;
                    if (i12 < 0) {
                        i12 = 0;
                    }
                    this.reqs = i12;
                    int i13 = this.rsps;
                    if (i13 < 0) {
                        i13 = 0;
                    }
                    this.rsps = i13;
                    int i14 = this.rspe;
                    if (i14 < 0) {
                        i14 = 0;
                    }
                    this.rspe = i14;
                    int i15 = this.dl;
                    if (i15 < 0) {
                        i15 = 0;
                    }
                    this.dl = i15;
                    int i16 = this.di;
                    if (i16 < 0) {
                        i16 = 0;
                    }
                    this.di = i16;
                    int i17 = this.dcles;
                    if (i17 < 0) {
                        i17 = 0;
                    }
                    this.dcles = i17;
                    int i18 = this.dclee;
                    if (i18 < 0) {
                        i18 = 0;
                    }
                    this.dclee = i18;
                    int i19 = this.dc;
                    if (i19 < 0) {
                        i19 = 0;
                    }
                    this.dc = i19;
                    int i20 = this.les;
                    if (i20 < 0) {
                        i20 = 0;
                    }
                    this.les = i20;
                    int i21 = this.lee;
                    if (i21 <= 0) {
                        i21 = -1;
                    }
                    this.lee = i21;
                    int i22 = this.fp;
                    if (i22 <= 0) {
                        i22 = -1;
                    }
                    this.fp = i22;
                    int i23 = this.fcp;
                    if (i23 <= 0) {
                        i23 = -1;
                    }
                    this.fcp = i23;
                    int i24 = this.lcp;
                    if (i24 > 0) {
                        i2 = i24;
                    }
                    this.lcp = i2;
                    return false;
                }
            }
            Object[] objArr = new Object[2];
            String str = this.url;
            objArr[0] = str;
            objArr[1] = Integer.valueOf(str != null ? str.length() : 0);
            a.e("WebviewService CustomH5Performance isCustomFilter url is %s, url.length is %s.", objArr);
            return true;
        } catch (Exception e) {
            a.a().e("WebviewService CustomH5Performance isCustomFilter error %s.", e.getMessage());
            return true;
        }
    }

    public String getPvid() {
        return this.pvid;
    }

    public void setPvid(String str) {
        this.pvid = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public int getImd() {
        return this.imd;
    }

    public void setImd(int i) {
        this.imd = i;
    }

    public long getNs() {
        return this.ns;
    }

    public void setNs(long j) {
        this.ns = j;
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

    public int getScs() {
        return this.scs;
    }

    public void setScs(int i) {
        this.scs = i;
    }

    public int getCe() {
        return this.ce;
    }

    public void setCe(int i) {
        this.ce = i;
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

    public int getDl() {
        return this.dl;
    }

    public void setDl(int i) {
        this.dl = i;
    }

    public int getDi() {
        return this.di;
    }

    public void setDi(int i) {
        this.di = i;
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

    public int getDc() {
        return this.dc;
    }

    public void setDc(int i) {
        this.dc = i;
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

    public int getFp() {
        return this.fp;
    }

    public void setFp(int i) {
        this.fp = i;
    }

    public int getFcp() {
        return this.fcp;
    }

    public void setFcp(int i) {
        this.fcp = i;
    }

    public int getLcp() {
        return this.lcp;
    }

    public void setLcp(int i) {
        this.lcp = i;
    }

    public String toString() {
        return "PagePerformanceTiming{pvid='" + this.pvid + '\'' + ", url='" + this.url + '\'' + ", imd=" + this.imd + ", ns=" + this.ns + ", ues=" + this.ues + ", uee=" + this.uee + ", rds=" + this.rds + ", rde=" + this.rde + ", fs=" + this.fs + ", dls=" + this.dls + ", dle=" + this.dle + ", cs=" + this.cs + ", scs=" + this.scs + ", ce=" + this.ce + ", reqs=" + this.reqs + ", rsps=" + this.rsps + ", rspe=" + this.rspe + ", dl=" + this.dl + ", di=" + this.di + ", dcles=" + this.dcles + ", dclee=" + this.dclee + ", dc=" + this.dc + ", les=" + this.les + ", lee=" + this.lee + ", fp=" + this.fp + ", fcp=" + this.fcp + ", lcp=" + this.lcp + '}';
    }
}
