package com.tal.app.thinkacademy.live.util;

import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal.app.thinkacademy.live.core.utils.LiveTrack;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006J\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J&\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0010J\u0016\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006J&\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0006J\u000e\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0006J\u0016\u0010%\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0006J\u0016\u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0010J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0010J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0006J\u000e\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0006J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0006J_\u0010.\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u00106J\u0001\u00107\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010:\u001a\u0004\u0018\u0001032\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010=¨\u0006>"}, d2 = {"Lcom/tal/app/thinkacademy/live/util/DriverTrack;", "", "()V", "classRoomBase", "", "eventName", "", "jsonObject", "Lorg/json/JSONObject;", "classRoomInteractChatSend", "classRoomInteractGameQuit", "interactId", "classRoomInteractMessageReply", "classRoomInteractOnlyShow", "classRoomInteractOnlySwitch", "switchType", "", "classRoomInteractPhotographClick", "classRoomInteractPhotographControl", "controlType", "classRoomInteractPhotographSubmit", "classRoomInteractShorcutSend", "sentenceContent", "classRoomInteractShorcutShow", "classRoomInteractTutorMessage", "classRoomInteractVideoChat", "video_chat_type", "video_state", "voice_state", "classRoomInteractVideoChatControl", "control_type", "classroomInteractGift", "gift_id", "gift_price", "click_button", "interact_id", "classroomInteractGiftIcon", "classroomInteractRedPacketClick", "classroomInteractTreasureClick", "classroomMyCamera", "switch_type", "classroomToolbarClick", "tool_name", "classroomToolbarProblem", "problem_type", "classroomToolbarVideo", "emojiPackageShow", "planId", "classId", "lessonType", "isPrepare", "", "previousSource", "packageId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "emojiRelated", "emojiId", "emojiName", "emojiFree", "emojiDetaiId", "emojiDetaiName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DriverTrack.kt */
public final class DriverTrack {
    public static final DriverTrack INSTANCE = new DriverTrack();

    private DriverTrack() {
    }

