package com.tal.app.thinkacademy.live.business.praiselist;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PraiseListPluginView.kt */
final class PraiseListPluginView$requestSavePermission$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ PraiseListPluginView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PraiseListPluginView$requestSavePermission$1(PraiseListPluginView praiseListPluginView) {
        super(1);
        this.this$0 = praiseListPluginView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (z) {
            XesLog.a(PraiseListPluginView.TAG, "用户授权存储权限，开始截图");
            this.this$0.screenshotToLocal();
            return;
        }
        XesLog.e(PraiseListPluginView.TAG, "用户拒绝授权存储权限，放弃截图");
    }
}
