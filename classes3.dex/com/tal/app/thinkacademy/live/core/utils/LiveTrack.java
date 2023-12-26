package com.tal.app.thinkacademy.live.core.utils;

import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.live.core.live.bean.LiveRoomData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tJ(\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J(\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rH\u0007J\u0006\u0010\u0014\u001a\u00020\u0006J(\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00162\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rH\u0007J,\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0007J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u000e\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0004J\u0016\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001bJ\u001e\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/utils/LiveTrack;", "", "()V", "TAG", "", "classTrack", "", "event", "args", "Lorg/json/JSONObject;", "commonLiveTrack", "eventKey", "params", "", "courseLoadError", "domain", "Lcom/tal/app/thinkacademy/live/core/utils/Domain;", "courseLoadStep", "step", "Lcom/tal/app/thinkacademy/live/core/utils/CourseLoadStep;", "enterClassRoom", "gameLoadStep", "Lcom/tal/app/thinkacademy/live/core/utils/GameLoadStep;", "hw_student_playback_duration", "teachId", "teacherName", "progress", "", "playStatus", "playbackLoadDuration", "duration", "", "praiseListDownload", "interactId", "praiseListTrumup", "count", "reportCpu", "cpuAppUse", "", "cpuTotalUser", "plan_id", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveTrack.kt */
public final class LiveTrack {
    public static final LiveTrack INSTANCE = new LiveTrack();
    public static final String TAG = "LiveTrack";

    @JvmStatic
    public static final void courseLoadStep(CourseLoadStep courseLoadStep) {
        Intrinsics.checkNotNullParameter(courseLoadStep, "step");
        courseLoadStep$default(courseLoadStep, (Map) null, 2, (Object) null);
    }

    private LiveTrack() {
    }

    public final void praiseListDownload(String str) {
        Intrinsics.checkNotNullParameter(str, "interactId");
        commonLiveTrack("praise_list_stu_download", MapsKt.mutableMapOf(new Pair("interact_id", str)));
    }

    public final void praiseListTrumup(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "interactId");
        commonLiveTrack("praise_list_stu_trumup", MapsKt.mutableMapOf(new Pair("interact_id", str), new Pair("click_num", Integer.valueOf(i))));
    }

    @JvmStatic
    public static final void playbackLoadDuration(long j) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("playback_load_duration", Long.valueOf(j));
        INSTANCE.commonLiveTrack("hw_stu_playback_load_duration", linkedHashMap);
    }

    @JvmStatic
    public static final void hw_student_playback_duration(String str, String str2, int i, int i2) {
        LiveRoomData liveRoomData = LiveTrackData.mLiveRoomData;
        if (liveRoomData != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("plan_id", liveRoomData.getPlanId());
                jSONObject.put(ClassParamsKt.CLASS_ID, LiveTrackData.mClassId);
                jSONObject.put("content_teacher_id", ParseUtils.tryParseInt(str, 0));
                jSONObject.put("content_teacher", str2);
                jSONObject.put("rightnow_play_status", i2);
                jSONObject.put("rightnow_play_progress", i);
            } catch (Exception unused) {
            }
            HwTrackUtil.INSTANCE.track("hw_student_playback_duration", jSONObject);
        }
    }

    public final void enterClassRoom() {
        String previousSource;
        Map linkedHashMap = new LinkedHashMap();
        LiveRoomData liveRoomData = LiveTrackData.mLiveRoomData;
        if (!(liveRoomData == null || (previousSource = liveRoomData.getPreviousSource()) == null)) {
            linkedHashMap.put("previous_source", previousSource);
        }
        commonLiveTrack("hw_stu_enter_class_room", linkedHashMap);
    }

    public final void reportCpu(double d, double d2, String str) {
        Intrinsics.checkNotNullParameter(str, "plan_id");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("plan_id", str);
            jSONObject.put("cpu_app_usage", d);
            jSONObject.put("cpu_total_usage", d2);
        } catch (Exception unused) {
        }
        HwTrackUtil.INSTANCE.track("hw_stu_cpu_class_room", jSONObject);
    }

    public static /* synthetic */ void classTrack$default(LiveTrack liveTrack, String str, JSONObject jSONObject, int i, Object obj) {
        if ((i & 2) != 0) {
            jSONObject = null;
        }
        liveTrack.classTrack(str, jSONObject);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void classTrack(java.lang.String r5, org.json.JSONObject r6) {
        /*
            r4 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.tal.app.thinkacademy.live.core.live.bean.LiveRoomData r0 = com.tal.app.thinkacademy.live.core.utils.LiveTrackData.mLiveRoomData     // Catch:{ Exception -> 0x007a }
            if (r0 != 0) goto L_0x000a
            goto L_0x0054
        L_0x000a:
            if (r6 != 0) goto L_0x000d
            goto L_0x0016
        L_0x000d:
            java.lang.String r1 = "plan_id"
            java.lang.String r2 = r0.getPlanId()     // Catch:{ Exception -> 0x007a }
            r6.put(r1, r2)     // Catch:{ Exception -> 0x007a }
        L_0x0016:
            if (r6 != 0) goto L_0x0019
            goto L_0x0054
        L_0x0019:
            java.lang.String r1 = "lesson_type"
            java.lang.String r2 = r0.getSubPlatformType()     // Catch:{ Exception -> 0x007a }
            if (r2 == 0) goto L_0x004d
            int r3 = r2.hashCode()     // Catch:{ Exception -> 0x007a }
            switch(r3) {
                case 48: goto L_0x0041;
                case 49: goto L_0x0035;
                case 50: goto L_0x0029;
                default: goto L_0x0028;
            }     // Catch:{ Exception -> 0x007a }
        L_0x0028:
            goto L_0x004d
        L_0x0029:
            java.lang.String r3 = "2"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x007a }
            if (r2 != 0) goto L_0x0032
            goto L_0x004d
        L_0x0032:
            java.lang.String r0 = "小班"
            goto L_0x0051
        L_0x0035:
            java.lang.String r3 = "1"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x007a }
            if (r2 != 0) goto L_0x003e
            goto L_0x004d
        L_0x003e:
            java.lang.String r0 = "伪小班"
            goto L_0x0051
        L_0x0041:
            java.lang.String r3 = "0"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x007a }
            if (r2 != 0) goto L_0x004a
            goto L_0x004d
        L_0x004a:
            java.lang.String r0 = "大班"
            goto L_0x0051
        L_0x004d:
            java.lang.String r0 = r0.getSubPlatformType()     // Catch:{ Exception -> 0x007a }
        L_0x0051:
            r6.put(r1, r0)     // Catch:{ Exception -> 0x007a }
        L_0x0054:
            java.lang.Integer r0 = com.tal.app.thinkacademy.live.core.utils.LiveTrackData.mClassId     // Catch:{ Exception -> 0x007a }
            if (r0 != 0) goto L_0x0059
            goto L_0x0067
        L_0x0059:
            java.lang.Number r0 = (java.lang.Number) r0     // Catch:{ Exception -> 0x007a }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x007a }
            if (r6 != 0) goto L_0x0062
            goto L_0x0067
        L_0x0062:
            java.lang.String r1 = "class_id"
            r6.put(r1, r0)     // Catch:{ Exception -> 0x007a }
        L_0x0067:
            java.lang.String r0 = com.tal.app.thinkacademy.live.core.utils.LiveTrackData.mGradeName     // Catch:{ Exception -> 0x007a }
            if (r0 != 0) goto L_0x006c
            goto L_0x0074
        L_0x006c:
            if (r6 != 0) goto L_0x006f
            goto L_0x0074
        L_0x006f:
            java.lang.String r1 = "grade_name"
            r6.put(r1, r0)     // Catch:{ Exception -> 0x007a }
        L_0x0074:
            com.tal.app.thinkacademy.common.sensors.HwTrackUtil r0 = com.tal.app.thinkacademy.common.sensors.HwTrackUtil.INSTANCE     // Catch:{ Exception -> 0x007a }
            r0.track(r5, r6)     // Catch:{ Exception -> 0x007a }
            goto L_0x007e
        L_0x007a:
            r5 = move-exception
            r5.printStackTrace()
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.core.utils.LiveTrack.classTrack(java.lang.String, org.json.JSONObject):void");
    }

    public static /* synthetic */ void courseLoadStep$default(CourseLoadStep courseLoadStep, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        courseLoadStep(courseLoadStep, map);
    }

    @JvmStatic
    public static final void courseLoadStep(CourseLoadStep courseLoadStep, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(courseLoadStep, "step");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("step", courseLoadStep.getStep());
        linkedHashMap.put("description", courseLoadStep.getDesc());
        if (!(map == null || (r3 = map.entrySet().iterator()) == null)) {
            for (Map.Entry next : map.entrySet()) {
                linkedHashMap.put((String) next.getKey(), next.getValue());
            }
        }
        INSTANCE.commonLiveTrack("hw_course_load_step", linkedHashMap);
    }

    @JvmStatic
    public static final void courseLoadError(Domain domain) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("domain", domain.getType().getValue());
        linkedHashMap.put("code", Integer.valueOf(domain.getCode()));
        linkedHashMap.put("msg", domain.getMsg());
        linkedHashMap.put("path", domain.getPath());
        courseLoadStep(CourseLoadStep.Error, linkedHashMap);
    }

    public static /* synthetic */ void gameLoadStep$default(GameLoadStep gameLoadStep, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        gameLoadStep(gameLoadStep, map);
    }

    @JvmStatic
    public static final void gameLoadStep(GameLoadStep gameLoadStep, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(gameLoadStep, "step");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("step", gameLoadStep.getStep());
        linkedHashMap.put("description", gameLoadStep.getDesc());
        if (!(map == null || (r3 = map.entrySet().iterator()) == null)) {
            for (Map.Entry next : map.entrySet()) {
                linkedHashMap.put((String) next.getKey(), next.getValue());
            }
        }
        INSTANCE.commonLiveTrack("hw_course_game_step", linkedHashMap);
    }

    static /* synthetic */ void commonLiveTrack$default(LiveTrack liveTrack, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        liveTrack.commonLiveTrack(str, map);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void commonLiveTrack(java.lang.String r9, java.util.Map<java.lang.String, ? extends java.lang.Object> r10) {
        /*
            r8 = this;
            boolean r0 = com.tal.app.thinkacademy.live.core.utils.LiveTrackData.mInLive
            if (r0 != 0) goto L_0x0032
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "数据销毁，遗弃埋点："
            r2.append(r3)
            r2.append(r9)
            java.lang.String r9 = " ["
            r2.append(r9)
            java.lang.String r9 = com.tal.app.thinkacademy.lib.util.GsonUtils.toJson(r10)
            r2.append(r9)
            r9 = 93
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            r0[r1] = r9
            java.lang.String r9 = "LiveTrack"
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r9, r0)
            return
        L_0x0032:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            com.tal.app.thinkacademy.live.core.live.bean.LiveRoomData r1 = com.tal.app.thinkacademy.live.core.utils.LiveTrackData.mLiveRoomData
            if (r1 != 0) goto L_0x003d
            goto L_0x013a
        L_0x003d:
            java.lang.String r2 = r1.getPlanId()
            java.lang.String r3 = "plan_id"
            r0.put(r3, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r1.getPlanId()
            r2.append(r3)
            r3 = 95
            r2.append(r3)
            java.lang.String r3 = com.tal.app.thinkacademy.live.core.utils.LiveTrackData.getMUserId()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "classroom_planid_userid"
            r0.put(r3, r2)
            java.lang.String r2 = r1.getSubPlatformType()
            java.lang.String r3 = "1"
            if (r2 == 0) goto L_0x0099
            int r4 = r2.hashCode()
            switch(r4) {
                case 48: goto L_0x008d;
                case 49: goto L_0x0083;
                case 50: goto L_0x0077;
                default: goto L_0x0076;
            }
        L_0x0076:
            goto L_0x0099
        L_0x0077:
            java.lang.String r4 = "2"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0080
            goto L_0x0099
        L_0x0080:
            java.lang.String r2 = "小班"
            goto L_0x009d
        L_0x0083:
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x008a
            goto L_0x0099
        L_0x008a:
            java.lang.String r2 = "伪小班"
            goto L_0x009d
        L_0x008d:
            java.lang.String r4 = "0"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0096
            goto L_0x0099
        L_0x0096:
            java.lang.String r2 = "大班"
            goto L_0x009d
        L_0x0099:
            java.lang.String r2 = r1.getSubPlatformType()
        L_0x009d:
            java.lang.String r4 = "lesson_type"
            r0.put(r4, r2)
            java.lang.String r2 = "package_id"
            java.lang.String r4 = r1.getPackageId()     // Catch:{ all -> 0x00b8 }
            if (r4 != 0) goto L_0x00ac
            r4 = 0
            goto L_0x00b4
        L_0x00ac:
            long r4 = java.lang.Long.parseLong(r4)     // Catch:{ all -> 0x00b8 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x00b8 }
        L_0x00b4:
            r0.put(r2, r4)     // Catch:{ all -> 0x00b8 }
            goto L_0x00bc
        L_0x00b8:
            r2 = move-exception
            r2.printStackTrace()
        L_0x00bc:
            java.lang.String r2 = r1.getCourseId()
            java.lang.String r4 = "class_id"
            r0.put(r4, r2)
            boolean r2 = r1.isParentAudit()
            java.lang.String r4 = "旁听课"
            java.lang.String r5 = "临时课"
            java.lang.String r6 = "course_type"
            if (r2 == 0) goto L_0x00d7
            java.lang.String r2 = "家长旁听"
            r0.put(r6, r2)
            goto L_0x011a
        L_0x00d7:
            java.lang.String r2 = r1.getLessonType()
            if (r2 == 0) goto L_0x0113
            int r7 = r2.hashCode()
            switch(r7) {
                case -1633171941: goto L_0x0107;
                case 476614193: goto L_0x00fc;
                case 1758698061: goto L_0x00f1;
                case 2079517679: goto L_0x00e5;
                default: goto L_0x00e4;
            }
        L_0x00e4:
            goto L_0x0113
        L_0x00e5:
            java.lang.String r7 = "FORMAL"
            boolean r2 = r2.equals(r7)
            if (r2 != 0) goto L_0x00ee
            goto L_0x0113
        L_0x00ee:
            java.lang.String r2 = "正式课"
            goto L_0x0117
        L_0x00f1:
            java.lang.String r7 = "AUDITION"
            boolean r2 = r2.equals(r7)
            if (r2 != 0) goto L_0x00fa
            goto L_0x0113
        L_0x00fa:
            r2 = r4
            goto L_0x0117
        L_0x00fc:
            java.lang.String r7 = "TEMPORARY"
            boolean r2 = r2.equals(r7)
            if (r2 != 0) goto L_0x0105
            goto L_0x0113
        L_0x0105:
            r2 = r5
            goto L_0x0117
        L_0x0107:
            java.lang.String r7 = "PLAYBACK"
            boolean r2 = r2.equals(r7)
            if (r2 != 0) goto L_0x0110
            goto L_0x0113
        L_0x0110:
            java.lang.String r2 = "回放"
            goto L_0x0117
        L_0x0113:
            java.lang.String r2 = r1.getLessonType()
        L_0x0117:
            r0.put(r6, r2)
        L_0x011a:
            java.lang.String r2 = r1.getIsTemp()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            java.lang.String r3 = "正常课"
            if (r2 == 0) goto L_0x0127
            goto L_0x0128
        L_0x0127:
            r5 = r3
        L_0x0128:
            java.lang.String r2 = "isTemp"
            r0.put(r2, r5)
            boolean r1 = r1.isAuditor()
            if (r1 == 0) goto L_0x0134
            goto L_0x0135
        L_0x0134:
            r4 = r3
        L_0x0135:
            java.lang.String r1 = "isAudition"
            r0.put(r1, r4)
        L_0x013a:
            java.lang.String r1 = com.tal.app.thinkacademy.live.core.utils.LiveTrackData.mRoomId
            if (r1 != 0) goto L_0x013f
            goto L_0x0144
        L_0x013f:
            java.lang.String r2 = "roomId"
            r0.put(r2, r1)
        L_0x0144:
            java.lang.String r1 = com.tal.app.thinkacademy.live.core.utils.LiveTrackData.mTraceId
            if (r1 != 0) goto L_0x0149
            goto L_0x014e
        L_0x0149:
            java.lang.String r2 = "traceId"
            r0.put(r2, r1)
        L_0x014e:
            java.lang.String r1 = com.tal.app.thinkacademy.live.core.utils.LiveTrackData.mCourseTraceId
            if (r1 != 0) goto L_0x0153
            goto L_0x0158
        L_0x0153:
            java.lang.String r2 = "courseTraceId"
            r0.put(r2, r1)
        L_0x0158:
            java.lang.String r1 = com.tal.app.thinkacademy.live.core.utils.LiveTrackData.mPlanMode
            if (r1 != 0) goto L_0x015d
            goto L_0x0162
        L_0x015d:
            java.lang.String r2 = "plan_mode"
            r0.put(r2, r1)
        L_0x0162:
            java.lang.String r1 = com.tal.app.thinkacademy.live.core.utils.LiveTrackData.mIrcState
            if (r1 != 0) goto L_0x0167
            goto L_0x016c
        L_0x0167:
            java.lang.String r2 = "ircJoinState"
            r0.put(r2, r1)
        L_0x016c:
            java.lang.String r1 = com.tal.app.thinkacademy.live.core.utils.LiveTrackData.mLocalServerState
            if (r1 != 0) goto L_0x0171
            goto L_0x0176
        L_0x0171:
            java.lang.String r2 = "localServerState"
            r0.put(r2, r1)
        L_0x0176:
            if (r10 != 0) goto L_0x0179
            goto L_0x019e
        L_0x0179:
            java.util.Set r10 = r10.entrySet()
            java.util.Iterator r10 = r10.iterator()
            if (r10 != 0) goto L_0x0184
            goto L_0x019e
        L_0x0184:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto L_0x019e
            java.lang.Object r1 = r10.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.getValue()
            r0.put(r2, r1)
            goto L_0x0184
        L_0x019e:
            com.tal.app.thinkacademy.common.sensors.HwTrackUtil r10 = com.tal.app.thinkacademy.common.sensors.HwTrackUtil.INSTANCE
            r10.track(r9, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.core.utils.LiveTrack.commonLiveTrack(java.lang.String, java.util.Map):void");
    }
}
