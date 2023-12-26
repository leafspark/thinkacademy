package io.ktor.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\u0015\u0010\u0007\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0004¨\u0006\t"}, d2 = {"digest", "", "Lio/ktor/util/HashFunction;", "input", "offset", "", "length", "leftRotate", "bitCount", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HashFunction.kt */
public final class HashFunctionKt {
    /* access modifiers changed from: private */
    public static final int leftRotate(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    public static /* synthetic */ byte[] digest$default(HashFunction hashFunction, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return digest(hashFunction, bArr, i, i2);
    }

    public static final byte[] digest(HashFunction hashFunction, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(hashFunction, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "input");
        hashFunction.update(bArr, i, i2);
        return hashFunction.digest();
    }
}
