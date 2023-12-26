package com.bonree.sdk.bc;

import com.bonree.sdk.ab.i;
import com.bonree.sdk.bc.dd;
import com.facebook.soloader.MinElf;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

public final class dn extends ca {
    private static final long a = -9104259763909119805L;
    private byte[] b;
    private int c;
    private int[] d;

    public static class a {
        private static int A = 28;
        private static int B = 29;
        private static int C = 30;
        private static int D = 31;
        private static int E = 32;
        private static int F = 33;
        private static int G = 62;
        private static int H = 64;
        private static int I = 65;
        private static int J = 66;
        private static int K = 67;
        private static int L = 69;
        private static int M = 71;
        private static int N = 76;
        private static int O = 78;
        private static int P = 79;
        private static bc Q = null;
        private static int a = 1;
        private static int b = 2;
        private static int c = 3;
        private static int d = 5;
        private static int e = 6;
        private static int f = 7;
        private static int g = 8;
        private static int h = 9;
        private static int i = 10;
        private static int j = 11;
        private static int k = 12;
        private static int l = 13;
        private static int m = 14;
        private static int n = 15;
        private static int o = 16;
        private static int p = 17;
        private static int q = 18;
        private static int r = 19;
        private static int s = 20;
        private static int t = 21;
        private static int u = 22;
        private static int v = 23;
        private static int w = 24;
        private static int x = 25;
        private static int y = 26;
        private static int z = 27;

        private a() {
        }

        static {
            bc bcVar = new bc("IP protocol", 3);
            Q = bcVar;
            bcVar.b(255);
            Q.a(true);
            Q.a(1, "icmp");
            Q.a(2, "igmp");
            Q.a(3, "ggp");
            Q.a(5, "st");
            Q.a(6, "tcp");
            Q.a(7, "ucl");
            Q.a(8, "egp");
            Q.a(9, "igp");
            Q.a(10, "bbn-rcc-mon");
            Q.a(11, "nvp-ii");
            Q.a(12, "pup");
            Q.a(13, "argus");
            Q.a(14, "emcon");
            Q.a(15, "xnet");
            Q.a(16, "chaos");
            Q.a(17, "udp");
            Q.a(18, "mux");
            Q.a(19, "dcn-meas");
            Q.a(20, "hmp");
            Q.a(21, "prm");
            Q.a(22, "xns-idp");
            Q.a(23, "trunk-1");
            Q.a(24, "trunk-2");
            Q.a(25, "leaf-1");
            Q.a(26, "leaf-2");
            Q.a(27, "rdp");
            Q.a(28, "irtp");
            Q.a(29, "iso-tp4");
            Q.a(30, "netblt");
            Q.a(31, "mfe-nsp");
            Q.a(32, "merit-inp");
            Q.a(33, "sep");
            Q.a(62, "cftp");
            Q.a(64, "sat-expak");
            Q.a(65, "mit-subnet");
            Q.a(66, "rvd");
            Q.a(67, "ippc");
            Q.a(69, "sat-mon");
            Q.a(71, "ipcv");
            Q.a(76, "br-sat-mon");
            Q.a(78, "wb-mon");
            Q.a(79, "wb-expak");
        }

        private static String a(int i2) {
            return Q.d(i2);
        }

        public static int a(String str) {
            return Q.b(str);
        }
    }

