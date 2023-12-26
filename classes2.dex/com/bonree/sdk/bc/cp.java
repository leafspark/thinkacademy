package com.bonree.sdk.bc;

public final class cp {
    private static final long a = 4294967295L;

    private cp() {
    }

    public static int a(long j, long j2) {
        if (j < 0 || j > a) {
            throw new IllegalArgumentException(j + " out of range");
        } else if (j2 < 0 || j2 > a) {
            throw new IllegalArgumentException(j2 + " out of range");
        } else {
            long j3 = j - j2;
            if (j3 >= a) {
                j3 -= 4294967296L;
            } else if (j3 < -4294967295L) {
                j3 += 4294967296L;
            }
            return (int) j3;
        }
    }

    private static long a(long j) {
        int i;
        if (j < 0 || j > a) {
            throw new IllegalArgumentException(j + " out of range");
        } else if (i == 0) {
            return 0;
        } else {
            return j + 1;
        }
    }
}
