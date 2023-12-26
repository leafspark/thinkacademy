package com.tal.app.thinkacademy.common.imconfig;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J5\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/CourseStorePurchaseGuide;", "", "fag_name", "", "faq_desc", "steps", "", "Lcom/tal/app/thinkacademy/common/imconfig/Step;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getFag_name", "()Ljava/lang/String;", "getFaq_desc", "getSteps", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchoolListInfo.kt */
public final class CourseStorePurchaseGuide {
    private final String fag_name;
    private final String faq_desc;
    private final List<Step> steps;

    public CourseStorePurchaseGuide() {
        this((String) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CourseStorePurchaseGuide copy$default(CourseStorePurchaseGuide courseStorePurchaseGuide, String str, String str2, List<Step> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = courseStorePurchaseGuide.fag_name;
        }
        if ((i & 2) != 0) {
            str2 = courseStorePurchaseGuide.faq_desc;
        }
        if ((i & 4) != 0) {
            list = courseStorePurchaseGuide.steps;
        }
        return courseStorePurchaseGuide.copy(str, str2, list);
    }

    public final String component1() {
        return this.fag_name;
    }

    public final String component2() {
        return this.faq_desc;
    }

    public final List<Step> component3() {
        return this.steps;
    }

    public final CourseStorePurchaseGuide copy(String str, String str2, List<Step> list) {
        return new CourseStorePurchaseGuide(str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CourseStorePurchaseGuide)) {
            return false;
        }
        CourseStorePurchaseGuide courseStorePurchaseGuide = (CourseStorePurchaseGuide) obj;
        return Intrinsics.areEqual(this.fag_name, courseStorePurchaseGuide.fag_name) && Intrinsics.areEqual(this.faq_desc, courseStorePurchaseGuide.faq_desc) && Intrinsics.areEqual(this.steps, courseStorePurchaseGuide.steps);
    }

    public int hashCode() {
        String str = this.fag_name;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.faq_desc;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<Step> list = this.steps;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "CourseStorePurchaseGuide(fag_name=" + this.fag_name + ", faq_desc=" + this.faq_desc + ", steps=" + this.steps + ')';
    }

    public CourseStorePurchaseGuide(String str, String str2, List<Step> list) {
        this.fag_name = str;
        this.faq_desc = str2;
        this.steps = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CourseStorePurchaseGuide(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list);
    }

    public final String getFag_name() {
        return this.fag_name;
    }

    public final String getFaq_desc() {
        return this.faq_desc;
    }

    public final List<Step> getSteps() {
        return this.steps;
    }
}
