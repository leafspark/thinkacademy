package com.bonree.sdk.bq;

import com.bonree.sdk.bf.i;
import com.bonree.sdk.bl.c;
import java.io.IOException;
import java.net.InetAddress;

public interface b {

    public interface a {
        void a(com.bonree.sdk.bj.a aVar, c cVar);
    }

    int a();

    c a(com.bonree.sdk.bj.a aVar, InetAddress inetAddress, int i) throws IOException;

    void a(int i);

    int b();

    i<c, IOException> b(com.bonree.sdk.bj.a aVar, InetAddress inetAddress, int i);
}
