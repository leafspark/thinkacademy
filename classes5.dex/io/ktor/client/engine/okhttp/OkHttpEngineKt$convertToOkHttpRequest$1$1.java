package io.ktor.client.engine.okhttp;

import io.ktor.http.HttpHeaders;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.Request;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "key", "", "value", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkHttpEngine.kt */
final class OkHttpEngineKt$convertToOkHttpRequest$1$1 extends Lambda implements Function2<String, String, Unit> {
    final /* synthetic */ Request.Builder $this_with;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OkHttpEngineKt$convertToOkHttpRequest$1$1(Request.Builder builder) {
        super(2);
        this.$this_with = builder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        if (!Intrinsics.areEqual(str, HttpHeaders.INSTANCE.getContentLength())) {
            this.$this_with.addHeader(str, str2);
        }
    }
}
