package com.bonree.sdk.bp;

import com.bonree.sdk.bk.a;
import com.bonree.sdk.bp.v;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class n extends h {
    private static final Logger a = Logger.getLogger(n.class.getName());
    private a b;
    private final byte[] c;
    private List<v.b> d;

    public static n a(DataInputStream dataInputStream, byte[] bArr, int i) throws IOException {
        a a2 = a.a(dataInputStream, bArr);
        int b2 = i - a2.b();
        byte[] bArr2 = new byte[b2];
        if (dataInputStream.read(bArr2) == b2) {
            return new n(a2, a(bArr2));
        }
        throw new IOException();
    }

    private n(String str, List<v.b> list) {
        this(a.a(str), list);
    }

    private n(String str, v.b... bVarArr) {
        this(a.a(str), (List<v.b>) Arrays.asList(bVarArr));
    }

    private n(a aVar, List<v.b> list) {
        this.b = aVar;
        this.d = Collections.unmodifiableList(list);
        this.c = a(list);
    }

    public final v.b a() {
        return v.b.NSEC;
    }

    public final void a(DataOutputStream dataOutputStream) throws IOException {
        this.b.a((OutputStream) dataOutputStream);
        dataOutputStream.write(this.c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        sb.append('.');
        for (v.b append : this.d) {
            sb.append(' ');
            sb.append(append);
        }
        return sb.toString();
    }

    static byte[] a(List<v.b> list) {
        ArrayList<Integer> arrayList = new ArrayList<>(list.size());
        for (v.b a2 : list) {
            arrayList.add(Integer.valueOf(a2.a()));
        }
        Collections.sort(arrayList);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        byte[] bArr = null;
        try {
            int i = -1;
            for (Integer num : arrayList) {
                if (i == -1 || (num.intValue() >> 8) != i) {
                    if (i != -1) {
                        a(bArr, dataOutputStream);
                    }
                    i = num.intValue() >> 8;
                    dataOutputStream.writeByte(i);
                    bArr = new byte[32];
                }
                int intValue = (num.intValue() >> 3) % 32;
                bArr[intValue] = (byte) ((128 >> (num.intValue() % 8)) | bArr[intValue]);
            }
            if (i != -1) {
                a(bArr, dataOutputStream);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void a(byte[] bArr, DataOutputStream dataOutputStream) throws IOException {
        int i = 0;
        for (int i2 = 0; i2 < 32; i2++) {
            if (bArr[i2] != 0) {
                i = i2 + 1;
            }
        }
        dataOutputStream.writeByte(i);
        for (int i3 = 0; i3 < i; i3++) {
            dataOutputStream.writeByte(bArr[i3]);
        }
    }

    static List<v.b> a(byte[] bArr) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (bArr.length > i) {
            int readUnsignedByte = dataInputStream.readUnsignedByte();
            int readUnsignedByte2 = dataInputStream.readUnsignedByte();
            for (int i2 = 0; i2 < readUnsignedByte2; i2++) {
                int readUnsignedByte3 = dataInputStream.readUnsignedByte();
                for (int i3 = 0; i3 < 8; i3++) {
                    if (((readUnsignedByte3 >> i3) & 1) > 0) {
                        int i4 = (readUnsignedByte << 8) + (i2 << 3) + (7 - i3);
                        v.b a2 = v.b.a(i4);
                        if (a2 == v.b.UNKNOWN) {
                            a.warning("Skipping unknown type in type bitmap: " + i4);
                        } else {
                            arrayList.add(a2);
                        }
                    }
                }
            }
            i += readUnsignedByte2 + 2;
        }
        return arrayList;
    }
}
