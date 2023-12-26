package atd.h;

import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import atd.i.a;
import atd.i.b;
import atd.k.c;
import atd.m.e;
import atd.m.f;
import atd.m.g;
import atd.m.h;
import atd.m.i;
import atd.m.k;
import atd.m.l;
import atd.m.n;
import atd.s.j;
import atd.v.b0;
import atd.v.c0;
import atd.v.m;
import atd.v.o;
import atd.v.p;
import atd.v.q;
import atd.v.r;
import atd.v.s;
import atd.v.u;
import atd.v.v;
import atd.v.w;
import atd.v.x;
import atd.v.y;
import atd.v.z;
import java.util.ArrayList;
import java.util.List;

final class d extends c {
    d() {
    }

    private void b(List<b> list) {
        list.add(new a(atd.s0.a.a(-85829290355264L), Build.BOARD));
        list.add(new a(atd.s0.a.a(-85842175257152L), Build.BOOTLOADER));
        list.add(new a(atd.s0.a.a(-85855060159040L), Build.BRAND));
        list.add(new a(atd.s0.a.a(-85867945060928L), Build.DEVICE));
        list.add(new a(atd.s0.a.a(-86190067608128L), Build.DISPLAY));
        list.add(new a(atd.s0.a.a(-86202952510016L), Build.FINGERPRINT));
        list.add(new a(atd.s0.a.a(-86215837411904L), Build.HARDWARE));
        list.add(new a(atd.s0.a.a(-86228722313792L), Build.ID));
        list.add(new a(atd.s0.a.a(-86275966954048L), Build.MANUFACTURER));
        list.add(new a(atd.s0.a.a(-86288851855936L), Build.PRODUCT));
        list.add(new a(atd.s0.a.a(-86301736757824L), Build.getRadioVersion()));
        list.add(new atd.k.a());
        list.add(new atd.k.b());
        list.add(new c());
        list.add(new a(atd.s0.a.a(-86039743752768L), Build.TAGS));
        list.add(new a(atd.s0.a.a(-86086988393024L), Long.valueOf(Build.TIME)));
        list.add(new a(atd.s0.a.a(-86099873294912L), Build.TYPE));
        list.add(new a(atd.s0.a.a(-86112758196800L), Build.USER));
    }

    private void c(List<b> list) {
        list.add(new a(atd.s0.a.a(-86125643098688L), Build.VERSION.CODENAME));
        list.add(new a(atd.s0.a.a(-86172887738944L), Build.VERSION.INCREMENTAL));
        list.add(new atd.l.a());
        list.add(new a(atd.s0.a.a(-85361138920000L), Integer.valueOf(Build.VERSION.SDK_INT)));
        list.add(new atd.l.b());
    }

    private void d(List<b> list) {
        list.add(new k());
        list.add(new atd.m.c());
        list.add(new h());
        list.add(new i());
        list.add(new f());
        list.add(new n());
        list.add(new atd.m.a());
        list.add(new l());
        list.add(new atd.m.d());
        list.add(new e());
        list.addAll(new g().a());
    }

