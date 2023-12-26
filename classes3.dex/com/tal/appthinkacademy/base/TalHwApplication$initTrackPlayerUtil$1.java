package com.tal.appthinkacademy.base;

import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal.app.thinkacademy.lib.track.HwTrackListener;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/tal/appthinkacademy/base/TalHwApplication$initTrackPlayerUtil$1", "Lcom/tal/app/thinkacademy/lib/track/HwTrackListener;", "track", "", "eventName", "", "jsonObject", "Lorg/json/JSONObject;", "app_googleRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalHwApplication.kt */
public final class TalHwApplication$initTrackPlayerUtil$1 implements HwTrackListener {
    TalHwApplication$initTrackPlayerUtil$1() {
    }

    public void track(String str, JSONObject jSONObject) {
        HwTrackUtil.INSTANCE.track(str, jSONObject);
    }
}
