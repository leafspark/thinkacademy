package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class k extends e {
    public k(i iVar, d dVar, long j) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(dVar.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = dVar.c + (j * ((long) dVar.e));
        this.a = iVar.e(allocate, j2);
        this.b = iVar.c(allocate, 8 + j2);
        this.c = iVar.c(allocate, 16 + j2);
        this.d = iVar.c(allocate, j2 + 40);
    }
}
