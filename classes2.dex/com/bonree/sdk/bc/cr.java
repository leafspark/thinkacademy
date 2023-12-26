package com.bonree.sdk.bc;

import com.facebook.soloader.MinElf;
import com.igexin.assist.sdk.AssistPushConsts;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.List;

public final class cr implements cd {
    private static int a = 53;
    private static int b = 1280;
    private static final short j = 512;
    private static String k = "localhost";
    private static int l;
    private InetSocketAddress c;
    private InetSocketAddress d;
    private boolean e;
    private boolean f;
    private bp g;
    private cx h;
    private long i;

    public cr(String str) throws UnknownHostException {
        InetAddress inetAddress;
        this.i = 10000;
        if (str == null && (str = ce.e().b()) == null) {
            str = k;
        }
        if (str.equals(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE)) {
            inetAddress = InetAddress.getLocalHost();
        } else {
            inetAddress = InetAddress.getByName(str);
        }
        this.c = new InetSocketAddress(inetAddress, 53);
    }

    public cr() throws UnknownHostException {
        this((String) null);
    }

    private InetSocketAddress a() {
        return this.c;
    }

    private static void a(String str) {
        k = str;
    }

    public final void a(int i2) {
        this.c = new InetSocketAddress(this.c.getAddress(), i2);
    }

    private void a(InetSocketAddress inetSocketAddress) {
        this.c = inetSocketAddress;
    }

    private void a(InetAddress inetAddress) {
        this.c = new InetSocketAddress(inetAddress, this.c.getPort());
    }

    private void b(InetSocketAddress inetSocketAddress) {
        this.d = inetSocketAddress;
    }

    private void b(InetAddress inetAddress) {
        this.d = new InetSocketAddress(inetAddress, 0);
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final void b(boolean z) {
        this.f = z;
    }

    public final void a(int i2, int i3, int i4, List list) {
        if (i2 == 0 || i2 == -1) {
            if (i3 == 0) {
                i3 = 1280;
            }
            this.g = new bp(i3, 0, i2, i4, list);
            return;
        }
        throw new IllegalArgumentException("invalid EDNS level - must be 0 or -1");
    }

    public final void b(int i2) {
        a(i2, 0, 0, (List) null);
    }

    public final void a(cx cxVar) {
        this.h = cxVar;
    }

    private cx b() {
        return this.h;
    }

    public final void a(int i2, int i3) {
        this.i = (((long) i2) * 1000) + ((long) i3);
    }

    public final void c(int i2) {
        a(5, 0);
    }

    private long c() {
        return this.i;
    }

    private static bb a(byte[] bArr) throws Cdo {
        try {
            return new bb(bArr);
        } catch (IOException e2) {
            e = e2;
            if (br.a("verbose")) {
                e.printStackTrace();
            }
            if (!(e instanceof Cdo)) {
                e = new Cdo("Error parsing message");
            }
            throw ((Cdo) e);
        }
    }

    private static void a(bb bbVar, bb bbVar2, byte[] bArr, cx cxVar) {
        if (cxVar != null) {
            int a2 = cxVar.a(bbVar2, bArr, bbVar.c());
            if (br.a("verbose")) {
                PrintStream printStream = System.err;
                printStream.println("TSIG verify: " + bz.b(a2));
            }
        }
    }

    private void b(bb bbVar) {
        if (this.g != null && bbVar.e() == null) {
            bbVar.a((ca) this.g, 3);
        }
    }

    private static int c(bb bbVar) {
        bp e2 = bbVar.e();
        if (e2 == null) {
            return 512;
        }
        return e2.d();
    }

    public final bb a(bb bbVar) throws IOException {
        int i2;
        byte[] bArr;
        bb a2;
        ca b2;
        if (br.a("verbose")) {
            System.err.println("Sending to " + this.c.getAddress().getHostAddress() + ":" + this.c.getPort());
        }
        if (bbVar.a().d() == 0 && (b2 = bbVar.b()) != null && b2.p() == 252) {
            return d(bbVar);
        }
        bb bbVar2 = (bb) bbVar.clone();
        if (this.g != null && bbVar2.e() == null) {
            bbVar2.a((ca) this.g, 3);
        }
        cx cxVar = this.h;
        if (cxVar != null) {
            cxVar.a(bbVar2, (cy) null);
        }
        byte[] c2 = bbVar2.c(MinElf.PN_XNUM);
        bp e2 = bbVar2.e();
        if (e2 == null) {
            i2 = 512;
        } else {
            i2 = e2.d();
        }
        int i3 = i2;
        long currentTimeMillis = System.currentTimeMillis() + this.i;
        boolean z = false;
        while (true) {
            boolean z2 = (this.e || c2.length > i3) ? true : z;
            if (z2) {
                bArr = cu.a(this.d, this.c, c2, currentTimeMillis);
            } else {
                bArr = di.a(this.d, this.c, c2, i3, currentTimeMillis);
            }
            if (bArr.length >= 12) {
                int i4 = ((bArr[0] & 255) << 8) + (bArr[1] & 255);
                int b3 = bbVar2.a().b();
                if (i4 != b3) {
                    String str = "invalid message id: expected " + b3 + "; got id " + i4;
                    if (!z2) {
                        if (br.a("verbose")) {
                            System.err.println(str);
                        }
                        z = z2;
                    } else {
                        throw new Cdo(str);
                    }
                } else {
                    a2 = a(bArr);
                    cx cxVar2 = this.h;
                    if (cxVar2 != null) {
                        int a3 = cxVar2.a(a2, bArr, bbVar2.c());
                        if (br.a("verbose")) {
                            System.err.println("TSIG verify: " + bz.b(a3));
                        }
                    }
                    if (z2 || this.f || !a2.a().b(6)) {
                        return a2;
                    }
                    z = true;
                }
            } else {
                throw new Cdo("invalid DNS header - too short");
            }
        }
        return a2;
    }

    public final Object a(bb bbVar, cf cfVar) {
        Integer num;
        synchronized (this) {
            int i2 = l;
            l = i2 + 1;
            num = new Integer(i2);
        }
        ca b2 = bbVar.b();
        String str = getClass() + ": " + (b2 != null ? b2.o().toString() : "(none)");
        cc ccVar = new cc(this, bbVar, num, cfVar);
        ccVar.setName(str);
        ccVar.setDaemon(true);
        ccVar.start();
        return num;
    }

    private bb d(bb bbVar) throws IOException {
        ds a2 = ds.a(bbVar.b().o(), (SocketAddress) this.c, this.h);
        a2.a((int) (this.i / 1000));
        a2.a((SocketAddress) this.d);
        try {
            a2.b();
            List<ca> d2 = a2.d();
            bb bbVar2 = new bb(bbVar.a().b());
            bbVar2.a().a(5);
            bbVar2.a().a(0);
            bbVar2.a(bbVar.b(), 0);
            for (ca a3 : d2) {
                bbVar2.a(a3, 1);
            }
            return bbVar2;
        } catch (dr e2) {
            throw new Cdo(e2.getMessage());
        }
    }
}
