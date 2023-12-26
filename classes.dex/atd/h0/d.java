package atd.h0;

import atd.i0.h;
import atd.s0.a;
import atd.y.c;
import com.adyen.threeds2.exception.SDKRuntimeException;
import com.adyen.threeds2.internal.b;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.List;

public final class d {
    private final a a;
    private final b b;
    private final c c;

    static {
        a.a(-797380817250880L);
    }

    private d(a aVar, b bVar, c cVar) {
        this.a = aVar;
        this.b = bVar;
        this.c = cVar;
    }

    public static d a(String str) {
        String[] split = str.split(a.a(-797367932348992L));
        if (split.length == 3) {
            return new d(new a(split[0]), new b(split[1]), new c(split[2]));
        }
        throw c.CRYPTO_FAILURE.a();
    }

    public b a() {
        return this.b;
    }

    public void a(List<X509Certificate> list) {
        for (X509Certificate a2 : list) {
            try {
                a(a2);
                return;
            } catch (SDKRuntimeException unused) {
            }
        }
        throw c.CRYPTO_FAILURE.a();
    }

    public void a(X509Certificate x509Certificate) {
        h.a(x509Certificate, this.a.e());
        byte[] a2 = a(this.a.c(), this.b.c());
        try {
            if (!this.a.f().a(this.c.b(), a2, this.a.e().get(0).getPublicKey())) {
                throw c.CRYPTO_FAILURE.a();
            }
        } catch (GeneralSecurityException e) {
            throw c.CRYPTO_FAILURE.a(e);
        }
    }

    private static byte[] a(String str, String str2) {
        return (str + a.a(-797355047447104L) + str2).getBytes(b.a);
    }
}
