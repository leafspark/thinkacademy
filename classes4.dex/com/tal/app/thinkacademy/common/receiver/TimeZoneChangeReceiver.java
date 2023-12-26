package com.tal.app.thinkacademy.common.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tal.app.thinkacademy.common.utils.TimeZoneUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/common/receiver/TimeZoneChangeReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TimeZoneChangeReceiver.kt */
public final class TimeZoneChangeReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("时区发生了变化,action = ");
        sb.append(intent == null ? null : intent.getAction());
        sb.append(",当前时区为：");
        sb.append(TimeZone.getDefault().getID());
        sb.append(",app时区为：");
        sb.append(TimeZoneUtil.INSTANCE.getTimeZone());
        objArr[0] = sb.toString();
        XesLog.dt("", objArr);
        XesDataBus.with(DataBusKey.SYSTEM_TIME_ZONE_CHANGED).postStickyData("");
    }
}
