package com.tal.app.thinkacademy.common.entity;

import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal.app.thinkacademy.lib.download.model.FilePoint;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/DataFilePoint;", "Lcom/tal/app/thinkacademy/lib/download/model/FilePoint;", "()V", "courseDownloadStart", "", "onFailed", "", "code", "", "message", "", "progress", "errorInfo", "onFinished", "onStart", "track", "jsonObject", "Lorg/json/JSONObject;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DataFilePoint.kt */
public class DataFilePoint extends FilePoint {
    private long courseDownloadStart;

    public void onStart() {
        this.courseDownloadStart = System.currentTimeMillis();
        XesLog.i(Tag.GLOBAL_DOWNLOAD, Intrinsics.stringPlus("onStart: fileName = ", this.fileName), Intrinsics.stringPlus("url = ", getRealUrl()));
    }

    public void onFinished() {
        XesLog.i(Tag.GLOBAL_DOWNLOAD, Intrinsics.stringPlus("onFinished: fileName = ", this.fileName), Intrinsics.stringPlus("url = ", getRealUrl()));
        ShareDataManager.getInstance().put(Intrinsics.stringPlus("courseware_download_size_", getRealFileName()), -1, ShareDataManager.SHAREDATA_CAN_CLEAR);
        ShareDataManager.getInstance().put(Intrinsics.stringPlus(getRealFileName(), ShareDataKey.ADDITION_DOWNLOAD_COURSEWARE), getMd5(), ShareDataManager.SHAREDATA_CAN_CLEAR);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("hw_download_result", "success");
        track(jSONObject);
    }

    public void onFailed(int i, String str, String str2, String str3) {
        XesLog.i(Tag.GLOBAL_DOWNLOAD, Intrinsics.stringPlus("onFailed: fileName = ", this.fileName), Intrinsics.stringPlus("url = ", getRealUrl()));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("hw_download_result", "fail");
        jSONObject.put("hw_download_error_type", i + '_' + str);
        jSONObject.put("hw_download_error_msg", str3);
        track(jSONObject);
    }

    public final void track(JSONObject jSONObject) {
        double d;
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.courseDownloadStart;
        long j2 = currentTimeMillis - j;
        if (j2 > 0 && j > 0) {
            double d2 = 0.0d;
            try {
                BigDecimal divide = BigDecimal.valueOf(getFileSize()).divide(BigDecimal.valueOf(1048576), 2, 4);
                Intrinsics.checkNotNullExpressionValue(divide, "valueOf(fileSize).divide…HALF_UP\n                )");
                if (divide.doubleValue() <= 0.0d) {
                    divide = BigDecimal.ZERO;
                    Intrinsics.checkNotNullExpressionValue(divide, "ZERO");
                }
                d = divide.doubleValue();
            } catch (Throwable th) {
                th.printStackTrace();
                d = 0.0d;
            }
            try {
                BigDecimal divide2 = BigDecimal.valueOf(j2).divide(BigDecimal.valueOf(1000), 3, 4);
                Intrinsics.checkNotNullExpressionValue(divide2, "valueOf(downloadCost)\n  …BigDecimal.ROUND_HALF_UP)");
                if (divide2.doubleValue() <= 0.0d) {
                    divide2 = BigDecimal.ZERO;
                    Intrinsics.checkNotNullExpressionValue(divide2, "ZERO");
                }
                d2 = divide2.doubleValue();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            jSONObject.put("hw_download_url", getRealUrl());
            jSONObject.put("hw_download_file_size", d);
            jSONObject.put("hw_download_type", getResBusinessType());
            HashMap hashMap = this.expandData;
            if (hashMap != null) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("hw_download_duration", d2);
            HwTrackUtil.INSTANCE.track("hw_download_global", jSONObject);
        }
    }
}
