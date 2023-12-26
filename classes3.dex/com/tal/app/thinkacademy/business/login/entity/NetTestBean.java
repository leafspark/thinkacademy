package com.tal.app.thinkacademy.business.login.entity;

import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/NetTestBean;", "", "type", "Lcom/tal/app/thinkacademy/business/login/entity/NetTestType;", "result", "", "(Lcom/tal/app/thinkacademy/business/login/entity/NetTestType;Z)V", "getResult", "()Z", "getType", "()Lcom/tal/app/thinkacademy/business/login/entity/NetTestType;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetTestBean.kt */
public final class NetTestBean {
    private final boolean result;
    private final NetTestType type;

    public static /* synthetic */ NetTestBean copy$default(NetTestBean netTestBean, NetTestType netTestType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            netTestType = netTestBean.type;
        }
        if ((i & 2) != 0) {
            z = netTestBean.result;
        }
        return netTestBean.copy(netTestType, z);
    }

    public final NetTestType component1() {
        return this.type;
    }

    public final boolean component2() {
        return this.result;
    }

    public final NetTestBean copy(NetTestType netTestType, boolean z) {
        Intrinsics.checkNotNullParameter(netTestType, ClassParamsKt.TYPE);
        return new NetTestBean(netTestType, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetTestBean)) {
            return false;
        }
        NetTestBean netTestBean = (NetTestBean) obj;
        return this.type == netTestBean.type && this.result == netTestBean.result;
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        boolean z = this.result;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public NetTestBean(NetTestType netTestType, boolean z) {
        Intrinsics.checkNotNullParameter(netTestType, ClassParamsKt.TYPE);
        this.type = netTestType;
        this.result = z;
    }

    public final boolean getResult() {
        return this.result;
    }

    public final NetTestType getType() {
        return this.type;
    }

    public String toString() {
        return "type:" + this.type + " , result:" + this.result;
    }
}
