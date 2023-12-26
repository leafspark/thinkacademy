package com.tal.app.thinkacademy.common.business.browser.view;

import com.tal.app.thinkacademy.lib.commui.baseview.dialog.ChoosePicType;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/ChoosePicType;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebFileSelectModel.kt */
final class WebFileSelectModel$getChooseDialog$1$1 extends Lambda implements Function1<ChoosePicType, Unit> {
    final /* synthetic */ WebFileSelectModel this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebFileSelectModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ChoosePicType.values().length];
            iArr[ChoosePicType.take.ordinal()] = 1;
            iArr[ChoosePicType.choose.ordinal()] = 2;
            iArr[ChoosePicType.TAKE_VIDEO.ordinal()] = 3;
            iArr[ChoosePicType.CHOOSE_VIDEO.ordinal()] = 4;
            iArr[ChoosePicType.cancel.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebFileSelectModel$getChooseDialog$1$1(WebFileSelectModel webFileSelectModel) {
        super(1);
        this.this$0 = webFileSelectModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ChoosePicType) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ChoosePicType choosePicType) {
        Intrinsics.checkNotNullParameter(choosePicType, "it");
        int i = WhenMappings.$EnumSwitchMapping$0[choosePicType.ordinal()];
        if (i == 1) {
            this.this$0.takePhoto();
        } else if (i == 2) {
            this.this$0.choosePhoto();
        } else if (i == 3) {
            this.this$0.takeVideo();
        } else if (i == 4) {
            this.this$0.chooseVideo();
        } else if (i != 5) {
            this.this$0.sendJsCancel();
            XesLog.it("WebFileSelectModel", "getChooseDialog 点击了其他按钮 is null");
        } else {
            XesLog.it("WebFileSelectModel", "getChooseDialog 点击了cancel按钮 is null");
            this.this$0.sendJsCancel();
        }
    }
}
