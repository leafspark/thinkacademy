package com.bonree.sdk.bh;

import java.util.HashMap;
import java.util.Map;

public final class b {
    /* access modifiers changed from: private */
    public static final Map<Byte, C0013b> a = new HashMap();
    /* access modifiers changed from: private */
    public static final Map<Byte, a> b = new HashMap();

    private b() {
    }

    /* renamed from: com.bonree.sdk.bh.b$b  reason: collision with other inner class name */
    public enum C0013b {
        RSAMD5(1, "RSA/MD5"),
        DH(2, "Diffie-Hellman"),
        DSA(3, "DSA/SHA1"),
        RSASHA1(5, "RSA/SHA-1"),
        DSA_NSEC3_SHA1(6, "DSA_NSEC3-SHA1"),
        RSASHA1_NSEC3_SHA1(7, "RSASHA1-NSEC3-SHA1"),
        RSASHA256(8, "RSA/SHA-256"),
        RSASHA512(10, "RSA/SHA-512"),
        ECC_GOST(12, "GOST R 34.10-2001"),
        ECDSAP256SHA256(13, "ECDSA Curve P-256 with SHA-256"),
        ECDSAP384SHA384(14, "ECDSA Curve P-384 with SHA-384"),
        INDIRECT(252, "Reserved for Indirect Keys"),
        PRIVATEDNS(253, "private algorithm"),
        PRIVATEOID(254, "private algorithm oid");
        
        public final String description;
        public final byte number;

        private C0013b(int i, String str) {
            if (i < 0 || i > 255) {
                throw new IllegalArgumentException();
            }
            byte b = (byte) i;
            this.number = b;
            this.description = str;
            b.a.put(Byte.valueOf(b), this);
        }

        public static C0013b a(byte b) {
            return (C0013b) b.a.get(Byte.valueOf(b));
        }
    }

    public enum a {
        SHA1(1, "SHA-1"),
        SHA256(2, "SHA-256"),
        GOST(3, "GOST R 34.11-94"),
        SHA384(4, "SHA-384");
        
        public final String description;
        public final byte value;

        private a(int i, String str) {
            if (i < 0 || i > 255) {
                throw new IllegalArgumentException();
            }
            byte b = (byte) i;
            this.value = b;
            this.description = str;
            b.b.put(Byte.valueOf(b), this);
        }

        public static a a(byte b) {
            return (a) b.b.get(Byte.valueOf(b));
        }
    }
}
