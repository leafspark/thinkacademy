package atd.e0;

import atd.y.c;

public final class d {
    public static final c a = new b();
    public static final c b = new a();

    public static c a(String str) {
        c cVar = a;
        if (cVar.a().equals(str)) {
            return cVar;
        }
        c cVar2 = b;
        if (cVar2.a().equals(str)) {
            return cVar2;
        }
        throw c.CRYPTO_FAILURE.a();
    }
}
