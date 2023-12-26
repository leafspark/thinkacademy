package com.bonree.sdk.am;

import com.bonree.sdk.bs.ad;
import com.bonree.sdk.bs.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import ohos.agp.utils.Point;
import ohos.agp.window.service.Display;
import ohos.agp.window.service.DisplayManager;
import ohos.app.Context;
import ohos.system.DeviceInfo;

public final class l extends f {
    private Context m = q.a();

    public l() {
        a();
    }

    public final void a() {
        super.a();
        if (this.m == null) {
            this.m = q.a();
        }
        this.e = u();
        this.f = v();
        this.i = Locale.getDefault().getLanguage();
        this.c = s();
        this.j = t();
        this.a = w();
        this.b = DeviceInfo.getModel();
        int a = a(this.m);
        int b = b(this.m);
        this.h = a + "*" + b;
        this.d = b(this.e);
        this.g = "user";
        this.k = (int) Math.ceil((double) c());
    }

    public final float c() {
        return (((float) this.m.getFilesDir().getTotalSpace()) / 1000.0f) / 1000.0f;
    }

    private static String s() {
        String d = ad.d("hw_sc.build.platform.version", (String) null);
        if (ad.c(d)) {
            return d;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("getprop");
        arrayList.add("hw_sc.build.platform.version");
        return ad.a((List<String>) arrayList);
    }

    private static String t() {
        String d = ad.d("ro.huawei.build.display.id", (String) null);
        if (ad.c(d)) {
            return d;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("getprop");
        arrayList.add("ro.huawei.build.display.id");
        return ad.a((List<String>) arrayList);
    }

    private static String u() {
        String d = ad.d("ro.product.cpu.abi", (String) null);
        if (ad.c(d)) {
            return d;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("getprop");
        arrayList.add("ro.product.cpu.abi");
        return ad.a((List<String>) arrayList);
    }

    private static String v() {
        String d = ad.d("ro.hardware", (String) null);
        if (ad.c(d)) {
            return d;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("getprop");
        arrayList.add("ro.hardware");
        return ad.a((List<String>) arrayList);
    }

    private static String w() {
        String d = ad.d("ro.product.brand", (String) null);
        if (ad.c(d)) {
            return d;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("getprop");
        arrayList.add("ro.product.brand");
        return ad.a((List<String>) arrayList);
    }

    private static int a(Context context) {
        float f = 0.0f;
        for (Display realSize : DisplayManager.getInstance().getAllDisplays(context)) {
            Point point = new Point();
            realSize.getRealSize(point);
            f += point.getPointX();
        }
        return (int) f;
    }

    private static int b(Context context) {
        float f = 0.0f;
        for (Display realSize : DisplayManager.getInstance().getAllDisplays(context)) {
            Point point = new Point();
            realSize.getRealSize(point);
            f += point.getPointY();
        }
        return (int) f;
    }
}
