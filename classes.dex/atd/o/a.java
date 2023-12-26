package atd.o;

import android.content.Context;
import android.os.Build;
import atd.i.b;

public class a implements b {
    /* renamed from: b */
    public Integer a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Integer.valueOf(context.getResources().getConfiguration().getLocales().size());
        }
        return 1;
    }

    public String a() {
        return atd.s0.a.a(-71101847497280L);
    }
}
