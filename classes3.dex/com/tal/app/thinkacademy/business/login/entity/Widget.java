package com.tal.app.thinkacademy.business.login.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006!"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/Widget;", "", "order", "", "target", "", "title", "", "type", "url", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getOrder", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTarget", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTitle", "()Ljava/lang/String;", "getType", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/tal/app/thinkacademy/business/login/entity/Widget;", "equals", "other", "hashCode", "", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BannersData.kt */
public final class Widget {
    private final Long order;
    private final Boolean target;
    private final String title;
    private final Long type;
    private final String url;

    public static /* synthetic */ Widget copy$default(Widget widget, Long l, Boolean bool, String str, Long l2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = widget.order;
        }
        if ((i & 2) != 0) {
            bool = widget.target;
        }
        Boolean bool2 = bool;
        if ((i & 4) != 0) {
            str = widget.title;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            l2 = widget.type;
        }
        Long l3 = l2;
        if ((i & 16) != 0) {
            str2 = widget.url;
        }
        return widget.copy(l, bool2, str3, l3, str2);
    }

    public final Long component1() {
        return this.order;
    }

    public final Boolean component2() {
        return this.target;
    }

    public final String component3() {
        return this.title;
    }

    public final Long component4() {
        return this.type;
    }

    public final String component5() {
        return this.url;
    }

    public final Widget copy(Long l, Boolean bool, String str, Long l2, String str2) {
        return new Widget(l, bool, str, l2, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Widget)) {
            return false;
        }
        Widget widget = (Widget) obj;
        return Intrinsics.areEqual((Object) this.order, (Object) widget.order) && Intrinsics.areEqual((Object) this.target, (Object) widget.target) && Intrinsics.areEqual((Object) this.title, (Object) widget.title) && Intrinsics.areEqual((Object) this.type, (Object) widget.type) && Intrinsics.areEqual((Object) this.url, (Object) widget.url);
    }

    public int hashCode() {
        Long l = this.order;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Boolean bool = this.target;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.title;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Long l2 = this.type;
        int hashCode4 = (hashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str2 = this.url;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "Widget(order=" + this.order + ", target=" + this.target + ", title=" + this.title + ", type=" + this.type + ", url=" + this.url + ')';
    }

    public Widget(Long l, Boolean bool, String str, Long l2, String str2) {
        this.order = l;
        this.target = bool;
        this.title = str;
        this.type = l2;
        this.url = str2;
    }

    public final Long getOrder() {
        return this.order;
    }

    public final Boolean getTarget() {
        return this.target;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Long getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }
}
