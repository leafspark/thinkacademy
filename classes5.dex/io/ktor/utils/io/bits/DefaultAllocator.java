package io.ktor.utils.io.bits;

import io.ktor.http.ContentDisposition;
import io.ktor.utils.io.core.internal.NumbersKt;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\tH\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0007\u0010\nJ\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"Lio/ktor/utils/io/bits/DefaultAllocator;", "Lio/ktor/utils/io/bits/Allocator;", "()V", "alloc", "Lio/ktor/utils/io/bits/Memory;", "size", "", "alloc-gFv-Zug", "(I)Ljava/nio/ByteBuffer;", "", "(J)Ljava/nio/ByteBuffer;", "free", "", "instance", "free-3GNKZMM", "(Ljava/nio/ByteBuffer;)V", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MemoryFactoryJvm.kt */
public final class DefaultAllocator implements Allocator {
    public static final DefaultAllocator INSTANCE = new DefaultAllocator();

    /* renamed from: free-3GNKZMM  reason: not valid java name */
    public void m38free3GNKZMM(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "instance");
    }

    private DefaultAllocator() {
    }

    /* renamed from: alloc-gFv-Zug  reason: not valid java name */
    public ByteBuffer m36allocgFvZug(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(i);
        Intrinsics.checkNotNullExpressionValue(allocate, "allocate(size)");
        return Memory.m40constructorimpl(allocate);
    }

    /* renamed from: alloc-gFv-Zug  reason: not valid java name */
    public ByteBuffer m37allocgFvZug(long j) {
        if (j < 2147483647L) {
            return m36allocgFvZug((int) j);
        }
        NumbersKt.failLongToIntConversion(j, ContentDisposition.Parameters.Size);
        throw new KotlinNothingValueException();
    }
}
