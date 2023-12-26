package io.ktor.util;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J3\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eR&\u0010\u0003\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lio/ktor/util/ConcurrentSafeAttributes;", "Lio/ktor/util/AttributesJvmBase;", "()V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "Lio/ktor/util/AttributeKey;", "", "getMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "computeIfAbsent", "T", "key", "block", "Lkotlin/Function0;", "(Lio/ktor/util/AttributeKey;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AttributesJvm.kt */
final class ConcurrentSafeAttributes extends AttributesJvmBase {
    private final ConcurrentHashMap<AttributeKey<?>, Object> map = new ConcurrentHashMap<>();

    /* access modifiers changed from: protected */
    public ConcurrentHashMap<AttributeKey<?>, Object> getMap() {
        return this.map;
    }

    public <T> T computeIfAbsent(AttributeKey<T> attributeKey, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(attributeKey, "key");
        Intrinsics.checkNotNullParameter(function0, "block");
        T t = getMap().get(attributeKey);
        if (t != null) {
            return t;
        }
        T invoke = function0.invoke();
        T putIfAbsent = getMap().putIfAbsent(attributeKey, invoke);
        return putIfAbsent == null ? invoke : putIfAbsent;
    }
}
