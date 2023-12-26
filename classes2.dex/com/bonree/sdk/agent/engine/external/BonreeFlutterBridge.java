package com.bonree.sdk.agent.engine.external;

import com.bonree.sdk.af.a;
import com.bonree.sdk.ba.p;
import com.bonree.sdk.d.e;
import com.bonree.sdk.m.d;
import com.bonree.sdk.m.k;
import java.util.Map;

public class BonreeFlutterBridge {
    public static void reportFlutterView(long j, String str, int i, int i2, String str2, String str3) {
        p.a(j, str, i, i2, str2, str3, 1);
    }

    public static void reportCrash(long j, String str, String str2, String str3) {
        a f = e.d().f();
        if (f != null) {
            f.b(j, str, str2, str3);
        }
    }

    public static void reportNetwork(String str, long j, int i, String str2, String str3, int i2, int i3, int i4, String str4, Map map, Map map2) {
        d.a().a(str, j, i, str2, str3, i2, i3, i4, str4, map, map2);
    }

    public static Class<?> isImportFlutterPlugin() {
        try {
            return Class.forName("com.bonree.sdk.bonree_flutter_plugin.BonreeFlutterPlugin");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void setNetworkTraceConfig(Class<?> cls, Map map) {
        try {
            cls.getDeclaredMethod("setNetworkTraceConfig", new Class[]{Map.class}).invoke((Object) null, new Object[]{map});
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().e("setNetworkTraceConfig error: %s", th.toString());
        }
    }

    public static Map getNetworkTraceConfig() {
        return k.b().a();
    }
}
