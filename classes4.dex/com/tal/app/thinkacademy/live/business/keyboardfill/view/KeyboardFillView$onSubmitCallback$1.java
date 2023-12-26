package com.tal.app.thinkacademy.live.business.keyboardfill.view;

import com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.NumAndMarkKeyboard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/tal/app/thinkacademy/live/business/keyboardfill/keyboard/NumAndMarkKeyboard$OnKeyboardListener;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: KeyboardFillView.kt */
final class KeyboardFillView$onSubmitCallback$1 extends Lambda implements Function1<NumAndMarkKeyboard.OnKeyboardListener, Unit> {
    final /* synthetic */ Function1<String, Unit> $block;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KeyboardFillView$onSubmitCallback$1(Function1<? super String, Unit> function1) {
        super(1);
        this.$block = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NumAndMarkKeyboard.OnKeyboardListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(NumAndMarkKeyboard.OnKeyboardListener onKeyboardListener) {
        Intrinsics.checkNotNullParameter(onKeyboardListener, "$this$setOnKeyboardListener");
        onKeyboardListener.onSubmitClick(this.$block);
    }
}
