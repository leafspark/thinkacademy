package com.bonree.sdk.bq;

import com.bonree.sdk.bj.a;
import com.bonree.sdk.bl.c;
import com.bonree.sdk.bl.d;
import com.bonree.sdk.bq.a;
import com.bonree.sdk.br.h;
import java.io.IOException;
import java.io.Serializable;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class c extends a {
    private static Logger c = Logger.getLogger(c.class.getName());
    private static /* synthetic */ boolean d = true;

    /* renamed from: c */
    public d a(a aVar, InetAddress inetAddress, int i) throws IOException {
        boolean z;
        Object obj;
        a.C0017a c2 = c();
        int i2 = d.a[c2.ordinal()];
        if (i2 == 1 || i2 == 2) {
            z = true;
        } else if (i2 == 3) {
            z = false;
        } else {
            throw new IllegalStateException("Unsupported query mode: " + c2);
        }
        ArrayList arrayList = new ArrayList(2);
        com.bonree.sdk.bj.a aVar2 = null;
        if (z) {
            try {
                aVar2 = d(aVar, inetAddress, i);
            } catch (IOException e) {
                arrayList.add(e);
            }
            com.bonree.sdk.bj.a aVar3 = aVar2;
            if (aVar3 != null && !aVar3.f) {
                return new d(inetAddress, i, c.a.a, aVar, aVar3);
            } else if (d || aVar3 == null || aVar3.f || arrayList.size() == 1) {
                Logger logger = c;
                Level level = Level.FINE;
                Object[] objArr = new Object[1];
                if (aVar3 != null) {
                    obj = "response is truncated";
                } else {
                    obj = (Serializable) arrayList.get(0);
                }
                objArr[0] = obj;
                logger.log(level, "Fallback to TCP because {0}", objArr);
                aVar2 = aVar3;
            } else {
                throw new AssertionError();
            }
        }
        try {
            aVar2 = e(aVar, inetAddress, i);
        } catch (IOException e2) {
            arrayList.add(e2);
            h.a((List<? extends IOException>) arrayList);
        }
        return new d(inetAddress, i, c.a.b, aVar, aVar2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bonree.sdk.bj.a d(com.bonree.sdk.bj.a r4, java.net.InetAddress r5, int r6) throws java.io.IOException {
        /*
            r3 = this;
            java.net.DatagramPacket r5 = r4.a((java.net.InetAddress) r5, (int) r6)
            int r6 = r3.a
            byte[] r0 = new byte[r6]
            r1 = 0
            java.net.DatagramSocket r2 = new java.net.DatagramSocket     // Catch:{ all -> 0x003a }
            r2.<init>()     // Catch:{ all -> 0x003a }
            int r1 = r3.b     // Catch:{ all -> 0x0037 }
            r2.setSoTimeout(r1)     // Catch:{ all -> 0x0037 }
            r2.send(r5)     // Catch:{ all -> 0x0037 }
            java.net.DatagramPacket r5 = new java.net.DatagramPacket     // Catch:{ all -> 0x0037 }
            r5.<init>(r0, r6)     // Catch:{ all -> 0x0037 }
            r2.receive(r5)     // Catch:{ all -> 0x0037 }
            com.bonree.sdk.bj.a r6 = new com.bonree.sdk.bj.a     // Catch:{ all -> 0x0037 }
            byte[] r5 = r5.getData()     // Catch:{ all -> 0x0037 }
            r6.<init>((byte[]) r5)     // Catch:{ all -> 0x0037 }
            int r5 = r6.a     // Catch:{ all -> 0x0037 }
            int r0 = r4.a     // Catch:{ all -> 0x0037 }
            if (r5 != r0) goto L_0x0031
            r2.close()
            return r6
        L_0x0031:
            com.bonree.sdk.bf.h$b r5 = new com.bonree.sdk.bf.h$b     // Catch:{ all -> 0x0037 }
            r5.<init>(r4, r6)     // Catch:{ all -> 0x0037 }
            throw r5     // Catch:{ all -> 0x0037 }
        L_0x0037:
            r4 = move-exception
            r1 = r2
            goto L_0x003b
        L_0x003a:
            r4 = move-exception
        L_0x003b:
            if (r1 == 0) goto L_0x0040
            r1.close()
        L_0x0040:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bq.c.d(com.bonree.sdk.bj.a, java.net.InetAddress, int):com.bonree.sdk.bj.a");
    }

    private static Socket d() {
        return new Socket();
    }

    private static DatagramSocket e() throws SocketException {
        return new DatagramSocket();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bonree.sdk.bj.a e(com.bonree.sdk.bj.a r5, java.net.InetAddress r6, int r7) throws java.io.IOException {
        /*
            r4 = this;
            r0 = 0
            java.net.Socket r1 = new java.net.Socket     // Catch:{ all -> 0x0056 }
            r1.<init>()     // Catch:{ all -> 0x0056 }
            java.net.InetSocketAddress r0 = new java.net.InetSocketAddress     // Catch:{ all -> 0x0053 }
            r0.<init>(r6, r7)     // Catch:{ all -> 0x0053 }
            int r6 = r4.b     // Catch:{ all -> 0x0053 }
            r1.connect(r0, r6)     // Catch:{ all -> 0x0053 }
            int r6 = r4.b     // Catch:{ all -> 0x0053 }
            r1.setSoTimeout(r6)     // Catch:{ all -> 0x0053 }
            java.io.DataOutputStream r6 = new java.io.DataOutputStream     // Catch:{ all -> 0x0053 }
            java.io.OutputStream r7 = r1.getOutputStream()     // Catch:{ all -> 0x0053 }
            r6.<init>(r7)     // Catch:{ all -> 0x0053 }
            r5.a((java.io.OutputStream) r6)     // Catch:{ all -> 0x0053 }
            r6.flush()     // Catch:{ all -> 0x0053 }
            java.io.DataInputStream r6 = new java.io.DataInputStream     // Catch:{ all -> 0x0053 }
            java.io.InputStream r7 = r1.getInputStream()     // Catch:{ all -> 0x0053 }
            r6.<init>(r7)     // Catch:{ all -> 0x0053 }
            int r7 = r6.readUnsignedShort()     // Catch:{ all -> 0x0053 }
            byte[] r0 = new byte[r7]     // Catch:{ all -> 0x0053 }
            r2 = 0
        L_0x0034:
            if (r2 >= r7) goto L_0x003e
            int r3 = r7 - r2
            int r3 = r6.read(r0, r2, r3)     // Catch:{ all -> 0x0053 }
            int r2 = r2 + r3
            goto L_0x0034
        L_0x003e:
            com.bonree.sdk.bj.a r6 = new com.bonree.sdk.bj.a     // Catch:{ all -> 0x0053 }
            r6.<init>((byte[]) r0)     // Catch:{ all -> 0x0053 }
            int r7 = r6.a     // Catch:{ all -> 0x0053 }
            int r0 = r5.a     // Catch:{ all -> 0x0053 }
            if (r7 != r0) goto L_0x004d
            r1.close()
            return r6
        L_0x004d:
            com.bonree.sdk.bf.h$b r7 = new com.bonree.sdk.bf.h$b     // Catch:{ all -> 0x0053 }
            r7.<init>(r5, r6)     // Catch:{ all -> 0x0053 }
            throw r7     // Catch:{ all -> 0x0053 }
        L_0x0053:
            r5 = move-exception
            r0 = r1
            goto L_0x0057
        L_0x0056:
            r5 = move-exception
        L_0x0057:
            if (r0 == 0) goto L_0x005c
            r0.close()
        L_0x005c:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bq.c.e(com.bonree.sdk.bj.a, java.net.InetAddress, int):com.bonree.sdk.bj.a");
    }
}
