package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.tal.app.thinkacademy.common.utils.PictureSelectorHelper;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.ChoosePicType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/ChoosePicType;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedbackActivity.kt */
final class FeedbackActivity$showChooseDialog$1 extends Lambda implements Function1<ChoosePicType, Unit> {
    final /* synthetic */ FeedbackActivity this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedbackActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ChoosePicType.values().length];
            iArr[ChoosePicType.take.ordinal()] = 1;
            iArr[ChoosePicType.choose.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedbackActivity$showChooseDialog$1(FeedbackActivity feedbackActivity) {
        super(1);
        this.this$0 = feedbackActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ChoosePicType) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ChoosePicType choosePicType) {
        Intrinsics.checkNotNullParameter(choosePicType, "it");
        int i = WhenMappings.$EnumSwitchMapping$0[choosePicType.ordinal()];
        if (i == 1) {
            PictureSelectorHelper instance = PictureSelectorHelper.Companion.getInstance();
            FeedbackActivity feedbackActivity = this.this$0;
            PictureSelectorHelper.takePhoto$default(instance, (Activity) feedbackActivity, feedbackActivity.mMaxPhoto, false, false, 0, (OnResultCallbackListener) null, 52, (Object) null);
        } else if (i == 2) {
            PictureSelectorHelper instance2 = PictureSelectorHelper.Companion.getInstance();
            FeedbackActivity feedbackActivity2 = this.this$0;
            PictureSelectorHelper.choosePhoto$default(instance2, (Activity) feedbackActivity2, feedbackActivity2.mMaxPhoto, false, false, 0, (OnResultCallbackListener) null, 52, (Object) null);
        }
    }
}
