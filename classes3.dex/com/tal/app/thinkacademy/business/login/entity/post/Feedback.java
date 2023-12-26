package com.tal.app.thinkacademy.business.login.entity.post;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ6\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/post/Feedback;", "", "tag", "", "details", "images", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "getDetails", "()Ljava/lang/String;", "getImages", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getTag", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Lcom/tal/app/thinkacademy/business/login/entity/post/Feedback;", "equals", "", "other", "hashCode", "", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubmitFeedback.kt */
public final class Feedback {
    private final String details;
    private final String[] images;
    private final String tag;

    public static /* synthetic */ Feedback copy$default(Feedback feedback, String str, String str2, String[] strArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = feedback.tag;
        }
        if ((i & 2) != 0) {
            str2 = feedback.details;
        }
        if ((i & 4) != 0) {
            strArr = feedback.images;
        }
        return feedback.copy(str, str2, strArr);
    }

    public final String component1() {
        return this.tag;
    }

    public final String component2() {
        return this.details;
    }

    public final String[] component3() {
        return this.images;
    }

    public final Feedback copy(String str, String str2, String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "images");
        return new Feedback(str, str2, strArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Feedback)) {
            return false;
        }
        Feedback feedback = (Feedback) obj;
        return Intrinsics.areEqual((Object) this.tag, (Object) feedback.tag) && Intrinsics.areEqual((Object) this.details, (Object) feedback.details) && Intrinsics.areEqual((Object) this.images, (Object) feedback.images);
    }

    public int hashCode() {
        String str = this.tag;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.details;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + Arrays.hashCode(this.images);
    }

    public String toString() {
        return "Feedback(tag=" + this.tag + ", details=" + this.details + ", images=" + Arrays.toString(this.images) + ')';
    }

    public Feedback(String str, String str2, String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "images");
        this.tag = str;
        this.details = str2;
        this.images = strArr;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getDetails() {
        return this.details;
    }

    public final String[] getImages() {
        return this.images;
    }
}
