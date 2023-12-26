package com.tal.app.thinkacademy.common.entity;

import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fJ\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003Jw\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0007HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0007HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0011¨\u00065"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/OrderPlayResponseBean;", "", "businessCode", "", "merchantCode", "merchantOrderNo", "payProduct", "", "goodsName", "goodsDetail", "totalFee", "reqTime", "currency", "notifyUrl", "timeOut", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getBusinessCode", "()Ljava/lang/String;", "setBusinessCode", "(Ljava/lang/String;)V", "getCurrency", "getGoodsDetail", "getGoodsName", "setGoodsName", "getMerchantCode", "setMerchantCode", "getMerchantOrderNo", "setMerchantOrderNo", "getNotifyUrl", "getPayProduct", "()I", "setPayProduct", "(I)V", "getReqTime", "getTimeOut", "getTotalFee", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OrderPlayResponseBean.kt */
public final class OrderPlayResponseBean {
    private String businessCode;
    private final String currency;
    private final String goodsDetail;
    private String goodsName;
    private String merchantCode;
    private String merchantOrderNo;
    private final String notifyUrl;
    private int payProduct;
    private final String reqTime;
    private final int timeOut;
    private final String totalFee;

    public OrderPlayResponseBean() {
        this((String) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 2047, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OrderPlayResponseBean copy$default(OrderPlayResponseBean orderPlayResponseBean, String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, String str9, int i2, int i3, Object obj) {
        OrderPlayResponseBean orderPlayResponseBean2 = orderPlayResponseBean;
        int i4 = i3;
        return orderPlayResponseBean.copy((i4 & 1) != 0 ? orderPlayResponseBean2.businessCode : str, (i4 & 2) != 0 ? orderPlayResponseBean2.merchantCode : str2, (i4 & 4) != 0 ? orderPlayResponseBean2.merchantOrderNo : str3, (i4 & 8) != 0 ? orderPlayResponseBean2.payProduct : i, (i4 & 16) != 0 ? orderPlayResponseBean2.goodsName : str4, (i4 & 32) != 0 ? orderPlayResponseBean2.goodsDetail : str5, (i4 & 64) != 0 ? orderPlayResponseBean2.totalFee : str6, (i4 & LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP) != 0 ? orderPlayResponseBean2.reqTime : str7, (i4 & 256) != 0 ? orderPlayResponseBean2.currency : str8, (i4 & 512) != 0 ? orderPlayResponseBean2.notifyUrl : str9, (i4 & 1024) != 0 ? orderPlayResponseBean2.timeOut : i2);
    }

    public final String component1() {
        return this.businessCode;
    }

    public final String component10() {
        return this.notifyUrl;
    }

    public final int component11() {
        return this.timeOut;
    }

    public final String component2() {
        return this.merchantCode;
    }

    public final String component3() {
        return this.merchantOrderNo;
    }

    public final int component4() {
        return this.payProduct;
    }

    public final String component5() {
        return this.goodsName;
    }

    public final String component6() {
        return this.goodsDetail;
    }

    public final String component7() {
        return this.totalFee;
    }

    public final String component8() {
        return this.reqTime;
    }

    public final String component9() {
        return this.currency;
    }

    public final OrderPlayResponseBean copy(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, String str9, int i2) {
        Intrinsics.checkNotNullParameter(str, "businessCode");
        Intrinsics.checkNotNullParameter(str2, "merchantCode");
        String str10 = str3;
        Intrinsics.checkNotNullParameter(str10, "merchantOrderNo");
        String str11 = str4;
        Intrinsics.checkNotNullParameter(str11, "goodsName");
        String str12 = str5;
        Intrinsics.checkNotNullParameter(str12, "goodsDetail");
        String str13 = str6;
        Intrinsics.checkNotNullParameter(str13, "totalFee");
        String str14 = str7;
        Intrinsics.checkNotNullParameter(str14, "reqTime");
        String str15 = str8;
        Intrinsics.checkNotNullParameter(str15, "currency");
        String str16 = str9;
        Intrinsics.checkNotNullParameter(str16, "notifyUrl");
        return new OrderPlayResponseBean(str, str2, str10, i, str11, str12, str13, str14, str15, str16, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderPlayResponseBean)) {
            return false;
        }
        OrderPlayResponseBean orderPlayResponseBean = (OrderPlayResponseBean) obj;
        return Intrinsics.areEqual(this.businessCode, orderPlayResponseBean.businessCode) && Intrinsics.areEqual(this.merchantCode, orderPlayResponseBean.merchantCode) && Intrinsics.areEqual(this.merchantOrderNo, orderPlayResponseBean.merchantOrderNo) && this.payProduct == orderPlayResponseBean.payProduct && Intrinsics.areEqual(this.goodsName, orderPlayResponseBean.goodsName) && Intrinsics.areEqual(this.goodsDetail, orderPlayResponseBean.goodsDetail) && Intrinsics.areEqual(this.totalFee, orderPlayResponseBean.totalFee) && Intrinsics.areEqual(this.reqTime, orderPlayResponseBean.reqTime) && Intrinsics.areEqual(this.currency, orderPlayResponseBean.currency) && Intrinsics.areEqual(this.notifyUrl, orderPlayResponseBean.notifyUrl) && this.timeOut == orderPlayResponseBean.timeOut;
    }

    public int hashCode() {
        return (((((((((((((((((((this.businessCode.hashCode() * 31) + this.merchantCode.hashCode()) * 31) + this.merchantOrderNo.hashCode()) * 31) + this.payProduct) * 31) + this.goodsName.hashCode()) * 31) + this.goodsDetail.hashCode()) * 31) + this.totalFee.hashCode()) * 31) + this.reqTime.hashCode()) * 31) + this.currency.hashCode()) * 31) + this.notifyUrl.hashCode()) * 31) + this.timeOut;
    }

    public String toString() {
        return "OrderPlayResponseBean(businessCode=" + this.businessCode + ", merchantCode=" + this.merchantCode + ", merchantOrderNo=" + this.merchantOrderNo + ", payProduct=" + this.payProduct + ", goodsName=" + this.goodsName + ", goodsDetail=" + this.goodsDetail + ", totalFee=" + this.totalFee + ", reqTime=" + this.reqTime + ", currency=" + this.currency + ", notifyUrl=" + this.notifyUrl + ", timeOut=" + this.timeOut + ')';
    }

    public OrderPlayResponseBean(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, String str9, int i2) {
        Intrinsics.checkNotNullParameter(str, "businessCode");
        Intrinsics.checkNotNullParameter(str2, "merchantCode");
        Intrinsics.checkNotNullParameter(str3, "merchantOrderNo");
        Intrinsics.checkNotNullParameter(str4, "goodsName");
        Intrinsics.checkNotNullParameter(str5, "goodsDetail");
        Intrinsics.checkNotNullParameter(str6, "totalFee");
        Intrinsics.checkNotNullParameter(str7, "reqTime");
        Intrinsics.checkNotNullParameter(str8, "currency");
        Intrinsics.checkNotNullParameter(str9, "notifyUrl");
        this.businessCode = str;
        this.merchantCode = str2;
        this.merchantOrderNo = str3;
        this.payProduct = i;
        this.goodsName = str4;
        this.goodsDetail = str5;
        this.totalFee = str6;
        this.reqTime = str7;
        this.currency = str8;
        this.notifyUrl = str9;
        this.timeOut = i2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OrderPlayResponseBean(java.lang.String r14, java.lang.String r15, java.lang.String r16, int r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, int r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r13 = this;
            r0 = r25
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000b
        L_0x000a:
            r1 = r14
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0012
        L_0x0011:
            r3 = r15
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r2
            goto L_0x001a
        L_0x0018:
            r4 = r16
        L_0x001a:
            r5 = r0 & 8
            r6 = 0
            if (r5 == 0) goto L_0x0021
            r5 = r6
            goto L_0x0023
        L_0x0021:
            r5 = r17
        L_0x0023:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0029
            r7 = r2
            goto L_0x002b
        L_0x0029:
            r7 = r18
        L_0x002b:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0031
            r8 = r2
            goto L_0x0033
        L_0x0031:
            r8 = r19
        L_0x0033:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0039
            r9 = r2
            goto L_0x003b
        L_0x0039:
            r9 = r20
        L_0x003b:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0041
            r10 = r2
            goto L_0x0043
        L_0x0041:
            r10 = r21
        L_0x0043:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0049
            r11 = r2
            goto L_0x004b
        L_0x0049:
            r11 = r22
        L_0x004b:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r2 = r23
        L_0x0052:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0057
            goto L_0x0059
        L_0x0057:
            r6 = r24
        L_0x0059:
            r14 = r13
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r7
            r20 = r8
            r21 = r9
            r22 = r10
            r23 = r11
            r24 = r2
            r25 = r6
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.entity.OrderPlayResponseBean.<init>(java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getBusinessCode() {
        return this.businessCode;
    }

    public final void setBusinessCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.businessCode = str;
    }

    public final String getMerchantCode() {
        return this.merchantCode;
    }

    public final void setMerchantCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.merchantCode = str;
    }

    public final String getMerchantOrderNo() {
        return this.merchantOrderNo;
    }

    public final void setMerchantOrderNo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.merchantOrderNo = str;
    }

    public final int getPayProduct() {
        return this.payProduct;
    }

    public final void setPayProduct(int i) {
        this.payProduct = i;
    }

    public final String getGoodsName() {
        return this.goodsName;
    }

    public final void setGoodsName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.goodsName = str;
    }

    public final String getGoodsDetail() {
        return this.goodsDetail;
    }

    public final String getTotalFee() {
        return this.totalFee;
    }

    public final String getReqTime() {
        return this.reqTime;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getNotifyUrl() {
        return this.notifyUrl;
    }

    public final int getTimeOut() {
        return this.timeOut;
    }
}
