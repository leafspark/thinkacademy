package androidx.camera.core.impl.utils;

import android.content.Context;

public final class ContextUtil {
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r3 = androidx.camera.core.impl.utils.ContextUtil.Api30Impl.getAttributionTag(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.Context getApplicationContext(android.content.Context r3) {
        /*
            android.content.Context r0 = r3.getApplicationContext()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 30
            if (r1 < r2) goto L_0x0015
            java.lang.String r3 = androidx.camera.core.impl.utils.ContextUtil.Api30Impl.getAttributionTag(r3)
            if (r3 == 0) goto L_0x0015
            android.content.Context r3 = androidx.camera.core.impl.utils.ContextUtil.Api30Impl.createAttributionContext(r0, r3)
            return r3
        L_0x0015:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.ContextUtil.getApplicationContext(android.content.Context):android.content.Context");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r3 = androidx.camera.core.impl.utils.ContextUtil.Api30Impl.getAttributionTag(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.Context getBaseContext(android.content.ContextWrapper r3) {
        /*
            android.content.Context r0 = r3.getBaseContext()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 30
            if (r1 < r2) goto L_0x0015
            java.lang.String r3 = androidx.camera.core.impl.utils.ContextUtil.Api30Impl.getAttributionTag(r3)
            if (r3 == 0) goto L_0x0015
            android.content.Context r3 = androidx.camera.core.impl.utils.ContextUtil.Api30Impl.createAttributionContext(r0, r3)
            return r3
        L_0x0015:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.ContextUtil.getBaseContext(android.content.ContextWrapper):android.content.Context");
    }

    private ContextUtil() {
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static Context createAttributionContext(Context context, String str) {
            return context.createAttributionContext(str);
        }

        static String getAttributionTag(Context context) {
            return context.getAttributionTag();
        }
    }
}
