package com.tal.app.thinkacademy.live.business.function.view;

import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiAssembleBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "emojiAssembleBean", "Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiAssembleBean;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FunctionPluginView.kt */
final class FunctionPluginView$createEmojiPopWindow$window$1 extends Lambda implements Function1<EmojiAssembleBean, Unit> {
    final /* synthetic */ FunctionPluginView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FunctionPluginView$createEmojiPopWindow$window$1(FunctionPluginView functionPluginView) {
        super(1);
        this.this$0 = functionPluginView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((EmojiAssembleBean) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x009f, code lost:
        r2 = (r2 = r2.getDataStorage()).getCourseInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(com.tal.app.thinkacademy.live.business.emoji.bean.EmojiAssembleBean r23) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            java.lang.String r2 = "emojiAssembleBean"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            com.tal.app.thinkacademy.live.business.function.view.FunctionPluginView r2 = r0.this$0
            int r3 = r2.currentIndex
            r4 = 1
            int r3 = r3 + r4
            com.tal.app.thinkacademy.live.business.function.view.FunctionPluginView r5 = r0.this$0
            int r5 = r5.COOL_DOWN_COUNT
            int r3 = r3 % r5
            r2.currentIndex = r3
            com.tal.app.thinkacademy.live.business.function.view.FunctionPluginView r2 = r0.this$0
            long[] r2 = r2.sendTime
            com.tal.app.thinkacademy.live.business.function.view.FunctionPluginView r3 = r0.this$0
            int r3 = r3.currentIndex
            long r5 = android.os.SystemClock.elapsedRealtime()
            r2[r3] = r5
            com.tal.app.thinkacademy.live.business.function.view.FunctionPluginView r2 = r0.this$0
            long[] r2 = r2.sendTime
            com.tal.app.thinkacademy.live.business.function.view.FunctionPluginView r3 = r0.this$0
            int r3 = r3.currentIndex
            r5 = r2[r3]
            com.tal.app.thinkacademy.live.business.function.view.FunctionPluginView r2 = r0.this$0
            long[] r2 = r2.sendTime
            com.tal.app.thinkacademy.live.business.function.view.FunctionPluginView r3 = r0.this$0
            int r3 = r3.currentIndex
            int r3 = r3 + r4
            com.tal.app.thinkacademy.live.business.function.view.FunctionPluginView r7 = r0.this$0
            int r7 = r7.COOL_DOWN_COUNT
            int r3 = r3 % r7
            r7 = r2[r3]
            long r5 = r5 - r7
            com.tal.app.thinkacademy.live.business.function.view.FunctionPluginView r2 = r0.this$0
            int r2 = r2.COOL_DOWN_TIME
            long r2 = (long) r2
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0062
            com.tal.app.thinkacademy.live.business.function.view.FunctionPluginView r2 = r0.this$0
            r2.emojiCountDown()
        L_0x0062:
            com.tal.app.thinkacademy.live.business.function.view.FunctionPluginView r2 = r0.this$0
            com.tal.app.thinkacademy.live.business.function.FunctionPluginDriver r2 = r2.getDriver()
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r2 = r2.getLiveRoomProvider()
            if (r2 != 0) goto L_0x006f
            goto L_0x0072
        L_0x006f:
            com.tal.app.thinkacademy.live.business.emoji.util.EmojiUtil.sendPadEmojiMsg(r2, r1)
        L_0x0072:
            com.tal.app.thinkacademy.common.appmonitor.HWEventTracking$Companion r2 = com.tal.app.thinkacademy.common.appmonitor.HWEventTracking.Companion
            com.tal.app.thinkacademy.common.appmonitor.HWEventTracking r2 = r2.get()
            java.lang.String r3 = r23.getEmojiName()
            if (r3 != 0) goto L_0x0080
            java.lang.String r3 = ""
        L_0x0080:
            java.lang.String r5 = "group"
            java.lang.String r6 = "emoji"
            r2.ostaCbSendMsg(r5, r6, r3)
            com.tal.app.thinkacademy.live.util.DriverTrack r7 = com.tal.app.thinkacademy.live.util.DriverTrack.INSTANCE
            com.tal.app.thinkacademy.live.business.function.view.FunctionPluginView r2 = r0.this$0
            com.tal.app.thinkacademy.live.business.function.FunctionPluginDriver r2 = r2.getDriver()
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r2 = r2.getLiveRoomProvider()
            r3 = 0
            if (r2 != 0) goto L_0x0098
        L_0x0096:
            r9 = r3
            goto L_0x00b3
        L_0x0098:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r2 = r2.getDataStorage()
            if (r2 != 0) goto L_0x009f
            goto L_0x0096
        L_0x009f:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r2 = r2.getCourseInfo()
            if (r2 != 0) goto L_0x00a6
            goto L_0x0096
        L_0x00a6:
            int r2 = r2.getPlanId()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r2 = r2.toString()
            r9 = r2
        L_0x00b3:
            com.tal.app.thinkacademy.live.business.function.view.FunctionPluginView r2 = r0.this$0
            com.tal.app.thinkacademy.live.business.function.FunctionPluginDriver r2 = r2.getDriver()
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r2 = r2.getLiveRoomProvider()
            if (r2 != 0) goto L_0x00c1
        L_0x00bf:
            r10 = r3
            goto L_0x00dc
        L_0x00c1:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r2 = r2.getDataStorage()
            if (r2 != 0) goto L_0x00c8
            goto L_0x00bf
        L_0x00c8:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r2 = r2.getCourseInfo()
            if (r2 != 0) goto L_0x00cf
            goto L_0x00bf
        L_0x00cf:
            int r2 = r2.getClassId()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r2 = r2.toString()
            r10 = r2
        L_0x00dc:
            com.tal.app.thinkacademy.live.business.function.view.FunctionPluginView r2 = r0.this$0
            com.tal.app.thinkacademy.live.business.function.FunctionPluginDriver r2 = r2.getDriver()
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r2 = r2.getLiveRoomProvider()
            if (r2 != 0) goto L_0x00ea
            r2 = r3
            goto L_0x00ee
        L_0x00ea:
            java.lang.String r2 = r2.getClassType()
        L_0x00ee:
            java.lang.String r5 = "0"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r5)
            if (r5 == 0) goto L_0x00fa
            java.lang.String r2 = "大班"
        L_0x00f8:
            r11 = r2
            goto L_0x0108
        L_0x00fa:
            java.lang.String r5 = "1"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r5)
            if (r2 == 0) goto L_0x0105
            java.lang.String r2 = "伪小班"
            goto L_0x00f8
        L_0x0105:
            java.lang.String r2 = "小班"
            goto L_0x00f8
        L_0x0108:
            java.lang.String r14 = r23.getEmojiPackageId()
            java.lang.String r15 = r23.getEmojiPackageName()
            java.lang.Integer r2 = r23.getType()
            if (r2 != 0) goto L_0x0117
            goto L_0x011e
        L_0x0117:
            int r2 = r2.intValue()
            if (r2 != r4) goto L_0x011e
            goto L_0x011f
        L_0x011e:
            r4 = 0
        L_0x011f:
            java.lang.String r17 = r23.getEmojiId()
            java.lang.String r18 = r23.getEmojiName()
            com.tal.app.thinkacademy.live.business.function.view.FunctionPluginView r1 = r0.this$0
            com.tal.app.thinkacademy.live.business.function.FunctionPluginDriver r1 = r1.getDriver()
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r1 = r1.getLiveRoomProvider()
            if (r1 != 0) goto L_0x0136
        L_0x0133:
            r19 = r3
            goto L_0x0152
        L_0x0136:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r1 = r1.getDataStorage()
            if (r1 != 0) goto L_0x013d
            goto L_0x0133
        L_0x013d:
            com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy r1 = r1.getPlanInfo()
            if (r1 != 0) goto L_0x0144
            goto L_0x0133
        L_0x0144:
            long r1 = r1.getPackageId()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r1 = r1.toString()
            r19 = r1
        L_0x0152:
            r12 = 0
            java.lang.Boolean r16 = java.lang.Boolean.valueOf(r4)
            r20 = 16
            r21 = 0
            java.lang.String r8 = "hw_classroom_emoji_send"
            java.lang.String r13 = "课中"
            com.tal.app.thinkacademy.live.util.DriverTrack.emojiRelated$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.function.view.FunctionPluginView$createEmojiPopWindow$window$1.invoke(com.tal.app.thinkacademy.live.business.emoji.bean.EmojiAssembleBean):void");
    }
}
