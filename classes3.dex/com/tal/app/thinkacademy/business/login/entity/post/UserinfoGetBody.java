package com.tal.app.thinkacademy.business.login.entity.post;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/post/UserinfoGetBody;", "", "head", "Lcom/tal/app/thinkacademy/business/login/entity/post/UserinfoGetBodyHead;", "(Lcom/tal/app/thinkacademy/business/login/entity/post/UserinfoGetBodyHead;)V", "getHead", "()Lcom/tal/app/thinkacademy/business/login/entity/post/UserinfoGetBodyHead;", "setHead", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserinfoGetBody.kt */
public final class UserinfoGetBody {
    private UserinfoGetBodyHead head;

    public UserinfoGetBody() {
        this((UserinfoGetBodyHead) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UserinfoGetBody copy$default(UserinfoGetBody userinfoGetBody, UserinfoGetBodyHead userinfoGetBodyHead, int i, Object obj) {
        if ((i & 1) != 0) {
            userinfoGetBodyHead = userinfoGetBody.head;
        }
        return userinfoGetBody.copy(userinfoGetBodyHead);
    }

    public final UserinfoGetBodyHead component1() {
        return this.head;
    }

    public final UserinfoGetBody copy(UserinfoGetBodyHead userinfoGetBodyHead) {
        Intrinsics.checkNotNullParameter(userinfoGetBodyHead, "head");
        return new UserinfoGetBody(userinfoGetBodyHead);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UserinfoGetBody) && Intrinsics.areEqual((Object) this.head, (Object) ((UserinfoGetBody) obj).head);
    }

    public int hashCode() {
        return this.head.hashCode();
    }

    public String toString() {
        return "UserinfoGetBody(head=" + this.head + ')';
    }

    public UserinfoGetBody(UserinfoGetBodyHead userinfoGetBodyHead) {
        Intrinsics.checkNotNullParameter(userinfoGetBodyHead, "head");
        this.head = userinfoGetBodyHead;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserinfoGetBody(UserinfoGetBodyHead userinfoGetBodyHead, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserinfoGetBodyHead((String) null, 1, (DefaultConstructorMarker) null) : userinfoGetBodyHead);
    }

    public final UserinfoGetBodyHead getHead() {
        return this.head;
    }

    public final void setHead(UserinfoGetBodyHead userinfoGetBodyHead) {
        Intrinsics.checkNotNullParameter(userinfoGetBodyHead, "<set-?>");
        this.head = userinfoGetBodyHead;
    }
}
