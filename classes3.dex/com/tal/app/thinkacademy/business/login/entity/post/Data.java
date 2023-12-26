package com.tal.app.thinkacademy.business.login.entity.post;

import com.tal.app.thinkacademy.business.login.entity.LinkedAccount;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0003J^\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u001b\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006$"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/post/Data;", "", "avatar", "", "firstName", "gradeId", "", "lastName", "nickName", "linkedAccount", "", "Lcom/tal/app/thinkacademy/business/login/entity/LinkedAccount;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAvatar", "()Ljava/lang/String;", "getFirstName", "getGradeId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLastName", "getLinkedAccount", "()Ljava/util/List;", "getNickName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/tal/app/thinkacademy/business/login/entity/post/Data;", "equals", "", "other", "hashCode", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModifyUserInfo.kt */
public final class Data {
    private final String avatar;
    private final String firstName;
    private final Integer gradeId;
    private final String lastName;
    private final List<LinkedAccount> linkedAccount;
    private final String nickName;

    public static /* synthetic */ Data copy$default(Data data, String str, String str2, Integer num, String str3, String str4, List<LinkedAccount> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = data.avatar;
        }
        if ((i & 2) != 0) {
            str2 = data.firstName;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            num = data.gradeId;
        }
        Integer num2 = num;
        if ((i & 8) != 0) {
            str3 = data.lastName;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = data.nickName;
        }
        String str7 = str4;
        if ((i & 32) != 0) {
            list = data.linkedAccount;
        }
        return data.copy(str, str5, num2, str6, str7, list);
    }

    public final String component1() {
        return this.avatar;
    }

    public final String component2() {
        return this.firstName;
    }

    public final Integer component3() {
        return this.gradeId;
    }

    public final String component4() {
        return this.lastName;
    }

    public final String component5() {
        return this.nickName;
    }

    public final List<LinkedAccount> component6() {
        return this.linkedAccount;
    }

    public final Data copy(String str, String str2, Integer num, String str3, String str4, List<LinkedAccount> list) {
        return new Data(str, str2, num, str3, str4, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Data)) {
            return false;
        }
        Data data = (Data) obj;
        return Intrinsics.areEqual((Object) this.avatar, (Object) data.avatar) && Intrinsics.areEqual((Object) this.firstName, (Object) data.firstName) && Intrinsics.areEqual((Object) this.gradeId, (Object) data.gradeId) && Intrinsics.areEqual((Object) this.lastName, (Object) data.lastName) && Intrinsics.areEqual((Object) this.nickName, (Object) data.nickName) && Intrinsics.areEqual((Object) this.linkedAccount, (Object) data.linkedAccount);
    }

    public int hashCode() {
        String str = this.avatar;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.firstName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.gradeId;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.lastName;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.nickName;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<LinkedAccount> list = this.linkedAccount;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "Data(avatar=" + this.avatar + ", firstName=" + this.firstName + ", gradeId=" + this.gradeId + ", lastName=" + this.lastName + ", nickName=" + this.nickName + ", linkedAccount=" + this.linkedAccount + ')';
    }

    public Data(String str, String str2, Integer num, String str3, String str4, List<LinkedAccount> list) {
        this.avatar = str;
        this.firstName = str2;
        this.gradeId = num;
        this.lastName = str3;
        this.nickName = str4;
        this.linkedAccount = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Data(String str, String str2, Integer num, String str3, String str4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, num, str3, str4, (i & 32) != 0 ? null : list);
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final Integer getGradeId() {
        return this.gradeId;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final List<LinkedAccount> getLinkedAccount() {
        return this.linkedAccount;
    }
}
