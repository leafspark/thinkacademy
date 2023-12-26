package com.tal.app.thinkacademy.live.business.bulletscreen;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/bulletscreen/BulletScreenBean;", "", "data", "Lcom/tal/app/thinkacademy/live/business/bulletscreen/Data;", "ircType", "", "(Lcom/tal/app/thinkacademy/live/business/bulletscreen/Data;Ljava/lang/String;)V", "getData", "()Lcom/tal/app/thinkacademy/live/business/bulletscreen/Data;", "getIrcType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BulletScreenBean.kt */
public final class BulletScreenBean {
    private final Data data;
    private final String ircType;

    public static /* synthetic */ BulletScreenBean copy$default(BulletScreenBean bulletScreenBean, Data data2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            data2 = bulletScreenBean.data;
        }
        if ((i & 2) != 0) {
            str = bulletScreenBean.ircType;
        }
        return bulletScreenBean.copy(data2, str);
    }

    public final Data component1() {
        return this.data;
    }

    public final String component2() {
        return this.ircType;
    }

    public final BulletScreenBean copy(Data data2, String str) {
        Intrinsics.checkNotNullParameter(data2, "data");
        Intrinsics.checkNotNullParameter(str, "ircType");
        return new BulletScreenBean(data2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BulletScreenBean)) {
            return false;
        }
        BulletScreenBean bulletScreenBean = (BulletScreenBean) obj;
        return Intrinsics.areEqual(this.data, bulletScreenBean.data) && Intrinsics.areEqual(this.ircType, bulletScreenBean.ircType);
    }

    public int hashCode() {
        return (this.data.hashCode() * 31) + this.ircType.hashCode();
    }

    public String toString() {
        return "BulletScreenBean(data=" + this.data + ", ircType=" + this.ircType + ')';
    }

    public BulletScreenBean(Data data2, String str) {
        Intrinsics.checkNotNullParameter(data2, "data");
        Intrinsics.checkNotNullParameter(str, "ircType");
        this.data = data2;
        this.ircType = str;
    }

    public final Data getData() {
        return this.data;
    }

    public final String getIrcType() {
        return this.ircType;
    }
}
