package io.ktor.utils.io.internal;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\f\u0010\b\u001a\u00020\t*\u00020\u0006H\u0000\u001a\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\r\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\u000f\u001a\u00020\t*\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0001H\u0000¨\u0006\u0012"}, d2 = {"getIOIntProperty", "", "name", "", "default", "indexOfPartial", "Ljava/nio/ByteBuffer;", "sub", "isEmpty", "", "putAtMost", "src", "n", "putLimited", "limit", "startsWith", "prefix", "prefixSkip", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Utils.kt */
public final class UtilsKt {
    public static final boolean isEmpty(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        return !byteBuffer.hasRemaining();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        r2 = kotlin.text.StringsKt.toIntOrNull(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int getIOIntProperty(java.lang.String r2, int r3) {
        /*
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ SecurityException -> 0x001b }
            r0.<init>()     // Catch:{ SecurityException -> 0x001b }
            java.lang.String r1 = "io.ktor.utils.io."
            r0.append(r1)     // Catch:{ SecurityException -> 0x001b }
            r0.append(r2)     // Catch:{ SecurityException -> 0x001b }
            java.lang.String r2 = r0.toString()     // Catch:{ SecurityException -> 0x001b }
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch:{ SecurityException -> 0x001b }
            goto L_0x001e
        L_0x001b:
            r2 = 0
            java.lang.String r2 = (java.lang.String) r2
        L_0x001e:
            if (r2 == 0) goto L_0x002a
            java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r2)
            if (r2 == 0) goto L_0x002a
            int r3 = r2.intValue()
        L_0x002a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.UtilsKt.getIOIntProperty(java.lang.String, int):int");
    }

    public static final int indexOfPartial(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(byteBuffer2, "sub");
        int position = byteBuffer2.position();
        int remaining = byteBuffer2.remaining();
        byte b = byteBuffer2.get(position);
        int limit = byteBuffer.limit();
        loop0:
        for (int position2 = byteBuffer.position(); position2 < limit; position2++) {
            if (byteBuffer.get(position2) == b) {
                int i = 1;
                while (i < remaining) {
                    int i2 = position2 + i;
                    if (i2 == limit) {
                        break loop0;
                    } else if (byteBuffer.get(i2) == byteBuffer2.get(position + i)) {
                        i++;
                    }
                }
                return position2 - byteBuffer.position();
            }
        }
        return -1;
    }

    public static /* synthetic */ boolean startsWith$default(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return startsWith(byteBuffer, byteBuffer2, i);
    }

    public static final boolean startsWith(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(byteBuffer2, "prefix");
        int min = Math.min(byteBuffer.remaining(), byteBuffer2.remaining() - i);
        if (min <= 0) {
            return false;
        }
        int position = byteBuffer.position();
        int position2 = byteBuffer2.position() + i;
        for (int i2 = 0; i2 < min; i2++) {
            if (byteBuffer.get(position + i2) != byteBuffer2.get(position2 + i2)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ int putAtMost$default(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = byteBuffer2.remaining();
        }
        return putAtMost(byteBuffer, byteBuffer2, i);
    }

    public static final int putAtMost(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(byteBuffer2, "src");
        int remaining = byteBuffer.remaining();
        int remaining2 = byteBuffer2.remaining();
        if (remaining2 > remaining || remaining2 > i) {
            remaining2 = Math.min(remaining, Math.min(remaining2, i));
            int i2 = 1;
            if (1 <= remaining2) {
                while (true) {
                    byteBuffer.put(byteBuffer2.get());
                    if (i2 == remaining2) {
                        break;
                    }
                    i2++;
                }
            }
        } else {
            byteBuffer.put(byteBuffer2);
        }
        return remaining2;
    }

    public static /* synthetic */ int putLimited$default(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = byteBuffer.limit();
        }
        return putLimited(byteBuffer, byteBuffer2, i);
    }

    public static final int putLimited(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(byteBuffer2, "src");
        return putAtMost(byteBuffer, byteBuffer2, i - byteBuffer2.position());
    }
}
