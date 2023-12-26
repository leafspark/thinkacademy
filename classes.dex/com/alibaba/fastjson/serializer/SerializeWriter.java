package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.RyuDouble;
import com.alibaba.fastjson.util.RyuFloat;
import com.amazonaws.services.s3.internal.Constants;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;

public final class SerializeWriter extends Writer {
    private static int BUFFER_THRESHOLD;
    private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
    private static final ThreadLocal<byte[]> bytesBufLocal = new ThreadLocal<>();
    static final int nonDirectFeatures = (((((((((SerializerFeature.UseSingleQuotes.mask | 0) | SerializerFeature.BrowserCompatible.mask) | SerializerFeature.PrettyFormat.mask) | SerializerFeature.WriteEnumUsingToString.mask) | SerializerFeature.WriteNonStringValueAsString.mask) | SerializerFeature.WriteSlashAsSpecial.mask) | SerializerFeature.IgnoreErrorGetter.mask) | SerializerFeature.WriteClassName.mask) | SerializerFeature.NotWriteDefaultValue.mask);
    protected boolean beanToArray;
    protected boolean browserSecure;
    protected char[] buf;
    protected int count;
    protected boolean disableCircularReferenceDetect;
    protected int features;
    protected char keySeperator;
    protected int maxBufSize;
    protected boolean notWriteDefaultValue;
    protected boolean quoteFieldNames;
    protected long sepcialBits;
    protected boolean sortField;
    protected boolean useSingleQuotes;
    protected boolean writeDirect;
    protected boolean writeEnumUsingName;
    protected boolean writeEnumUsingToString;
    protected boolean writeNonStringValueAsString;
    private final Writer writer;

    static {
        int parseInt;
        BUFFER_THRESHOLD = 131072;
        try {
            String stringProperty = IOUtils.getStringProperty("fastjson.serializer_buffer_threshold");
            if (stringProperty != null && stringProperty.length() > 0 && (parseInt = Integer.parseInt(stringProperty)) >= 64 && parseInt <= 65536) {
                BUFFER_THRESHOLD = parseInt * 1024;
            }
        } catch (Throwable unused) {
        }
    }

    public SerializeWriter() {
        this((Writer) null);
    }

    public SerializeWriter(Writer writer2) {
        this(writer2, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this((Writer) null, serializerFeatureArr);
    }

    public SerializeWriter(Writer writer2, SerializerFeature... serializerFeatureArr) {
        this(writer2, 0, serializerFeatureArr);
    }

    public SerializeWriter(Writer writer2, int i, SerializerFeature... serializerFeatureArr) {
        this.maxBufSize = -1;
        this.writer = writer2;
        ThreadLocal<char[]> threadLocal = bufLocal;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set((Object) null);
        } else {
            this.buf = new char[2048];
        }
        for (SerializerFeature mask : serializerFeatureArr) {
            i |= mask.getMask();
        }
        this.features = i;
        computeFeatures();
    }

    public int getMaxBufSize() {
        return this.maxBufSize;
    }

    public void setMaxBufSize(int i) {
        if (i >= this.buf.length) {
            this.maxBufSize = i;
            return;
        }
        throw new JSONException("must > " + this.buf.length);
    }

    public int getBufferLength() {
        return this.buf.length;
    }

    public SerializeWriter(int i) {
        this((Writer) null, i);
    }

