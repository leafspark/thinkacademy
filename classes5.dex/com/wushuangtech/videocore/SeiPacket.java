package com.wushuangtech.videocore;

public class SeiPacket {
    static int UUID_SIZE = 16;
    static byte[] uuid = {109, 111, 109, 111, 97, 57, 97, 52, 50, 55, 100, 49, 119, 101, 105, 108};

    public static int get_sei_nalu_size(int i) {
        int i2 = 2;
        int i3 = i + UUID_SIZE + 2;
        int i4 = (i3 / 255) + (i3 % 255 != 0 ? 1 : 0) + 2 + i3;
        if (i4 % 2 == 1) {
            i2 = 1;
        }
        return i4 + i2;
    }

    public static int get_sei_packet_size(int i) {
        return get_sei_nalu_size(i) + 4;
    }

    public static int fill_sei_packet(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = get_sei_nalu_size(i2);
        if (i == 0) {
            bArr[0] = (byte) ((i3 >> 24) & 255);
            bArr[1] = (byte) ((i3 >> 16) & 255);
            bArr[2] = (byte) ((i3 >> 8) & 255);
            bArr[3] = (byte) (i3 & 255);
        } else {
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            bArr[3] = 1;
        }
        int i4 = 6;
        bArr[4] = 6;
        bArr[5] = 5;
        int i5 = UUID_SIZE + i2 + 2;
        while (i5 > 0) {
            int i6 = i4 + 1;
            bArr[i4] = (byte) (i5 >= 255 ? 255 : i5);
            i5 = i5 < 255 ? 0 : i5 - 255;
            i4 = i6;
        }
        System.arraycopy(uuid, 0, bArr, i4, UUID_SIZE);
        int i7 = i4 + UUID_SIZE;
        int i8 = i7 + 1;
        bArr[i7] = (byte) (255 & (i2 >> 8));
        int i9 = i8 + 1;
        bArr[i8] = (byte) (i2 & 255);
        System.arraycopy(bArr2, 0, bArr, i9, i2);
        int i10 = i9 + i2;
        int i11 = (i3 + 4) - i10;
        if (i11 == 1) {
            bArr[i10] = Byte.MIN_VALUE;
        } else if (i11 == 2) {
            bArr[i10] = 0;
            bArr[i10 + 1] = Byte.MIN_VALUE;
        }
        return 1;
    }
}
