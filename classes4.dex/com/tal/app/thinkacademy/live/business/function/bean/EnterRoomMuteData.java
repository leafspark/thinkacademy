package com.tal.app.thinkacademy.live.business.function.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/function/bean/EnterRoomMuteData;", "", "enterRoomMute", "", "(Ljava/lang/String;)V", "getEnterRoomMute", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EnterRoomMuteData.kt */
public final class EnterRoomMuteData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String STATUS_MUTE = "1";
    public static final String STATUS_UN_MUTE = "0";
    private final String enterRoomMute;

    public static /* synthetic */ EnterRoomMuteData copy$default(EnterRoomMuteData enterRoomMuteData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = enterRoomMuteData.enterRoomMute;
        }
        return enterRoomMuteData.copy(str);
    }

    public final String component1() {
        return this.enterRoomMute;
    }

    public final EnterRoomMuteData copy(String str) {
        return new EnterRoomMuteData(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EnterRoomMuteData) && Intrinsics.areEqual(this.enterRoomMute, ((EnterRoomMuteData) obj).enterRoomMute);
    }

    public int hashCode() {
        String str = this.enterRoomMute;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "EnterRoomMuteData(enterRoomMute=" + this.enterRoomMute + ')';
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/function/bean/EnterRoomMuteData$Companion;", "", "()V", "STATUS_MUTE", "", "STATUS_UN_MUTE", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EnterRoomMuteData.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public EnterRoomMuteData(String str) {
        this.enterRoomMute = str;
    }

    public final String getEnterRoomMute() {
        return this.enterRoomMute;
    }
}
