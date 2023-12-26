package io.agora.rtc.internal;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

class Marshallable {
    public static final int PROTO_PACKET_SIZE = 8192;
    private ByteBuffer mBuffer;

    public Marshallable() {
        ByteBuffer allocate = ByteBuffer.allocate(PROTO_PACKET_SIZE);
        this.mBuffer = allocate;
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        this.mBuffer.position(2);
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [int, short] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] marshall() {
        /*
            r3 = this;
            java.nio.ByteBuffer r0 = r3.mBuffer
            int r0 = r0.position()
            short r0 = (short) r0
            java.nio.ByteBuffer r1 = r3.mBuffer
            r2 = 0
            r1.putShort(r2, r0)
            byte[] r0 = new byte[r0]
            java.nio.ByteBuffer r1 = r3.mBuffer
            r1.position(r2)
            java.nio.ByteBuffer r1 = r3.mBuffer
            r1.get(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.internal.Marshallable.marshall():byte[]");
    }

    public void marshall(ByteBuffer byteBuffer) {
        this.mBuffer = byteBuffer;
    }

    public void unmarshall(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.mBuffer = wrap;
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        popShort();
    }

    public void unmarshall(ByteBuffer byteBuffer) {
        this.mBuffer = byteBuffer;
    }

    public ByteBuffer getBuffer() {
        return this.mBuffer;
    }

    public void pushBool(Boolean bool) {
        this.mBuffer.put(bool.booleanValue() ? (byte) 1 : 0);
    }

    public Boolean popBool() {
        boolean z = true;
        if (this.mBuffer.get() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public void pushByte(byte b) {
        this.mBuffer.put(b);
    }

    public byte popByte() {
        return this.mBuffer.get();
    }

    public void pushBytes(byte[] bArr) {
        this.mBuffer.putShort((short) bArr.length);
        this.mBuffer.put(bArr);
    }

    public byte[] popBytes() {
        int i = this.mBuffer.getShort();
        byte[] bArr = new byte[0];
        if (i <= 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        this.mBuffer.get(bArr2);
        return bArr2;
    }

    public void pushBytes32(byte[] bArr) {
        this.mBuffer.putInt(bArr.length);
        this.mBuffer.put(bArr);
    }

    public byte[] popBytes32() {
        int i = this.mBuffer.getInt();
        if (i <= 0) {
            return null;
        }
        byte[] bArr = new byte[i];
        this.mBuffer.get(bArr);
        return bArr;
    }

    public byte[] popAll() {
        byte[] bArr = new byte[this.mBuffer.remaining()];
        this.mBuffer.get(bArr);
        return bArr;
    }

    public void pushShort(short s) {
        this.mBuffer.putShort(s);
    }

    public short popShort() {
        return this.mBuffer.getShort();
    }

    public void pushInt(int i) {
        this.mBuffer.putInt(i);
    }

    public void pushDouble(double d) {
        this.mBuffer.putDouble(d);
    }

    public int popInt() {
        return this.mBuffer.getInt();
    }

    public void pushInt64(long j) {
        this.mBuffer.putLong(j);
    }

    public long popInt64() {
        return this.mBuffer.getLong();
    }

    public void pushString16(String str) {
        if (str == null) {
            this.mBuffer.putShort(0);
            return;
        }
        this.mBuffer.putShort((short) str.getBytes().length);
        if (str.getBytes().length > 0) {
            this.mBuffer.put(str.getBytes());
        }
    }

    public String popString16() {
        int i = this.mBuffer.getShort();
        if (i <= 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        this.mBuffer.get(bArr);
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String popString16UTF8() {
        int i = this.mBuffer.getShort();
        if (i <= 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        this.mBuffer.get(bArr);
        try {
            return new String(bArr, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void pushStringArray(ArrayList<String> arrayList) {
        if (arrayList == null) {
            pushInt(0);
            return;
        }
        int size = arrayList.size();
        pushShort((short) size);
        for (int i = 0; i < size; i++) {
            pushBytes(arrayList.get(i).getBytes());
        }
    }

    public void pushIntArray(int[] iArr) {
        if (iArr == null) {
            pushInt(0);
            return;
        }
        pushInt(r1);
        for (int pushInt : iArr) {
            pushInt(pushInt);
        }
    }

    public void pushIntArray(Integer[] numArr) {
        if (numArr == null) {
            pushInt(0);
            return;
        }
        pushInt(r1);
        for (Integer intValue : numArr) {
            pushInt(intValue.intValue());
        }
    }

    public int[] popIntArray() {
        int popInt = popInt();
        int[] iArr = new int[popInt];
        for (int i = 0; i < popInt; i++) {
            iArr[i] = popInt();
        }
        return iArr;
    }

    public void pushShortArray(short[] sArr) {
        if (sArr == null) {
            pushInt(0);
            return;
        }
        pushInt(r1);
        for (short pushShort : sArr) {
            pushShort(pushShort);
        }
    }

    public short[] popShortArray() {
        int popInt = popInt();
        short[] sArr = new short[popInt];
        for (int i = 0; i < popInt; i++) {
            sArr[i] = popShort();
        }
        return sArr;
    }

    public void clear() {
        this.mBuffer.position(10);
    }
}
