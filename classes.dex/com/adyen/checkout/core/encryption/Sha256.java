package com.adyen.checkout.core.encryption;

import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/adyen/checkout/core/encryption/Sha256;", "", "()V", "SHA_256", "", "digest", "Ljava/security/MessageDigest;", "kotlin.jvm.PlatformType", "hash", "", "byteArray", "hashString", "string", "checkout-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Sha256.kt */
public final class Sha256 {
    public static final Sha256 INSTANCE = new Sha256();
    private static final String SHA_256 = "SHA-256";
    private static final MessageDigest digest = MessageDigest.getInstance(SHA_256);

    private Sha256() {
    }

    public final byte[] hash(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "byteArray");
        MessageDigest messageDigest = digest;
        messageDigest.reset();
        messageDigest.update(bArr);
        byte[] digest2 = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digest2, "digest.digest()");
        return digest2;
    }

    public final String hashString(String str) {
        Intrinsics.checkNotNullParameter(str, "string");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return new String(hash(bytes), Charsets.UTF_8);
    }
}
