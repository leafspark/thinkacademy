package io.flutter.plugin.editing;

import io.flutter.embedding.engine.FlutterJNI;

class FlutterTextUtils {
    public static final int CANCEL_TAG = 917631;
    public static final int CARRIAGE_RETURN = 13;
    public static final int COMBINING_ENCLOSING_KEYCAP = 8419;
    public static final int LINE_FEED = 10;
    public static final int ZERO_WIDTH_JOINER = 8205;
    private final FlutterJNI flutterJNI;

    public boolean isKeycapBase(int i) {
        return (48 <= i && i <= 57) || i == 35 || i == 42;
    }

    public boolean isTagSpecChar(int i) {
        return 917536 <= i && i <= 917630;
    }

    public FlutterTextUtils(FlutterJNI flutterJNI2) {
        this.flutterJNI = flutterJNI2;
    }

    public boolean isEmoji(int i) {
        return this.flutterJNI.isCodePointEmoji(i);
    }

    public boolean isEmojiModifier(int i) {
        return this.flutterJNI.isCodePointEmojiModifier(i);
    }

    public boolean isEmojiModifierBase(int i) {
        return this.flutterJNI.isCodePointEmojiModifierBase(i);
    }

    public boolean isVariationSelector(int i) {
        return this.flutterJNI.isCodePointVariantSelector(i);
    }

