package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class g extends d {
    private final i j;

    public g(boolean z, i iVar) {
        this.a = z;
        this.j = iVar;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.b = iVar.b(allocate, 16);
        this.c = iVar.e(allocate, 28);
        this.d = iVar.e(allocate, 32);
        this.e = iVar.b(allocate, 42);
        this.f = iVar.b(allocate, 44);
        this.g = iVar.b(allocate, 46);
        this.h = iVar.b(allocate, 48);
        this.i = iVar.b(allocate, 50);
    }

    public f a(int i) {
        return new l(this.j, this, i);
    }

    public e a(long j2) {
        return new j(this.j, this, j2);
    }

    public c a(long j2, int i) {
        return new a(this.j, this, j2, i);
    }
}
