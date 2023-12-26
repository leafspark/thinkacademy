package com.tal.app.thinkacademy.live.business.function.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/function/bean/ForbiddenStudentEmoji;", "", "pub", "", "(Ljava/lang/Boolean;)V", "getPub", "()Ljava/lang/Boolean;", "setPub", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/tal/app/thinkacademy/live/business/function/bean/ForbiddenStudentEmoji;", "equals", "other", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiControlsData.kt */
public final class ForbiddenStudentEmoji {
    private Boolean pub;

    public ForbiddenStudentEmoji() {
        this((Boolean) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ForbiddenStudentEmoji copy$default(ForbiddenStudentEmoji forbiddenStudentEmoji, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = forbiddenStudentEmoji.pub;
        }
        return forbiddenStudentEmoji.copy(bool);
    }

    public final Boolean component1() {
        return this.pub;
    }

    public final ForbiddenStudentEmoji copy(Boolean bool) {
        return new ForbiddenStudentEmoji(bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ForbiddenStudentEmoji) && Intrinsics.areEqual(this.pub, ((ForbiddenStudentEmoji) obj).pub);
    }

    public int hashCode() {
        Boolean bool = this.pub;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public String toString() {
        return "ForbiddenStudentEmoji(pub=" + this.pub + ')';
    }

    public ForbiddenStudentEmoji(Boolean bool) {
        this.pub = bool;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ForbiddenStudentEmoji(Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : bool);
    }

    public final Boolean getPub() {
        return this.pub;
    }

    public final void setPub(Boolean bool) {
        this.pub = bool;
    }
}
