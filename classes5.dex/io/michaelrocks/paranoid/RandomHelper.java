package io.michaelrocks.paranoid;

public class RandomHelper {
    private static short rotl(short s, int i) {
        return (short) ((s >>> (32 - i)) | (s << i));
    }

    public static long seed(long j) {
        long j2 = (j ^ (j >>> 33)) * 7109453100751455733L;
        return ((j2 ^ (j2 >>> 28)) * -3808689974395783757L) >>> 32;
    }

    private RandomHelper() {
    }

    public static long next(long j) {
        short s = (short) ((int) (j & 65535));
        short s2 = (short) ((int) ((j >>> 16) & 65535));
        short s3 = (short) (s2 ^ s);
        return ((((long) rotl(s3, 10)) | (((long) ((short) (rotl((short) (s + s2), 9) + s))) << 16)) << 16) | ((long) ((short) (((short) (rotl(s, 13) ^ s3)) ^ (s3 << 5))));
    }
}
