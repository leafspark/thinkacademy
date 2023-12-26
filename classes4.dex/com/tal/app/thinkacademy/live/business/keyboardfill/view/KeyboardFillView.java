package com.tal.app.thinkacademy.live.business.keyboardfill.view;

import android.content.Context;
import android.view.View;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.continuous.window.AwardType;
import com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultParams;
import com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultView;
import com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.NumAndMarkKeyboard;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import com.tal.app.thinkacademy.live.util.ViewScaleUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0006\u0010\u000f\u001a\u00020\nJ\b\u0010\u0010\u001a\u00020\nH\u0016J)\u0010\u0011\u001a\u00020\n2!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\n0\u0013J\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u000eJ\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\fJ\u0006\u0010\u001b\u001a\u00020\nJ\u001a\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000eJ\u0006\u0010\u001f\u001a\u00020\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/tal/app/thinkacademy/live/business/keyboardfill/view/KeyboardFillView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseLivePluginView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mKeyboardView", "Lcom/tal/app/thinkacademy/live/business/keyboardfill/keyboard/NumAndMarkKeyboard;", "mSubmitResultView", "Lcom/tal/app/thinkacademy/live/business/continuous/window/SubmitResultView;", "destroy", "", "getContent", "", "getLayoutId", "", "hide", "initViews", "onSubmitCallback", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "content", "refreshLayout", "height", "setResult", "result", "show", "showSubmitResultView", "addCoins", "totalCoin", "showSuccess", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: KeyboardFillView.kt */
public final class KeyboardFillView extends BaseLivePluginView {
    private NumAndMarkKeyboard mKeyboardView;
    private SubmitResultView mSubmitResultView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KeyboardFillView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public int getLayoutId() {
        return R.layout.layout_keyboard_fill;
    }

    public void initViews() {
        KeyboardFillView.super.initViews();
        this.mKeyboardView = (NumAndMarkKeyboard) findViewById(R.id.keyboard);
        this.mSubmitResultView = (SubmitResultView) findViewById(R.id.submit_result_view);
    }

    public final void show() {
        NumAndMarkKeyboard numAndMarkKeyboard = this.mKeyboardView;
        if (numAndMarkKeyboard != null) {
            numAndMarkKeyboard.show();
        }
    }

    public final void hide() {
        NumAndMarkKeyboard numAndMarkKeyboard = this.mKeyboardView;
        if (numAndMarkKeyboard != null) {
            numAndMarkKeyboard.hide();
        }
    }

    public final String getContent() {
        NumAndMarkKeyboard numAndMarkKeyboard = this.mKeyboardView;
        if (numAndMarkKeyboard == null) {
            return null;
        }
        return numAndMarkKeyboard.getAllEditTextContent();
    }

    public final void setResult(String str) {
        Intrinsics.checkNotNullParameter(str, "result");
        NumAndMarkKeyboard numAndMarkKeyboard = this.mKeyboardView;
        if (numAndMarkKeyboard != null) {
            numAndMarkKeyboard.recoveryData(str);
        }
    }

    public final void showSuccess() {
        NumAndMarkKeyboard numAndMarkKeyboard = this.mKeyboardView;
        if (numAndMarkKeyboard != null) {
            numAndMarkKeyboard.showModel(true);
        }
        show();
    }

    public final void onSubmitCallback(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        NumAndMarkKeyboard numAndMarkKeyboard = this.mKeyboardView;
        if (numAndMarkKeyboard != null) {
            numAndMarkKeyboard.setOnKeyboardListener(new KeyboardFillView$onSubmitCallback$1(function1));
        }
    }

    public final void refreshLayout(int i) {
        NumAndMarkKeyboard numAndMarkKeyboard = this.mKeyboardView;
        if (numAndMarkKeyboard != null) {
            View view = (View) numAndMarkKeyboard;
            ViewScaleUtil.scale(view, (((float) i) * 1.0f) / ((float) SizeUtils.dp2px(618.0f)), SizeUtils.dp2px(790.0f) / 2, SizeUtils.dp2px(283.0f));
        }
    }

    public final void destroy() {
        NumAndMarkKeyboard numAndMarkKeyboard = this.mKeyboardView;
        if (numAndMarkKeyboard != null) {
            numAndMarkKeyboard.destroy();
        }
        this.mKeyboardView = null;
    }

    public static /* synthetic */ void showSubmitResultView$default(KeyboardFillView keyboardFillView, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        keyboardFillView.showSubmitResultView(i, i2);
    }

    public final void showSubmitResultView(int i, int i2) {
        SubmitResultView submitResultView = this.mSubmitResultView;
        if (submitResultView != null) {
            submitResultView.setLogTag(Tag.KEYBOARD_FILL);
        }
        SubmitResultView submitResultView2 = this.mSubmitResultView;
        if (submitResultView2 != null) {
            submitResultView2.setParams(new SubmitResultParams(AwardType.RIGHT, i2, i, 0, false, 24, (DefaultConstructorMarker) null));
        }
        SubmitResultView submitResultView3 = this.mSubmitResultView;
        if (submitResultView3 != null) {
            SubmitResultView.show$default(submitResultView3, (Function0) null, 1, (Object) null);
        }
    }
}
