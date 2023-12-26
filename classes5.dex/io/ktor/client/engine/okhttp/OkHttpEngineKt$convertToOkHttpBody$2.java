package io.ktor.client.engine.okhttp;

import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/ktor/utils/io/ByteReadChannel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkHttpEngine.kt */
final class OkHttpEngineKt$convertToOkHttpBody$2 extends Lambda implements Function0<ByteReadChannel> {
    final /* synthetic */ OutgoingContent $this_convertToOkHttpBody;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OkHttpEngineKt$convertToOkHttpBody$2(OutgoingContent outgoingContent) {
        super(0);
        this.$this_convertToOkHttpBody = outgoingContent;
    }

    public final ByteReadChannel invoke() {
        return ((OutgoingContent.ReadChannelContent) this.$this_convertToOkHttpBody).readFrom();
    }
}
