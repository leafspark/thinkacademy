package com.tal.thinkacademy.networkprobe;

import com.yanzhenjie.andserver.util.HttpHeaders;
import io.ktor.http.HeadersBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lio/ktor/http/HeadersBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetProbe.kt */
final class NetProbe$get$2$1 extends Lambda implements Function1<HeadersBuilder, Unit> {
    public static final NetProbe$get$2$1 INSTANCE = new NetProbe$get$2$1();

    NetProbe$get$2$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((HeadersBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(HeadersBuilder headersBuilder) {
        Intrinsics.checkNotNullParameter(headersBuilder, "$this$headers");
        headersBuilder.append(HttpHeaders.CONNECTION, "close");
    }
}
