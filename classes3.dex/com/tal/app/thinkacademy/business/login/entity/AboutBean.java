package com.tal.app.thinkacademy.business.login.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/AboutBean;", "", "title", "", "url", "local_type", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getLocal_type", "()I", "setLocal_type", "(I)V", "getTitle", "()Ljava/lang/String;", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AboutListEntity.kt */
public final class AboutBean {
    private int local_type;
    private final String title;
    private final String url;

    public static /* synthetic */ AboutBean copy$default(AboutBean aboutBean, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = aboutBean.title;
        }
        if ((i2 & 2) != 0) {
            str2 = aboutBean.url;
        }
        if ((i2 & 4) != 0) {
            i = aboutBean.local_type;
        }
        return aboutBean.copy(str, str2, i);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.url;
    }

    public final int component3() {
        return this.local_type;
    }

    public final AboutBean copy(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "url");
        return new AboutBean(str, str2, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AboutBean)) {
            return false;
        }
        AboutBean aboutBean = (AboutBean) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) aboutBean.title) && Intrinsics.areEqual((Object) this.url, (Object) aboutBean.url) && this.local_type == aboutBean.local_type;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.url.hashCode()) * 31) + this.local_type;
    }

    public String toString() {
        return "AboutBean(title=" + this.title + ", url=" + this.url + ", local_type=" + this.local_type + ')';
    }

    public AboutBean(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "url");
        this.title = str;
        this.url = str2;
        this.local_type = i;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getLocal_type() {
        return this.local_type;
    }

    public final void setLocal_type(int i) {
        this.local_type = i;
    }
}
