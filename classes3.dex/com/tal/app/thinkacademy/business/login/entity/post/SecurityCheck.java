package com.tal.app.thinkacademy.business.login.entity.post;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/post/SecurityCheck;", "", "header", "Lcom/tal/app/thinkacademy/business/login/entity/post/SecurityCheckHeader;", "data", "Lcom/tal/app/thinkacademy/business/login/entity/post/SecurityCheckData;", "(Lcom/tal/app/thinkacademy/business/login/entity/post/SecurityCheckHeader;Lcom/tal/app/thinkacademy/business/login/entity/post/SecurityCheckData;)V", "getData", "()Lcom/tal/app/thinkacademy/business/login/entity/post/SecurityCheckData;", "getHeader", "()Lcom/tal/app/thinkacademy/business/login/entity/post/SecurityCheckHeader;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SecurityCheck.kt */
public final class SecurityCheck {
    private final SecurityCheckData data;
    private final SecurityCheckHeader header;

    public static /* synthetic */ SecurityCheck copy$default(SecurityCheck securityCheck, SecurityCheckHeader securityCheckHeader, SecurityCheckData securityCheckData, int i, Object obj) {
        if ((i & 1) != 0) {
            securityCheckHeader = securityCheck.header;
        }
        if ((i & 2) != 0) {
            securityCheckData = securityCheck.data;
        }
        return securityCheck.copy(securityCheckHeader, securityCheckData);
    }

    public final SecurityCheckHeader component1() {
        return this.header;
    }

    public final SecurityCheckData component2() {
        return this.data;
    }

    public final SecurityCheck copy(SecurityCheckHeader securityCheckHeader, SecurityCheckData securityCheckData) {
        return new SecurityCheck(securityCheckHeader, securityCheckData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SecurityCheck)) {
            return false;
        }
        SecurityCheck securityCheck = (SecurityCheck) obj;
        return Intrinsics.areEqual((Object) this.header, (Object) securityCheck.header) && Intrinsics.areEqual((Object) this.data, (Object) securityCheck.data);
    }

    public int hashCode() {
        SecurityCheckHeader securityCheckHeader = this.header;
        int i = 0;
        int hashCode = (securityCheckHeader == null ? 0 : securityCheckHeader.hashCode()) * 31;
        SecurityCheckData securityCheckData = this.data;
        if (securityCheckData != null) {
            i = securityCheckData.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "SecurityCheck(header=" + this.header + ", data=" + this.data + ')';
    }

    public SecurityCheck(SecurityCheckHeader securityCheckHeader, SecurityCheckData securityCheckData) {
        this.header = securityCheckHeader;
        this.data = securityCheckData;
    }

    public final SecurityCheckHeader getHeader() {
        return this.header;
    }

    public final SecurityCheckData getData() {
        return this.data;
    }
}
