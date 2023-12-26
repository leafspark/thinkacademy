package com.bonree.sdk.bp;

import com.bonree.sdk.bp.v;
import com.bumptech.glide.load.Key;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class aa extends h {
    private final byte[] a;
    private transient String b;
    private transient List<String> c;

    public static aa a(DataInputStream dataInputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        dataInputStream.readFully(bArr);
        return new aa(bArr);
    }

    public aa(byte[] bArr) {
        this.a = bArr;
    }

    private byte[] d() {
        return (byte[]) this.a.clone();
    }

    private String e() {
        if (this.b == null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = f().iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                if (it.hasNext()) {
                    sb.append(" / ");
                }
            }
            this.b = sb.toString();
        }
        return this.b;
    }

    private List<String> f() {
        if (this.c == null) {
            ArrayList<byte[]> arrayList = new ArrayList<>();
            int i = 0;
            while (true) {
                byte[] bArr = this.a;
                if (i >= bArr.length) {
                    break;
                }
                int i2 = i + 1;
                int i3 = (bArr[i] & 255) + i2;
                arrayList.add(Arrays.copyOfRange(bArr, i2, i3));
                i = i3;
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            for (byte[] str : arrayList) {
                try {
                    arrayList2.add(new String(str, Key.STRING_CHARSET_NAME));
                } catch (UnsupportedEncodingException e) {
                    throw new AssertionError(e);
                }
            }
            this.c = Collections.unmodifiableList(arrayList2);
        }
        return this.c;
    }

    private List<byte[]> g() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            byte[] bArr = this.a;
            if (i >= bArr.length) {
                return arrayList;
            }
            int i2 = i + 1;
            int i3 = (bArr[i] & 255) + i2;
            arrayList.add(Arrays.copyOfRange(bArr, i2, i3));
            i = i3;
        }
    }

    public final void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.a);
    }

    public final v.b a() {
        return v.b.TXT;
    }

    public final String toString() {
        return "\"" + e() + "\"";
    }
}
