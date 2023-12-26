package atd.k;

import android.content.Context;
import android.os.Build;
import atd.i.c;
import atd.i.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a extends d {
    public String a() {
        return atd.s0.a.a(-74593655908928L);
    }

    /* access modifiers changed from: protected */
    public List<String> b() {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 29) {
            arrayList.add(atd.s0.a.a(-74606540810816L));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            arrayList.add(atd.s0.a.a(-73717482580544L));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String c(Context context) throws c {
        if (Build.VERSION.SDK_INT >= 26) {
            return Build.getSerial();
        }
        return Build.SERIAL;
    }
}
