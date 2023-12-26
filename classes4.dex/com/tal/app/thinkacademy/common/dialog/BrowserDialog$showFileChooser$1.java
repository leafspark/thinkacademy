package com.tal.app.thinkacademy.common.dialog;

import com.tal.app.thinkacademy.lib.commui.baseview.dialog.ChoosePicType;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/ChoosePicType;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BrowserDialog.kt */
final class BrowserDialog$showFileChooser$1 extends Lambda implements Function1<ChoosePicType, Unit> {
    final /* synthetic */ BrowserDialog this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BrowserDialog.kt */
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
    BrowserDialog$showFileChooser$1(BrowserDialog browserDialog) {
        super(1);
        this.this$0 = browserDialog;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ChoosePicType) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ChoosePicType choosePicType) {
        Intrinsics.checkNotNullParameter(choosePicType, "it");
        int i = WhenMappings.$EnumSwitchMapping$0[choosePicType.ordinal()];
        if (i == 1) {
            this.this$0.isChoose = true;
            XesLog.it("BrowserDialog", "点击拍照");
            this.this$0.takePhoto();
        } else if (i == 2) {
            this.this$0.isChoose = true;
            XesLog.it("BrowserDialog", "点击相册");
            this.this$0.choosePhoto();
        }
    }
}
