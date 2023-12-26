package io.ktor.util;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J3\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH&¢\u0006\u0002\u0010\fJ\u0015\u0010\r\u001a\u00020\u000e2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0004H¦\u0002J&\u0010\u000f\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004H\u0002¢\u0006\u0002\u0010\u0010J'\u0010\u0011\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004H&¢\u0006\u0002\u0010\u0010J-\u0010\u0012\u001a\u00020\u0013\"\b\b\u0000\u0010\b*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00042\u0006\u0010\u0014\u001a\u0002H\bH&¢\u0006\u0002\u0010\u0015J \u0010\u0016\u001a\u00020\u0013\"\b\b\u0000\u0010\b*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004H&J%\u0010\u0017\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004H\u0016¢\u0006\u0002\u0010\u0010J'\u0010\u0018\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004H\u0016¢\u0006\u0002\u0010\u0010R\u001c\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, d2 = {"Lio/ktor/util/Attributes;", "", "allKeys", "", "Lio/ktor/util/AttributeKey;", "getAllKeys", "()Ljava/util/List;", "computeIfAbsent", "T", "key", "block", "Lkotlin/Function0;", "(Lio/ktor/util/AttributeKey;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "contains", "", "get", "(Lio/ktor/util/AttributeKey;)Ljava/lang/Object;", "getOrNull", "put", "", "value", "(Lio/ktor/util/AttributeKey;Ljava/lang/Object;)V", "remove", "take", "takeOrNull", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Attributes.kt */
public interface Attributes {
    <T> T computeIfAbsent(AttributeKey<T> attributeKey, Function0<? extends T> function0);

    boolean contains(AttributeKey<?> attributeKey);

    <T> T get(AttributeKey<T> attributeKey);

    List<AttributeKey<?>> getAllKeys();

    <T> T getOrNull(AttributeKey<T> attributeKey);

    <T> void put(AttributeKey<T> attributeKey, T t);

    <T> void remove(AttributeKey<T> attributeKey);

    <T> T take(AttributeKey<T> attributeKey);

    <T> T takeOrNull(AttributeKey<T> attributeKey);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Attributes.kt */
    public static final class DefaultImpls {
        public static <T> T get(Attributes attributes, AttributeKey<T> attributeKey) {
            Intrinsics.checkNotNullParameter(attributeKey, "key");
            T orNull = attributes.getOrNull(attributeKey);
            if (orNull != null) {
                return orNull;
            }
            throw new IllegalStateException("No instance for key " + attributeKey);
        }

        public static <T> T take(Attributes attributes, AttributeKey<T> attributeKey) {
            Intrinsics.checkNotNullParameter(attributeKey, "key");
            T t = attributes.get(attributeKey);
            attributes.remove(attributeKey);
            return t;
        }

        public static <T> T takeOrNull(Attributes attributes, AttributeKey<T> attributeKey) {
            Intrinsics.checkNotNullParameter(attributeKey, "key");
            T orNull = attributes.getOrNull(attributeKey);
            attributes.remove(attributeKey);
            return orNull;
        }
    }
}
