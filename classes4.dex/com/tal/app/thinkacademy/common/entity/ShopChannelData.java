package com.tal.app.thinkacademy.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/ShopChannelData;", "", "isInit", "", "data", "Lcom/tal/app/thinkacademy/common/entity/ChannelSaveData;", "schoolCode", "", "(ZLcom/tal/app/thinkacademy/common/entity/ChannelSaveData;Ljava/lang/String;)V", "getData", "()Lcom/tal/app/thinkacademy/common/entity/ChannelSaveData;", "setData", "(Lcom/tal/app/thinkacademy/common/entity/ChannelSaveData;)V", "()Z", "setInit", "(Z)V", "getSchoolCode", "()Ljava/lang/String;", "setSchoolCode", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelSaveData.kt */
public final class ShopChannelData {
    private ChannelSaveData data;
    private boolean isInit;
    private String schoolCode;

    public static /* synthetic */ ShopChannelData copy$default(ShopChannelData shopChannelData, boolean z, ChannelSaveData channelSaveData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = shopChannelData.isInit;
        }
        if ((i & 2) != 0) {
            channelSaveData = shopChannelData.data;
        }
        if ((i & 4) != 0) {
            str = shopChannelData.schoolCode;
        }
        return shopChannelData.copy(z, channelSaveData, str);
    }

    public final boolean component1() {
        return this.isInit;
    }

    public final ChannelSaveData component2() {
        return this.data;
    }

    public final String component3() {
        return this.schoolCode;
    }

    public final ShopChannelData copy(boolean z, ChannelSaveData channelSaveData, String str) {
        return new ShopChannelData(z, channelSaveData, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopChannelData)) {
            return false;
        }
        ShopChannelData shopChannelData = (ShopChannelData) obj;
        return this.isInit == shopChannelData.isInit && Intrinsics.areEqual(this.data, shopChannelData.data) && Intrinsics.areEqual(this.schoolCode, shopChannelData.schoolCode);
    }

    public int hashCode() {
        boolean z = this.isInit;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        ChannelSaveData channelSaveData = this.data;
        int i2 = 0;
        int hashCode = (i + (channelSaveData == null ? 0 : channelSaveData.hashCode())) * 31;
        String str = this.schoolCode;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "ShopChannelData(isInit=" + this.isInit + ", data=" + this.data + ", schoolCode=" + this.schoolCode + ')';
    }

    public ShopChannelData(boolean z, ChannelSaveData channelSaveData, String str) {
        this.isInit = z;
        this.data = channelSaveData;
        this.schoolCode = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopChannelData(boolean z, ChannelSaveData channelSaveData, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : channelSaveData, (i & 4) != 0 ? null : str);
    }

    public final ChannelSaveData getData() {
        return this.data;
    }

    public final String getSchoolCode() {
        return this.schoolCode;
    }

    public final boolean isInit() {
        return this.isInit;
    }

    public final void setData(ChannelSaveData channelSaveData) {
        this.data = channelSaveData;
    }

    public final void setInit(boolean z) {
        this.isInit = z;
    }

    public final void setSchoolCode(String str) {
        this.schoolCode = str;
    }
}
