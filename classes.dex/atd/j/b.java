package atd.j;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;
import atd.i.c;
import atd.i.d;
import atd.s0.a;
import java.util.Collections;
import java.util.List;

abstract class b extends d {
    b() {
    }

    /* access modifiers changed from: protected */
    public List<String> b() {
        return Collections.singletonList(a.a(-74469101857344L));
    }

    /* access modifiers changed from: package-private */
    public BluetoothAdapter d(Context context) throws c {
        return e(context).getAdapter();
    }

    /* access modifiers changed from: package-private */
    public BluetoothManager e(Context context) throws c {
        BluetoothManager bluetoothManager;
        if (Build.VERSION.SDK_INT >= 18 && (bluetoothManager = (BluetoothManager) context.getSystemService(a.a(-74310188067392L))) != null) {
            return bluetoothManager;
        }
        throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
