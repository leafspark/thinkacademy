package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/CheckCanGotoBuyBean;", "", "continue", "", "helper", "Lcom/tal/app/thinkacademy/business/shop/bean/CanGotoBuyHelper;", "(ZLcom/tal/app/thinkacademy/business/shop/bean/CanGotoBuyHelper;)V", "getContinue", "()Z", "getHelper", "()Lcom/tal/app/thinkacademy/business/shop/bean/CanGotoBuyHelper;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CheckCanGotoBuyBean.kt */
public final class CheckCanGotoBuyBean {

    /* renamed from: continue  reason: not valid java name */
    private final boolean f3continue;
    private final CanGotoBuyHelper helper;

    public CheckCanGotoBuyBean() {
        this(false, (CanGotoBuyHelper) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CheckCanGotoBuyBean copy$default(CheckCanGotoBuyBean checkCanGotoBuyBean, boolean z, CanGotoBuyHelper canGotoBuyHelper, int i, Object obj) {
        if ((i & 1) != 0) {
            z = checkCanGotoBuyBean.f3continue;
        }
        if ((i & 2) != 0) {
            canGotoBuyHelper = checkCanGotoBuyBean.helper;
        }
        return checkCanGotoBuyBean.copy(z, canGotoBuyHelper);
    }

    public final boolean component1() {
        return this.f3continue;
    }

    public final CanGotoBuyHelper component2() {
        return this.helper;
    }

    public final CheckCanGotoBuyBean copy(boolean z, CanGotoBuyHelper canGotoBuyHelper) {
        return new CheckCanGotoBuyBean(z, canGotoBuyHelper);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckCanGotoBuyBean)) {
            return false;
        }
        CheckCanGotoBuyBean checkCanGotoBuyBean = (CheckCanGotoBuyBean) obj;
        return this.f3continue == checkCanGotoBuyBean.f3continue && Intrinsics.areEqual((Object) this.helper, (Object) checkCanGotoBuyBean.helper);
    }

    public int hashCode() {
        boolean z = this.f3continue;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        CanGotoBuyHelper canGotoBuyHelper = this.helper;
        return i + (canGotoBuyHelper == null ? 0 : canGotoBuyHelper.hashCode());
    }

    public String toString() {
        return "CheckCanGotoBuyBean(continue=" + this.f3continue + ", helper=" + this.helper + ')';
    }

    public CheckCanGotoBuyBean(boolean z, CanGotoBuyHelper canGotoBuyHelper) {
        this.f3continue = z;
        this.helper = canGotoBuyHelper;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CheckCanGotoBuyBean(boolean z, CanGotoBuyHelper canGotoBuyHelper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : canGotoBuyHelper);
    }

    public final boolean getContinue() {
        return this.f3continue;
    }

    public final CanGotoBuyHelper getHelper() {
        return this.helper;
    }
}
