package atd.t;

import android.content.Context;
import android.provider.Settings;

public final class b extends atd.q.a {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                atd.q.a$a[] r0 = atd.q.a.C0005a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                atd.q.a$a r1 = atd.q.a.C0005a.INTEGER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                atd.q.a$a r1 = atd.q.a.C0005a.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                atd.q.a$a r1 = atd.q.a.C0005a.LONG     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                atd.q.a$a r1 = atd.q.a.C0005a.STRING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atd.t.b.a.<clinit>():void");
        }
    }

    public b(String str, String str2) {
        super(str, str2);
    }

    /* access modifiers changed from: protected */
    public Object b(Context context) {
        try {
            int i = a.a[f().ordinal()];
            if (i == 1) {
                return Integer.valueOf(Settings.System.getInt(context.getContentResolver(), e()));
            }
            if (i == 2) {
                return Float.valueOf(Settings.System.getFloat(context.getContentResolver(), e()));
            }
            if (i != 3) {
                return Settings.System.getString(context.getContentResolver(), e());
            }
            return Long.valueOf(Settings.System.getLong(context.getContentResolver(), e()));
        } catch (Settings.SettingNotFoundException unused) {
            return null;
        }
    }
}
