package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class b extends c {
    public b(i iVar, d dVar, long j, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(dVar.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + ((long) (i * 16));
        this.a = iVar.c(allocate, j2);
        this.b = iVar.c(allocate, j2 + 8);
    }
}
