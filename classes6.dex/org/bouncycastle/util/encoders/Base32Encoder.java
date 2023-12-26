package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class Base32Encoder implements Encoder {
    private static final byte[] DEAULT_ENCODING_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55};
    private static final byte DEFAULT_PADDING = 61;
    private final byte[] decodingTable;
    private final byte[] encodingTable;
    private final byte padding;

    public Base32Encoder() {
        this.decodingTable = new byte[128];
        this.encodingTable = DEAULT_ENCODING_TABLE;
        this.padding = DEFAULT_PADDING;
        initialiseDecodingTable();
    }

    public Base32Encoder(byte[] bArr, byte b) {
        this.decodingTable = new byte[128];
        if (bArr.length == 32) {
            this.encodingTable = Arrays.clone(bArr);
            this.padding = b;
            initialiseDecodingTable();
            return;
        }
        throw new IllegalArgumentException("encoding table needs to be length 32");
    }

    private int decodeLastBlock(OutputStream outputStream, char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) throws IOException {
        byte b = this.padding;
        if (c8 != b) {
            byte[] bArr = this.decodingTable;
            byte b2 = bArr[c];
            byte b3 = bArr[c2];
            byte b4 = bArr[c3];
            byte b5 = bArr[c4];
            byte b6 = bArr[c5];
            byte b7 = bArr[c6];
            byte b8 = bArr[c7];
            byte b9 = bArr[c8];
            if ((b2 | b3 | b4 | b5 | b6 | b7 | b8 | b9) >= 0) {
                outputStream.write((b2 << 3) | (b3 >> 2));
                outputStream.write((b3 << 6) | (b4 << 1) | (b5 >> 4));
                outputStream.write((b5 << 4) | (b6 >> 1));
                outputStream.write((b6 << 7) | (b7 << 2) | (b8 >> 3));
                outputStream.write((b8 << 5) | b9);
                return 5;
            }
            throw new IOException("invalid characters encountered at end of base32 data");
        } else if (c7 != b) {
            byte[] bArr2 = this.decodingTable;
            byte b10 = bArr2[c];
            byte b11 = bArr2[c2];
            byte b12 = bArr2[c3];
            byte b13 = bArr2[c4];
            byte b14 = bArr2[c5];
            byte b15 = bArr2[c6];
            byte b16 = bArr2[c7];
            if ((b10 | b11 | b12 | b13 | b14 | b15 | b16) >= 0) {
                outputStream.write((b10 << 3) | (b11 >> 2));
                outputStream.write((b11 << 6) | (b12 << 1) | (b13 >> 4));
                outputStream.write((b13 << 4) | (b14 >> 1));
                outputStream.write((b14 << 7) | (b15 << 2) | (b16 >> 3));
                return 4;
            }
            throw new IOException("invalid characters encountered at end of base32 data");
        } else if (c6 != b) {
            throw new IOException("invalid characters encountered at end of base32 data");
        } else if (c5 != b) {
            byte[] bArr3 = this.decodingTable;
            byte b17 = bArr3[c];
            byte b18 = bArr3[c2];
            byte b19 = bArr3[c3];
            byte b20 = bArr3[c4];
            byte b21 = bArr3[c5];
            if ((b17 | b18 | b19 | b20 | b21) >= 0) {
                outputStream.write((b17 << 3) | (b18 >> 2));
                outputStream.write((b18 << 6) | (b19 << 1) | (b20 >> 4));
                outputStream.write((b20 << 4) | (b21 >> 1));
                return 3;
            }
            throw new IOException("invalid characters encountered at end of base32 data");
        } else if (c4 != b) {
            byte[] bArr4 = this.decodingTable;
            byte b22 = bArr4[c];
            byte b23 = bArr4[c2];
            byte b24 = bArr4[c3];
            byte b25 = bArr4[c4];
            if ((b22 | b23 | b24 | b25) >= 0) {
                outputStream.write((b22 << 3) | (b23 >> 2));
                outputStream.write((b23 << 6) | (b24 << 1) | (b25 >> 4));
                return 2;
            }
            throw new IOException("invalid characters encountered at end of base32 data");
        } else if (c3 == b) {
            byte[] bArr5 = this.decodingTable;
            byte b26 = bArr5[c];
            byte b27 = bArr5[c2];
            if ((b26 | b27) >= 0) {
                outputStream.write((b26 << 3) | (b27 >> 2));
                return 1;
            }
            throw new IOException("invalid characters encountered at end of base32 data");
        } else {
            throw new IOException("invalid characters encountered at end of base32 data");
        }
    }

    private void encodeBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = i + 1;
        byte b = bArr[i];
        int i4 = i3 + 1;
        byte b2 = bArr[i3] & 255;
        int i5 = i4 + 1;
        byte b3 = bArr[i4] & 255;
        int i6 = i5 + 1;
        byte b4 = bArr[i5] & 255;
        byte b5 = bArr[i6] & 255;
        int i7 = i2 + 1;
        byte[] bArr3 = this.encodingTable;
        bArr2[i2] = bArr3[(b >>> 3) & 31];
        int i8 = i7 + 1;
        bArr2[i7] = bArr3[((b << 2) | (b2 >>> 6)) & 31];
        int i9 = i8 + 1;
        bArr2[i8] = bArr3[(b2 >>> 1) & 31];
        int i10 = i9 + 1;
        bArr2[i9] = bArr3[((b2 << 4) | (b3 >>> 4)) & 31];
        int i11 = i10 + 1;
        bArr2[i10] = bArr3[((b3 << 1) | (b4 >>> 7)) & 31];
        int i12 = i11 + 1;
        bArr2[i11] = bArr3[(b4 >>> 2) & 31];
        bArr2[i12] = bArr3[((b4 << 3) | (b5 >>> 5)) & 31];
        bArr2[i12 + 1] = bArr3[b5 & 31];
    }

    private boolean ignore(char c) {
        return c == 10 || c == 13 || c == 9 || c == ' ';
    }

    private int nextI(byte[] bArr, int i, int i2) {
        while (i < i2 && ignore((char) bArr[i])) {
            i++;
        }
        return i;
    }

    public int decode(String str, OutputStream outputStream) throws IOException {
        byte[] byteArray = Strings.toByteArray(str);
        return decode(byteArray, 0, byteArray.length, outputStream);
    }

    public int decode(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        byte[] bArr2 = bArr;
        int i3 = i;
        OutputStream outputStream2 = outputStream;
        byte[] bArr3 = new byte[55];
        int i4 = i3 + i2;
        while (i4 > i3 && ignore((char) bArr2[i4 - 1])) {
            i4--;
        }
        if (i4 == 0) {
            return 0;
        }
        int i5 = i4;
        int i6 = 0;
        while (i5 > i3 && i6 != 8) {
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
            int nextI5 = nextI(bArr2, i12, i5);
            int i13 = nextI5 + 1;
            byte b5 = this.decodingTable[bArr2[nextI5]];
            int nextI6 = nextI(bArr2, i13, i5);
            int i14 = nextI6 + 1;
            byte b6 = this.decodingTable[bArr2[nextI6]];
            int nextI7 = nextI(bArr2, i14, i5);
            int i15 = i4;
            int i16 = nextI7 + 1;
            byte b7 = this.decodingTable[bArr2[nextI7]];
            int nextI8 = nextI(bArr2, i16, i5);
            int i17 = i5;
            int i18 = nextI8 + 1;
            byte b8 = this.decodingTable[bArr2[nextI8]];
            if ((b | b2 | b3 | b4 | b5 | b6 | b7 | b8) >= 0) {
                int i19 = i7 + 1;
                bArr3[i7] = (byte) ((b << 3) | (b2 >> 2));
                int i20 = i19 + 1;
                bArr3[i19] = (byte) ((b2 << 6) | (b3 << 1) | (b4 >> 4));
                int i21 = i20 + 1;
                bArr3[i20] = (byte) ((b4 << 4) | (b5 >> 1));
                int i22 = i21 + 1;
                bArr3[i21] = (byte) ((b6 << 2) | (b5 << 7) | (b7 >> 3));
                int i23 = i22 + 1;
                bArr3[i22] = (byte) ((b7 << 5) | b8);
                if (i23 == 55) {
                    outputStream2.write(bArr3);
                    i7 = 0;
                } else {
                    i7 = i23;
                }
                i8 += 5;
                int i24 = i17;
                int nextI9 = nextI(bArr2, i18, i24);
                i5 = i24;
                i4 = i15;
                nextI = nextI9;
            } else {
                throw new IOException("invalid characters encountered in base32 data");
            }
        }
        int i25 = i4;
        if (i7 > 0) {
            outputStream2.write(bArr3, 0, i7);
        }
        int i26 = i25;
        int nextI10 = nextI(bArr2, nextI, i26);
        int nextI11 = nextI(bArr2, nextI10 + 1, i26);
        int nextI12 = nextI(bArr2, nextI11 + 1, i26);
        int nextI13 = nextI(bArr2, nextI12 + 1, i26);
        int nextI14 = nextI(bArr2, nextI13 + 1, i26);
        int nextI15 = nextI(bArr2, nextI14 + 1, i26);
        int nextI16 = nextI(bArr2, nextI15 + 1, i26);
        return i8 + decodeLastBlock(outputStream, (char) bArr2[nextI10], (char) bArr2[nextI11], (char) bArr2[nextI12], (char) bArr2[nextI13], (char) bArr2[nextI14], (char) bArr2[nextI15], (char) bArr2[nextI16], (char) bArr2[nextI(bArr2, nextI16 + 1, i26)]);
    }

    public int encode(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        byte[] bArr2 = new byte[72];
        while (i2 > 0) {
            int min = Math.min(45, i2);
            outputStream.write(bArr2, 0, encode(bArr, i, min, bArr2, 0));
            i += min;
            i2 -= min;
        }
        return ((i2 + 2) / 3) * 4;
    }

    public int encode(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IOException {
        int i4 = (i + i2) - 4;
        int i5 = i;
        int i6 = i3;
        while (i5 < i4) {
            encodeBlock(bArr, i5, bArr2, i6);
            i5 += 5;
            i6 += 8;
        }
        int i7 = i2 - (i5 - i);
        if (i7 > 0) {
            byte[] bArr3 = new byte[5];
            System.arraycopy(bArr, i5, bArr3, 0, i7);
            encodeBlock(bArr3, 0, bArr2, i6);
            if (i7 == 1) {
                byte b = this.padding;
                bArr2[i6 + 2] = b;
                bArr2[i6 + 3] = b;
                bArr2[i6 + 4] = b;
                bArr2[i6 + 5] = b;
                bArr2[i6 + 6] = b;
                bArr2[i6 + 7] = b;
            } else if (i7 == 2) {
                byte b2 = this.padding;
                bArr2[i6 + 4] = b2;
                bArr2[i6 + 5] = b2;
                bArr2[i6 + 6] = b2;
                bArr2[i6 + 7] = b2;
            } else if (i7 == 3) {
                byte b3 = this.padding;
                bArr2[i6 + 5] = b3;
                bArr2[i6 + 6] = b3;
                bArr2[i6 + 7] = b3;
            } else if (i7 == 4) {
                bArr2[i6 + 7] = this.padding;
            }
            i6 += 8;
        }
        return i6 - i3;
    }

    public int getEncodedLength(int i) {
        return ((i + 4) / 5) * 8;
    }

    public int getMaxDecodedLength(int i) {
        return (i / 8) * 5;
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
