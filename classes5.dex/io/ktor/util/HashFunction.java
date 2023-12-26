package io.ktor.util;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lio/ktor/util/HashFunction;", "", "digest", "", "update", "", "input", "offset", "", "length", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HashFunction.kt */
public interface HashFunction {
    byte[] digest();

    void update(byte[] bArr, int i, int i2);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HashFunction.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void update$default(HashFunction hashFunction, byte[] bArr, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    i = 0;
                }
                if ((i3 & 4) != 0) {
                    i2 = bArr.length;
                }
                hashFunction.update(bArr, i, i2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
        }
    }
}
