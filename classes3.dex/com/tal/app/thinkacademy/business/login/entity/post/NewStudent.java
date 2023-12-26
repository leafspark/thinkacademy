package com.tal.app.thinkacademy.business.login.entity.post;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/post/NewStudent;", "", "nickName", "", "firstName", "lastName", "gradeId", "", "email", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getFirstName", "getGradeId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLastName", "getNickName", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/tal/app/thinkacademy/business/login/entity/post/NewStudent;", "equals", "", "other", "hashCode", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddNewStudentRequest.kt */
public final class NewStudent {
    private final String email;
    private final String firstName;
    private final Integer gradeId;
    private final String lastName;
    private final String nickName;

    public static /* synthetic */ NewStudent copy$default(NewStudent newStudent, String str, String str2, String str3, Integer num, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = newStudent.nickName;
        }
        if ((i & 2) != 0) {
            str2 = newStudent.firstName;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = newStudent.lastName;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            num = newStudent.gradeId;
        }
        Integer num2 = num;
        if ((i & 16) != 0) {
            str4 = newStudent.email;
        }
        return newStudent.copy(str, str5, str6, num2, str4);
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

    public final Integer component4() {
        return this.gradeId;
    }

    public final String component5() {
        return this.email;
    }

    public final NewStudent copy(String str, String str2, String str3, Integer num, String str4) {
        return new NewStudent(str, str2, str3, num, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NewStudent)) {
            return false;
        }
        NewStudent newStudent = (NewStudent) obj;
        return Intrinsics.areEqual((Object) this.nickName, (Object) newStudent.nickName) && Intrinsics.areEqual((Object) this.firstName, (Object) newStudent.firstName) && Intrinsics.areEqual((Object) this.lastName, (Object) newStudent.lastName) && Intrinsics.areEqual((Object) this.gradeId, (Object) newStudent.gradeId) && Intrinsics.areEqual((Object) this.email, (Object) newStudent.email);
    }

    public int hashCode() {
        String str = this.nickName;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.firstName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.lastName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.gradeId;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.email;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "NewStudent(nickName=" + this.nickName + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", gradeId=" + this.gradeId + ", email=" + this.email + ')';
    }

    public NewStudent(String str, String str2, String str3, Integer num, String str4) {
        this.nickName = str;
        this.firstName = str2;
        this.lastName = str3;
        this.gradeId = num;
        this.email = str4;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final Integer getGradeId() {
        return this.gradeId;
    }

    public final String getEmail() {
        return this.email;
    }
}
