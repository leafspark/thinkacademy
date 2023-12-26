package com.bonree.sdk.common.json;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.util.Arrays;

public class Kim {
    private byte[] bytes;
    private int hashcode;
    public int length;
    private String string;

    public Kim(byte[] bArr, int i, int i2) {
        this.bytes = null;
        this.hashcode = 0;
        this.length = 0;
        this.string = null;
        this.hashcode = 0;
        int i3 = i2 - i;
        this.length = i3;
        if (i3 > 0) {
            this.bytes = new byte[i3];
            int i4 = 1;
            for (int i5 = 0; i5 < this.length; i5++) {
                byte b = bArr[i5 + i] & 255;
                i4 += b;
                this.hashcode += i4;
                this.bytes[i5] = (byte) b;
            }
            this.hashcode += i4 << 16;
        }
    }

    public Kim(byte[] bArr, int i) {
        this(bArr, 0, i);
    }

    public Kim(Kim kim, int i, int i2) {
        this(kim.bytes, i, i2);
    }

    public Kim(String str) throws JSONException {
        int i;
        this.bytes = null;
        int i2 = 0;
        this.hashcode = 0;
        this.length = 0;
        this.string = null;
        int length2 = str.length();
        this.hashcode = 0;
        this.length = 0;
        if (length2 > 0) {
            int i3 = 0;
            while (i3 < length2) {
                char charAt = str.charAt(i3);
                if (charAt <= 127) {
                    this.length++;
                } else if (charAt <= 16383) {
                    this.length += 2;
                } else {
                    if (charAt >= 55296 && charAt <= 57343) {
                        i3++;
                        char charAt2 = str.charAt(i3);
                        if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                            throw new JSONException("Bad UTF16");
                        }
                    }
                    this.length += 3;
                }
                i3++;
            }
            this.bytes = new byte[this.length];
            int i4 = 0;
            int i5 = 1;
            while (i2 < length2) {
                int charAt3 = str.charAt(i2);
                if (charAt3 <= 127) {
                    this.bytes[i4] = (byte) charAt3;
                    i5 += charAt3;
                    this.hashcode += i5;
                    i4++;
                } else {
                    if (charAt3 <= 16383) {
                        int i6 = (charAt3 >>> 7) | 128;
                        byte[] bArr = this.bytes;
                        bArr[i4] = (byte) i6;
                        int i7 = i5 + i6;
                        int i8 = this.hashcode + i7;
                        this.hashcode = i8;
                        i = i4 + 1;
                        int i9 = charAt3 & 127;
                        bArr[i] = (byte) i9;
                        i5 = i7 + i9;
                        this.hashcode = i8 + i5;
                    } else {
                        if (charAt3 >= 55296 && charAt3 <= 56319) {
                            i2++;
                            charAt3 = (((charAt3 & 1023) << 10) | (str.charAt(i2) & 1023)) + ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        int i10 = (charAt3 >>> 14) | 128;
                        byte[] bArr2 = this.bytes;
                        bArr2[i4] = (byte) i10;
                        int i11 = i5 + i10;
                        int i12 = this.hashcode + i11;
                        this.hashcode = i12;
                        int i13 = i4 + 1;
                        int i14 = ((charAt3 >>> 7) & 255) | 128;
                        bArr2[i13] = (byte) i14;
                        int i15 = i11 + i14;
                        int i16 = i12 + i15;
                        this.hashcode = i16;
                        i = i13 + 1;
                        int i17 = charAt3 & 127;
                        bArr2[i] = (byte) i17;
                        i5 = i15 + i17;
                        this.hashcode = i16 + i5;
                    }
                    i4 = i + 1;
                }
                i2++;
            }
            this.hashcode += i5 << 16;
        }
    }

    public int characterAt(int i) throws JSONException {
        int i2 = get(i);
        if ((i2 & 128) == 0) {
            return i2;
        }
        int i3 = get(i + 1);
        if ((i3 & 128) == 0) {
            int i4 = ((i2 & 127) << 7) | i3;
            if (i4 > 127) {
                return i4;
            }
        } else {
            int i5 = get(i + 2);
            int i6 = ((i2 & 127) << 14) | ((i3 & 127) << 7) | i5;
            if ((i5 & 128) == 0 && i6 > 16383 && i6 <= 1114111 && (i6 < 55296 || i6 > 57343)) {
                return i6;
            }
        }
        throw new JSONException("Bad character at " + i);
    }

    public static int characterSize(int i) throws JSONException {
        if (i < 0 || i > 1114111) {
            throw new JSONException("Bad character " + i);
        } else if (i <= 127) {
            return 1;
        } else {
            return i <= 16383 ? 2 : 3;
        }
    }

    public int copy(byte[] bArr, int i) {
        System.arraycopy(this.bytes, 0, bArr, i, this.length);
        return i + this.length;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Kim)) {
            return false;
        }
        Kim kim = (Kim) obj;
        if (this == kim) {
            return true;
        }
        if (this.hashcode != kim.hashcode) {
            return false;
        }
        return Arrays.equals(this.bytes, kim.bytes);
    }

    public int get(int i) throws JSONException {
        if (i >= 0 && i <= this.length) {
            return this.bytes[i] & 255;
        }
        throw new JSONException("Bad character at " + i);
    }

    public int hashCode() {
        return this.hashcode;
    }

    public String toString() throws JSONException {
        if (this.string == null) {
            char[] cArr = new char[this.length];
            int i = 0;
            int i2 = 0;
            while (i < this.length) {
                int characterAt = characterAt(i);
                if (characterAt < 65536) {
                    cArr[i2] = (char) characterAt;
                } else {
                    cArr[i2] = (char) (((characterAt - ArrayPool.STANDARD_BUFFER_SIZE_BYTES) >>> 10) | 55296);
                    i2++;
                    cArr[i2] = (char) (56320 | (characterAt & 1023));
                }
                i2++;
                i += characterSize(characterAt);
            }
            this.string = new String(cArr, 0, i2);
        }
        return this.string;
    }
}
