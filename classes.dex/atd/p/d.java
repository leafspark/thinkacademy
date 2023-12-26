package atd.p;

import android.content.Context;
import android.content.pm.FeatureInfo;
import atd.s0.a;

public class d extends a {
    /* renamed from: c */
    public Integer a(Context context) {
        FeatureInfo[] systemAvailableFeatures = b(context).getSystemAvailableFeatures();
        return Integer.valueOf(systemAvailableFeatures != null ? systemAvailableFeatures.length : 0);
    }

    public String a() {
        return a.a(-71174861941312L);
    }
}
