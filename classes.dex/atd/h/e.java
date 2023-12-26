package atd.h;

import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import atd.i.a;
import atd.i.b;
import atd.k.c;
import atd.m.d;
import atd.m.f;
import atd.m.g;
import atd.m.h;
import atd.m.i;
import atd.m.j;
import atd.m.k;
import atd.m.l;
import atd.m.m;
import atd.m.n;
import atd.v.b0;
import atd.v.c0;
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

final class e extends c {
    e() {
    }

    private void b(List<b> list) {
        list.add(new a(atd.s0.a.a(-80499235940928L), Build.BOARD));
        list.add(new a(atd.s0.a.a(-80512120842816L), Build.BOOTLOADER));
        list.add(new a(atd.s0.a.a(-80525005744704L), Build.BRAND));
        list.add(new a(atd.s0.a.a(-80297372478016L), Build.DEVICE));
        list.add(new a(atd.s0.a.a(-80310257379904L), Build.DISPLAY));
        list.add(new a(atd.s0.a.a(-80323142281792L), Build.FINGERPRINT));
        list.add(new a(atd.s0.a.a(-80336027183680L), Build.HARDWARE));
        list.add(new a(atd.s0.a.a(-80383271823936L), Build.ID));
        list.add(new a(atd.s0.a.a(-80396156725824L), Build.MANUFACTURER));
        list.add(new a(atd.s0.a.a(-80683919534656L), Build.PRODUCT));
        list.add(new a(atd.s0.a.a(-80696804436544L), Build.getRadioVersion()));
        list.add(new atd.k.a());
        list.add(new atd.k.b());
        list.add(new c());
        list.add(new a(atd.s0.a.a(-80744049076800L), Build.TAGS));
        list.add(new a(atd.s0.a.a(-80756933978688L), Long.valueOf(Build.TIME)));
        list.add(new a(atd.s0.a.a(-80769818880576L), Build.TYPE));
        list.add(new a(atd.s0.a.a(-80782703782464L), Build.USER));
    }

    private void c(List<b> list) {
        list.add(new a(atd.s0.a.a(-80555070515776L), Build.VERSION.CODENAME));
        list.add(new a(atd.s0.a.a(-80567955417664L), Build.VERSION.INCREMENTAL));
        list.add(new atd.l.a());
        list.add(new a(atd.s0.a.a(-80580840319552L), Integer.valueOf(Build.VERSION.SDK_INT)));
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
        list.add(new d());
        list.add(new atd.m.e());
        list.addAll(new g().a());
        list.add(new j());
        list.add(new atd.m.b());
        list.add(new m());
    }

