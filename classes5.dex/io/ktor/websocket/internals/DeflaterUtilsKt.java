package io.ktor.websocket.internals;

import com.tekartik.sqflite.Constant;
import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.OutputArraysJVMKt;
import io.ktor.utils.io.core.StringsKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a$\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"EMPTY_CHUNK", "", "PADDED_EMPTY_CHUNK", "deflateFully", "Ljava/util/zip/Deflater;", "data", "deflateTo", "", "Lio/ktor/utils/io/core/BytePacketBuilder;", "deflater", "buffer", "Ljava/nio/ByteBuffer;", "flush", "", "inflateFully", "Ljava/util/zip/Inflater;", "ktor-websockets"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeflaterUtils.kt */
public final class DeflaterUtilsKt {
    private static final byte[] EMPTY_CHUNK = {0, 0, -1, -1};
    private static final byte[] PADDED_EMPTY_CHUNK = {0, 0, 0, -1, -1};

    public static final byte[] deflateFully(Deflater deflater, byte[] bArr) {
        ObjectPool<ByteBuffer> ktorDefaultPool;
        ByteBuffer borrow;
        Intrinsics.checkNotNullParameter(deflater, "<this>");
        Intrinsics.checkNotNullParameter(bArr, Constant.PARAM_ERROR_DATA);
        deflater.setInput(bArr);
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            ktorDefaultPool = ByteBufferPoolKt.getKtorDefaultPool();
            borrow = ktorDefaultPool.borrow();
            ByteBuffer byteBuffer = borrow;
            while (!deflater.needsInput()) {
                deflateTo(bytePacketBuilder, deflater, byteBuffer, false);
            }
            do {
            } while (deflateTo(bytePacketBuilder, deflater, byteBuffer, true) != 0);
            Unit unit = Unit.INSTANCE;
            ktorDefaultPool.recycle(borrow);
            ByteReadPacket build = bytePacketBuilder.build();
            if (BytePacketUtilsKt.endsWith(build, PADDED_EMPTY_CHUNK)) {
                byte[] readBytes = StringsKt.readBytes(build, ((int) build.getRemaining()) - EMPTY_CHUNK.length);
                build.release();
                return readBytes;
            }
            BytePacketBuilder bytePacketBuilder2 = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
            try {
                bytePacketBuilder2.writePacket(build);
                bytePacketBuilder2.writeByte((byte) 0);
                return StringsKt.readBytes$default(bytePacketBuilder2.build(), 0, 1, (Object) null);
            } catch (Throwable th) {
                bytePacketBuilder2.release();
                throw th;
            }
        } catch (Throwable th2) {
            bytePacketBuilder.release();
            throw th2;
        }
    }

    public static final byte[] inflateFully(Inflater inflater, byte[] bArr) {
        ObjectPool<ByteBuffer> ktorDefaultPool;
        ByteBuffer borrow;
        Intrinsics.checkNotNullParameter(inflater, "<this>");
        Intrinsics.checkNotNullParameter(bArr, Constant.PARAM_ERROR_DATA);
        byte[] plus = ArraysKt.plus(bArr, EMPTY_CHUNK);
        inflater.setInput(plus);
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            ktorDefaultPool = ByteBufferPoolKt.getKtorDefaultPool();
            borrow = ktorDefaultPool.borrow();
            ByteBuffer byteBuffer = borrow;
            long length = ((long) plus.length) + inflater.getBytesRead();
            while (inflater.getBytesRead() < length) {
                byteBuffer.clear();
                byteBuffer.position(byteBuffer.position() + inflater.inflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit()));
                byteBuffer.flip();
                OutputArraysJVMKt.writeFully(bytePacketBuilder, byteBuffer);
            }
            Unit unit = Unit.INSTANCE;
            ktorDefaultPool.recycle(borrow);
            return StringsKt.readBytes$default(bytePacketBuilder.build(), 0, 1, (Object) null);
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    private static final int deflateTo(BytePacketBuilder bytePacketBuilder, Deflater deflater, ByteBuffer byteBuffer, boolean z) {
        int i;
        byteBuffer.clear();
        if (z) {
            i = deflater.deflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit(), 2);
        } else {
            i = deflater.deflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
        }
        if (i == 0) {
            return 0;
        }
        byteBuffer.position(byteBuffer.position() + i);
        byteBuffer.flip();
        OutputArraysJVMKt.writeFully(bytePacketBuilder, byteBuffer);
        return i;
    }
}
