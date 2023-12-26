package atd.p;

import android.content.Context;
import android.content.pm.PackageManager;
import atd.i.b;

abstract class a implements b {
    a() {
    }

    /* access modifiers changed from: package-private */
    public PackageManager b(Context context) {
        return context.getPackageManager();
    }
}
