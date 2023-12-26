package androidx.camera.core.impl.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

final class ExifAttribute {
    static final Charset ASCII = StandardCharsets.US_ASCII;
    public static final long BYTES_OFFSET_UNKNOWN = -1;
    static final byte[] EXIF_ASCII_PREFIX = {65, 83, 67, 73, 73, 0, 0, 0};
    static final int IFD_FORMAT_BYTE = 1;
    static final int[] IFD_FORMAT_BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final int IFD_FORMAT_DOUBLE = 12;
    static final String[] IFD_FORMAT_NAMES = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int IFD_FORMAT_SBYTE = 6;
    static final int IFD_FORMAT_SINGLE = 11;
    static final int IFD_FORMAT_SLONG = 9;
    static final int IFD_FORMAT_SRATIONAL = 10;
    static final int IFD_FORMAT_SSHORT = 8;
    static final int IFD_FORMAT_STRING = 2;
    static final int IFD_FORMAT_ULONG = 4;
    static final int IFD_FORMAT_UNDEFINED = 7;
    static final int IFD_FORMAT_URATIONAL = 5;
    static final int IFD_FORMAT_USHORT = 3;
    private static final String TAG = "ExifAttribute";
    public final byte[] bytes;
    public final long bytesOffset;
    public final int format;
    public final int numberOfComponents;

    ExifAttribute(int i, int i2, byte[] bArr) {
        this(i, i2, -1, bArr);
    }

    ExifAttribute(int i, int i2, long j, byte[] bArr) {
        this.format = i;
        this.numberOfComponents = i2;
        this.bytesOffset = j;
        this.bytes = bArr;
    }

