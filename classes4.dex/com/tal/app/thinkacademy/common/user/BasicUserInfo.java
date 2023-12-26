package com.tal.app.thinkacademy.common.user;

import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b,\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010)J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001cJÎ\u0001\u0010=\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020\u00142\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020\u0006HÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b#\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b%\u0010\u001cR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0017R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0017¨\u0006D"}, d2 = {"Lcom/tal/app/thinkacademy/common/user/BasicUserInfo;", "Ljava/io/Serializable;", "avatar", "", "cardNo", "coinAmount", "", "countryCallingCode", "createTime", "email", "firstName", "gender", "gradeId", "gradeName", "id", "lastName", "nickName", "phone", "username", "nickNameModified", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getCardNo", "getCoinAmount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCountryCallingCode", "getCreateTime", "getEmail", "getFirstName", "getGender", "getGradeId", "getGradeName", "getId", "getLastName", "getNickName", "getNickNameModified", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPhone", "getUsername", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/tal/app/thinkacademy/common/user/BasicUserInfo;", "equals", "other", "", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BasicUserInfo.kt */
public final class BasicUserInfo implements Serializable {
    private String avatar;
    private final String cardNo;
    private final Integer coinAmount;
    private final String countryCallingCode;
    private final String createTime;
    private final String email;
    private final String firstName;
    private final String gender;
    private final Integer gradeId;
    private final String gradeName;
    private final Integer id;
    private final String lastName;
    private final String nickName;
    private final Boolean nickNameModified;
    private final String phone;
    private final String username;

    public static /* synthetic */ BasicUserInfo copy$default(BasicUserInfo basicUserInfo, String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, Integer num2, String str8, Integer num3, String str9, String str10, String str11, String str12, Boolean bool, int i, Object obj) {
        BasicUserInfo basicUserInfo2 = basicUserInfo;
        int i2 = i;
        return basicUserInfo.copy((i2 & 1) != 0 ? basicUserInfo2.avatar : str, (i2 & 2) != 0 ? basicUserInfo2.cardNo : str2, (i2 & 4) != 0 ? basicUserInfo2.coinAmount : num, (i2 & 8) != 0 ? basicUserInfo2.countryCallingCode : str3, (i2 & 16) != 0 ? basicUserInfo2.createTime : str4, (i2 & 32) != 0 ? basicUserInfo2.email : str5, (i2 & 64) != 0 ? basicUserInfo2.firstName : str6, (i2 & LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP) != 0 ? basicUserInfo2.gender : str7, (i2 & 256) != 0 ? basicUserInfo2.gradeId : num2, (i2 & 512) != 0 ? basicUserInfo2.gradeName : str8, (i2 & 1024) != 0 ? basicUserInfo2.id : num3, (i2 & 2048) != 0 ? basicUserInfo2.lastName : str9, (i2 & 4096) != 0 ? basicUserInfo2.nickName : str10, (i2 & 8192) != 0 ? basicUserInfo2.phone : str11, (i2 & 16384) != 0 ? basicUserInfo2.username : str12, (i2 & 32768) != 0 ? basicUserInfo2.nickNameModified : bool);
    }

    public final String component1() {
        return this.avatar;
    }

    public final String component10() {
        return this.gradeName;
    }

    public final Integer component11() {
        return this.id;
    }

    public final String component12() {
        return this.lastName;
    }

    public final String component13() {
        return this.nickName;
    }

    public final String component14() {
        return this.phone;
    }

    public final String component15() {
        return this.username;
    }

    public final Boolean component16() {
        return this.nickNameModified;
    }

    public final String component2() {
        return this.cardNo;
    }

    public final Integer component3() {
        return this.coinAmount;
    }

    public final String component4() {
        return this.countryCallingCode;
    }

    public final String component5() {
        return this.createTime;
    }

    public final String component6() {
        return this.email;
    }

    public final String component7() {
        return this.firstName;
    }

    public final String component8() {
        return this.gender;
    }

    public final Integer component9() {
        return this.gradeId;
    }

