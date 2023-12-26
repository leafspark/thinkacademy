package atd.h;

import atd.y.c;
import com.adyen.threeds2.exception.InvalidInputException;

final class f {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                atd.h.a[] r0 = atd.h.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                atd.h.a r1 = atd.h.a.V1_1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                atd.h.a r1 = atd.h.a.V1_4     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atd.h.f.a.<clinit>():void");
        }
    }

    public static c a(a aVar) throws InvalidInputException {
        int i = a.a[aVar.ordinal()];
        if (i == 1) {
            return new d();
        }
        if (i == 2) {
            return new e();
        }
        throw c.DEVICE_DATA_FAILURE.a();
    }
}