    private void e(List<b> list) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        list.add(new a(atd.s0.a.a(-81225085413952L), Float.valueOf(displayMetrics.density)));
        list.add(new a(atd.s0.a.a(-80413336595008L), Integer.valueOf(displayMetrics.densityDpi)));
        list.add(new a(atd.s0.a.a(-80426221496896L), Float.valueOf(displayMetrics.scaledDensity)));
        list.add(new a(atd.s0.a.a(-80439106398784L), Float.valueOf(displayMetrics.xdpi)));
        list.add(new a(atd.s0.a.a(-80486351039040L), Float.valueOf(displayMetrics.ydpi)));
    }

    private void f(List<b> list) {
        list.add(new atd.n.a());
    }

    private void g(List<b> list) {
        list.add(new atd.o.a());
    }

    private void h(List<b> list) {
        list.add(new atd.p.f());
        list.add(new atd.p.b());
        list.add(new atd.p.c());
        list.add(new atd.p.d());
        list.add(new atd.p.e());
    }

    private void i(List<b> list) {
        list.add(new atd.r.a(atd.s0.a.a(-84347526638144L), atd.s0.a.a(-84360411540032L)).c());
        list.add(new atd.r.a(atd.s0.a.a(-84137073240640L), atd.s0.a.a(-84149958142528L)));
        list.add(new atd.r.a(atd.s0.a.a(-84540800166464L), atd.s0.a.a(-84553685068352L)).c());
        list.add(new atd.r.a(atd.s0.a.a(-84652469316160L), atd.s0.a.a(-84390476311104L)).b());
        list.add(new atd.r.a(atd.s0.a.a(-84493555526208L), atd.s0.a.a(-83716166445632L)).c());
        list.add(new atd.r.a(atd.s0.a.a(-83741936249408L), atd.s0.a.a(-83754821151296L)).c());
        list.add(new atd.r.a(atd.s0.a.a(-83827835595328L), atd.s0.a.a(-83565842590272L)).c());
        list.add(new atd.r.a(atd.s0.a.a(-83991044352576L), atd.s0.a.a(-84003929254464L)));
        list.add(new atd.r.a(atd.s0.a.a(-84059763829312L), atd.s0.a.a(-84072648731200L)));
        list.add(new atd.r.a(atd.s0.a.a(-83887965137472L), atd.s0.a.a(-83900850039360L)).c());
        list.add(new atd.r.a(atd.s0.a.a(-83175000566336L), atd.s0.a.a(-83187885468224L)).b());
        list.add(new atd.r.a(atd.s0.a.a(-83037561612864L), atd.s0.a.a(-83050446514752L)).c());
        list.add(new atd.r.a(atd.s0.a.a(-83458468407872L), atd.s0.a.a(-83471353309760L)));
        list.add(new atd.r.a(atd.s0.a.a(-83540072786496L), atd.s0.a.a(-83552957688384L)).c());
        list.add(new atd.r.b());
    }

    private void j(List<b> list) {
        list.add(new atd.s.a());
        list.add(new atd.s.f(atd.s0.a.a(-85374023821888L), atd.s0.a.a(-85386908723776L)).c());
        list.add(new atd.s.h());
        list.add(new atd.s.f(atd.s0.a.a(-85223699966528L), atd.s0.a.a(-85236584868416L)));
        list.add(new atd.s.f(atd.s0.a.a(-85631721859648L), atd.s0.a.a(-85644606761536L)));
        list.add(new atd.s.b());
        list.add(new atd.s.f(atd.s0.a.a(-85700441336384L), atd.s0.a.a(-85713326238272L)));
        list.add(new atd.s.c());
        list.add(new atd.s.f(atd.s0.a.a(-85554412448320L), atd.s0.a.a(-85567297350208L)));
        list.add(new atd.s.f(atd.s0.a.a(-84884397550144L), atd.s0.a.a(-84897282452032L)));
        list.add(new atd.s.f(atd.s0.a.a(-84699713956416L), atd.s0.a.a(-84746958596672L)));
        list.add(new atd.s.d());
        list.add(new atd.s.e());
        list.add(new atd.s.g());
        list.add(new atd.s.i());
        list.add(new atd.s.f(atd.s0.a.a(-85154980489792L), atd.s0.a.a(-85167865391680L)).c());
        list.add(new atd.s.f(atd.s0.a.a(-84987476765248L), atd.s0.a.a(-85000361667136L)).c());
        list.add(new atd.s.f(atd.s0.a.a(-85064786176576L), atd.s0.a.a(-84253037357632L)));
        list.add(new j());
    }

    private void k(List<b> list) {
        list.add(new atd.t.b(atd.s0.a.a(-83372569061952L), atd.s0.a.a(-83385453963840L)).c());
        list.add(new atd.t.b(atd.s0.a.a(-82668194425408L), atd.s0.a.a(-82681079327296L)).c());
        list.add(new atd.t.b(atd.s0.a.a(-82500690700864L), atd.s0.a.a(-82547935341120L)).c());
        list.add(new atd.t.b(atd.s0.a.a(-82951662266944L), atd.s0.a.a(-82964547168832L)));
        list.add(new atd.t.a());
        list.add(new atd.t.b(atd.s0.a.a(-82741208869440L), atd.s0.a.a(-82788453509696L)).c());
        list.add(new atd.t.b(atd.s0.a.a(-82814223313472L), atd.s0.a.a(-82827108215360L)).c());
        list.add(new atd.t.b(atd.s0.a.a(-82088373840448L), atd.s0.a.a(-82135618480704L)).b());
        list.add(new atd.t.b(atd.s0.a.a(-82157093317184L), atd.s0.a.a(-81929460050496L)).c());
        list.add(new atd.t.b(atd.s0.a.a(-82032539265600L), atd.s0.a.a(-82045424167488L)).c());
        list.add(new atd.t.b(atd.s0.a.a(-82436266191424L), atd.s0.a.a(-82449151093312L)));
        list.add(new atd.t.b(atd.s0.a.a(-82264467499584L), atd.s0.a.a(-82277352401472L)).c());
        list.add(new atd.t.b(atd.s0.a.a(-81564387830336L), atd.s0.a.a(-81577272732224L)));
        list.add(new atd.t.b(atd.s0.a.a(-81607337503296L), atd.s0.a.a(-81379704236608L)).c());
        list.add(new atd.t.b(atd.s0.a.a(-81439833778752L), atd.s0.a.a(-81452718680640L)).c());
        list.add(new atd.t.b(atd.s0.a.a(-81834970769984L), atd.s0.a.a(-81847855671872L)).d());
        list.add(new atd.t.b(atd.s0.a.a(-81663172078144L), atd.s0.a.a(-81676056980032L)).c());
        list.add(new atd.t.b(atd.s0.a.a(-80963092408896L), atd.s0.a.a(-80975977310784L)).c());
        list.add(new atd.t.b(atd.s0.a.a(-81036106852928L), atd.s0.a.a(-81048991754816L)).c());
        list.add(new atd.t.b(atd.s0.a.a(-80847128291904L), atd.s0.a.a(-80860013193792L)).c());
        list.add(new atd.t.b(atd.s0.a.a(-80907257834048L), atd.s0.a.a(-80920142735936L)).c());
        list.add(new atd.t.b(atd.s0.a.a(-81272330054208L), atd.s0.a.a(-81285214956096L)).c());
        list.add(new atd.t.b(atd.s0.a.a(-81341049530944L), atd.s0.a.a(-81353934432832L)).c());
        list.add(new atd.t.b(atd.s0.a.a(-81156365937216L), atd.s0.a.a(-81169250839104L)).c());
        list.add(new atd.t.c());
    }

    private void l(List<b> list) {
        list.add(new atd.u.a());
    }

    private void m(List<b> list) {
        list.add(new atd.v.a());
        list.add(new z());
        list.add(new atd.v.d());
        list.add(new atd.v.b());
        list.add(new atd.v.k());
        list.add(new atd.v.l());
        list.add(new m());
        list.add(new atd.v.n());
        list.add(new o());
        list.add(new p());
        list.add(new q());
        list.add(new r());
        list.add(new s());
        list.add(new u());
        list.add(new v());
        list.add(new w());
        list.add(new x());
        list.add(new y());
        list.add(new b0());
        list.add(new c0());
        list.add(new atd.v.c());
        list.add(new atd.v.e());
        list.add(new atd.v.f());
        list.add(new atd.v.g());
        list.add(new atd.v.h());
        list.add(new atd.v.i());
        list.add(new atd.v.j());
    }

    private void n(List<b> list) {
        list.add(new atd.w.l());
        list.add(new atd.w.b());
        list.add(new atd.w.k());
        list.add(new atd.w.j());
        list.add(new atd.w.c());
        list.add(new atd.w.d());
        list.add(new atd.w.e());
        list.add(new atd.w.f());
        list.add(new atd.w.g());
        list.add(new atd.w.h());
        list.add(new atd.w.i());
    }

    /* access modifiers changed from: package-private */
    public List<b> a() {
        ArrayList arrayList = new ArrayList();
        d(arrayList);
        m(arrayList);
        n(arrayList);
        a(arrayList);
        b(arrayList);
        c(arrayList);
        j(arrayList);
        i(arrayList);
        k(arrayList);
        h(arrayList);
        f(arrayList);
        g(arrayList);
        e(arrayList);
        l(arrayList);
        return arrayList;
    }

    private void a(List<b> list) {
        list.add(new atd.j.a());
        list.add(new atd.j.c());
        list.add(new atd.j.d());
    }
}
