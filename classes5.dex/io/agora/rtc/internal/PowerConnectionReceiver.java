package io.agora.rtc.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import java.lang.ref.WeakReference;

public class PowerConnectionReceiver extends BroadcastReceiver {
    private WeakReference<CommonUtility> mCommonUtility;

    public PowerConnectionReceiver(CommonUtility commonUtility) {
        this.mCommonUtility = new WeakReference<>(commonUtility);
    }

    public void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        CommonUtility commonUtility = (CommonUtility) this.mCommonUtility.get();
        if (commonUtility == null) {
            Logging.w("rtc engine is not ready");
        } else if (intent != null) {
            int intExtra = intent.getIntExtra("level", -1);
            int intExtra2 = intent.getIntExtra("scale", -1);
            if (intExtra2 != 0) {
                commonUtility.onPowerChange((int) ((((float) intExtra) / ((float) intExtra2)) * 100.0f));
            }
        }
    }
}
