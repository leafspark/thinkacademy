package com.tal.app.thinkacademy.business.login.entity;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/NetTestState;", "", "()V", "createDownloadBean", "Lcom/tal/app/thinkacademy/business/login/entity/NetTestBean;", "speed", "", "createIrcBean", "count", "createRtcBean", "quality", "createServerBean", "millisTime", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetTestBean.kt */
public final class NetTestState {
    public static final NetTestState INSTANCE = new NetTestState();

    private NetTestState() {
    }

    public final NetTestBean createRtcBean(int i) {
        NetTestType netTestType = NetTestType.RTC;
        boolean z = false;
        if (i >= 0 && i < 5) {
            z = true;
        }
        return new NetTestBean(netTestType, z);
    }

    public final NetTestBean createIrcBean(int i) {
        return new NetTestBean(NetTestType.IRC, i >= 19);
    }

    public final NetTestBean createServerBean(long j) {
        NetTestType netTestType = NetTestType.SERVER;
        boolean z = false;
        if (1 <= j && j < 3001) {
            z = true;
        }
        return new NetTestBean(netTestType, z);
    }

    public final NetTestBean createDownloadBean(int i) {
        return new NetTestBean(NetTestType.DOWNLOAD, i >= 200);
    }
}
