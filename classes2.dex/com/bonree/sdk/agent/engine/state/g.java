package com.bonree.sdk.agent.engine.state;

import com.bonree.sdk.bs.q;
import ohos.app.Context;
import ohos.net.ConnectionProperties;
import ohos.net.NetCapabilities;
import ohos.net.NetHandle;
import ohos.net.NetManager;
import ohos.net.NetStatusCallback;
import ohos.telephony.RadioInfoManager;

public class g extends m {
    /* access modifiers changed from: private */
    public static final String d = "g";
    private static final String g = "ohos.permission.GET_NETWORK_INFO";
    volatile int a = 0;
    private a e;
    private NetManager f;

    public final void b() {
        Context a2 = q.a();
        if (a2.verifySelfPermission(g) != 0) {
            com.bonree.sdk.be.a.a().e(d, "start HarmonyNetStateEngine error: no permission:ohos.permission.GET_NETWORK_INFO");
        } else if (this.e == null) {
            this.f = NetManager.getInstance(a2);
            h hVar = new h(this, a2, a2);
            this.e = hVar;
            this.f.addDefaultNetStatusCallback(hVar);
        }
    }

    public final void c() {
        a aVar;
        NetManager netManager = this.f;
        if (netManager != null && (aVar = this.e) != null) {
            netManager.removeNetStatusCallback(aVar);
        }
    }

    public static class a extends NetStatusCallback {
        private Context a;
        private String b = a.class.getSimpleName();

        public a(Context context) {
            this.a = context;
        }

        public void onAvailable(NetHandle netHandle) {
            g.super.onAvailable(netHandle);
            a();
        }

        public void onBlockedStatusChanged(NetHandle netHandle, boolean z) {
            g.super.onBlockedStatusChanged(netHandle, z);
        }

        public void onLosing(NetHandle netHandle, long j) {
            g.super.onLosing(netHandle, j);
        }

        public void onLost(NetHandle netHandle) {
            g.super.onLost(netHandle);
        }

        public void onUnavailable() {
            g.super.onUnavailable();
        }

        public void onCapabilitiesChanged(NetHandle netHandle, NetCapabilities netCapabilities) {
            g.super.onCapabilitiesChanged(netHandle, netCapabilities);
            a();
        }

        public void onConnectionPropertiesChanged(NetHandle netHandle, ConnectionProperties connectionProperties) {
            g.super.onConnectionPropertiesChanged(netHandle, connectionProperties);
        }

        private void a() {
            RadioInfoManager instance = RadioInfoManager.getInstance(this.a);
            instance.getRadioTech(instance.getPrimarySlotId());
        }
    }

    static class b {
        /* access modifiers changed from: private */
        public static final g a = new g();

        private b() {
        }
    }

    public static g d() {
        return b.a;
    }
}
