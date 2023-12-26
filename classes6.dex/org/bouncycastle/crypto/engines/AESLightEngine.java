package org.bouncycastle.crypto.engines;

import java.lang.reflect.Array;
import okio.Utf8;
import org.apache.commons.fileupload.MultipartStream;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;
import org.bouncycastle.util.Pack;

public class AESLightEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final byte[] S = {99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, Utf8.REPLACEMENT_BYTE, -9, -52, 52, -91, -27, -15, 113, -40, 49, 21, 4, -57, 35, -61, 24, -106, 5, -102, 7, 18, Byte.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, 26, 27, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, Byte.MAX_VALUE, 80, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, -74, -38, 33, Tnaf.POW_2_WIDTH, -1, -13, -46, -51, 12, 19, -20, 95, -105, 68, 23, -60, -89, 126, 61, 100, 93, 25, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, 28, -90, -76, -58, -24, -35, 116, 31, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, 30, -121, -23, -50, 85, 40, -33, -116, -95, -119, MultipartStream.CR, -65, -26, 66, 104, 65, -103, MultipartStream.DASH, 15, -80, 84, -69, 22};
    private static final byte[] Si = {82, 9, 106, -43, 48, 54, -91, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, -90, -62, 35, 61, -18, 76, -107, 11, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, 21, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, 30, -113, -54, Utf8.REPLACEMENT_BYTE, 15, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, -33, 110, 71, -15, 26, 113, 29, 41, -59, -119, 111, -73, 98, 14, -86, 24, -66, 27, -4, 86, 62, 75, -58, -46, 121, 32, -102, -37, -64, -2, 120, -51, 90, -12, 31, -35, -88, 51, -120, 7, -57, 49, -79, 18, Tnaf.POW_2_WIDTH, 89, 39, Byte.MIN_VALUE, -20, 95, 96, 81, Byte.MAX_VALUE, -87, 25, -75, 74, MultipartStream.CR, MultipartStream.DASH, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, 23, 43, 4, 126, -70, 119, -42, 38, -31, 105, 20, 99, 85, 33, 12, 125};
    private static final int m1 = -2139062144;
    private static final int m2 = 2139062143;
    private static final int m3 = 27;
    private static final int m4 = -1061109568;
    private static final int m5 = 1061109567;
    private static final int[] rcon = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, 239, 197, 145};
    private int ROUNDS;
    private int[][] WorkingKey = null;
    private boolean forEncryption;

    private static int FFmulX(int i) {
        return (((i & m1) >>> 7) * 27) ^ ((m2 & i) << 1);
    }

    private static int FFmulX2(int i) {
        int i2 = i & m4;
        int i3 = i2 ^ (i2 >>> 1);
        return (i3 >>> 5) ^ (((m5 & i) << 2) ^ (i3 >>> 2));
    }

    private void decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2, int[][] iArr) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int littleEndianToInt = Pack.littleEndianToInt(bArr3, i + 0);
        int littleEndianToInt2 = Pack.littleEndianToInt(bArr3, i + 4);
        int littleEndianToInt3 = Pack.littleEndianToInt(bArr3, i + 8);
        int littleEndianToInt4 = Pack.littleEndianToInt(bArr3, i + 12);
        int i3 = this.ROUNDS;
        int i4 = littleEndianToInt ^ iArr[i3][0];
        int i5 = littleEndianToInt2 ^ iArr[i3][1];
        int i6 = littleEndianToInt3 ^ iArr[i3][2];
        int i7 = i3 - 1;
        int i8 = littleEndianToInt4 ^ iArr[i3][3];
        while (true) {
            byte[] bArr5 = Si;
            int i9 = i4 & GF2Field.MASK;
            if (i7 > 1) {
                int inv_mcol = inv_mcol((((bArr5[i9] & 255) ^ ((bArr5[(i8 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(i6 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i5 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i7][0];
                int inv_mcol2 = inv_mcol((((bArr5[i5 & GF2Field.MASK] & 255) ^ ((bArr5[(i4 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(i8 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i6 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i7][1];
                int inv_mcol3 = inv_mcol((((bArr5[i6 & GF2Field.MASK] & 255) ^ ((bArr5[(i5 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(i4 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i8 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i7][2];
                int i10 = i7 - 1;
                int inv_mcol4 = inv_mcol((((bArr5[i8 & GF2Field.MASK] & 255) ^ ((bArr5[(i6 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(i5 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i4 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i7][3];
                int inv_mcol5 = inv_mcol((((bArr5[inv_mcol & GF2Field.MASK] & 255) ^ ((bArr5[(inv_mcol4 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(inv_mcol3 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(inv_mcol2 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i10][0];
                int inv_mcol6 = inv_mcol((((bArr5[inv_mcol2 & GF2Field.MASK] & 255) ^ ((bArr5[(inv_mcol >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(inv_mcol4 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(inv_mcol3 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i10][1];
                int i11 = i10 - 1;
                i8 = inv_mcol((((bArr5[inv_mcol4 & GF2Field.MASK] & 255) ^ ((bArr5[(inv_mcol3 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(inv_mcol2 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(inv_mcol >> 24) & GF2Field.MASK] << 24)) ^ iArr[i10][3];
                i4 = inv_mcol5;
                i5 = inv_mcol6;
                i6 = inv_mcol((((bArr5[inv_mcol3 & GF2Field.MASK] & 255) ^ ((bArr5[(inv_mcol2 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(inv_mcol >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(inv_mcol4 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i10][2];
                i7 = i11;
            } else {
                int inv_mcol7 = inv_mcol((((bArr5[i9] & 255) ^ ((bArr5[(i8 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(i6 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i5 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i7][0];
                int inv_mcol8 = inv_mcol((((bArr5[i5 & GF2Field.MASK] & 255) ^ ((bArr5[(i4 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(i8 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i6 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i7][1];
                int inv_mcol9 = inv_mcol((((bArr5[i6 & GF2Field.MASK] & 255) ^ ((bArr5[(i5 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(i4 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i8 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i7][2];
                int inv_mcol10 = inv_mcol((((bArr5[i8 & GF2Field.MASK] & 255) ^ ((bArr5[(i6 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(i5 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i4 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i7][3];
                byte b = ((((bArr5[inv_mcol7 & GF2Field.MASK] & 255) ^ ((bArr5[(inv_mcol10 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(inv_mcol9 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(inv_mcol8 >> 24) & GF2Field.MASK] << 24)) ^ iArr[0][0];
                byte b2 = ((((bArr5[inv_mcol8 & GF2Field.MASK] & 255) ^ ((bArr5[(inv_mcol7 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(inv_mcol10 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(inv_mcol9 >> 24) & GF2Field.MASK] << 24)) ^ iArr[0][1];
                byte b3 = ((((bArr5[inv_mcol9 & GF2Field.MASK] & 255) ^ ((bArr5[(inv_mcol8 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(inv_mcol7 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(inv_mcol10 >> 24) & GF2Field.MASK] << 24)) ^ iArr[0][2];
                byte b4 = ((((bArr5[inv_mcol10 & GF2Field.MASK] & 255) ^ ((bArr5[(inv_mcol9 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(inv_mcol8 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(inv_mcol7 >> 24) & GF2Field.MASK] << 24)) ^ iArr[0][3];
                Pack.intToLittleEndian((int) b, bArr4, i2 + 0);
                Pack.intToLittleEndian((int) b2, bArr4, i2 + 4);
                Pack.intToLittleEndian((int) b3, bArr4, i2 + 8);
                Pack.intToLittleEndian((int) b4, bArr4, i2 + 12);
                return;
            }
        }
    }

    private void encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2, int[][] iArr) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int littleEndianToInt = Pack.littleEndianToInt(bArr3, i + 0);
        int littleEndianToInt2 = Pack.littleEndianToInt(bArr3, i + 4);
        int littleEndianToInt3 = Pack.littleEndianToInt(bArr3, i + 8);
        int littleEndianToInt4 = Pack.littleEndianToInt(bArr3, i + 12);
        int i3 = littleEndianToInt ^ iArr[0][0];
        int i4 = littleEndianToInt2 ^ iArr[0][1];
        int i5 = littleEndianToInt3 ^ iArr[0][2];
        int i6 = littleEndianToInt4 ^ iArr[0][3];
        int i7 = 1;
        while (i7 < this.ROUNDS - 1) {
            byte[] bArr5 = S;
            int mcol = mcol((((bArr5[i3 & GF2Field.MASK] & 255) ^ ((bArr5[(i4 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(i5 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i6 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i7][0];
            int mcol2 = mcol((((bArr5[i4 & GF2Field.MASK] & 255) ^ ((bArr5[(i5 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(i6 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i3 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i7][1];
            int mcol3 = mcol((((bArr5[i5 & GF2Field.MASK] & 255) ^ ((bArr5[(i6 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(i3 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i4 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i7][2];
            int i8 = i7 + 1;
            int mcol4 = mcol((((bArr5[i6 & GF2Field.MASK] & 255) ^ ((bArr5[(i3 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(i4 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i5 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i7][3];
            int mcol5 = mcol((((bArr5[mcol & GF2Field.MASK] & 255) ^ ((bArr5[(mcol2 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(mcol3 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(mcol4 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i8][0];
            int mcol6 = mcol((((bArr5[mcol2 & GF2Field.MASK] & 255) ^ ((bArr5[(mcol3 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(mcol4 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(mcol >> 24) & GF2Field.MASK] << 24)) ^ iArr[i8][1];
            int i9 = i8 + 1;
            i6 = mcol((((bArr5[mcol4 & GF2Field.MASK] & 255) ^ ((bArr5[(mcol >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(mcol2 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(mcol3 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i8][3];
            i3 = mcol5;
            i4 = mcol6;
            i5 = mcol((((bArr5[mcol3 & GF2Field.MASK] & 255) ^ ((bArr5[(mcol4 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr5[(mcol >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(mcol2 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i8][2];
            i7 = i9;
        }
        byte[] bArr6 = S;
        int mcol7 = mcol((((bArr6[i3 & GF2Field.MASK] & 255) ^ ((bArr6[(i4 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr6[(i5 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr6[(i6 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i7][0];
        int mcol8 = mcol((((bArr6[i4 & GF2Field.MASK] & 255) ^ ((bArr6[(i5 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr6[(i6 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr6[(i3 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i7][1];
        int mcol9 = mcol((((bArr6[i5 & GF2Field.MASK] & 255) ^ ((bArr6[(i6 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr6[(i3 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr6[(i4 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i7][2];
        int i10 = i7 + 1;
        int mcol10 = mcol((((bArr6[i6 & GF2Field.MASK] & 255) ^ ((bArr6[(i3 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr6[(i4 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr6[(i5 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i7][3];
        byte b = ((((bArr6[mcol7 & GF2Field.MASK] & 255) ^ ((bArr6[(mcol8 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr6[(mcol9 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr6[(mcol10 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i10][0];
        byte b2 = ((((bArr6[mcol8 & GF2Field.MASK] & 255) ^ ((bArr6[(mcol9 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr6[(mcol10 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr6[(mcol7 >> 24) & 255] << 24)) ^ iArr[i10][1];
        byte b3 = ((((bArr6[mcol9 & GF2Field.MASK] & 255) ^ ((bArr6[(mcol10 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr6[(mcol7 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr6[(mcol8 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i10][2];
        byte b4 = ((((bArr6[mcol10 & GF2Field.MASK] & 255) ^ ((bArr6[(mcol7 >> 8) & GF2Field.MASK] & 255) << 8)) ^ ((bArr6[(mcol8 >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr6[(mcol9 >> 24) & GF2Field.MASK] << 24)) ^ iArr[i10][3];
        Pack.intToLittleEndian((int) b, bArr4, i2 + 0);
        Pack.intToLittleEndian((int) b2, bArr4, i2 + 4);
        Pack.intToLittleEndian((int) b3, bArr4, i2 + 8);
        Pack.intToLittleEndian((int) b4, bArr4, i2 + 12);
    }

    private int[][] generateWorkingKey(byte[] bArr, boolean z) {
        byte[] bArr2 = bArr;
        int length = bArr2.length;
        if (length < 16 || length > 32 || (length & 7) != 0) {
            throw new IllegalArgumentException("Key length not 128/192/256 bits.");
        }
        int i = length >>> 2;
        int i2 = i + 6;
        this.ROUNDS = i2;
        int[] iArr = new int[2];
        iArr[1] = 4;
        iArr[0] = i2 + 1;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
        int i3 = 8;
        char c = 3;
        if (i == 4) {
            int littleEndianToInt = Pack.littleEndianToInt(bArr2, 0);
            iArr2[0][0] = littleEndianToInt;
            int littleEndianToInt2 = Pack.littleEndianToInt(bArr2, 4);
            iArr2[0][1] = littleEndianToInt2;
            int littleEndianToInt3 = Pack.littleEndianToInt(bArr2, 8);
            iArr2[0][2] = littleEndianToInt3;
            int littleEndianToInt4 = Pack.littleEndianToInt(bArr2, 12);
            iArr2[0][3] = littleEndianToInt4;
            for (int i4 = 1; i4 <= 10; i4++) {
                littleEndianToInt ^= subWord(shift(littleEndianToInt4, 8)) ^ rcon[i4 - 1];
                iArr2[i4][0] = littleEndianToInt;
                littleEndianToInt2 ^= littleEndianToInt;
                iArr2[i4][1] = littleEndianToInt2;
                littleEndianToInt3 ^= littleEndianToInt2;
                iArr2[i4][2] = littleEndianToInt3;
                littleEndianToInt4 ^= littleEndianToInt3;
                iArr2[i4][3] = littleEndianToInt4;
            }
        } else if (i == 6) {
            int littleEndianToInt5 = Pack.littleEndianToInt(bArr2, 0);
            iArr2[0][0] = littleEndianToInt5;
            int littleEndianToInt6 = Pack.littleEndianToInt(bArr2, 4);
            iArr2[0][1] = littleEndianToInt6;
            int littleEndianToInt7 = Pack.littleEndianToInt(bArr2, 8);
            iArr2[0][2] = littleEndianToInt7;
            int littleEndianToInt8 = Pack.littleEndianToInt(bArr2, 12);
            iArr2[0][3] = littleEndianToInt8;
            int littleEndianToInt9 = Pack.littleEndianToInt(bArr2, 16);
            int littleEndianToInt10 = Pack.littleEndianToInt(bArr2, 20);
            int i5 = 1;
            int i6 = 1;
            while (true) {
                iArr2[i5][0] = littleEndianToInt9;
                iArr2[i5][1] = littleEndianToInt10;
                int subWord = subWord(shift(littleEndianToInt10, 8)) ^ i6;
                int i7 = i6 << 1;
                int i8 = littleEndianToInt5 ^ subWord;
                iArr2[i5][2] = i8;
                int i9 = littleEndianToInt6 ^ i8;
                iArr2[i5][3] = i9;
                int i10 = littleEndianToInt7 ^ i9;
                int i11 = i5 + 1;
                iArr2[i11][0] = i10;
                int i12 = littleEndianToInt8 ^ i10;
                iArr2[i11][1] = i12;
                int i13 = littleEndianToInt9 ^ i12;
                iArr2[i11][2] = i13;
                int i14 = littleEndianToInt10 ^ i13;
                iArr2[i11][3] = i14;
                int subWord2 = subWord(shift(i14, 8)) ^ i7;
                i6 = i7 << 1;
                littleEndianToInt5 = i8 ^ subWord2;
                int i15 = i5 + 2;
                iArr2[i15][0] = littleEndianToInt5;
                littleEndianToInt6 = i9 ^ littleEndianToInt5;
                iArr2[i15][1] = littleEndianToInt6;
                littleEndianToInt7 = i10 ^ littleEndianToInt6;
                iArr2[i15][2] = littleEndianToInt7;
                littleEndianToInt8 = i12 ^ littleEndianToInt7;
                iArr2[i15][3] = littleEndianToInt8;
                i5 += 3;
                if (i5 >= 13) {
                    break;
                }
                littleEndianToInt9 = i13 ^ littleEndianToInt8;
                littleEndianToInt10 = i14 ^ littleEndianToInt9;
            }
        } else if (i == 8) {
            int littleEndianToInt11 = Pack.littleEndianToInt(bArr2, 0);
            iArr2[0][0] = littleEndianToInt11;
            int littleEndianToInt12 = Pack.littleEndianToInt(bArr2, 4);
            iArr2[0][1] = littleEndianToInt12;
            int littleEndianToInt13 = Pack.littleEndianToInt(bArr2, 8);
            iArr2[0][2] = littleEndianToInt13;
            int littleEndianToInt14 = Pack.littleEndianToInt(bArr2, 12);
            iArr2[0][3] = littleEndianToInt14;
            int littleEndianToInt15 = Pack.littleEndianToInt(bArr2, 16);
            iArr2[1][0] = littleEndianToInt15;
            int littleEndianToInt16 = Pack.littleEndianToInt(bArr2, 20);
            iArr2[1][1] = littleEndianToInt16;
            int littleEndianToInt17 = Pack.littleEndianToInt(bArr2, 24);
            iArr2[1][2] = littleEndianToInt17;
            int littleEndianToInt18 = Pack.littleEndianToInt(bArr2, 28);
            iArr2[1][3] = littleEndianToInt18;
            int i16 = 2;
            int i17 = 1;
            while (true) {
                int subWord3 = subWord(shift(littleEndianToInt18, i3)) ^ i17;
                i17 <<= 1;
                littleEndianToInt11 ^= subWord3;
                iArr2[i16][0] = littleEndianToInt11;
                littleEndianToInt12 ^= littleEndianToInt11;
                iArr2[i16][1] = littleEndianToInt12;
                littleEndianToInt13 ^= littleEndianToInt12;
                iArr2[i16][2] = littleEndianToInt13;
                littleEndianToInt14 ^= littleEndianToInt13;
                iArr2[i16][c] = littleEndianToInt14;
                int i18 = i16 + 1;
                if (i18 >= 15) {
                    break;
                }
                littleEndianToInt15 ^= subWord(littleEndianToInt14);
                iArr2[i18][0] = littleEndianToInt15;
                littleEndianToInt16 ^= littleEndianToInt15;
                iArr2[i18][1] = littleEndianToInt16;
                littleEndianToInt17 ^= littleEndianToInt16;
                iArr2[i18][2] = littleEndianToInt17;
                littleEndianToInt18 ^= littleEndianToInt17;
                iArr2[i18][3] = littleEndianToInt18;
                i16 = i18 + 1;
                i3 = 8;
                c = 3;
            }
        } else {
            throw new IllegalStateException("Should never get here");
        }
        if (!z) {
            for (int i19 = 1; i19 < this.ROUNDS; i19++) {
                for (int i20 = 0; i20 < 4; i20++) {
                    iArr2[i19][i20] = inv_mcol(iArr2[i19][i20]);
                }
            }
        }
        return iArr2;
    }

    private static int inv_mcol(int i) {
        int shift = shift(i, 8) ^ i;
        int FFmulX = i ^ FFmulX(shift);
        int FFmulX2 = shift ^ FFmulX2(FFmulX);
        return FFmulX ^ (FFmulX2 ^ shift(FFmulX2, 16));
    }

    private static int mcol(int i) {
        int shift = shift(i, 8);
        int i2 = i ^ shift;
        return FFmulX(i2) ^ (shift ^ shift(i2, 16));
    }

    private static int shift(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    private static int subWord(int i) {
        byte[] bArr = S;
        return (bArr[(i >> 24) & GF2Field.MASK] << 24) | (bArr[i & GF2Field.MASK] & 255) | ((bArr[(i >> 8) & GF2Field.MASK] & 255) << 8) | ((bArr[(i >> 16) & GF2Field.MASK] & 255) << Tnaf.POW_2_WIDTH);
    }

    public String getAlgorithmName() {
        return "AES";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.WorkingKey = generateWorkingKey(((KeyParameter) cipherParameters).getKey(), z);
            this.forEncryption = z;
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to AES init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[][] iArr = this.WorkingKey;
        if (iArr == null) {
            throw new IllegalStateException("AES engine not initialised");
        } else if (i > bArr.length - 16) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 <= bArr2.length - 16) {
            if (this.forEncryption) {
                encryptBlock(bArr, i, bArr2, i2, iArr);
            } else {
                decryptBlock(bArr, i, bArr2, i2, iArr);
            }
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
