package com.tal.app.thinkacademy.business.home.main.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/LeaveInfoPostBodyYachProfile;", "", "host", "", "secret", "(Ljava/lang/String;Ljava/lang/String;)V", "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "getSecret", "setSecret", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LeaveInfoPostBody.kt */
public final class LeaveInfoPostBodyYachProfile {
    private String host;
    private String secret;

    public LeaveInfoPostBodyYachProfile() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ LeaveInfoPostBodyYachProfile copy$default(LeaveInfoPostBodyYachProfile leaveInfoPostBodyYachProfile, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = leaveInfoPostBodyYachProfile.host;
        }
        if ((i & 2) != 0) {
            str2 = leaveInfoPostBodyYachProfile.secret;
        }
        return leaveInfoPostBodyYachProfile.copy(str, str2);
    }

    public final String component1() {
        return this.host;
    }

    public final String component2() {
        return this.secret;
    }

    public final LeaveInfoPostBodyYachProfile copy(String str, String str2) {
        return new LeaveInfoPostBodyYachProfile(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LeaveInfoPostBodyYachProfile)) {
            return false;
        }
        LeaveInfoPostBodyYachProfile leaveInfoPostBodyYachProfile = (LeaveInfoPostBodyYachProfile) obj;
        return Intrinsics.areEqual((Object) this.host, (Object) leaveInfoPostBodyYachProfile.host) && Intrinsics.areEqual((Object) this.secret, (Object) leaveInfoPostBodyYachProfile.secret);
    }

    public int hashCode() {
        String str = this.host;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.secret;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "LeaveInfoPostBodyYachProfile(host=" + this.host + ", secret=" + this.secret + ')';
    }

    public LeaveInfoPostBodyYachProfile(String str, String str2) {
        this.host = str;
        this.secret = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LeaveInfoPostBodyYachProfile(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public final String getHost() {
        return this.host;
    }

    public final void setHost(String str) {
        this.host = str;
    }

    public final String getSecret() {
        return this.secret;
    }

    public final void setSecret(String str) {
        this.secret = str;
    }
}
