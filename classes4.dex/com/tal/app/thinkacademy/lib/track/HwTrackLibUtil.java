package com.tal.app.thinkacademy.lib.track;

import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u001a\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/lib/track/HwTrackLibUtil;", "", "()V", "mListener", "Lcom/tal/app/thinkacademy/lib/track/HwTrackListener;", "setListener", "", "listener", "track", "eventName", "", "jsonObject", "Lorg/json/JSONObject;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwTrackLibUtil.kt */
public final class HwTrackLibUtil {
    public static final HwTrackLibUtil INSTANCE = new HwTrackLibUtil();
    private static HwTrackListener mListener;

    private HwTrackLibUtil() {
    }

    public final void setListener(HwTrackListener hwTrackListener) {
        if (hwTrackListener != null) {
            mListener = hwTrackListener;
        }
    }

    public final void track(String str) {
        track(str, (JSONObject) null);
    }

    public final void track(String str, JSONObject jSONObject) {
        HwTrackListener hwTrackListener = mListener;
        if (hwTrackListener != null) {
            hwTrackListener.track(str, jSONObject);
        }
    }
}
