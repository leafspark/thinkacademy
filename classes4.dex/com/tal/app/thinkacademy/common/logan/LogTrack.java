package com.tal.app.thinkacademy.common.logan;

import android.text.TextUtils;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/common/logan/LogTrack;", "", "()V", "uploadLogInfo", "", "logUrl", "", "params", "Lcom/tal/app/thinkacademy/common/logan/FileParams;", "zipSize", "", "uploadLogUrl", "logDate", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LogTrack.kt */
public final class LogTrack {
    public static final LogTrack INSTANCE = new LogTrack();

    private LogTrack() {
    }

    public final void uploadLogUrl(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "logDate");
        Intrinsics.checkNotNullParameter(str2, "logUrl");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("log_date", str);
            jSONObject.put("log_url", str2);
            HwTrackUtil.INSTANCE.track("hw_upload_log", jSONObject);
        }
    }

    public final void uploadLogInfo(String str, FileParams fileParams, long j) {
        Intrinsics.checkNotNullParameter(str, "logUrl");
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("log_url", str);
            if (fileParams != null) {
                jSONObject.put("log_name", fileParams.getLogName());
                jSONObject.put("localFileUploadCreateTime", fileParams.getCreateTime());
                jSONObject.put("localZipFileUploadCreateTime", fileParams.getFinalTime());
                jSONObject.put("log_plan_mode", fileParams.getPlanMode());
                jSONObject.put("log_lesson_type", fileParams.getLessonType());
                jSONObject.put("log_plan_id", fileParams.getPlanId());
                jSONObject.put("localZipFileLength", j);
                HwTrackUtil.INSTANCE.track("upload_log_url", jSONObject);
            }
        }
    }
}
