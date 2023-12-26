package com.bonree.sdk.v;

import com.bonree.sdk.bs.z;
import com.bonree.sdk.n.f;
import java.net.Socket;
import java.net.SocketImpl;

public class g {
    private String a;

    public g() {
    }

    public static f a(Socket socket) {
        try {
            SocketImpl socketImpl = (SocketImpl) z.a((Object) socket, "impl");
            if (socketImpl instanceof d) {
                return ((d) socketImpl).a();
            }
            return null;
        } catch (Throwable th) {
            com.bonree.sdk.be.g.b("SocketLink getSocketImpl error: " + th);
            return null;
        }
    }

    public g(String str) {
        this.a = str;
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }
}
