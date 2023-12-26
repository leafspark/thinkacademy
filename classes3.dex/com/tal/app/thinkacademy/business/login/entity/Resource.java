package com.tal.app.thinkacademy.business.login.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003JP\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/Resource;", "", "resId", "", "src", "", "target", "", "url", "widgets", "", "Lcom/tal/app/thinkacademy/business/login/entity/Widget;", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;)V", "getResId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSrc", "()Ljava/lang/String;", "getTarget", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUrl", "getWidgets", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;)Lcom/tal/app/thinkacademy/business/login/entity/Resource;", "equals", "other", "hashCode", "", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BannersData.kt */
public final class Resource {
    private final Long resId;
    private final String src;
    private final Boolean target;
    private final String url;
    private final List<Widget> widgets;

    public static /* synthetic */ Resource copy$default(Resource resource, Long l, String str, Boolean bool, String str2, List<Widget> list, int i, Object obj) {
        if ((i & 1) != 0) {
            l = resource.resId;
        }
        if ((i & 2) != 0) {
            str = resource.src;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            bool = resource.target;
        }
        Boolean bool2 = bool;
        if ((i & 8) != 0) {
            str2 = resource.url;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            list = resource.widgets;
        }
        return resource.copy(l, str3, bool2, str4, list);
    }

    public final Long component1() {
        return this.resId;
    }

    public final String component2() {
        return this.src;
    }

    public final Boolean component3() {
        return this.target;
    }

    public final String component4() {
        return this.url;
    }

    public final List<Widget> component5() {
        return this.widgets;
    }

    public final Resource copy(Long l, String str, Boolean bool, String str2, List<Widget> list) {
        return new Resource(l, str, bool, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Resource)) {
            return false;
        }
        Resource resource = (Resource) obj;
        return Intrinsics.areEqual((Object) this.resId, (Object) resource.resId) && Intrinsics.areEqual((Object) this.src, (Object) resource.src) && Intrinsics.areEqual((Object) this.target, (Object) resource.target) && Intrinsics.areEqual((Object) this.url, (Object) resource.url) && Intrinsics.areEqual((Object) this.widgets, (Object) resource.widgets);
    }

    public int hashCode() {
        Long l = this.resId;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.src;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.target;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.url;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<Widget> list = this.widgets;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "Resource(resId=" + this.resId + ", src=" + this.src + ", target=" + this.target + ", url=" + this.url + ", widgets=" + this.widgets + ')';
    }

    public Resource(Long l, String str, Boolean bool, String str2, List<Widget> list) {
        this.resId = l;
        this.src = str;
        this.target = bool;
        this.url = str2;
        this.widgets = list;
    }

    public final Long getResId() {
        return this.resId;
    }

    public final String getSrc() {
        return this.src;
    }

    public final Boolean getTarget() {
        return this.target;
    }

    public final String getUrl() {
        return this.url;
    }

    public final List<Widget> getWidgets() {
        return this.widgets;
    }
}
