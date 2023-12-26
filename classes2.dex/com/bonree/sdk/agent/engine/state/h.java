package com.bonree.sdk.agent.engine.state;

import com.bonree.sdk.agent.engine.state.g;
import com.bonree.sdk.be.a;
import ohos.app.Context;
import ohos.net.NetCapabilities;
import ohos.net.NetHandle;
import ohos.telephony.RadioInfoManager;

final class h extends g.a {
    private /* synthetic */ Context a;
    private /* synthetic */ g b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    h(g gVar, Context context, Context context2) {
        super(context);
        this.b = gVar;
        this.a = context2;
    }

    public final void onAvailable(NetHandle netHandle) {
        super.onAvailable(netHandle);
        this.b.a = 1;
        this.b.b = new k();
    }

    public final void onCapabilitiesChanged(NetHandle netHandle, NetCapabilities netCapabilities) {
        String str;
        super.onCapabilitiesChanged(netHandle, netCapabilities);
        try {
            if (netCapabilities.hasCap(16) && this.b.a == 1) {
                if (!netCapabilities.hasBearer(1)) {
                    if (!netCapabilities.hasBearer(5)) {
                        if (netCapabilities.hasBearer(0) || netCapabilities.hasBearer(3)) {
                            RadioInfoManager instance = RadioInfoManager.getInstance(this.a);
                            int radioTech = instance.getRadioTech(instance.getPrimarySlotId());
                            switch (radioTech) {
                                case 1:
                                    str = "GSM";
                                    break;
                                case 2:
                                    str = "CDMA - 1xRTT";
                                    break;
                                case 3:
                                    str = "UMTS";
                                    break;
                                case 4:
                                    str = "HSPA";
                                    break;
                                case 5:
                                    str = "HSPA+";
                                    break;
                                case 6:
                                    str = "TD_SCDMA";
                                    break;
                                case 7:
                                    str = "CDMA - EvDo rev. 0";
                                    break;
                                case 8:
                                    str = "CDMA - eHRPD";
                                    break;
                                case 9:
                                    str = "LTE";
                                    break;
                                case 10:
                                    str = "LTE_CA";
                                    break;
                                case 11:
                                    str = "IWLAN";
                                    break;
                                case 12:
                                    str = "NR";
                                    break;
                                default:
                                    str = "UNKNOWN";
                                    break;
                            }
                            this.b.a(radioTech, str);
                        }
                        this.b.a(this.b.b);
                        this.b.a = 0;
                    }
                }
                this.b.a(0);
                this.b.a(this.b.b);
                this.b.a = 0;
            }
        } catch (Throwable th) {
            a.a().e(g.d, "onCapabilitiesChanged", th);
        }
    }

    public final void onLost(NetHandle netHandle) {
        super.onLost(netHandle);
        this.b.b = new k();
        this.b.f();
        this.b.a(this.b.b);
    }
}