    public static ExifAttribute createUShort(int[] iArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(IFD_FORMAT_BYTES_PER_FORMAT[3] * iArr.length)]);
        wrap.order(byteOrder);
        for (int i : iArr) {
            wrap.putShort((short) i);
        }
        return new ExifAttribute(3, iArr.length, wrap.array());
    }

    public static ExifAttribute createUShort(int i, ByteOrder byteOrder) {
        return createUShort(new int[]{i}, byteOrder);
    }

    public static ExifAttribute createULong(long[] jArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(IFD_FORMAT_BYTES_PER_FORMAT[4] * jArr.length)]);
        wrap.order(byteOrder);
        for (long j : jArr) {
            wrap.putInt((int) j);
        }
        return new ExifAttribute(4, jArr.length, wrap.array());
    }

    public static ExifAttribute createULong(long j, ByteOrder byteOrder) {
        return createULong(new long[]{j}, byteOrder);
    }

    public static ExifAttribute createSLong(int[] iArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(IFD_FORMAT_BYTES_PER_FORMAT[9] * iArr.length)]);
        wrap.order(byteOrder);
        for (int putInt : iArr) {
            wrap.putInt(putInt);
        }
        return new ExifAttribute(9, iArr.length, wrap.array());
    }

    public static ExifAttribute createSLong(int i, ByteOrder byteOrder) {
        return createSLong(new int[]{i}, byteOrder);
    }

    public static ExifAttribute createByte(String str) {
        if (str.length() != 1 || str.charAt(0) < '0' || str.charAt(0) > '1') {
            byte[] bytes2 = str.getBytes(ASCII);
            return new ExifAttribute(1, bytes2.length, bytes2);
        }
        return new ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
    }

    public static ExifAttribute createString(String str) {
        byte[] bytes2 = (str + 0).getBytes(ASCII);
        return new ExifAttribute(2, bytes2.length, bytes2);
    }

    public static ExifAttribute createURational(LongRational[] longRationalArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(IFD_FORMAT_BYTES_PER_FORMAT[5] * longRationalArr.length)]);
        wrap.order(byteOrder);
        for (LongRational longRational : longRationalArr) {
            wrap.putInt((int) longRational.getNumerator());
            wrap.putInt((int) longRational.getDenominator());
        }
        return new ExifAttribute(5, longRationalArr.length, wrap.array());
    }

    public static ExifAttribute createURational(LongRational longRational, ByteOrder byteOrder) {
        return createURational(new LongRational[]{longRational}, byteOrder);
    }

    public static ExifAttribute createSRational(LongRational[] longRationalArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(IFD_FORMAT_BYTES_PER_FORMAT[10] * longRationalArr.length)]);
        wrap.order(byteOrder);
        for (LongRational longRational : longRationalArr) {
            wrap.putInt((int) longRational.getNumerator());
            wrap.putInt((int) longRational.getDenominator());
        }
        return new ExifAttribute(10, longRationalArr.length, wrap.array());
    }

    public static ExifAttribute createSRational(LongRational longRational, ByteOrder byteOrder) {
        return createSRational(new LongRational[]{longRational}, byteOrder);
    }

    public static ExifAttribute createDouble(double[] dArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(IFD_FORMAT_BYTES_PER_FORMAT[12] * dArr.length)]);
        wrap.order(byteOrder);
        for (double putDouble : dArr) {
            wrap.putDouble(putDouble);
        }
        return new ExifAttribute(12, dArr.length, wrap.array());
    }

    public static ExifAttribute createDouble(double d, ByteOrder byteOrder) {
        return createDouble(new double[]{d}, byteOrder);
    }

    public String toString() {
        return "(" + IFD_FORMAT_NAMES[this.format] + ", data length:" + this.bytes.length + ")";
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x019f A[SYNTHETIC, Splitter:B:164:0x019f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getValue(java.nio.ByteOrder r11) {
        /*
            r10 = this;
            java.lang.String r0 = "IOException occurred while closing InputStream"
            java.lang.String r1 = "ExifAttribute"
            r2 = 0
            androidx.camera.core.impl.utils.ByteOrderedDataInputStream r3 = new androidx.camera.core.impl.utils.ByteOrderedDataInputStream     // Catch:{ IOException -> 0x0189, all -> 0x0187 }
            byte[] r4 = r10.bytes     // Catch:{ IOException -> 0x0189, all -> 0x0187 }
            r3.<init>((byte[]) r4)     // Catch:{ IOException -> 0x0189, all -> 0x0187 }
            r3.setByteOrder(r11)     // Catch:{ IOException -> 0x0185 }
            int r11 = r10.format     // Catch:{ IOException -> 0x0185 }
            r4 = 1
            r5 = 0
            switch(r11) {
                case 1: goto L_0x0148;
                case 2: goto L_0x00fd;
                case 3: goto L_0x00e3;
                case 4: goto L_0x00c9;
                case 5: goto L_0x00a6;
                case 6: goto L_0x0148;
                case 7: goto L_0x00fd;
                case 8: goto L_0x008c;
                case 9: goto L_0x0072;
                case 10: goto L_0x004d;
                case 11: goto L_0x0032;
                case 12: goto L_0x0018;
                default: goto L_0x0016;
            }     // Catch:{ IOException -> 0x0185 }
        L_0x0016:
            goto L_0x017c
        L_0x0018:
            int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0185 }
            double[] r11 = new double[r11]     // Catch:{ IOException -> 0x0185 }
        L_0x001c:
            int r4 = r10.numberOfComponents     // Catch:{ IOException -> 0x0185 }
            if (r5 >= r4) goto L_0x0029
            double r6 = r3.readDouble()     // Catch:{ IOException -> 0x0185 }
            r11[r5] = r6     // Catch:{ IOException -> 0x0185 }
            int r5 = r5 + 1
            goto L_0x001c
        L_0x0029:
            r3.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r2 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r2)
        L_0x0031:
            return r11
        L_0x0032:
            int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0185 }
            double[] r11 = new double[r11]     // Catch:{ IOException -> 0x0185 }
        L_0x0036:
            int r4 = r10.numberOfComponents     // Catch:{ IOException -> 0x0185 }
            if (r5 >= r4) goto L_0x0044
            float r4 = r3.readFloat()     // Catch:{ IOException -> 0x0185 }
            double r6 = (double) r4     // Catch:{ IOException -> 0x0185 }
            r11[r5] = r6     // Catch:{ IOException -> 0x0185 }
            int r5 = r5 + 1
            goto L_0x0036
        L_0x0044:
            r3.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x004c
        L_0x0048:
            r2 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r2)
        L_0x004c:
            return r11
        L_0x004d:
            int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0185 }
            androidx.camera.core.impl.utils.LongRational[] r11 = new androidx.camera.core.impl.utils.LongRational[r11]     // Catch:{ IOException -> 0x0185 }
        L_0x0051:
            int r4 = r10.numberOfComponents     // Catch:{ IOException -> 0x0185 }
            if (r5 >= r4) goto L_0x0069
            int r4 = r3.readInt()     // Catch:{ IOException -> 0x0185 }
            long r6 = (long) r4     // Catch:{ IOException -> 0x0185 }
            int r4 = r3.readInt()     // Catch:{ IOException -> 0x0185 }
            long r8 = (long) r4     // Catch:{ IOException -> 0x0185 }
            androidx.camera.core.impl.utils.LongRational r4 = new androidx.camera.core.impl.utils.LongRational     // Catch:{ IOException -> 0x0185 }
            r4.<init>(r6, r8)     // Catch:{ IOException -> 0x0185 }
            r11[r5] = r4     // Catch:{ IOException -> 0x0185 }
            int r5 = r5 + 1
            goto L_0x0051
        L_0x0069:
            r3.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r2 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r2)
        L_0x0071:
            return r11
        L_0x0072:
            int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0185 }
            int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0185 }
        L_0x0076:
            int r4 = r10.numberOfComponents     // Catch:{ IOException -> 0x0185 }
            if (r5 >= r4) goto L_0x0083
            int r4 = r3.readInt()     // Catch:{ IOException -> 0x0185 }
            r11[r5] = r4     // Catch:{ IOException -> 0x0185 }
            int r5 = r5 + 1
            goto L_0x0076
        L_0x0083:
            r3.close()     // Catch:{ IOException -> 0x0087 }
            goto L_0x008b
        L_0x0087:
            r2 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r2)
        L_0x008b:
            return r11
        L_0x008c:
            int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0185 }
            int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0185 }
        L_0x0090:
            int r4 = r10.numberOfComponents     // Catch:{ IOException -> 0x0185 }
            if (r5 >= r4) goto L_0x009d
            short r4 = r3.readShort()     // Catch:{ IOException -> 0x0185 }
            r11[r5] = r4     // Catch:{ IOException -> 0x0185 }
            int r5 = r5 + 1
            goto L_0x0090
        L_0x009d:
            r3.close()     // Catch:{ IOException -> 0x00a1 }
            goto L_0x00a5
        L_0x00a1:
            r2 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r2)
        L_0x00a5:
            return r11
        L_0x00a6:
            int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0185 }
            androidx.camera.core.impl.utils.LongRational[] r11 = new androidx.camera.core.impl.utils.LongRational[r11]     // Catch:{ IOException -> 0x0185 }
        L_0x00aa:
            int r4 = r10.numberOfComponents     // Catch:{ IOException -> 0x0185 }
            if (r5 >= r4) goto L_0x00c0
            long r6 = r3.readUnsignedInt()     // Catch:{ IOException -> 0x0185 }
            long r8 = r3.readUnsignedInt()     // Catch:{ IOException -> 0x0185 }
            androidx.camera.core.impl.utils.LongRational r4 = new androidx.camera.core.impl.utils.LongRational     // Catch:{ IOException -> 0x0185 }
            r4.<init>(r6, r8)     // Catch:{ IOException -> 0x0185 }
            r11[r5] = r4     // Catch:{ IOException -> 0x0185 }
            int r5 = r5 + 1
            goto L_0x00aa
        L_0x00c0:
            r3.close()     // Catch:{ IOException -> 0x00c4 }
            goto L_0x00c8
        L_0x00c4:
            r2 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r2)
        L_0x00c8:
            return r11
        L_0x00c9:
            int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0185 }
            long[] r11 = new long[r11]     // Catch:{ IOException -> 0x0185 }
        L_0x00cd:
            int r4 = r10.numberOfComponents     // Catch:{ IOException -> 0x0185 }
            if (r5 >= r4) goto L_0x00da
            long r6 = r3.readUnsignedInt()     // Catch:{ IOException -> 0x0185 }
            r11[r5] = r6     // Catch:{ IOException -> 0x0185 }
            int r5 = r5 + 1
            goto L_0x00cd
        L_0x00da:
            r3.close()     // Catch:{ IOException -> 0x00de }
            goto L_0x00e2
        L_0x00de:
            r2 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r2)
        L_0x00e2:
            return r11
        L_0x00e3:
            int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0185 }
            int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0185 }
        L_0x00e7:
            int r4 = r10.numberOfComponents     // Catch:{ IOException -> 0x0185 }
            if (r5 >= r4) goto L_0x00f4
            int r4 = r3.readUnsignedShort()     // Catch:{ IOException -> 0x0185 }
            r11[r5] = r4     // Catch:{ IOException -> 0x0185 }
            int r5 = r5 + 1
            goto L_0x00e7
        L_0x00f4:
            r3.close()     // Catch:{ IOException -> 0x00f8 }
            goto L_0x00fc
        L_0x00f8:
            r2 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r2)
        L_0x00fc:
            return r11
        L_0x00fd:
            int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0185 }
            byte[] r6 = EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x0185 }
            int r6 = r6.length     // Catch:{ IOException -> 0x0185 }
            if (r11 < r6) goto L_0x011a
            r11 = r5
        L_0x0105:
            byte[] r6 = EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x0185 }
            int r7 = r6.length     // Catch:{ IOException -> 0x0185 }
            if (r11 >= r7) goto L_0x0117
            byte[] r7 = r10.bytes     // Catch:{ IOException -> 0x0185 }
            byte r7 = r7[r11]     // Catch:{ IOException -> 0x0185 }
            byte r8 = r6[r11]     // Catch:{ IOException -> 0x0185 }
            if (r7 == r8) goto L_0x0114
            r4 = r5
            goto L_0x0117
        L_0x0114:
            int r11 = r11 + 1
            goto L_0x0105
        L_0x0117:
            if (r4 == 0) goto L_0x011a
            int r5 = r6.length     // Catch:{ IOException -> 0x0185 }
        L_0x011a:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0185 }
            r11.<init>()     // Catch:{ IOException -> 0x0185 }
        L_0x011f:
            int r4 = r10.numberOfComponents     // Catch:{ IOException -> 0x0185 }
            if (r5 >= r4) goto L_0x013b
            byte[] r4 = r10.bytes     // Catch:{ IOException -> 0x0185 }
            byte r4 = r4[r5]     // Catch:{ IOException -> 0x0185 }
            if (r4 != 0) goto L_0x012a
            goto L_0x013b
        L_0x012a:
            r6 = 32
            if (r4 < r6) goto L_0x0133
            char r4 = (char) r4     // Catch:{ IOException -> 0x0185 }
            r11.append(r4)     // Catch:{ IOException -> 0x0185 }
            goto L_0x0138
        L_0x0133:
            r4 = 63
            r11.append(r4)     // Catch:{ IOException -> 0x0185 }
        L_0x0138:
            int r5 = r5 + 1
            goto L_0x011f
        L_0x013b:
            java.lang.String r11 = r11.toString()     // Catch:{ IOException -> 0x0185 }
            r3.close()     // Catch:{ IOException -> 0x0143 }
            goto L_0x0147
        L_0x0143:
            r2 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r2)
        L_0x0147:
            return r11
        L_0x0148:
            byte[] r11 = r10.bytes     // Catch:{ IOException -> 0x0185 }
            int r6 = r11.length     // Catch:{ IOException -> 0x0185 }
            if (r6 != r4) goto L_0x016c
            byte r6 = r11[r5]     // Catch:{ IOException -> 0x0185 }
            if (r6 < 0) goto L_0x016c
            byte r6 = r11[r5]     // Catch:{ IOException -> 0x0185 }
            if (r6 > r4) goto L_0x016c
            java.lang.String r6 = new java.lang.String     // Catch:{ IOException -> 0x0185 }
            char[] r4 = new char[r4]     // Catch:{ IOException -> 0x0185 }
            byte r11 = r11[r5]     // Catch:{ IOException -> 0x0185 }
            int r11 = r11 + 48
            char r11 = (char) r11     // Catch:{ IOException -> 0x0185 }
            r4[r5] = r11     // Catch:{ IOException -> 0x0185 }
            r6.<init>(r4)     // Catch:{ IOException -> 0x0185 }
            r3.close()     // Catch:{ IOException -> 0x0167 }
            goto L_0x016b
        L_0x0167:
            r11 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r11)
        L_0x016b:
            return r6
        L_0x016c:
            java.lang.String r4 = new java.lang.String     // Catch:{ IOException -> 0x0185 }
            java.nio.charset.Charset r5 = ASCII     // Catch:{ IOException -> 0x0185 }
            r4.<init>(r11, r5)     // Catch:{ IOException -> 0x0185 }
            r3.close()     // Catch:{ IOException -> 0x0177 }
            goto L_0x017b
        L_0x0177:
            r11 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r11)
        L_0x017b:
            return r4
        L_0x017c:
            r3.close()     // Catch:{ IOException -> 0x0180 }
            goto L_0x0184
        L_0x0180:
            r11 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r11)
        L_0x0184:
            return r2
        L_0x0185:
            r11 = move-exception
            goto L_0x018b
        L_0x0187:
            r11 = move-exception
            goto L_0x019d
        L_0x0189:
            r11 = move-exception
            r3 = r2
        L_0x018b:
            java.lang.String r4 = "IOException occurred during reading a value"
            androidx.camera.core.Logger.w(r1, r4, r11)     // Catch:{ all -> 0x019b }
            if (r3 == 0) goto L_0x019a
            r3.close()     // Catch:{ IOException -> 0x0196 }
            goto L_0x019a
        L_0x0196:
            r11 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r11)
        L_0x019a:
            return r2
        L_0x019b:
            r11 = move-exception
            r2 = r3
        L_0x019d:
            if (r2 == 0) goto L_0x01a7
            r2.close()     // Catch:{ IOException -> 0x01a3 }
            goto L_0x01a7
        L_0x01a3:
            r2 = move-exception
            androidx.camera.core.Logger.e(r1, r0, r2)
        L_0x01a7:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.ExifAttribute.getValue(java.nio.ByteOrder):java.lang.Object");
    }

    public double getDoubleValue(ByteOrder byteOrder) {
        Object value = getValue(byteOrder);
        if (value == null) {
            throw new NumberFormatException("NULL can't be converted to a double value");
        } else if (value instanceof String) {
            return Double.parseDouble((String) value);
        } else {
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                if (jArr.length == 1) {
                    return (double) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            } else if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                if (iArr.length == 1) {
                    return (double) iArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            } else if (value instanceof double[]) {
                double[] dArr = (double[]) value;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            } else if (value instanceof LongRational[]) {
                LongRational[] longRationalArr = (LongRational[]) value;
                if (longRationalArr.length == 1) {
                    return longRationalArr[0].toDouble();
                }
                throw new NumberFormatException("There are more than one component");
            } else {
                throw new NumberFormatException("Couldn't find a double value");
            }
        }
    }

    public int getIntValue(ByteOrder byteOrder) {
        Object value = getValue(byteOrder);
        if (value == null) {
            throw new NumberFormatException("NULL can't be converted to a integer value");
        } else if (value instanceof String) {
            return Integer.parseInt((String) value);
        } else {
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            } else if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                if (iArr.length == 1) {
                    return iArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            } else {
                throw new NumberFormatException("Couldn't find a integer value");
            }
        }
    }

    public String getStringValue(ByteOrder byteOrder) {
        Object value = getValue(byteOrder);
        if (value == null) {
            return null;
        }
        if (value instanceof String) {
            return (String) value;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (value instanceof long[]) {
            long[] jArr = (long[]) value;
            while (i < jArr.length) {
                sb.append(jArr[i]);
                i++;
                if (i != jArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        } else if (value instanceof int[]) {
            int[] iArr = (int[]) value;
            while (i < iArr.length) {
                sb.append(iArr[i]);
                i++;
                if (i != iArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        } else if (value instanceof double[]) {
            double[] dArr = (double[]) value;
            while (i < dArr.length) {
                sb.append(dArr[i]);
                i++;
                if (i != dArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        } else if (!(value instanceof LongRational[])) {
            return null;
        } else {
            LongRational[] longRationalArr = (LongRational[]) value;
            while (i < longRationalArr.length) {
                sb.append(longRationalArr[i].getNumerator());
                sb.append('/');
                sb.append(longRationalArr[i].getDenominator());
                i++;
                if (i != longRationalArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
    }

    public int size() {
        return IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
    }
}
