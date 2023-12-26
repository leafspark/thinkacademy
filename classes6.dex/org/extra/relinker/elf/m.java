package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class m extends f {
    public m(i iVar, d dVar, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(dVar.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.a = iVar.e(allocate, dVar.d + ((long) (i * dVar.g)) + 44);
    }
}
