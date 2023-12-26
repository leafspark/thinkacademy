package com.tal.app.thinkacademy.business.home.main;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import com.tal.app.thinkacademy.common.location.CustomLocationManager;
import com.tal.app.thinkacademy.common.location.listener.SimpleLocationListener;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;

@Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006\u0012"}, d2 = {"com/tal/app/thinkacademy/business/home/main/LaunchActivity$startLocation$1$1", "Lcom/tal/app/thinkacademy/common/location/listener/SimpleLocationListener;", "locationResult", "", "result", "", "updateGPSProviderStatus", "gpsStatus", "", "updateLocation", "location", "Landroid/location/Location;", "updateStatus", "provider", "", "status", "extras", "Landroid/os/Bundle;", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LaunchActivity.kt */
public final class LaunchActivity$startLocation$1$1 implements SimpleLocationListener {
    final /* synthetic */ LaunchActivity this$0;

    public void updateGPSProviderStatus(int i) {
    }

    public void updateStatus(String str, int i, Bundle bundle) {
    }

    LaunchActivity$startLocation$1$1(LaunchActivity launchActivity) {
        this.this$0 = launchActivity;
    }

    public void updateLocation(Location location) {
        this.this$0.hideLoading();
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("longitude = ");
        sb.append(location == null ? null : Double.valueOf(location.getLongitude()));
        sb.append(" latitude = ");
        sb.append(location == null ? null : Double.valueOf(location.getLatitude()));
        objArr[0] = sb.toString();
        XesLog.dt("LaunchActivity分校信息", objArr);
        CustomLocationManager.Companion.getInstance((Context) this.this$0).onDestroy();
        this.this$0.analysisLocation(location);
        Handler access$getMHandler$p = this.this$0.mHandler;
        if (access$getMHandler$p != null) {
            access$getMHandler$p.removeCallbacksAndMessages((Object) null);
        }
    }

    public void locationResult(boolean z) {
        this.this$0.hideLoading();
        if (!z) {
            this.this$0.goNormalNext("outside_white_list");
        }
    }
}
