package atd.v;

import android.os.Build;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class t extends a0 {
    t() {
    }

    /* access modifiers changed from: protected */
    public List<String> b() {
        if (Build.VERSION.SDK_INT < 29) {
            return super.b();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.READ_PHONE_STATE");
        arrayList.add("android.permission.READ_PRIVILEGED_PHONE_STATE");
        return Collections.unmodifiableList(arrayList);
    }
}
