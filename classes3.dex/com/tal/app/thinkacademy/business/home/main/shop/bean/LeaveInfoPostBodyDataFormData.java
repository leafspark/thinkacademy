package com.tal.app.thinkacademy.business.home.main.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003JA\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006#"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/LeaveInfoPostBodyDataFormData;", "", "key", "", "name", "value", "multi", "", "custom", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getCustom", "()Z", "setCustom", "(Z)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getMulti", "setMulti", "getName", "setName", "getValue", "setValue", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LeaveInfoPostBody.kt */
public final class LeaveInfoPostBodyDataFormData {
    private boolean custom;
    private String key;
    private boolean multi;
    private String name;
    private String value;

    public LeaveInfoPostBodyDataFormData() {
        this((String) null, (String) null, (String) null, false, false, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ LeaveInfoPostBodyDataFormData copy$default(LeaveInfoPostBodyDataFormData leaveInfoPostBodyDataFormData, String str, String str2, String str3, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = leaveInfoPostBodyDataFormData.key;
        }
        if ((i & 2) != 0) {
            str2 = leaveInfoPostBodyDataFormData.name;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = leaveInfoPostBodyDataFormData.value;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            z = leaveInfoPostBodyDataFormData.multi;
        }
        boolean z3 = z;
        if ((i & 16) != 0) {
            z2 = leaveInfoPostBodyDataFormData.custom;
        }
        return leaveInfoPostBodyDataFormData.copy(str, str4, str5, z3, z2);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.value;
    }

    public final boolean component4() {
        return this.multi;
    }

    public final boolean component5() {
        return this.custom;
    }

    public final LeaveInfoPostBodyDataFormData copy(String str, String str2, String str3, boolean z, boolean z2) {
        return new LeaveInfoPostBodyDataFormData(str, str2, str3, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LeaveInfoPostBodyDataFormData)) {
            return false;
        }
        LeaveInfoPostBodyDataFormData leaveInfoPostBodyDataFormData = (LeaveInfoPostBodyDataFormData) obj;
        return Intrinsics.areEqual((Object) this.key, (Object) leaveInfoPostBodyDataFormData.key) && Intrinsics.areEqual((Object) this.name, (Object) leaveInfoPostBodyDataFormData.name) && Intrinsics.areEqual((Object) this.value, (Object) leaveInfoPostBodyDataFormData.value) && this.multi == leaveInfoPostBodyDataFormData.multi && this.custom == leaveInfoPostBodyDataFormData.custom;
    }

    public int hashCode() {
        String str = this.key;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.value;
        if (str3 != null) {
            i = str3.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.multi;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i3 = (i2 + (z ? 1 : 0)) * 31;
        boolean z3 = this.custom;
        if (!z3) {
            z2 = z3;
        }
        return i3 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "LeaveInfoPostBodyDataFormData(key=" + this.key + ", name=" + this.name + ", value=" + this.value + ", multi=" + this.multi + ", custom=" + this.custom + ')';
    }

    public LeaveInfoPostBodyDataFormData(String str, String str2, String str3, boolean z, boolean z2) {
        this.key = str;
        this.name = str2;
        this.value = str3;
        this.multi = z;
        this.custom = z2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LeaveInfoPostBodyDataFormData(java.lang.String r4, java.lang.String r5, java.lang.String r6, boolean r7, boolean r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 0
            if (r10 == 0) goto L_0x0007
            r10 = r0
            goto L_0x0008
        L_0x0007:
            r10 = r4
        L_0x0008:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r5
        L_0x000f:
            r4 = r9 & 4
            if (r4 == 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r0 = r6
        L_0x0015:
            r4 = r9 & 8
            r5 = 0
            if (r4 == 0) goto L_0x001c
            r2 = r5
            goto L_0x001d
        L_0x001c:
            r2 = r7
        L_0x001d:
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0023
            r9 = r5
            goto L_0x0024
        L_0x0023:
            r9 = r8
        L_0x0024:
            r4 = r3
            r5 = r10
            r6 = r1
            r7 = r0
            r8 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.shop.bean.LeaveInfoPostBodyDataFormData.<init>(java.lang.String, java.lang.String, java.lang.String, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getKey() {
        return this.key;
    }

    public final void setKey(String str) {
        this.key = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    public final boolean getMulti() {
        return this.multi;
    }

    public final void setMulti(boolean z) {
        this.multi = z;
    }

    public final boolean getCustom() {
        return this.custom;
    }

    public final void setCustom(boolean z) {
        this.custom = z;
    }
}
