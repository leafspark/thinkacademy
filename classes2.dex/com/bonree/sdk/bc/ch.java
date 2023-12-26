package com.bonree.sdk.bc;

import com.bonree.sdk.bc.w;
import com.huawei.multimedia.audiokit.config.ResultCode;
import java.security.PrivateKey;
import java.util.Date;

public final class ch {
    private static final short a = 300;

    private ch() {
    }

    private static void a(bb bbVar, ap apVar, PrivateKey privateKey, cj cjVar) throws w.b {
        int b = br.b("sig0validity");
        if (b < 0) {
            b = 300;
        }
        long currentTimeMillis = System.currentTimeMillis();
        bbVar.a((ca) w.a(bbVar, cjVar, apVar, privateKey, new Date(currentTimeMillis), new Date(currentTimeMillis + ((long) (b * ResultCode.KARAOKE_SUCCESS)))), 3);
    }

    private static void a(bb bbVar, byte[] bArr, ap apVar, cj cjVar) throws w.b {
        cj cjVar2;
        ca[] a2 = bbVar.a(3);
        int i = 0;
        while (true) {
            if (i < a2.length) {
                if (a2[i].p() == 24 && ((cj) a2[i]).l() == 0) {
                    cjVar2 = (cj) a2[i];
                    break;
                }
                i++;
            } else {
                cjVar2 = null;
                break;
            }
        }
        w.a(bbVar, bArr, cjVar2, cjVar, apVar);
    }
}
