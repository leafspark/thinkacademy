package com.bonree.sdk.agent.engine.network.okhttp2.external;

import com.bonree.sdk.be.g;
import com.bonree.sdk.d.a;
import com.bonree.sdk.n.b;
import com.squareup.okhttp.Dns;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class Okhttp2Dns implements Dns {
    private Dns a;
    private b b;

    public Okhttp2Dns(Dns dns, b bVar) {
        this.a = dns;
        this.b = bVar;
    }

    public final void a(b bVar) {
        this.b = bVar;
    }

    public List<InetAddress> lookup(String str) throws UnknownHostException {
        long b2 = a.b();
        List<InetAddress> lookup = this.a.lookup(str);
        try {
            int b3 = (int) (a.b() - b2);
            b bVar = this.b;
            if (bVar != null && bVar.f().contains(str) && this.b.z() <= 0) {
                this.b.c(b3);
            }
        } catch (Throwable th) {
            g.a("replaceDefaultDns failed:" + th, new Object[0]);
        }
        return lookup;
    }
}
