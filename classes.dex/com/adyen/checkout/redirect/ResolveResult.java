package com.adyen.checkout.redirect;

import android.content.pm.ResolveInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/adyen/checkout/redirect/ResolveResult;", "", "type", "Lcom/adyen/checkout/redirect/ResolveResult$Type;", "resolveInfo", "Landroid/content/pm/ResolveInfo;", "(Lcom/adyen/checkout/redirect/ResolveResult$Type;Landroid/content/pm/ResolveInfo;)V", "getResolveInfo", "()Landroid/content/pm/ResolveInfo;", "getType", "()Lcom/adyen/checkout/redirect/ResolveResult$Type;", "Type", "redirect_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ResolveResult.kt */
public final class ResolveResult {
    private final ResolveInfo resolveInfo;
    private final Type type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/adyen/checkout/redirect/ResolveResult$Type;", "", "(Ljava/lang/String;I)V", "RESOLVER_ACTIVITY", "DEFAULT_BROWSER", "APPLICATION", "UNKNOWN", "redirect_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ResolveResult.kt */
    public enum Type {
        RESOLVER_ACTIVITY,
        DEFAULT_BROWSER,
        APPLICATION,
        UNKNOWN
    }

    public ResolveResult(Type type2, ResolveInfo resolveInfo2) {
        Intrinsics.checkNotNullParameter(type2, "type");
        this.type = type2;
        this.resolveInfo = resolveInfo2;
    }

    public final ResolveInfo getResolveInfo() {
        return this.resolveInfo;
    }

    public final Type getType() {
        return this.type;
    }
}
