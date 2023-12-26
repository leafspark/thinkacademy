package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class h extends d {
    private final i j;

    public h(boolean z, i iVar) {
        this.a = z;
        this.j = iVar;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.b = iVar.b(allocate, 16);
        this.c = iVar.c(allocate, 32);
        this.d = iVar.c(allocate, 40);
        this.e = iVar.b(allocate, 54);
        this.f = iVar.b(allocate, 56);
        this.g = iVar.b(allocate, 58);
        this.h = iVar.b(allocate, 60);
        this.i = iVar.b(allocate, 62);
    }

    public f a(int i) {
        return new m(this.j, this, i);
    }

    public e a(long j2) {
        return new k(this.j, this, j2);
    }

    public c a(long j2, int i) {
        return new b(this.j, this, j2, i);
    }
}
