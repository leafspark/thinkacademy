package com.igexin.push.util;

import com.bonree.sdk.agent.engine.webview.entity.WebViewRouteChangeEvent;

class i extends h {
    private static final int[] c;
    private static final int[] d;
    private int e;
    private int f;
    private final int[] g;

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

    public i(int i, byte[] bArr) {
        this.a = bArr;
        this.g = (i & 8) == 0 ? c : d;
        this.e = 0;
        this.f = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bd, code lost:
        r0.e = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c0, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ef, code lost:
        if (r20 != false) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f1, code lost:
        r0.e = r5;
        r0.f = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f5, code lost:
        r0.b = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f7, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f8, code lost:
        if (r5 == 1) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00fa, code lost:
        if (r5 == 2) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00fc, code lost:
        if (r5 == 3) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00fe, code lost:
        if (r5 == 4) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0101, code lost:
        r1 = r9 + 1;
        r6[r9] = (byte) (r8 >> 10);
        r9 = r1 + 1;
        r6[r1] = (byte) (r8 >> 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0110, code lost:
        r6[r9] = (byte) (r8 >> 4);
        r9 = r9 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0118, code lost:
        r0.e = r5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ef A[EDGE_INSN: B:69:0x00ef->B:54:0x00ef ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(byte[] r17, int r18, int r19, boolean r20) {
        /*
            r16 = this;
            r0 = r16
            int r1 = r0.e
            r2 = 0
            r3 = 6
            if (r1 != r3) goto L_0x0009
            return r2
        L_0x0009:
            int r4 = r19 + r18
            int r5 = r0.f
            byte[] r6 = r0.a
            int[] r7 = r0.g
            r9 = r2
            r8 = r5
            r5 = r1
            r1 = r18
        L_0x0016:
            r10 = 3
            r11 = 4
            r12 = 2
            r13 = 1
            if (r1 >= r4) goto L_0x00ef
            if (r5 != 0) goto L_0x0063
        L_0x001e:
            int r14 = r1 + 4
            if (r14 > r4) goto L_0x005f
            byte r8 = r17[r1]
            r8 = r8 & 255(0xff, float:3.57E-43)
            r8 = r7[r8]
            int r8 = r8 << 18
            int r15 = r1 + 1
            byte r15 = r17[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r7[r15]
            int r15 = r15 << 12
            r8 = r8 | r15
            int r15 = r1 + 2
            byte r15 = r17[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r7[r15]
            int r15 = r15 << r3
            r8 = r8 | r15
            int r15 = r1 + 3
            byte r15 = r17[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r7[r15]
            r8 = r8 | r15
            if (r8 < 0) goto L_0x005f
            int r1 = r9 + 2
            byte r15 = (byte) r8
            r6[r1] = r15
            int r1 = r9 + 1
            int r15 = r8 >> 8
            byte r15 = (byte) r15
            r6[r1] = r15
            int r1 = r8 >> 16
            byte r1 = (byte) r1
            r6[r9] = r1
            int r9 = r9 + 3
            r1 = r14
            goto L_0x001e
        L_0x005f:
            if (r1 < r4) goto L_0x0063
            goto L_0x00ef
        L_0x0063:
            int r14 = r1 + 1
            byte r1 = r17[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r7[r1]
            r15 = 5
            r2 = -1
            if (r5 == 0) goto L_0x00df
            if (r5 == r13) goto L_0x00d3
            r13 = -2
            if (r5 == r12) goto L_0x00c1
            if (r5 == r10) goto L_0x008e
            if (r5 == r11) goto L_0x0082
            if (r5 == r15) goto L_0x007c
            goto L_0x00eb
        L_0x007c:
            if (r1 == r2) goto L_0x00eb
        L_0x007e:
            r0.e = r3
            r10 = 0
            return r10
        L_0x0082:
            r10 = 0
            if (r1 != r13) goto L_0x0089
            int r5 = r5 + 1
            goto L_0x00eb
        L_0x0089:
            if (r1 == r2) goto L_0x00eb
            r0.e = r3
            return r10
        L_0x008e:
            if (r1 < 0) goto L_0x00a9
            int r2 = r8 << 6
            r1 = r1 | r2
            int r2 = r9 + 2
            byte r5 = (byte) r1
            r6[r2] = r5
            int r2 = r9 + 1
            int r5 = r1 >> 8
            byte r5 = (byte) r5
            r6[r2] = r5
            int r2 = r1 >> 16
            byte r2 = (byte) r2
            r6[r9] = r2
            int r9 = r9 + 3
            r8 = r1
            r5 = 0
            goto L_0x00eb
        L_0x00a9:
            if (r1 != r13) goto L_0x00bb
            int r1 = r9 + 1
            int r2 = r8 >> 2
            byte r2 = (byte) r2
            r6[r1] = r2
            int r1 = r8 >> 10
            byte r1 = (byte) r1
            r6[r9] = r1
            int r9 = r9 + 2
            r5 = r15
            goto L_0x00eb
        L_0x00bb:
            if (r1 == r2) goto L_0x00eb
        L_0x00bd:
            r0.e = r3
            r1 = 0
            return r1
        L_0x00c1:
            if (r1 < 0) goto L_0x00c4
            goto L_0x00d6
        L_0x00c4:
            if (r1 != r13) goto L_0x00d0
            int r1 = r9 + 1
            int r2 = r8 >> 4
            byte r2 = (byte) r2
            r6[r9] = r2
            r9 = r1
            r5 = r11
            goto L_0x00eb
        L_0x00d0:
            if (r1 == r2) goto L_0x00eb
            goto L_0x007e
        L_0x00d3:
            r10 = 0
            if (r1 < 0) goto L_0x00da
        L_0x00d6:
            int r2 = r8 << 6
            r1 = r1 | r2
            goto L_0x00e2
        L_0x00da:
            if (r1 == r2) goto L_0x00eb
            r0.e = r3
            return r10
        L_0x00df:
            r10 = 0
            if (r1 < 0) goto L_0x00e6
        L_0x00e2:
            int r5 = r5 + 1
            r8 = r1
            goto L_0x00eb
        L_0x00e6:
            if (r1 == r2) goto L_0x00eb
            r0.e = r3
            return r10
        L_0x00eb:
            r1 = r14
            r2 = 0
            goto L_0x0016
        L_0x00ef:
            if (r20 != 0) goto L_0x00f8
            r0.e = r5
            r0.f = r8
        L_0x00f5:
            r0.b = r9
            return r13
        L_0x00f8:
            if (r5 == r13) goto L_0x00bd
            if (r5 == r12) goto L_0x0110
            if (r5 == r10) goto L_0x0101
            if (r5 == r11) goto L_0x00bd
            goto L_0x0118
        L_0x0101:
            int r1 = r9 + 1
            int r2 = r8 >> 10
            byte r2 = (byte) r2
            r6[r9] = r2
            int r9 = r1 + 1
            int r2 = r8 >> 2
            byte r2 = (byte) r2
            r6[r1] = r2
            goto L_0x0118
        L_0x0110:
            int r1 = r9 + 1
            int r2 = r8 >> 4
            byte r2 = (byte) r2
            r6[r9] = r2
            r9 = r1
        L_0x0118:
            r0.e = r5
            goto L_0x00f5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.i.a(byte[], int, int, boolean):boolean");
    }
}
