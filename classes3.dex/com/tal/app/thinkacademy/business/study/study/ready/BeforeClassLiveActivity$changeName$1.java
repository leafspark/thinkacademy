package com.tal.app.thinkacademy.business.study.study.ready;

import com.tal.app.thinkacademy.business.studycenter.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "success", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BeforeClassLiveActivity.kt */
final class BeforeClassLiveActivity$changeName$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ EnvTestItemView $itemView;
    final /* synthetic */ String $newName;
    final /* synthetic */ BeforeClassLiveActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BeforeClassLiveActivity$changeName$1(EnvTestItemView envTestItemView, String str, BeforeClassLiveActivity beforeClassLiveActivity) {
        super(1);
        this.$itemView = envTestItemView;
        this.$newName = str;
        this.this$0 = beforeClassLiveActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (z) {
            EnvTestItemView envTestItemView = this.$itemView;
            if (envTestItemView != null) {
                envTestItemView.setStatus(2);
            }
            EnvTestItemView envTestItemView2 = this.$itemView;
            if (envTestItemView2 != null) {
                envTestItemView2.setText(this.$newName);
                return;
            }
            return;
        }
        EnvTestItemView envTestItemView3 = this.$itemView;
        if (envTestItemView3 != null) {
            envTestItemView3.setStatus(3);
        }
        this.this$0.showViewToast(false, R.string.prepare_change_name_failed);
    }
}
