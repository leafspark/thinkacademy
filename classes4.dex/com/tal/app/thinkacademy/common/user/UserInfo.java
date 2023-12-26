package com.tal.app.thinkacademy.common.user;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\"\u0018\u00002\u00020\u0001:\u0001'B_\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rB\u0005¢\u0006\u0002\u0010\u000eJ\b\u0010&\u001a\u00020\u0003H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0010\"\u0004\b%\u0010\u0012¨\u0006("}, d2 = {"Lcom/tal/app/thinkacademy/common/user/UserInfo;", "", "phone", "", "uid", "guest", "", "unifiedAccessToken", "avatar", "countryCallingCode", "email", "nickName", "card", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getCard", "setCard", "getCountryCallingCode", "setCountryCallingCode", "getEmail", "setEmail", "isGuest", "()Ljava/lang/Boolean;", "setGuest", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getNickName", "setNickName", "getPhone", "setPhone", "getUid", "setUid", "getUnifiedAccessToken", "setUnifiedAccessToken", "toString", "Build", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserInfo.kt */
public final class UserInfo {
    private String avatar;
    private String card;
    private String countryCallingCode;
    private String email;
    private Boolean isGuest;
    private String nickName;
    private String phone;
    private String uid;
    private String unifiedAccessToken;

    public UserInfo() {
        this.nickName = "";
        this.card = "";
    }

    public final String getPhone() {
        return this.phone;
    }

    public final void setPhone(String str) {
        this.phone = str;
    }

    public final String getUid() {
        return this.uid;
    }

    public final void setUid(String str) {
        this.uid = str;
    }

    public final Boolean isGuest() {
        return this.isGuest;
    }

    public final void setGuest(Boolean bool) {
        this.isGuest = bool;
    }

    public final String getUnifiedAccessToken() {
        return this.unifiedAccessToken;
    }

    public final void setUnifiedAccessToken(String str) {
        this.unifiedAccessToken = str;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final String getCountryCallingCode() {
        return this.countryCallingCode;
    }

    public final void setCountryCallingCode(String str) {
        this.countryCallingCode = str;
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

    public final String getCard() {
        return this.card;
    }

    public final void setCard(String str) {
        this.card = str;
    }

    public UserInfo(String str, String str2, boolean z, String str3, String str4, String str5, String str6, String str7, String str8) {
        this();
        this.phone = str;
        this.uid = str2;
        this.isGuest = Boolean.valueOf(z);
        this.unifiedAccessToken = str3;
        this.avatar = str4;
        this.countryCallingCode = str5;
        this.email = str6;
        this.nickName = str7;
        this.card = str8;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/common/user/UserInfo$Build;", "", "()V", "avatar", "", "card", "countryCallingCode", "email", "isGuest", "", "nickName", "phone", "uid", "unifiedAccessToken", "build", "Lcom/tal/app/thinkacademy/common/user/UserInfo;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UserInfo.kt */
    public static final class Build {
        private String avatar;
        private String card;
        private String countryCallingCode;
        private String email;
        private boolean isGuest;
        private String nickName;
        private String phone;
        private String uid;
        private String unifiedAccessToken;

        public final Build phone(String str) {
            this.phone = str;
            return this;
        }

        public final Build uid(String str) {
            this.uid = str;
            return this;
        }

        public final Build isGuest(boolean z) {
            this.isGuest = z;
            return this;
        }

        public final Build unifiedAccessToken(String str) {
            this.unifiedAccessToken = str;
            return this;
        }

        public final Build avatar(String str) {
            this.avatar = str;
            return this;
        }

        public final Build countryCallingCode(String str) {
            this.countryCallingCode = str;
            return this;
        }

        public final Build email(String str) {
            this.email = str;
            return this;
        }

        public final Build nickName(String str) {
            this.nickName = str;
            return this;
        }

        public final Build card(String str) {
            this.card = str;
            return this;
        }

        public final UserInfo build() {
            return new UserInfo(this.phone, this.uid, this.isGuest, this.unifiedAccessToken, this.avatar, this.countryCallingCode, this.email, this.nickName, this.card);
        }
    }

    public String toString() {
        return "UserInfo(phone=" + this.phone + ", uid=" + this.uid + ", isGuest=" + this.isGuest + ", unifiedAccessToken=" + this.unifiedAccessToken + ", avatar=" + this.avatar + ", countryCallingCode=" + this.countryCallingCode + ", email=" + this.email + ')';
    }
}
