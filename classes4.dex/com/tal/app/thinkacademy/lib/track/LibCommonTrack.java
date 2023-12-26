package com.tal.app.thinkacademy.lib.track;

import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/lib/track/LibCommonTrack;", "", "()V", "glideLoadFailed", "", "url", "", "errorMsg", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LibCommonTrack.kt */
public final class LibCommonTrack {
    public static final LibCommonTrack INSTANCE = new LibCommonTrack();

    private LibCommonTrack() {
    }

    public final void glideLoadFailed(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("hw_glide_load_url", str);
            jSONObject.put("hw_glide_load_error_msg", str2);
            HwTrackLibUtil.INSTANCE.track("hw_glide_load_failed", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
