package atd.f0;

import atd.s0.a;
import atd.y.c;
import java.util.Locale;

public final class h {
    private final f a;
    private final d b;
    private final g c;
    private final e d;
    private final c e;

    static {
        a.a(-797887623391808L);
    }

    h(f fVar, d dVar, g gVar, e eVar, c cVar) {
        this.a = fVar;
        this.b = dVar;
        this.c = gVar;
        this.d = eVar;
        this.e = cVar;
    }

    public static h a(String str) {
        String[] split = str.split(a.a(-798652127570496L));
        if (split.length == 5) {
            return new h(new f(split[0]), new d(split[1]), new g(split[2]), new e(split[3]), new c(split[4]));
        }
        throw c.CRYPTO_FAILURE.a();
    }

    public e b() {
        return this.d;
    }

    public f c() {
        return this.a;
    }

    public g d() {
        return this.c;
    }

    public String e() {
        return String.format(Locale.US, a.a(-797848968686144L), new Object[]{this.a.c(), this.b.c(), this.c.c(), this.d.c(), this.e.c()});
    }

    public c a() {
        return this.e;
    }
}