    public static /* synthetic */ void emojiPackageShow$default(DriverTrack driverTrack, String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "";
        }
        if ((i & 8) != 0) {
            str4 = "";
        }
        if ((i & 16) != 0) {
            bool = false;
        }
        if ((i & 32) != 0) {
            str5 = "";
        }
        if ((i & 64) != 0) {
            str6 = "";
        }
        driverTrack.emojiPackageShow(str, str2, str3, str4, bool, str5, str6);
    }

    public final void emojiPackageShow(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("plan_id", str2);
            jSONObject.put(ClassParamsKt.CLASS_ID, str3);
            jSONObject.put("lesson_type", str4);
            jSONObject.put("is_prepare", bool);
            jSONObject.put("previous_source", str5);
            jSONObject.put("package_id", str6);
        } catch (Exception unused) {
        }
        HwTrackUtil.INSTANCE.track("hw_classroom_emoji_icon_click", jSONObject);
    }

    public static /* synthetic */ void emojiRelated$default(DriverTrack driverTrack, String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, String str7, Boolean bool2, String str8, String str9, String str10, int i, Object obj) {
        boolean z;
        int i2 = i;
        String str11 = (i2 & 1) != 0 ? "hw_classroom_emoji_send" : str;
        String str12 = "";
        String str13 = (i2 & 2) != 0 ? str12 : str2;
        String str14 = (i2 & 4) != 0 ? str12 : str3;
        String str15 = (i2 & 8) != 0 ? str12 : str4;
        if ((i2 & 16) != 0) {
            z = false;
        } else {
            z = bool;
        }
        String str16 = (i2 & 32) != 0 ? str12 : str5;
        String str17 = (i2 & 64) != 0 ? str12 : str6;
        String str18 = (i2 & 128) != 0 ? str12 : str7;
        Boolean bool3 = (i2 & 256) != 0 ? null : bool2;
        String str19 = (i2 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? str12 : str8;
        String str20 = (i2 & 1024) != 0 ? str12 : str9;
        if ((i2 & 2048) == 0) {
            str12 = str10;
        }
        driverTrack.emojiRelated(str11, str13, str14, str15, z, str16, str17, str18, bool3, str19, str20, str12);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030 A[Catch:{ Exception -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003a A[Catch:{ Exception -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0046 A[Catch:{ Exception -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0050 A[Catch:{ Exception -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005c A[Catch:{ Exception -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0063 A[Catch:{ Exception -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0064 A[Catch:{ Exception -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072 A[Catch:{ Exception -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007e A[Catch:{ Exception -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0088 A[Catch:{ Exception -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0094 A[Catch:{ Exception -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009e A[Catch:{ Exception -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00aa A[Catch:{ Exception -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b1 A[Catch:{ Exception -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00b2 A[Catch:{ Exception -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c0 A[Catch:{ Exception -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00cc A[Catch:{ Exception -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d6 A[Catch:{ Exception -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e2 A[Catch:{ Exception -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f5 A[Catch:{ Exception -> 0x00fa }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void emojiRelated(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.Boolean r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.Boolean r23, java.lang.String r24, java.lang.String r25, java.lang.String r26) {
        /*
            r14 = this;
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r20
            r5 = r21
            r6 = r22
            r7 = r24
            r8 = r25
            r9 = r26
            java.lang.String r10 = "eventName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r10)
            org.json.JSONObject r10 = new org.json.JSONObject
            r10.<init>()
            r11 = r1
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ Exception -> 0x00fa }
            r12 = 0
            r13 = 1
            if (r11 == 0) goto L_0x002d
            boolean r11 = kotlin.text.StringsKt.isBlank(r11)     // Catch:{ Exception -> 0x00fa }
            if (r11 == 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r11 = r12
            goto L_0x002e
        L_0x002d:
            r11 = r13
        L_0x002e:
            if (r11 != 0) goto L_0x0035
            java.lang.String r11 = "plan_id"
            r10.put(r11, r1)     // Catch:{ Exception -> 0x00fa }
        L_0x0035:
            r1 = r2
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x00fa }
            if (r1 == 0) goto L_0x0043
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)     // Catch:{ Exception -> 0x00fa }
            if (r1 == 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r1 = r12
            goto L_0x0044
        L_0x0043:
            r1 = r13
        L_0x0044:
            if (r1 != 0) goto L_0x004b
            java.lang.String r1 = "class_id"
            r10.put(r1, r2)     // Catch:{ Exception -> 0x00fa }
        L_0x004b:
            r1 = r3
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x00fa }
            if (r1 == 0) goto L_0x0059
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)     // Catch:{ Exception -> 0x00fa }
            if (r1 == 0) goto L_0x0057
            goto L_0x0059
        L_0x0057:
            r1 = r12
            goto L_0x005a
        L_0x0059:
            r1 = r13
        L_0x005a:
            if (r1 != 0) goto L_0x0061
            java.lang.String r1 = "lesson_type"
            r10.put(r1, r3)     // Catch:{ Exception -> 0x00fa }
        L_0x0061:
            if (r19 != 0) goto L_0x0064
            goto L_0x006d
        L_0x0064:
            boolean r1 = r19.booleanValue()     // Catch:{ Exception -> 0x00fa }
            java.lang.String r2 = "is_prepare"
            r10.put(r2, r1)     // Catch:{ Exception -> 0x00fa }
        L_0x006d:
            r1 = r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x00fa }
            if (r1 == 0) goto L_0x007b
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)     // Catch:{ Exception -> 0x00fa }
            if (r1 == 0) goto L_0x0079
            goto L_0x007b
        L_0x0079:
            r1 = r12
            goto L_0x007c
        L_0x007b:
            r1 = r13
        L_0x007c:
            if (r1 != 0) goto L_0x0083
            java.lang.String r1 = "previous_source"
            r10.put(r1, r4)     // Catch:{ Exception -> 0x00fa }
        L_0x0083:
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x00fa }
            if (r1 == 0) goto L_0x0091
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)     // Catch:{ Exception -> 0x00fa }
            if (r1 == 0) goto L_0x008f
            goto L_0x0091
        L_0x008f:
            r1 = r12
            goto L_0x0092
        L_0x0091:
            r1 = r13
        L_0x0092:
            if (r1 != 0) goto L_0x0099
            java.lang.String r1 = "emoji_id"
            r10.put(r1, r5)     // Catch:{ Exception -> 0x00fa }
        L_0x0099:
            r1 = r6
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x00fa }
            if (r1 == 0) goto L_0x00a7
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)     // Catch:{ Exception -> 0x00fa }
            if (r1 == 0) goto L_0x00a5
            goto L_0x00a7
        L_0x00a5:
            r1 = r12
            goto L_0x00a8
        L_0x00a7:
            r1 = r13
        L_0x00a8:
            if (r1 != 0) goto L_0x00af
            java.lang.String r1 = "emoji_name"
            r10.put(r1, r6)     // Catch:{ Exception -> 0x00fa }
        L_0x00af:
            if (r23 != 0) goto L_0x00b2
            goto L_0x00bb
        L_0x00b2:
            boolean r1 = r23.booleanValue()     // Catch:{ Exception -> 0x00fa }
            java.lang.String r2 = "emoji_free"
            r10.put(r2, r1)     // Catch:{ Exception -> 0x00fa }
        L_0x00bb:
            r1 = r7
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x00fa }
            if (r1 == 0) goto L_0x00c9
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)     // Catch:{ Exception -> 0x00fa }
            if (r1 == 0) goto L_0x00c7
            goto L_0x00c9
        L_0x00c7:
            r1 = r12
            goto L_0x00ca
        L_0x00c9:
            r1 = r13
        L_0x00ca:
            if (r1 != 0) goto L_0x00d1
            java.lang.String r1 = "emoji_detai_id"
            r10.put(r1, r7)     // Catch:{ Exception -> 0x00fa }
        L_0x00d1:
            r1 = r8
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x00fa }
            if (r1 == 0) goto L_0x00df
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)     // Catch:{ Exception -> 0x00fa }
            if (r1 == 0) goto L_0x00dd
            goto L_0x00df
        L_0x00dd:
            r1 = r12
            goto L_0x00e0
        L_0x00df:
            r1 = r13
        L_0x00e0:
            if (r1 != 0) goto L_0x00e7
            java.lang.String r1 = "emoji_detai_name"
            r10.put(r1, r8)     // Catch:{ Exception -> 0x00fa }
        L_0x00e7:
            r1 = r9
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x00fa }
            if (r1 == 0) goto L_0x00f2
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)     // Catch:{ Exception -> 0x00fa }
            if (r1 == 0) goto L_0x00f3
        L_0x00f2:
            r12 = r13
        L_0x00f3:
            if (r12 != 0) goto L_0x00fa
            java.lang.String r1 = "package_id"
            r10.put(r1, r9)     // Catch:{ Exception -> 0x00fa }
        L_0x00fa:
            com.tal.app.thinkacademy.common.sensors.HwTrackUtil r1 = com.tal.app.thinkacademy.common.sensors.HwTrackUtil.INSTANCE
            r1.track(r15, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.util.DriverTrack.emojiRelated(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final void classroomMyCamera(int i) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("switch_type", i);
        LiveTrack.INSTANCE.classTrack("hw_classroom_my_camera", jSONObject);
    }

    public final void classroomToolbarClick(String str) {
        Intrinsics.checkNotNullParameter(str, "tool_name");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("tool_name", str);
        LiveTrack.INSTANCE.classTrack("hw_classroom_toolbar_click", jSONObject);
    }

    public final void classroomToolbarProblem(String str) {
        Intrinsics.checkNotNullParameter(str, "problem_type");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("problem_type", str);
        LiveTrack.INSTANCE.classTrack("hw_classroom_toolbar_problem", jSONObject);
    }

    public final void classroomToolbarVideo(String str) {
        Intrinsics.checkNotNullParameter(str, "switch_type");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("switch_type", str);
        LiveTrack.INSTANCE.classTrack("hw_classroom_toolbar_video", jSONObject);
    }

    public final void classroomInteractRedPacketClick(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "interact_id");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("click_button", i);
        jSONObject.put("interact_id", str);
        LiveTrack.INSTANCE.classTrack("hw_classroom_interact_red_packet_click", jSONObject);
    }

    public final void classroomInteractGift(int i, int i2, int i3, String str) {
        Intrinsics.checkNotNullParameter(str, "interact_id");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("click_button", i3);
        jSONObject.put("gift_id", i);
        jSONObject.put("gift_price", i2);
        jSONObject.put("interact_id", str);
        LiveTrack.INSTANCE.classTrack("hw_classroom_interact_gift", jSONObject);
    }

    public final void classroomInteractGiftIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "interact_id");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("interact_id", str);
        LiveTrack.INSTANCE.classTrack("hw_classroom_interact_gift_icon", jSONObject);
    }

    public final void classroomInteractTreasureClick(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "interact_id");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("interact_id", str);
        jSONObject.put("click_button", i);
        LiveTrack.INSTANCE.classTrack("hw_classroom_interact_treasure_click", jSONObject);
    }

    public final void classRoomInteractShorcutShow() {
        classRoomBase$default(this, "hw_classroom_chat_shortcut_show", (JSONObject) null, 2, (Object) null);
    }

    public final void classRoomInteractShorcutSend(String str) {
        Intrinsics.checkNotNullParameter(str, "sentenceContent");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sentence_content", str);
        Unit unit = Unit.INSTANCE;
        classRoomBase("hw_classroom_chat_shortcut", jSONObject);
    }

    public final void classRoomInteractChatSend() {
        classRoomBase$default(this, "hw_classroom_chat_send", (JSONObject) null, 2, (Object) null);
    }

    public final void classRoomInteractOnlyShow() {
        classRoomBase$default(this, "hw_classroom_teacher_only_show", (JSONObject) null, 2, (Object) null);
    }

    public final void classRoomInteractOnlySwitch(int i) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("switch_type", i);
        Unit unit = Unit.INSTANCE;
        classRoomBase("hw_classroom_teacher_only_switch", jSONObject);
    }

    public final void classRoomInteractTutorMessage() {
        classRoomBase$default(this, "hw_classroom_tutor_message", (JSONObject) null, 2, (Object) null);
    }

    public final void classRoomInteractMessageReply() {
        classRoomBase$default(this, "hw_classroom_tutor_message_reply", (JSONObject) null, 2, (Object) null);
    }

    public final void classRoomInteractPhotographClick(String str) {
        Intrinsics.checkNotNullParameter(str, "interactId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("interact_id", str);
        Unit unit = Unit.INSTANCE;
        classRoomBase("hw_classroom_interact_photograph_click", jSONObject);
    }

    public final void classRoomInteractPhotographControl(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "interactId");
        Intrinsics.checkNotNullParameter(str2, "controlType");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("interact_id", str);
        jSONObject.put("control_type", str2);
        Unit unit = Unit.INSTANCE;
        classRoomBase("hw_classroom_interact_photograph_control", jSONObject);
    }

    public final void classRoomInteractPhotographSubmit(String str) {
        Intrinsics.checkNotNullParameter(str, "interactId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("interact_id", str);
        jSONObject.put("submit_type", 1);
        Unit unit = Unit.INSTANCE;
        classRoomBase("hw_classroom_interact_photograph_submit", jSONObject);
    }

    public final void classRoomInteractGameQuit(String str) {
        Intrinsics.checkNotNullParameter(str, "interactId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("interact_id", str);
        Unit unit = Unit.INSTANCE;
        classRoomBase("hw_classroom_interact_game_quit", jSONObject);
    }

    public final void classRoomInteractVideoChat(String str, String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "interactId");
        Intrinsics.checkNotNullParameter(str2, "video_chat_type");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("interact_id", str);
        jSONObject.put("video_chat_type", str2);
        jSONObject.put("video_state", i);
        jSONObject.put("voice_state", i2);
        Unit unit = Unit.INSTANCE;
        classRoomBase("hw_classroom_interact_video_chat", jSONObject);
    }

    public final void classRoomInteractVideoChatControl(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "interactId");
        Intrinsics.checkNotNullParameter(str2, "control_type");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("interact_id", str);
        jSONObject.put("control_type", str2);
        Unit unit = Unit.INSTANCE;
        classRoomBase("hw_classroom_interact_video_chat_control", jSONObject);
    }

    static /* synthetic */ void classRoomBase$default(DriverTrack driverTrack, String str, JSONObject jSONObject, int i, Object obj) {
        if ((i & 2) != 0) {
            jSONObject = null;
        }
        driverTrack.classRoomBase(str, jSONObject);
    }

    private final void classRoomBase(String str, JSONObject jSONObject) {
        LiveTrack liveTrack = LiveTrack.INSTANCE;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        liveTrack.classTrack(str, jSONObject);
    }
}
