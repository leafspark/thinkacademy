package com.igexin.b.a.b.a.a;

import android.text.TextUtils;
import com.igexin.b.a.b.a.a.a.d;
import com.igexin.b.a.b.b;
import com.igexin.b.a.b.e;
import com.igexin.push.c.i;
import com.igexin.push.config.SDKUrlConfig;
import java.net.InetSocketAddress;
import java.net.Socket;

public final class c extends a {
    private d h;
    private Socket i;

    public c(d dVar) {
        super(-2037, (String) null, (b) null);
        this.h = dVar;
    }

    public void b() {
        super.b();
        i.a().d().a();
        String cmAddress = SDKUrlConfig.getCmAddress();
        try {
            String[] a = e.a(cmAddress);
            String str = a[1];
            int parseInt = Integer.parseInt(a[2]);
            com.igexin.b.a.c.b.a("GS-C|start connect :  " + cmAddress + " *********", new Object[0]);
            d dVar = this.h;
            if (dVar != null) {
                dVar.a(cmAddress);
            }
            Socket socket = new Socket();
            this.i = socket;
            try {
                socket.connect(new InetSocketAddress(str, parseInt), 10000);
                com.igexin.b.a.c.b.a("GS-C|connected :  " + cmAddress + " #########", new Object[0]);
                com.igexin.b.a.c.b.a("GS-C|local-" + this.i.getLocalAddress() + ":" + this.i.getLocalPort(), new Object[0]);
                if (this.e != b.INTERRUPT) {
                    this.e = b.NORMAL;
                }
            } catch (Exception e) {
                if (this.e != b.INTERRUPT) {
                    this.e = b.EXCEPTION;
                    this.f = e.toString();
                }
            }
            this.d = true;
        } catch (Exception e2) {
            com.igexin.b.a.c.b.a("GS-C|ips invalid, " + e2.toString(), new Object[0]);
            throw e2;
        }
    }

    public final int b_() {
        return -2037;
    }

    public void f() {
        Socket socket;
        super.f();
        com.igexin.b.a.c.b.a("GS-C|sc dispose", new Object[0]);
        if (this.h != null) {
            if (this.e == b.INTERRUPT) {
                this.h.a(this);
            } else if (this.e == b.EXCEPTION) {
                if (!TextUtils.isEmpty(this.f)) {
                    this.h.a(new Exception(this.f));
                }
            } else if (this.e == b.NORMAL && (socket = this.i) != null) {
                this.h.a(socket);
            }
        }
        this.h = null;
    }

    public void j() {
        this.e = b.INTERRUPT;
    }
}
