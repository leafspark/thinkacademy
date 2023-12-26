package io.ktor.http;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "invoke", "(Lkotlin/Pair;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Cookie.kt */
final class CookieKt$parseClientCookiesHeader$2 extends Lambda implements Function1<Pair<? extends String, ? extends String>, Boolean> {
    final /* synthetic */ boolean $skipEscaped;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CookieKt$parseClientCookiesHeader$2(boolean z) {
        super(1);
        this.$skipEscaped = z;
    }

    public final Boolean invoke(Pair<String, String> pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        boolean z = false;
        if (!this.$skipEscaped || !StringsKt.startsWith$default(pair.getFirst(), "$", false, 2, (Object) null)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
