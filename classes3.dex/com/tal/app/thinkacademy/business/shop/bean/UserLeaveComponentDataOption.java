package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/UserLeaveComponentDataOption;", "", "name", "", "rowUuid", "type", "mLocalIsSelect", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getMLocalIsSelect", "()Z", "setMLocalIsSelect", "(Z)V", "getName", "()Ljava/lang/String;", "getRowUuid", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserLeaveInfoBean.kt */
public final class UserLeaveComponentDataOption {
    private boolean mLocalIsSelect;
    private final String name;
    private final String rowUuid;
    private final String type;

    public UserLeaveComponentDataOption() {
        this((String) null, (String) null, (String) null, false, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UserLeaveComponentDataOption copy$default(UserLeaveComponentDataOption userLeaveComponentDataOption, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userLeaveComponentDataOption.name;
        }
        if ((i & 2) != 0) {
            str2 = userLeaveComponentDataOption.rowUuid;
        }
        if ((i & 4) != 0) {
            str3 = userLeaveComponentDataOption.type;
        }
        if ((i & 8) != 0) {
            z = userLeaveComponentDataOption.mLocalIsSelect;
        }
        return userLeaveComponentDataOption.copy(str, str2, str3, z);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.rowUuid;
    }

    public final String component3() {
        return this.type;
    }

    public final boolean component4() {
        return this.mLocalIsSelect;
    }

    public final UserLeaveComponentDataOption copy(String str, String str2, String str3, boolean z) {
        return new UserLeaveComponentDataOption(str, str2, str3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserLeaveComponentDataOption)) {
            return false;
        }
        UserLeaveComponentDataOption userLeaveComponentDataOption = (UserLeaveComponentDataOption) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) userLeaveComponentDataOption.name) && Intrinsics.areEqual((Object) this.rowUuid, (Object) userLeaveComponentDataOption.rowUuid) && Intrinsics.areEqual((Object) this.type, (Object) userLeaveComponentDataOption.type) && this.mLocalIsSelect == userLeaveComponentDataOption.mLocalIsSelect;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.rowUuid;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.type;
        if (str3 != null) {
            i = str3.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.mLocalIsSelect;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        return "UserLeaveComponentDataOption(name=" + this.name + ", rowUuid=" + this.rowUuid + ", type=" + this.type + ", mLocalIsSelect=" + this.mLocalIsSelect + ')';
    }

    public UserLeaveComponentDataOption(String str, String str2, String str3, boolean z) {
        this.name = str;
        this.rowUuid = str2;
        this.type = str3;
        this.mLocalIsSelect = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserLeaveComponentDataOption(String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? false : z);
    }

    public final String getName() {
        return this.name;
    }

    public final String getRowUuid() {
        return this.rowUuid;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean getMLocalIsSelect() {
        return this.mLocalIsSelect;
    }

    public final void setMLocalIsSelect(boolean z) {
        this.mLocalIsSelect = z;
    }
}
