package com.tal.app.thinkacademy.common.widget;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.lib.util.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bB\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/common/widget/TextClickSpan;", "Landroid/text/style/ClickableSpan;", "color", "", "underline", "", "listener", "Landroid/view/View$OnClickListener;", "(IZLandroid/view/View$OnClickListener;)V", "mHighLightColor", "mClickListener", "(ILandroid/view/View$OnClickListener;)V", "(Landroid/view/View$OnClickListener;)V", "getListener", "()Landroid/view/View$OnClickListener;", "mUnderLine", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextClickSpan.kt */
public final class TextClickSpan extends ClickableSpan {
    private final View.OnClickListener listener;
    private View.OnClickListener mClickListener;
    private int mHighLightColor;
    private boolean mUnderLine;

    public TextClickSpan(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "listener");
        this.listener = onClickListener;
        this.mHighLightColor = R.color.color_3bafd9;
    }

    public final View.OnClickListener getListener() {
        return this.listener;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TextClickSpan(int i, boolean z, View.OnClickListener onClickListener) {
        this(onClickListener);
        Intrinsics.checkNotNullParameter(onClickListener, "listener");
        this.mHighLightColor = i;
        this.mUnderLine = z;
        this.mClickListener = onClickListener;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TextClickSpan(int i, View.OnClickListener onClickListener) {
        this(onClickListener);
        Intrinsics.checkNotNullParameter(onClickListener, "mClickListener");
        this.mHighLightColor = i;
        this.mClickListener = onClickListener;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        View.OnClickListener onClickListener = this.mClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        super.updateDrawState(textPaint);
        textPaint.setColor(ColorUtils.getColor(this.mHighLightColor));
        textPaint.setUnderlineText(this.mUnderLine);
    }
}
