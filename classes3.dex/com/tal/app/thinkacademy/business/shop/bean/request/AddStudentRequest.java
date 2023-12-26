package com.tal.app.thinkacademy.business.shop.bean.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/request/AddStudentRequest;", "", "nickName", "", "firstName", "lastName", "gradeId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getFirstName", "()Ljava/lang/String;", "setFirstName", "(Ljava/lang/String;)V", "getGradeId", "()I", "setGradeId", "(I)V", "getLastName", "setLastName", "getNickName", "setNickName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddStudentRequest.kt */
public final class AddStudentRequest {
    private String firstName;
    private int gradeId;
    private String lastName;
    private String nickName;

    public static /* synthetic */ AddStudentRequest copy$default(AddStudentRequest addStudentRequest, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = addStudentRequest.nickName;
        }
        if ((i2 & 2) != 0) {
            str2 = addStudentRequest.firstName;
        }
        if ((i2 & 4) != 0) {
            str3 = addStudentRequest.lastName;
        }
        if ((i2 & 8) != 0) {
            i = addStudentRequest.gradeId;
        }
        return addStudentRequest.copy(str, str2, str3, i);
    }

    public final String component1() {
        return this.nickName;
    }

    public final String component2() {
        return this.firstName;
    }

    public final String component3() {
        return this.lastName;
    }

    public final int component4() {
        return this.gradeId;
    }

    public final AddStudentRequest copy(String str, String str2, String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "nickName");
        Intrinsics.checkNotNullParameter(str2, "firstName");
        Intrinsics.checkNotNullParameter(str3, "lastName");
        return new AddStudentRequest(str, str2, str3, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddStudentRequest)) {
            return false;
        }
        AddStudentRequest addStudentRequest = (AddStudentRequest) obj;
        return Intrinsics.areEqual((Object) this.nickName, (Object) addStudentRequest.nickName) && Intrinsics.areEqual((Object) this.firstName, (Object) addStudentRequest.firstName) && Intrinsics.areEqual((Object) this.lastName, (Object) addStudentRequest.lastName) && this.gradeId == addStudentRequest.gradeId;
    }

    public int hashCode() {
        return (((((this.nickName.hashCode() * 31) + this.firstName.hashCode()) * 31) + this.lastName.hashCode()) * 31) + this.gradeId;
    }

    public String toString() {
        return "AddStudentRequest(nickName=" + this.nickName + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", gradeId=" + this.gradeId + ')';
    }

    public AddStudentRequest(String str, String str2, String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "nickName");
        Intrinsics.checkNotNullParameter(str2, "firstName");
        Intrinsics.checkNotNullParameter(str3, "lastName");
        this.nickName = str;
        this.firstName = str2;
        this.lastName = str3;
        this.gradeId = i;
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

    public final int getGradeId() {
        return this.gradeId;
    }

    public final void setGradeId(int i) {
        this.gradeId = i;
    }
}
