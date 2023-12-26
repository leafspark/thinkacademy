package com.bonree.sdk.bc;

import com.bonree.sdk.agent.engine.webview.entity.WebViewRouteChangeEvent;
import java.util.HashMap;

public final class df {
    private static int A = 27;
    private static int B = 28;
    private static int C = 29;
    private static int D = 30;
    private static int E = 31;
    private static int F = 32;
    private static int G = 33;
    private static int H = 34;
    private static int I = 35;
    private static int J = 36;
    private static int K = 37;
    private static int L = 38;
    private static int M = 39;
    private static int N = 41;
    private static int O = 42;
    private static int P = 43;
    private static int Q = 44;
    private static int R = 45;
    private static int S = 46;
    private static int T = 47;
    private static int U = 48;
    private static int V = 49;
    private static int W = 50;
    private static int X = 51;
    private static int Y = 52;
    private static int Z = 99;
    private static int a = 1;
    private static int aa = 249;
    private static int ab = 250;
    private static int ac = 251;
    private static int ad = 252;
    private static int ae = 253;
    private static int af = 254;
    private static int ag = 255;
    private static int ah = 256;
    private static int ai = 32769;
    private static a aj = null;
    private static int b = 2;
    private static int c = 3;
    private static int d = 4;
    private static int e = 5;
    private static int f = 6;
    private static int g = 7;
    private static int h = 8;
    private static int i = 9;
    private static int j = 10;
    private static int k = 11;
    private static int l = 12;
    private static int m = 13;
    private static int n = 14;
    private static int o = 15;
    private static int p = 16;
    private static int q = 17;
    private static int r = 18;
    private static int s = 19;
    private static int t = 20;
    private static int u = 21;
    private static int v = 22;
    private static int w = 23;
    private static int x = 24;
    private static int y = 25;
    private static int z = 26;

    public static boolean d(int i2) {
        if (i2 == 41) {
            return false;
        }
        switch (i2) {
            case 249:
            case 250:
            case 251:
            case 252:
            case 253:
            case 254:
            case 255:
                return false;
            default:
                return true;
        }
    }

    static class a extends bc {
        private HashMap a = new HashMap();

        public a() {
            super("Type", 2);
            a("TYPE");
        }

        public final void a(int i, String str, ca caVar) {
            super.a(i, str);
            this.a.put(bc.c(i), caVar);
        }

        public final void a(int i) {
            df.a(i);
        }

        public final ca e(int i) {
            df.a(i);
            return (ca) this.a.get(c(i));
        }
    }

    static {
        a aVar = new a();
        aj = aVar;
        aVar.a(1, "A", new f());
        aj.a(2, "NS", new bk());
        aj.a(3, "MD", new au());
        aj.a(4, "MF", new av());
        aj.a(5, "CNAME", new i());
        aj.a(6, "SOA", new ck());
        aj.a(7, "MB", new at());
        aj.a(8, "MG", new aw());
        aj.a(9, "MR", new ay());
        aj.a(10, "NULL", new bl());
        aj.a(11, "WKS", new dn());
        aj.a(12, "PTR", new bs());
        aj.a(13, "HINFO", new ah());
        aj.a(14, "MINFO", new ax());
        aj.a(15, "MX", new az());
        aj.a(16, "TXT", new db());
        aj.a(17, "RP", new bv());
        aj.a(18, "AFSDB", new c());
        aj.a(19, "X25", new dp());
        aj.a(20, "ISDN", new ak());
        aj.a(21, "RT", new by());
        aj.a(22, "NSAP", new be());
        aj.a(23, "NSAP-PTR", new bf());
        aj.a(24, "SIG", new cj());
        aj.a(25, "KEY", new ap());
        aj.a(26, "PX", new bt());
        aj.a(27, "GPOS", new ae());
        aj.a(28, "AAAA", new b());
        aj.a(29, "LOC", new ar());
        aj.a(30, "NXT", new bm());
        aj.a(31, "EID");
        aj.a(32, "NIMLOC");
        aj.a(33, "SRV", new cm());
        aj.a(34, "ATMA");
        aj.a(35, "NAPTR", new bd());
        aj.a(36, "KX", new aq());
        aj.a(37, "CERT", new h());
        aj.a(38, "A6", new a());
        aj.a(39, "DNAME", new s());
        aj.a(41, "OPT", new bp());
        aj.a(42, "APL", new d());
        aj.a(43, "DS", new x());
        aj.a(44, "SSHFP", new cn());
        aj.a(45, "IPSECKEY", new aj());
        aj.a(46, "RRSIG", new bw());
        aj.a(47, "NSEC", new bi());
        aj.a(48, "DNSKEY", new u());
        aj.a(49, "DHCID", new q());
        aj.a(50, "NSEC3", new bh());
        aj.a(51, "NSEC3PARAM", new bg());
        aj.a(52, "TLSA", new cw());
        aj.a(99, "SPF", new cl());
        aj.a(249, "TKEY", new cv());
        aj.a(250, "TSIG", new cy());
        aj.a(251, "IXFR");
        aj.a(252, "AXFR");
        aj.a(253, "MAILB");
        aj.a(254, "MAILA");
        aj.a(255, "ANY");
        aj.a(WebViewRouteChangeEvent.ROUTE_CHANGE_String_LIMIT, "URI", new dl());
        aj.a(32769, "DLV", new r());
    }

    private df() {
    }

    public static void a(int i2) {
        if (i2 < 0 || i2 > 65535) {
            throw new an(i2);
        }
    }

    public static String b(int i2) {
        return aj.d(i2);
    }

    public static int a(String str, boolean z2) {
        int b2 = aj.b(str);
        if (b2 != -1 || !z2) {
            return b2;
        }
        a aVar = aj;
        return aVar.b("TYPE" + str);
    }

    public static int a(String str) {
        return a(str, false);
    }

    static ca c(int i2) {
        return aj.e(i2);
    }
}
