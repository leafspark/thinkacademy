package io.ktor.client.request.forms;

import io.ktor.utils.io.core.ByteReadPacketExtensionsKt;
import io.ktor.utils.io.core.Input;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/ktor/utils/io/core/Input;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: formDsl.kt */
final class FormDslKt$formData$1$part$3 extends Lambda implements Function0<Input> {
    final /* synthetic */ Object $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FormDslKt$formData$1$part$3(Object obj) {
        super(0);
        this.$value = obj;
    }

    public final Input invoke() {
        byte[] bArr = (byte[]) this.$value;
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, bArr.length);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(array, offset, length)");
        return ByteReadPacketExtensionsKt.ByteReadPacket(wrap, new FormDslKt$formData$1$part$3$invoke$$inlined$ByteReadPacket$default$1(bArr));
    }
}
