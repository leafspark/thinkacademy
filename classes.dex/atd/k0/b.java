package atd.k0;

import android.content.Context;
import atd.s0.a;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;

public final class b implements a {
    private final String a;

    static {
        a.a(-791436582513216L);
    }

    private b(String str) {
        this.a = str == null ? a.a(-791629856041536L) : str;
    }

    public static b a() {
        return a(a.a(-791513891924544L));
    }

    public static b a(String str) {
        return new b(str);
    }

    public String a(Context context, String str) {
        String str2 = this.a;
        return (!(context instanceof Context) ? context.getSharedPreferences(str2, 0) : XMLParseInstrumentation.getSharedPreferences(context, str2, 0)).getString(str, (String) null);
    }

    public void a(Context context, String str, String str2) {
        String str3 = this.a;
        (!(context instanceof Context) ? context.getSharedPreferences(str3, 0) : XMLParseInstrumentation.getSharedPreferences(context, str3, 0)).edit().putString(str, str2).apply();
    }
}
