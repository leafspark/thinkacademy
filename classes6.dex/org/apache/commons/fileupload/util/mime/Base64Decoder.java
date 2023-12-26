package org.apache.commons.fileupload.util.mime;

import java.io.IOException;
import java.io.OutputStream;

final class Base64Decoder {
    private static final byte[] DECODING_TABLE = new byte[256];
    private static final byte[] ENCODING_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final int INPUT_BYTES_PER_CHUNK = 4;
    private static final int INVALID_BYTE = -1;
    private static final int MASK_BYTE_UNSIGNED = 255;
    private static final byte PADDING = 61;
    private static final int PAD_BYTE = -2;

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = DECODING_TABLE;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        while (true) {
            byte[] bArr2 = ENCODING_TABLE;
            if (i < bArr2.length) {
                DECODING_TABLE[bArr2[i]] = (byte) i;
                i++;
            } else {
                DECODING_TABLE[61] = -2;
                return;
            }
        }
    }

    private Base64Decoder() {
    }

    public static int decode(byte[] bArr, OutputStream outputStream) throws IOException {
        byte[] bArr2 = new byte[4];
        int i = 0;
        int i2 = 0;
        for (byte b : bArr) {
            byte b2 = DECODING_TABLE[b & 255];
            if (b2 != -1) {
                int i3 = i + 1;
                bArr2[i] = b2;
                if (i3 == 4) {
                    byte b3 = bArr2[0];
                    byte b4 = bArr2[1];
                    byte b5 = bArr2[2];
                    byte b6 = bArr2[3];
                    if (b3 == -2 || b4 == -2) {
                        throw new IOException("Invalid Base64 input: incorrect padding, first two bytes cannot be padding");
                    }
                    outputStream.write((b3 << 2) | (b4 >> 4));
                    i2++;
                    if (b5 != -2) {
                        outputStream.write((b4 << 4) | (b5 >> 2));
                        i2++;
                        if (b6 != -2) {
                            outputStream.write((b5 << 6) | b6);
                            i2++;
                        }
                    } else if (b6 != -2) {
                        throw new IOException("Invalid Base64 input: incorrect padding, 4th byte must be padding if 3rd byte is");
                    }
                    i = 0;
                } else {
                    i = i3;
                }
            }
        }
        if (i == 0) {
            return i2;
        }
        throw new IOException("Invalid Base64 input: truncated");
    }
}
