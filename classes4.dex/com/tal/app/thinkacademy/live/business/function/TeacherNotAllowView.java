package com.tal.app.thinkacademy.live.business.function;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LayoutMicNotAllowBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/function/TeacherNotAllowView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "allow", "Lcom/tal/app/thinkacademy/live/business/function/ITeacherNotAllow;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/business/function/ITeacherNotAllow;)V", "getAllow", "()Lcom/tal/app/thinkacademy/live/business/function/ITeacherNotAllow;", "setAllow", "(Lcom/tal/app/thinkacademy/live/business/function/ITeacherNotAllow;)V", "mViewBinding", "Lcom/tal/app/thinkacademy/live/business/databinding/LayoutMicNotAllowBinding;", "setIconRes", "", "resId", "", "setMsg", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherNotAllowView.kt */
public final class TeacherNotAllowView extends FrameLayout {
    private ITeacherNotAllow allow;
    private final LayoutMicNotAllowBinding mViewBinding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TeacherNotAllowView(Context context, ITeacherNotAllow iTeacherNotAllow) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iTeacherNotAllow, "allow");
        this.allow = iTeacherNotAllow;
        LayoutInflater from = LayoutInflater.from(context);
        int i = PadUtils.isPad(Utils.getApp()) ? R.layout.layout_mic_not_allow : R.layout.layout_mic_not_allow_phone;
        ViewGroup viewGroup = this;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(from, i, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(\n …          false\n        )");
        addView(inflate);
        LayoutMicNotAllowBinding bind = LayoutMicNotAllowBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(contentView)");
        this.mViewBinding = bind;
        bind.tvGotIt.setOnClickListener(new TeacherNotAllowView$$ExternalSyntheticLambda0(this));
    }

    public final ITeacherNotAllow getAllow() {
        return this.allow;
    }

    public final void setAllow(ITeacherNotAllow iTeacherNotAllow) {
        Intrinsics.checkNotNullParameter(iTeacherNotAllow, "<set-?>");
        this.allow = iTeacherNotAllow;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m253_init_$lambda0(TeacherNotAllowView teacherNotAllowView, View view) {
        Intrinsics.checkNotNullParameter(teacherNotAllowView, "this$0");
        teacherNotAllowView.allow.gotIt();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void setIconRes(int i) {
        this.mViewBinding.ivMicMute.setImageResource(i);
    }

    public final void setMsg(int i) {
        this.mViewBinding.tvMicTitle.setText(i);
    }
}
