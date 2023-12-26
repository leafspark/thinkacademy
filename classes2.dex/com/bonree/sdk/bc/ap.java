package com.bonree.sdk.bc;

import com.bonree.sdk.agent.engine.webview.entity.WebViewRouteChangeEvent;
import com.bonree.sdk.bc.w;
import com.facebook.soloader.MinElf;
import com.google.protobuf.CodedOutputStream;
import com.luck.picture.lib.tools.PictureFileUtils;
import java.io.IOException;
import java.security.PublicKey;
import java.util.StringTokenizer;

public final class ap extends ao {
    private static final long j = 6385613447571488906L;
    private static int k = 16384;
    private static int l = 32768;
    private static int m = 49152;
    private static int n = 256;
    private static int o = 512;
    private static int p = 0;
    private static int q = 1;
    private static int r = 2;
    private static int s = 3;
    private static int t = 4;
    private static int u = 255;

    public final /* bridge */ /* synthetic */ int d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ byte[] e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ int f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ PublicKey f_() throws w.b {
        return super.f_();
    }

    public final /* bridge */ /* synthetic */ int g() {
        return super.g();
    }

    public final /* bridge */ /* synthetic */ int h() {
        return super.h();
    }

    public static class b {
        private static int a = 0;
        private static int b = 1;
        private static int c = 2;
        private static int d = 3;
        private static int e = 4;
        private static int f = 255;
        private static bc g;

        private b() {
        }

        static {
            bc bcVar = new bc("KEY protocol", 2);
            g = bcVar;
            bcVar.b(255);
            g.a(true);
            g.a(0, "NONE");
            g.a(1, "TLS");
            g.a(2, "EMAIL");
            g.a(3, "DNSSEC");
            g.a(4, "IPSEC");
            g.a(255, "ANY");
        }

        private static String a(int i) {
            return g.d(i);
        }

        public static int a(String str) {
            return g.b(str);
        }
    }

    public static class a {
        private static int A = 9;
        private static int B = 10;
        private static int C = 11;
        private static int D = 12;
        private static int E = 13;
        private static int F = 14;
        private static int G = 15;
        private static bc H = null;
        private static int a = 16384;
        private static int b = 32768;
        private static int c = 49152;
        private static int d = 49152;
        private static int e = 8192;
        private static int f = 4096;
        private static int g = 2048;
        private static int h = 1024;
        private static int i = 0;
        private static int j = 256;
        private static int k = 512;
        private static int l = 768;
        private static int m = 768;
        private static int n = 128;
        private static int o = 64;
        private static int p = 32;
        private static int q = 16;
        private static int r = 0;
        private static int s = 1;
        private static int t = 2;
        private static int u = 3;
        private static int v = 4;
        private static int w = 5;
        private static int x = 6;
        private static int y = 7;
        private static int z = 8;

        private a() {
        }

        static {
            bc bcVar = new bc("KEY flags", 2);
            H = bcVar;
            bcVar.b((int) MinElf.PN_XNUM);
            H.a(false);
            H.a(16384, "NOCONF");
            H.a(32768, "NOAUTH");
            H.a(49152, "NOKEY");
            H.a(8192, "FLAG2");
            H.a(CodedOutputStream.DEFAULT_BUFFER_SIZE, "EXTEND");
            H.a(2048, "FLAG4");
            H.a(PictureFileUtils.KB, "FLAG5");
            H.a(0, "USER");
            H.a(WebViewRouteChangeEvent.ROUTE_CHANGE_String_LIMIT, "ZONE");
            H.a(512, "HOST");
            H.a(768, "NTYP3");
            H.a(128, "FLAG8");
            H.a(64, "FLAG9");
            H.a(32, "FLAG10");
            H.a(16, "FLAG11");
            H.a(0, "SIG0");
            H.a(1, "SIG1");
            H.a(2, "SIG2");
            H.a(3, "SIG3");
            H.a(4, "SIG4");
            H.a(5, "SIG5");
            H.a(6, "SIG6");
            H.a(7, "SIG7");
            H.a(8, "SIG8");
            H.a(9, "SIG9");
            H.a(10, "SIG10");
            H.a(11, "SIG11");
            H.a(12, "SIG12");
            H.a(13, "SIG13");
            H.a(14, "SIG14");
            H.a(15, "SIG15");
        }

        public static int a(String str) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt < 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
                StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
                int i2 = 0;
                while (stringTokenizer.hasMoreTokens()) {
                    int b2 = H.b(stringTokenizer.nextToken());
                    if (b2 < 0) {
                        return -1;
                    }
                    i2 |= b2;
                }
                return i2;
            }
        }
    }

    ap() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new ap();
    }

    private ap(bn bnVar, int i, long j2, int i2, int i3, int i4, byte[] bArr) {
        super(bnVar, 25, i, j2, i2, i3, i4, bArr);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ap(com.bonree.sdk.bc.bn r12, int r13, long r14, int r16, int r17, int r18, java.security.PublicKey r19) throws com.bonree.sdk.bc.w.b {
        /*
            r11 = this;
            r8 = r18
            r10 = r19
            byte[] r9 = com.bonree.sdk.bc.w.a((java.security.PublicKey) r10, (int) r8)
            r2 = 25
            r0 = r11
            r1 = r12
            r3 = r13
            r4 = r14
            r6 = r16
            r7 = r17
            r0.<init>(r1, r2, r3, r4, r6, r7, r8, r9)
            r0.e = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.ap.<init>(com.bonree.sdk.bc.bn, int, long, int, int, int, java.security.PublicKey):void");
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        String d = ddVar.d();
        this.a = a.a(d);
        if (this.a >= 0) {
            String d2 = ddVar.d();
            this.b = b.a(d2);
            if (this.b >= 0) {
                String d3 = ddVar.d();
                this.c = w.a.a(d3);
                if (this.c < 0) {
                    throw ddVar.a("Invalid algorithm: " + d3);
                } else if ((this.a & 49152) == 49152) {
                    this.d = null;
                } else {
                    this.d = ddVar.l();
                }
            } else {
                throw ddVar.a("Invalid protocol: " + d2);
            }
        } else {
            throw ddVar.a("Invalid flags: " + d);
        }
    }
}
