package com.bonree.sdk.bq;

import com.bonree.sdk.bf.d;
import com.bonree.sdk.bf.i;
import com.bonree.sdk.bl.c;
import com.luck.picture.lib.tools.PictureFileUtils;
import java.io.IOException;
import java.net.InetAddress;

public abstract class a implements b {
    protected int a = PictureFileUtils.KB;
    protected int b = 5000;
    private d c;
    private C0017a d = C0017a.dontCare;

    /* renamed from: com.bonree.sdk.bq.a$a  reason: collision with other inner class name */
    public enum C0017a {
        dontCare,
        udpTcp,
        tcp
    }

    private void a(com.bonree.sdk.bj.a aVar, c cVar) {
    }

    public abstract c a(com.bonree.sdk.bj.a aVar, InetAddress inetAddress, int i) throws IOException;

    public final i<c, IOException> b(com.bonree.sdk.bj.a aVar, InetAddress inetAddress, int i) {
        i.b bVar = new i.b();
        try {
            bVar.b(a(aVar, inetAddress, i));
            return bVar;
        } catch (IOException e) {
            bVar.a(e);
            return bVar;
        }
    }

    public final int a() {
        return this.b;
    }

    public final void a(int i) {
        if (i > 0) {
            this.b = i;
            return;
        }
        throw new IllegalArgumentException("Timeout must be greater than zero");
    }

    public final int b() {
        return this.a;
    }

    private void b(int i) {
        if (i > 0) {
            this.a = i;
            return;
        }
        throw new IllegalArgumentException("UDP payload size must be greater than zero");
    }

    public final void a(C0017a aVar) {
        if (aVar != null) {
            this.d = aVar;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final C0017a c() {
        return this.d;
    }
}
