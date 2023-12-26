package net.lucode.hackware.magicindicator.buildins;

import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;

public class ArgbEvaluatorHolder {
    public static int eval(float f, int i, int i2) {
        int i3 = (i >> 24) & GF2Field.MASK;
        int i4 = (i >> 16) & GF2Field.MASK;
        int i5 = (i >> 8) & GF2Field.MASK;
        int i6 = i & GF2Field.MASK;
        int i7 = (i2 >> 24) & GF2Field.MASK;
        int i8 = (i2 >> 16) & GF2Field.MASK;
        int i9 = (i2 >> 8) & GF2Field.MASK;
        return ((i3 + ((int) (((float) (i7 - i3)) * f))) << 24) | ((i4 + ((int) (((float) (i8 - i4)) * f))) << 16) | ((i5 + ((int) (((float) (i9 - i5)) * f))) << 8) | (i6 + ((int) (f * ((float) ((i2 & GF2Field.MASK) - i6)))));
    }
}
