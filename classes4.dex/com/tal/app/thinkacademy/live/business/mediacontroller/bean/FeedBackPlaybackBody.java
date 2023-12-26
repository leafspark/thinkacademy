package com.tal.app.thinkacademy.live.business.mediacontroller.bean;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003JU\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006."}, d2 = {"Lcom/tal/app/thinkacademy/live/business/mediacontroller/bean/FeedBackPlaybackBody;", "", "type", "", "screenshot", "", "planId", "", "classId", "describe", "nickName", "ext", "(ILjava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClassId", "()J", "setClassId", "(J)V", "getDescribe", "()Ljava/lang/String;", "setDescribe", "(Ljava/lang/String;)V", "getExt", "setExt", "getNickName", "setNickName", "getPlanId", "setPlanId", "getScreenshot", "setScreenshot", "getType", "()I", "setType", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBackPlaybackBody.kt */
public final class FeedBackPlaybackBody {
    private long classId;
    private String describe;
    private String ext;
    private String nickName;
    private long planId;
    private String screenshot;
    private int type;

    public FeedBackPlaybackBody() {
        this(0, (String) null, 0, 0, (String) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FeedBackPlaybackBody copy$default(FeedBackPlaybackBody feedBackPlaybackBody, int i, String str, long j, long j2, String str2, String str3, String str4, int i2, Object obj) {
        FeedBackPlaybackBody feedBackPlaybackBody2 = feedBackPlaybackBody;
        return feedBackPlaybackBody.copy((i2 & 1) != 0 ? feedBackPlaybackBody2.type : i, (i2 & 2) != 0 ? feedBackPlaybackBody2.screenshot : str, (i2 & 4) != 0 ? feedBackPlaybackBody2.planId : j, (i2 & 8) != 0 ? feedBackPlaybackBody2.classId : j2, (i2 & 16) != 0 ? feedBackPlaybackBody2.describe : str2, (i2 & 32) != 0 ? feedBackPlaybackBody2.nickName : str3, (i2 & 64) != 0 ? feedBackPlaybackBody2.ext : str4);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.screenshot;
    }

    public final long component3() {
        return this.planId;
    }

    public final long component4() {
        return this.classId;
    }

    public final String component5() {
        return this.describe;
    }

    public final String component6() {
        return this.nickName;
    }

    public final String component7() {
        return this.ext;
    }

    public final FeedBackPlaybackBody copy(int i, String str, long j, long j2, String str2, String str3, String str4) {
        String str5 = str3;
        Intrinsics.checkNotNullParameter(str5, "nickName");
        return new FeedBackPlaybackBody(i, str, j, j2, str2, str5, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedBackPlaybackBody)) {
            return false;
        }
        FeedBackPlaybackBody feedBackPlaybackBody = (FeedBackPlaybackBody) obj;
        return this.type == feedBackPlaybackBody.type && Intrinsics.areEqual(this.screenshot, feedBackPlaybackBody.screenshot) && this.planId == feedBackPlaybackBody.planId && this.classId == feedBackPlaybackBody.classId && Intrinsics.areEqual(this.describe, feedBackPlaybackBody.describe) && Intrinsics.areEqual(this.nickName, feedBackPlaybackBody.nickName) && Intrinsics.areEqual(this.ext, feedBackPlaybackBody.ext);
    }

    public int hashCode() {
        int i = this.type * 31;
        String str = this.screenshot;
        int i2 = 0;
        int hashCode = (((((i + (str == null ? 0 : str.hashCode())) * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.planId)) * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.classId)) * 31;
        String str2 = this.describe;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.nickName.hashCode()) * 31;
        String str3 = this.ext;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "FeedBackPlaybackBody(type=" + this.type + ", screenshot=" + this.screenshot + ", planId=" + this.planId + ", classId=" + this.classId + ", describe=" + this.describe + ", nickName=" + this.nickName + ", ext=" + this.ext + ')';
    }

    public FeedBackPlaybackBody(int i, String str, long j, long j2, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str3, "nickName");
        this.type = i;
        this.screenshot = str;
        this.planId = j;
        this.classId = j2;
        this.describe = str2;
        this.nickName = str3;
        this.ext = str4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FeedBackPlaybackBody(int r11, java.lang.String r12, long r13, long r15, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20 & 1
            if (r0 == 0) goto L_0x0006
            r0 = 0
            goto L_0x0007
        L_0x0006:
            r0 = r11
        L_0x0007:
            r1 = r20 & 2
            r2 = 0
            if (r1 == 0) goto L_0x000e
            r1 = r2
            goto L_0x000f
        L_0x000e:
            r1 = r12
        L_0x000f:
            r3 = r20 & 4
            r4 = 0
            if (r3 == 0) goto L_0x0017
            r6 = r4
            goto L_0x0018
        L_0x0017:
            r6 = r13
        L_0x0018:
            r3 = r20 & 8
            if (r3 == 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r4 = r15
        L_0x001e:
            r3 = r20 & 16
            if (r3 == 0) goto L_0x0024
            r3 = r2
            goto L_0x0026
        L_0x0024:
            r3 = r17
        L_0x0026:
            r8 = r20 & 32
            if (r8 == 0) goto L_0x002d
            java.lang.String r8 = ""
            goto L_0x002f
        L_0x002d:
            r8 = r18
        L_0x002f:
            r9 = r20 & 64
            if (r9 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r2 = r19
        L_0x0036:
            r11 = r10
            r12 = r0
            r13 = r1
            r14 = r6
            r16 = r4
            r18 = r3
            r19 = r8
            r20 = r2
            r11.<init>(r12, r13, r14, r16, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.mediacontroller.bean.FeedBackPlaybackBody.<init>(int, java.lang.String, long, long, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final String getScreenshot() {
        return this.screenshot;
    }

    public final void setScreenshot(String str) {
        this.screenshot = str;
    }

    public final long getPlanId() {
        return this.planId;
    }

    public final void setPlanId(long j) {
        this.planId = j;
    }

    public final long getClassId() {
        return this.classId;
    }

    public final void setClassId(long j) {
        this.classId = j;
    }

    public final String getDescribe() {
        return this.describe;
    }

    public final void setDescribe(String str) {
        this.describe = str;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final void setNickName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nickName = str;
    }

    public final String getExt() {
        return this.ext;
    }

    public final void setExt(String str) {
        this.ext = str;
    }
}