    private void e(List<b> list) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        list.add(new a(atd.s0.a.a(-75620153092672L), Float.valueOf(displayMetrics.density)));
        list.add(new a(atd.s0.a.a(-75633037994560L), Integer.valueOf(displayMetrics.densityDpi)));
        list.add(new a(atd.s0.a.a(-75645922896448L), Float.valueOf(displayMetrics.scaledDensity)));
        list.add(new a(atd.s0.a.a(-75693167536704L), Float.valueOf(displayMetrics.xdpi)));
        list.add(new a(atd.s0.a.a(-75706052438592L), Float.valueOf(displayMetrics.ydpi)));
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
        list.add(new atd.r.a(atd.s0.a.a(-79567228037696L), atd.s0.a.a(-78755479218752L)));
        list.add(new atd.r.a(atd.s0.a.a(-78807018826304L), atd.s0.a.a(-78854263466560L)));
        list.add(new atd.r.a(atd.s0.a.a(-78660989938240L), atd.s0.a.a(-78673874840128L)));
        list.add(new atd.r.a(atd.s0.a.a(-79047536994880L), atd.s0.a.a(-79094781635136L)).b());
        list.add(new atd.r.a(atd.s0.a.a(-78922982943296L), atd.s0.a.a(-78935867845184L)));
        list.add(new atd.r.a(atd.s0.a.a(-78961637648960L), atd.s0.a.a(-79008882289216L)));
        list.add(new atd.r.a(atd.s0.a.a(-78222903274048L), atd.s0.a.a(-78270147914304L)));
        list.add(new atd.r.a(atd.s0.a.a(-78111234124352L), atd.s0.a.a(-78124119026240L)));
        list.add(new atd.r.a(atd.s0.a.a(-78179953601088L), atd.s0.a.a(-78192838502976L)));
        list.add(new atd.r.a(atd.s0.a.a(-78557910723136L), atd.s0.a.a(-78570795625024L)));
        list.add(new atd.r.a(atd.s0.a.a(-78394701965888L), atd.s0.a.a(-78441946606144L)).b());
        list.add(new atd.r.a(atd.s0.a.a(-77707507198528L), atd.s0.a.a(-77754751838784L)));
        list.add(new atd.r.a(atd.s0.a.a(-77578658179648L), atd.s0.a.a(-77591543081536L)));
        list.add(new atd.r.a(atd.s0.a.a(-77935140465216L), atd.s0.a.a(-77948025367104L)));
        list.add(new atd.r.b());
    }

    private void j(List<b> list) {
        list.add(new atd.s.a());
        list.add(new atd.s.f(atd.s0.a.a(-80593725221440L), atd.s0.a.a(-80640969861696L)));
        list.add(new atd.s.h());
        list.add(new atd.s.f(atd.s0.a.a(-79893645552192L), atd.s0.a.a(-79906530454080L)));
        list.add(new atd.s.f(atd.s0.a.a(-79751911631424L), atd.s0.a.a(-79799156271680L)));
        list.add(new atd.s.b());
        list.add(new atd.s.f(atd.s0.a.a(-79820631108160L), atd.s0.a.a(-80142753655360L)));
        list.add(new atd.s.c());
        list.add(new atd.s.f(atd.s0.a.a(-80224358033984L), atd.s0.a.a(-80237242935872L)));
        list.add(new atd.s.f(atd.s0.a.a(-80104098949696L), atd.s0.a.a(-80116983851584L)));
        list.add(new atd.s.f(atd.s0.a.a(-79404019280448L), atd.s0.a.a(-79416904182336L)));
        list.add(new atd.s.d());
        list.add(new atd.s.e());
        list.add(new atd.s.g());
        list.add(new atd.s.i());
        list.add(new atd.s.f(atd.s0.a.a(-79275170261568L), atd.s0.a.a(-79288055163456L)));
        list.add(new atd.s.f(atd.s0.a.a(-79657422350912L), atd.s0.a.a(-79670307252800L)));
        list.add(new atd.s.f(atd.s0.a.a(-79459853855296L), atd.s0.a.a(-79507098495552L)));
        list.add(new atd.s.j());
    }

    private void k(List<b> list) {
        list.add(new atd.t.b(atd.s0.a.a(-78042514647616L), atd.s0.a.a(-78055399549504L)));
        list.add(new atd.t.b(atd.s0.a.a(-77887895824960L), atd.s0.a.a(-77900780726848L)));
        list.add(new atd.t.b(atd.s0.a.a(-77204996024896L), atd.s0.a.a(-77217880926784L)));
        list.add(new atd.t.b(atd.s0.a.a(-77071852038720L), atd.s0.a.a(-77393974585920L)));
        list.add(new atd.t.a());
        list.add(new atd.t.b(atd.s0.a.a(-77445514193472L), atd.s0.a.a(-77458399095360L)));
        list.add(new atd.t.b(atd.s0.a.a(-77484168899136L), atd.s0.a.a(-77256535632448L)));
        list.add(new atd.t.b(atd.s0.a.a(-77342434978368L), atd.s0.a.a(-77355319880256L)).b());
        list.add(new atd.t.b(atd.s0.a.a(-76586520734272L), atd.s0.a.a(-76599405636160L)));
        list.add(new atd.t.b(atd.s0.a.a(-76427606944320L), atd.s0.a.a(-76440491846208L)));
        list.add(new atd.t.b(atd.s0.a.a(-76831333870144L), atd.s0.a.a(-76878578510400L)));
        list.add(new atd.t.b(atd.s0.a.a(-76934413085248L), atd.s0.a.a(-76706779818560L)));
        list.add(new atd.t.b(atd.s0.a.a(-76784089229888L), atd.s0.a.a(-76796974131776L)));
        list.add(new atd.t.b(atd.s0.a.a(-76036764920384L), atd.s0.a.a(-76049649822272L)));
        list.add(new atd.t.b(atd.s0.a.a(-76109779364416L), atd.s0.a.a(-75882146097728L)));
        list.add(new atd.t.b(atd.s0.a.a(-75955160541760L), atd.s0.a.a(-76002405182016L)).d());
        list.add(new atd.t.b(atd.s0.a.a(-76333117663808L), atd.s0.a.a(-76380362304064L)));
        list.add(new atd.t.b(atd.s0.a.a(-76182793808448L), atd.s0.a.a(-76195678710336L)));
        list.add(new atd.t.b(atd.s0.a.a(-76255808252480L), atd.s0.a.a(-76268693154368L)));
        list.add(new atd.t.b(atd.s0.a.a(-75517073877568L), atd.s0.a.a(-75529958779456L)));
        list.add(new atd.t.b(atd.s0.a.a(-75577203419712L), atd.s0.a.a(-75349570153024L)));
        list.add(new atd.t.b(atd.s0.a.a(-75392519825984L), atd.s0.a.a(-75405404727872L)));
        list.add(new atd.t.b(atd.s0.a.a(-75736117209664L), atd.s0.a.a(-75749002111552L)));
        list.add(new atd.t.b(atd.s0.a.a(-75826311522880L), atd.s0.a.a(-75839196424768L)));
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
        list.add(new atd.v.m());
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
