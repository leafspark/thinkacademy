package com.bonree.sdk.bf;

import java.io.IOException;

public abstract class h extends IOException {
    private static final long a = 1;

    protected h(String str) {
        super(str);
    }

    public static class b extends h {
        private static final long a = 1;
        private static /* synthetic */ boolean d = true;
        private final com.bonree.sdk.bj.a b;
        private final com.bonree.sdk.bj.a c;

        static {
            Class<h> cls = h.class;
        }

        private com.bonree.sdk.bj.a a() {
            return this.b;
        }

        private com.bonree.sdk.bj.a b() {
            return this.c;
        }

        private static String a(com.bonree.sdk.bj.a aVar, com.bonree.sdk.bj.a aVar2) {
            return "The response's ID doesn't matches the request ID. Request: " + aVar.a + ". Response: " + aVar2.a;
        }

        public b(com.bonree.sdk.bj.a aVar, com.bonree.sdk.bj.a aVar2) {
            super("The response's ID doesn't matches the request ID. Request: " + aVar.a + ". Response: " + aVar2.a);
            if (d || aVar.a != aVar2.a) {
                this.b = aVar;
                this.c = aVar2;
                return;
            }
            throw new AssertionError();
        }
    }

    public static class d extends h {
        private static final long a = 1;
        private final com.bonree.sdk.bj.a b;

        private d(com.bonree.sdk.bj.a aVar) {
            super("The request yielded a 'null' result while resolving.");
            this.b = aVar;
        }

        private com.bonree.sdk.bj.a a() {
            return this.b;
        }
    }

    public static class a extends h {
        private static final long a = 1;
        private final com.bonree.sdk.bj.a b;
        private final com.bonree.sdk.bl.c c;

        public a(com.bonree.sdk.bj.a aVar, com.bonree.sdk.bl.c cVar) {
            super("Received " + cVar.a.c + " error response\n" + cVar);
            this.b = aVar;
            this.c = cVar;
        }

        private com.bonree.sdk.bj.a a() {
            return this.b;
        }

        private com.bonree.sdk.bl.c b() {
            return this.c;
        }
    }

    public static class c extends h {
        private static final long a = 1;
        private final com.bonree.sdk.bj.a b;

        public c(com.bonree.sdk.bj.a aVar) {
            super("No DNS server could be queried");
            this.b = aVar;
        }

        private com.bonree.sdk.bj.a a() {
            return this.b;
        }
    }
}
