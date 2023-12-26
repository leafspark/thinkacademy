package com.tal.app.thinkacademy.live.business.groupvideocall;

import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b;\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BÛ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0017J\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u00108\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u00109\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010:\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010;\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\t\u0010B\u001a\u00020\u0007HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJä\u0001\u0010H\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010IJ\u0013\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010M\u001a\u00020\u0003HÖ\u0001J\t\u0010N\u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010#R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010#R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u0002\u0010\u001d\"\u0004\b&\u0010#R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010#R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b)\u0010\u001dR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010#R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b,\u0010\u001d\"\u0004\b-\u0010#R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b/\u0010\u0019R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b0\u0010\u0019R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010#R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b3\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b4\u0010 R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b5\u0010 ¨\u0006O"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/groupvideocall/VideoCallBean;", "", "isAuthorize", "", "cameraIsOpen", "micIsOpen", "userId", "", "nickName", "userName", "avatar", "addCoin", "totalCoin", "level", "originXRatio", "", "originYRatio", "WRatio", "HRatio", "cameraIsInit", "micIsInit", "layerIndex", "positionIndex", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHRatio", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getWRatio", "getAddCoin", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAvatar", "()Ljava/lang/String;", "getCameraIsInit", "setCameraIsInit", "(Ljava/lang/Integer;)V", "getCameraIsOpen", "setCameraIsOpen", "setAuthorize", "getLayerIndex", "setLayerIndex", "getLevel", "getMicIsInit", "setMicIsInit", "getMicIsOpen", "setMicIsOpen", "getNickName", "getOriginXRatio", "getOriginYRatio", "getPositionIndex", "setPositionIndex", "getTotalCoin", "getUserId", "getUserName", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/live/business/groupvideocall/VideoCallBean;", "equals", "", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GroupVideoCallBean.kt */
public final class VideoCallBean {
    private final Float HRatio;
    private final Float WRatio;
    private final Integer addCoin;
    private final String avatar;
    private Integer cameraIsInit;
    private Integer cameraIsOpen;
    private Integer isAuthorize;
    private Integer layerIndex;
    private final Integer level;
    private Integer micIsInit;
    private Integer micIsOpen;
    private final String nickName;
    private final Float originXRatio;
    private final Float originYRatio;
    private Integer positionIndex;
    private final Integer totalCoin;
    private final String userId;
    private final String userName;

