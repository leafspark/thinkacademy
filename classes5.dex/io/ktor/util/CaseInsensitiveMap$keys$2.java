package io.ktor.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/ktor/util/CaseInsensitiveString;", "Value", "", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CaseInsensitiveMap.kt */
final class CaseInsensitiveMap$keys$2 extends Lambda implements Function1<String, CaseInsensitiveString> {
    public static final CaseInsensitiveMap$keys$2 INSTANCE = new CaseInsensitiveMap$keys$2();

    CaseInsensitiveMap$keys$2() {
        super(1);
    }

    public final CaseInsensitiveString invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "$this$$receiver");
        return TextKt.caseInsensitive(str);
    }
}
