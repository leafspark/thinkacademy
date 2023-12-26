package com.tal.app.thinkacademy.live.business.keyboardfill.keyboard;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.NumAndMarkKeyboard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "text", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NumAndMarkKeyboard.kt */
final class NumAndMarkKeyboard$initListener$15 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ NumAndMarkKeyboard this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NumAndMarkKeyboard$initListener$15(NumAndMarkKeyboard numAndMarkKeyboard) {
        super(1);
        this.this$0 = numAndMarkKeyboard;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        NumAndMarkKeyboard.OnKeyboardListener access$getMKeyboardListener$p = this.this$0.mKeyboardListener;
        if (access$getMKeyboardListener$p != null) {
            NumAndMarkKeyboard numAndMarkKeyboard = this.this$0;
            int hashCode = str.hashCode();
            if (hashCode != 47) {
                if (hashCode != 3106) {
                    if (hashCode == 99339 && str.equals("del")) {
                        Function0<Unit> delClickBlock$bus_livebusiness_release = access$getMKeyboardListener$p.getDelClickBlock$bus_livebusiness_release();
                        if (delClickBlock$bus_livebusiness_release != null) {
                            delClickBlock$bus_livebusiness_release.invoke();
                        }
                        numAndMarkKeyboard.processDelEditText();
                        return;
                    }
                } else if (str.equals("ac")) {
                    Function0<Unit> clearClickBlock$bus_livebusiness_release = access$getMKeyboardListener$p.getClearClickBlock$bus_livebusiness_release();
                    if (clearClickBlock$bus_livebusiness_release != null) {
                        clearClickBlock$bus_livebusiness_release.invoke();
                    }
                    numAndMarkKeyboard.processCleEditText();
                    return;
                }
            } else if (str.equals("/")) {
                if (!numAndMarkKeyboard.isFractionShown() && !numAndMarkKeyboard.isMaxCharacterNumber()) {
                    numAndMarkKeyboard.showFraction(true);
                    numAndMarkKeyboard.inputTextChanged();
                    numAndMarkKeyboard.autoAdaptInputContent();
                    FillInEditText access$getMEtInputText$p = numAndMarkKeyboard.mEtInputText;
                    FillInEditText fillInEditText = null;
                    if (access$getMEtInputText$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                        access$getMEtInputText$p = null;
                    }
                    if (access$getMEtInputText$p.hasFocus()) {
                        FillInEditText access$getMEtInputText$p2 = numAndMarkKeyboard.mEtInputText;
                        if (access$getMEtInputText$p2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                            access$getMEtInputText$p2 = null;
                        }
                        access$getMEtInputText$p2.clearFocus();
                    }
                    FillInEditText access$getMEtInputDenominator$p = numAndMarkKeyboard.mEtInputDenominator;
                    if (access$getMEtInputDenominator$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
                    } else {
                        fillInEditText = access$getMEtInputDenominator$p;
                    }
                    fillInEditText.requestFocus();
                    XesLog.i(NumAndMarkKeyboard.TAG, Intrinsics.stringPlus("分子符号被点击 focusFlag ", Integer.valueOf(numAndMarkKeyboard.mFocusFlag)));
                    return;
                }
                return;
            }
            if (numAndMarkKeyboard.mFocusFlag == -1) {
                numAndMarkKeyboard.requestFlagFocus(1);
            }
            Function1<String, Unit> numberClickBlock$bus_livebusiness_release = access$getMKeyboardListener$p.getNumberClickBlock$bus_livebusiness_release();
            if (numberClickBlock$bus_livebusiness_release != null) {
                numberClickBlock$bus_livebusiness_release.invoke(str);
            }
            numAndMarkKeyboard.inputKeyboardText(str);
        }
    }
}
