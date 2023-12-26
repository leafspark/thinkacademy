package atd.m;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;
import atd.i.c;
import atd.s0.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class d extends atd.i.d {
    public String a() {
        return a.a(-74009540356672L);
    }

    /* access modifiers changed from: protected */
    public List<String> b() {
        if (Build.VERSION.SDK_INT < 31) {
            return Collections.singletonList(a.a(-73189201603136L));
        }
        return Collections.unmodifiableList(Arrays.asList(new String[]{a.a(-74022425258560L), a.a(-73313755654720L)}));
    }

    /* access modifiers changed from: protected */
    public Object c(Context context) throws c {
        if (Build.VERSION.SDK_INT >= 18) {
            BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService(a.a(-73614403365440L));
            BluetoothAdapter adapter = bluetoothManager != null ? bluetoothManager.getAdapter() : null;
            if (adapter != null) {
                return adapter.getName();
            }
            return null;
        }
        throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
