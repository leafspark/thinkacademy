package com.alibaba.fastjson.util;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.airbnb.lottie.utils.Utils;

public final class RyuFloat {
    private static final int[][] POW5_INV_SPLIT = {new int[]{268435456, 1}, new int[]{214748364, 1717986919}, new int[]{171798691, 1803886265}, new int[]{137438953, 1013612282}, new int[]{219902325, 1192282922}, new int[]{175921860, 953826338}, new int[]{140737488, 763061070}, new int[]{225179981, 791400982}, new int[]{180143985, 203624056}, new int[]{144115188, 162899245}, new int[]{230584300, 1978625710}, new int[]{184467440, 1582900568}, new int[]{147573952, 1266320455}, new int[]{236118324, 308125809}, new int[]{188894659, 675997377}, new int[]{151115727, 970294631}, new int[]{241785163, 1981968139}, new int[]{193428131, 297084323}, new int[]{154742504, 1955654377}, new int[]{247588007, 1840556814}, new int[]{198070406, 613451992}, new int[]{158456325, 61264864}, new int[]{253530120, 98023782}, new int[]{202824096, 78419026}, new int[]{162259276, 1780722139}, new int[]{259614842, 1990161963}, new int[]{207691874, 733136111}, new int[]{166153499, 1016005619}, new int[]{265845599, 337118801}, new int[]{212676479, 699191770}, new int[]{170141183, 988850146}};
    private static final int[][] POW5_SPLIT = {new int[]{536870912, 0}, new int[]{671088640, 0}, new int[]{838860800, 0}, new int[]{1048576000, 0}, new int[]{655360000, 0}, new int[]{819200000, 0}, new int[]{1024000000, 0}, new int[]{640000000, 0}, new int[]{800000000, 0}, new int[]{Utils.SECOND_IN_NANOS, 0}, new int[]{625000000, 0}, new int[]{781250000, 0}, new int[]{976562500, 0}, new int[]{610351562, BasicMeasure.EXACTLY}, new int[]{762939453, 268435456}, new int[]{953674316, 872415232}, new int[]{596046447, 1619001344}, new int[]{745058059, 1486880768}, new int[]{931322574, 1321730048}, new int[]{582076609, 289210368}, new int[]{727595761, 898383872}, new int[]{909494701, 1659850752}, new int[]{568434188, 1305842176}, new int[]{710542735, 1632302720}, new int[]{888178419, 1503507488}, new int[]{555111512, 671256724}, new int[]{693889390, 839070905}, new int[]{867361737, 2122580455}, new int[]{542101086, 521306416}, new int[]{677626357, 1725374844}, new int[]{847032947, 546105819}, new int[]{1058791184, 145761362}, new int[]{661744490, 91100851}, new int[]{827180612, 1187617888}, new int[]{1033975765, 1484522360}, new int[]{646234853, 1196261931}, new int[]{807793566, 2032198326}, new int[]{1009741958, 1466506084}, new int[]{631088724, 379695390}, new int[]{788860905, 474619238}, new int[]{986076131, 1130144959}, new int[]{616297582, 437905143}, new int[]{770371977, 1621123253}, new int[]{962964972, 415791331}, new int[]{601853107, 1333611405}, new int[]{752316384, 1130143345}, new int[]{940395480, 1412679181}};

    public static String toString(float f) {
        char[] cArr = new char[15];
        return new String(cArr, 0, toString(f, cArr, 0));
    }

