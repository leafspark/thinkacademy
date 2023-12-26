package com.tal.app.thinkacademy.business.login.entity;

import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bi\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010¨\u0006/"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/MasterUserBean;", "", "avatar", "", "countryCallingCode", "email", "firstName", "gender", "gradeName", "id", "", "lastName", "nickName", "phone", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getCountryCallingCode", "getEmail", "getFirstName", "getGender", "()Ljava/lang/Object;", "getGradeName", "getId", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLastName", "getNickName", "getPhone", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tal/app/thinkacademy/business/login/entity/MasterUserBean;", "equals", "", "other", "hashCode", "", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MasterUserBean.kt */
public final class MasterUserBean {
    private final String avatar;
    private final String countryCallingCode;
    private final String email;
    private final String firstName;
    private final Object gender;
    private final Object gradeName;
    private final Double id;
    private final String lastName;
    private final String nickName;
    private final String phone;

    public static /* synthetic */ MasterUserBean copy$default(MasterUserBean masterUserBean, String str, String str2, String str3, String str4, Object obj, Object obj2, Double d, String str5, String str6, String str7, int i, Object obj3) {
        MasterUserBean masterUserBean2 = masterUserBean;
        int i2 = i;
        return masterUserBean.copy((i2 & 1) != 0 ? masterUserBean2.avatar : str, (i2 & 2) != 0 ? masterUserBean2.countryCallingCode : str2, (i2 & 4) != 0 ? masterUserBean2.email : str3, (i2 & 8) != 0 ? masterUserBean2.firstName : str4, (i2 & 16) != 0 ? masterUserBean2.gender : obj, (i2 & 32) != 0 ? masterUserBean2.gradeName : obj2, (i2 & 64) != 0 ? masterUserBean2.id : d, (i2 & 128) != 0 ? masterUserBean2.lastName : str5, (i2 & 256) != 0 ? masterUserBean2.nickName : str6, (i2 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? masterUserBean2.phone : str7);
    }

    public final String component1() {
        return this.avatar;
    }

    public final String component10() {
        return this.phone;
    }

    public final String component2() {
        return this.countryCallingCode;
    }

    public final String component3() {
        return this.email;
    }

    public final String component4() {
        return this.firstName;
    }

    public final Object component5() {
        return this.gender;
    }

    public final Object component6() {
        return this.gradeName;
    }

    public final Double component7() {
        return this.id;
    }

    public final String component8() {
        return this.lastName;
    }

    public final String component9() {
        return this.nickName;
    }

    public final MasterUserBean copy(String str, String str2, String str3, String str4, Object obj, Object obj2, Double d, String str5, String str6, String str7) {
        return new MasterUserBean(str, str2, str3, str4, obj, obj2, d, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MasterUserBean)) {
            return false;
        }
        MasterUserBean masterUserBean = (MasterUserBean) obj;
        return Intrinsics.areEqual((Object) this.avatar, (Object) masterUserBean.avatar) && Intrinsics.areEqual((Object) this.countryCallingCode, (Object) masterUserBean.countryCallingCode) && Intrinsics.areEqual((Object) this.email, (Object) masterUserBean.email) && Intrinsics.areEqual((Object) this.firstName, (Object) masterUserBean.firstName) && Intrinsics.areEqual(this.gender, masterUserBean.gender) && Intrinsics.areEqual(this.gradeName, masterUserBean.gradeName) && Intrinsics.areEqual((Object) this.id, (Object) masterUserBean.id) && Intrinsics.areEqual((Object) this.lastName, (Object) masterUserBean.lastName) && Intrinsics.areEqual((Object) this.nickName, (Object) masterUserBean.nickName) && Intrinsics.areEqual((Object) this.phone, (Object) masterUserBean.phone);
    }

    public int hashCode() {
        String str = this.avatar;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.countryCallingCode;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.email;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.firstName;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Object obj = this.gender;
        int hashCode5 = (hashCode4 + (obj == null ? 0 : obj.hashCode())) * 31;
        Object obj2 = this.gradeName;
        int hashCode6 = (hashCode5 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Double d = this.id;
        int hashCode7 = (hashCode6 + (d == null ? 0 : d.hashCode())) * 31;
        String str5 = this.lastName;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.nickName;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.phone;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode9 + i;
    }

    public String toString() {
        return "MasterUserBean(avatar=" + this.avatar + ", countryCallingCode=" + this.countryCallingCode + ", email=" + this.email + ", firstName=" + this.firstName + ", gender=" + this.gender + ", gradeName=" + this.gradeName + ", id=" + this.id + ", lastName=" + this.lastName + ", nickName=" + this.nickName + ", phone=" + this.phone + ')';
    }

    public MasterUserBean(String str, String str2, String str3, String str4, Object obj, Object obj2, Double d, String str5, String str6, String str7) {
        this.avatar = str;
        this.countryCallingCode = str2;
        this.email = str3;
        this.firstName = str4;
        this.gender = obj;
        this.gradeName = obj2;
        this.id = d;
        this.lastName = str5;
        this.nickName = str6;
        this.phone = str7;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getCountryCallingCode() {
        return this.countryCallingCode;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final Object getGender() {
        return this.gender;
    }

    public final Object getGradeName() {
        return this.gradeName;
    }

    public final Double getId() {
        return this.id;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getPhone() {
        return this.phone;
    }
}
