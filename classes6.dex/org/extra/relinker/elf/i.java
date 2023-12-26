package org.extra.relinker.elf;

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
import okhttp3.internal.ws.WebSocketProtocol;

public class i implements Closeable {
    private final int a = 1179403647;
    private final FileChannel b;

    public i(File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.b = new FileInputStream(file).getChannel();
    }

    public d a() {
        this.b.position(0);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (e(allocate, 0) == 1179403647) {
            short a2 = a(allocate, 4);
            boolean z = a(allocate, 5) == 2;
            if (a2 == 1) {
                return new g(z, this);
            }
            if (a2 == 2) {
                return new h(z, this);
            }
            throw new IllegalStateException("Invalid class type!");
        }
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    public List b() {
        long j;
        this.b.position(0);
        ArrayList arrayList = new ArrayList();
        d a2 = a();
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(a2.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = (long) a2.f;
        int i = 0;
        if (j2 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            j2 = a2.a(0).a;
        }
        long j3 = 0;
        while (true) {
            if (j3 >= j2) {
                j = 0;
                break;
            }
            e a3 = a2.a(j3);
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
            c a4 = a2.a(j, i);
            long j5 = a4.a;
            if (j5 == 1) {
                arrayList2.add(Long.valueOf(a4.b));
            } else if (j5 == 5) {
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
                arrayList.add(d(allocate, longValue.longValue() + a5));
            }
            return arrayList;
        }
        throw new IllegalStateException("String table offset not found!");
    }

    /* access modifiers changed from: protected */
    public long c(ByteBuffer byteBuffer, long j) {
        a(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    public void close() {
        this.b.close();
    }

    /* access modifiers changed from: protected */
    public String d(ByteBuffer byteBuffer, long j) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short a2 = a(byteBuffer, j);
            if (a2 == 0) {
                return sb.toString();
            }
            sb.append((char) a2);
            j = j2;
        }
    }

    /* access modifiers changed from: protected */
    public long e(ByteBuffer byteBuffer, long j) {
        a(byteBuffer, j, 4);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    private long a(d dVar, long j, long j2) {
        for (long j3 = 0; j3 < j; j3++) {
            e a2 = dVar.a(j3);
            if (a2.a == 1) {
                long j4 = a2.c;
                if (j4 <= j2 && j2 <= a2.d + j4) {
                    return (j2 - j4) + a2.b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    /* access modifiers changed from: protected */
    public short a(ByteBuffer byteBuffer, long j) {
        a(byteBuffer, j, 1);
        return (short) (byteBuffer.get() & 255);
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
    public int b(ByteBuffer byteBuffer, long j) {
        a(byteBuffer, j, 2);
        return byteBuffer.getShort() & 65535;
    }
}
