package com.amazonaws.util;

class Base16Codec implements Codec {
    private static final int BITS_4 = 4;
    private static final int MASK_4BITS = 15;
    private static final int OFFSET_OF_A = 55;
    private static final int OFFSET_OF_a = 87;
    private static final int OFFSET_VALUE = 10;
    private final byte[] alpahbets = CodecUtils.toBytesDirect("0123456789ABCDEF");

    Base16Codec() {
    }

    private static class LazyHolder {
        /* access modifiers changed from: private */
        public static final byte[] DECODED = decodeTable();

        private LazyHolder() {
        }

        private static byte[] decodeTable() {
            byte[] bArr = new byte[103];
            for (int i = 0; i <= 102; i++) {
                if (i >= 48 && i <= 57) {
                    bArr[i] = (byte) (i - 48);
                } else if (i >= 65 && i <= 70) {
                    bArr[i] = (byte) (i - 55);
                } else if (i < 97 || i > 102) {
                    bArr[i] = -1;
                } else {
                    bArr[i] = (byte) (i - 87);
                }
            }
            return bArr;
        }
    }

    public byte[] encode(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            byte[] bArr3 = this.alpahbets;
            bArr2[i] = bArr3[(b >>> 4) & 15];
            i = i2 + 1;
            bArr2[i2] = bArr3[b & 15];
        }
        return bArr2;
    }

    public byte[] decode(byte[] bArr, int i) {
        if (i % 2 == 0) {
            int i2 = i / 2;
            byte[] bArr2 = new byte[i2];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                bArr2[i3] = (byte) ((pos(bArr[i4]) << 4) | pos(bArr[i5]));
                i3++;
                i4 = i5 + 1;
            }
            return bArr2;
        }
        throw new IllegalArgumentException("Input is expected to be encoded in multiple of 2 bytes but found: " + i);
    }

    /* access modifiers changed from: protected */
    public int pos(byte b) {
        byte b2 = LazyHolder.DECODED[b];
        if (b2 > -1) {
            return b2;
        }
        throw new IllegalArgumentException("Invalid base 16 character: '" + ((char) b) + "'");
    }
}
