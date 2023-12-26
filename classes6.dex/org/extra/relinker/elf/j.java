package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class j extends e {
    public j(i iVar, d dVar, long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(dVar.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = dVar.c + (j * ((long) dVar.e));
        this.a = iVar.e(allocate, j2);
        this.b = iVar.e(allocate, 4 + j2);
        this.c = iVar.e(allocate, 8 + j2);
        this.d = iVar.e(allocate, j2 + 20);
    }
}
