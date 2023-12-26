package com.bonree.sdk.bc;

import java.io.PrintStream;

public final class m {
    private static final int a = 17;
    private static final int b = 16383;
    private a[] c = new a[17];
    private boolean d = br.a("verbosecompression");

    static class a {
        bn a;
        int b;
        a c;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void a(int i, bn bnVar) {
        if (i <= b) {
            int hashCode = (bnVar.hashCode() & Integer.MAX_VALUE) % 17;
            a aVar = new a((byte) 0);
            aVar.a = bnVar;
            aVar.b = i;
            aVar.c = this.c[hashCode];
            this.c[hashCode] = aVar;
            if (this.d) {
                PrintStream printStream = System.err;
                printStream.println("Adding " + bnVar + " at " + i);
            }
        }
    }

    public final int a(bn bnVar) {
        int i = -1;
        for (a aVar = this.c[(bnVar.hashCode() & Integer.MAX_VALUE) % 17]; aVar != null; aVar = aVar.c) {
            if (aVar.a.equals(bnVar)) {
                i = aVar.b;
            }
        }
        if (this.d) {
            PrintStream printStream = System.err;
            printStream.println("Looking for " + bnVar + ", found " + i);
        }
        return i;
    }
}