    public SerializeWriter(Writer writer2, int i) {
        this.maxBufSize = -1;
        this.writer = writer2;
        if (i > 0) {
            this.buf = new char[i];
            computeFeatures();
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i);
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        if (z) {
            this.features |= serializerFeature.getMask();
            if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
                this.features &= ~SerializerFeature.WriteEnumUsingName.getMask();
            } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                this.features &= ~SerializerFeature.WriteEnumUsingToString.getMask();
            }
        } else {
            this.features = (~serializerFeature.getMask()) & this.features;
        }
        computeFeatures();
    }

    /* access modifiers changed from: protected */
    public void computeFeatures() {
        boolean z = true;
        this.quoteFieldNames = (this.features & SerializerFeature.QuoteFieldNames.mask) != 0;
        this.useSingleQuotes = (this.features & SerializerFeature.UseSingleQuotes.mask) != 0;
        this.sortField = (this.features & SerializerFeature.SortField.mask) != 0;
        this.disableCircularReferenceDetect = (this.features & SerializerFeature.DisableCircularReferenceDetect.mask) != 0;
        this.beanToArray = (this.features & SerializerFeature.BeanToArray.mask) != 0;
        this.writeNonStringValueAsString = (this.features & SerializerFeature.WriteNonStringValueAsString.mask) != 0;
        this.notWriteDefaultValue = (this.features & SerializerFeature.NotWriteDefaultValue.mask) != 0;
        this.writeEnumUsingName = (this.features & SerializerFeature.WriteEnumUsingName.mask) != 0;
        this.writeEnumUsingToString = (this.features & SerializerFeature.WriteEnumUsingToString.mask) != 0;
        this.writeDirect = this.quoteFieldNames && (this.features & nonDirectFeatures) == 0 && (this.beanToArray || this.writeEnumUsingName);
        this.keySeperator = this.useSingleQuotes ? '\'' : '\"';
        if ((this.features & SerializerFeature.BrowserSecure.mask) == 0) {
            z = false;
        }
        this.browserSecure = z;
        this.sepcialBits = z ? 5764610843043954687L : (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0 ? 140758963191807L : 21474836479L;
    }

    public boolean isSortField() {
        return this.sortField;
    }

    public boolean isNotWriteDefaultValue() {
        return this.notWriteDefaultValue;
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.features) != 0;
    }

    public boolean isEnabled(int i) {
        return (i & this.features) != 0;
    }

    public void write(int i) {
        int i2 = 1;
        int i3 = this.count + 1;
        if (i3 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i3);
            } else {
                flush();
                this.buf[this.count] = (char) i;
                this.count = i2;
            }
        }
        i2 = i3;
        this.buf[this.count] = (char) i;
        this.count = i2;
    }

    public void write(char[] cArr, int i, int i2) {
        int i3;
        if (i < 0 || i > cArr.length || i2 < 0 || (i3 = i + i2) > cArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 != 0) {
            int i4 = this.count + i2;
            if (i4 > this.buf.length) {
                if (this.writer == null) {
                    expandCapacity(i4);
                } else {
                    do {
                        char[] cArr2 = this.buf;
                        int length = cArr2.length;
                        int i5 = this.count;
                        int i6 = length - i5;
                        System.arraycopy(cArr, i, cArr2, i5, i6);
                        this.count = this.buf.length;
                        flush();
                        i2 -= i6;
                        i += i6;
                    } while (i2 > this.buf.length);
                    i4 = i2;
                }
            }
            System.arraycopy(cArr, i, this.buf, this.count, i2);
            this.count = i4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0045, code lost:
        r0 = bufLocal;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void expandCapacity(int r4) {
        /*
            r3 = this;
            int r0 = r3.maxBufSize
            r1 = -1
            if (r0 == r1) goto L_0x0029
            if (r4 >= r0) goto L_0x0008
            goto L_0x0029
        L_0x0008:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "serialize exceeded MAX_OUTPUT_LENGTH="
            r1.append(r2)
            int r2 = r3.maxBufSize
            r1.append(r2)
            java.lang.String r2 = ", minimumCapacity="
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        L_0x0029:
            char[] r0 = r3.buf
            int r1 = r0.length
            int r2 = r0.length
            int r2 = r2 >> 1
            int r1 = r1 + r2
            int r1 = r1 + 1
            if (r1 >= r4) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r4 = r1
        L_0x0036:
            char[] r4 = new char[r4]
            int r1 = r3.count
            r2 = 0
            java.lang.System.arraycopy(r0, r2, r4, r2, r1)
            char[] r0 = r3.buf
            int r0 = r0.length
            int r1 = BUFFER_THRESHOLD
            if (r0 >= r1) goto L_0x005a
            java.lang.ThreadLocal<char[]> r0 = bufLocal
            java.lang.Object r1 = r0.get()
            char[] r1 = (char[]) r1
            if (r1 == 0) goto L_0x0055
            int r1 = r1.length
            char[] r2 = r3.buf
            int r2 = r2.length
            if (r1 >= r2) goto L_0x005a
        L_0x0055:
            char[] r1 = r3.buf
            r0.set(r1)
        L_0x005a:
            r3.buf = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.expandCapacity(int):void");
    }

    public SerializeWriter append(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "null" : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public SerializeWriter append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String charSequence2 = charSequence.subSequence(i, i2).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public SerializeWriter append(char c) {
        write((int) c);
        return this;
    }

    public void write(String str, int i, int i2) {
        int i3;
        int i4 = this.count + i2;
        if (i4 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i4);
            } else {
                while (true) {
                    char[] cArr = this.buf;
                    int length = cArr.length;
                    int i5 = this.count;
                    int i6 = length - i5;
                    i3 = i + i6;
                    str.getChars(i, i3, cArr, i5);
                    this.count = this.buf.length;
                    flush();
                    i2 -= i6;
                    if (i2 <= this.buf.length) {
                        break;
                    }
                    i = i3;
                }
                i4 = i2;
                i = i3;
            }
        }
        str.getChars(i, i2 + i, this.buf, this.count);
        this.count = i4;
    }

    public void writeTo(Writer writer2) throws IOException {
        if (this.writer == null) {
            writer2.write(this.buf, 0, this.count);
            return;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        writeTo(outputStream, Charset.forName(str));
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        writeToEx(outputStream, charset);
    }

    public int writeToEx(OutputStream outputStream, Charset charset) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        } else if (charset == IOUtils.UTF8) {
            return encodeToUTF8(outputStream);
        } else {
            byte[] bytes = new String(this.buf, 0, this.count).getBytes(charset);
            outputStream.write(bytes);
            return bytes.length;
        }
    }

    public char[] toCharArray() {
        if (this.writer == null) {
            int i = this.count;
            char[] cArr = new char[i];
            System.arraycopy(this.buf, 0, cArr, 0, i);
            return cArr;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public char[] toCharArrayForSpringWebSocket() {
        if (this.writer == null) {
            int i = this.count;
            char[] cArr = new char[(i - 2)];
            System.arraycopy(this.buf, 1, cArr, 0, i - 2);
            return cArr;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public byte[] toBytes(String str) {
        Charset charset;
        if (str == null || Constants.DEFAULT_ENCODING.equals(str)) {
            charset = IOUtils.UTF8;
        } else {
            charset = Charset.forName(str);
        }
        return toBytes(charset);
    }

    public byte[] toBytes(Charset charset) {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        } else if (charset == IOUtils.UTF8) {
            return encodeToUTF8Bytes();
        } else {
            return new String(this.buf, 0, this.count).getBytes(charset);
        }
    }

    private int encodeToUTF8(OutputStream outputStream) throws IOException {
        int i = (int) (((double) this.count) * 3.0d);
        ThreadLocal<byte[]> threadLocal = bytesBufLocal;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        int encodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr);
        outputStream.write(bArr, 0, encodeUTF8);
        return encodeUTF8;
    }

    private byte[] encodeToUTF8Bytes() {
        int i = (int) (((double) this.count) * 3.0d);
        ThreadLocal<byte[]> threadLocal = bytesBufLocal;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        int encodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr);
        byte[] bArr2 = new byte[encodeUTF8];
        System.arraycopy(bArr, 0, bArr2, 0, encodeUTF8);
        return bArr2;
    }

    public int size() {
        return this.count;
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        char[] cArr = this.buf;
        if (cArr.length <= BUFFER_THRESHOLD) {
            bufLocal.set(cArr);
        }
        this.buf = null;
    }

    public void write(String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
    }

    public void writeInt(int i) {
        if (i == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int stringSize = i < 0 ? IOUtils.stringSize(-i) + 1 : IOUtils.stringSize(i);
        int i2 = this.count + stringSize;
        if (i2 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i2);
            } else {
                char[] cArr = new char[stringSize];
                IOUtils.getChars(i, stringSize, cArr);
                write(cArr, 0, stringSize);
                return;
            }
        }
        IOUtils.getChars(i, i2, this.buf);
        this.count = i2;
    }

    public void writeByteArray(byte[] bArr) {
        byte[] bArr2 = bArr;
        if (isEnabled(SerializerFeature.WriteClassName.mask)) {
            writeHex(bArr);
            return;
        }
        int length = bArr2.length;
        boolean z = this.useSingleQuotes;
        char c = z ? '\'' : '\"';
        if (length == 0) {
            write(z ? "''" : "\"\"");
            return;
        }
        char[] cArr = IOUtils.CA;
        int i = (length / 3) * 3;
        int i2 = length - 1;
        int i3 = this.count;
        int i4 = (((i2 / 3) + 1) << 2) + i3 + 2;
        int i5 = 0;
        if (i4 > this.buf.length) {
            if (this.writer != null) {
                write((int) c);
                int i6 = 0;
                while (i6 < i) {
                    int i7 = i6 + 1;
                    int i8 = i7 + 1;
                    byte b = ((bArr2[i6] & 255) << 16) | ((bArr2[i7] & 255) << 8) | (bArr2[i8] & 255);
                    write((int) cArr[(b >>> 18) & 63]);
                    write((int) cArr[(b >>> 12) & 63]);
                    write((int) cArr[(b >>> 6) & 63]);
                    write((int) cArr[b & 63]);
                    i6 = i8 + 1;
                }
                int i9 = length - i;
                if (i9 > 0) {
                    int i10 = (bArr2[i] & 255) << 10;
                    if (i9 == 2) {
                        i5 = (bArr2[i2] & 255) << 2;
                    }
                    int i11 = i10 | i5;
                    write((int) cArr[i11 >> 12]);
                    write((int) cArr[(i11 >>> 6) & 63]);
                    write((int) i9 == 2 ? cArr[i11 & 63] : '=');
                    write(61);
                }
                write((int) c);
                return;
            }
            expandCapacity(i4);
        }
        this.count = i4;
        int i12 = i3 + 1;
        this.buf[i3] = c;
        int i13 = 0;
        while (i13 < i) {
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            byte b2 = ((bArr2[i13] & 255) << 16) | ((bArr2[i14] & 255) << 8);
            int i16 = i15 + 1;
            byte b3 = b2 | (bArr2[i15] & 255);
            char[] cArr2 = this.buf;
            int i17 = i12 + 1;
            cArr2[i12] = cArr[(b3 >>> 18) & 63];
            int i18 = i17 + 1;
            cArr2[i17] = cArr[(b3 >>> 12) & 63];
            int i19 = i18 + 1;
            cArr2[i18] = cArr[(b3 >>> 6) & 63];
            i12 = i19 + 1;
            cArr2[i19] = cArr[b3 & 63];
            i13 = i16;
        }
        int i20 = length - i;
        if (i20 > 0) {
            int i21 = (bArr2[i] & 255) << 10;
            if (i20 == 2) {
                i5 = (bArr2[i2] & 255) << 2;
            }
            int i22 = i21 | i5;
            char[] cArr3 = this.buf;
            cArr3[i4 - 5] = cArr[i22 >> 12];
            cArr3[i4 - 4] = cArr[(i22 >>> 6) & 63];
            cArr3[i4 - 3] = i20 == 2 ? cArr[i22 & 63] : '=';
            cArr3[i4 - 2] = '=';
        }
        this.buf[i4 - 1] = c;
    }

    public void writeHex(byte[] bArr) {
        int i = 2;
        int length = this.count + (bArr.length * 2) + 3;
        int i2 = 0;
        if (length > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[((bArr.length * 2) + 3)];
                cArr[0] = 'x';
                cArr[1] = '\'';
                while (i2 < bArr.length) {
                    byte b = bArr[i2] & 255;
                    int i3 = b >> 4;
                    byte b2 = b & 15;
                    int i4 = i + 1;
                    cArr[i] = (char) (i3 + (i3 < 10 ? 48 : 55));
                    i = i4 + 1;
                    cArr[i4] = (char) (b2 + (b2 < 10 ? (byte) 48 : 55));
                    i2++;
                }
                cArr[i] = '\'';
                try {
                    this.writer.write(cArr);
                    return;
                } catch (IOException e) {
                    throw new JSONException("writeBytes error.", e);
                }
            } else {
                expandCapacity(length);
            }
        }
        char[] cArr2 = this.buf;
        int i5 = this.count;
        int i6 = i5 + 1;
        this.count = i6;
        cArr2[i5] = 'x';
        this.count = i6 + 1;
        cArr2[i6] = '\'';
        while (i2 < bArr.length) {
            byte b3 = bArr[i2] & 255;
            int i7 = b3 >> 4;
            byte b4 = b3 & 15;
            char[] cArr3 = this.buf;
            int i8 = this.count;
            int i9 = i8 + 1;
            this.count = i9;
            cArr3[i8] = (char) (i7 + (i7 < 10 ? 48 : 55));
            this.count = i9 + 1;
            cArr3[i9] = (char) (b4 + (b4 < 10 ? (byte) 48 : 55));
            i2++;
        }
        char[] cArr4 = this.buf;
        int i10 = this.count;
        this.count = i10 + 1;
        cArr4[i10] = '\'';
    }

    public void writeFloat(float f, boolean z) {
        if (f != f || f == Float.POSITIVE_INFINITY || f == Float.NEGATIVE_INFINITY) {
            writeNull();
            return;
        }
        int i = this.count + 15;
        if (i > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i);
            } else {
                String ryuFloat = RyuFloat.toString(f);
                write(ryuFloat, 0, ryuFloat.length());
                if (z && isEnabled(SerializerFeature.WriteClassName)) {
                    write(70);
                    return;
                }
                return;
            }
        }
        this.count += RyuFloat.toString(f, this.buf, this.count);
        if (z && isEnabled(SerializerFeature.WriteClassName)) {
            write(70);
        }
    }

    public void writeDouble(double d, boolean z) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            writeNull();
            return;
        }
        int i = this.count + 24;
        if (i > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i);
            } else {
                String ryuDouble = RyuDouble.toString(d);
                write(ryuDouble, 0, ryuDouble.length());
                if (z && isEnabled(SerializerFeature.WriteClassName)) {
                    write(68);
                    return;
                }
                return;
            }
        }
        this.count += RyuDouble.toString(d, this.buf, this.count);
        if (z && isEnabled(SerializerFeature.WriteClassName)) {
            write(68);
        }
    }

    public void writeEnum(Enum<?> enumR) {
        if (enumR == null) {
            writeNull();
            return;
        }
        String str = null;
        if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
            str = enumR.name();
        } else if (this.writeEnumUsingToString) {
            str = enumR.toString();
        }
        if (str != null) {
            int i = isEnabled(SerializerFeature.UseSingleQuotes) ? 39 : 34;
            write(i);
            write(str);
            write(i);
            return;
        }
        writeInt(enumR.ordinal());
    }

    public void writeLongAndChar(long j, char c) throws IOException {
        writeLong(j);
        write((int) c);
    }

    public void writeLong(long j) {
        boolean z = isEnabled(SerializerFeature.BrowserCompatible) && !isEnabled(SerializerFeature.WriteClassName) && (j > 9007199254740991L || j < -9007199254740991L);
        if (j != Long.MIN_VALUE) {
            int stringSize = j < 0 ? IOUtils.stringSize(-j) + 1 : IOUtils.stringSize(j);
            int i = this.count + stringSize;
            if (z) {
                i += 2;
            }
            if (i > this.buf.length) {
                if (this.writer == null) {
                    expandCapacity(i);
                } else {
                    char[] cArr = new char[stringSize];
                    IOUtils.getChars(j, stringSize, cArr);
                    if (z) {
                        write(34);
                        write(cArr, 0, stringSize);
                        write(34);
                        return;
                    }
                    write(cArr, 0, stringSize);
                    return;
                }
            }
            if (z) {
                char[] cArr2 = this.buf;
                cArr2[this.count] = '\"';
                int i2 = i - 1;
                IOUtils.getChars(j, i2, cArr2);
                this.buf[i2] = '\"';
            } else {
                IOUtils.getChars(j, i, this.buf);
            }
            this.count = i;
        } else if (z) {
            write("\"-9223372036854775808\"");
        } else {
            write("-9223372036854775808");
        }
    }

    public void writeNull() {
        write("null");
    }

    public void writeNull(SerializerFeature serializerFeature) {
        writeNull(0, serializerFeature.mask);
    }

    public void writeNull(int i, int i2) {
        if ((i & i2) == 0 && (this.features & i2) == 0) {
            writeNull();
        } else if (i2 == SerializerFeature.WriteNullListAsEmpty.mask) {
            write("[]");
        } else if (i2 == SerializerFeature.WriteNullStringAsEmpty.mask) {
            writeString("");
        } else if (i2 == SerializerFeature.WriteNullBooleanAsFalse.mask) {
            write("false");
        } else if (i2 == SerializerFeature.WriteNullNumberAsZero.mask) {
            write(48);
        } else {
            writeNull();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0477, code lost:
        if (r4 != '>') goto L_0x04cc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeStringWithDoubleQuote(java.lang.String r23, char r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            if (r1 != 0) goto L_0x0011
            r22.writeNull()
            if (r2 == 0) goto L_0x0010
            r0.write((int) r2)
        L_0x0010:
            return
        L_0x0011:
            int r3 = r23.length()
            int r4 = r0.count
            int r4 = r4 + r3
            int r4 = r4 + 2
            if (r2 == 0) goto L_0x001e
            int r4 = r4 + 1
        L_0x001e:
            char[] r5 = r0.buf
            int r5 = r5.length
            r6 = 62
            r7 = 60
            r8 = 41
            r9 = 40
            r14 = 34
            r15 = 12
            r12 = 8
            r10 = 117(0x75, float:1.64E-43)
            r13 = 92
            r11 = 1
            if (r4 <= r5) goto L_0x017c
            java.io.Writer r5 = r0.writer
            if (r5 == 0) goto L_0x0179
            r0.write((int) r14)
            r3 = 0
        L_0x003e:
            int r4 = r23.length()
            if (r3 >= r4) goto L_0x0170
            char r4 = r1.charAt(r3)
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserSecure
            boolean r5 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r5)
            if (r5 == 0) goto L_0x008a
            if (r4 == r9) goto L_0x0058
            if (r4 == r8) goto L_0x0058
            if (r4 == r7) goto L_0x0058
            if (r4 != r6) goto L_0x008a
        L_0x0058:
            r0.write((int) r13)
            r0.write((int) r10)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r16 = r4 >>> 12
            r16 = r16 & 15
            char r5 = r5[r16]
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r16 = r4 >>> 8
            r16 = r16 & 15
            char r5 = r5[r16]
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r16 = r4 >>> 4
            r16 = r16 & 15
            char r5 = r5[r16]
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r4 = r4 & 15
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x016a
        L_0x008a:
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible
            boolean r5 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r5)
            if (r5 == 0) goto L_0x0110
            if (r4 == r12) goto L_0x0105
            if (r4 == r15) goto L_0x0105
            r5 = 10
            if (r4 == r5) goto L_0x0105
            r5 = 13
            if (r4 == r5) goto L_0x0105
            r5 = 9
            if (r4 == r5) goto L_0x0105
            if (r4 == r14) goto L_0x0105
            r5 = 47
            if (r4 == r5) goto L_0x0105
            if (r4 != r13) goto L_0x00ab
            goto L_0x0105
        L_0x00ab:
            r5 = 32
            if (r4 >= r5) goto L_0x00d0
            r0.write((int) r13)
            r0.write((int) r10)
            r5 = 48
            r0.write((int) r5)
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.ASCII_CHARS
            int r4 = r4 * 2
            char r5 = r5[r4]
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.ASCII_CHARS
            int r4 = r4 + r11
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x016a
        L_0x00d0:
            r5 = 127(0x7f, float:1.78E-43)
            if (r4 < r5) goto L_0x0167
            r0.write((int) r13)
            r0.write((int) r10)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r16 = r4 >>> 12
            r16 = r16 & 15
            char r5 = r5[r16]
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r16 = r4 >>> 8
            r16 = r16 & 15
            char r5 = r5[r16]
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r16 = r4 >>> 4
            r16 = r16 & 15
            char r5 = r5[r16]
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r4 = r4 & 15
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x016a
        L_0x0105:
            r0.write((int) r13)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x016a
        L_0x0110:
            byte[] r5 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r5 = r5.length
            if (r4 >= r5) goto L_0x011b
            byte[] r5 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r5 = r5[r4]
            if (r5 != 0) goto L_0x0127
        L_0x011b:
            r5 = 47
            if (r4 != r5) goto L_0x0167
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial
            boolean r5 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r5)
            if (r5 == 0) goto L_0x0167
        L_0x0127:
            r0.write((int) r13)
            byte[] r5 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r5 = r5[r4]
            r6 = 4
            if (r5 != r6) goto L_0x015f
            r0.write((int) r10)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r4 >>> 12
            r6 = r6 & 15
            char r5 = r5[r6]
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r4 >>> 8
            r6 = r6 & 15
            char r5 = r5[r6]
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r4 >>> 4
            r6 = r6 & 15
            char r5 = r5[r6]
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r4 = r4 & 15
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x016a
        L_0x015f:
            char[] r5 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x016a
        L_0x0167:
            r0.write((int) r4)
        L_0x016a:
            int r3 = r3 + 1
            r6 = 62
            goto L_0x003e
        L_0x0170:
            r0.write((int) r14)
            if (r2 == 0) goto L_0x0178
            r0.write((int) r2)
        L_0x0178:
            return
        L_0x0179:
            r0.expandCapacity(r4)
        L_0x017c:
            int r5 = r0.count
            int r6 = r5 + 1
            int r7 = r6 + r3
            char[] r8 = r0.buf
            r8[r5] = r14
            r5 = 0
            r1.getChars(r5, r3, r8, r6)
            r0.count = r4
            com.alibaba.fastjson.serializer.SerializerFeature r3 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible
            boolean r3 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r3)
            r8 = -1
            if (r3 == 0) goto L_0x02b4
            r1 = r6
        L_0x0196:
            if (r1 >= r7) goto L_0x01c8
            char[] r3 = r0.buf
            char r3 = r3[r1]
            if (r3 == r14) goto L_0x01c2
            r5 = 47
            if (r3 == r5) goto L_0x01c2
            if (r3 != r13) goto L_0x01a5
            goto L_0x01c2
        L_0x01a5:
            if (r3 == r12) goto L_0x01c2
            if (r3 == r15) goto L_0x01c2
            r5 = 10
            if (r3 == r5) goto L_0x01c2
            r5 = 13
            if (r3 == r5) goto L_0x01c2
            r5 = 9
            if (r3 != r5) goto L_0x01b6
            goto L_0x01c2
        L_0x01b6:
            r5 = 32
            if (r3 >= r5) goto L_0x01bd
        L_0x01ba:
            int r4 = r4 + 5
            goto L_0x01c4
        L_0x01bd:
            r5 = 127(0x7f, float:1.78E-43)
            if (r3 < r5) goto L_0x01c5
            goto L_0x01ba
        L_0x01c2:
            int r4 = r4 + 1
        L_0x01c4:
            r8 = r1
        L_0x01c5:
            int r1 = r1 + 1
            goto L_0x0196
        L_0x01c8:
            char[] r1 = r0.buf
            int r1 = r1.length
            if (r4 <= r1) goto L_0x01d0
            r0.expandCapacity(r4)
        L_0x01d0:
            r0.count = r4
        L_0x01d2:
            if (r8 < r6) goto L_0x029e
            char[] r1 = r0.buf
            char r3 = r1[r8]
            if (r3 == r12) goto L_0x0284
            if (r3 == r15) goto L_0x0284
            r4 = 10
            if (r3 == r4) goto L_0x0284
            r4 = 13
            if (r3 == r4) goto L_0x0284
            r4 = 9
            if (r3 != r4) goto L_0x01ea
            goto L_0x0284
        L_0x01ea:
            if (r3 == r14) goto L_0x0273
            r4 = 47
            if (r3 == r4) goto L_0x0273
            if (r3 != r13) goto L_0x01f4
            goto L_0x0273
        L_0x01f4:
            r4 = 32
            if (r3 >= r4) goto L_0x022a
            int r4 = r8 + 1
            int r5 = r8 + 6
            int r9 = r7 - r8
            int r9 = r9 - r11
            java.lang.System.arraycopy(r1, r4, r1, r5, r9)
            char[] r1 = r0.buf
            r1[r8] = r13
            r1[r4] = r10
            int r4 = r8 + 2
            r5 = 48
            r1[r4] = r5
            int r4 = r8 + 3
            r1[r4] = r5
            int r4 = r8 + 4
            char[] r5 = com.alibaba.fastjson.util.IOUtils.ASCII_CHARS
            int r3 = r3 * 2
            char r5 = r5[r3]
            r1[r4] = r5
            char[] r1 = r0.buf
            int r4 = r8 + 5
            char[] r5 = com.alibaba.fastjson.util.IOUtils.ASCII_CHARS
            int r3 = r3 + r11
            char r3 = r5[r3]
            r1[r4] = r3
        L_0x0227:
            int r7 = r7 + 5
            goto L_0x029a
        L_0x022a:
            r4 = 127(0x7f, float:1.78E-43)
            if (r3 < r4) goto L_0x029a
            int r4 = r8 + 1
            int r5 = r8 + 6
            int r9 = r7 - r8
            int r9 = r9 - r11
            java.lang.System.arraycopy(r1, r4, r1, r5, r9)
            char[] r1 = r0.buf
            r1[r8] = r13
            r1[r4] = r10
            int r4 = r8 + 2
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r9 = r3 >>> 12
            r9 = r9 & 15
            char r5 = r5[r9]
            r1[r4] = r5
            char[] r1 = r0.buf
            int r4 = r8 + 3
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r9 = r3 >>> 8
            r9 = r9 & 15
            char r5 = r5[r9]
            r1[r4] = r5
            char[] r1 = r0.buf
            int r4 = r8 + 4
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r9 = r3 >>> 4
            r9 = r9 & 15
            char r5 = r5[r9]
            r1[r4] = r5
            char[] r1 = r0.buf
            int r4 = r8 + 5
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r3 = r3 & 15
            char r3 = r5[r3]
            r1[r4] = r3
            goto L_0x0227
        L_0x0273:
            int r4 = r8 + 1
            int r5 = r8 + 2
            int r9 = r7 - r8
            int r9 = r9 - r11
            java.lang.System.arraycopy(r1, r4, r1, r5, r9)
            char[] r1 = r0.buf
            r1[r8] = r13
            r1[r4] = r3
            goto L_0x0298
        L_0x0284:
            int r4 = r8 + 1
            int r5 = r8 + 2
            int r9 = r7 - r8
            int r9 = r9 - r11
            java.lang.System.arraycopy(r1, r4, r1, r5, r9)
            char[] r1 = r0.buf
            r1[r8] = r13
            char[] r5 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r3 = r5[r3]
            r1[r4] = r3
        L_0x0298:
            int r7 = r7 + 1
        L_0x029a:
            int r8 = r8 + -1
            goto L_0x01d2
        L_0x029e:
            if (r2 == 0) goto L_0x02ac
            char[] r1 = r0.buf
            int r3 = r0.count
            int r4 = r3 + -2
            r1[r4] = r14
            int r3 = r3 - r11
            r1[r3] = r2
            goto L_0x02b3
        L_0x02ac:
            char[] r1 = r0.buf
            int r2 = r0.count
            int r2 = r2 - r11
            r1[r2] = r14
        L_0x02b3:
            return
        L_0x02b4:
            r12 = r5
            r15 = r12
            r3 = r6
            r5 = r8
            r19 = r5
        L_0x02ba:
            r14 = 8232(0x2028, float:1.1535E-41)
            if (r3 >= r7) goto L_0x032a
            char[] r10 = r0.buf
            char r10 = r10[r3]
            r11 = 93
            if (r10 < r11) goto L_0x02df
            r11 = 127(0x7f, float:1.78E-43)
            if (r10 < r11) goto L_0x0322
            if (r10 == r14) goto L_0x02d4
            r14 = 8233(0x2029, float:1.1537E-41)
            if (r10 == r14) goto L_0x02d4
            r14 = 160(0xa0, float:2.24E-43)
            if (r10 >= r14) goto L_0x0322
        L_0x02d4:
            if (r5 != r8) goto L_0x02d7
            r5 = r3
        L_0x02d7:
            int r12 = r12 + 1
            int r4 = r4 + 4
        L_0x02db:
            r19 = r3
        L_0x02dd:
            r15 = r10
            goto L_0x0322
        L_0x02df:
            r11 = 127(0x7f, float:1.78E-43)
            r14 = 64
            if (r10 >= r14) goto L_0x02f3
            long r8 = r0.sepcialBits
            r20 = 1
            long r20 = r20 << r10
            long r8 = r8 & r20
            r20 = 0
            int r8 = (r8 > r20 ? 1 : (r8 == r20 ? 0 : -1))
            if (r8 != 0) goto L_0x02f5
        L_0x02f3:
            if (r10 != r13) goto L_0x02f7
        L_0x02f5:
            r8 = 1
            goto L_0x02f8
        L_0x02f7:
            r8 = 0
        L_0x02f8:
            if (r8 == 0) goto L_0x0321
            int r12 = r12 + 1
            r8 = 40
            if (r10 == r8) goto L_0x0318
            r8 = 41
            if (r10 == r8) goto L_0x0318
            r8 = 60
            if (r10 == r8) goto L_0x0318
            r8 = 62
            if (r10 == r8) goto L_0x0318
            byte[] r8 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r8 = r8.length
            if (r10 >= r8) goto L_0x031a
            byte[] r8 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r8 = r8[r10]
            r9 = 4
            if (r8 != r9) goto L_0x031a
        L_0x0318:
            int r4 = r4 + 4
        L_0x031a:
            r8 = -1
            if (r5 != r8) goto L_0x02db
            r5 = r3
            r19 = r5
            goto L_0x02dd
        L_0x0321:
            r8 = -1
        L_0x0322:
            int r3 = r3 + 1
            r9 = 40
            r10 = 117(0x75, float:1.64E-43)
            r11 = 1
            goto L_0x02ba
        L_0x032a:
            if (r12 <= 0) goto L_0x0591
            int r4 = r4 + r12
            char[] r3 = r0.buf
            int r3 = r3.length
            if (r4 <= r3) goto L_0x0335
            r0.expandCapacity(r4)
        L_0x0335:
            r0.count = r4
            r3 = 1
            if (r12 != r3) goto L_0x0456
            r1 = 50
            if (r15 != r14) goto L_0x0364
            int r4 = r19 + 1
            int r5 = r19 + 6
            int r7 = r7 - r19
            int r7 = r7 - r3
            char[] r6 = r0.buf
            java.lang.System.arraycopy(r6, r4, r6, r5, r7)
            char[] r5 = r0.buf
            r5[r19] = r13
            r6 = 117(0x75, float:1.64E-43)
            r5[r4] = r6
            int r4 = r4 + r3
            r5[r4] = r1
            int r4 = r4 + r3
            r6 = 48
            r5[r4] = r6
            int r4 = r4 + r3
            r5[r4] = r1
            int r4 = r4 + r3
            r1 = 56
            r5[r4] = r1
            goto L_0x0591
        L_0x0364:
            r4 = 8233(0x2029, float:1.1537E-41)
            if (r15 != r4) goto L_0x038e
            int r4 = r19 + 1
            int r5 = r19 + 6
            int r7 = r7 - r19
            int r7 = r7 - r3
            char[] r6 = r0.buf
            java.lang.System.arraycopy(r6, r4, r6, r5, r7)
            char[] r5 = r0.buf
            r5[r19] = r13
            r6 = 117(0x75, float:1.64E-43)
            r5[r4] = r6
            int r4 = r4 + r3
            r5[r4] = r1
            int r4 = r4 + r3
            r6 = 48
            r5[r4] = r6
            int r4 = r4 + r3
            r5[r4] = r1
            int r4 = r4 + r3
            r1 = 57
            r5[r4] = r1
            goto L_0x0591
        L_0x038e:
            r1 = 40
            if (r15 == r1) goto L_0x040f
            r1 = 41
            if (r15 == r1) goto L_0x040f
            r1 = 60
            if (r15 == r1) goto L_0x040f
            r1 = 62
            if (r15 != r1) goto L_0x039f
            goto L_0x040f
        L_0x039f:
            byte[] r1 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r1 = r1.length
            if (r15 >= r1) goto L_0x03f6
            byte[] r1 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r1 = r1[r15]
            r3 = 4
            if (r1 != r3) goto L_0x03f6
            int r1 = r19 + 1
            int r3 = r19 + 6
            int r7 = r7 - r19
            r4 = 1
            int r7 = r7 - r4
            char[] r4 = r0.buf
            java.lang.System.arraycopy(r4, r1, r4, r3, r7)
            char[] r3 = r0.buf
            r3[r19] = r13
            int r4 = r1 + 1
            r5 = 117(0x75, float:1.64E-43)
            r3[r1] = r5
            int r1 = r4 + 1
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r15 >>> 12
            r6 = r6 & 15
            char r5 = r5[r6]
            r3[r4] = r5
            char[] r3 = r0.buf
            int r4 = r1 + 1
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r15 >>> 8
            r6 = r6 & 15
            char r5 = r5[r6]
            r3[r1] = r5
            char[] r1 = r0.buf
            int r3 = r4 + 1
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r15 >>> 4
            r6 = r6 & 15
            char r5 = r5[r6]
            r1[r4] = r5
            char[] r1 = r0.buf
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r5 = r15 & 15
            char r4 = r4[r5]
            r1[r3] = r4
            goto L_0x0591
        L_0x03f6:
            int r1 = r19 + 1
            int r3 = r19 + 2
            int r7 = r7 - r19
            r4 = 1
            int r7 = r7 - r4
            char[] r4 = r0.buf
            java.lang.System.arraycopy(r4, r1, r4, r3, r7)
            char[] r3 = r0.buf
            r3[r19] = r13
            char[] r4 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r4 = r4[r15]
            r3[r1] = r4
            goto L_0x0591
        L_0x040f:
            int r1 = r19 + 1
            int r3 = r19 + 6
            int r7 = r7 - r19
            r4 = 1
            int r7 = r7 - r4
            char[] r5 = r0.buf
            java.lang.System.arraycopy(r5, r1, r5, r3, r7)
            char[] r3 = r0.buf
            r3[r19] = r13
            r5 = 117(0x75, float:1.64E-43)
            r3[r1] = r5
            int r1 = r1 + r4
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r15 >>> 12
            r6 = r6 & 15
            char r5 = r5[r6]
            r3[r1] = r5
            char[] r3 = r0.buf
            int r1 = r1 + r4
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r15 >>> 8
            r6 = r6 & 15
            char r5 = r5[r6]
            r3[r1] = r5
            char[] r3 = r0.buf
            int r1 = r1 + r4
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r15 >>> 4
            r6 = r6 & 15
            char r5 = r5[r6]
            r3[r1] = r5
            char[] r3 = r0.buf
            int r1 = r1 + r4
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r6 = r15 & 15
            char r5 = r5[r6]
            r3[r1] = r5
            goto L_0x0591
        L_0x0456:
            r4 = r3
            if (r12 <= r4) goto L_0x0591
            int r3 = r5 - r6
        L_0x045b:
            int r4 = r23.length()
            if (r3 >= r4) goto L_0x0591
            char r4 = r1.charAt(r3)
            boolean r6 = r0.browserSecure
            if (r6 == 0) goto L_0x04c4
            r6 = 40
            r7 = 41
            r8 = 60
            if (r4 == r6) goto L_0x047a
            if (r4 == r7) goto L_0x047a
            r9 = 62
            if (r4 == r8) goto L_0x047c
            if (r4 != r9) goto L_0x04cc
            goto L_0x047c
        L_0x047a:
            r9 = 62
        L_0x047c:
            char[] r10 = r0.buf
            int r11 = r5 + 1
            r10[r5] = r13
            int r5 = r11 + 1
            r12 = 117(0x75, float:1.64E-43)
            r10[r11] = r12
            int r11 = r5 + 1
            char[] r12 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r15 = r4 >>> 12
            r15 = r15 & 15
            char r12 = r12[r15]
            r10[r5] = r12
            char[] r5 = r0.buf
            int r10 = r11 + 1
            char[] r12 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r15 = r4 >>> 8
            r15 = r15 & 15
            char r12 = r12[r15]
            r5[r11] = r12
            char[] r5 = r0.buf
            int r11 = r10 + 1
            char[] r12 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r15 = r4 >>> 4
            r15 = r15 & 15
            char r12 = r12[r15]
            r5[r10] = r12
            char[] r5 = r0.buf
            int r10 = r11 + 1
            char[] r12 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r4 = r4 & 15
            char r4 = r12[r4]
            r5[r11] = r4
            r5 = r10
            r10 = 47
            r11 = 4
        L_0x04c0:
            r16 = 117(0x75, float:1.64E-43)
            goto L_0x058d
        L_0x04c4:
            r6 = 40
            r7 = 41
            r8 = 60
            r9 = 62
        L_0x04cc:
            byte[] r10 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r10 = r10.length
            if (r4 >= r10) goto L_0x04db
            byte[] r10 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r10 = r10[r4]
            if (r10 != 0) goto L_0x04d8
            goto L_0x04db
        L_0x04d8:
            r10 = 47
            goto L_0x04e7
        L_0x04db:
            r10 = 47
            if (r4 != r10) goto L_0x053d
            com.alibaba.fastjson.serializer.SerializerFeature r11 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial
            boolean r11 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r11)
            if (r11 == 0) goto L_0x053d
        L_0x04e7:
            char[] r11 = r0.buf
            int r12 = r5 + 1
            r11[r5] = r13
            byte[] r5 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r5 = r5[r4]
            r11 = 4
            if (r5 != r11) goto L_0x0531
            char[] r5 = r0.buf
            int r15 = r12 + 1
            r16 = 117(0x75, float:1.64E-43)
            r5[r12] = r16
            int r12 = r15 + 1
            char[] r16 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r17 = r4 >>> 12
            r17 = r17 & 15
            char r16 = r16[r17]
            r5[r15] = r16
            char[] r5 = r0.buf
            int r15 = r12 + 1
            char[] r16 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r17 = r4 >>> 8
            r17 = r17 & 15
            char r16 = r16[r17]
            r5[r12] = r16
            char[] r5 = r0.buf
            int r12 = r15 + 1
            char[] r16 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r17 = r4 >>> 4
            r17 = r17 & 15
            char r16 = r16[r17]
            r5[r15] = r16
            char[] r5 = r0.buf
            int r15 = r12 + 1
            char[] r16 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r4 = r4 & 15
            char r4 = r16[r4]
            r5[r12] = r4
            goto L_0x053b
        L_0x0531:
            char[] r5 = r0.buf
            int r15 = r12 + 1
            char[] r16 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r4 = r16[r4]
            r5[r12] = r4
        L_0x053b:
            r5 = r15
            goto L_0x04c0
        L_0x053d:
            r11 = 4
            if (r4 == r14) goto L_0x054c
            r12 = 8233(0x2029, float:1.1537E-41)
            if (r4 != r12) goto L_0x0545
            goto L_0x054c
        L_0x0545:
            char[] r12 = r0.buf
            int r15 = r5 + 1
            r12[r5] = r4
            goto L_0x053b
        L_0x054c:
            char[] r12 = r0.buf
            int r15 = r5 + 1
            r12[r5] = r13
            int r5 = r15 + 1
            r16 = 117(0x75, float:1.64E-43)
            r12[r15] = r16
            int r15 = r5 + 1
            char[] r17 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r18 = r4 >>> 12
            r18 = r18 & 15
            char r17 = r17[r18]
            r12[r5] = r17
            char[] r5 = r0.buf
            int r12 = r15 + 1
            char[] r17 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r18 = r4 >>> 8
            r18 = r18 & 15
            char r17 = r17[r18]
            r5[r15] = r17
            char[] r5 = r0.buf
            int r15 = r12 + 1
            char[] r17 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r18 = r4 >>> 4
            r18 = r18 & 15
            char r17 = r17[r18]
            r5[r12] = r17
            char[] r5 = r0.buf
            int r12 = r15 + 1
            char[] r17 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r4 = r4 & 15
            char r4 = r17[r4]
            r5[r15] = r4
            r5 = r12
        L_0x058d:
            int r3 = r3 + 1
            goto L_0x045b
        L_0x0591:
            if (r2 == 0) goto L_0x05a2
            char[] r1 = r0.buf
            int r3 = r0.count
            int r4 = r3 + -2
            r5 = 34
            r1[r4] = r5
            r4 = 1
            int r3 = r3 - r4
            r1[r3] = r2
            goto L_0x05ac
        L_0x05a2:
            r4 = 1
            r5 = 34
            char[] r1 = r0.buf
            int r2 = r0.count
            int r2 = r2 - r4
            r1[r2] = r5
        L_0x05ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeStringWithDoubleQuote(java.lang.String, char):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0478, code lost:
        if (r3 != '>') goto L_0x04cb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeStringWithDoubleQuote(char[] r25, char r26) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            if (r1 != 0) goto L_0x0011
            r24.writeNull()
            if (r2 == 0) goto L_0x0010
            r0.write((int) r2)
        L_0x0010:
            return
        L_0x0011:
            int r3 = r1.length
            int r4 = r0.count
            int r4 = r4 + r3
            int r4 = r4 + 2
            if (r2 == 0) goto L_0x001b
            int r4 = r4 + 1
        L_0x001b:
            char[] r5 = r0.buf
            int r5 = r5.length
            r6 = 62
            r7 = 60
            r8 = 41
            r9 = 40
            r14 = 34
            r15 = 12
            r12 = 8
            r10 = 117(0x75, float:1.64E-43)
            r13 = 92
            r11 = 1
            if (r4 <= r5) goto L_0x0174
            java.io.Writer r5 = r0.writer
            if (r5 == 0) goto L_0x0171
            r0.write((int) r14)
            r3 = 0
        L_0x003b:
            int r4 = r1.length
            if (r3 >= r4) goto L_0x0168
            char r4 = r1[r3]
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserSecure
            boolean r5 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r5)
            if (r5 == 0) goto L_0x0082
            if (r4 == r9) goto L_0x0050
            if (r4 == r8) goto L_0x0050
            if (r4 == r7) goto L_0x0050
            if (r4 != r6) goto L_0x0082
        L_0x0050:
            r0.write((int) r13)
            r0.write((int) r10)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r16 = r4 >>> 12
            r16 = r16 & 15
            char r5 = r5[r16]
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r16 = r4 >>> 8
            r16 = r16 & 15
            char r5 = r5[r16]
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r16 = r4 >>> 4
            r16 = r16 & 15
            char r5 = r5[r16]
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r4 = r4 & 15
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x0162
        L_0x0082:
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible
            boolean r5 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r5)
            if (r5 == 0) goto L_0x0108
            if (r4 == r12) goto L_0x00fd
            if (r4 == r15) goto L_0x00fd
            r5 = 10
            if (r4 == r5) goto L_0x00fd
            r5 = 13
            if (r4 == r5) goto L_0x00fd
            r5 = 9
            if (r4 == r5) goto L_0x00fd
            if (r4 == r14) goto L_0x00fd
            r5 = 47
            if (r4 == r5) goto L_0x00fd
            if (r4 != r13) goto L_0x00a3
            goto L_0x00fd
        L_0x00a3:
            r5 = 32
            if (r4 >= r5) goto L_0x00c8
            r0.write((int) r13)
            r0.write((int) r10)
            r5 = 48
            r0.write((int) r5)
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.ASCII_CHARS
            int r4 = r4 * 2
            char r5 = r5[r4]
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.ASCII_CHARS
            int r4 = r4 + r11
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x0162
        L_0x00c8:
            r5 = 127(0x7f, float:1.78E-43)
            if (r4 < r5) goto L_0x015f
            r0.write((int) r13)
            r0.write((int) r10)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r16 = r4 >>> 12
            r16 = r16 & 15
            char r5 = r5[r16]
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r16 = r4 >>> 8
            r16 = r16 & 15
            char r5 = r5[r16]
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r16 = r4 >>> 4
            r16 = r16 & 15
            char r5 = r5[r16]
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r4 = r4 & 15
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x0162
        L_0x00fd:
            r0.write((int) r13)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x0162
        L_0x0108:
            byte[] r5 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r5 = r5.length
            if (r4 >= r5) goto L_0x0113
            byte[] r5 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r5 = r5[r4]
            if (r5 != 0) goto L_0x011f
        L_0x0113:
            r5 = 47
            if (r4 != r5) goto L_0x015f
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial
            boolean r5 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r5)
            if (r5 == 0) goto L_0x015f
        L_0x011f:
            r0.write((int) r13)
            byte[] r5 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r5 = r5[r4]
            r6 = 4
            if (r5 != r6) goto L_0x0157
            r0.write((int) r10)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r4 >>> 12
            r6 = r6 & 15
            char r5 = r5[r6]
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r4 >>> 8
            r6 = r6 & 15
            char r5 = r5[r6]
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r4 >>> 4
            r6 = r6 & 15
            char r5 = r5[r6]
            r0.write((int) r5)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r4 = r4 & 15
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x0162
        L_0x0157:
            char[] r5 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x0162
        L_0x015f:
            r0.write((int) r4)
        L_0x0162:
            int r3 = r3 + 1
            r6 = 62
            goto L_0x003b
        L_0x0168:
            r0.write((int) r14)
            if (r2 == 0) goto L_0x0170
            r0.write((int) r2)
        L_0x0170:
            return
        L_0x0171:
            r0.expandCapacity(r4)
        L_0x0174:
            int r5 = r0.count
            int r6 = r5 + 1
            int r3 = r3 + r6
            char[] r7 = r0.buf
            r7[r5] = r14
            int r5 = r1.length
            r8 = 0
            java.lang.System.arraycopy(r1, r8, r7, r6, r5)
            r0.count = r4
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible
            boolean r5 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r5)
            r7 = -1
            if (r5 == 0) goto L_0x02ac
            r1 = r6
        L_0x018e:
            if (r1 >= r3) goto L_0x01c0
            char[] r5 = r0.buf
            char r5 = r5[r1]
            if (r5 == r14) goto L_0x01ba
            r8 = 47
            if (r5 == r8) goto L_0x01ba
            if (r5 != r13) goto L_0x019d
            goto L_0x01ba
        L_0x019d:
            if (r5 == r12) goto L_0x01ba
            if (r5 == r15) goto L_0x01ba
            r8 = 10
            if (r5 == r8) goto L_0x01ba
            r8 = 13
            if (r5 == r8) goto L_0x01ba
            r8 = 9
            if (r5 != r8) goto L_0x01ae
            goto L_0x01ba
        L_0x01ae:
            r8 = 32
            if (r5 >= r8) goto L_0x01b5
        L_0x01b2:
            int r4 = r4 + 5
            goto L_0x01bc
        L_0x01b5:
            r8 = 127(0x7f, float:1.78E-43)
            if (r5 < r8) goto L_0x01bd
            goto L_0x01b2
        L_0x01ba:
            int r4 = r4 + 1
        L_0x01bc:
            r7 = r1
        L_0x01bd:
            int r1 = r1 + 1
            goto L_0x018e
        L_0x01c0:
            char[] r1 = r0.buf
            int r1 = r1.length
            if (r4 <= r1) goto L_0x01c8
            r0.expandCapacity(r4)
        L_0x01c8:
            r0.count = r4
        L_0x01ca:
            if (r7 < r6) goto L_0x0296
            char[] r1 = r0.buf
            char r4 = r1[r7]
            if (r4 == r12) goto L_0x027c
            if (r4 == r15) goto L_0x027c
            r5 = 10
            if (r4 == r5) goto L_0x027c
            r5 = 13
            if (r4 == r5) goto L_0x027c
            r5 = 9
            if (r4 != r5) goto L_0x01e2
            goto L_0x027c
        L_0x01e2:
            if (r4 == r14) goto L_0x026b
            r5 = 47
            if (r4 == r5) goto L_0x026b
            if (r4 != r13) goto L_0x01ec
            goto L_0x026b
        L_0x01ec:
            r5 = 32
            if (r4 >= r5) goto L_0x0222
            int r5 = r7 + 1
            int r8 = r7 + 6
            int r9 = r3 - r7
            int r9 = r9 - r11
            java.lang.System.arraycopy(r1, r5, r1, r8, r9)
            char[] r1 = r0.buf
            r1[r7] = r13
            r1[r5] = r10
            int r5 = r7 + 2
            r8 = 48
            r1[r5] = r8
            int r5 = r7 + 3
            r1[r5] = r8
            int r5 = r7 + 4
            char[] r8 = com.alibaba.fastjson.util.IOUtils.ASCII_CHARS
            int r4 = r4 * 2
            char r8 = r8[r4]
            r1[r5] = r8
            char[] r1 = r0.buf
            int r5 = r7 + 5
            char[] r8 = com.alibaba.fastjson.util.IOUtils.ASCII_CHARS
            int r4 = r4 + r11
            char r4 = r8[r4]
            r1[r5] = r4
        L_0x021f:
            int r3 = r3 + 5
            goto L_0x0292
        L_0x0222:
            r5 = 127(0x7f, float:1.78E-43)
            if (r4 < r5) goto L_0x0292
            int r5 = r7 + 1
            int r8 = r7 + 6
            int r9 = r3 - r7
            int r9 = r9 - r11
            java.lang.System.arraycopy(r1, r5, r1, r8, r9)
            char[] r1 = r0.buf
            r1[r7] = r13
            r1[r5] = r10
            int r5 = r7 + 2
            char[] r8 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r9 = r4 >>> 12
            r9 = r9 & 15
            char r8 = r8[r9]
            r1[r5] = r8
            char[] r1 = r0.buf
            int r5 = r7 + 3
            char[] r8 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r9 = r4 >>> 8
            r9 = r9 & 15
            char r8 = r8[r9]
            r1[r5] = r8
            char[] r1 = r0.buf
            int r5 = r7 + 4
            char[] r8 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r9 = r4 >>> 4
            r9 = r9 & 15
            char r8 = r8[r9]
            r1[r5] = r8
            char[] r1 = r0.buf
            int r5 = r7 + 5
            char[] r8 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r4 = r4 & 15
            char r4 = r8[r4]
            r1[r5] = r4
            goto L_0x021f
        L_0x026b:
            int r5 = r7 + 1
            int r8 = r7 + 2
            int r9 = r3 - r7
            int r9 = r9 - r11
            java.lang.System.arraycopy(r1, r5, r1, r8, r9)
            char[] r1 = r0.buf
            r1[r7] = r13
            r1[r5] = r4
            goto L_0x0290
        L_0x027c:
            int r5 = r7 + 1
            int r8 = r7 + 2
            int r9 = r3 - r7
            int r9 = r9 - r11
            java.lang.System.arraycopy(r1, r5, r1, r8, r9)
            char[] r1 = r0.buf
            r1[r7] = r13
            char[] r8 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r4 = r8[r4]
            r1[r5] = r4
        L_0x0290:
            int r3 = r3 + 1
        L_0x0292:
            int r7 = r7 + -1
            goto L_0x01ca
        L_0x0296:
            if (r2 == 0) goto L_0x02a4
            char[] r1 = r0.buf
            int r3 = r0.count
            int r4 = r3 + -2
            r1[r4] = r14
            int r3 = r3 - r11
            r1[r3] = r2
            goto L_0x02ab
        L_0x02a4:
            char[] r1 = r0.buf
            int r2 = r0.count
            int r2 = r2 - r11
            r1[r2] = r14
        L_0x02ab:
            return
        L_0x02ac:
            r5 = r6
            r19 = r7
            r12 = r8
            r15 = r12
            r8 = r19
        L_0x02b3:
            r14 = 8232(0x2028, float:1.1535E-41)
            if (r5 >= r3) goto L_0x0333
            char[] r10 = r0.buf
            char r10 = r10[r5]
            r11 = 93
            if (r10 < r11) goto L_0x02dd
            r11 = 127(0x7f, float:1.78E-43)
            if (r10 < r11) goto L_0x02d7
            if (r10 == r14) goto L_0x02cd
            r14 = 8233(0x2029, float:1.1537E-41)
            if (r10 == r14) goto L_0x02cd
            r14 = 160(0xa0, float:2.24E-43)
            if (r10 >= r14) goto L_0x02d7
        L_0x02cd:
            if (r8 != r7) goto L_0x02d0
            r8 = r5
        L_0x02d0:
            int r12 = r12 + 1
            int r4 = r4 + 4
            r19 = r5
            r15 = r10
        L_0x02d7:
            r23 = r8
            r8 = r7
            r7 = r23
            goto L_0x0328
        L_0x02dd:
            r11 = 127(0x7f, float:1.78E-43)
            r14 = 64
            r20 = r8
            if (r10 >= r14) goto L_0x02f3
            long r7 = r0.sepcialBits
            r21 = 1
            long r21 = r21 << r10
            long r7 = r7 & r21
            r21 = 0
            int r7 = (r7 > r21 ? 1 : (r7 == r21 ? 0 : -1))
            if (r7 != 0) goto L_0x02f5
        L_0x02f3:
            if (r10 != r13) goto L_0x02f7
        L_0x02f5:
            r7 = 1
            goto L_0x02f8
        L_0x02f7:
            r7 = 0
        L_0x02f8:
            if (r7 == 0) goto L_0x0325
            int r12 = r12 + 1
            if (r10 == r9) goto L_0x0316
            r7 = 41
            if (r10 == r7) goto L_0x0316
            r7 = 60
            if (r10 == r7) goto L_0x0316
            r7 = 62
            if (r10 == r7) goto L_0x0316
            byte[] r7 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r7 = r7.length
            if (r10 >= r7) goto L_0x0318
            byte[] r7 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r7 = r7[r10]
            r8 = 4
            if (r7 != r8) goto L_0x0318
        L_0x0316:
            int r4 = r4 + 4
        L_0x0318:
            r7 = r20
            r8 = -1
            if (r7 != r8) goto L_0x0321
            r7 = r5
            r19 = r7
            goto L_0x0323
        L_0x0321:
            r19 = r5
        L_0x0323:
            r15 = r10
            goto L_0x0328
        L_0x0325:
            r7 = r20
            r8 = -1
        L_0x0328:
            int r5 = r5 + 1
            r10 = 117(0x75, float:1.64E-43)
            r11 = 1
            r23 = r8
            r8 = r7
            r7 = r23
            goto L_0x02b3
        L_0x0333:
            r7 = r8
            if (r12 <= 0) goto L_0x0590
            int r4 = r4 + r12
            char[] r5 = r0.buf
            int r5 = r5.length
            if (r4 <= r5) goto L_0x033f
            r0.expandCapacity(r4)
        L_0x033f:
            r0.count = r4
            r4 = 1
            if (r12 != r4) goto L_0x045e
            r1 = 50
            if (r15 != r14) goto L_0x036e
            int r5 = r19 + 1
            int r6 = r19 + 6
            int r3 = r3 - r19
            int r3 = r3 - r4
            char[] r7 = r0.buf
            java.lang.System.arraycopy(r7, r5, r7, r6, r3)
            char[] r3 = r0.buf
            r3[r19] = r13
            r6 = 117(0x75, float:1.64E-43)
            r3[r5] = r6
            int r5 = r5 + r4
            r3[r5] = r1
            int r5 = r5 + r4
            r6 = 48
            r3[r5] = r6
            int r5 = r5 + r4
            r3[r5] = r1
            int r5 = r5 + r4
            r1 = 56
            r3[r5] = r1
            goto L_0x0590
        L_0x036e:
            r5 = 8233(0x2029, float:1.1537E-41)
            if (r15 != r5) goto L_0x0398
            int r5 = r19 + 1
            int r6 = r19 + 6
            int r3 = r3 - r19
            int r3 = r3 - r4
            char[] r7 = r0.buf
            java.lang.System.arraycopy(r7, r5, r7, r6, r3)
            char[] r3 = r0.buf
            r3[r19] = r13
            r6 = 117(0x75, float:1.64E-43)
            r3[r5] = r6
            int r5 = r5 + r4
            r3[r5] = r1
            int r5 = r5 + r4
            r6 = 48
            r3[r5] = r6
            int r5 = r5 + r4
            r3[r5] = r1
            int r5 = r5 + r4
            r1 = 57
            r3[r5] = r1
            goto L_0x0590
        L_0x0398:
            if (r15 == r9) goto L_0x0417
            r1 = 41
            if (r15 == r1) goto L_0x0417
            r1 = 60
            if (r15 == r1) goto L_0x0417
            r1 = 62
            if (r15 != r1) goto L_0x03a7
            goto L_0x0417
        L_0x03a7:
            byte[] r1 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r1 = r1.length
            if (r15 >= r1) goto L_0x03fe
            byte[] r1 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r1 = r1[r15]
            r4 = 4
            if (r1 != r4) goto L_0x03fe
            int r1 = r19 + 1
            int r4 = r19 + 6
            int r3 = r3 - r19
            r5 = 1
            int r3 = r3 - r5
            char[] r5 = r0.buf
            java.lang.System.arraycopy(r5, r1, r5, r4, r3)
            char[] r3 = r0.buf
            r3[r19] = r13
            int r4 = r1 + 1
            r5 = 117(0x75, float:1.64E-43)
            r3[r1] = r5
            int r1 = r4 + 1
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r15 >>> 12
            r6 = r6 & 15
            char r5 = r5[r6]
            r3[r4] = r5
            char[] r3 = r0.buf
            int r4 = r1 + 1
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r15 >>> 8
            r6 = r6 & 15
            char r5 = r5[r6]
            r3[r1] = r5
            char[] r1 = r0.buf
            int r3 = r4 + 1
            char[] r5 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r15 >>> 4
            r6 = r6 & 15
            char r5 = r5[r6]
            r1[r4] = r5
            char[] r1 = r0.buf
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r5 = r15 & 15
            char r4 = r4[r5]
            r1[r3] = r4
            goto L_0x0590
        L_0x03fe:
            int r1 = r19 + 1
            int r4 = r19 + 2
            int r3 = r3 - r19
            r5 = 1
            int r3 = r3 - r5
            char[] r5 = r0.buf
            java.lang.System.arraycopy(r5, r1, r5, r4, r3)
            char[] r3 = r0.buf
            r3[r19] = r13
            char[] r4 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r4 = r4[r15]
            r3[r1] = r4
            goto L_0x0590
        L_0x0417:
            int r1 = r19 + 1
            int r4 = r19 + 6
            int r3 = r3 - r19
            r5 = 1
            int r3 = r3 - r5
            char[] r6 = r0.buf
            java.lang.System.arraycopy(r6, r1, r6, r4, r3)
            char[] r3 = r0.buf
            r3[r19] = r13
            r4 = 117(0x75, float:1.64E-43)
            r3[r1] = r4
            int r1 = r1 + r5
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r15 >>> 12
            r6 = r6 & 15
            char r4 = r4[r6]
            r3[r1] = r4
            char[] r3 = r0.buf
            int r1 = r1 + r5
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r15 >>> 8
            r6 = r6 & 15
            char r4 = r4[r6]
            r3[r1] = r4
            char[] r3 = r0.buf
            int r1 = r1 + r5
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r6 = r15 >>> 4
            r6 = r6 & 15
            char r4 = r4[r6]
            r3[r1] = r4
            char[] r3 = r0.buf
            int r1 = r1 + r5
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r6 = r15 & 15
            char r4 = r4[r6]
            r3[r1] = r4
            goto L_0x0590
        L_0x045e:
            r5 = r4
            if (r12 <= r5) goto L_0x0590
            int r8 = r7 - r6
        L_0x0463:
            int r3 = r1.length
            if (r8 >= r3) goto L_0x0590
            char r3 = r1[r8]
            boolean r4 = r0.browserSecure
            if (r4 == 0) goto L_0x04c5
            r4 = 41
            r5 = 60
            if (r3 == r9) goto L_0x047b
            if (r3 == r4) goto L_0x047b
            r6 = 62
            if (r3 == r5) goto L_0x047d
            if (r3 != r6) goto L_0x04cb
            goto L_0x047d
        L_0x047b:
            r6 = 62
        L_0x047d:
            char[] r10 = r0.buf
            int r11 = r7 + 1
            r10[r7] = r13
            int r7 = r11 + 1
            r12 = 117(0x75, float:1.64E-43)
            r10[r11] = r12
            int r11 = r7 + 1
            char[] r12 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r15 = r3 >>> 12
            r15 = r15 & 15
            char r12 = r12[r15]
            r10[r7] = r12
            char[] r7 = r0.buf
            int r10 = r11 + 1
            char[] r12 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r15 = r3 >>> 8
            r15 = r15 & 15
            char r12 = r12[r15]
            r7[r11] = r12
            char[] r7 = r0.buf
            int r11 = r10 + 1
            char[] r12 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r15 = r3 >>> 4
            r15 = r15 & 15
            char r12 = r12[r15]
            r7[r10] = r12
            char[] r7 = r0.buf
            int r10 = r11 + 1
            char[] r12 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r3 = r3 & 15
            char r3 = r12[r3]
            r7[r11] = r3
            r7 = r10
            r10 = 47
            r11 = 4
        L_0x04c1:
            r16 = 117(0x75, float:1.64E-43)
            goto L_0x058c
        L_0x04c5:
            r4 = 41
            r5 = 60
            r6 = 62
        L_0x04cb:
            byte[] r10 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r10 = r10.length
            if (r3 >= r10) goto L_0x04da
            byte[] r10 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r10 = r10[r3]
            if (r10 != 0) goto L_0x04d7
            goto L_0x04da
        L_0x04d7:
            r10 = 47
            goto L_0x04e6
        L_0x04da:
            r10 = 47
            if (r3 != r10) goto L_0x053c
            com.alibaba.fastjson.serializer.SerializerFeature r11 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial
            boolean r11 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r11)
            if (r11 == 0) goto L_0x053c
        L_0x04e6:
            char[] r11 = r0.buf
            int r12 = r7 + 1
            r11[r7] = r13
            byte[] r7 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r7 = r7[r3]
            r11 = 4
            if (r7 != r11) goto L_0x0530
            char[] r7 = r0.buf
            int r15 = r12 + 1
            r16 = 117(0x75, float:1.64E-43)
            r7[r12] = r16
            int r12 = r15 + 1
            char[] r16 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r17 = r3 >>> 12
            r17 = r17 & 15
            char r16 = r16[r17]
            r7[r15] = r16
            char[] r7 = r0.buf
            int r15 = r12 + 1
            char[] r16 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r17 = r3 >>> 8
            r17 = r17 & 15
            char r16 = r16[r17]
            r7[r12] = r16
            char[] r7 = r0.buf
            int r12 = r15 + 1
            char[] r16 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r17 = r3 >>> 4
            r17 = r17 & 15
            char r16 = r16[r17]
            r7[r15] = r16
            char[] r7 = r0.buf
            int r15 = r12 + 1
            char[] r16 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r3 = r3 & 15
            char r3 = r16[r3]
            r7[r12] = r3
            goto L_0x053a
        L_0x0530:
            char[] r7 = r0.buf
            int r15 = r12 + 1
            char[] r16 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r3 = r16[r3]
            r7[r12] = r3
        L_0x053a:
            r7 = r15
            goto L_0x04c1
        L_0x053c:
            r11 = 4
            if (r3 == r14) goto L_0x054b
            r12 = 8233(0x2029, float:1.1537E-41)
            if (r3 != r12) goto L_0x0544
            goto L_0x054b
        L_0x0544:
            char[] r12 = r0.buf
            int r15 = r7 + 1
            r12[r7] = r3
            goto L_0x053a
        L_0x054b:
            char[] r12 = r0.buf
            int r15 = r7 + 1
            r12[r7] = r13
            int r7 = r15 + 1
            r16 = 117(0x75, float:1.64E-43)
            r12[r15] = r16
            int r15 = r7 + 1
            char[] r17 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r18 = r3 >>> 12
            r18 = r18 & 15
            char r17 = r17[r18]
            r12[r7] = r17
            char[] r7 = r0.buf
            int r12 = r15 + 1
            char[] r17 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r18 = r3 >>> 8
            r18 = r18 & 15
            char r17 = r17[r18]
            r7[r15] = r17
            char[] r7 = r0.buf
            int r15 = r12 + 1
            char[] r17 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r18 = r3 >>> 4
            r18 = r18 & 15
            char r17 = r17[r18]
            r7[r12] = r17
            char[] r7 = r0.buf
            int r12 = r15 + 1
            char[] r17 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r3 = r3 & 15
            char r3 = r17[r3]
            r7[r15] = r3
            r7 = r12
        L_0x058c:
            int r8 = r8 + 1
            goto L_0x0463
        L_0x0590:
            if (r2 == 0) goto L_0x05a1
            char[] r1 = r0.buf
            int r3 = r0.count
            int r4 = r3 + -2
            r5 = 34
            r1[r4] = r5
            r4 = 1
            int r3 = r3 - r4
            r1[r3] = r2
            goto L_0x05ab
        L_0x05a1:
            r4 = 1
            r5 = 34
            char[] r1 = r0.buf
            int r2 = r0.count
            int r2 = r2 - r4
            r1[r2] = r5
        L_0x05ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeStringWithDoubleQuote(char[], char):void");
    }

    public void writeFieldNameDirect(String str) {
        int length = str.length();
        int i = this.count + length + 3;
        if (i > this.buf.length) {
            expandCapacity(i);
        }
        int i2 = this.count;
        char[] cArr = this.buf;
        cArr[i2] = '\"';
        str.getChars(0, length, cArr, i2 + 1);
        this.count = i;
        char[] cArr2 = this.buf;
        cArr2[i - 2] = '\"';
        cArr2[i - 1] = ':';
    }

    public void write(List<String> list) {
        boolean z;
        int i;
        if (list.isEmpty()) {
            write("[]");
            return;
        }
        int i2 = this.count;
        int size = list.size();
        int i3 = i2;
        int i4 = 0;
        while (i4 < size) {
            String str = list.get(i4);
            if (str == null) {
                z = true;
            } else {
                int length = str.length();
                z = false;
                for (int i5 = 0; i5 < length; i5++) {
                    char charAt = str.charAt(i5);
                    z = charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\\';
                    if (z) {
                        break;
                    }
                }
            }
            if (z) {
                this.count = i2;
                write(91);
                for (int i6 = 0; i6 < list.size(); i6++) {
                    String str2 = list.get(i6);
                    if (i6 != 0) {
                        write(44);
                    }
                    if (str2 == null) {
                        write("null");
                    } else {
                        writeStringWithDoubleQuote(str2, 0);
                    }
                }
                write(93);
                return;
            }
            int length2 = str.length() + i3 + 3;
            if (i4 == list.size() - 1) {
                length2++;
            }
            if (length2 > this.buf.length) {
                this.count = i3;
                expandCapacity(length2);
            }
            if (i4 == 0) {
                i = i3 + 1;
                this.buf[i3] = '[';
            } else {
                i = i3 + 1;
                this.buf[i3] = ',';
            }
            int i7 = i + 1;
            this.buf[i] = '\"';
            str.getChars(0, str.length(), this.buf, i7);
            int length3 = i7 + str.length();
            this.buf[length3] = '\"';
            i4++;
            i3 = length3 + 1;
        }
        this.buf[i3] = ']';
        this.count = i3 + 1;
    }

    public void writeFieldValue(char c, String str, char c2) {
        write((int) c);
        writeFieldName(str);
        if (c2 == 0) {
            writeString("\u0000");
        } else {
            writeString(Character.toString(c2));
        }
    }

    public void writeFieldValue(char c, String str, boolean z) {
        if (!this.quoteFieldNames) {
            write((int) c);
            writeFieldName(str);
            write(z);
            return;
        }
        int i = z ? 4 : 5;
        int length = str.length();
        int i2 = this.count + length + 4 + i;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write((int) c);
                writeString(str);
                write(58);
                write(z);
                return;
            }
            expandCapacity(i2);
        }
        int i3 = this.count;
        this.count = i2;
        char[] cArr = this.buf;
        cArr[i3] = c;
        int i4 = i3 + length + 1;
        cArr[i3 + 1] = this.keySeperator;
        str.getChars(0, length, cArr, i3 + 2);
        this.buf[i4 + 1] = this.keySeperator;
        if (z) {
            System.arraycopy(":true".toCharArray(), 0, this.buf, i4 + 2, 5);
        } else {
            System.arraycopy(":false".toCharArray(), 0, this.buf, i4 + 2, 6);
        }
    }

    public void write(boolean z) {
        if (z) {
            write("true");
        } else {
            write("false");
        }
    }

    public void writeFieldValue(char c, String str, int i) {
        if (i == Integer.MIN_VALUE || !this.quoteFieldNames) {
            write((int) c);
            writeFieldName(str);
            writeInt(i);
            return;
        }
        int stringSize = i < 0 ? IOUtils.stringSize(-i) + 1 : IOUtils.stringSize(i);
        int length = str.length();
        int i2 = this.count + length + 4 + stringSize;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write((int) c);
                writeFieldName(str);
                writeInt(i);
                return;
            }
            expandCapacity(i2);
        }
        int i3 = this.count;
        this.count = i2;
        char[] cArr = this.buf;
        cArr[i3] = c;
        int i4 = i3 + length + 1;
        cArr[i3 + 1] = this.keySeperator;
        str.getChars(0, length, cArr, i3 + 2);
        char[] cArr2 = this.buf;
        cArr2[i4 + 1] = this.keySeperator;
        cArr2[i4 + 2] = ':';
        IOUtils.getChars(i, this.count, cArr2);
    }

    public void writeFieldValue(char c, String str, long j) {
        if (j == Long.MIN_VALUE || !this.quoteFieldNames || isEnabled(SerializerFeature.BrowserCompatible.mask)) {
            write((int) c);
            writeFieldName(str);
            writeLong(j);
            return;
        }
        int stringSize = j < 0 ? IOUtils.stringSize(-j) + 1 : IOUtils.stringSize(j);
        int length = str.length();
        int i = this.count + length + 4 + stringSize;
        if (i > this.buf.length) {
            if (this.writer != null) {
                write((int) c);
                writeFieldName(str);
                writeLong(j);
                return;
            }
            expandCapacity(i);
        }
        int i2 = this.count;
        this.count = i;
        char[] cArr = this.buf;
        cArr[i2] = c;
        int i3 = i2 + length + 1;
        cArr[i2 + 1] = this.keySeperator;
        str.getChars(0, length, cArr, i2 + 2);
        char[] cArr2 = this.buf;
        cArr2[i3 + 1] = this.keySeperator;
        cArr2[i3 + 2] = ':';
        IOUtils.getChars(j, this.count, cArr2);
    }

    public void writeFieldValue(char c, String str, float f) {
        write((int) c);
        writeFieldName(str);
        writeFloat(f, false);
    }

    public void writeFieldValue(char c, String str, double d) {
        write((int) c);
        writeFieldName(str);
        writeDouble(d, false);
    }

    public void writeFieldValue(char c, String str, String str2) {
        if (!this.quoteFieldNames) {
            write((int) c);
            writeFieldName(str);
            if (str2 == null) {
                writeNull();
            } else {
                writeString(str2);
            }
        } else if (this.useSingleQuotes) {
            write((int) c);
            writeFieldName(str);
            if (str2 == null) {
                writeNull();
            } else {
                writeString(str2);
            }
        } else if (isEnabled(SerializerFeature.BrowserCompatible)) {
            write((int) c);
            writeStringWithDoubleQuote(str, ':');
            writeStringWithDoubleQuote(str2, 0);
        } else {
            writeFieldValueStringWithDoubleQuoteCheck(c, str, str2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0232, code lost:
        if (r3 != '>') goto L_0x0284;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeFieldValueStringWithDoubleQuoteCheck(char r21, java.lang.String r22, java.lang.String r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r22
            r2 = r23
            int r3 = r22.length()
            int r4 = r0.count
            if (r2 != 0) goto L_0x0013
            int r6 = r3 + 8
            int r4 = r4 + r6
            r6 = 4
            goto L_0x001c
        L_0x0013:
            int r6 = r23.length()
            int r7 = r3 + r6
            int r7 = r7 + 6
            int r4 = r4 + r7
        L_0x001c:
            char[] r7 = r0.buf
            int r7 = r7.length
            r8 = 58
            r9 = 0
            if (r4 <= r7) goto L_0x0035
            java.io.Writer r7 = r0.writer
            if (r7 == 0) goto L_0x0032
            r20.write((int) r21)
            r0.writeStringWithDoubleQuote((java.lang.String) r1, (char) r8)
            r0.writeStringWithDoubleQuote((java.lang.String) r2, (char) r9)
            return
        L_0x0032:
            r0.expandCapacity(r4)
        L_0x0035:
            char[] r7 = r0.buf
            int r10 = r0.count
            r7[r10] = r21
            int r11 = r10 + 2
            int r12 = r11 + r3
            r13 = 1
            int r10 = r10 + r13
            r14 = 34
            r7[r10] = r14
            r1.getChars(r9, r3, r7, r11)
            r0.count = r4
            char[] r1 = r0.buf
            r1[r12] = r14
            int r12 = r12 + r13
            int r3 = r12 + 1
            r1[r12] = r8
            r7 = 117(0x75, float:1.64E-43)
            if (r2 != 0) goto L_0x006a
            int r2 = r3 + 1
            r4 = 110(0x6e, float:1.54E-43)
            r1[r3] = r4
            int r3 = r2 + 1
            r1[r2] = r7
            int r2 = r3 + 1
            r4 = 108(0x6c, float:1.51E-43)
            r1[r3] = r4
            r1[r2] = r4
            return
        L_0x006a:
            int r8 = r3 + 1
            r1[r3] = r14
            int r3 = r8 + r6
            r2.getChars(r9, r6, r1, r8)
            r1 = -1
            r12 = r1
            r15 = r12
            r6 = r8
            r10 = r9
            r11 = r10
        L_0x0079:
            r5 = 8233(0x2029, float:1.1537E-41)
            r9 = 8232(0x2028, float:1.1535E-41)
            r14 = 92
            if (r6 >= r3) goto L_0x00e9
            char[] r7 = r0.buf
            char r7 = r7[r6]
            r13 = 93
            if (r7 < r13) goto L_0x009f
            r13 = 127(0x7f, float:1.78E-43)
            if (r7 < r13) goto L_0x00df
            if (r7 == r9) goto L_0x0095
            if (r7 == r5) goto L_0x0095
            r5 = 160(0xa0, float:2.24E-43)
            if (r7 >= r5) goto L_0x00df
        L_0x0095:
            if (r12 != r1) goto L_0x0098
            r12 = r6
        L_0x0098:
            int r10 = r10 + 1
            int r4 = r4 + 4
        L_0x009c:
            r15 = r6
        L_0x009d:
            r11 = r7
            goto L_0x00df
        L_0x009f:
            r5 = 64
            if (r7 >= r5) goto L_0x00b1
            long r1 = r0.sepcialBits
            r18 = 1
            long r18 = r18 << r7
            long r1 = r1 & r18
            r18 = 0
            int r1 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r1 != 0) goto L_0x00b3
        L_0x00b1:
            if (r7 != r14) goto L_0x00b5
        L_0x00b3:
            r1 = 1
            goto L_0x00b6
        L_0x00b5:
            r1 = 0
        L_0x00b6:
            if (r1 == 0) goto L_0x00de
            int r10 = r10 + 1
            r1 = 40
            if (r7 == r1) goto L_0x00d6
            r1 = 41
            if (r7 == r1) goto L_0x00d6
            r1 = 60
            if (r7 == r1) goto L_0x00d6
            r1 = 62
            if (r7 == r1) goto L_0x00d6
            byte[] r1 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r1 = r1.length
            if (r7 >= r1) goto L_0x00d8
            byte[] r1 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r1 = r1[r7]
            r2 = 4
            if (r1 != r2) goto L_0x00d8
        L_0x00d6:
            int r4 = r4 + 4
        L_0x00d8:
            r1 = -1
            if (r12 != r1) goto L_0x009c
            r12 = r6
            r15 = r12
            goto L_0x009d
        L_0x00de:
            r1 = -1
        L_0x00df:
            int r6 = r6 + 1
            r2 = r23
            r7 = 117(0x75, float:1.64E-43)
            r13 = 1
            r14 = 34
            goto L_0x0079
        L_0x00e9:
            if (r10 <= 0) goto L_0x0343
            int r4 = r4 + r10
            char[] r1 = r0.buf
            int r1 = r1.length
            if (r4 <= r1) goto L_0x00f4
            r0.expandCapacity(r4)
        L_0x00f4:
            r0.count = r4
            r1 = 1
            if (r10 != r1) goto L_0x0210
            r2 = 48
            r4 = 50
            if (r11 != r9) goto L_0x0122
            int r5 = r15 + 1
            int r6 = r15 + 6
            int r3 = r3 - r15
            int r3 = r3 - r1
            char[] r7 = r0.buf
            java.lang.System.arraycopy(r7, r5, r7, r6, r3)
            char[] r3 = r0.buf
            r3[r15] = r14
            r6 = 117(0x75, float:1.64E-43)
            r3[r5] = r6
            int r5 = r5 + r1
            r3[r5] = r4
            int r5 = r5 + r1
            r3[r5] = r2
            int r5 = r5 + r1
            r3[r5] = r4
            int r5 = r5 + r1
            r2 = 56
            r3[r5] = r2
            goto L_0x0343
        L_0x0122:
            if (r11 != r5) goto L_0x0147
            int r5 = r15 + 1
            int r6 = r15 + 6
            int r3 = r3 - r15
            int r3 = r3 - r1
            char[] r7 = r0.buf
            java.lang.System.arraycopy(r7, r5, r7, r6, r3)
            char[] r3 = r0.buf
            r3[r15] = r14
            r6 = 117(0x75, float:1.64E-43)
            r3[r5] = r6
            int r5 = r5 + r1
            r3[r5] = r4
            int r5 = r5 + r1
            r3[r5] = r2
            int r5 = r5 + r1
            r3[r5] = r4
            int r5 = r5 + r1
            r1 = 57
            r3[r5] = r1
            goto L_0x0343
        L_0x0147:
            r1 = 40
            if (r11 == r1) goto L_0x01c6
            r1 = 41
            if (r11 == r1) goto L_0x01c6
            r1 = 60
            if (r11 == r1) goto L_0x01c6
            r1 = 62
            if (r11 != r1) goto L_0x0158
            goto L_0x01c6
        L_0x0158:
            byte[] r1 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r1 = r1.length
            if (r11 >= r1) goto L_0x01ae
            byte[] r1 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r1 = r1[r11]
            r2 = 4
            if (r1 != r2) goto L_0x01ae
            int r1 = r15 + 1
            int r2 = r15 + 6
            int r3 = r3 - r15
            r4 = 1
            int r3 = r3 - r4
            char[] r4 = r0.buf
            java.lang.System.arraycopy(r4, r1, r4, r2, r3)
            char[] r2 = r0.buf
            r2[r15] = r14
            int r3 = r1 + 1
            r4 = 117(0x75, float:1.64E-43)
            r2[r1] = r4
            int r1 = r3 + 1
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r5 = r11 >>> 12
            r5 = r5 & 15
            char r4 = r4[r5]
            r2[r3] = r4
            char[] r2 = r0.buf
            int r3 = r1 + 1
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r5 = r11 >>> 8
            r5 = r5 & 15
            char r4 = r4[r5]
            r2[r1] = r4
            char[] r1 = r0.buf
            int r2 = r3 + 1
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r5 = r11 >>> 4
            r5 = r5 & 15
            char r4 = r4[r5]
            r1[r3] = r4
            char[] r1 = r0.buf
            char[] r3 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r4 = r11 & 15
            char r3 = r3[r4]
            r1[r2] = r3
            goto L_0x0343
        L_0x01ae:
            int r1 = r15 + 1
            int r2 = r15 + 2
            int r3 = r3 - r15
            r4 = 1
            int r3 = r3 - r4
            char[] r4 = r0.buf
            java.lang.System.arraycopy(r4, r1, r4, r2, r3)
            char[] r2 = r0.buf
            r2[r15] = r14
            char[] r3 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r3 = r3[r11]
            r2[r1] = r3
            goto L_0x0343
        L_0x01c6:
            int r1 = r15 + 1
            int r2 = r15 + 6
            int r3 = r3 - r15
            r4 = 1
            int r3 = r3 - r4
            char[] r4 = r0.buf
            java.lang.System.arraycopy(r4, r1, r4, r2, r3)
            char[] r2 = r0.buf
            r2[r15] = r14
            int r3 = r1 + 1
            r4 = 117(0x75, float:1.64E-43)
            r2[r1] = r4
            int r1 = r3 + 1
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r5 = r11 >>> 12
            r5 = r5 & 15
            char r4 = r4[r5]
            r2[r3] = r4
            char[] r2 = r0.buf
            int r3 = r1 + 1
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r5 = r11 >>> 8
            r5 = r5 & 15
            char r4 = r4[r5]
            r2[r1] = r4
            char[] r1 = r0.buf
            int r2 = r3 + 1
            char[] r4 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r5 = r11 >>> 4
            r5 = r5 & 15
            char r4 = r4[r5]
            r1[r3] = r4
            char[] r1 = r0.buf
            char[] r3 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r4 = r11 & 15
            char r3 = r3[r4]
            r1[r2] = r3
            goto L_0x0343
        L_0x0210:
            if (r10 <= r1) goto L_0x0343
            int r1 = r12 - r8
        L_0x0214:
            int r2 = r23.length()
            if (r1 >= r2) goto L_0x0343
            r2 = r23
            char r3 = r2.charAt(r1)
            boolean r4 = r0.browserSecure
            if (r4 == 0) goto L_0x027c
            r4 = 40
            r6 = 41
            r7 = 60
            if (r3 == r4) goto L_0x0235
            if (r3 == r6) goto L_0x0235
            r8 = 62
            if (r3 == r7) goto L_0x0237
            if (r3 != r8) goto L_0x0284
            goto L_0x0237
        L_0x0235:
            r8 = 62
        L_0x0237:
            char[] r10 = r0.buf
            int r11 = r12 + 1
            r10[r12] = r14
            int r12 = r11 + 1
            r13 = 117(0x75, float:1.64E-43)
            r10[r11] = r13
            int r11 = r12 + 1
            char[] r13 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r15 = r3 >>> 12
            r15 = r15 & 15
            char r13 = r13[r15]
            r10[r12] = r13
            char[] r10 = r0.buf
            int r12 = r11 + 1
            char[] r13 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r15 = r3 >>> 8
            r15 = r15 & 15
            char r13 = r13[r15]
            r10[r11] = r13
            char[] r10 = r0.buf
            int r11 = r12 + 1
            char[] r13 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r15 = r3 >>> 4
            r15 = r15 & 15
            char r13 = r13[r15]
            r10[r12] = r13
            char[] r10 = r0.buf
            int r12 = r11 + 1
            char[] r13 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r3 = r3 & 15
            char r3 = r13[r3]
            r10[r11] = r3
            r13 = 4
        L_0x0278:
            r15 = 117(0x75, float:1.64E-43)
            goto L_0x033f
        L_0x027c:
            r4 = 40
            r6 = 41
            r7 = 60
            r8 = 62
        L_0x0284:
            byte[] r10 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            int r10 = r10.length
            if (r3 >= r10) goto L_0x028f
            byte[] r10 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r10 = r10[r3]
            if (r10 != 0) goto L_0x029b
        L_0x028f:
            r10 = 47
            if (r3 != r10) goto L_0x02f0
            com.alibaba.fastjson.serializer.SerializerFeature r10 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial
            boolean r10 = r0.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r10)
            if (r10 == 0) goto L_0x02f0
        L_0x029b:
            char[] r10 = r0.buf
            int r11 = r12 + 1
            r10[r12] = r14
            byte[] r10 = com.alibaba.fastjson.util.IOUtils.specicalFlags_doubleQuotes
            byte r10 = r10[r3]
            r13 = 4
            if (r10 != r13) goto L_0x02e5
            char[] r10 = r0.buf
            int r12 = r11 + 1
            r15 = 117(0x75, float:1.64E-43)
            r10[r11] = r15
            int r11 = r12 + 1
            char[] r15 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r16 = r3 >>> 12
            r16 = r16 & 15
            char r15 = r15[r16]
            r10[r12] = r15
            char[] r10 = r0.buf
            int r12 = r11 + 1
            char[] r15 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r16 = r3 >>> 8
            r16 = r16 & 15
            char r15 = r15[r16]
            r10[r11] = r15
            char[] r10 = r0.buf
            int r11 = r12 + 1
            char[] r15 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r16 = r3 >>> 4
            r16 = r16 & 15
            char r15 = r15[r16]
            r10[r12] = r15
            char[] r10 = r0.buf
            int r12 = r11 + 1
            char[] r15 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r3 = r3 & 15
            char r3 = r15[r3]
            r10[r11] = r3
            goto L_0x0278
        L_0x02e5:
            char[] r10 = r0.buf
            int r12 = r11 + 1
            char[] r15 = com.alibaba.fastjson.util.IOUtils.replaceChars
            char r3 = r15[r3]
            r10[r11] = r3
            goto L_0x0278
        L_0x02f0:
            r13 = 4
            if (r3 == r9) goto L_0x02ff
            if (r3 != r5) goto L_0x02f6
            goto L_0x02ff
        L_0x02f6:
            char[] r10 = r0.buf
            int r11 = r12 + 1
            r10[r12] = r3
            r12 = r11
            goto L_0x0278
        L_0x02ff:
            char[] r10 = r0.buf
            int r11 = r12 + 1
            r10[r12] = r14
            int r12 = r11 + 1
            r15 = 117(0x75, float:1.64E-43)
            r10[r11] = r15
            int r11 = r12 + 1
            char[] r16 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r17 = r3 >>> 12
            r17 = r17 & 15
            char r16 = r16[r17]
            r10[r12] = r16
            char[] r10 = r0.buf
            int r12 = r11 + 1
            char[] r16 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r17 = r3 >>> 8
            r17 = r17 & 15
            char r16 = r16[r17]
            r10[r11] = r16
            char[] r10 = r0.buf
            int r11 = r12 + 1
            char[] r16 = com.alibaba.fastjson.util.IOUtils.DIGITS
            int r17 = r3 >>> 4
            r17 = r17 & 15
            char r16 = r16[r17]
            r10[r12] = r16
            char[] r10 = r0.buf
            int r12 = r11 + 1
            char[] r16 = com.alibaba.fastjson.util.IOUtils.DIGITS
            r3 = r3 & 15
            char r3 = r16[r3]
            r10[r11] = r3
        L_0x033f:
            int r1 = r1 + 1
            goto L_0x0214
        L_0x0343:
            char[] r1 = r0.buf
            int r2 = r0.count
            r3 = 1
            int r2 = r2 - r3
            r3 = 34
            r1[r2] = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeFieldValueStringWithDoubleQuoteCheck(char, java.lang.String, java.lang.String):void");
    }

    public void writeFieldValueStringWithDoubleQuote(char c, String str, String str2) {
        int length = str.length();
        int i = this.count;
        int length2 = str2.length();
        int i2 = i + length + length2 + 6;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write((int) c);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, 0);
                return;
            }
            expandCapacity(i2);
        }
        char[] cArr = this.buf;
        int i3 = this.count;
        cArr[i3] = c;
        int i4 = i3 + 2;
        int i5 = i4 + length;
        cArr[i3 + 1] = '\"';
        str.getChars(0, length, cArr, i4);
        this.count = i2;
        char[] cArr2 = this.buf;
        cArr2[i5] = '\"';
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        cArr2[i6] = ':';
        cArr2[i7] = '\"';
        str2.getChars(0, length2, cArr2, i7 + 1);
        this.buf[this.count - 1] = '\"';
    }

    public void writeFieldValue(char c, String str, Enum<?> enumR) {
        if (enumR == null) {
            write((int) c);
            writeFieldName(str);
            writeNull();
        } else if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
            writeEnumFieldValue(c, str, enumR.name());
        } else if (this.writeEnumUsingToString) {
            writeEnumFieldValue(c, str, enumR.toString());
        } else {
            writeFieldValue(c, str, enumR.ordinal());
        }
    }

    private void writeEnumFieldValue(char c, String str, String str2) {
        if (this.useSingleQuotes) {
            writeFieldValue(c, str, str2);
        } else {
            writeFieldValueStringWithDoubleQuote(c, str, str2);
        }
    }

    public void writeFieldValue(char c, String str, BigDecimal bigDecimal) {
        String str2;
        write((int) c);
        writeFieldName(str);
        if (bigDecimal == null) {
            writeNull();
            return;
        }
        int scale = bigDecimal.scale();
        if (!isEnabled(SerializerFeature.WriteBigDecimalAsPlain) || scale < -100 || scale >= 100) {
            str2 = bigDecimal.toString();
        } else {
            str2 = bigDecimal.toPlainString();
        }
        write(str2);
    }

    public void writeString(String str, char c) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(str);
            write((int) c);
            return;
        }
        writeStringWithDoubleQuote(str, c);
    }

    public void writeString(String str) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, 0);
        }
    }

    public void writeString(char[] cArr) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(cArr);
        } else {
            writeStringWithDoubleQuote(new String(cArr), 0);
        }
    }

    /* access modifiers changed from: protected */
    public void writeStringWithSingleQuote(String str) {
        int i = 0;
        if (str == null) {
            int i2 = this.count + 4;
            if (i2 > this.buf.length) {
                expandCapacity(i2);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i2;
            return;
        }
        int length = str.length();
        int i3 = this.count + length + 2;
        if (i3 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i < str.length()) {
                    char charAt = str.charAt(i);
                    if (charAt <= 13 || charAt == '\\' || charAt == '\'' || (charAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write(92);
                        write((int) IOUtils.replaceChars[charAt]);
                    } else {
                        write((int) charAt);
                    }
                    i++;
                }
                write(39);
                return;
            }
            expandCapacity(i3);
        }
        int i4 = this.count;
        int i5 = i4 + 1;
        int i6 = i5 + length;
        char[] cArr = this.buf;
        cArr[i4] = '\'';
        str.getChars(0, length, cArr, i5);
        this.count = i3;
        int i7 = -1;
        char c = 0;
        for (int i8 = i5; i8 < i6; i8++) {
            char c2 = this.buf[i8];
            if (c2 <= 13 || c2 == '\\' || c2 == '\'' || (c2 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                i++;
                i7 = i8;
                c = c2;
            }
        }
        int i9 = i3 + i;
        if (i9 > this.buf.length) {
            expandCapacity(i9);
        }
        this.count = i9;
        if (i == 1) {
            char[] cArr2 = this.buf;
            int i10 = i7 + 1;
            System.arraycopy(cArr2, i10, cArr2, i7 + 2, (i6 - i7) - 1);
            char[] cArr3 = this.buf;
            cArr3[i7] = '\\';
            cArr3[i10] = IOUtils.replaceChars[c];
        } else if (i > 1) {
            char[] cArr4 = this.buf;
            int i11 = i7 + 1;
            System.arraycopy(cArr4, i11, cArr4, i7 + 2, (i6 - i7) - 1);
            char[] cArr5 = this.buf;
            cArr5[i7] = '\\';
            cArr5[i11] = IOUtils.replaceChars[c];
            int i12 = i6 + 1;
            for (int i13 = i11 - 2; i13 >= i5; i13--) {
                char c3 = this.buf[i13];
                if (c3 <= 13 || c3 == '\\' || c3 == '\'' || (c3 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr6 = this.buf;
                    int i14 = i13 + 1;
                    System.arraycopy(cArr6, i14, cArr6, i13 + 2, (i12 - i13) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i13] = '\\';
                    cArr7[i14] = IOUtils.replaceChars[c3];
                    i12++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    /* access modifiers changed from: protected */
    public void writeStringWithSingleQuote(char[] cArr) {
        int i = 0;
        if (cArr == null) {
            int i2 = this.count + 4;
            if (i2 > this.buf.length) {
                expandCapacity(i2);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i2;
            return;
        }
        int length = cArr.length;
        int i3 = this.count + length + 2;
        if (i3 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i < cArr.length) {
                    char c = cArr[i];
                    if (c <= 13 || c == '\\' || c == '\'' || (c == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write(92);
                        write((int) IOUtils.replaceChars[c]);
                    } else {
                        write((int) c);
                    }
                    i++;
                }
                write(39);
                return;
            }
            expandCapacity(i3);
        }
        int i4 = this.count;
        int i5 = i4 + 1;
        int i6 = length + i5;
        char[] cArr2 = this.buf;
        cArr2[i4] = '\'';
        System.arraycopy(cArr, 0, cArr2, i5, cArr.length);
        this.count = i3;
        int i7 = -1;
        char c2 = 0;
        for (int i8 = i5; i8 < i6; i8++) {
            char c3 = this.buf[i8];
            if (c3 <= 13 || c3 == '\\' || c3 == '\'' || (c3 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                i++;
                i7 = i8;
                c2 = c3;
            }
        }
        int i9 = i3 + i;
        if (i9 > this.buf.length) {
            expandCapacity(i9);
        }
        this.count = i9;
        if (i == 1) {
            char[] cArr3 = this.buf;
            int i10 = i7 + 1;
            System.arraycopy(cArr3, i10, cArr3, i7 + 2, (i6 - i7) - 1);
            char[] cArr4 = this.buf;
            cArr4[i7] = '\\';
            cArr4[i10] = IOUtils.replaceChars[c2];
        } else if (i > 1) {
            char[] cArr5 = this.buf;
            int i11 = i7 + 1;
            System.arraycopy(cArr5, i11, cArr5, i7 + 2, (i6 - i7) - 1);
            char[] cArr6 = this.buf;
            cArr6[i7] = '\\';
            cArr6[i11] = IOUtils.replaceChars[c2];
            int i12 = i6 + 1;
            for (int i13 = i11 - 2; i13 >= i5; i13--) {
                char c4 = this.buf[i13];
                if (c4 <= 13 || c4 == '\\' || c4 == '\'' || (c4 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr7 = this.buf;
                    int i14 = i13 + 1;
                    System.arraycopy(cArr7, i14, cArr7, i13 + 2, (i12 - i13) - 1);
                    char[] cArr8 = this.buf;
                    cArr8[i13] = '\\';
                    cArr8[i14] = IOUtils.replaceChars[c4];
                    i12++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeFieldName(String str) {
        writeFieldName(str, false);
    }

    public void writeFieldName(String str, boolean z) {
        if (str == null) {
            write("null:");
        } else if (this.useSingleQuotes) {
            if (this.quoteFieldNames) {
                writeStringWithSingleQuote(str);
                write(58);
                return;
            }
            writeKeyWithSingleQuoteIfHasSpecial(str);
        } else if (this.quoteFieldNames) {
            writeStringWithDoubleQuote(str, ':');
        } else {
            boolean z2 = true;
            boolean z3 = str.length() == 0;
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    z2 = z3;
                    break;
                }
                char charAt = str.charAt(i);
                if ((charAt < '@' && (this.sepcialBits & (1 << charAt)) != 0) || charAt == '\\') {
                    break;
                }
                i++;
            }
            if (z2) {
                writeStringWithDoubleQuote(str, ':');
                return;
            }
            write(str);
            write(58);
        }
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        String str2 = str;
        byte[] bArr = IOUtils.specicalFlags_singleQuotes;
        int length = str.length();
        boolean z = true;
        int i = this.count + length + 1;
        int i2 = 0;
        if (i > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i);
            } else if (length == 0) {
                write(39);
                write(39);
                write(58);
                return;
            } else {
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        char charAt = str2.charAt(i3);
                        if (charAt < bArr.length && bArr[charAt] != 0) {
                            break;
                        }
                        i3++;
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    write(39);
                }
                while (i2 < length) {
                    char charAt2 = str2.charAt(i2);
                    if (charAt2 >= bArr.length || bArr[charAt2] == 0) {
                        write((int) charAt2);
                    } else {
                        write(92);
                        write((int) IOUtils.replaceChars[charAt2]);
                    }
                    i2++;
                }
                if (z) {
                    write(39);
                }
                write(58);
                return;
            }
        }
        if (length == 0) {
            int i4 = this.count;
            if (i4 + 3 > this.buf.length) {
                expandCapacity(i4 + 3);
            }
            char[] cArr = this.buf;
            int i5 = this.count;
            int i6 = i5 + 1;
            this.count = i6;
            cArr[i5] = '\'';
            int i7 = i6 + 1;
            this.count = i7;
            cArr[i6] = '\'';
            this.count = i7 + 1;
            cArr[i7] = ':';
            return;
        }
        int i8 = this.count;
        int i9 = i8 + length;
        str2.getChars(0, length, this.buf, i8);
        this.count = i;
        int i10 = i8;
        boolean z2 = false;
        while (i10 < i9) {
            char[] cArr2 = this.buf;
            char c = cArr2[i10];
            if (c < bArr.length && bArr[c] != 0) {
                if (!z2) {
                    i += 3;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr3 = this.buf;
                    int i11 = i10 + 1;
                    System.arraycopy(cArr3, i11, cArr3, i10 + 3, (i9 - i10) - 1);
                    char[] cArr4 = this.buf;
                    System.arraycopy(cArr4, i2, cArr4, 1, i10);
                    char[] cArr5 = this.buf;
                    cArr5[i8] = '\'';
                    cArr5[i11] = '\\';
                    int i12 = i11 + 1;
                    cArr5[i12] = IOUtils.replaceChars[c];
                    i9 += 2;
                    this.buf[this.count - 2] = '\'';
                    i10 = i12;
                    z2 = true;
                } else {
                    i++;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr6 = this.buf;
                    int i13 = i10 + 1;
                    System.arraycopy(cArr6, i13, cArr6, i10 + 2, i9 - i10);
                    char[] cArr7 = this.buf;
                    cArr7[i10] = '\\';
                    cArr7[i13] = IOUtils.replaceChars[c];
                    i9++;
                    i10 = i13;
                }
            }
            i10++;
            i2 = 0;
        }
        this.buf[i - 1] = ':';
    }

    public void flush() {
        Writer writer2 = this.writer;
        if (writer2 != null) {
            try {
                writer2.write(this.buf, 0, this.count);
                this.writer.flush();
                this.count = 0;
            } catch (IOException e) {
                throw new JSONException(e.getMessage(), e);
            }
        }
    }
}
