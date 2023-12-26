package com.tal.app.thinkacademy.business.login.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\bA\b\b\u0018\u00002\u00020\u0001B£\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u000fHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u000fHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u000fHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010G\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u0016HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u001aHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u000fHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J§\u0002\u0010V\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010W\u001a\u00020\u001a2\b\u0010X\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Y\u001a\u00020\u000fHÖ\u0001J\t\u0010Z\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010&R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010!R\u0011\u0010\u0011\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b1\u0010/R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010!R\u0011\u0010\u0013\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b3\u0010/R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010!R\u001b\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010!R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010!R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010!R\u0011\u0010\u001d\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b<\u0010/R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010!¨\u0006["}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/UseGetInfo;", "", "attentionCountryCode", "", "attentionEmail", "attentionPhone", "avatar", "card", "cardNo", "countryCallingCode", "createTime", "email", "firstName", "gender", "gradeId", "", "gradeName", "gradeStageId", "gradeStageName", "id", "lastName", "linkedAccount", "", "Lcom/tal/app/thinkacademy/business/login/entity/LinkedAccount;", "nickName", "nickNameModified", "", "phone", "sex", "userType", "username", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getAttentionCountryCode", "()Ljava/lang/String;", "getAttentionEmail", "getAttentionPhone", "getAvatar", "setAvatar", "(Ljava/lang/String;)V", "getCard", "getCardNo", "getCountryCallingCode", "getCreateTime", "getEmail", "getFirstName", "getGender", "getGradeId", "()I", "getGradeName", "getGradeStageId", "getGradeStageName", "getId", "getLastName", "getLinkedAccount", "()Ljava/util/List;", "getNickName", "getNickNameModified", "()Z", "getPhone", "getSex", "getUserType", "getUsername", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UseGetInfo.kt */
public final class UseGetInfo {
    private final String attentionCountryCode;
    private final String attentionEmail;
    private final String attentionPhone;
    private String avatar;
    private final String card;
    private final String cardNo;
    private final String countryCallingCode;
    private final String createTime;
    private final String email;
    private final String firstName;
    private final String gender;
    private final int gradeId;
    private final String gradeName;
    private final int gradeStageId;
    private final String gradeStageName;
    private final int id;
    private final String lastName;
    private final List<LinkedAccount> linkedAccount;
    private final String nickName;
    private final boolean nickNameModified;
    private final String phone;
    private final String sex;
    private final int userType;
    private final String username;

    public UseGetInfo() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, 0, (String) null, 0, (String) null, (List) null, (String) null, false, (String) null, (String) null, 0, (String) null, 16777215, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UseGetInfo copy$default(UseGetInfo useGetInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, String str12, int i2, String str13, int i3, String str14, List list, String str15, boolean z, String str16, String str17, int i4, String str18, int i5, Object obj) {
        UseGetInfo useGetInfo2 = useGetInfo;
        int i6 = i5;
        return useGetInfo.copy((i6 & 1) != 0 ? useGetInfo2.attentionCountryCode : str, (i6 & 2) != 0 ? useGetInfo2.attentionEmail : str2, (i6 & 4) != 0 ? useGetInfo2.attentionPhone : str3, (i6 & 8) != 0 ? useGetInfo2.avatar : str4, (i6 & 16) != 0 ? useGetInfo2.card : str5, (i6 & 32) != 0 ? useGetInfo2.cardNo : str6, (i6 & 64) != 0 ? useGetInfo2.countryCallingCode : str7, (i6 & 128) != 0 ? useGetInfo2.createTime : str8, (i6 & 256) != 0 ? useGetInfo2.email : str9, (i6 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? useGetInfo2.firstName : str10, (i6 & 1024) != 0 ? useGetInfo2.gender : str11, (i6 & 2048) != 0 ? useGetInfo2.gradeId : i, (i6 & ConstantsKt.DEFAULT_BLOCK_SIZE) != 0 ? useGetInfo2.gradeName : str12, (i6 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? useGetInfo2.gradeStageId : i2, (i6 & 16384) != 0 ? useGetInfo2.gradeStageName : str13, (i6 & 32768) != 0 ? useGetInfo2.id : i3, (i6 & 65536) != 0 ? useGetInfo2.lastName : str14, (i6 & 131072) != 0 ? useGetInfo2.linkedAccount : list, (i6 & 262144) != 0 ? useGetInfo2.nickName : str15, (i6 & 524288) != 0 ? useGetInfo2.nickNameModified : z, (i6 & 1048576) != 0 ? useGetInfo2.phone : str16, (i6 & 2097152) != 0 ? useGetInfo2.sex : str17, (i6 & 4194304) != 0 ? useGetInfo2.userType : i4, (i6 & 8388608) != 0 ? useGetInfo2.username : str18);
    }

    public final String component1() {
        return this.attentionCountryCode;
    }

    public final String component10() {
        return this.firstName;
    }

    public final String component11() {
        return this.gender;
    }

    public final int component12() {
        return this.gradeId;
    }

    public final String component13() {
        return this.gradeName;
    }

    public final int component14() {
        return this.gradeStageId;
    }

    public final String component15() {
        return this.gradeStageName;
    }

    public final int component16() {
        return this.id;
    }

    public final String component17() {
        return this.lastName;
    }

    public final List<LinkedAccount> component18() {
        return this.linkedAccount;
    }

    public final String component19() {
        return this.nickName;
    }

    public final String component2() {
        return this.attentionEmail;
    }

    public final boolean component20() {
        return this.nickNameModified;
    }

    public final String component21() {
        return this.phone;
    }

    public final String component22() {
        return this.sex;
    }

    public final int component23() {
        return this.userType;
    }

    public final String component24() {
        return this.username;
    }

    public final String component3() {
        return this.attentionPhone;
    }

    public final String component4() {
        return this.avatar;
    }

    public final String component5() {
        return this.card;
    }

    public final String component6() {
        return this.cardNo;
    }

    public final String component7() {
        return this.countryCallingCode;
    }

    public final String component8() {
        return this.createTime;
    }

    public final String component9() {
        return this.email;
    }

    public final UseGetInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, String str12, int i2, String str13, int i3, String str14, List<LinkedAccount> list, String str15, boolean z, String str16, String str17, int i4, String str18) {
        return new UseGetInfo(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, i, str12, i2, str13, i3, str14, list, str15, z, str16, str17, i4, str18);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UseGetInfo)) {
            return false;
        }
        UseGetInfo useGetInfo = (UseGetInfo) obj;
        return Intrinsics.areEqual((Object) this.attentionCountryCode, (Object) useGetInfo.attentionCountryCode) && Intrinsics.areEqual((Object) this.attentionEmail, (Object) useGetInfo.attentionEmail) && Intrinsics.areEqual((Object) this.attentionPhone, (Object) useGetInfo.attentionPhone) && Intrinsics.areEqual((Object) this.avatar, (Object) useGetInfo.avatar) && Intrinsics.areEqual((Object) this.card, (Object) useGetInfo.card) && Intrinsics.areEqual((Object) this.cardNo, (Object) useGetInfo.cardNo) && Intrinsics.areEqual((Object) this.countryCallingCode, (Object) useGetInfo.countryCallingCode) && Intrinsics.areEqual((Object) this.createTime, (Object) useGetInfo.createTime) && Intrinsics.areEqual((Object) this.email, (Object) useGetInfo.email) && Intrinsics.areEqual((Object) this.firstName, (Object) useGetInfo.firstName) && Intrinsics.areEqual((Object) this.gender, (Object) useGetInfo.gender) && this.gradeId == useGetInfo.gradeId && Intrinsics.areEqual((Object) this.gradeName, (Object) useGetInfo.gradeName) && this.gradeStageId == useGetInfo.gradeStageId && Intrinsics.areEqual((Object) this.gradeStageName, (Object) useGetInfo.gradeStageName) && this.id == useGetInfo.id && Intrinsics.areEqual((Object) this.lastName, (Object) useGetInfo.lastName) && Intrinsics.areEqual((Object) this.linkedAccount, (Object) useGetInfo.linkedAccount) && Intrinsics.areEqual((Object) this.nickName, (Object) useGetInfo.nickName) && this.nickNameModified == useGetInfo.nickNameModified && Intrinsics.areEqual((Object) this.phone, (Object) useGetInfo.phone) && Intrinsics.areEqual((Object) this.sex, (Object) useGetInfo.sex) && this.userType == useGetInfo.userType && Intrinsics.areEqual((Object) this.username, (Object) useGetInfo.username);
    }

    public int hashCode() {
        String str = this.attentionCountryCode;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.attentionEmail;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.attentionPhone;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.avatar;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.card;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.cardNo;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.countryCallingCode;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.createTime;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.email;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.firstName;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.gender;
        int hashCode11 = (((hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31) + this.gradeId) * 31;
        String str12 = this.gradeName;
        int hashCode12 = (((hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31) + this.gradeStageId) * 31;
        String str13 = this.gradeStageName;
        int hashCode13 = (((hashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31) + this.id) * 31;
        String str14 = this.lastName;
        int hashCode14 = (hashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        List<LinkedAccount> list = this.linkedAccount;
        int hashCode15 = (hashCode14 + (list == null ? 0 : list.hashCode())) * 31;
        String str15 = this.nickName;
        int hashCode16 = (hashCode15 + (str15 == null ? 0 : str15.hashCode())) * 31;
        boolean z = this.nickNameModified;
        if (z) {
            z = true;
        }
        int i2 = (hashCode16 + (z ? 1 : 0)) * 31;
        String str16 = this.phone;
        int hashCode17 = (i2 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.sex;
        int hashCode18 = (((hashCode17 + (str17 == null ? 0 : str17.hashCode())) * 31) + this.userType) * 31;
        String str18 = this.username;
        if (str18 != null) {
            i = str18.hashCode();
        }
        return hashCode18 + i;
    }

    public String toString() {
        return "UseGetInfo(attentionCountryCode=" + this.attentionCountryCode + ", attentionEmail=" + this.attentionEmail + ", attentionPhone=" + this.attentionPhone + ", avatar=" + this.avatar + ", card=" + this.card + ", cardNo=" + this.cardNo + ", countryCallingCode=" + this.countryCallingCode + ", createTime=" + this.createTime + ", email=" + this.email + ", firstName=" + this.firstName + ", gender=" + this.gender + ", gradeId=" + this.gradeId + ", gradeName=" + this.gradeName + ", gradeStageId=" + this.gradeStageId + ", gradeStageName=" + this.gradeStageName + ", id=" + this.id + ", lastName=" + this.lastName + ", linkedAccount=" + this.linkedAccount + ", nickName=" + this.nickName + ", nickNameModified=" + this.nickNameModified + ", phone=" + this.phone + ", sex=" + this.sex + ", userType=" + this.userType + ", username=" + this.username + ')';
    }

    public UseGetInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, String str12, int i2, String str13, int i3, String str14, List<LinkedAccount> list, String str15, boolean z, String str16, String str17, int i4, String str18) {
        this.attentionCountryCode = str;
        this.attentionEmail = str2;
        this.attentionPhone = str3;
        this.avatar = str4;
        this.card = str5;
        this.cardNo = str6;
        this.countryCallingCode = str7;
        this.createTime = str8;
        this.email = str9;
        this.firstName = str10;
        this.gender = str11;
        this.gradeId = i;
        this.gradeName = str12;
        this.gradeStageId = i2;
        this.gradeStageName = str13;
        this.id = i3;
        this.lastName = str14;
        this.linkedAccount = list;
        this.nickName = str15;
        this.nickNameModified = z;
        this.phone = str16;
        this.sex = str17;
        this.userType = i4;
        this.username = str18;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UseGetInfo(java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, int r37, java.lang.String r38, int r39, java.lang.String r40, int r41, java.lang.String r42, java.util.List r43, java.lang.String r44, boolean r45, java.lang.String r46, java.lang.String r47, int r48, java.lang.String r49, int r50, kotlin.jvm.internal.DefaultConstructorMarker r51) {
        /*
            r25 = this;
            r0 = r50
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r26
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r27
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r28
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r29
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r30
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r31
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r32
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r33
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r34
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r35
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r36
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r37
        L_0x0062:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0068
            r15 = 0
            goto L_0x006a
        L_0x0068:
            r15 = r38
        L_0x006a:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0070
            r2 = 0
            goto L_0x0072
        L_0x0070:
            r2 = r39
        L_0x0072:
            r14 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r14 == 0) goto L_0x0078
            r14 = 0
            goto L_0x007a
        L_0x0078:
            r14 = r40
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r41
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r42
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r43
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            r19 = 0
            goto L_0x00a7
        L_0x00a5:
            r19 = r44
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b0
            r20 = 0
            goto L_0x00b2
        L_0x00b0:
            r20 = r45
        L_0x00b2:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00bb
            r21 = 0
            goto L_0x00bd
        L_0x00bb:
            r21 = r46
        L_0x00bd:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00c6
            r22 = 0
            goto L_0x00c8
        L_0x00c6:
            r22 = r47
        L_0x00c8:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00d1
            r23 = 0
            goto L_0x00d3
        L_0x00d1:
            r23 = r48
        L_0x00d3:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r0 = r0 & r24
            if (r0 == 0) goto L_0x00db
            r0 = 0
            goto L_0x00dd
        L_0x00db:
            r0 = r49
        L_0x00dd:
            r26 = r25
            r27 = r1
            r28 = r3
            r29 = r4
            r30 = r5
            r31 = r6
            r32 = r7
            r33 = r8
            r34 = r9
            r35 = r10
            r36 = r11
            r37 = r12
            r38 = r13
            r39 = r15
            r40 = r2
            r41 = r14
            r42 = r16
            r43 = r17
            r44 = r18
            r45 = r19
            r46 = r20
            r47 = r21
            r48 = r22
            r49 = r23
            r50 = r0
            r26.<init>(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.entity.UseGetInfo.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, java.lang.String, int, java.lang.String, java.util.List, java.lang.String, boolean, java.lang.String, java.lang.String, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getAttentionCountryCode() {
        return this.attentionCountryCode;
    }

    public final String getAttentionEmail() {
        return this.attentionEmail;
    }

    public final String getAttentionPhone() {
        return this.attentionPhone;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final String getCard() {
        return this.card;
    }

    public final String getCardNo() {
        return this.cardNo;
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

    public final int getGradeId() {
        return this.gradeId;
    }

    public final String getGradeName() {
        return this.gradeName;
    }

    public final int getGradeStageId() {
        return this.gradeStageId;
    }

    public final String getGradeStageName() {
        return this.gradeStageName;
    }

    public final int getId() {
        return this.id;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final List<LinkedAccount> getLinkedAccount() {
        return this.linkedAccount;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final boolean getNickNameModified() {
        return this.nickNameModified;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getSex() {
        return this.sex;
    }

    public final int getUserType() {
        return this.userType;
    }

    public final String getUsername() {
        return this.username;
    }
}
