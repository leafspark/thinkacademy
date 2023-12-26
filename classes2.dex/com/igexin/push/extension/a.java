package com.igexin.push.extension;

import android.content.Context;
import com.igexin.b.a.c.b;
import com.igexin.push.core.d;
import com.igexin.push.extension.stub.IPushExtension;
import java.util.ArrayList;
import java.util.List;

public class a {
    private static String a = "com.igexin.push.extension.a";
    private static a c;
    private List<IPushExtension> b = new ArrayList();

    private a() {
    }

    public static a a() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    private void b(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("com.igexin.push.extension.distribution.basic.stub.PushExtension");
        for (String str : arrayList) {
            try {
                IPushExtension iPushExtension = (IPushExtension) context.getClassLoader().loadClass(str).newInstance();
                iPushExtension.init(d.g);
                this.b.add(iPushExtension);
                b.a("[main] ext loaded(mock): " + str, new Object[0]);
            } catch (Exception e) {
                b.a(a + e.toString(), new Object[0]);
            }
        }
    }

    public boolean a(Context context) {
        try {
            b(context);
            return true;
        } catch (Throwable th) {
            b.a(a + "|" + th.toString(), new Object[0]);
            return true;
        }
    }

    public List<IPushExtension> b() {
        return this.b;
    }
}
