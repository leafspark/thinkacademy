package com.tal.app.thinkacademy.live.core.live.bean;

import com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/live/bean/ReportDeviceBody;", "", "planId", "", "ircName", "ircChannel", "reportChannel", "extra", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExtra", "()Ljava/lang/String;", "getIrcChannel", "getIrcName", "getPlanId", "getReportChannel", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReportDeviceBody.kt */
public final class ReportDeviceBody {
    private final String extra;
    private final String ircChannel;
    private final String ircName;
    private final String planId;
    private final String reportChannel;

    public static /* synthetic */ ReportDeviceBody copy$default(ReportDeviceBody reportDeviceBody, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reportDeviceBody.planId;
        }
        if ((i & 2) != 0) {
            str2 = reportDeviceBody.ircName;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = reportDeviceBody.ircChannel;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = reportDeviceBody.reportChannel;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = reportDeviceBody.extra;
        }
        return reportDeviceBody.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.planId;
    }

    public final String component2() {
        return this.ircName;
    }

    public final String component3() {
        return this.ircChannel;
    }

    public final String component4() {
        return this.reportChannel;
    }

    public final String component5() {
        return this.extra;
    }

    public final ReportDeviceBody copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.PLANID);
        return new ReportDeviceBody(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReportDeviceBody)) {
            return false;
        }
        ReportDeviceBody reportDeviceBody = (ReportDeviceBody) obj;
        return Intrinsics.areEqual((Object) this.planId, (Object) reportDeviceBody.planId) && Intrinsics.areEqual((Object) this.ircName, (Object) reportDeviceBody.ircName) && Intrinsics.areEqual((Object) this.ircChannel, (Object) reportDeviceBody.ircChannel) && Intrinsics.areEqual((Object) this.reportChannel, (Object) reportDeviceBody.reportChannel) && Intrinsics.areEqual((Object) this.extra, (Object) reportDeviceBody.extra);
    }

    public int hashCode() {
        int hashCode = this.planId.hashCode() * 31;
        String str = this.ircName;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.ircChannel;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.reportChannel;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.extra;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "ReportDeviceBody(planId=" + this.planId + ", ircName=" + this.ircName + ", ircChannel=" + this.ircChannel + ", reportChannel=" + this.reportChannel + ", extra=" + this.extra + ')';
    }

    public ReportDeviceBody(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.PLANID);
        this.planId = str;
        this.ircName = str2;
        this.ircChannel = str3;
        this.reportChannel = str4;
        this.extra = str5;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReportDeviceBody(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    public final String getPlanId() {
        return this.planId;
    }

    public final String getIrcName() {
        return this.ircName;
    }

    public final String getIrcChannel() {
        return this.ircChannel;
    }

    public final String getReportChannel() {
        return this.reportChannel;
    }

    public final String getExtra() {
        return this.extra;
    }
}