    public static int toString(float f, char[] cArr, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        if (Float.isNaN(f)) {
            int i21 = i + 1;
            cArr[i] = 'N';
            int i22 = i21 + 1;
            cArr[i21] = 'a';
            i20 = i22 + 1;
            cArr[i22] = 'N';
        } else if (f == Float.POSITIVE_INFINITY) {
            int i23 = i + 1;
            cArr[i] = 'I';
            int i24 = i23 + 1;
            cArr[i23] = 'n';
            int i25 = i24 + 1;
            cArr[i24] = 'f';
            int i26 = i25 + 1;
            cArr[i25] = 'i';
            int i27 = i26 + 1;
            cArr[i26] = 'n';
            int i28 = i27 + 1;
            cArr[i27] = 'i';
            int i29 = i28 + 1;
            cArr[i28] = 't';
            cArr[i29] = 'y';
            return (i29 + 1) - i;
        } else if (f == Float.NEGATIVE_INFINITY) {
            int i30 = i + 1;
            cArr[i] = '-';
            int i31 = i30 + 1;
            cArr[i30] = 'I';
            int i32 = i31 + 1;
            cArr[i31] = 'n';
            int i33 = i32 + 1;
            cArr[i32] = 'f';
            int i34 = i33 + 1;
            cArr[i33] = 'i';
            int i35 = i34 + 1;
            cArr[i34] = 'n';
            int i36 = i35 + 1;
            cArr[i35] = 'i';
            int i37 = i36 + 1;
            cArr[i36] = 't';
            i20 = i37 + 1;
            cArr[i37] = 'y';
        } else {
            int floatToIntBits = Float.floatToIntBits(f);
            if (floatToIntBits == 0) {
                int i38 = i + 1;
                cArr[i] = '0';
                int i39 = i38 + 1;
                cArr[i38] = '.';
                i20 = i39 + 1;
                cArr[i39] = '0';
            } else if (floatToIntBits == Integer.MIN_VALUE) {
                int i40 = i + 1;
                cArr[i] = '-';
                int i41 = i40 + 1;
                cArr[i40] = '0';
                int i42 = i41 + 1;
                cArr[i41] = '.';
                cArr[i42] = '0';
                return (i42 + 1) - i;
            } else {
                int i43 = (floatToIntBits >> 23) & 255;
                int i44 = 8388607 & floatToIntBits;
                if (i43 == 0) {
                    i2 = -149;
                } else {
                    i2 = (i43 - 127) - 23;
                    i44 |= 8388608;
                }
                boolean z2 = floatToIntBits < 0;
                boolean z3 = (i44 & 1) == 0;
                int i45 = i44 * 4;
                int i46 = i45 + 2;
                int i47 = i45 - ((((long) i44) != 8388608 || i43 <= 1) ? 2 : 1);
                int i48 = i2 - 2;
                if (i48 >= 0) {
                    i11 = (int) ((((long) i48) * 3010299) / 10000000);
                    if (i11 == 0) {
                        i18 = 1;
                    } else {
                        i18 = (int) ((((((long) i11) * 23219280) + 10000000) - 1) / 10000000);
                    }
                    int i49 = (-i48) + i11;
                    int[][] iArr = POW5_INV_SPLIT;
                    long j = (long) iArr[i11][0];
                    z = z3;
                    long j2 = (long) iArr[i11][1];
                    long j3 = (long) i45;
                    int i50 = (((i18 + 59) - 1) + i49) - 31;
                    long j4 = j3;
                    long j5 = (long) i46;
                    i4 = (int) (((j5 * j) + ((j5 * j2) >> 31)) >> i50);
                    i3 = (int) (((j3 * j) + ((j3 * j2) >> 31)) >> i50);
                    int i51 = i47;
                    long j6 = (long) i51;
                    i9 = (int) (((j * j6) + ((j6 * j2) >> 31)) >> i50);
                    if (i11 == 0 || (i4 - 1) / 10 > i9 / 10) {
                        i10 = 0;
                    } else {
                        int i52 = i11 - 1;
                        if (i52 == 0) {
                            i19 = 1;
                        } else {
                            i19 = (int) ((((((long) i52) * 23219280) + 10000000) - 1) / 10000000);
                        }
                        i10 = (int) ((((((long) iArr[i52][0]) * j4) + ((((long) iArr[i52][1]) * j4) >> 31)) >> (((i49 - 1) + ((i19 + 59) - 1)) - 31)) % 10);
                    }
                    int i53 = 0;
                    while (i46 > 0 && i46 % 5 == 0) {
                        i46 /= 5;
                        i53++;
                    }
                    int i54 = 0;
                    while (i45 > 0 && i45 % 5 == 0) {
                        i45 /= 5;
                        i54++;
                    }
                    int i55 = 0;
                    while (i51 > 0 && i51 % 5 == 0) {
                        i51 /= 5;
                        i55++;
                    }
                    i8 = i53 >= i11 ? 1 : 0;
                    i7 = i54 >= i11 ? 1 : 0;
                    i6 = i55 >= i11 ? 1 : 0;
                    i5 = 0;
                } else {
                    int i56 = i47;
                    z = z3;
                    int i57 = -i48;
                    int i58 = (int) ((((long) i57) * 6989700) / 10000000);
                    int i59 = i57 - i58;
                    if (i59 == 0) {
                        i15 = 1;
                    } else {
                        i15 = (int) ((((((long) i59) * 23219280) + 10000000) - 1) / 10000000);
                    }
                    int[][] iArr2 = POW5_SPLIT;
                    long j7 = (long) iArr2[i59][0];
                    int i60 = i48;
                    long j8 = (long) iArr2[i59][1];
                    int i61 = (i58 - (i15 - 61)) - 31;
                    long j9 = (long) i45;
                    int i62 = i45;
                    int i63 = (int) (((j9 * j7) + ((j9 * j8) >> 31)) >> i61);
                    long j10 = (long) i46;
                    int i64 = (int) (((j10 * j7) + ((j10 * j8) >> 31)) >> i61);
                    int i65 = i56;
                    int i66 = i58;
                    long j11 = (long) i65;
                    i9 = (int) (((j7 * j11) + ((j11 * j8) >> 31)) >> i61);
                    if (i66 == 0 || (i64 - 1) / 10 > i9 / 10) {
                        i5 = 0;
                        i16 = 0;
                    } else {
                        int i67 = i59 + 1;
                        int i68 = i66 - 1;
                        if (i67 == 0) {
                            i17 = 1;
                        } else {
                            i17 = (int) ((((((long) i67) * 23219280) + 10000000) - 1) / 10000000);
                        }
                        i5 = 0;
                        i16 = (int) ((((((long) iArr2[i67][0]) * j9) + ((j9 * ((long) iArr2[i67][1])) >> 31)) >> ((i68 - (i17 - 61)) - 31)) % 10);
                    }
                    int i69 = i66 + i60;
                    int i70 = i66;
                    int i71 = 1 >= i70 ? 1 : i5;
                    int i72 = (i70 >= 23 || (i62 & ((1 << (i70 + -1)) - 1)) != 0) ? i5 : 1;
                    int i73 = (i65 % 2 == 1 ? i5 : 1) >= i70 ? 1 : i5;
                    i7 = i72;
                    i3 = i63;
                    i4 = i64;
                    int i74 = i69;
                    i10 = i16;
                    i11 = i74;
                    int i75 = i71;
                    i6 = i73;
                    i8 = i75;
                }
                int i76 = Utils.SECOND_IN_NANOS;
                int i77 = 10;
                while (i77 > 0 && i4 < i76) {
                    i76 /= 10;
                    i77--;
                }
                int i78 = (i11 + i77) - 1;
                int i79 = (i78 < -3 || i78 >= 7) ? 1 : i5;
                if (i8 != 0 && !z) {
                    i4--;
                }
                int i80 = i5;
                while (true) {
                    int i81 = i4 / 10;
                    int i82 = i9 / 10;
                    if (i81 > i82 && (i4 >= 100 || i79 == 0)) {
                        i6 &= i9 % 10 == 0 ? 1 : i5;
                        i10 = i3 % 10;
                        i3 /= 10;
                        i80++;
                        i4 = i81;
                        i9 = i82;
                    } else if (i6 != 0 && z) {
                        while (i9 % 10 == 0 && (i4 >= 100 || i79 == 0)) {
                            i4 /= 10;
                            i10 = i3 % 10;
                            i3 /= 10;
                            i9 /= 10;
                            i80++;
                        }
                    }
                }
                while (i9 % 10 == 0) {
                    i4 /= 10;
                    i10 = i3 % 10;
                    i3 /= 10;
                    i9 /= 10;
                    i80++;
                }
                if (i7 != 0 && i10 == 5 && i3 % 2 == 0) {
                    i10 = 4;
                }
                int i83 = i3 + (((i3 != i9 || (i6 != 0 && z)) && i10 < 5) ? i5 : 1);
                int i84 = i77 - i80;
                if (z2) {
                    i12 = i + 1;
                    cArr[i] = '-';
                } else {
                    i12 = i;
                }
                if (i79 != 0) {
                    while (i5 < i84 - 1) {
                        int i85 = i83 % 10;
                        i83 /= 10;
                        cArr[(i12 + i84) - i5] = (char) (i85 + 48);
                        i5++;
                    }
                    cArr[i12] = (char) ((i83 % 10) + 48);
                    cArr[i12 + 1] = '.';
                    int i86 = i12 + i84 + 1;
                    if (i84 == 1) {
                        cArr[i86] = '0';
                        i86++;
                    }
                    int i87 = i86 + 1;
                    cArr[i86] = 'E';
                    if (i78 < 0) {
                        cArr[i87] = '-';
                        i78 = -i78;
                        i87++;
                    }
                    if (i78 >= 10) {
                        i14 = 48;
                        cArr[i87] = (char) ((i78 / 10) + 48);
                        i87++;
                    } else {
                        i14 = 48;
                    }
                    i13 = i87 + 1;
                    cArr[i87] = (char) ((i78 % 10) + i14);
                } else {
                    int i88 = 48;
                    if (i78 < 0) {
                        int i89 = i12 + 1;
                        cArr[i12] = '0';
                        int i90 = i89 + 1;
                        cArr[i89] = '.';
                        int i91 = -1;
                        while (i91 > i78) {
                            cArr[i90] = '0';
                            i91--;
                            i90++;
                        }
                        int i92 = i90;
                        while (i5 < i84) {
                            cArr[((i90 + i84) - i5) - 1] = (char) ((i83 % 10) + i88);
                            i83 /= 10;
                            i92++;
                            i5++;
                            i88 = 48;
                        }
                        i13 = i92;
                    } else {
                        int i93 = i78 + 1;
                        if (i93 >= i84) {
                            while (i5 < i84) {
                                cArr[((i12 + i84) - i5) - 1] = (char) ((i83 % 10) + 48);
                                i83 /= 10;
                                i5++;
                            }
                            int i94 = i12 + i84;
                            while (i84 < i93) {
                                cArr[i94] = '0';
                                i84++;
                                i94++;
                            }
                            int i95 = i94 + 1;
                            cArr[i94] = '.';
                            i13 = i95 + 1;
                            cArr[i95] = '0';
                        } else {
                            int i96 = i12 + 1;
                            while (i5 < i84) {
                                if ((i84 - i5) - 1 == i78) {
                                    cArr[((i96 + i84) - i5) - 1] = '.';
                                    i96--;
                                }
                                cArr[((i96 + i84) - i5) - 1] = (char) ((i83 % 10) + 48);
                                i83 /= 10;
                                i5++;
                            }
                            i13 = i12 + i84 + 1;
                        }
                    }
                }
                return i13 - i;
            }
        }
        return i20 - i;
    }
}
