package atd.j;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import atd.i.c;
import atd.s0.a;

public class d extends b {
    public String a() {
        return a.a(-74546411268672L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Boolean c(Context context) throws c {
        BluetoothAdapter d = d(context);
        if (d != null) {
            return Boolean.valueOf(d.isEnabled());
        }
        return null;
    }
}
