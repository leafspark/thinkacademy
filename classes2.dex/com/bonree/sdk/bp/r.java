package com.bonree.sdk.bp;

import com.bonree.sdk.bn.c;
import com.bonree.sdk.bp.v;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class r extends h {
    private static /* synthetic */ boolean b = true;
    public final List<c> a;

    public r() {
        this(Collections.emptyList());
    }

    public r(List<c> list) {
        this.a = Collections.unmodifiableList(list);
    }

    public static r a(DataInputStream dataInputStream, int i) throws IOException {
        List list;
        if (i == 0) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList = new ArrayList(4);
            while (i > 0) {
                int readUnsignedShort = dataInputStream.readUnsignedShort();
                int readUnsignedShort2 = dataInputStream.readUnsignedShort();
                byte[] bArr = new byte[readUnsignedShort2];
                dataInputStream.read(bArr);
                arrayList.add(c.a(readUnsignedShort, bArr));
                i -= readUnsignedShort2 + 4;
                if (!b && i < 0) {
                    throw new AssertionError();
                }
            }
            list = arrayList;
        }
        return new r(list);
    }

    public final v.b a() {
        return v.b.OPT;
    }

    /* access modifiers changed from: protected */
    public final void a(DataOutputStream dataOutputStream) throws IOException {
        for (c a2 : this.a) {
            a2.a(dataOutputStream);
        }
    }
}
