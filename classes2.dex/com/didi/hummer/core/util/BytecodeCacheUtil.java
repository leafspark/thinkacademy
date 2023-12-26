package com.didi.hummer.core.util;

import android.text.TextUtils;
import android.util.LruCache;

public class BytecodeCacheUtil {
    private static LruCache<String, byte[]> bytecodeCache;
    private static final int cacheSize;
    private static final int maxMemory;

    static {
        int maxMemory2 = (int) Runtime.getRuntime().maxMemory();
        maxMemory = maxMemory2;
        int i = maxMemory2 / 8;
        cacheSize = i;
        bytecodeCache = new LruCache<String, byte[]>(i) {
            /* access modifiers changed from: protected */
            public int sizeOf(String str, byte[] bArr) {
                return bArr.length;
            }
        };
    }

    public static void putBytecode(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length > 0) {
            bytecodeCache.put(str, bArr);
        }
    }

    public static byte[] getBytecode(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return bytecodeCache.get(str);
    }

    public static void removeBytecode(String str) {
        if (!TextUtils.isEmpty(str)) {
            bytecodeCache.remove(str);
        }
    }

    public static boolean contains(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return bytecodeCache.snapshot().containsKey(str);
    }
}
