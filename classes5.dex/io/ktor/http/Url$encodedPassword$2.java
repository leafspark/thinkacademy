package io.ktor.http;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Url.kt */
final class Url$encodedPassword$2 extends Lambda implements Function0<String> {
    final /* synthetic */ Url this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Url$encodedPassword$2(Url url) {
        super(0);
        this.this$0 = url;
    }

    public final String invoke() {
        if (this.this$0.getPassword() == null) {
            return null;
        }
        if (this.this$0.getPassword().length() == 0) {
            return "";
        }
        String substring = this.this$0.urlString.substring(StringsKt.indexOf$default((CharSequence) this.this$0.urlString, ':', this.this$0.getProtocol().getName().length() + 3, false, 4, (Object) null) + 1, StringsKt.indexOf$default((CharSequence) this.this$0.urlString, '@', 0, false, 6, (Object) null));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }
}
