package com.bonree.sdk.bk;

public abstract class b extends IllegalStateException {
    private static final long b = 1;
    protected final String a;

    protected b(String str) {
        this.a = str;
    }

    /* renamed from: com.bonree.sdk.bk.b$b  reason: collision with other inner class name */
    public static class C0015b extends b {
        private static final long b = 1;
        private final String c;

        public C0015b(String str, String str2) {
            super(str);
            this.c = str2;
        }

        public final String getMessage() {
            StringBuilder sb = new StringBuilder("The DNS name '");
            sb.append(this.a);
            sb.append("' contains the label '");
            sb.append(this.c);
            sb.append("' which exceeds the maximum label length of 63");
            sb.append(" octets by ");
            sb.append(this.c.length() - 63);
            sb.append(" octets.");
            return sb.toString();
        }
    }

    public static class a extends b {
        private static final long b = 1;
        private final byte[] c;

        public a(String str, byte[] bArr) {
            super(str);
            this.c = bArr;
        }

        public final String getMessage() {
            StringBuilder sb = new StringBuilder("The DNS name '");
            sb.append(this.a);
            sb.append("' exceeds the maximum name length of 255");
            sb.append(" octets by ");
            sb.append(this.c.length - 255);
            sb.append(" octets.");
            return sb.toString();
        }
    }
}
