package com.tal.app.thinkacademy.live.abilitypack.playback.bean;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\tHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006!"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/playback/bean/CourseWarePointBean;", "", "ircType", "", "pageId", "beginTime", "", "ircMsg", "blackBoardType", "", "specificLiveKey", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;)V", "getBeginTime", "()J", "getBlackBoardType", "()I", "getIrcMsg", "()Ljava/lang/String;", "getIrcType", "getPageId", "getSpecificLiveKey", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CourseWarePointBean.kt */
public final class CourseWarePointBean {
    private final long beginTime;
    private final int blackBoardType;
    private final String ircMsg;
    private final String ircType;
    private final String pageId;
    private final String specificLiveKey;

    public static /* synthetic */ CourseWarePointBean copy$default(CourseWarePointBean courseWarePointBean, String str, String str2, long j, String str3, int i, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = courseWarePointBean.ircType;
        }
        if ((i2 & 2) != 0) {
            str2 = courseWarePointBean.pageId;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            j = courseWarePointBean.beginTime;
        }
        long j2 = j;
        if ((i2 & 8) != 0) {
            str3 = courseWarePointBean.ircMsg;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            i = courseWarePointBean.blackBoardType;
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            str4 = courseWarePointBean.specificLiveKey;
        }
        return courseWarePointBean.copy(str, str5, j2, str6, i3, str4);
    }

    public final String component1() {
        return this.ircType;
    }

    public final String component2() {
        return this.pageId;
    }

    public final long component3() {
        return this.beginTime;
    }

    public final String component4() {
        return this.ircMsg;
    }

    public final int component5() {
        return this.blackBoardType;
    }

    public final String component6() {
        return this.specificLiveKey;
    }

    public final CourseWarePointBean copy(String str, String str2, long j, String str3, int i, String str4) {
        Intrinsics.checkNotNullParameter(str, "ircType");
        Intrinsics.checkNotNullParameter(str2, "pageId");
        Intrinsics.checkNotNullParameter(str3, "ircMsg");
        String str5 = str4;
        Intrinsics.checkNotNullParameter(str5, "specificLiveKey");
        return new CourseWarePointBean(str, str2, j, str3, i, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CourseWarePointBean)) {
            return false;
        }
        CourseWarePointBean courseWarePointBean = (CourseWarePointBean) obj;
        return Intrinsics.areEqual(this.ircType, courseWarePointBean.ircType) && Intrinsics.areEqual(this.pageId, courseWarePointBean.pageId) && this.beginTime == courseWarePointBean.beginTime && Intrinsics.areEqual(this.ircMsg, courseWarePointBean.ircMsg) && this.blackBoardType == courseWarePointBean.blackBoardType && Intrinsics.areEqual(this.specificLiveKey, courseWarePointBean.specificLiveKey);
    }

    public int hashCode() {
        return (((((((((this.ircType.hashCode() * 31) + this.pageId.hashCode()) * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.beginTime)) * 31) + this.ircMsg.hashCode()) * 31) + this.blackBoardType) * 31) + this.specificLiveKey.hashCode();
    }

    public String toString() {
        return "CourseWarePointBean(ircType=" + this.ircType + ", pageId=" + this.pageId + ", beginTime=" + this.beginTime + ", ircMsg=" + this.ircMsg + ", blackBoardType=" + this.blackBoardType + ", specificLiveKey=" + this.specificLiveKey + ')';
    }

    public CourseWarePointBean(String str, String str2, long j, String str3, int i, String str4) {
        Intrinsics.checkNotNullParameter(str, "ircType");
        Intrinsics.checkNotNullParameter(str2, "pageId");
        Intrinsics.checkNotNullParameter(str3, "ircMsg");
        Intrinsics.checkNotNullParameter(str4, "specificLiveKey");
        this.ircType = str;
        this.pageId = str2;
        this.beginTime = j;
        this.ircMsg = str3;
        this.blackBoardType = i;
        this.specificLiveKey = str4;
    }

    public final String getIrcType() {
        return this.ircType;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final long getBeginTime() {
        return this.beginTime;
    }

    public final String getIrcMsg() {
        return this.ircMsg;
    }

    public final int getBlackBoardType() {
        return this.blackBoardType;
    }

    public final String getSpecificLiveKey() {
        return this.specificLiveKey;
    }
}
