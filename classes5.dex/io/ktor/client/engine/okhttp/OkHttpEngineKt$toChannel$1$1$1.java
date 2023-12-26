package io.ktor.client.engine.okhttp;

import io.ktor.client.request.HttpRequestData;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import okio.BufferedSource;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkHttpEngine.kt */
final class OkHttpEngineKt$toChannel$1$1$1 extends Lambda implements Function1<ByteBuffer, Unit> {
    final /* synthetic */ Ref.IntRef $lastRead;
    final /* synthetic */ HttpRequestData $requestData;
    final /* synthetic */ BufferedSource $source;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OkHttpEngineKt$toChannel$1$1$1(Ref.IntRef intRef, BufferedSource bufferedSource, HttpRequestData httpRequestData) {
        super(1);
        this.$lastRead = intRef;
        this.$source = bufferedSource;
        this.$requestData = httpRequestData;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ByteBuffer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        try {
            this.$lastRead.element = this.$source.read(byteBuffer);
        } catch (Throwable th) {
            throw OkHttpEngineKt.mapExceptions(th, this.$requestData);
        }
    }
}