    public static class b {
        private static int A = 53;
        private static int B = 55;
        private static int C = 61;
        private static int D = 63;
        private static int E = 65;
        private static int F = 67;
        private static int G = 68;
        private static int H = 69;
        private static int I = 71;
        private static int J = 72;
        private static int K = 73;
        private static int L = 74;
        private static int M = 79;
        private static int N = 81;
        private static int O = 89;
        private static int P = 91;
        private static int Q = 93;
        private static int R = 95;
        private static int S = 97;
        private static int T = 98;
        private static int U = 99;
        private static int V = 101;
        private static int W = 102;
        private static int X = 103;
        private static int Y = 104;
        private static int Z = 105;
        private static int a = 5;
        private static int aA = 245;
        private static bc aB = null;
        private static int aa = 107;
        private static int ab = 109;
        private static int ac = 111;
        private static int ad = 113;
        private static int ae = 115;
        private static int af = 117;
        private static int ag = 119;
        private static int ah = 121;
        private static int ai = 123;
        private static int aj = 125;
        private static int ak = 127;
        private static int al = 129;
        private static int am = 130;
        private static int an = 131;
        private static int ao = 132;
        private static int ap = 133;
        private static int aq = 134;
        private static int ar = 135;
        private static int as = 136;
        private static int at = 137;
        private static int au = 138;
        private static int av = 139;
        private static int aw = 140;
        private static int ax = 141;
        private static int ay = 142;
        private static int az = 243;
        private static int b = 7;
        private static int c = 9;
        private static int d = 11;
        private static int e = 13;
        private static int f = 17;
        private static int g = 19;
        private static int h = 20;
        private static int i = 21;
        private static int j = 23;
        private static int k = 25;
        private static int l = 27;
        private static int m = 29;
        private static int n = 31;
        private static int o = 33;
        private static int p = 37;
        private static int q = 39;
        private static int r = 41;
        private static int s = 42;
        private static int t = 43;
        private static int u = 44;
        private static int v = 45;
        private static int w = 46;
        private static int x = 47;
        private static int y = 49;
        private static int z = 51;

        private b() {
        }

        static {
            bc bcVar = new bc("TCP/UDP service", 3);
            aB = bcVar;
            bcVar.b((int) MinElf.PN_XNUM);
            aB.a(true);
            aB.a(5, "rje");
            aB.a(7, "echo");
            aB.a(9, "discard");
            aB.a(11, "users");
            aB.a(13, "daytime");
            aB.a(17, "quote");
            aB.a(19, "chargen");
            aB.a(20, "ftp-data");
            aB.a(21, "ftp");
            aB.a(23, "telnet");
            aB.a(25, "smtp");
            aB.a(27, "nsw-fe");
            aB.a(29, "msg-icp");
            aB.a(31, "msg-auth");
            aB.a(33, "dsp");
            aB.a(37, "time");
            aB.a(39, "rlp");
            aB.a(41, "graphics");
            aB.a(42, "nameserver");
            aB.a(43, "nicname");
            aB.a(44, "mpm-flags");
            aB.a(45, "mpm");
            aB.a(46, "mpm-snd");
            aB.a(47, "ni-ftp");
            aB.a(49, FirebaseAnalytics.Event.LOGIN);
            aB.a(51, "la-maint");
            aB.a(53, "domain");
            aB.a(55, "isi-gl");
            aB.a(61, "ni-mail");
            aB.a(63, "via-ftp");
            aB.a(65, "tacacs-ds");
            aB.a(67, "bootps");
            aB.a(68, "bootpc");
            aB.a(69, "tftp");
            aB.a(71, "netrjs-1");
            aB.a(72, "netrjs-2");
            aB.a(73, "netrjs-3");
            aB.a(74, "netrjs-4");
            aB.a(79, "finger");
            aB.a(81, "hosts2-ns");
            aB.a(89, "su-mit-tg");
            aB.a(91, "mit-dov");
            aB.a(93, "dcp");
            aB.a(95, "supdup");
            aB.a(97, "swift-rvf");
            aB.a(98, "tacnews");
            aB.a(99, "metagram");
            aB.a(101, "hostname");
            aB.a(102, "iso-tsap");
            aB.a(103, "x400");
            aB.a(104, "x400-snd");
            aB.a(105, "csnet-ns");
            aB.a(107, "rtelnet");
            aB.a(109, "pop-2");
            aB.a(111, "sunrpc");
            aB.a(113, "auth");
            aB.a(115, "sftp");
            aB.a(117, "uucp-path");
            aB.a(119, "nntp");
            aB.a(121, "erpc");
            aB.a(123, "ntp");
            aB.a(125, "locus-map");
            aB.a(127, "locus-con");
            aB.a(129, "pwdgen");
            aB.a(130, "cisco-fna");
            aB.a(131, "cisco-tna");
            aB.a(132, "cisco-sys");
            aB.a(133, "statsrv");
            aB.a(134, "ingres-net");
            aB.a(135, "loc-srv");
            aB.a(136, Scopes.PROFILE);
            aB.a(137, "netbios-ns");
            aB.a(138, "netbios-dgm");
            aB.a(139, "netbios-ssn");
            aB.a(140, "emfis-data");
            aB.a(141, "emfis-cntl");
            aB.a(142, "bl-idm");
            aB.a(243, "sur-meas");
            aB.a(245, "link");
        }

