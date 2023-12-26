package com.tal.app.thinkacademy.business.login.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/NicknameBean;", "", "nickName", "", "nickNameModified", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getNickName", "()Ljava/lang/String;", "getNickNameModified", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/tal/app/thinkacademy/business/login/entity/NicknameBean;", "equals", "other", "hashCode", "", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NicknameBean.kt */
public final class NicknameBean {
    private final String nickName;
    private final Boolean nickNameModified;

    public static /* synthetic */ NicknameBean copy$default(NicknameBean nicknameBean, String str, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = nicknameBean.nickName;
        }
        if ((i & 2) != 0) {
            bool = nicknameBean.nickNameModified;
        }
        return nicknameBean.copy(str, bool);
    }

    public final String component1() {
        return this.nickName;
    }

    public final Boolean component2() {
        return this.nickNameModified;
    }

    public final NicknameBean copy(String str, Boolean bool) {
        return new NicknameBean(str, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NicknameBean)) {
            return false;
        }
        NicknameBean nicknameBean = (NicknameBean) obj;
        return Intrinsics.areEqual((Object) this.nickName, (Object) nicknameBean.nickName) && Intrinsics.areEqual((Object) this.nickNameModified, (Object) nicknameBean.nickNameModified);
    }

    public int hashCode() {
        String str = this.nickName;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.nickNameModified;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "NicknameBean(nickName=" + this.nickName + ", nickNameModified=" + this.nickNameModified + ')';
    }

    public NicknameBean(String str, Boolean bool) {
        this.nickName = str;
        this.nickNameModified = bool;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final Boolean getNickNameModified() {
        return this.nickNameModified;
    }
}
