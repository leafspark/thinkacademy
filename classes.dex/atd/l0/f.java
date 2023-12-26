package atd.l0;

import android.content.Context;
import atd.r0.g;
import com.adyen.threeds2.Warning;
import com.adyen.threeds2.internal.j;

abstract class f {
    f() {
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        return a(c());
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        return a(d());
    }

    /* access modifiers changed from: package-private */
    public abstract boolean b(Context context);

    /* access modifiers changed from: package-private */
    public abstract String c();

    /* access modifiers changed from: package-private */
    public abstract String d();

    /* access modifiers changed from: package-private */
    public abstract Warning.Severity e();

    /* access modifiers changed from: package-private */
    public final j a(Context context) {
        if (b(context)) {
            return new j(a(), b(), e());
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final String a(String str) {
        return g.a(str);
    }
}
