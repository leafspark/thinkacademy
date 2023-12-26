package com.tal.app.thinkacademy.business.login.entity.post;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/post/ChangePassword;", "", "header", "Lcom/tal/app/thinkacademy/business/login/entity/post/ChangePasswordHeader;", "data", "Lcom/tal/app/thinkacademy/business/login/entity/post/ChangePasswordData;", "(Lcom/tal/app/thinkacademy/business/login/entity/post/ChangePasswordHeader;Lcom/tal/app/thinkacademy/business/login/entity/post/ChangePasswordData;)V", "getData", "()Lcom/tal/app/thinkacademy/business/login/entity/post/ChangePasswordData;", "getHeader", "()Lcom/tal/app/thinkacademy/business/login/entity/post/ChangePasswordHeader;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChangePassword.kt */
public final class ChangePassword {
    private final ChangePasswordData data;
    private final ChangePasswordHeader header;

    public static /* synthetic */ ChangePassword copy$default(ChangePassword changePassword, ChangePasswordHeader changePasswordHeader, ChangePasswordData changePasswordData, int i, Object obj) {
        if ((i & 1) != 0) {
            changePasswordHeader = changePassword.header;
        }
        if ((i & 2) != 0) {
            changePasswordData = changePassword.data;
        }
        return changePassword.copy(changePasswordHeader, changePasswordData);
    }

    public final ChangePasswordHeader component1() {
        return this.header;
    }

    public final ChangePasswordData component2() {
        return this.data;
    }

    public final ChangePassword copy(ChangePasswordHeader changePasswordHeader, ChangePasswordData changePasswordData) {
        return new ChangePassword(changePasswordHeader, changePasswordData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangePassword)) {
            return false;
        }
        ChangePassword changePassword = (ChangePassword) obj;
        return Intrinsics.areEqual((Object) this.header, (Object) changePassword.header) && Intrinsics.areEqual((Object) this.data, (Object) changePassword.data);
    }

    public int hashCode() {
        ChangePasswordHeader changePasswordHeader = this.header;
        int i = 0;
        int hashCode = (changePasswordHeader == null ? 0 : changePasswordHeader.hashCode()) * 31;
        ChangePasswordData changePasswordData = this.data;
        if (changePasswordData != null) {
            i = changePasswordData.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ChangePassword(header=" + this.header + ", data=" + this.data + ')';
    }

    public ChangePassword(ChangePasswordHeader changePasswordHeader, ChangePasswordData changePasswordData) {
        this.header = changePasswordHeader;
        this.data = changePasswordData;
    }

    public final ChangePasswordHeader getHeader() {
        return this.header;
    }

    public final ChangePasswordData getData() {
        return this.data;
    }
}
