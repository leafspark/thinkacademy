package com.tal.thinkacademy.encryptkey;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH ¨\u0006\t"}, d2 = {"Lcom/tal/thinkacademy/encryptkey/EncryptKey;", "", "()V", "decryptString", "", "byteArray", "", "key", "", "encryptkey_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EncryptKey.kt */
public final class EncryptKey {
    public static final EncryptKey INSTANCE = new EncryptKey();

    public final native String decryptString(byte[] bArr, int i);

    private EncryptKey() {
    }

    static {
        System.loadLibrary("encryptkey");
    }
}
