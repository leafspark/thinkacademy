package io.ktor.utils.io.bits;

import java.nio.ByteBuffer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH&ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0006\u0010\tJ\u001d\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b\r\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, d2 = {"Lio/ktor/utils/io/bits/Allocator;", "", "alloc", "Lio/ktor/utils/io/bits/Memory;", "size", "", "alloc-gFv-Zug", "(I)Ljava/nio/ByteBuffer;", "", "(J)Ljava/nio/ByteBuffer;", "free", "", "instance", "free-3GNKZMM", "(Ljava/nio/ByteBuffer;)V", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MemoryFactory.kt */
public interface Allocator {
    /* renamed from: alloc-gFv-Zug  reason: not valid java name */
    ByteBuffer m30allocgFvZug(int i);

    /* renamed from: alloc-gFv-Zug  reason: not valid java name */
    ByteBuffer m31allocgFvZug(long j);

    /* renamed from: free-3GNKZMM  reason: not valid java name */
    void m32free3GNKZMM(ByteBuffer byteBuffer);
}
