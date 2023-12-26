package atd.i;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import atd.i.c;
import atd.s0.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class d implements b {
    private void b(Context context) throws c {
        List list;
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 4096);
            List<String> b = b();
            String[] strArr = packageInfo.requestedPermissions;
            if (strArr != null) {
                list = Arrays.asList(strArr);
            } else {
                list = Collections.emptyList();
            }
            for (String contains : b) {
                if (!list.contains(contains)) {
                    throw new c(c.a.MISSING_PERMISSION, (Throwable) null);
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                for (String checkSelfPermission : b) {
                    if (context.checkSelfPermission(checkSelfPermission) != 0) {
                        throw new c(c.a.MISSING_PERMISSION, (Throwable) null);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(a.a(-74361727674944L) + packageName, e);
        }
    }

    public final Object a(Context context) throws c {
        b(context);
        try {
            return c(context);
        } catch (SecurityException unused) {
            throw new c(c.a.MISSING_PERMISSION, (Throwable) null);
        }
    }

    /* access modifiers changed from: protected */
    public abstract List<String> b();

    /* access modifiers changed from: protected */
    public abstract Object c(Context context) throws c;
}