    public VideoCallBean() {
        this((Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Float) null, (Float) null, (Float) null, (Float) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 262143, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ VideoCallBean copy$default(VideoCallBean videoCallBean, Integer num, Integer num2, Integer num3, String str, String str2, String str3, String str4, Integer num4, Integer num5, Integer num6, Float f, Float f2, Float f3, Float f4, Integer num7, Integer num8, Integer num9, Integer num10, int i, Object obj) {
        VideoCallBean videoCallBean2 = videoCallBean;
        int i2 = i;
        return videoCallBean.copy((i2 & 1) != 0 ? videoCallBean2.isAuthorize : num, (i2 & 2) != 0 ? videoCallBean2.cameraIsOpen : num2, (i2 & 4) != 0 ? videoCallBean2.micIsOpen : num3, (i2 & 8) != 0 ? videoCallBean2.userId : str, (i2 & 16) != 0 ? videoCallBean2.nickName : str2, (i2 & 32) != 0 ? videoCallBean2.userName : str3, (i2 & 64) != 0 ? videoCallBean2.avatar : str4, (i2 & LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP) != 0 ? videoCallBean2.addCoin : num4, (i2 & 256) != 0 ? videoCallBean2.totalCoin : num5, (i2 & 512) != 0 ? videoCallBean2.level : num6, (i2 & 1024) != 0 ? videoCallBean2.originXRatio : f, (i2 & 2048) != 0 ? videoCallBean2.originYRatio : f2, (i2 & 4096) != 0 ? videoCallBean2.WRatio : f3, (i2 & 8192) != 0 ? videoCallBean2.HRatio : f4, (i2 & 16384) != 0 ? videoCallBean2.cameraIsInit : num7, (i2 & 32768) != 0 ? videoCallBean2.micIsInit : num8, (i2 & 65536) != 0 ? videoCallBean2.layerIndex : num9, (i2 & 131072) != 0 ? videoCallBean2.positionIndex : num10);
    }

    public final Integer component1() {
        return this.isAuthorize;
    }

    public final Integer component10() {
        return this.level;
    }

    public final Float component11() {
        return this.originXRatio;
    }

    public final Float component12() {
        return this.originYRatio;
    }

    public final Float component13() {
        return this.WRatio;
    }

    public final Float component14() {
        return this.HRatio;
    }

    public final Integer component15() {
        return this.cameraIsInit;
    }

    public final Integer component16() {
        return this.micIsInit;
    }

    public final Integer component17() {
        return this.layerIndex;
    }

    public final Integer component18() {
        return this.positionIndex;
    }

    public final Integer component2() {
        return this.cameraIsOpen;
    }

    public final Integer component3() {
        return this.micIsOpen;
    }

    public final String component4() {
        return this.userId;
    }

    public final String component5() {
        return this.nickName;
    }

    public final String component6() {
        return this.userName;
    }

    public final String component7() {
        return this.avatar;
    }

    public final Integer component8() {
        return this.addCoin;
    }

    public final Integer component9() {
        return this.totalCoin;
    }

    public final VideoCallBean copy(Integer num, Integer num2, Integer num3, String str, String str2, String str3, String str4, Integer num4, Integer num5, Integer num6, Float f, Float f2, Float f3, Float f4, Integer num7, Integer num8, Integer num9, Integer num10) {
        Integer num11 = num;
        Intrinsics.checkNotNullParameter(str, "userId");
        return new VideoCallBean(num, num2, num3, str, str2, str3, str4, num4, num5, num6, f, f2, f3, f4, num7, num8, num9, num10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoCallBean)) {
            return false;
        }
        VideoCallBean videoCallBean = (VideoCallBean) obj;
        return Intrinsics.areEqual(this.isAuthorize, videoCallBean.isAuthorize) && Intrinsics.areEqual(this.cameraIsOpen, videoCallBean.cameraIsOpen) && Intrinsics.areEqual(this.micIsOpen, videoCallBean.micIsOpen) && Intrinsics.areEqual(this.userId, videoCallBean.userId) && Intrinsics.areEqual(this.nickName, videoCallBean.nickName) && Intrinsics.areEqual(this.userName, videoCallBean.userName) && Intrinsics.areEqual(this.avatar, videoCallBean.avatar) && Intrinsics.areEqual(this.addCoin, videoCallBean.addCoin) && Intrinsics.areEqual(this.totalCoin, videoCallBean.totalCoin) && Intrinsics.areEqual(this.level, videoCallBean.level) && Intrinsics.areEqual(this.originXRatio, videoCallBean.originXRatio) && Intrinsics.areEqual(this.originYRatio, videoCallBean.originYRatio) && Intrinsics.areEqual(this.WRatio, videoCallBean.WRatio) && Intrinsics.areEqual(this.HRatio, videoCallBean.HRatio) && Intrinsics.areEqual(this.cameraIsInit, videoCallBean.cameraIsInit) && Intrinsics.areEqual(this.micIsInit, videoCallBean.micIsInit) && Intrinsics.areEqual(this.layerIndex, videoCallBean.layerIndex) && Intrinsics.areEqual(this.positionIndex, videoCallBean.positionIndex);
    }

    public int hashCode() {
        Integer num = this.isAuthorize;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.cameraIsOpen;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.micIsOpen;
        int hashCode3 = (((hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31) + this.userId.hashCode()) * 31;
        String str = this.nickName;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.userName;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.avatar;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num4 = this.addCoin;
        int hashCode7 = (hashCode6 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.totalCoin;
        int hashCode8 = (hashCode7 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.level;
        int hashCode9 = (hashCode8 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Float f = this.originXRatio;
        int hashCode10 = (hashCode9 + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.originYRatio;
        int hashCode11 = (hashCode10 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.WRatio;
        int hashCode12 = (hashCode11 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Float f4 = this.HRatio;
        int hashCode13 = (hashCode12 + (f4 == null ? 0 : f4.hashCode())) * 31;
        Integer num7 = this.cameraIsInit;
        int hashCode14 = (hashCode13 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.micIsInit;
        int hashCode15 = (hashCode14 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.layerIndex;
        int hashCode16 = (hashCode15 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Integer num10 = this.positionIndex;
        if (num10 != null) {
            i = num10.hashCode();
        }
        return hashCode16 + i;
    }

    public String toString() {
        return "VideoCallBean(isAuthorize=" + this.isAuthorize + ", cameraIsOpen=" + this.cameraIsOpen + ", micIsOpen=" + this.micIsOpen + ", userId=" + this.userId + ", nickName=" + this.nickName + ", userName=" + this.userName + ", avatar=" + this.avatar + ", addCoin=" + this.addCoin + ", totalCoin=" + this.totalCoin + ", level=" + this.level + ", originXRatio=" + this.originXRatio + ", originYRatio=" + this.originYRatio + ", WRatio=" + this.WRatio + ", HRatio=" + this.HRatio + ", cameraIsInit=" + this.cameraIsInit + ", micIsInit=" + this.micIsInit + ", layerIndex=" + this.layerIndex + ", positionIndex=" + this.positionIndex + ')';
    }

    public VideoCallBean(Integer num, Integer num2, Integer num3, String str, String str2, String str3, String str4, Integer num4, Integer num5, Integer num6, Float f, Float f2, Float f3, Float f4, Integer num7, Integer num8, Integer num9, Integer num10) {
        Intrinsics.checkNotNullParameter(str, "userId");
        this.isAuthorize = num;
        this.cameraIsOpen = num2;
        this.micIsOpen = num3;
        this.userId = str;
        this.nickName = str2;
        this.userName = str3;
        this.avatar = str4;
        this.addCoin = num4;
        this.totalCoin = num5;
        this.level = num6;
        this.originXRatio = f;
        this.originYRatio = f2;
        this.WRatio = f3;
        this.HRatio = f4;
        this.cameraIsInit = num7;
        this.micIsInit = num8;
        this.layerIndex = num9;
        this.positionIndex = num10;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VideoCallBean(java.lang.Integer r21, java.lang.Integer r22, java.lang.Integer r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.Integer r28, java.lang.Integer r29, java.lang.Integer r30, java.lang.Float r31, java.lang.Float r32, java.lang.Float r33, java.lang.Float r34, java.lang.Integer r35, java.lang.Integer r36, java.lang.Integer r37, java.lang.Integer r38, int r39, kotlin.jvm.internal.DefaultConstructorMarker r40) {
        /*
            r20 = this;
            r0 = r39
            r1 = r0 & 1
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            if (r1 == 0) goto L_0x000d
            r1 = r2
            goto L_0x000f
        L_0x000d:
            r1 = r21
        L_0x000f:
            r3 = r0 & 2
            r4 = 1
            if (r3 == 0) goto L_0x0019
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            goto L_0x001b
        L_0x0019:
            r3 = r22
        L_0x001b:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0024
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            goto L_0x0026
        L_0x0024:
            r5 = r23
        L_0x0026:
            r6 = r0 & 8
            java.lang.String r7 = ""
            if (r6 == 0) goto L_0x002e
            r6 = r7
            goto L_0x0030
        L_0x002e:
            r6 = r24
        L_0x0030:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0036
            r8 = r7
            goto L_0x0038
        L_0x0036:
            r8 = r25
        L_0x0038:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003e
            r9 = r7
            goto L_0x0040
        L_0x003e:
            r9 = r26
        L_0x0040:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r7 = r27
        L_0x0047:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0051
            r10 = 5
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto L_0x0053
        L_0x0051:
            r10 = r28
        L_0x0053:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0059
            r11 = r2
            goto L_0x005b
        L_0x0059:
            r11 = r29
        L_0x005b:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            r2 = r30
        L_0x0062:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            r13 = 0
            if (r12 == 0) goto L_0x006c
            java.lang.Float r12 = java.lang.Float.valueOf(r13)
            goto L_0x006e
        L_0x006c:
            r12 = r31
        L_0x006e:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0077
            java.lang.Float r14 = java.lang.Float.valueOf(r13)
            goto L_0x0079
        L_0x0077:
            r14 = r32
        L_0x0079:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0082
            java.lang.Float r15 = java.lang.Float.valueOf(r13)
            goto L_0x0084
        L_0x0082:
            r15 = r33
        L_0x0084:
            r4 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r4 == 0) goto L_0x008d
            java.lang.Float r4 = java.lang.Float.valueOf(r13)
            goto L_0x008f
        L_0x008d:
            r4 = r34
        L_0x008f:
            r13 = r0 & 16384(0x4000, float:2.2959E-41)
            r16 = -1
            if (r13 == 0) goto L_0x009a
            java.lang.Integer r13 = java.lang.Integer.valueOf(r16)
            goto L_0x009c
        L_0x009a:
            r13 = r35
        L_0x009c:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x00a8
            java.lang.Integer r16 = java.lang.Integer.valueOf(r16)
            goto L_0x00aa
        L_0x00a8:
            r16 = r36
        L_0x00aa:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x00b7
            r17 = 1
            java.lang.Integer r18 = java.lang.Integer.valueOf(r17)
            goto L_0x00bb
        L_0x00b7:
            r17 = 1
            r18 = r37
        L_0x00bb:
            r19 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r19
            if (r0 == 0) goto L_0x00c6
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)
            goto L_0x00c8
        L_0x00c6:
            r0 = r38
        L_0x00c8:
            r21 = r20
            r22 = r1
            r23 = r3
            r24 = r5
            r25 = r6
            r26 = r8
            r27 = r9
            r28 = r7
            r29 = r10
            r30 = r11
            r31 = r2
            r32 = r12
            r33 = r14
            r34 = r15
            r35 = r4
            r36 = r13
            r37 = r16
            r38 = r18
            r39 = r0
            r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean.<init>(java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer isAuthorize() {
        return this.isAuthorize;
    }

    public final void setAuthorize(Integer num) {
        this.isAuthorize = num;
    }

    public final Integer getCameraIsOpen() {
        return this.cameraIsOpen;
    }

    public final void setCameraIsOpen(Integer num) {
        this.cameraIsOpen = num;
    }

    public final Integer getMicIsOpen() {
        return this.micIsOpen;
    }

    public final void setMicIsOpen(Integer num) {
        this.micIsOpen = num;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final Integer getAddCoin() {
        return this.addCoin;
    }

    public final Integer getTotalCoin() {
        return this.totalCoin;
    }

    public final Integer getLevel() {
        return this.level;
    }

    public final Float getOriginXRatio() {
        return this.originXRatio;
    }

    public final Float getOriginYRatio() {
        return this.originYRatio;
    }

    public final Float getWRatio() {
        return this.WRatio;
    }

    public final Float getHRatio() {
        return this.HRatio;
    }

    public final Integer getCameraIsInit() {
        return this.cameraIsInit;
    }

    public final void setCameraIsInit(Integer num) {
        this.cameraIsInit = num;
    }

    public final Integer getMicIsInit() {
        return this.micIsInit;
    }

    public final void setMicIsInit(Integer num) {
        this.micIsInit = num;
    }

    public final Integer getLayerIndex() {
        return this.layerIndex;
    }

    public final void setLayerIndex(Integer num) {
        this.layerIndex = num;
    }

    public final Integer getPositionIndex() {
        return this.positionIndex;
    }

    public final void setPositionIndex(Integer num) {
        this.positionIndex = num;
    }
}
