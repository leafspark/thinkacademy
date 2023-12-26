package com.tal.app.thinkacademy.live.business.keyboardfill.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/keyboardfill/view/KeyboardFillResultToast;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseLivePluginView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mTvText", "Landroid/widget/TextView;", "cancel", "", "getLayoutId", "", "initViews", "setText", "resId", "showToast", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: KeyboardFillResultToast.kt */
public final class KeyboardFillResultToast extends BaseLivePluginView {
    private TextView mTvText;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KeyboardFillResultToast(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public int getLayoutId() {
        return R.layout.layout_keyboard_fill_toast_result;
    }

    public void initViews() {
        KeyboardFillResultToast.super.initViews();
        this.mTvText = (TextView) findViewById(R.id.tv_text);
    }

    public final void setText(int i) {
        TextView textView = this.mTvText;
        if (textView != null) {
            textView.setText(i);
        }
    }

    public final void showToast() {
        LiveAreaLayoutParams pptLp = LiveAreaContext.get().getPptLp();
        ToastUtils.setGravity(17, (-(pptLp.right - pptLp.left)) / 2, (-(pptLp.bottom - pptLp.top)) / 2);
        ToastUtils.showCustomLong((View) this);
    }

    public final void cancel() {
        ToastUtils.cancel();
    }
}
