package com.bonree.sdk.bs;

import com.bonree.sdk.agent.engine.webview.entity.WebViewRouteChangeEvent;
import java.io.UnsupportedEncodingException;

public class i {
    private static int a = 0;
    private static int b = 1;
    private static int c = 2;
    private static int d = 4;
    private static int e = 8;
    private static int f = 16;
    private static /* synthetic */ boolean g = true;

    static abstract class a {
        public byte[] a;
        public int b;

        public abstract int a(int i);

        public abstract boolean a(byte[] bArr, int i, int i2, boolean z);

        a() {
        }
    }

    private static byte[] a(String str, int i) {
        return a(str.getBytes(), i);
    }

    public static byte[] a(byte[] bArr, int i) {
        return a(bArr, 0, bArr.length, i);
    }

    private static byte[] a(byte[] bArr, int i, int i2, int i3) {
        b bVar = new b(i3, new byte[((i2 * 3) / 4)]);
        if (!bVar.a(bArr, 0, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (bVar.b == bVar.a.length) {
            return bVar.a;
        } else {
            byte[] bArr2 = new byte[bVar.b];
            System.arraycopy(bVar.a, 0, bArr2, 0, bVar.b);
            return bArr2;
        }
    }

    static class b extends a {
        private static final int[] c;
        private static final int[] d;
        private static final int e = -1;
        private static final int f = -2;
        private int g;
        private int h;
        private final int[] i;

        static {
            int[] iArr = new int[WebViewRouteChangeEvent.ROUTE_CHANGE_String_LIMIT];
            // fill-array-data instruction
            iArr[0] = -1;
            iArr[1] = -1;
            iArr[2] = -1;
            iArr[3] = -1;
            iArr[4] = -1;
            iArr[5] = -1;
            iArr[6] = -1;
            iArr[7] = -1;
            iArr[8] = -1;
            iArr[9] = -1;
            iArr[10] = -1;
            iArr[11] = -1;
            iArr[12] = -1;
            iArr[13] = -1;
            iArr[14] = -1;
            iArr[15] = -1;
            iArr[16] = -1;
            iArr[17] = -1;
            iArr[18] = -1;
            iArr[19] = -1;
            iArr[20] = -1;
            iArr[21] = -1;
            iArr[22] = -1;
            iArr[23] = -1;
            iArr[24] = -1;
            iArr[25] = -1;
            iArr[26] = -1;
            iArr[27] = -1;
            iArr[28] = -1;
            iArr[29] = -1;
            iArr[30] = -1;
            iArr[31] = -1;
            iArr[32] = -1;
            iArr[33] = -1;
            iArr[34] = -1;
            iArr[35] = -1;
            iArr[36] = -1;
            iArr[37] = -1;
            iArr[38] = -1;
            iArr[39] = -1;
            iArr[40] = -1;
            iArr[41] = -1;
            iArr[42] = -1;
            iArr[43] = 62;
            iArr[44] = -1;
            iArr[45] = -1;
            iArr[46] = -1;
            iArr[47] = 63;
            iArr[48] = 52;
            iArr[49] = 53;
            iArr[50] = 54;
            iArr[51] = 55;
            iArr[52] = 56;
            iArr[53] = 57;
            iArr[54] = 58;
            iArr[55] = 59;
            iArr[56] = 60;
            iArr[57] = 61;
            iArr[58] = -1;
            iArr[59] = -1;
            iArr[60] = -1;
            iArr[61] = -2;
            iArr[62] = -1;
            iArr[63] = -1;
            iArr[64] = -1;
            iArr[65] = 0;
            iArr[66] = 1;
            iArr[67] = 2;
            iArr[68] = 3;
            iArr[69] = 4;
            iArr[70] = 5;
            iArr[71] = 6;
            iArr[72] = 7;
            iArr[73] = 8;
            iArr[74] = 9;
            iArr[75] = 10;
            iArr[76] = 11;
            iArr[77] = 12;
            iArr[78] = 13;
            iArr[79] = 14;
            iArr[80] = 15;
            iArr[81] = 16;
            iArr[82] = 17;
            iArr[83] = 18;
            iArr[84] = 19;
            iArr[85] = 20;
            iArr[86] = 21;
            iArr[87] = 22;
            iArr[88] = 23;
            iArr[89] = 24;
            iArr[90] = 25;
            iArr[91] = -1;
            iArr[92] = -1;
            iArr[93] = -1;
            iArr[94] = -1;
            iArr[95] = -1;
            iArr[96] = -1;
            iArr[97] = 26;
            iArr[98] = 27;
            iArr[99] = 28;
            iArr[100] = 29;
            iArr[101] = 30;
            iArr[102] = 31;
            iArr[103] = 32;
            iArr[104] = 33;
            iArr[105] = 34;
            iArr[106] = 35;
            iArr[107] = 36;
            iArr[108] = 37;
            iArr[109] = 38;
            iArr[110] = 39;
            iArr[111] = 40;
            iArr[112] = 41;
            iArr[113] = 42;
            iArr[114] = 43;
            iArr[115] = 44;
            iArr[116] = 45;
            iArr[117] = 46;
            iArr[118] = 47;
            iArr[119] = 48;
            iArr[120] = 49;
            iArr[121] = 50;
            iArr[122] = 51;
            iArr[123] = -1;
            iArr[124] = -1;
            iArr[125] = -1;
            iArr[126] = -1;
            iArr[127] = -1;
            iArr[128] = -1;
            iArr[129] = -1;
            iArr[130] = -1;
            iArr[131] = -1;
            iArr[132] = -1;
            iArr[133] = -1;
            iArr[134] = -1;
            iArr[135] = -1;
            iArr[136] = -1;
            iArr[137] = -1;
            iArr[138] = -1;
            iArr[139] = -1;
            iArr[140] = -1;
            iArr[141] = -1;
            iArr[142] = -1;
            iArr[143] = -1;
            iArr[144] = -1;
            iArr[145] = -1;
            iArr[146] = -1;
            iArr[147] = -1;
            iArr[148] = -1;
            iArr[149] = -1;
            iArr[150] = -1;
            iArr[151] = -1;
            iArr[152] = -1;
            iArr[153] = -1;
            iArr[154] = -1;
            iArr[155] = -1;
            iArr[156] = -1;
            iArr[157] = -1;
            iArr[158] = -1;
            iArr[159] = -1;
            iArr[160] = -1;
            iArr[161] = -1;
            iArr[162] = -1;
            iArr[163] = -1;
            iArr[164] = -1;
            iArr[165] = -1;
            iArr[166] = -1;
            iArr[167] = -1;
            iArr[168] = -1;
            iArr[169] = -1;
            iArr[170] = -1;
            iArr[171] = -1;
            iArr[172] = -1;
            iArr[173] = -1;
            iArr[174] = -1;
            iArr[175] = -1;
            iArr[176] = -1;
            iArr[177] = -1;
            iArr[178] = -1;
            iArr[179] = -1;
            iArr[180] = -1;
            iArr[181] = -1;
            iArr[182] = -1;
            iArr[183] = -1;
            iArr[184] = -1;
            iArr[185] = -1;
            iArr[186] = -1;
            iArr[187] = -1;
            iArr[188] = -1;
            iArr[189] = -1;
            iArr[190] = -1;
            iArr[191] = -1;
            iArr[192] = -1;
            iArr[193] = -1;
            iArr[194] = -1;
            iArr[195] = -1;
            iArr[196] = -1;
            iArr[197] = -1;
            iArr[198] = -1;
            iArr[199] = -1;
            iArr[200] = -1;
            iArr[201] = -1;
            iArr[202] = -1;
            iArr[203] = -1;
            iArr[204] = -1;
            iArr[205] = -1;
            iArr[206] = -1;
            iArr[207] = -1;
            iArr[208] = -1;
            iArr[209] = -1;
            iArr[210] = -1;
            iArr[211] = -1;
            iArr[212] = -1;
            iArr[213] = -1;
            iArr[214] = -1;
            iArr[215] = -1;
            iArr[216] = -1;
            iArr[217] = -1;
            iArr[218] = -1;
            iArr[219] = -1;
            iArr[220] = -1;
            iArr[221] = -1;
            iArr[222] = -1;
            iArr[223] = -1;
            iArr[224] = -1;
            iArr[225] = -1;
            iArr[226] = -1;
            iArr[227] = -1;
            iArr[228] = -1;
            iArr[229] = -1;
            iArr[230] = -1;
            iArr[231] = -1;
            iArr[232] = -1;
            iArr[233] = -1;
            iArr[234] = -1;
            iArr[235] = -1;
            iArr[236] = -1;
            iArr[237] = -1;
            iArr[238] = -1;
            iArr[239] = -1;
            iArr[240] = -1;
            iArr[241] = -1;
            iArr[242] = -1;
            iArr[243] = -1;
            iArr[244] = -1;
            iArr[245] = -1;
            iArr[246] = -1;
            iArr[247] = -1;
            iArr[248] = -1;
            iArr[249] = -1;
            iArr[250] = -1;
            iArr[251] = -1;
            iArr[252] = -1;
            iArr[253] = -1;
            iArr[254] = -1;
            iArr[255] = -1;
            c = iArr;
            int[] iArr2 = new int[WebViewRouteChangeEvent.ROUTE_CHANGE_String_LIMIT];
            // fill-array-data instruction
            iArr2[0] = -1;
            iArr2[1] = -1;
            iArr2[2] = -1;
            iArr2[3] = -1;
            iArr2[4] = -1;
            iArr2[5] = -1;
            iArr2[6] = -1;
            iArr2[7] = -1;
            iArr2[8] = -1;
            iArr2[9] = -1;
            iArr2[10] = -1;
            iArr2[11] = -1;
            iArr2[12] = -1;
            iArr2[13] = -1;
            iArr2[14] = -1;
            iArr2[15] = -1;
            iArr2[16] = -1;
            iArr2[17] = -1;
            iArr2[18] = -1;
            iArr2[19] = -1;
            iArr2[20] = -1;
            iArr2[21] = -1;
            iArr2[22] = -1;
            iArr2[23] = -1;
            iArr2[24] = -1;
            iArr2[25] = -1;
            iArr2[26] = -1;
            iArr2[27] = -1;
            iArr2[28] = -1;
            iArr2[29] = -1;
            iArr2[30] = -1;
            iArr2[31] = -1;
            iArr2[32] = -1;
            iArr2[33] = -1;
            iArr2[34] = -1;
            iArr2[35] = -1;
            iArr2[36] = -1;
            iArr2[37] = -1;
            iArr2[38] = -1;
            iArr2[39] = -1;
            iArr2[40] = -1;
            iArr2[41] = -1;
            iArr2[42] = -1;
            iArr2[43] = -1;
            iArr2[44] = -1;
            iArr2[45] = 62;
            iArr2[46] = -1;
            iArr2[47] = -1;
            iArr2[48] = 52;
            iArr2[49] = 53;
            iArr2[50] = 54;
            iArr2[51] = 55;
            iArr2[52] = 56;
            iArr2[53] = 57;
            iArr2[54] = 58;
            iArr2[55] = 59;
            iArr2[56] = 60;
            iArr2[57] = 61;
            iArr2[58] = -1;
            iArr2[59] = -1;
            iArr2[60] = -1;
            iArr2[61] = -2;
            iArr2[62] = -1;
            iArr2[63] = -1;
            iArr2[64] = -1;
            iArr2[65] = 0;
            iArr2[66] = 1;
            iArr2[67] = 2;
            iArr2[68] = 3;
            iArr2[69] = 4;
            iArr2[70] = 5;
            iArr2[71] = 6;
            iArr2[72] = 7;
            iArr2[73] = 8;
            iArr2[74] = 9;
            iArr2[75] = 10;
            iArr2[76] = 11;
            iArr2[77] = 12;
            iArr2[78] = 13;
            iArr2[79] = 14;
            iArr2[80] = 15;
            iArr2[81] = 16;
            iArr2[82] = 17;
            iArr2[83] = 18;
            iArr2[84] = 19;
            iArr2[85] = 20;
            iArr2[86] = 21;
            iArr2[87] = 22;
            iArr2[88] = 23;
            iArr2[89] = 24;
            iArr2[90] = 25;
            iArr2[91] = -1;
            iArr2[92] = -1;
            iArr2[93] = -1;
            iArr2[94] = -1;
            iArr2[95] = 63;
            iArr2[96] = -1;
            iArr2[97] = 26;
            iArr2[98] = 27;
            iArr2[99] = 28;
            iArr2[100] = 29;
            iArr2[101] = 30;
            iArr2[102] = 31;
            iArr2[103] = 32;
            iArr2[104] = 33;
            iArr2[105] = 34;
            iArr2[106] = 35;
            iArr2[107] = 36;
            iArr2[108] = 37;
            iArr2[109] = 38;
            iArr2[110] = 39;
            iArr2[111] = 40;
            iArr2[112] = 41;
            iArr2[113] = 42;
            iArr2[114] = 43;
            iArr2[115] = 44;
            iArr2[116] = 45;
            iArr2[117] = 46;
            iArr2[118] = 47;
            iArr2[119] = 48;
            iArr2[120] = 49;
            iArr2[121] = 50;
            iArr2[122] = 51;
            iArr2[123] = -1;
            iArr2[124] = -1;
            iArr2[125] = -1;
            iArr2[126] = -1;
            iArr2[127] = -1;
            iArr2[128] = -1;
            iArr2[129] = -1;
            iArr2[130] = -1;
            iArr2[131] = -1;
            iArr2[132] = -1;
            iArr2[133] = -1;
            iArr2[134] = -1;
            iArr2[135] = -1;
            iArr2[136] = -1;
            iArr2[137] = -1;
            iArr2[138] = -1;
            iArr2[139] = -1;
            iArr2[140] = -1;
            iArr2[141] = -1;
            iArr2[142] = -1;
            iArr2[143] = -1;
            iArr2[144] = -1;
            iArr2[145] = -1;
            iArr2[146] = -1;
            iArr2[147] = -1;
            iArr2[148] = -1;
            iArr2[149] = -1;
            iArr2[150] = -1;
            iArr2[151] = -1;
            iArr2[152] = -1;
            iArr2[153] = -1;
            iArr2[154] = -1;
            iArr2[155] = -1;
            iArr2[156] = -1;
            iArr2[157] = -1;
            iArr2[158] = -1;
            iArr2[159] = -1;
            iArr2[160] = -1;
            iArr2[161] = -1;
            iArr2[162] = -1;
            iArr2[163] = -1;
            iArr2[164] = -1;
            iArr2[165] = -1;
            iArr2[166] = -1;
            iArr2[167] = -1;
            iArr2[168] = -1;
            iArr2[169] = -1;
            iArr2[170] = -1;
            iArr2[171] = -1;
            iArr2[172] = -1;
            iArr2[173] = -1;
            iArr2[174] = -1;
            iArr2[175] = -1;
            iArr2[176] = -1;
            iArr2[177] = -1;
            iArr2[178] = -1;
            iArr2[179] = -1;
            iArr2[180] = -1;
            iArr2[181] = -1;
            iArr2[182] = -1;
            iArr2[183] = -1;
            iArr2[184] = -1;
            iArr2[185] = -1;
            iArr2[186] = -1;
            iArr2[187] = -1;
            iArr2[188] = -1;
            iArr2[189] = -1;
            iArr2[190] = -1;
            iArr2[191] = -1;
            iArr2[192] = -1;
            iArr2[193] = -1;
            iArr2[194] = -1;
            iArr2[195] = -1;
            iArr2[196] = -1;
            iArr2[197] = -1;
            iArr2[198] = -1;
            iArr2[199] = -1;
            iArr2[200] = -1;
            iArr2[201] = -1;
            iArr2[202] = -1;
            iArr2[203] = -1;
            iArr2[204] = -1;
            iArr2[205] = -1;
            iArr2[206] = -1;
            iArr2[207] = -1;
            iArr2[208] = -1;
            iArr2[209] = -1;
            iArr2[210] = -1;
            iArr2[211] = -1;
            iArr2[212] = -1;
            iArr2[213] = -1;
            iArr2[214] = -1;
            iArr2[215] = -1;
            iArr2[216] = -1;
            iArr2[217] = -1;
            iArr2[218] = -1;
            iArr2[219] = -1;
            iArr2[220] = -1;
            iArr2[221] = -1;
            iArr2[222] = -1;
            iArr2[223] = -1;
            iArr2[224] = -1;
            iArr2[225] = -1;
            iArr2[226] = -1;
            iArr2[227] = -1;
            iArr2[228] = -1;
            iArr2[229] = -1;
            iArr2[230] = -1;
            iArr2[231] = -1;
            iArr2[232] = -1;
            iArr2[233] = -1;
            iArr2[234] = -1;
            iArr2[235] = -1;
            iArr2[236] = -1;
            iArr2[237] = -1;
            iArr2[238] = -1;
            iArr2[239] = -1;
            iArr2[240] = -1;
            iArr2[241] = -1;
            iArr2[242] = -1;
            iArr2[243] = -1;
            iArr2[244] = -1;
            iArr2[245] = -1;
            iArr2[246] = -1;
            iArr2[247] = -1;
            iArr2[248] = -1;
            iArr2[249] = -1;
            iArr2[250] = -1;
            iArr2[251] = -1;
            iArr2[252] = -1;
            iArr2[253] = -1;
            iArr2[254] = -1;
            iArr2[255] = -1;
            d = iArr2;
        }

        public b(int i2, byte[] bArr) {
            this.a = bArr;
            this.i = (i2 & 8) == 0 ? c : d;
            this.g = 0;
            this.h = 0;
        }

        public final int a(int i2) {
            return ((i2 * 3) / 4) + 10;
        }

        public final boolean a(byte[] bArr, int i2, int i3, boolean z) {
            boolean z2;
            int i4 = this.g;
            if (i4 == 6) {
                return false;
            }
            int i5 = i3 + i2;
            int i6 = this.h;
            byte[] bArr2 = this.a;
            int[] iArr = this.i;
            int i7 = 0;
            int i8 = i6;
            int i9 = i4;
            int i10 = i2;
            while (i10 < i5) {
                if (i9 == 0) {
                    while (true) {
                        int i11 = i10 + 4;
                        if (i11 > i5) {
                            break;
                        }
                        i8 = iArr[bArr[i10 + 3] & 255] | (iArr[bArr[i10 + 1] & 255] << 12) | (iArr[bArr[i10] & 255] << 18) | (iArr[bArr[i10 + 2] & 255] << 6);
                        if (i8 < 0) {
                            break;
                        }
                        bArr2[i7 + 2] = (byte) i8;
                        bArr2[i7 + 1] = (byte) (i8 >> 8);
                        bArr2[i7] = (byte) (i8 >> 16);
                        i7 += 3;
                        i10 = i11;
                    }
                    if (i10 >= i5) {
                        break;
                    }
                }
                int i12 = i10 + 1;
                int i13 = iArr[bArr[i10] & 255];
                if (i9 != 0) {
                    if (i9 == 1) {
                        z2 = false;
                        if (i13 >= 0) {
                            i8 = (i8 << 6) | i13;
                        } else {
                            if (i13 != -1) {
                                this.g = 6;
                                return false;
                            }
                            i10 = i12;
                        }
                    } else if (i9 != 2) {
                        if (i9 != 3) {
                            if (i9 == 4) {
                                z2 = false;
                                if (i13 != -2) {
                                    if (i13 != -1) {
                                        this.g = 6;
                                        return false;
                                    }
                                }
                            } else if (i9 == 5 && i13 != -1) {
                                this.g = 6;
                                return false;
                            }
                        } else if (i13 >= 0) {
                            i8 = (i8 << 6) | i13;
                            bArr2[i7 + 2] = (byte) i8;
                            bArr2[i7 + 1] = (byte) (i8 >> 8);
                            bArr2[i7] = (byte) (i8 >> 16);
                            i7 += 3;
                            i10 = i12;
                            i9 = 0;
                        } else if (i13 == -2) {
                            bArr2[i7 + 1] = (byte) (i8 >> 2);
                            bArr2[i7] = (byte) (i8 >> 10);
                            i7 += 2;
                            i10 = i12;
                            i9 = 5;
                        } else if (i13 != -1) {
                            this.g = 6;
                            return false;
                        }
                        i10 = i12;
                    } else {
                        if (i13 >= 0) {
                            i8 = (i8 << 6) | i13;
                            i9++;
                        } else if (i13 == -2) {
                            bArr2[i7] = (byte) (i8 >> 4);
                            i7++;
                            i10 = i12;
                            i9 = 4;
                        } else if (i13 != -1) {
                            this.g = 6;
                            return false;
                        }
                        i10 = i12;
                    }
                    i9++;
                } else {
                    z2 = false;
                    if (i13 >= 0) {
                        i9++;
                        i8 = i13;
                    } else {
                        if (i13 != -1) {
                            this.g = 6;
                            return false;
                        }
                        i10 = i12;
                    }
                }
                i10 = i12;
                boolean z3 = z2;
            }
            if (i9 != 1) {
                if (i9 == 2) {
                    bArr2[i7] = (byte) (i8 >> 4);
                    i7++;
                } else if (i9 == 3) {
                    int i14 = i7 + 1;
                    bArr2[i7] = (byte) (i8 >> 10);
                    i7 = i14 + 1;
                    bArr2[i14] = (byte) (i8 >> 2);
                } else if (i9 == 4) {
                    this.g = 6;
                    return false;
                }
                this.g = i9;
                this.b = i7;
                return true;
            }
            this.g = 6;
            return false;
        }
    }

    public static String b(byte[] bArr, int i) {
        try {
            return new String(c(bArr, 0), "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    private static String b(byte[] bArr, int i, int i2, int i3) {
        try {
            return new String(c(bArr, i, i2, i3), "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public static byte[] c(byte[] bArr, int i) {
        return c(bArr, 0, bArr.length, i);
    }

    private static byte[] c(byte[] bArr, int i, int i2, int i3) {
        c cVar = new c(i3, (byte[]) null);
        int i4 = 2;
        int i5 = (i2 / 3) << 2;
        if (!cVar.c) {
            int i6 = i2 % 3;
            if (i6 == 1) {
                i5 += 2;
            } else if (i6 == 2) {
                i5 += 3;
            }
        } else if (i2 % 3 > 0) {
            i5 += 4;
        }
        if (cVar.d && i2 > 0) {
            int i7 = ((i2 - 1) / 57) + 1;
            if (!cVar.e) {
                i4 = 1;
            }
            i5 += i7 * i4;
        }
        cVar.a = new byte[i5];
        cVar.a(bArr, i, i2, true);
        if (g || cVar.b == i5) {
            return cVar.a;
        }
        throw new AssertionError();
    }

    static class c extends a {
        private static int f = 19;
        private static final byte[] g = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] h = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        private static /* synthetic */ boolean m = true;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        private final byte[] i;
        private int j;
        private int k;
        private final byte[] l;

        static {
            Class<i> cls = i.class;
        }

        public c(int i2, byte[] bArr) {
            this.a = null;
            boolean z = true;
            this.c = (i2 & 1) == 0;
            boolean z2 = (i2 & 2) == 0;
            this.d = z2;
            this.e = (i2 & 4) == 0 ? false : z;
            this.l = (i2 & 8) == 0 ? g : h;
            this.i = new byte[2];
            this.j = 0;
            this.k = z2 ? 19 : -1;
        }

        public final int a(int i2) {
            return ((i2 << 3) / 5) + 10;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0094  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00f0  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0135  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x01c2  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x01c8  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x00e6 A[SYNTHETIC] */
        public final boolean a(byte[] r19, int r20, int r21, boolean r22) {
            /*
                r18 = this;
                r0 = r18
                byte[] r1 = r0.l
                byte[] r2 = r0.a
                int r3 = r0.k
                int r4 = r21 + r20
                int r5 = r0.j
                r6 = -1
                r7 = 2
                r8 = 0
                r9 = 1
                if (r5 == r9) goto L_0x0031
                if (r5 == r7) goto L_0x0015
                goto L_0x0050
            L_0x0015:
                int r5 = r20 + 1
                if (r5 > r4) goto L_0x0050
                byte[] r10 = r0.i
                byte r11 = r10[r8]
                r11 = r11 & 255(0xff, float:3.57E-43)
                int r11 = r11 << 16
                byte r10 = r10[r9]
                r10 = r10 & 255(0xff, float:3.57E-43)
                int r10 = r10 << 8
                r10 = r10 | r11
                byte r11 = r19[r20]
                r11 = r11 & 255(0xff, float:3.57E-43)
                r10 = r10 | r11
                r0.j = r8
                r11 = r5
                goto L_0x0053
            L_0x0031:
                int r5 = r20 + 2
                if (r5 > r4) goto L_0x0050
                byte[] r5 = r0.i
                byte r5 = r5[r8]
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << 16
                int r10 = r20 + 1
                byte r11 = r19[r20]
                r11 = r11 & 255(0xff, float:3.57E-43)
                int r11 = r11 << 8
                r5 = r5 | r11
                int r11 = r10 + 1
                byte r10 = r19[r10]
                r10 = r10 & 255(0xff, float:3.57E-43)
                r10 = r10 | r5
                r0.j = r8
                goto L_0x0053
            L_0x0050:
                r11 = r20
                r10 = r6
            L_0x0053:
                r12 = 4
                r13 = 13
                r14 = 10
                if (r10 == r6) goto L_0x008f
                int r6 = r10 >> 18
                r6 = r6 & 63
                byte r6 = r1[r6]
                r2[r8] = r6
                int r6 = r10 >> 12
                r6 = r6 & 63
                byte r6 = r1[r6]
                r2[r9] = r6
                int r6 = r10 >> 6
                r6 = r6 & 63
                byte r6 = r1[r6]
                r2[r7] = r6
                r6 = r10 & 63
                byte r6 = r1[r6]
                r10 = 3
                r2[r10] = r6
                int r3 = r3 + -1
                if (r3 != 0) goto L_0x008d
                boolean r3 = r0.e
                if (r3 == 0) goto L_0x0085
                r3 = 5
                r2[r12] = r13
                goto L_0x0086
            L_0x0085:
                r3 = r12
            L_0x0086:
                int r6 = r3 + 1
                r2[r3] = r14
            L_0x008a:
                r3 = 19
                goto L_0x0090
            L_0x008d:
                r6 = r12
                goto L_0x0090
            L_0x008f:
                r6 = r8
            L_0x0090:
                int r10 = r11 + 3
                if (r10 > r4) goto L_0x00e6
                byte r15 = r19[r11]
                r15 = r15 & 255(0xff, float:3.57E-43)
                int r15 = r15 << 16
                int r16 = r11 + 1
                byte r5 = r19[r16]
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << 8
                r5 = r5 | r15
                int r11 = r11 + 2
                byte r11 = r19[r11]
                r11 = r11 & 255(0xff, float:3.57E-43)
                r5 = r5 | r11
                int r11 = r5 >> 18
                r11 = r11 & 63
                byte r11 = r1[r11]
                r2[r6] = r11
                int r11 = r6 + 1
                int r15 = r5 >> 12
                r15 = r15 & 63
                byte r15 = r1[r15]
                r2[r11] = r15
                int r11 = r6 + 2
                int r15 = r5 >> 6
                r15 = r15 & 63
                byte r15 = r1[r15]
                r2[r11] = r15
                int r11 = r6 + 3
                r5 = r5 & 63
                byte r5 = r1[r5]
                r2[r11] = r5
                int r6 = r6 + 4
                int r3 = r3 + -1
                if (r3 != 0) goto L_0x00e4
                boolean r3 = r0.e
                if (r3 == 0) goto L_0x00dd
                int r3 = r6 + 1
                r2[r6] = r13
                r6 = r3
            L_0x00dd:
                int r3 = r6 + 1
                r2[r6] = r14
                r6 = r3
                r11 = r10
                goto L_0x008a
            L_0x00e4:
                r11 = r10
                goto L_0x0090
            L_0x00e6:
                int r5 = r0.j
                int r10 = r11 - r5
                int r15 = r4 + -1
                r16 = 61
                if (r10 != r15) goto L_0x0135
                if (r5 <= 0) goto L_0x00f8
                byte[] r7 = r0.i
                byte r7 = r7[r8]
                r8 = r9
                goto L_0x00fe
            L_0x00f8:
                int r7 = r11 + 1
                byte r10 = r19[r11]
                r11 = r7
                r7 = r10
            L_0x00fe:
                r7 = r7 & 255(0xff, float:3.57E-43)
                int r7 = r7 << r12
                int r5 = r5 - r8
                r0.j = r5
                int r5 = r6 + 1
                int r8 = r7 >> 6
                r8 = r8 & 63
                byte r8 = r1[r8]
                r2[r6] = r8
                int r6 = r5 + 1
                r7 = r7 & 63
                byte r1 = r1[r7]
                r2[r5] = r1
                boolean r1 = r0.c
                if (r1 == 0) goto L_0x0122
                int r1 = r6 + 1
                r2[r6] = r16
                int r6 = r1 + 1
                r2[r1] = r16
            L_0x0122:
                boolean r1 = r0.d
                if (r1 == 0) goto L_0x01b9
                boolean r1 = r0.e
                if (r1 == 0) goto L_0x012f
                int r1 = r6 + 1
                r2[r6] = r13
                r6 = r1
            L_0x012f:
                int r1 = r6 + 1
                r2[r6] = r14
                goto L_0x01b8
            L_0x0135:
                int r10 = r11 - r5
                int r12 = r4 + -2
                if (r10 != r12) goto L_0x01a1
                if (r5 <= r9) goto L_0x0143
                byte[] r10 = r0.i
                byte r8 = r10[r8]
                r10 = r9
                goto L_0x014d
            L_0x0143:
                int r10 = r11 + 1
                byte r11 = r19[r11]
                r17 = r10
                r10 = r8
                r8 = r11
                r11 = r17
            L_0x014d:
                r8 = r8 & 255(0xff, float:3.57E-43)
                int r8 = r8 << r14
                if (r5 <= 0) goto L_0x0159
                byte[] r12 = r0.i
                int r15 = r10 + 1
                byte r10 = r12[r10]
                goto L_0x0160
            L_0x0159:
                int r12 = r11 + 1
                byte r11 = r19[r11]
                r15 = r10
                r10 = r11
                r11 = r12
            L_0x0160:
                r10 = r10 & 255(0xff, float:3.57E-43)
                int r7 = r10 << 2
                r7 = r7 | r8
                int r5 = r5 - r15
                r0.j = r5
                int r5 = r6 + 1
                int r8 = r7 >> 12
                r8 = r8 & 63
                byte r8 = r1[r8]
                r2[r6] = r8
                int r6 = r5 + 1
                int r8 = r7 >> 6
                r8 = r8 & 63
                byte r8 = r1[r8]
                r2[r5] = r8
                int r5 = r6 + 1
                r7 = r7 & 63
                byte r1 = r1[r7]
                r2[r6] = r1
                boolean r1 = r0.c
                if (r1 == 0) goto L_0x018d
                int r1 = r5 + 1
                r2[r5] = r16
                r5 = r1
            L_0x018d:
                boolean r1 = r0.d
                if (r1 == 0) goto L_0x019f
                boolean r1 = r0.e
                if (r1 == 0) goto L_0x019a
                int r1 = r5 + 1
                r2[r5] = r13
                r5 = r1
            L_0x019a:
                int r1 = r5 + 1
                r2[r5] = r14
                goto L_0x01b8
            L_0x019f:
                r6 = r5
                goto L_0x01b9
            L_0x01a1:
                boolean r1 = r0.d
                if (r1 == 0) goto L_0x01b9
                if (r6 <= 0) goto L_0x01b9
                r1 = 19
                if (r3 == r1) goto L_0x01b9
                boolean r1 = r0.e
                if (r1 == 0) goto L_0x01b4
                int r1 = r6 + 1
                r2[r6] = r13
                r6 = r1
            L_0x01b4:
                int r1 = r6 + 1
                r2[r6] = r14
            L_0x01b8:
                r6 = r1
            L_0x01b9:
                boolean r1 = m
                if (r1 != 0) goto L_0x01c8
                int r2 = r0.j
                if (r2 != 0) goto L_0x01c2
                goto L_0x01c8
            L_0x01c2:
                java.lang.AssertionError r1 = new java.lang.AssertionError
                r1.<init>()
                throw r1
            L_0x01c8:
                if (r1 != 0) goto L_0x01d3
                if (r11 != r4) goto L_0x01cd
                goto L_0x01d3
            L_0x01cd:
                java.lang.AssertionError r1 = new java.lang.AssertionError
                r1.<init>()
                throw r1
            L_0x01d3:
                r0.b = r6
                r0.k = r3
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bs.i.c.a(byte[], int, int, boolean):boolean");
        }
    }

    private i() {
    }
}
