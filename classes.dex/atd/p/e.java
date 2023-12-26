package atd.p;

import android.content.Context;
import atd.s0.a;

public class e extends a {
    /* renamed from: c */
    public Integer a(Context context) {
        String[] systemSharedLibraryNames = b(context).getSystemSharedLibraryNames();
        return Integer.valueOf(systemSharedLibraryNames != null ? systemSharedLibraryNames.length : 0);
    }

    public String a() {
        return a.a(-71187746843200L);
    }
}
