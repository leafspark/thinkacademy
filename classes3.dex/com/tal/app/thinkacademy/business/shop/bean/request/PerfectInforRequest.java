package com.tal.app.thinkacademy.business.shop.bean.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\bHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006#"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/request/PerfectInforRequest;", "", "avatar", "", "nickName", "firstName", "lastName", "grade", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getFirstName", "setFirstName", "getGrade", "()I", "setGrade", "(I)V", "getLastName", "setLastName", "getNickName", "setNickName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PerfectInforRequest.kt */
public final class PerfectInforRequest {
    private String avatar;
    private String firstName;
    private int grade;
    private String lastName;
    private String nickName;

    public static /* synthetic */ PerfectInforRequest copy$default(PerfectInforRequest perfectInforRequest, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = perfectInforRequest.avatar;
        }
        if ((i2 & 2) != 0) {
            str2 = perfectInforRequest.nickName;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = perfectInforRequest.firstName;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = perfectInforRequest.lastName;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            i = perfectInforRequest.grade;
        }
        return perfectInforRequest.copy(str, str5, str6, str7, i);
    }

    public final String component1() {
        return this.avatar;
    }

    public final String component2() {
        return this.nickName;
    }

    public final String component3() {
        return this.firstName;
    }

    public final String component4() {
        return this.lastName;
    }

    public final int component5() {
        return this.grade;
    }

    public final PerfectInforRequest copy(String str, String str2, String str3, String str4, int i) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, "nickName");
        Intrinsics.checkNotNullParameter(str3, "firstName");
        Intrinsics.checkNotNullParameter(str4, "lastName");
        return new PerfectInforRequest(str, str2, str3, str4, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PerfectInforRequest)) {
            return false;
        }
        PerfectInforRequest perfectInforRequest = (PerfectInforRequest) obj;
        return Intrinsics.areEqual((Object) this.avatar, (Object) perfectInforRequest.avatar) && Intrinsics.areEqual((Object) this.nickName, (Object) perfectInforRequest.nickName) && Intrinsics.areEqual((Object) this.firstName, (Object) perfectInforRequest.firstName) && Intrinsics.areEqual((Object) this.lastName, (Object) perfectInforRequest.lastName) && this.grade == perfectInforRequest.grade;
    }

    public int hashCode() {
        return (((((((this.avatar.hashCode() * 31) + this.nickName.hashCode()) * 31) + this.firstName.hashCode()) * 31) + this.lastName.hashCode()) * 31) + this.grade;
    }

    public String toString() {
        return "PerfectInforRequest(avatar=" + this.avatar + ", nickName=" + this.nickName + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", grade=" + this.grade + ')';
    }

    public PerfectInforRequest(String str, String str2, String str3, String str4, int i) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, "nickName");
        Intrinsics.checkNotNullParameter(str3, "firstName");
        Intrinsics.checkNotNullParameter(str4, "lastName");
        this.avatar = str;
        this.nickName = str2;
        this.firstName = str3;
        this.lastName = str4;
        this.grade = i;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final void setAvatar(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatar = str;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final void setNickName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nickName = str;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final void setFirstName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.firstName = str;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final void setLastName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lastName = str;
    }

    public final int getGrade() {
        return this.grade;
    }

    public final void setGrade(int i) {
        this.grade = i;
    }
}
