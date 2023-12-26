package com.tal.app.thinkacademy.business.bus_hummer.track;

import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/business/bus_hummer/track/HummerTrack;", "", "()V", "hw_hummer_page", "", "type", "Lcom/tal/app/thinkacademy/business/bus_hummer/track/HummerTrack$HummerPageActionType;", "url", "", "timeMs", "", "errorMsg", "HummerPageActionType", "bus_hummer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HummerTrack.kt */
public final class HummerTrack {
    public static final HummerTrack INSTANCE = new HummerTrack();

    private HummerTrack() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/business/bus_hummer/track/HummerTrack$HummerPageActionType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "START", "SUCCESS", "FAILED", "bus_hummer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HummerTrack.kt */
    public enum HummerPageActionType {
        START("开始"),
        SUCCESS("成功"),
        FAILED("失败");
        
        private final String type;

        private HummerPageActionType(String str) {
            this.type = str;
        }

        public final String getType() {
            return this.type;
        }
    }

    public static /* synthetic */ void hw_hummer_page$default(HummerTrack hummerTrack, HummerPageActionType hummerPageActionType, String str, long j, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 0;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            str2 = null;
        }
        hummerTrack.hw_hummer_page(hummerPageActionType, str, j2, str2);
    }

    public final void hw_hummer_page(HummerPageActionType hummerPageActionType, String str, long j, String str2) {
        Intrinsics.checkNotNullParameter(hummerPageActionType, ClassParamsKt.TYPE);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("hummer_page_action_type", hummerPageActionType.getType());
            jSONObject.put("hummer_page_url", str);
            jSONObject.put("hummer_page_cost_time", j);
            jSONObject.put("hummer_page_error_msg", str2);
            HwTrackUtil.INSTANCE.track("hw_hummer_page", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
