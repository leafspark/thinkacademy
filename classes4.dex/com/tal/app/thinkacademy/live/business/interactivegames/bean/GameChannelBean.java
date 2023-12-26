package com.tal.app.thinkacademy.live.business.interactivegames.bean;

import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0010J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012¨\u00064"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameChannelBean;", "Ljava/io/Serializable;", "pub", "", "interactId", "", "planId", "coin", "totalCoin", "gameNumber", "teacherId", "teacherType", "currentTime", "interactiveTemplatePath", "pageId", "pageTitle", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCoin", "()Ljava/lang/String;", "getCurrentTime", "getGameNumber", "getInteractId", "getInteractiveTemplatePath", "getPageId", "getPageTitle", "getPlanId", "getPub", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTeacherId", "getTeacherType", "getTotalCoin", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameChannelBean;", "equals", "other", "", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameChannelBean.kt */
public final class GameChannelBean implements Serializable {
    private final String coin;
    private final String currentTime;
    private final String gameNumber;
    private final String interactId;
    private final String interactiveTemplatePath;
    private final String pageId;
    private final String pageTitle;
    private final String planId;
    private final Boolean pub;
    private final String teacherId;
    private final String teacherType;
    private final String totalCoin;

    public GameChannelBean() {
        this((Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 4095, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GameChannelBean copy$default(GameChannelBean gameChannelBean, Boolean bool, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, Object obj) {
        GameChannelBean gameChannelBean2 = gameChannelBean;
        int i2 = i;
        return gameChannelBean.copy((i2 & 1) != 0 ? gameChannelBean2.pub : bool, (i2 & 2) != 0 ? gameChannelBean2.interactId : str, (i2 & 4) != 0 ? gameChannelBean2.planId : str2, (i2 & 8) != 0 ? gameChannelBean2.coin : str3, (i2 & 16) != 0 ? gameChannelBean2.totalCoin : str4, (i2 & 32) != 0 ? gameChannelBean2.gameNumber : str5, (i2 & 64) != 0 ? gameChannelBean2.teacherId : str6, (i2 & LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP) != 0 ? gameChannelBean2.teacherType : str7, (i2 & 256) != 0 ? gameChannelBean2.currentTime : str8, (i2 & 512) != 0 ? gameChannelBean2.interactiveTemplatePath : str9, (i2 & 1024) != 0 ? gameChannelBean2.pageId : str10, (i2 & 2048) != 0 ? gameChannelBean2.pageTitle : str11);
    }

    public final Boolean component1() {
        return this.pub;
    }

    public final String component10() {
        return this.interactiveTemplatePath;
    }

    public final String component11() {
        return this.pageId;
    }

    public final String component12() {
        return this.pageTitle;
    }

    public final String component2() {
        return this.interactId;
    }

    public final String component3() {
        return this.planId;
    }

    public final String component4() {
        return this.coin;
    }

    public final String component5() {
        return this.totalCoin;
    }

    public final String component6() {
        return this.gameNumber;
    }

    public final String component7() {
        return this.teacherId;
    }

    public final String component8() {
        return this.teacherType;
    }

    public final String component9() {
        return this.currentTime;
    }

    public final GameChannelBean copy(Boolean bool, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        return new GameChannelBean(bool, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GameChannelBean)) {
            return false;
        }
        GameChannelBean gameChannelBean = (GameChannelBean) obj;
        return Intrinsics.areEqual(this.pub, gameChannelBean.pub) && Intrinsics.areEqual(this.interactId, gameChannelBean.interactId) && Intrinsics.areEqual(this.planId, gameChannelBean.planId) && Intrinsics.areEqual(this.coin, gameChannelBean.coin) && Intrinsics.areEqual(this.totalCoin, gameChannelBean.totalCoin) && Intrinsics.areEqual(this.gameNumber, gameChannelBean.gameNumber) && Intrinsics.areEqual(this.teacherId, gameChannelBean.teacherId) && Intrinsics.areEqual(this.teacherType, gameChannelBean.teacherType) && Intrinsics.areEqual(this.currentTime, gameChannelBean.currentTime) && Intrinsics.areEqual(this.interactiveTemplatePath, gameChannelBean.interactiveTemplatePath) && Intrinsics.areEqual(this.pageId, gameChannelBean.pageId) && Intrinsics.areEqual(this.pageTitle, gameChannelBean.pageTitle);
    }

    public int hashCode() {
        Boolean bool = this.pub;
        int i = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.interactId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.planId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.coin;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.totalCoin;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.gameNumber;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.teacherId;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.teacherType;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.currentTime;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.interactiveTemplatePath;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.pageId;
        int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.pageTitle;
        if (str11 != null) {
            i = str11.hashCode();
        }
        return hashCode11 + i;
    }

    public String toString() {
        return "GameChannelBean(pub=" + this.pub + ", interactId=" + this.interactId + ", planId=" + this.planId + ", coin=" + this.coin + ", totalCoin=" + this.totalCoin + ", gameNumber=" + this.gameNumber + ", teacherId=" + this.teacherId + ", teacherType=" + this.teacherType + ", currentTime=" + this.currentTime + ", interactiveTemplatePath=" + this.interactiveTemplatePath + ", pageId=" + this.pageId + ", pageTitle=" + this.pageTitle + ')';
    }

    public GameChannelBean(Boolean bool, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.pub = bool;
        this.interactId = str;
        this.planId = str2;
        this.coin = str3;
        this.totalCoin = str4;
        this.gameNumber = str5;
        this.teacherId = str6;
        this.teacherType = str7;
        this.currentTime = str8;
        this.interactiveTemplatePath = str9;
        this.pageId = str10;
        this.pageTitle = str11;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GameChannelBean(java.lang.Boolean r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            r1 = 0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x000d
        L_0x000c:
            r1 = r14
        L_0x000d:
            r2 = r0 & 2
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x0015
            r2 = r3
            goto L_0x0016
        L_0x0015:
            r2 = r15
        L_0x0016:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001c
            r4 = r3
            goto L_0x001e
        L_0x001c:
            r4 = r16
        L_0x001e:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0024
            r5 = r3
            goto L_0x0026
        L_0x0024:
            r5 = r17
        L_0x0026:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002c
            r6 = r3
            goto L_0x002e
        L_0x002c:
            r6 = r18
        L_0x002e:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0034
            r7 = r3
            goto L_0x0036
        L_0x0034:
            r7 = r19
        L_0x0036:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003c
            r8 = r3
            goto L_0x003e
        L_0x003c:
            r8 = r20
        L_0x003e:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0044
            r9 = r3
            goto L_0x0046
        L_0x0044:
            r9 = r21
        L_0x0046:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004c
            r10 = r3
            goto L_0x004e
        L_0x004c:
            r10 = r22
        L_0x004e:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0054
            r11 = r3
            goto L_0x0056
        L_0x0054:
            r11 = r23
        L_0x0056:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x005c
            r12 = r3
            goto L_0x005e
        L_0x005c:
            r12 = r24
        L_0x005e:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0063
            goto L_0x0065
        L_0x0063:
            r3 = r25
        L_0x0065:
            r14 = r13
            r15 = r1
            r16 = r2
            r17 = r4
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r3
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.interactivegames.bean.GameChannelBean.<init>(java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Boolean getPub() {
        return this.pub;
    }

    public final String getInteractId() {
        return this.interactId;
    }

    public final String getPlanId() {
        return this.planId;
    }

    public final String getCoin() {
        return this.coin;
    }

    public final String getTotalCoin() {
        return this.totalCoin;
    }

    public final String getGameNumber() {
        return this.gameNumber;
    }

    public final String getTeacherId() {
        return this.teacherId;
    }

    public final String getTeacherType() {
        return this.teacherType;
    }

    public final String getCurrentTime() {
        return this.currentTime;
    }

    public final String getInteractiveTemplatePath() {
        return this.interactiveTemplatePath;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getPageTitle() {
        return this.pageTitle;
    }
}