        private static String a(int i2) {
            return aB.d(i2);
        }

        public static int a(String str) {
            return aB.b(str);
        }
    }

    dn() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new dn();
    }

    private dn(bn bnVar, int i, long j, InetAddress inetAddress, int i2, int[] iArr) {
        super(bnVar, 11, i, j);
        if (i.a(inetAddress) == 1) {
            this.b = inetAddress.getAddress();
            this.c = a("protocol", i2);
            for (int b2 : iArr) {
                b("service", b2);
            }
            int[] iArr2 = new int[iArr.length];
            this.d = iArr2;
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            Arrays.sort(this.d);
            return;
        }
        throw new IllegalArgumentException("invalid IPv4 address");
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = tVar.d(4);
        this.c = tVar.g();
        byte[] j = tVar.j();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < j.length; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                if ((j[i] & 255 & (1 << (7 - i2))) != 0) {
                    arrayList.add(new Integer((i << 3) + i2));
                }
            }
        }
        this.d = new int[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            this.d[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        byte[] a2 = i.a(ddVar.c(), 1);
        this.b = a2;
        if (a2 != null) {
            String c2 = ddVar.c();
            int a3 = a.a(c2);
            this.c = a3;
            if (a3 >= 0) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    dd.a a4 = ddVar.a();
                    if (a4.a()) {
                        int a5 = b.a(a4.b);
                        if (a5 >= 0) {
                            arrayList.add(Integer.valueOf(a5));
                        } else {
                            throw ddVar.a("Invalid TCP/UDP service: " + a4.b);
                        }
                    } else {
                        ddVar.b();
                        this.d = new int[arrayList.size()];
                        for (int i = 0; i < arrayList.size(); i++) {
                            this.d[i] = ((Integer) arrayList.get(i)).intValue();
                        }
                        return;
                    }
                }
            } else {
                throw ddVar.a("Invalid IP protocol: " + c2);
            }
        } else {
            throw ddVar.a("invalid address");
        }
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i.a(this.b));
        stringBuffer.append(" ");
        stringBuffer.append(this.c);
        for (int i = 0; i < this.d.length; i++) {
            stringBuffer.append(" " + this.d[i]);
        }
        return stringBuffer.toString();
    }

    private InetAddress d() {
        try {
            return InetAddress.getByAddress(this.b);
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    private int e() {
        return this.c;
    }

    private int[] f() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.a(this.b);
        vVar.b(this.c);
        int[] iArr = this.d;
        byte[] bArr = new byte[((iArr[iArr.length - 1] / 8) + 1)];
        int i = 0;
        while (true) {
            int[] iArr2 = this.d;
            if (i < iArr2.length) {
                int i2 = iArr2[i];
                int i3 = i2 / 8;
                bArr[i3] = (byte) ((1 << (7 - (i2 % 8))) | bArr[i3]);
                i++;
            } else {
                vVar.a(bArr);
                return;
            }
        }
    }
}
