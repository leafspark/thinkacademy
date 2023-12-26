package io.michaelrocks.paranoid;

import io.flutter.embedding.android.KeyboardMap;

public class DeobfuscatorHelper {
    public static final int MAX_CHUNK_LENGTH = 8191;

    private DeobfuscatorHelper() {
    }

    public static String getString(long j, String[] strArr) {
        long next = RandomHelper.next(RandomHelper.seed(KeyboardMap.kValueMask & j));
        long next2 = RandomHelper.next(next);
        int i = (int) (((j >>> 32) ^ ((next >>> 32) & 65535)) ^ ((next2 >>> 16) & -65536));
        long charAt = getCharAt(i, strArr, next2);
        int i2 = (int) ((charAt >>> 32) & 65535);
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            charAt = getCharAt(i + i3 + 1, strArr, charAt);
            cArr[i3] = (char) ((int) ((charAt >>> 32) & 65535));
        }
        return new String(cArr);
    }

    private static long getCharAt(int i, String[] strArr, long j) {
        return (((long) strArr[i / MAX_CHUNK_LENGTH].charAt(i % MAX_CHUNK_LENGTH)) << 32) ^ RandomHelper.next(j);
    }
}
