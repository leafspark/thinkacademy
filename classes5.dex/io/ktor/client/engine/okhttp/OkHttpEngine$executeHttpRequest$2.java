package io.ktor.client.engine.okhttp;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkHttpEngine.kt */
final class OkHttpEngine$executeHttpRequest$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ ResponseBody $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OkHttpEngine$executeHttpRequest$2(ResponseBody responseBody) {
        super(1);
        this.$body = responseBody;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        ResponseBody responseBody = this.$body;
        if (responseBody != null) {
            responseBody.close();
        }
    }
}
