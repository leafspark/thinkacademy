package com.tal.app.thinkacademy.live.business.schulte.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableEndBean;", "", "interactId", "", "pub", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getInteractId", "()Ljava/lang/String;", "getPub", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableEndBean;", "equals", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTableEndBean.kt */
public final class SchulteTableEndBean {
    private final String interactId;
    private final Boolean pub;

    public static /* synthetic */ SchulteTableEndBean copy$default(SchulteTableEndBean schulteTableEndBean, String str, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = schulteTableEndBean.interactId;
        }
        if ((i & 2) != 0) {
            bool = schulteTableEndBean.pub;
        }
        return schulteTableEndBean.copy(str, bool);
    }

    public final String component1() {
        return this.interactId;
    }

    public final Boolean component2() {
        return this.pub;
    }

    public final SchulteTableEndBean copy(String str, Boolean bool) {
        return new SchulteTableEndBean(str, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SchulteTableEndBean)) {
            return false;
        }
        SchulteTableEndBean schulteTableEndBean = (SchulteTableEndBean) obj;
        return Intrinsics.areEqual(this.interactId, schulteTableEndBean.interactId) && Intrinsics.areEqual(this.pub, schulteTableEndBean.pub);
    }

    public int hashCode() {
        String str = this.interactId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.pub;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "SchulteTableEndBean(interactId=" + this.interactId + ", pub=" + this.pub + ')';
    }

    public SchulteTableEndBean(String str, Boolean bool) {
        this.interactId = str;
        this.pub = bool;
    }

    public final String getInteractId() {
        return this.interactId;
    }

    public final Boolean getPub() {
        return this.pub;
    }
}
