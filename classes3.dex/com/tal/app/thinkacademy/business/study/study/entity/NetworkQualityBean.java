package com.tal.app.thinkacademy.business.study.study.entity;

import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/NetworkQualityBean;", "", "avgRoundTrip", "", "avgSuccRate", "reqTimes", "result", "", "(IIILjava/lang/String;)V", "getAvgRoundTrip", "()I", "setAvgRoundTrip", "(I)V", "getAvgSuccRate", "setAvgSuccRate", "getReqTimes", "setReqTimes", "getResult", "()Ljava/lang/String;", "setResult", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetworkQualityBean.kt */
public final class NetworkQualityBean {
    private int avgRoundTrip;
    private int avgSuccRate;
    private int reqTimes;
    private String result;

    public static /* synthetic */ NetworkQualityBean copy$default(NetworkQualityBean networkQualityBean, int i, int i2, int i3, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = networkQualityBean.avgRoundTrip;
        }
        if ((i4 & 2) != 0) {
            i2 = networkQualityBean.avgSuccRate;
        }
        if ((i4 & 4) != 0) {
            i3 = networkQualityBean.reqTimes;
        }
        if ((i4 & 8) != 0) {
            str = networkQualityBean.result;
        }
        return networkQualityBean.copy(i, i2, i3, str);
    }

    public final int component1() {
        return this.avgRoundTrip;
    }

    public final int component2() {
        return this.avgSuccRate;
    }

    public final int component3() {
        return this.reqTimes;
    }

    public final String component4() {
        return this.result;
    }

    public final NetworkQualityBean copy(int i, int i2, int i3, String str) {
        Intrinsics.checkNotNullParameter(str, DbParams.KEY_CHANNEL_RESULT);
        return new NetworkQualityBean(i, i2, i3, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkQualityBean)) {
            return false;
        }
        NetworkQualityBean networkQualityBean = (NetworkQualityBean) obj;
        return this.avgRoundTrip == networkQualityBean.avgRoundTrip && this.avgSuccRate == networkQualityBean.avgSuccRate && this.reqTimes == networkQualityBean.reqTimes && Intrinsics.areEqual((Object) this.result, (Object) networkQualityBean.result);
    }

    public int hashCode() {
        return (((((this.avgRoundTrip * 31) + this.avgSuccRate) * 31) + this.reqTimes) * 31) + this.result.hashCode();
    }

    public String toString() {
        return "NetworkQualityBean(avgRoundTrip=" + this.avgRoundTrip + ", avgSuccRate=" + this.avgSuccRate + ", reqTimes=" + this.reqTimes + ", result=" + this.result + ')';
    }

    public NetworkQualityBean(int i, int i2, int i3, String str) {
        Intrinsics.checkNotNullParameter(str, DbParams.KEY_CHANNEL_RESULT);
        this.avgRoundTrip = i;
        this.avgSuccRate = i2;
        this.reqTimes = i3;
        this.result = str;
    }

    public final int getAvgRoundTrip() {
        return this.avgRoundTrip;
    }

    public final int getAvgSuccRate() {
        return this.avgSuccRate;
    }

    public final int getReqTimes() {
        return this.reqTimes;
    }

    public final String getResult() {
        return this.result;
    }

    public final void setAvgRoundTrip(int i) {
        this.avgRoundTrip = i;
    }

    public final void setAvgSuccRate(int i) {
        this.avgSuccRate = i;
    }

    public final void setReqTimes(int i) {
        this.reqTimes = i;
    }

    public final void setResult(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.result = str;
    }
}
