package com.tal.app.thinkacademy.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003JC\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006#"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/HwShareWebPageUrlBean;", "", "type", "", "title", "", "description", "thumbData", "webpageUrl", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getThumbData", "setThumbData", "getTitle", "setTitle", "getType", "()I", "setType", "(I)V", "getWebpageUrl", "setWebpageUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwShareWebPageUrlBean.kt */
public final class HwShareWebPageUrlBean {
    private String description;
    private String thumbData;
    private String title;
    private int type;
    private String webpageUrl;

    public HwShareWebPageUrlBean() {
        this(0, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ HwShareWebPageUrlBean copy$default(HwShareWebPageUrlBean hwShareWebPageUrlBean, int i, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = hwShareWebPageUrlBean.type;
        }
        if ((i2 & 2) != 0) {
            str = hwShareWebPageUrlBean.title;
        }
        String str5 = str;
        if ((i2 & 4) != 0) {
            str2 = hwShareWebPageUrlBean.description;
        }
        String str6 = str2;
        if ((i2 & 8) != 0) {
            str3 = hwShareWebPageUrlBean.thumbData;
        }
        String str7 = str3;
        if ((i2 & 16) != 0) {
            str4 = hwShareWebPageUrlBean.webpageUrl;
        }
        return hwShareWebPageUrlBean.copy(i, str5, str6, str7, str4);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.thumbData;
    }

    public final String component5() {
        return this.webpageUrl;
    }

    public final HwShareWebPageUrlBean copy(int i, String str, String str2, String str3, String str4) {
        return new HwShareWebPageUrlBean(i, str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HwShareWebPageUrlBean)) {
            return false;
        }
        HwShareWebPageUrlBean hwShareWebPageUrlBean = (HwShareWebPageUrlBean) obj;
        return this.type == hwShareWebPageUrlBean.type && Intrinsics.areEqual(this.title, hwShareWebPageUrlBean.title) && Intrinsics.areEqual(this.description, hwShareWebPageUrlBean.description) && Intrinsics.areEqual(this.thumbData, hwShareWebPageUrlBean.thumbData) && Intrinsics.areEqual(this.webpageUrl, hwShareWebPageUrlBean.webpageUrl);
    }

    public int hashCode() {
        int i = this.type * 31;
        String str = this.title;
        int i2 = 0;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.thumbData;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.webpageUrl;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        return "HwShareWebPageUrlBean(type=" + this.type + ", title=" + this.title + ", description=" + this.description + ", thumbData=" + this.thumbData + ", webpageUrl=" + this.webpageUrl + ')';
    }

    public HwShareWebPageUrlBean(int i, String str, String str2, String str3, String str4) {
        this.type = i;
        this.title = str;
        this.description = str2;
        this.thumbData = str3;
        this.webpageUrl = str4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HwShareWebPageUrlBean(int r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0005
            r4 = 1
        L_0x0005:
            r10 = r9 & 2
            java.lang.String r0 = ""
            if (r10 == 0) goto L_0x000d
            r10 = r0
            goto L_0x000e
        L_0x000d:
            r10 = r5
        L_0x000e:
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0014
            r1 = r0
            goto L_0x0015
        L_0x0014:
            r1 = r6
        L_0x0015:
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001b
            r2 = r0
            goto L_0x001c
        L_0x001b:
            r2 = r7
        L_0x001c:
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r0 = r8
        L_0x0022:
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r1
            r9 = r2
            r10 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.entity.HwShareWebPageUrlBean.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final String getThumbData() {
        return this.thumbData;
    }

    public final void setThumbData(String str) {
        this.thumbData = str;
    }

    public final String getWebpageUrl() {
        return this.webpageUrl;
    }

    public final void setWebpageUrl(String str) {
        this.webpageUrl = str;
    }
}
