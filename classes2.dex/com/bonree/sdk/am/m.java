package com.bonree.sdk.am;

import com.bonree.sdk.bs.q;
import ohos.aafwk.ability.DataAbilityHelper;
import ohos.aafwk.ability.SystemMemoryInfo;
import ohos.app.Context;
import ohos.batterymanager.BatteryInfo;
import ohos.location.Locator;
import ohos.sysappcomponents.settings.SystemSettings;

public final class m extends i {
    private static final String j = "ohos.permission.LOCATION";
    private Context k;
    private DataAbilityHelper l;

    public m() {
        Context a = q.a();
        this.k = a;
        this.l = DataAbilityHelper.creator(a);
        h();
        j();
    }

    public final void a() {
        this.f = new Locator(this.k).isLocationSwitchOn();
    }

    public final void b() {
        if ("1".equals(SystemSettings.getValue(this.l, "bluetooth_status"))) {
            this.e = true;
        } else {
            this.e = false;
        }
    }

    private void a(String str) {
        if ("1".equals(str)) {
            this.e = true;
        } else {
            this.e = false;
        }
    }

    public final void c() {
        SystemMemoryInfo systemMemoryInfo = new SystemMemoryInfo();
        this.k.getAbilityManager().getSystemMemoryInfo(systemMemoryInfo);
        this.d = (int) ((((double) systemMemoryInfo.getAvailSysMem()) / 1024.0d) / 1024.0d);
    }

    public final void d() {
        this.c = (int) ((((double) this.k.getFilesDir().getFreeSpace()) / 1024.0d) / 1024.0d);
        if (((byte) this.k.getResourceManager().getConfiguration().direction) == 0) {
            this.h = 1;
        } else {
            this.h = 2;
        }
        this.b = new BatteryInfo().getCapacity();
    }

    private static int a(Context context) {
        return context.getResourceManager().getConfiguration().direction;
    }
}
