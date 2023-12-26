package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;
import okio.Utf8;

public class Base64Encoder implements Encoder {
    protected final byte[] decodingTable = new byte[128];
    protected final byte[] encodingTable = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    protected byte padding = 61;

    public Base64Encoder() {
        initialiseDecodingTable();
    }

    private int decodeLastBlock(OutputStream outputStream, char c, char c2, char c3, char c4) throws IOException {
        byte b = this.padding;
        if (c3 == b) {
            if (c4 == b) {
                byte[] bArr = this.decodingTable;
                byte b2 = bArr[c];
                byte b3 = bArr[c2];
                if ((b2 | b3) >= 0) {
                    outputStream.write((b2 << 2) | (b3 >> 4));
                    return 1;
                }
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            throw new IOException("invalid characters encountered at end of base64 data");
        } else if (c4 == b) {
            byte[] bArr2 = this.decodingTable;
            byte b4 = bArr2[c];
            byte b5 = bArr2[c2];
            byte b6 = bArr2[c3];
            if ((b4 | b5 | b6) >= 0) {
                outputStream.write((b4 << 2) | (b5 >> 4));
                outputStream.write((b5 << 4) | (b6 >> 2));
                return 2;
            }
            throw new IOException("invalid characters encountered at end of base64 data");
        } else {
            byte[] bArr3 = this.decodingTable;
            byte b7 = bArr3[c];
            byte b8 = bArr3[c2];
            byte b9 = bArr3[c3];
            byte b10 = bArr3[c4];
            if ((b7 | b8 | b9 | b10) >= 0) {
                outputStream.write((b7 << 2) | (b8 >> 4));
                outputStream.write((b8 << 4) | (b9 >> 2));
                outputStream.write((b9 << 6) | b10);
                return 3;
            }
            throw new IOException("invalid characters encountered at end of base64 data");
        }
    }

    private boolean ignore(char c) {
        return c == 10 || c == 13 || c == 9 || c == ' ';
    }

    private int nextI(String str, int i, int i2) {
        while (i < i2 && ignore(str.charAt(i))) {
            i++;
        }
        return i;
    }

    private int nextI(byte[] bArr, int i, int i2) {
        while (i < i2 && ignore((char) bArr[i])) {
            i++;
        }
        return i;
    }

    public int decode(String str, OutputStream outputStream) throws IOException {
        String str2 = str;
        OutputStream outputStream2 = outputStream;
        byte[] bArr = new byte[54];
        int length = str.length();
        while (length > 0 && ignore(str2.charAt(length - 1))) {
            length--;
        }
        if (length == 0) {
            return 0;
        }
        int i = length;
        int i2 = 0;
        while (i > 0 && i2 != 4) {
            if (!ignore(str2.charAt(i - 1))) {
                i2++;
            }
            i--;
        }
        int nextI = nextI(str2, 0, i);
        int i3 = 0;
        int i4 = 0;
        while (nextI < i) {
            int i5 = nextI + 1;
            byte b = this.decodingTable[str2.charAt(nextI)];
            int nextI2 = nextI(str2, i5, i);
            int i6 = nextI2 + 1;
            byte b2 = this.decodingTable[str2.charAt(nextI2)];
            int nextI3 = nextI(str2, i6, i);
            int i7 = nextI3 + 1;
            byte b3 = this.decodingTable[str2.charAt(nextI3)];
            int nextI4 = nextI(str2, i7, i);
            int i8 = nextI4 + 1;
            byte b4 = this.decodingTable[str2.charAt(nextI4)];
            if ((b | b2 | b3 | b4) >= 0) {
                int i9 = i3 + 1;
                bArr[i3] = (byte) ((b << 2) | (b2 >> 4));
                int i10 = i9 + 1;
                bArr[i9] = (byte) ((b2 << 4) | (b3 >> 2));
                i3 = i10 + 1;
                bArr[i10] = (byte) ((b3 << 6) | b4);
                i4 += 3;
                if (i3 == 54) {
                    outputStream2.write(bArr);
                    i3 = 0;
                }
                nextI = nextI(str2, i8, i);
            } else {
                throw new IOException("invalid characters encountered in base64 data");
            }
        }
        if (i3 > 0) {
            outputStream2.write(bArr, 0, i3);
        }
        int nextI5 = nextI(str2, nextI, length);
        int nextI6 = nextI(str2, nextI5 + 1, length);
        int nextI7 = nextI(str2, nextI6 + 1, length);
        return i4 + decodeLastBlock(outputStream, str2.charAt(nextI5), str2.charAt(nextI6), str2.charAt(nextI7), str2.charAt(nextI(str2, nextI7 + 1, length)));
    }

    public int decode(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        byte[] bArr2 = bArr;
        int i3 = i;
        OutputStream outputStream2 = outputStream;
        byte[] bArr3 = new byte[54];
        int i4 = i3 + i2;
        while (i4 > i3 && ignore((char) bArr2[i4 - 1])) {
            i4--;
        }
        if (i4 == 0) {
            return 0;
        }
        int i5 = i4;
        int i6 = 0;
        while (i5 > i3 && i6 != 4) {
            if (!ignore((char) bArr2[i5 - 1])) {
                i6++;
            }
            i5--;
        }
        int nextI = nextI(bArr2, i3, i5);
        int i7 = 0;
        int i8 = 0;
        while (nextI < i5) {
            int i9 = nextI + 1;
            byte b = this.decodingTable[bArr2[nextI]];
            int nextI2 = nextI(bArr2, i9, i5);
            int i10 = nextI2 + 1;
            byte b2 = this.decodingTable[bArr2[nextI2]];
            int nextI3 = nextI(bArr2, i10, i5);
            int i11 = nextI3 + 1;
            byte b3 = this.decodingTable[bArr2[nextI3]];
            int nextI4 = nextI(bArr2, i11, i5);
            int i12 = nextI4 + 1;
            byte b4 = this.decodingTable[bArr2[nextI4]];
            if ((b | b2 | b3 | b4) >= 0) {
                int i13 = i7 + 1;
                bArr3[i7] = (byte) ((b << 2) | (b2 >> 4));
                int i14 = i13 + 1;
                bArr3[i13] = (byte) ((b2 << 4) | (b3 >> 2));
                i7 = i14 + 1;
                bArr3[i14] = (byte) ((b3 << 6) | b4);
                if (i7 == 54) {
                    outputStream2.write(bArr3);
                    i7 = 0;
                }
                i8 += 3;
                nextI = nextI(bArr2, i12, i5);
            } else {
                throw new IOException("invalid characters encountered in base64 data");
            }
        }
        if (i7 > 0) {
            outputStream2.write(bArr3, 0, i7);
        }
        int nextI5 = nextI(bArr2, nextI, i4);
        int nextI6 = nextI(bArr2, nextI5 + 1, i4);
        int nextI7 = nextI(bArr2, nextI6 + 1, i4);
        return i8 + decodeLastBlock(outputStream, (char) bArr2[nextI5], (char) bArr2[nextI6], (char) bArr2[nextI7], (char) bArr2[nextI(bArr2, nextI7 + 1, i4)]);
    }

    public int encode(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        byte[] bArr2 = new byte[72];
        while (i2 > 0) {
            int min = Math.min(54, i2);
            outputStream.write(bArr2, 0, encode(bArr, i, min, bArr2, 0));
            i += min;
            i2 -= min;
        }
        return ((i2 + 2) / 3) * 4;
    }

    public int encode(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IOException {
        int i4 = (i + i2) - 2;
        int i5 = i;
        int i6 = i3;
        while (i5 < i4) {
            int i7 = i5 + 1;
            byte b = bArr[i5];
            int i8 = i7 + 1;
            byte b2 = bArr[i7] & 255;
            int i9 = i8 + 1;
            byte b3 = bArr[i8] & 255;
            int i10 = i6 + 1;
            byte[] bArr3 = this.encodingTable;
            bArr2[i6] = bArr3[(b >>> 2) & 63];
            int i11 = i10 + 1;
            bArr2[i10] = bArr3[((b << 4) | (b2 >>> 4)) & 63];
            int i12 = i11 + 1;
            bArr2[i11] = bArr3[((b2 << 2) | (b3 >>> 6)) & 63];
            i6 = i12 + 1;
            bArr2[i12] = bArr3[b3 & Utf8.REPLACEMENT_BYTE];
            i5 = i9;
        }
        int i13 = i2 - (i5 - i);
        if (i13 == 1) {
            byte b4 = bArr[i5] & 255;
            int i14 = i6 + 1;
            byte[] bArr4 = this.encodingTable;
            bArr2[i6] = bArr4[(b4 >>> 2) & 63];
            int i15 = i14 + 1;
            bArr2[i14] = bArr4[(b4 << 4) & 63];
            int i16 = i15 + 1;
            byte b5 = this.padding;
            bArr2[i15] = b5;
            i6 = i16 + 1;
            bArr2[i16] = b5;
        } else if (i13 == 2) {
            byte b6 = bArr[i5] & 255;
            byte b7 = bArr[i5 + 1] & 255;
            int i17 = i6 + 1;
            byte[] bArr5 = this.encodingTable;
            bArr2[i6] = bArr5[(b6 >>> 2) & 63];
            int i18 = i17 + 1;
            bArr2[i17] = bArr5[((b6 << 4) | (b7 >>> 4)) & 63];
            int i19 = i18 + 1;
            bArr2[i18] = bArr5[(b7 << 2) & 63];
            i6 = i19 + 1;
            bArr2[i19] = this.padding;
        }
        return i6 - i3;
    }

    public int getEncodedLength(int i) {
        return ((i + 2) / 3) * 4;
    }

    public int getMaxDecodedLength(int i) {
        return (i / 4) * 3;
    }

    /* access modifiers changed from: protected */
    public void initialiseDecodingTable() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.decodingTable;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        while (true) {
            byte[] bArr2 = this.encodingTable;
            if (i < bArr2.length) {
                this.decodingTable[bArr2[i]] = (byte) i;
                i++;
            } else {
                return;
            }
        }
    }
}
