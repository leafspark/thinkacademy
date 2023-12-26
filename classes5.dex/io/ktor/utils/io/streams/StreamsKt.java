package io.ktor.utils.io.streams;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.InputArraysKt;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.OutputKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a\u0012\u0010\b\u001a\u00020\u0004*\u00020\u00032\u0006\u0010\t\u001a\u00020\n\u001a\u0012\u0010\u000b\u001a\u00020\u0004*\u00020\u00032\u0006\u0010\t\u001a\u00020\n\u001a\u0012\u0010\f\u001a\u00020\u0004*\u00020\u00032\u0006\u0010\t\u001a\u00020\n\u001a\u001c\u0010\r\u001a\u00020\u0004*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002\u001a\n\u0010\u0010\u001a\u00020\u0011*\u00020\u0004\u001a#\u0010\u0012\u001a\u00020\u0013*\u00020\u00062\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\u0002\b\u0016\u001a\u0012\u0010\u0012\u001a\u00020\u0013*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0004\u001a\n\u0010\u0018\u001a\u00020\u0019*\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"SkipBuffer", "", "inputStream", "Ljava/io/InputStream;", "Lio/ktor/utils/io/core/ByteReadPacket;", "outputStream", "Ljava/io/OutputStream;", "Lio/ktor/utils/io/core/BytePacketBuilder;", "readPacketAtLeast", "n", "", "readPacketAtMost", "readPacketExact", "readPacketImpl", "min", "max", "readerUTF8", "Ljava/io/Reader;", "writePacket", "", "builder", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "packet", "writerUTF8", "Ljava/io/Writer;", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Streams.kt */
public final class StreamsKt {
    /* access modifiers changed from: private */
    public static final char[] SkipBuffer = new char[Marshallable.PROTO_PACKET_SIZE];

    public static final void writePacket(OutputStream outputStream, ByteReadPacket byteReadPacket) {
        Intrinsics.checkNotNullParameter(outputStream, "<this>");
        Intrinsics.checkNotNullParameter(byteReadPacket, "packet");
        long remaining = byteReadPacket.getRemaining();
        if (remaining != 0) {
            byte[] bArr = new byte[((int) RangesKt.coerceAtMost(remaining, ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF))];
            while (!byteReadPacket.getEndOfInput()) {
                try {
                    outputStream.write(bArr, 0, InputArraysKt.readAvailable$default((Input) byteReadPacket, bArr, 0, 0, 6, (Object) null));
                } finally {
                    byteReadPacket.release();
                }
            }
        }
    }

    public static final ByteReadPacket readPacketExact(InputStream inputStream, long j) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        return readPacketImpl(inputStream, j, j);
    }

    public static final ByteReadPacket readPacketAtLeast(InputStream inputStream, long j) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        return readPacketImpl(inputStream, j, HttpTimeout.INFINITE_TIMEOUT_MS);
    }

    public static final ByteReadPacket readPacketAtMost(InputStream inputStream, long j) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        return readPacketImpl(inputStream, 1, j);
    }

    private static final ByteReadPacket readPacketImpl(InputStream inputStream, long j, long j2) {
        long j3 = j;
        long j4 = j2;
        long j5 = 0;
        int i = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        if (i >= 0) {
            if (j3 <= j4) {
                int coerceAtMost = (int) RangesKt.coerceAtMost(j4, ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF);
                byte[] bArr = new byte[coerceAtMost];
                BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
                while (true) {
                    int i2 = (j5 > j3 ? 1 : (j5 == j3 ? 0 : -1));
                    if (i2 < 0 || (i2 == 0 && i == 0)) {
                        try {
                            int read = inputStream.read(bArr, 0, Math.min((int) Math.min(j4 - j5, 2147483647L), coerceAtMost));
                            if (read != -1) {
                                j5 += (long) read;
                                OutputKt.writeFully((Output) bytePacketBuilder, bArr, 0, read);
                            } else {
                                throw new EOFException("Premature end of stream: was read " + j5 + " bytes of " + j3);
                            }
                        } catch (Throwable th) {
                            bytePacketBuilder.release();
                            throw th;
                        }
                    }
                }
                return bytePacketBuilder.build();
            }
            throw new IllegalArgumentException(("min shouldn't be greater than max: " + j3 + " > " + j4).toString());
        }
        throw new IllegalArgumentException("min shouldn't be negative".toString());
    }

    public static final InputStream inputStream(ByteReadPacket byteReadPacket) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        return new StreamsKt$inputStream$1(byteReadPacket);
    }

    public static final Reader readerUTF8(ByteReadPacket byteReadPacket) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        return new StreamsKt$readerUTF8$1(byteReadPacket);
    }

    public static final OutputStream outputStream(BytePacketBuilder bytePacketBuilder) {
        Intrinsics.checkNotNullParameter(bytePacketBuilder, "<this>");
        return new StreamsKt$outputStream$1(bytePacketBuilder);
    }

    public static final Writer writerUTF8(BytePacketBuilder bytePacketBuilder) {
        Intrinsics.checkNotNullParameter(bytePacketBuilder, "<this>");
        return new StreamsKt$writerUTF8$1(bytePacketBuilder);
    }

    public static final void writePacket(OutputStream outputStream, Function1<? super BytePacketBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(outputStream, "<this>");
        Intrinsics.checkNotNullParameter(function1, "builder");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            function1.invoke(bytePacketBuilder);
            writePacket(outputStream, bytePacketBuilder.build());
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }
}
