package io.ktor.client.request.forms;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.Input;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\f\rB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u0001\u0002\u000e\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/client/request/forms/PreparedPart;", "", "headers", "", "size", "", "([BLjava/lang/Long;)V", "getHeaders", "()[B", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "ChannelPart", "InputPart", "Lio/ktor/client/request/forms/PreparedPart$InputPart;", "Lio/ktor/client/request/forms/PreparedPart$ChannelPart;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormDataContent.kt */
abstract class PreparedPart {
    private final byte[] headers;
    private final Long size;

    public /* synthetic */ PreparedPart(byte[] bArr, Long l, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, l);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/client/request/forms/PreparedPart$InputPart;", "Lio/ktor/client/request/forms/PreparedPart;", "headers", "", "provider", "Lkotlin/Function0;", "Lio/ktor/utils/io/core/Input;", "size", "", "([BLkotlin/jvm/functions/Function0;Ljava/lang/Long;)V", "getProvider", "()Lkotlin/jvm/functions/Function0;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FormDataContent.kt */
    public static final class InputPart extends PreparedPart {
        private final Function0<Input> provider;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InputPart(byte[] bArr, Function0<? extends Input> function0, Long l) {
            super(bArr, l, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bArr, "headers");
            Intrinsics.checkNotNullParameter(function0, "provider");
            this.provider = function0;
        }

        public final Function0<Input> getProvider() {
            return this.provider;
        }
    }

    private PreparedPart(byte[] bArr, Long l) {
        this.headers = bArr;
        this.size = l;
    }

    public final byte[] getHeaders() {
        return this.headers;
    }

    public final Long getSize() {
        return this.size;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/client/request/forms/PreparedPart$ChannelPart;", "Lio/ktor/client/request/forms/PreparedPart;", "headers", "", "provider", "Lkotlin/Function0;", "Lio/ktor/utils/io/ByteReadChannel;", "size", "", "([BLkotlin/jvm/functions/Function0;Ljava/lang/Long;)V", "getProvider", "()Lkotlin/jvm/functions/Function0;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FormDataContent.kt */
    public static final class ChannelPart extends PreparedPart {
        private final Function0<ByteReadChannel> provider;

        public final Function0<ByteReadChannel> getProvider() {
            return this.provider;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChannelPart(byte[] bArr, Function0<? extends ByteReadChannel> function0, Long l) {
            super(bArr, l, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bArr, "headers");
            Intrinsics.checkNotNullParameter(function0, "provider");
            this.provider = function0;
        }
    }
}
