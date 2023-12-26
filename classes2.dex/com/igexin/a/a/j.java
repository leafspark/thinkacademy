package com.igexin.a.a;

import com.facebook.soloader.MinElf;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class j implements c, Closeable {
    private final int a = MinElf.ELF_MAGIC;
    private final FileChannel b;

    public j(File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.b = new FileInputStream(file).getChannel();
    }

    private long a(e eVar, long j, long j2) {
        for (long j3 = 0; j3 < j; j3++) {
            f a2 = eVar.a(j3);
            if (a2.a == 1 && a2.c <= j2 && j2 <= a2.c + a2.d) {
                return (j2 - a2.c) + a2.b;
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public e a() {
        this.b.position(0);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (c(allocate, 0) == 1179403647) {
            short e = e(allocate, 4);
            boolean z = e(allocate, 5) == 2;
            if (e == 1) {
                return new h(z, this);
            }
            if (e == 2) {
                return new i(z, this);
            }
            throw new IllegalStateException("Invalid class type!");
        }
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    /* access modifiers changed from: protected */
    public String a(ByteBuffer byteBuffer, long j) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short e = e(byteBuffer, j);
            if (e == 0) {
                return sb.toString();
            }
            sb.append((char) e);
            j = j2;
        }
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer, long j, int i) {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        long j2 = 0;
        while (j2 < ((long) i)) {
            int read = this.b.read(byteBuffer, j + j2);
            if (read != -1) {
                j2 += (long) read;
            } else {
                throw new EOFException();
            }
        }
        byteBuffer.position(0);
    }

    /* access modifiers changed from: protected */
    public long b(ByteBuffer byteBuffer, long j) {
        a(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    public List<String> b() {
        long j;
        this.b.position(0);
        ArrayList arrayList = new ArrayList();
        e a2 = a();
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(a2.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = (long) a2.f;
        int i = 0;
        if (j2 == 65535) {
            j2 = a2.a(0).a;
        }
        long j3 = 0;
        while (true) {
            if (j3 >= j2) {
                j = 0;
                break;
            }
            f a3 = a2.a(j3);
            if (a3.a == 2) {
                j = a3.b;
                break;
            }
            j3++;
        }
        if (j == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList<Long> arrayList2 = new ArrayList<>();
        long j4 = 0;
        while (true) {
            d a4 = a2.a(j, i);
            if (a4.a == 1) {
                arrayList2.add(Long.valueOf(a4.b));
            } else if (a4.a == 5) {
                j4 = a4.b;
            }
            i++;
            if (a4.a == 0) {
                break;
            }
        }
        if (j4 != 0) {
            long a5 = a(a2, j2, j4);
            for (Long longValue : arrayList2) {
                arrayList.add(a(allocate, longValue.longValue() + a5));
            }
            return arrayList;
        }
        throw new IllegalStateException("String table offset not found!");
    }

    /* access modifiers changed from: protected */
    public long c(ByteBuffer byteBuffer, long j) {
        a(byteBuffer, j, 4);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    public void close() {
        this.b.close();
    }

    /* access modifiers changed from: protected */
    public int d(ByteBuffer byteBuffer, long j) {
        a(byteBuffer, j, 2);
        return byteBuffer.getShort() & 65535;
    }

    /* access modifiers changed from: protected */
    public short e(ByteBuffer byteBuffer, long j) {
        a(byteBuffer, j, 1);
        return (short) (byteBuffer.get() & 255);
    }
}