    public final BasicUserInfo copy(String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, Integer num2, String str8, Integer num3, String str9, String str10, String str11, String str12, Boolean bool) {
        return new BasicUserInfo(str, str2, num, str3, str4, str5, str6, str7, num2, str8, num3, str9, str10, str11, str12, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BasicUserInfo)) {
            return false;
        }
        BasicUserInfo basicUserInfo = (BasicUserInfo) obj;
        return Intrinsics.areEqual(this.avatar, basicUserInfo.avatar) && Intrinsics.areEqual(this.cardNo, basicUserInfo.cardNo) && Intrinsics.areEqual(this.coinAmount, basicUserInfo.coinAmount) && Intrinsics.areEqual(this.countryCallingCode, basicUserInfo.countryCallingCode) && Intrinsics.areEqual(this.createTime, basicUserInfo.createTime) && Intrinsics.areEqual(this.email, basicUserInfo.email) && Intrinsics.areEqual(this.firstName, basicUserInfo.firstName) && Intrinsics.areEqual(this.gender, basicUserInfo.gender) && Intrinsics.areEqual(this.gradeId, basicUserInfo.gradeId) && Intrinsics.areEqual(this.gradeName, basicUserInfo.gradeName) && Intrinsics.areEqual(this.id, basicUserInfo.id) && Intrinsics.areEqual(this.lastName, basicUserInfo.lastName) && Intrinsics.areEqual(this.nickName, basicUserInfo.nickName) && Intrinsics.areEqual(this.phone, basicUserInfo.phone) && Intrinsics.areEqual(this.username, basicUserInfo.username) && Intrinsics.areEqual(this.nickNameModified, basicUserInfo.nickNameModified);
    }

    public int hashCode() {
        String str = this.avatar;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.cardNo;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.coinAmount;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.countryCallingCode;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.createTime;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.email;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.firstName;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.gender;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num2 = this.gradeId;
        int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str8 = this.gradeName;
        int hashCode10 = (hashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Integer num3 = this.id;
        int hashCode11 = (hashCode10 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str9 = this.lastName;
        int hashCode12 = (hashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.nickName;
        int hashCode13 = (hashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.phone;
        int hashCode14 = (hashCode13 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.username;
        int hashCode15 = (hashCode14 + (str12 == null ? 0 : str12.hashCode())) * 31;
        Boolean bool = this.nickNameModified;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode15 + i;
    }

    public String toString() {
        return "BasicUserInfo(avatar=" + this.avatar + ", cardNo=" + this.cardNo + ", coinAmount=" + this.coinAmount + ", countryCallingCode=" + this.countryCallingCode + ", createTime=" + this.createTime + ", email=" + this.email + ", firstName=" + this.firstName + ", gender=" + this.gender + ", gradeId=" + this.gradeId + ", gradeName=" + this.gradeName + ", id=" + this.id + ", lastName=" + this.lastName + ", nickName=" + this.nickName + ", phone=" + this.phone + ", username=" + this.username + ", nickNameModified=" + this.nickNameModified + ')';
    }

    public BasicUserInfo(String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, Integer num2, String str8, Integer num3, String str9, String str10, String str11, String str12, Boolean bool) {
        this.avatar = str;
        this.cardNo = str2;
        this.coinAmount = num;
        this.countryCallingCode = str3;
        this.createTime = str4;
        this.email = str5;
        this.firstName = str6;
        this.gender = str7;
        this.gradeId = num2;
        this.gradeName = str8;
        this.id = num3;
        this.lastName = str9;
        this.nickName = str10;
        this.phone = str11;
        this.username = str12;
        this.nickNameModified = bool;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final String getCardNo() {
        return this.cardNo;
    }

    public final Integer getCoinAmount() {
        return this.coinAmount;
    }

    public final String getCountryCallingCode() {
        return this.countryCallingCode;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getGender() {
        return this.gender;
    }

    public final Integer getGradeId() {
        return this.gradeId;
    }

    public final String getGradeName() {
        return this.gradeName;
    }

    public final Integer getId() {
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

    public final String getUsername() {
        return this.username;
    }

    public final Boolean getNickNameModified() {
        return this.nickNameModified;
    }
}
