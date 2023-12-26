package com.tal.app.thinkacademy.business.home.main.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BG\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003JK\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeDataCta;", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopItemCtaNode;", "illustrationsTouch", "", "", "touchLink", "touchSidePicture", "webLink", "webSidePicture", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIllustrationsTouch", "()Ljava/util/List;", "getTouchLink", "()Ljava/lang/String;", "getTouchSidePicture", "getWebLink", "getWebSidePicture", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeDataCta.kt */
public final class ShopHomeDataCta extends ShopItemCtaNode {
    private final List<String> illustrationsTouch;
    private final String touchLink;
    private final String touchSidePicture;
    private final String webLink;
    private final String webSidePicture;

    public ShopHomeDataCta() {
        this((List) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopHomeDataCta copy$default(ShopHomeDataCta shopHomeDataCta, List<String> list, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            list = shopHomeDataCta.illustrationsTouch;
        }
        if ((i & 2) != 0) {
            str = shopHomeDataCta.touchLink;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = shopHomeDataCta.touchSidePicture;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = shopHomeDataCta.webLink;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = shopHomeDataCta.webSidePicture;
        }
        return shopHomeDataCta.copy(list, str5, str6, str7, str4);
    }

    public final List<String> component1() {
        return this.illustrationsTouch;
    }

    public final String component2() {
        return this.touchLink;
    }

    public final String component3() {
        return this.touchSidePicture;
    }

    public final String component4() {
        return this.webLink;
    }

    public final String component5() {
        return this.webSidePicture;
    }

    public final ShopHomeDataCta copy(List<String> list, String str, String str2, String str3, String str4) {
        return new ShopHomeDataCta(list, str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopHomeDataCta)) {
            return false;
        }
        ShopHomeDataCta shopHomeDataCta = (ShopHomeDataCta) obj;
        return Intrinsics.areEqual((Object) this.illustrationsTouch, (Object) shopHomeDataCta.illustrationsTouch) && Intrinsics.areEqual((Object) this.touchLink, (Object) shopHomeDataCta.touchLink) && Intrinsics.areEqual((Object) this.touchSidePicture, (Object) shopHomeDataCta.touchSidePicture) && Intrinsics.areEqual((Object) this.webLink, (Object) shopHomeDataCta.webLink) && Intrinsics.areEqual((Object) this.webSidePicture, (Object) shopHomeDataCta.webSidePicture);
    }

    public int hashCode() {
        List<String> list = this.illustrationsTouch;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.touchLink;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.touchSidePicture;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.webLink;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.webSidePicture;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "ShopHomeDataCta(illustrationsTouch=" + this.illustrationsTouch + ", touchLink=" + this.touchLink + ", touchSidePicture=" + this.touchSidePicture + ", webLink=" + this.webLink + ", webSidePicture=" + this.webSidePicture + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShopHomeDataCta(java.util.List r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0008
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0008:
            r10 = r9 & 2
            java.lang.String r0 = ""
            if (r10 == 0) goto L_0x0010
            r10 = r0
            goto L_0x0011
        L_0x0010:
            r10 = r5
        L_0x0011:
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0017
            r1 = r0
            goto L_0x0018
        L_0x0017:
            r1 = r6
        L_0x0018:
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001e
            r2 = r0
            goto L_0x001f
        L_0x001e:
            r2 = r7
        L_0x001f:
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r0 = r8
        L_0x0025:
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r1
            r9 = r2
            r10 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataCta.<init>(java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<String> getIllustrationsTouch() {
        return this.illustrationsTouch;
    }

    public final String getTouchLink() {
        return this.touchLink;
    }

    public final String getTouchSidePicture() {
        return this.touchSidePicture;
    }

    public final String getWebLink() {
        return this.webLink;
    }

    public final String getWebSidePicture() {
        return this.webSidePicture;
    }

    public ShopHomeDataCta(List<String> list, String str, String str2, String str3, String str4) {
        super((List) null, 1, (DefaultConstructorMarker) null);
        this.illustrationsTouch = list;
        this.touchLink = str;
        this.touchSidePicture = str2;
        this.webLink = str3;
        this.webSidePicture = str4;
    }
}
