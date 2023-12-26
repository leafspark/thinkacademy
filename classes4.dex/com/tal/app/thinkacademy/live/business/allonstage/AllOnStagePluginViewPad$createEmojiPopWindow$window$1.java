package com.tal.app.thinkacademy.live.business.allonstage;

import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.AllOnStageViewModel;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiAssembleBean;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiLocalImageResourceBean;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiOnlineImageResourceBean;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiOnlineLottieResourceBean;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy;
import com.tal.app.thinkacademy.live.util.DriverTrack;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "emojiAssembleBean", "Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiAssembleBean;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStagePluginViewPad.kt */
final class AllOnStagePluginViewPad$createEmojiPopWindow$window$1 extends Lambda implements Function1<EmojiAssembleBean, Unit> {
    final /* synthetic */ AllOnStagePluginViewPad this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AllOnStagePluginViewPad$createEmojiPopWindow$window$1(AllOnStagePluginViewPad allOnStagePluginViewPad) {
        super(1);
        this.this$0 = allOnStagePluginViewPad;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((EmojiAssembleBean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(EmojiAssembleBean emojiAssembleBean) {
        EmojiBean emojiBean;
        String str;
        PlanInfoProxy planInfo;
        CourseInfoProxy courseInfo;
        CourseInfoProxy courseInfo2;
        EmojiAssembleBean emojiAssembleBean2 = emojiAssembleBean;
        Intrinsics.checkNotNullParameter(emojiAssembleBean2, "emojiAssembleBean");
        AllOnStagePluginViewPad allOnStagePluginViewPad = this.this$0;
        long access$getMUserId$p = allOnStagePluginViewPad.mUserId;
        Integer type = emojiAssembleBean.getType();
        String str2 = "";
        boolean z = true;
        String str3 = null;
        if (type != null && type.intValue() == 1) {
            String emojiName = emojiAssembleBean.getEmojiName();
            Integer type2 = emojiAssembleBean.getType();
            int intValue = type2 == null ? 1 : type2.intValue();
            Integer resId = emojiAssembleBean.getResId();
            emojiBean = new EmojiBean(emojiName, intValue, new EmojiLocalImageResourceBean(resId == null ? -1 : resId.intValue()));
        } else {
            if (type != null) {
                int i = 2;
                if (type.intValue() == 2) {
                    String emojiName2 = emojiAssembleBean.getEmojiName();
                    Integer type3 = emojiAssembleBean.getType();
                    if (type3 != null) {
                        i = type3.intValue();
                    }
                    String lottieUrl = emojiAssembleBean.getLottieUrl();
                    if (lottieUrl == null) {
                        lottieUrl = str2;
                    }
                    emojiBean = new EmojiBean(emojiName2, i, new EmojiOnlineLottieResourceBean(lottieUrl));
                }
            }
            if (type != null) {
                int i2 = 3;
                if (type.intValue() == 3) {
                    String emojiName3 = emojiAssembleBean.getEmojiName();
                    Integer type4 = emojiAssembleBean.getType();
                    if (type4 != null) {
                        i2 = type4.intValue();
                    }
                    String lottieUrl2 = emojiAssembleBean.getLottieUrl();
                    if (lottieUrl2 == null) {
                        lottieUrl2 = str2;
                    }
                    emojiBean = new EmojiBean(emojiName3, i2, new EmojiOnlineImageResourceBean(lottieUrl2));
                }
            }
            emojiBean = null;
        }
        allOnStagePluginViewPad.showEmoji(access$getMUserId$p, emojiBean);
        AllOnStageViewModel mViewModel = this.this$0.getMViewModel();
        if (mViewModel != null) {
            mViewModel.sendPadEmojiMsg(emojiAssembleBean2);
        }
        HWEventTracking hWEventTracking = HWEventTracking.Companion.get();
        String emojiName4 = emojiAssembleBean.getEmojiName();
        if (emojiName4 != null) {
            str2 = emojiName4;
        }
        hWEventTracking.ostaCbSendMsg("group", "emoji", str2);
        DriverTrack driverTrack = DriverTrack.INSTANCE;
        DataStorage dataStorage = this.this$0.getLiveRoomProvider().getDataStorage();
        String num = (dataStorage == null || (courseInfo2 = dataStorage.getCourseInfo()) == null) ? null : Integer.valueOf(courseInfo2.getPlanId()).toString();
        DataStorage dataStorage2 = this.this$0.getLiveRoomProvider().getDataStorage();
        String num2 = (dataStorage2 == null || (courseInfo = dataStorage2.getCourseInfo()) == null) ? null : Integer.valueOf(courseInfo.getClassId()).toString();
        String classType = this.this$0.getLiveRoomProvider().getClassType();
        if (Intrinsics.areEqual(classType, EnterRoomMuteData.STATUS_UN_MUTE)) {
            str = "大班";
        } else {
            str = Intrinsics.areEqual(classType, "1") ? "伪小班" : "小班";
        }
        String str4 = str;
        String emojiPackageId = emojiAssembleBean.getEmojiPackageId();
        String emojiPackageName = emojiAssembleBean.getEmojiPackageName();
        Integer type5 = emojiAssembleBean.getType();
        if (type5 == null || type5.intValue() != 1) {
            z = false;
        }
        String emojiId = emojiAssembleBean.getEmojiId();
        String emojiName5 = emojiAssembleBean.getEmojiName();
        DataStorage dataStorage3 = this.this$0.getLiveRoomProvider().getDataStorage();
        if (!(dataStorage3 == null || (planInfo = dataStorage3.getPlanInfo()) == null)) {
            str3 = Long.valueOf(planInfo.getPackageId()).toString();
        }
        DriverTrack.emojiRelated$default(driverTrack, "hw_classroom_emoji_send", num, num2, str4, (Boolean) null, "全员上台", emojiPackageId, emojiPackageName, Boolean.valueOf(z), emojiId, emojiName5, str3, 16, (Object) null);
    }
}
