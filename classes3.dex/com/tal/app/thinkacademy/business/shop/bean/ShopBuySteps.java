package com.tal.app.thinkacademy.business.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JK\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopBuySteps;", "", "fag_name", "", "faq_desc", "schoolCode", "schoolName", "steps", "", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopBuyStepsStep;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getFag_name", "()Ljava/lang/String;", "getFaq_desc", "getSchoolCode", "getSchoolName", "getSteps", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopBuySteps.kt */
public final class ShopBuySteps {
    private final String fag_name;
    private final String faq_desc;
    private final String schoolCode;
    private final String schoolName;
    private final List<ShopBuyStepsStep> steps;

    public ShopBuySteps() {
        this((String) null, (String) null, (String) null, (String) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopBuySteps copy$default(ShopBuySteps shopBuySteps, String str, String str2, String str3, String str4, List<ShopBuyStepsStep> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopBuySteps.fag_name;
        }
        if ((i & 2) != 0) {
            str2 = shopBuySteps.faq_desc;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = shopBuySteps.schoolCode;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = shopBuySteps.schoolName;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            list = shopBuySteps.steps;
        }
        return shopBuySteps.copy(str, str5, str6, str7, list);
    }

    public final String component1() {
        return this.fag_name;
    }

    public final String component2() {
        return this.faq_desc;
    }

    public final String component3() {
        return this.schoolCode;
    }

    public final String component4() {
        return this.schoolName;
    }

    public final List<ShopBuyStepsStep> component5() {
        return this.steps;
    }

    public final ShopBuySteps copy(String str, String str2, String str3, String str4, List<ShopBuyStepsStep> list) {
        return new ShopBuySteps(str, str2, str3, str4, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopBuySteps)) {
            return false;
        }
        ShopBuySteps shopBuySteps = (ShopBuySteps) obj;
        return Intrinsics.areEqual((Object) this.fag_name, (Object) shopBuySteps.fag_name) && Intrinsics.areEqual((Object) this.faq_desc, (Object) shopBuySteps.faq_desc) && Intrinsics.areEqual((Object) this.schoolCode, (Object) shopBuySteps.schoolCode) && Intrinsics.areEqual((Object) this.schoolName, (Object) shopBuySteps.schoolName) && Intrinsics.areEqual((Object) this.steps, (Object) shopBuySteps.steps);
    }

    public int hashCode() {
        String str = this.fag_name;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.faq_desc;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.schoolCode;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.schoolName;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<ShopBuyStepsStep> list = this.steps;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "ShopBuySteps(fag_name=" + this.fag_name + ", faq_desc=" + this.faq_desc + ", schoolCode=" + this.schoolCode + ", schoolName=" + this.schoolName + ", steps=" + this.steps + ')';
    }

    public ShopBuySteps(String str, String str2, String str3, String str4, List<ShopBuyStepsStep> list) {
        this.fag_name = str;
        this.faq_desc = str2;
        this.schoolCode = str3;
        this.schoolName = str4;
        this.steps = list;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShopBuySteps(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.util.List r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.ShopBuySteps.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getFag_name() {
        return this.fag_name;
    }

    public final String getFaq_desc() {
        return this.faq_desc;
    }

    public final String getSchoolCode() {
        return this.schoolCode;
    }

    public final String getSchoolName() {
        return this.schoolName;
    }

    public final List<ShopBuyStepsStep> getSteps() {
        return this.steps;
    }
}
