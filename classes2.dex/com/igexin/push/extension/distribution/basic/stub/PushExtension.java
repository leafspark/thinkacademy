package com.igexin.push.extension.distribution.basic.stub;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.didi.hummer.render.style.HummerStyleUtils;
import com.igexin.push.core.a.a.a;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.c;
import com.igexin.push.core.d;
import com.igexin.push.extension.distribution.basic.a.e;
import com.igexin.push.extension.distribution.basic.a.g;
import com.igexin.push.extension.distribution.basic.a.h;
import com.igexin.push.extension.distribution.basic.a.i;
import com.igexin.push.extension.distribution.basic.d.b;
import com.igexin.push.extension.stub.IPushExtension;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class PushExtension implements IPushExtension {
    private static Map<String, a> a;
    private static Set<String> b;

    public PushExtension() {
        a = new HashMap();
        HashSet hashSet = new HashSet();
        b = hashSet;
        hashSet.add("notification");
        b.add("terminatetask");
        b.add("starthome");
        b.add("startintent");
        b.add("startmyactivity");
    }

    private a a(String str) {
        Map<String, a> map;
        Object hVar;
        if (TextUtils.isEmpty(str) || !b.contains(str)) {
            return null;
        }
        if (!a.containsKey(str) || a.get(str) == null) {
            String str2 = "notification";
            if (str.equals(str2)) {
                map = a;
                hVar = new com.igexin.push.extension.distribution.basic.a.a();
            } else {
                str2 = "terminatetask";
                if (str.equals(str2)) {
                    map = a;
                    hVar = new i();
                } else {
                    str2 = "starthome";
                    if (str.equals(str2)) {
                        map = a;
                        hVar = new e();
                    } else {
                        str2 = "startintent";
                        if (str.equals(str2)) {
                            map = a;
                            hVar = new g();
                        } else {
                            str2 = "startmyactivity";
                            if (str.equals(str2)) {
                                map = a;
                                hVar = new h();
                            }
                        }
                    }
                }
            }
            map.put(str2, hVar);
        }
        return a.get(str);
    }

    private void a() {
        if (!com.igexin.push.extension.distribution.basic.g.e.a()) {
            com.igexin.push.extension.distribution.basic.c.e.k = com.igexin.push.extension.distribution.basic.c.e.a.getCacheDir() + "/ImgCache/";
        }
        com.igexin.push.extension.distribution.basic.c.e.e = new com.igexin.push.extension.distribution.basic.e.a(com.igexin.push.extension.distribution.basic.c.e.a);
        DisplayMetrics displayMetrics = com.igexin.push.extension.distribution.basic.c.e.a.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (i2 > i) {
            com.igexin.push.extension.distribution.basic.c.e.b = i2;
            com.igexin.push.extension.distribution.basic.c.e.c = i;
        } else {
            com.igexin.push.extension.distribution.basic.c.e.b = i;
            com.igexin.push.extension.distribution.basic.c.e.c = i2;
        }
        com.igexin.push.core.a.e.a().f();
        c.a().f();
    }

    private void b() {
        try {
            com.igexin.push.extension.distribution.basic.c.c.a().c();
            com.igexin.push.extension.distribution.basic.c.c.a().d();
        } catch (Throwable unused) {
        }
    }

    private void c() {
        b.a().b();
        if (com.igexin.push.extension.distribution.basic.c.e.d == null) {
            com.igexin.push.extension.distribution.basic.c.e.d = com.igexin.b.b.a.a(d.g.getPackageName() + System.currentTimeMillis());
            b.a().a(4, com.igexin.push.extension.distribution.basic.c.e.d);
        }
    }

    private void d() {
        boolean z;
        try {
            com.igexin.push.extension.distribution.basic.c.e.l = new com.igexin.push.extension.distribution.basic.e.b(com.igexin.push.extension.distribution.basic.c.e.a);
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        Thread thread = new Thread(new a(this, z));
        if (!(thread instanceof Thread)) {
            thread.start();
        } else {
            AsynchronousInstrumentation.threadStart(thread);
        }
    }

    public boolean executeAction(PushTaskBean pushTaskBean, BaseAction baseAction) {
        a a2;
        if (pushTaskBean == null || baseAction == null || (a2 = a(baseAction.getType())) == null || pushTaskBean.isStop()) {
            return false;
        }
        return a2.b(pushTaskBean, baseAction);
    }

    public boolean init(Context context) {
        com.igexin.b.a.c.b.a("EXT-PushExtension|ext init ###", new Object[0]);
        if (context == null) {
            com.igexin.b.a.c.b.a("EXT-PushExtension|context = null", new Object[0]);
            return false;
        }
        com.igexin.push.extension.distribution.basic.c.e.a = context;
        a();
        b();
        c();
        d();
        return true;
    }

    public boolean isActionSupported(String str) {
        return str != null && b.contains(str);
    }

    public void onDestroy() {
        com.igexin.push.extension.distribution.basic.c.c.a().f();
    }

    public BaseAction parseAction(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has(HummerStyleUtils.Hummer.TYPE)) {
            return null;
        }
        try {
            a a2 = a(jSONObject.getString(HummerStyleUtils.Hummer.TYPE));
            if (a2 != null) {
                return a2.a(jSONObject);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = a(r3.getType());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.igexin.push.core.a prepareExecuteAction(com.igexin.push.core.bean.PushTaskBean r2, com.igexin.push.core.bean.BaseAction r3) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0013
            if (r3 == 0) goto L_0x0013
            java.lang.String r0 = r3.getType()
            com.igexin.push.core.a.a.a r0 = r1.a(r0)
            if (r0 == 0) goto L_0x0013
            com.igexin.push.core.a r2 = r0.a(r2, r3)
            return r2
        L_0x0013:
            com.igexin.push.core.a r2 = com.igexin.push.core.a.stop
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.stub.PushExtension.prepareExecuteAction(com.igexin.push.core.bean.PushTaskBean, com.igexin.push.core.bean.BaseAction):com.igexin.push.core.a");
    }
}
