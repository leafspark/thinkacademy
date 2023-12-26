package io.ktor.client.engine.okhttp;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lokhttp3/OkHttpClient;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkHttpEngine.kt */
final class OkHttpEngine$clientCache$2 extends Lambda implements Function1<OkHttpClient, Unit> {
    public static final OkHttpEngine$clientCache$2 INSTANCE = new OkHttpEngine$clientCache$2();

    OkHttpEngine$clientCache$2() {
        super(1);
    }

    public final void invoke(OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((OkHttpClient) obj);
        return Unit.INSTANCE;
    }
}
