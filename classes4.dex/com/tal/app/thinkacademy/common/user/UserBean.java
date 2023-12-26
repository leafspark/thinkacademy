package com.tal.app.thinkacademy.common.user;

import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b,\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001By\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\t\u0010.\u001a\u00020\u000eHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\u000e2\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020\u0003HÖ\u0001J\t\u0010=\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0011\"\u0004\b,\u0010\u0013¨\u0006>"}, d2 = {"Lcom/tal/app/thinkacademy/common/user/UserBean;", "Ljava/io/Serializable;", "uid", "", "avatar", "", "phone", "email", "nickName", "countryCallingCode", "unifiedAccessToken", "type", "card", "passwordModified", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Z)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getCard", "setCard", "getCountryCallingCode", "setCountryCallingCode", "getEmail", "setEmail", "getNickName", "setNickName", "getPasswordModified", "()Z", "setPasswordModified", "(Z)V", "getPhone", "setPhone", "getType", "()I", "setType", "(I)V", "getUid", "()Ljava/lang/Integer;", "setUid", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUnifiedAccessToken", "setUnifiedAccessToken", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Z)Lcom/tal/app/thinkacademy/common/user/UserBean;", "equals", "other", "", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserBean.kt */
public final class UserBean implements Serializable {
    private String avatar;
    private String card;
    private String countryCallingCode;
    private String email;
    private String nickName;
    private boolean passwordModified;
    private String phone;
    private int type;
    private Integer uid;
    private String unifiedAccessToken;

    public UserBean() {
        this((Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, false, 1023, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UserBean copy$default(UserBean userBean, Integer num, String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, boolean z, int i2, Object obj) {
        UserBean userBean2 = userBean;
        int i3 = i2;
        return userBean.copy((i3 & 1) != 0 ? userBean2.uid : num, (i3 & 2) != 0 ? userBean2.avatar : str, (i3 & 4) != 0 ? userBean2.phone : str2, (i3 & 8) != 0 ? userBean2.email : str3, (i3 & 16) != 0 ? userBean2.nickName : str4, (i3 & 32) != 0 ? userBean2.countryCallingCode : str5, (i3 & 64) != 0 ? userBean2.unifiedAccessToken : str6, (i3 & LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP) != 0 ? userBean2.type : i, (i3 & 256) != 0 ? userBean2.card : str7, (i3 & 512) != 0 ? userBean2.passwordModified : z);
    }

    public final Integer component1() {
        return this.uid;
    }

    public final boolean component10() {
        return this.passwordModified;
    }

    public final String component2() {
        return this.avatar;
    }

    public final String component3() {
        return this.phone;
    }

    public final String component4() {
        return this.email;
    }

    public final String component5() {
        return this.nickName;
    }

    public final String component6() {
        return this.countryCallingCode;
    }

    public final String component7() {
        return this.unifiedAccessToken;
    }

    public final int component8() {
        return this.type;
    }

    public final String component9() {
        return this.card;
    }

    public final UserBean copy(Integer num, String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, boolean z) {
        return new UserBean(num, str, str2, str3, str4, str5, str6, i, str7, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserBean)) {
            return false;
        }
        UserBean userBean = (UserBean) obj;
        return Intrinsics.areEqual(this.uid, userBean.uid) && Intrinsics.areEqual(this.avatar, userBean.avatar) && Intrinsics.areEqual(this.phone, userBean.phone) && Intrinsics.areEqual(this.email, userBean.email) && Intrinsics.areEqual(this.nickName, userBean.nickName) && Intrinsics.areEqual(this.countryCallingCode, userBean.countryCallingCode) && Intrinsics.areEqual(this.unifiedAccessToken, userBean.unifiedAccessToken) && this.type == userBean.type && Intrinsics.areEqual(this.card, userBean.card) && this.passwordModified == userBean.passwordModified;
    }

    public int hashCode() {
        Integer num = this.uid;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.avatar;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.phone;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.email;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.nickName;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.countryCallingCode;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.unifiedAccessToken;
        int hashCode7 = (((hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.type) * 31;
        String str7 = this.card;
        if (str7 != null) {
            i = str7.hashCode();
        }
        int i2 = (hashCode7 + i) * 31;
        boolean z = this.passwordModified;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        return "UserBean(uid=" + this.uid + ", avatar=" + this.avatar + ", phone=" + this.phone + ", email=" + this.email + ", nickName=" + this.nickName + ", countryCallingCode=" + this.countryCallingCode + ", unifiedAccessToken=" + this.unifiedAccessToken + ", type=" + this.type + ", card=" + this.card + ", passwordModified=" + this.passwordModified + ')';
    }

    public UserBean(Integer num, String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, boolean z) {
        this.uid = num;
        this.avatar = str;
        this.phone = str2;
        this.email = str3;
        this.nickName = str4;
        this.countryCallingCode = str5;
        this.unifiedAccessToken = str6;
        this.type = i;
        this.card = str7;
        this.passwordModified = z;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UserBean(java.lang.Integer r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20, java.lang.String r21, boolean r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r12 = this;
            r0 = r23
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000c
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            goto L_0x000d
        L_0x000c:
            r1 = r13
        L_0x000d:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L_0x0014
            r3 = r4
            goto L_0x0015
        L_0x0014:
            r3 = r14
        L_0x0015:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001b
            r5 = r4
            goto L_0x001c
        L_0x001b:
            r5 = r15
        L_0x001c:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0022
            r6 = r4
            goto L_0x0024
        L_0x0022:
            r6 = r16
        L_0x0024:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002a
            r7 = r4
            goto L_0x002c
        L_0x002a:
            r7 = r17
        L_0x002c:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0032
            r8 = r4
            goto L_0x0034
        L_0x0032:
            r8 = r18
        L_0x0034:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003a
            r9 = r4
            goto L_0x003c
        L_0x003a:
            r9 = r19
        L_0x003c:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0042
            r10 = r2
            goto L_0x0044
        L_0x0042:
            r10 = r20
        L_0x0044:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            r4 = r21
        L_0x004b:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r2 = r22
        L_0x0052:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r4
            r23 = r2
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.user.UserBean.<init>(java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer getUid() {
        return this.uid;
    }

    public final void setUid(Integer num) {
        this.uid = num;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final void setPhone(String str) {
        this.phone = str;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final void setNickName(String str) {
        this.nickName = str;
    }

    public final String getCountryCallingCode() {
        return this.countryCallingCode;
    }

    public final void setCountryCallingCode(String str) {
        this.countryCallingCode = str;
    }

    public final String getUnifiedAccessToken() {
        return this.unifiedAccessToken;
    }

    public final void setUnifiedAccessToken(String str) {
        this.unifiedAccessToken = str;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final String getCard() {
        return this.card;
    }

    public final void setCard(String str) {
        this.card = str;
    }

    public final boolean getPasswordModified() {
        return this.passwordModified;
    }

    public final void setPasswordModified(boolean z) {
        this.passwordModified = z;
    }
}
