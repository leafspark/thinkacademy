package com.tal.app.thinkacademy.common.utils;

import android.os.Bundle;
import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.entity.PlaybackUrlEntity;
import com.tal.app.thinkacademy.lib.interfaces.route.RouteMap;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogExtraBean;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/StudyCenterUtil;", "", "()V", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudyCenterUtil.kt */
public final class StudyCenterUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String TYPE_LIVE = "3";
    /* access modifiers changed from: private */
    public static final String TYPE_PLAYBACK = "1";

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0001\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0019J]\u0010\u001a\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/StudyCenterUtil$Companion;", "", "()V", "TYPE_LIVE", "", "getTYPE_LIVE", "()Ljava/lang/String;", "TYPE_PLAYBACK", "getTYPE_PLAYBACK", "enterLiveVideo", "", "planId", "courseId", "bizId", "updateUserInfo", "subPlatformType", "", "isTemp", "isBindCourseware", "", "isParentAudit", "isAuditor", "lessonType", "previousSource", "packageId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "enterPlayBack", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StudyCenterUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTYPE_LIVE() {
            return StudyCenterUtil.TYPE_LIVE;
        }

        public final String getTYPE_PLAYBACK() {
            return StudyCenterUtil.TYPE_PLAYBACK;
        }

        public static /* synthetic */ void enterLiveVideo$default(Companion companion, String str, String str2, String str3, String str4, Integer num, String str5, boolean z, boolean z2, boolean z3, String str6, String str7, String str8, int i, Object obj) {
            int i2 = i;
            companion.enterLiveVideo(str, str2, str3, (i2 & 8) != 0 ? EnterRoomMuteData.STATUS_UN_MUTE : str4, (i2 & 16) != 0 ? 0 : num, (i2 & 32) != 0 ? EnterRoomMuteData.STATUS_UN_MUTE : str5, (i2 & 64) != 0 ? true : z, (i2 & LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP) != 0 ? false : z2, (i2 & 256) != 0 ? false : z3, str6, str7, str8);
        }

        public final void enterLiveVideo(String str, String str2, String str3, String str4, Integer num, String str5, boolean z, boolean z2, boolean z3, String str6, String str7, String str8) {
            String str9 = str6;
            String str10 = str7;
            String str11 = str8;
            Bundle bundle = new Bundle();
            HashMap hashMap = new HashMap();
            String str12 = "";
            hashMap.put("planId", str == null ? str12 : str);
            hashMap.put("courseId", str2 == null ? str12 : str2);
            if (str3 != null) {
                str12 = str3;
            }
            hashMap.put("bizId", str12);
            String str13 = EnterRoomMuteData.STATUS_UN_MUTE;
            hashMap.put("updateUserInfo", str4 == null ? str13 : str4);
            hashMap.put("subPlatformType", String.valueOf(num));
            if (str5 != null) {
                str13 = str5;
            }
            hashMap.put("isTemp", str13);
            hashMap.put("isBindCourseware", String.valueOf(z));
            hashMap.put("isParentAudit", String.valueOf(z2));
            hashMap.put("isAuditor", String.valueOf(z3));
            if (str9 != null) {
                String str14 = (String) hashMap.put("lessonType", str9);
            }
            if (str10 != null) {
                String str15 = (String) hashMap.put("previousSource", str10);
            }
            if (str11 != null) {
                hashMap.put("packageId", str11);
            }
            bundle.putString("liveParams", GsonUtils.toJson(hashMap));
            ShareDataManager.getInstance().put(ShareDataKey.CURRENT_IS_SMALL_CLASS, num == null || num.intValue() != 0, ShareDataManager.SHAREDATA_CAN_CLEAR);
            XesRoute.getInstance().navigation(RouteMap.ROUTE_LIVE_ACTIVITY, bundle);
            if (str != null) {
                XesLogExtraBean.getInstance().setPlanId(Integer.parseInt(str));
            }
            XesLog.ut("student.Enter", new JsonObject());
        }

        public static /* synthetic */ void enterPlayBack$default(Companion companion, String str, String str2, String str3, Integer num, boolean z, String str4, String str5, String str6, int i, Object obj) {
            companion.enterPlayBack(str, str2, str3, (i & 8) != 0 ? 0 : num, (i & 16) != 0 ? true : z, str4, str5, str6);
        }

        public final void enterPlayBack(String str, String str2, String str3, Integer num, boolean z, String str4, String str5, String str6) {
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
            if (str4 != null) {
                hashMap.put("lessonType", str4);
            }
            if (str5 != null) {
                hashMap.put("previousSource", str5);
            }
            if (str6 != null) {
                hashMap.put("packageId", str6);
            }
            hashMap.put("playbackUrl", (PlaybackUrlEntity) GsonUtils.fromJson("{\"list\":[{\"address\":\"http://vod-test.thethinkacademy.com/6c98a880vodcq1500002796/8f416754387702306858306346/playlist_eof.m3u8\",\"key\":0},{\"address\":\"https://pa-s3-playback-test.thethinkacademy.com/cloudRecording/8601/1304771484/0a0c7aeb40475a5dc53bf0ad737f40b2_1304771484.m3u8\",\"key\":0}],\"share\":[]}", PlaybackUrlEntity.class));
            bundle.putString("liveParams", GsonUtils.toJson(hashMap));
            ShareDataManager.getInstance().put(ShareDataKey.CURRENT_IS_SMALL_CLASS, false, ShareDataManager.SHAREDATA_CAN_CLEAR);
            XesRoute.getInstance().navigation(RouteMap.ROUTE_PLAY_BACK_ACTIVITY, bundle);
            if (str != null) {
                XesLogExtraBean.getInstance().setPlanId(Integer.parseInt(str));
            }
        }
    }
}
