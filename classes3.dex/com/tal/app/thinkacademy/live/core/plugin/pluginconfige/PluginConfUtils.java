package com.tal.app.thinkacademy.live.core.plugin.pluginconfige;

public class PluginConfUtils {
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002f A[SYNTHETIC, Splitter:B:18:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003c A[SYNTHETIC, Splitter:B:26:0x003c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String loadAssetsString(android.content.Context r3, java.lang.String r4) {
        /*
            r0 = 0
            android.content.res.AssetManager r3 = r3.getAssets()     // Catch:{ IOException -> 0x0028, all -> 0x0026 }
            java.io.InputStream r3 = r3.open(r4)     // Catch:{ IOException -> 0x0028, all -> 0x0026 }
            int r4 = r3.available()     // Catch:{ IOException -> 0x0024 }
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x0024 }
            r3.read(r4)     // Catch:{ IOException -> 0x0024 }
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x0024 }
            java.lang.String r2 = "utf8"
            r1.<init>(r4, r2)     // Catch:{ IOException -> 0x0024 }
            if (r3 == 0) goto L_0x0023
            r3.close()     // Catch:{ IOException -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0023:
            return r1
        L_0x0024:
            r4 = move-exception
            goto L_0x002a
        L_0x0026:
            r4 = move-exception
            goto L_0x003a
        L_0x0028:
            r4 = move-exception
            r3 = r0
        L_0x002a:
            r4.printStackTrace()     // Catch:{ all -> 0x0038 }
            if (r3 == 0) goto L_0x0037
            r3.close()     // Catch:{ IOException -> 0x0033 }
            goto L_0x0037
        L_0x0033:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0037:
            return r0
        L_0x0038:
            r4 = move-exception
            r0 = r3
        L_0x003a:
            if (r0 == 0) goto L_0x0044
            r0.close()     // Catch:{ IOException -> 0x0040 }
            goto L_0x0044
        L_0x0040:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0044:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.core.plugin.pluginconfige.PluginConfUtils.loadAssetsString(android.content.Context, java.lang.String):java.lang.String");
    }
}
