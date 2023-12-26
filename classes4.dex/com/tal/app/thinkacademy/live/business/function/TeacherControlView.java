package com.tal.app.thinkacademy.live.business.function;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LayoutMicContorlOpenBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\b\b\u0001\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/function/TeacherControlView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "content", "", "iconResId", "", "leftTextColor", "rightTextColor", "control", "Lcom/tal/app/thinkacademy/live/business/function/ITeacherControl;", "(Landroid/content/Context;Ljava/lang/String;IIILcom/tal/app/thinkacademy/live/business/function/ITeacherControl;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getControl", "()Lcom/tal/app/thinkacademy/live/business/function/ITeacherControl;", "setControl", "(Lcom/tal/app/thinkacademy/live/business/function/ITeacherControl;)V", "getIconResId", "()I", "setIconResId", "(I)V", "getLeftTextColor", "setLeftTextColor", "getRightTextColor", "setRightTextColor", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherControlView.kt */
public final class TeacherControlView extends FrameLayout {
    private String content;
    private ITeacherControl control;
    private int iconResId;
    private int leftTextColor;
    private int rightTextColor;

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    public final void setIconResId(int i) {
        this.iconResId = i;
    }

    public final int getLeftTextColor() {
        return this.leftTextColor;
    }

    public final void setLeftTextColor(int i) {
        this.leftTextColor = i;
    }

    public final int getRightTextColor() {
        return this.rightTextColor;
    }

    public final void setRightTextColor(int i) {
        this.rightTextColor = i;
    }

    public final ITeacherControl getControl() {
        return this.control;
    }

    public final void setControl(ITeacherControl iTeacherControl) {
        Intrinsics.checkNotNullParameter(iTeacherControl, "<set-?>");
        this.control = iTeacherControl;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TeacherControlView(Context context, String str, int i, int i2, int i3, ITeacherControl iTeacherControl) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(iTeacherControl, "control");
        this.content = str;
        this.iconResId = i;
        this.leftTextColor = i2;
        this.rightTextColor = i3;
        this.control = iTeacherControl;
        LayoutInflater from = LayoutInflater.from(context);
        int i4 = PadUtils.isPad(Utils.getApp()) ? R.layout.layout_mic_contorl_open : R.layout.layout_mic_contorl_open_phone;
        ViewGroup viewGroup = this;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i4, viewGroup, false) : XMLParseInstrumentation.inflate(from, i4, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(\n …\n            this, false)");
        addView(inflate);
        LayoutMicContorlOpenBinding bind = LayoutMicContorlOpenBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(contentView)");
        if (!TextUtils.isEmpty(this.content)) {
            bind.tvTitle.setText(this.content);
        }
        bind.ivIcon.setImageResource(this.iconResId);
        bind.tvDeny.setTextColor(context.getColor(this.leftTextColor));
        bind.tvAgree.setTextColor(context.getColor(this.rightTextColor));
        bind.tvDeny.setOnClickListener(new TeacherControlView$$ExternalSyntheticLambda0(this));
        bind.tvAgree.setOnClickListener(new TeacherControlView$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m251_init_$lambda0(TeacherControlView teacherControlView, View view) {
        Intrinsics.checkNotNullParameter(teacherControlView, "this$0");
        teacherControlView.control.deny();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m252_init_$lambda1(TeacherControlView teacherControlView, View view) {
        Intrinsics.checkNotNullParameter(teacherControlView, "this$0");
        teacherControlView.control.agree();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
