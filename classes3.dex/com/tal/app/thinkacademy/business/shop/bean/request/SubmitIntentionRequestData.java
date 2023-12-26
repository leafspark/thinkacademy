package com.tal.app.thinkacademy.business.shop.bean.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014JV\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\tHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000e¨\u0006)"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/request/SubmitIntentionRequestData;", "", "yearGroup", "", "day", "time", "email", "name", "subStatus", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getDay", "()Ljava/lang/String;", "setDay", "(Ljava/lang/String;)V", "getEmail", "setEmail", "getName", "setName", "getSubStatus", "()Ljava/lang/Integer;", "setSubStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTime", "setTime", "getYearGroup", "setYearGroup", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/business/shop/bean/request/SubmitIntentionRequestData;", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubmitIntentionRequestData.kt */
public final class SubmitIntentionRequestData {
    private String day;
    private String email;
    private String name;
    private Integer subStatus;
    private String time;
    private String yearGroup;

    public static /* synthetic */ SubmitIntentionRequestData copy$default(SubmitIntentionRequestData submitIntentionRequestData, String str, String str2, String str3, String str4, String str5, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = submitIntentionRequestData.yearGroup;
        }
        if ((i & 2) != 0) {
            str2 = submitIntentionRequestData.day;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = submitIntentionRequestData.time;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = submitIntentionRequestData.email;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = submitIntentionRequestData.name;
        }
        String str9 = str5;
        if ((i & 32) != 0) {
            num = submitIntentionRequestData.subStatus;
        }
        return submitIntentionRequestData.copy(str, str6, str7, str8, str9, num);
    }

    public final String component1() {
        return this.yearGroup;
    }

    public final String component2() {
        return this.day;
    }

    public final String component3() {
        return this.time;
    }

    public final String component4() {
        return this.email;
    }

    public final String component5() {
        return this.name;
    }

    public final Integer component6() {
        return this.subStatus;
    }

    public final SubmitIntentionRequestData copy(String str, String str2, String str3, String str4, String str5, Integer num) {
        return new SubmitIntentionRequestData(str, str2, str3, str4, str5, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubmitIntentionRequestData)) {
            return false;
        }
        SubmitIntentionRequestData submitIntentionRequestData = (SubmitIntentionRequestData) obj;
        return Intrinsics.areEqual((Object) this.yearGroup, (Object) submitIntentionRequestData.yearGroup) && Intrinsics.areEqual((Object) this.day, (Object) submitIntentionRequestData.day) && Intrinsics.areEqual((Object) this.time, (Object) submitIntentionRequestData.time) && Intrinsics.areEqual((Object) this.email, (Object) submitIntentionRequestData.email) && Intrinsics.areEqual((Object) this.name, (Object) submitIntentionRequestData.name) && Intrinsics.areEqual((Object) this.subStatus, (Object) submitIntentionRequestData.subStatus);
    }

    public int hashCode() {
        String str = this.yearGroup;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.day;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.time;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.email;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.name;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.subStatus;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "SubmitIntentionRequestData(yearGroup=" + this.yearGroup + ", day=" + this.day + ", time=" + this.time + ", email=" + this.email + ", name=" + this.name + ", subStatus=" + this.subStatus + ')';
    }

    public SubmitIntentionRequestData(String str, String str2, String str3, String str4, String str5, Integer num) {
        this.yearGroup = str;
        this.day = str2;
        this.time = str3;
        this.email = str4;
        this.name = str5;
        this.subStatus = num;
    }

    public final String getYearGroup() {
        return this.yearGroup;
    }

    public final void setYearGroup(String str) {
        this.yearGroup = str;
    }

    public final String getDay() {
        return this.day;
    }

    public final void setDay(String str) {
        this.day = str;
    }

    public final String getTime() {
        return this.time;
    }

    public final void setTime(String str) {
        this.time = str;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubmitIntentionRequestData(String str, String str2, String str3, String str4, String str5, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, (i & 32) != 0 ? 1 : num);
    }

    public final Integer getSubStatus() {
        return this.subStatus;
    }

    public final void setSubStatus(Integer num) {
        this.subStatus = num;
    }
}
