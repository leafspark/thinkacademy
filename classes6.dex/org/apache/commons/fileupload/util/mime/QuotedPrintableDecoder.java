package org.apache.commons.fileupload.util.mime;

import java.io.IOException;
import java.io.OutputStream;

final class QuotedPrintableDecoder {
    private static final int UPPER_NIBBLE_SHIFT = 4;

    private QuotedPrintableDecoder() {
    }

    public static int decode(byte[] bArr, OutputStream outputStream) throws IOException {
        int i = 0;
        int length = bArr.length + 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            byte b = bArr[i];
            if (b == 95) {
                outputStream.write(32);
            } else if (b == 61) {
                int i4 = i3 + 1;
                if (i4 < length) {
                    byte b2 = bArr[i3];
                    int i5 = i4 + 1;
                    byte b3 = bArr[i4];
                    if (b2 != 13) {
                        outputStream.write(hexToBinary(b3) | (hexToBinary(b2) << 4));
                        i2++;
                    } else if (b3 != 10) {
                        throw new IOException("Invalid quoted printable encoding; CR must be followed by LF");
                    }
                    i = i5;
                } else {
                    throw new IOException("Invalid quoted printable encoding; truncated escape sequence");
                }
            } else {
                outputStream.write(b);
                i2++;
            }
            i = i3;
        }
        return i2;
    }

    private static int hexToBinary(byte b) throws IOException {
        int digit = Character.digit((char) b, 16);
        if (digit != -1) {
            return digit;
        }
        throw new IOException("Invalid quoted printable encoding: not a valid hex digit: " + b);
    }
}
