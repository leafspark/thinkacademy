package io.ktor.client.engine.okhttp;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lokhttp3/OkHttpClient$Builder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkHttpConfig.kt */
final class OkHttpConfig$config$2 extends Lambda implements Function1<OkHttpClient.Builder, Unit> {
    final /* synthetic */ Function1<OkHttpClient.Builder, Unit> $block;
    final /* synthetic */ Function1<OkHttpClient.Builder, Unit> $oldConfig;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OkHttpConfig$config$2(Function1<? super OkHttpClient.Builder, Unit> function1, Function1<? super OkHttpClient.Builder, Unit> function12) {
        super(1);
        this.$oldConfig = function1;
        this.$block = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((OkHttpClient.Builder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(OkHttpClient.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$this$null");
        this.$oldConfig.invoke(builder);
        this.$block.invoke(builder);
    }
}
