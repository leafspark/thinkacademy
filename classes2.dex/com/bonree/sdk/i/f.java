package com.bonree.sdk.i;

import android.bluetooth.le.ScanSettings;
import android.os.Build;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class f implements InvocationHandler {
    private /* synthetic */ Object a;
    private /* synthetic */ c b;

    f(c cVar, Object obj) {
        this.b = cVar;
        this.a = obj;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        ScanSettings scanSettings;
        ScanSettings scanSettings2;
        if ("registerScanner".equals(method.getName())) {
            c.c(this.b);
        } else if ("startScan".equals(method.getName())) {
            int i = -1;
            if (objArr.length > 0) {
                if (objArr[0] instanceof Integer) {
                    i = objArr[0].intValue();
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    scanSettings2 = null;
                    for (ScanSettings scanSettings3 : objArr) {
                        if (scanSettings3 instanceof ScanSettings) {
                            scanSettings2 = scanSettings3;
                        }
                    }
                    c.a(this.b, i, scanSettings2);
                }
            }
            scanSettings2 = null;
            c.a(this.b, i, scanSettings2);
        } else if ("startScanForIntent".equals(method.getName())) {
            if (Build.VERSION.SDK_INT < 21 || objArr == null) {
                scanSettings = null;
            } else {
                scanSettings = null;
                for (ScanSettings scanSettings4 : objArr) {
                    if (scanSettings4 instanceof ScanSettings) {
                        scanSettings = scanSettings4;
                    }
                }
            }
            c.a(this.b, scanSettings);
        }
        try {
            return this.b.b(this.a, method, objArr);
        } catch (Throwable th) {
            this.b.d.d("BRSDK.BluetoothHooker invokeBluetoothGatt fail", th);
            return null;
        }
    }
}