    public boolean isRegionalIndicatorSymbol(int i) {
        return this.flutterJNI.isCodePointRegionalIndicator(i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r2 = java.lang.Character.codePointBefore(r9, r10);
        r3 = java.lang.Character.charCount(r2);
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0155 A[EDGE_INSN: B:100:0x0155->B:93:0x0155 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x014d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getOffsetBefore(java.lang.CharSequence r9, int r10) {
        /*
            r8 = this;
            r0 = 0
            r1 = 1
            if (r10 > r1) goto L_0x0005
            return r0
        L_0x0005:
            int r2 = java.lang.Character.codePointBefore(r9, r10)
            int r3 = java.lang.Character.charCount(r2)
            int r4 = r10 - r3
            if (r4 != 0) goto L_0x0012
            return r0
        L_0x0012:
            r5 = 10
            if (r2 != r5) goto L_0x0022
            int r9 = java.lang.Character.codePointBefore(r9, r4)
            r0 = 13
            if (r9 != r0) goto L_0x0020
            int r3 = r3 + 1
        L_0x0020:
            int r10 = r10 - r3
            return r10
        L_0x0022:
            boolean r5 = r8.isRegionalIndicatorSymbol(r2)
            if (r5 == 0) goto L_0x004d
            int r0 = java.lang.Character.codePointBefore(r9, r4)
            int r2 = java.lang.Character.charCount(r0)
            int r4 = r4 - r2
        L_0x0031:
            if (r4 <= 0) goto L_0x0045
            boolean r0 = r8.isRegionalIndicatorSymbol(r0)
            if (r0 == 0) goto L_0x0045
            int r0 = java.lang.Character.codePointBefore(r9, r4)
            int r2 = java.lang.Character.charCount(r0)
            int r4 = r4 - r2
            int r1 = r1 + 1
            goto L_0x0031
        L_0x0045:
            int r1 = r1 % 2
            if (r1 != 0) goto L_0x004b
            int r3 = r3 + 2
        L_0x004b:
            int r10 = r10 - r3
            return r10
        L_0x004d:
            r5 = 8419(0x20e3, float:1.1798E-41)
            if (r2 != r5) goto L_0x0084
            int r0 = java.lang.Character.codePointBefore(r9, r4)
            int r1 = java.lang.Character.charCount(r0)
            int r4 = r4 - r1
            if (r4 <= 0) goto L_0x0077
            boolean r1 = r8.isVariationSelector(r0)
            if (r1 == 0) goto L_0x0077
            int r9 = java.lang.Character.codePointBefore(r9, r4)
            boolean r1 = r8.isKeycapBase(r9)
            if (r1 == 0) goto L_0x0082
            int r0 = java.lang.Character.charCount(r0)
            int r9 = java.lang.Character.charCount(r9)
            int r0 = r0 + r9
            int r3 = r3 + r0
            goto L_0x0082
        L_0x0077:
            boolean r9 = r8.isKeycapBase(r0)
            if (r9 == 0) goto L_0x0082
            int r9 = java.lang.Character.charCount(r0)
            int r3 = r3 + r9
        L_0x0082:
            int r10 = r10 - r3
            return r10
        L_0x0084:
            r5 = 917631(0xe007f, float:1.285875E-39)
            if (r2 != r5) goto L_0x00b6
            int r2 = java.lang.Character.codePointBefore(r9, r4)
            int r5 = java.lang.Character.charCount(r2)
        L_0x0091:
            int r4 = r4 - r5
            if (r4 <= 0) goto L_0x00a8
            boolean r5 = r8.isTagSpecChar(r2)
            if (r5 == 0) goto L_0x00a8
            int r2 = java.lang.Character.charCount(r2)
            int r3 = r3 + r2
            int r2 = java.lang.Character.codePointBefore(r9, r4)
            int r5 = java.lang.Character.charCount(r2)
            goto L_0x0091
        L_0x00a8:
            boolean r5 = r8.isEmoji(r2)
            if (r5 != 0) goto L_0x00b1
            int r10 = r10 + -2
            return r10
        L_0x00b1:
            int r5 = java.lang.Character.charCount(r2)
            int r3 = r3 + r5
        L_0x00b6:
            boolean r5 = r8.isVariationSelector(r2)
            if (r5 == 0) goto L_0x00ce
            int r2 = java.lang.Character.codePointBefore(r9, r4)
            boolean r5 = r8.isEmoji(r2)
            if (r5 != 0) goto L_0x00c8
            int r10 = r10 - r3
            return r10
        L_0x00c8:
            int r5 = java.lang.Character.charCount(r2)
            int r3 = r3 + r5
            int r4 = r4 - r3
        L_0x00ce:
            boolean r5 = r8.isEmoji(r2)
            if (r5 == 0) goto L_0x0155
            r5 = r0
            r6 = r5
        L_0x00d6:
            if (r5 == 0) goto L_0x00e0
            int r5 = java.lang.Character.charCount(r2)
            int r5 = r5 + r6
            int r5 = r5 + r1
            int r3 = r3 + r5
            r5 = r0
        L_0x00e0:
            boolean r6 = r8.isEmojiModifier(r2)
            if (r6 == 0) goto L_0x0117
            int r1 = java.lang.Character.codePointBefore(r9, r4)
            int r2 = java.lang.Character.charCount(r1)
            int r4 = r4 - r2
            if (r4 <= 0) goto L_0x010a
            boolean r2 = r8.isVariationSelector(r1)
            if (r2 == 0) goto L_0x010a
            int r1 = java.lang.Character.codePointBefore(r9, r4)
            boolean r9 = r8.isEmoji(r1)
            if (r9 != 0) goto L_0x0103
            int r10 = r10 - r3
            return r10
        L_0x0103:
            int r0 = java.lang.Character.charCount(r1)
            java.lang.Character.charCount(r1)
        L_0x010a:
            boolean r9 = r8.isEmojiModifierBase(r1)
            if (r9 == 0) goto L_0x0155
            int r9 = java.lang.Character.charCount(r1)
            int r0 = r0 + r9
            int r3 = r3 + r0
            goto L_0x0155
        L_0x0117:
            if (r4 <= 0) goto L_0x0149
            int r2 = java.lang.Character.codePointBefore(r9, r4)
            int r6 = java.lang.Character.charCount(r2)
            int r4 = r4 - r6
            r6 = 8205(0x200d, float:1.1498E-41)
            if (r2 != r6) goto L_0x0149
            int r2 = java.lang.Character.codePointBefore(r9, r4)
            int r5 = java.lang.Character.charCount(r2)
            int r4 = r4 - r5
            if (r4 <= 0) goto L_0x0146
            boolean r5 = r8.isVariationSelector(r2)
            if (r5 == 0) goto L_0x0146
            int r2 = java.lang.Character.codePointBefore(r9, r4)
            int r5 = java.lang.Character.charCount(r2)
            int r6 = java.lang.Character.charCount(r2)
            int r4 = r4 - r6
            r6 = r5
            goto L_0x0147
        L_0x0146:
            r6 = r0
        L_0x0147:
            r5 = r1
            goto L_0x014a
        L_0x0149:
            r6 = r0
        L_0x014a:
            if (r4 != 0) goto L_0x014d
            goto L_0x0155
        L_0x014d:
            if (r5 == 0) goto L_0x0155
            boolean r7 = r8.isEmoji(r2)
            if (r7 != 0) goto L_0x00d6
        L_0x0155:
            int r10 = r10 - r3
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.FlutterTextUtils.getOffsetBefore(java.lang.CharSequence, int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:87:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0144 A[EDGE_INSN: B:98:0x0144->B:90:0x0144 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getOffsetAfter(java.lang.CharSequence r10, int r11) {
        /*
            r9 = this;
            int r0 = r10.length()
            int r1 = r0 + -1
            if (r11 < r1) goto L_0x0009
            return r0
        L_0x0009:
            int r2 = java.lang.Character.codePointAt(r10, r11)
            int r3 = java.lang.Character.charCount(r2)
            int r4 = r11 + r3
            r5 = 0
            if (r4 != 0) goto L_0x0017
            return r5
        L_0x0017:
            r6 = 10
            if (r2 != r6) goto L_0x0027
            int r10 = java.lang.Character.codePointAt(r10, r4)
            r0 = 13
            if (r10 != r0) goto L_0x0025
            int r3 = r3 + 1
        L_0x0025:
            int r11 = r11 + r3
            return r11
        L_0x0027:
            boolean r6 = r9.isRegionalIndicatorSymbol(r2)
            if (r6 == 0) goto L_0x005c
            if (r4 >= r1) goto L_0x005b
            int r0 = java.lang.Character.codePointAt(r10, r4)
            boolean r0 = r9.isRegionalIndicatorSymbol(r0)
            if (r0 != 0) goto L_0x003a
            goto L_0x005b
        L_0x003a:
            r0 = r11
        L_0x003b:
            if (r0 <= 0) goto L_0x0053
            int r1 = java.lang.Character.codePointBefore(r10, r11)
            boolean r1 = r9.isRegionalIndicatorSymbol(r1)
            if (r1 == 0) goto L_0x0053
            int r1 = java.lang.Character.codePointBefore(r10, r11)
            int r1 = java.lang.Character.charCount(r1)
            int r0 = r0 - r1
            int r5 = r5 + 1
            goto L_0x003b
        L_0x0053:
            int r5 = r5 % 2
            if (r5 != 0) goto L_0x0059
            int r3 = r3 + 2
        L_0x0059:
            int r11 = r11 + r3
            return r11
        L_0x005b:
            return r4
        L_0x005c:
            boolean r1 = r9.isKeycapBase(r2)
            if (r1 == 0) goto L_0x0067
            int r1 = java.lang.Character.charCount(r2)
            int r3 = r3 + r1
        L_0x0067:
            r1 = 8419(0x20e3, float:1.1798E-41)
            if (r2 != r1) goto L_0x009e
            int r1 = java.lang.Character.codePointBefore(r10, r4)
            int r2 = java.lang.Character.charCount(r1)
            int r4 = r4 + r2
            if (r4 >= r0) goto L_0x0091
            boolean r0 = r9.isVariationSelector(r1)
            if (r0 == 0) goto L_0x0091
            int r10 = java.lang.Character.codePointAt(r10, r4)
            boolean r0 = r9.isKeycapBase(r10)
            if (r0 == 0) goto L_0x009c
            int r0 = java.lang.Character.charCount(r1)
            int r10 = java.lang.Character.charCount(r10)
            int r0 = r0 + r10
            int r3 = r3 + r0
            goto L_0x009c
        L_0x0091:
            boolean r10 = r9.isKeycapBase(r1)
            if (r10 == 0) goto L_0x009c
            int r10 = java.lang.Character.charCount(r1)
            int r3 = r3 + r10
        L_0x009c:
            int r11 = r11 + r3
            return r11
        L_0x009e:
            boolean r6 = r9.isEmoji(r2)
            if (r6 == 0) goto L_0x0144
            r6 = r5
            r7 = r6
        L_0x00a6:
            r8 = 1
            if (r6 == 0) goto L_0x00b1
            int r6 = java.lang.Character.charCount(r2)
            int r6 = r6 + r7
            int r6 = r6 + r8
            int r3 = r3 + r6
            r6 = r5
        L_0x00b1:
            boolean r7 = r9.isEmojiModifier(r2)
            if (r7 == 0) goto L_0x00b9
            goto L_0x0144
        L_0x00b9:
            if (r4 >= r0) goto L_0x0138
            int r2 = java.lang.Character.codePointAt(r10, r4)
            int r7 = java.lang.Character.charCount(r2)
            int r4 = r4 + r7
            if (r2 != r1) goto L_0x00f9
            int r1 = java.lang.Character.codePointBefore(r10, r4)
            int r2 = java.lang.Character.charCount(r1)
            int r4 = r4 + r2
            if (r4 >= r0) goto L_0x00ec
            boolean r0 = r9.isVariationSelector(r1)
            if (r0 == 0) goto L_0x00ec
            int r10 = java.lang.Character.codePointAt(r10, r4)
            boolean r0 = r9.isKeycapBase(r10)
            if (r0 == 0) goto L_0x00f7
            int r0 = java.lang.Character.charCount(r1)
            int r10 = java.lang.Character.charCount(r10)
            int r0 = r0 + r10
            int r3 = r3 + r0
            goto L_0x00f7
        L_0x00ec:
            boolean r10 = r9.isKeycapBase(r1)
            if (r10 == 0) goto L_0x00f7
            int r10 = java.lang.Character.charCount(r1)
            int r3 = r3 + r10
        L_0x00f7:
            int r11 = r11 + r3
            return r11
        L_0x00f9:
            boolean r7 = r9.isEmojiModifier(r2)
            if (r7 == 0) goto L_0x0106
            int r10 = java.lang.Character.charCount(r2)
        L_0x0103:
            int r10 = r10 + r5
            int r3 = r3 + r10
            goto L_0x0144
        L_0x0106:
            boolean r7 = r9.isVariationSelector(r2)
            if (r7 == 0) goto L_0x0111
            int r10 = java.lang.Character.charCount(r2)
            goto L_0x0103
        L_0x0111:
            r7 = 8205(0x200d, float:1.1498E-41)
            if (r2 != r7) goto L_0x0138
            int r2 = java.lang.Character.codePointAt(r10, r4)
            int r6 = java.lang.Character.charCount(r2)
            int r4 = r4 + r6
            if (r4 >= r0) goto L_0x0135
            boolean r6 = r9.isVariationSelector(r2)
            if (r6 == 0) goto L_0x0135
            int r2 = java.lang.Character.codePointAt(r10, r4)
            int r6 = java.lang.Character.charCount(r2)
            int r7 = java.lang.Character.charCount(r2)
            int r4 = r4 + r7
            r7 = r6
            goto L_0x0136
        L_0x0135:
            r7 = r5
        L_0x0136:
            r6 = r8
            goto L_0x0139
        L_0x0138:
            r7 = r5
        L_0x0139:
            if (r4 < r0) goto L_0x013c
            goto L_0x0144
        L_0x013c:
            if (r6 == 0) goto L_0x0144
            boolean r8 = r9.isEmoji(r2)
            if (r8 != 0) goto L_0x00a6
        L_0x0144:
            int r11 = r11 + r3
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.FlutterTextUtils.getOffsetAfter(java.lang.CharSequence, int):int");
    }
}
