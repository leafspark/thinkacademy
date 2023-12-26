package com.tal.app.thinkacademy.common.utils;

import android.os.Bundle;
import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.lib.interfaces.route.RouteMap;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogExtraBean;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/TempClassUtil;", "", "()V", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TempClassUtil.kt */
public final class TempClassUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String TYPE_LIVE = "3";
    /* access modifiers changed from: private */
    public static final String TYPE_PLAYBACK = "1";

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JK\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J?\u0010\u0014\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/TempClassUtil$Companion;", "", "()V", "TYPE_LIVE", "", "getTYPE_LIVE", "()Ljava/lang/String;", "TYPE_PLAYBACK", "getTYPE_PLAYBACK", "enterLiveVideo", "", "planId", "courseId", "bizId", "updateUserInfo", "subPlatformType", "", "isBindCourseware", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)V", "enterPlayBack", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)V", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TempClassUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTYPE_LIVE() {
            return TempClassUtil.TYPE_LIVE;
        }

        public final String getTYPE_PLAYBACK() {
            return TempClassUtil.TYPE_PLAYBACK;
        }

        public static /* synthetic */ void enterLiveVideo$default(Companion companion, String str, String str2, String str3, String str4, Integer num, boolean z, int i, Object obj) {
            if ((i & 8) != 0) {
                str4 = EnterRoomMuteData.STATUS_UN_MUTE;
            }
            String str5 = str4;
            if ((i & 16) != 0) {
                num = 0;
            }
            Integer num2 = num;
            if ((i & 32) != 0) {
                z = true;
            }
            companion.enterLiveVideo(str, str2, str3, str5, num2, z);
        }

        public final void enterLiveVideo(String str, String str2, String str3, String str4, Integer num, boolean z) {
            Bundle bundle = new Bundle();
            HashMap hashMap = new HashMap();
            hashMap.put("planId", str == null ? "" : str);
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("courseId", str2);
            if (str3 == null) {
                str3 = "";
            }
            hashMap.put("bizId", str3);
            if (str4 == null) {
                str4 = EnterRoomMuteData.STATUS_UN_MUTE;
            }
            hashMap.put("updateUserInfo", str4);
            hashMap.put("subPlatformType", String.valueOf(num));
            hashMap.put("isTemp", "1");
            hashMap.put("isBindCourseware", String.valueOf(z));
            bundle.putString("liveParams", GsonUtils.toJson(hashMap));
            ShareDataManager.getInstance().put(ShareDataKey.CURRENT_IS_SMALL_CLASS, num == null || num.intValue() != 0, ShareDataManager.SHAREDATA_CAN_CLEAR);
            XesRoute.getInstance().navigation(RouteMap.ROUTE_LIVE_ACTIVITY, bundle);
            if (str != null) {
                XesLogExtraBean.getInstance().setPlanId(Integer.parseInt(str));
            }
            XesLog.ut("student.Enter", new JsonObject());
        }

        public static /* synthetic */ void enterPlayBack$default(Companion companion, String str, String str2, String str3, Integer num, boolean z, int i, Object obj) {
            if ((i & 8) != 0) {
                num = 0;
            }
            Integer num2 = num;
            if ((i & 16) != 0) {
                z = true;
            }
            companion.enterPlayBack(str, str2, str3, num2, z);
        }

        public final void enterPlayBack(String str, String str2, String str3, Integer num, boolean z) {
            Bundle bundle = new Bundle();
            HashMap hashMap = new HashMap();
            hashMap.put("planId", str == null ? "" : str);
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("courseId", str2);
            if (str3 == null) {
                str3 = "";
            }
            hashMap.put("bizId", str3);
            hashMap.put("updateUserInfo", EnterRoomMuteData.STATUS_UN_MUTE);
            hashMap.put("subPlatformType", String.valueOf(num));
            hashMap.put("isBindCourseware", String.valueOf(z));
            bundle.putString("liveParams", GsonUtils.toJson(hashMap));
            ShareDataManager.getInstance().put(ShareDataKey.CURRENT_IS_SMALL_CLASS, false, ShareDataManager.SHAREDATA_CAN_CLEAR);
            XesRoute.getInstance().navigation(RouteMap.ROUTE_PLAY_BACK_ACTIVITY, bundle);
            if (str != null) {
                XesLogExtraBean.getInstance().setPlanId(Integer.parseInt(str));
            }
        }
    }
}
