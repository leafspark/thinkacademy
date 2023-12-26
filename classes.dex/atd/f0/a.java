package atd.f0;

import atd.c0.d;
import atd.c0.e;
import atd.d0.f;
import atd.g0.b;
import java.security.GeneralSecurityException;

public final class a {
    private final f a;
    private final d b;
    private final d c;

    public a(f fVar, d dVar, b bVar) {
        f f = fVar.f();
        this.a = fVar;
        this.b = dVar;
        this.c = a(f, bVar);
    }

    public h a(byte[] bArr) throws GeneralSecurityException {
        atd.c0.b e = this.a.e();
        byte[] b2 = e.b();
        e b3 = e.b(this.b, b2, bArr, this.a.b());
        return new h(this.a, this.c, new g(b2), new e(b3.b()), new c(b3.a()));
    }

    public byte[] a(h hVar) throws GeneralSecurityException {
        atd.c0.b e = this.a.e();
        byte[] b2 = hVar.c().b();
        return e.a(this.b, hVar.d().b(), hVar.b().b(), b2, hVar.a().b());
    }

    private d a(f fVar, b bVar) {
        byte[] bArr;
        if (fVar instanceof atd.d0.e) {
            b.a(bVar, atd.g0.d.class);
            bArr = ((atd.d0.e) fVar).a(this.b, ((atd.g0.d) bVar).f());
        } else {
            bArr = null;
        }
        return new d(bArr);
    }
}
