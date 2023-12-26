package io.ktor.util;

import io.ktor.util.Attributes;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\"\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002J%\u0010\u0010\u001a\u0004\u0018\u0001H\u0011\"\b\b\u0000\u0010\u0011*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0005¢\u0006\u0002\u0010\u0012J+\u0010\u0013\u001a\u00020\u0014\"\b\b\u0000\u0010\u0011*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00052\u0006\u0010\u0015\u001a\u0002H\u0011¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u0014\"\b\b\u0000\u0010\u0011*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0005R\u001b\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lio/ktor/util/AttributesJvmBase;", "Lio/ktor/util/Attributes;", "()V", "allKeys", "", "Lio/ktor/util/AttributeKey;", "getAllKeys", "()Ljava/util/List;", "map", "", "", "getMap", "()Ljava/util/Map;", "contains", "", "key", "getOrNull", "T", "(Lio/ktor/util/AttributeKey;)Ljava/lang/Object;", "put", "", "value", "(Lio/ktor/util/AttributeKey;Ljava/lang/Object;)V", "remove", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AttributesJvm.kt */
abstract class AttributesJvmBase implements Attributes {
    /* access modifiers changed from: protected */
    public abstract Map<AttributeKey<?>, Object> getMap();

    public <T> T get(AttributeKey<T> attributeKey) {
        return Attributes.DefaultImpls.get(this, attributeKey);
    }

    public <T> T take(AttributeKey<T> attributeKey) {
        return Attributes.DefaultImpls.take(this, attributeKey);
    }

    public <T> T takeOrNull(AttributeKey<T> attributeKey) {
        return Attributes.DefaultImpls.takeOrNull(this, attributeKey);
    }

    public final <T> T getOrNull(AttributeKey<T> attributeKey) {
        Intrinsics.checkNotNullParameter(attributeKey, "key");
        return getMap().get(attributeKey);
    }

    public final boolean contains(AttributeKey<?> attributeKey) {
        Intrinsics.checkNotNullParameter(attributeKey, "key");
        return getMap().containsKey(attributeKey);
    }

    public final <T> void put(AttributeKey<T> attributeKey, T t) {
        Intrinsics.checkNotNullParameter(attributeKey, "key");
        Intrinsics.checkNotNullParameter(t, "value");
        getMap().put(attributeKey, t);
    }

    public final <T> void remove(AttributeKey<T> attributeKey) {
        Intrinsics.checkNotNullParameter(attributeKey, "key");
        getMap().remove(attributeKey);
    }

    public final List<AttributeKey<?>> getAllKeys() {
        return CollectionsKt.toList(getMap().keySet());
    }
}
