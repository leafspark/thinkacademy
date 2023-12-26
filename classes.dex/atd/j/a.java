package atd.j;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import atd.i.c;

public class a extends b {
    public String a() {
        return atd.s0.a.a(-74456216955456L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public String c(Context context) throws c {
        BluetoothAdapter d = d(context);
        if (d != null) {
            return d.getAddress();
        }
        return null;
    }
}
