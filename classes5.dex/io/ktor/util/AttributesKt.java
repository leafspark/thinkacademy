package io.ktor.util;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002*J\b\u0007\u0010\u0004\u001a\u0004\b\u0000\u0010\u0005\"\b\u0012\u0004\u0012\u0002H\u00050\u00062\b\u0012\u0004\u0012\u0002H\u00050\u0006B*\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u001c\b\n\u0012\u0018\b\u000bB\u0014\b\u000b\u0012\u0006\b\f\u0012\u0002\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¨\u0006\u000f"}, d2 = {"putAll", "", "Lio/ktor/util/Attributes;", "other", "EquatableAttributeKey", "T", "Lio/ktor/util/AttributeKey;", "Lkotlin/Deprecated;", "message", "Please use `AttributeKey` class instead", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "expression", "AttributeKey", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Attributes.kt */
public final class AttributesKt {
    @Deprecated(message = "Please use `AttributeKey` class instead", replaceWith = @ReplaceWith(expression = "AttributeKey", imports = {}))
    public static /* synthetic */ void EquatableAttributeKey$annotations() {
    }

    public static final void putAll(Attributes attributes, Attributes attributes2) {
        Intrinsics.checkNotNullParameter(attributes, "<this>");
        Intrinsics.checkNotNullParameter(attributes2, "other");
        for (AttributeKey attributeKey : attributes2.getAllKeys()) {
            attributes.put(attributeKey, attributes2.get(attributeKey));
        }
    }
}
