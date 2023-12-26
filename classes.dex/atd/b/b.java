package atd.b;

import atd.a.c;
import atd.a.d;
import atd.d.i;
import atd.d.j;
import atd.f0.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class b {
    private final ExecutorService a = Executors.newFixedThreadPool(3);
    private final a b;
    private final c<j> c;

    public b(String str, a aVar, c<j> cVar) {
        this.b = new a(str, aVar);
        this.c = cVar;
    }

    public void a(i iVar) {
        this.a.submit(new d(this.c, this.b.c(iVar)));
    }
}
