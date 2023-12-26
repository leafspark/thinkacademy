package com.tal.app.thinkcademy.lib.commui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.util.ScreenUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0006\u0010\u001f\u001a\u00020\u001dJ\u0010\u0010 \u001a\u00020\u001d2\b\b\u0003\u0010!\u001a\u00020\tJ\u0010\u0010\"\u001a\u00020\u001d2\b\b\u0001\u0010#\u001a\u00020\tJ\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&JB\u0010'\u001a\u00020\u001d2\b\b\u0002\u0010(\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020&2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010-H\u0007J@\u0010.\u001a\u00020\u001d2\b\b\u0002\u0010(\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010+\u001a\u00020&2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010&2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001d0-H\u0007J\u0012\u00100\u001a\u00020\u001d2\b\b\u0003\u0010!\u001a\u00020\tH\u0007JJ\u00101\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\t2\u0006\u0010%\u001a\u00020&2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020&2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010-H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/LoadStatusView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "btnHint", "Landroid/widget/Button;", "clContent", "Landroid/view/ViewGroup;", "ivImage", "Landroid/widget/ImageView;", "loadStatus", "Lcom/tal/app/thinkcademy/lib/commui/widget/LoadStatus;", "mFullLoadingView", "Lcom/tal/app/thinkcademy/lib/commui/widget/FullLoadingView;", "getMFullLoadingView", "()Lcom/tal/app/thinkcademy/lib/commui/widget/FullLoadingView;", "mFullLoadingView$delegate", "Lkotlin/Lazy;", "tvHint", "Landroid/widget/TextView;", "tvHintDesc", "hideFullLoadingView", "", "initView", "restoreView", "setContentBg", "colorId", "setContentBgDrawable", "drawableRes", "setHintText", "hintText", "", "showEmptyView", "hintImage", "visibilityButton", "", "hintBtnText", "click", "Lkotlin/Function0;", "showErrorView", "hintDescText", "showFullLoadingView", "showView", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoadStatusView.kt */
public final class LoadStatusView extends ConstraintLayout {
    private Button btnHint;
    private ViewGroup clContent;
    private ImageView ivImage;
    private LoadStatus loadStatus;
    private final Lazy mFullLoadingView$delegate;
    private TextView tvHint;
    private TextView tvHintDesc;

    public final void showEmptyView() {
        showEmptyView$default(this, 0, (String) null, false, (String) null, (Function0) null, 31, (Object) null);
    }

    public final void showEmptyView(int i) {
        showEmptyView$default(this, i, (String) null, false, (String) null, (Function0) null, 30, (Object) null);
    }

    public final void showEmptyView(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "hintText");
        showEmptyView$default(this, i, str, false, (String) null, (Function0) null, 28, (Object) null);
    }

    public final void showEmptyView(int i, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "hintText");
        showEmptyView$default(this, i, str, z, (String) null, (Function0) null, 24, (Object) null);
    }

    public final void showEmptyView(int i, String str, boolean z, String str2) {
        Intrinsics.checkNotNullParameter(str, "hintText");
        Intrinsics.checkNotNullParameter(str2, "hintBtnText");
        showEmptyView$default(this, i, str, z, str2, (Function0) null, 16, (Object) null);
    }

    public final void showErrorView(int i, String str, String str2, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "hintText");
        Intrinsics.checkNotNullParameter(str2, "hintBtnText");
        Intrinsics.checkNotNullParameter(function0, "click");
        showErrorView$default(this, i, str, str2, (String) null, function0, 8, (Object) null);
    }

    public final void showErrorView(int i, String str, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "hintText");
        Intrinsics.checkNotNullParameter(function0, "click");
        showErrorView$default(this, i, str, (String) null, (String) null, function0, 12, (Object) null);
    }

    public final void showErrorView(int i, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "click");
        showErrorView$default(this, i, (String) null, (String) null, (String) null, function0, 14, (Object) null);
    }

    public final void showErrorView(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "click");
        showErrorView$default(this, 0, (String) null, (String) null, (String) null, function0, 15, (Object) null);
    }

    public final void showFullLoadingView() {
        showFullLoadingView$default(this, 0, 1, (Object) null);
    }

    public LoadStatusView(Context context) {
        this(context, (AttributeSet) null);
    }

    public LoadStatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoadStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNull(context);
        this.loadStatus = LoadStatus.Empty;
        this.mFullLoadingView$delegate = LazyKt.lazy(new LoadStatusView$mFullLoadingView$2(this));
        if (!isInEditMode()) {
            initView();
        }
    }

    private final FullLoadingView getMFullLoadingView() {
        return (FullLoadingView) this.mFullLoadingView$delegate.getValue();
    }

    private final void initView() {
        int i;
        if (ScreenUtils.isLandscape()) {
            i = R.layout.load_landscape_status_view;
        } else {
            i = R.layout.load_status_view;
        }
        View inflate = XMLParseInstrumentation.inflate(getContext(), i, (ViewGroup) this);
        this.clContent = (ViewGroup) inflate.findViewById(R.id.cl_content);
        this.tvHint = (TextView) inflate.findViewById(R.id.tv_hint);
        this.tvHintDesc = (TextView) inflate.findViewById(R.id.tv_hint_desc);
        this.btnHint = (Button) inflate.findViewById(R.id.btn_hint);
        this.ivImage = (ImageView) inflate.findViewById(R.id.iv_image);
        ViewGroup viewGroup = this.clContent;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public static /* synthetic */ void showErrorView$default(LoadStatusView loadStatusView, int i, String str, String str2, String str3, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = R.drawable.fail_internet_connection;
        }
        int i3 = i;
        if ((i2 & 2) != 0) {
            str = loadStatusView.getContext().getString(R.string.fail_hint);
            Intrinsics.checkNotNullExpressionValue(str, "fun showErrorView(\n     …k = click\n        )\n    }");
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            str2 = loadStatusView.getContext().getString(R.string.fail_btn_hint);
            Intrinsics.checkNotNullExpressionValue(str2, "fun showErrorView(\n     …k = click\n        )\n    }");
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        loadStatusView.showErrorView(i3, str4, str5, str3, function0);
    }

    public final void showErrorView(int i, String str, String str2, String str3, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "hintText");
        Intrinsics.checkNotNullParameter(str2, "hintBtnText");
        Intrinsics.checkNotNullParameter(function0, "click");
        this.loadStatus = LoadStatus.Error;
        hideFullLoadingView();
        showView(i, str, str3, true, str2, function0);
    }

    public static /* synthetic */ void showEmptyView$default(LoadStatusView loadStatusView, int i, String str, boolean z, String str2, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = R.drawable.no_current_courses;
        }
        if ((i2 & 2) != 0) {
            str = loadStatusView.getContext().getString(R.string.no_data_hint);
            Intrinsics.checkNotNullExpressionValue(str, "fun showEmptyView(\n     …k = click\n        )\n    }");
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i2 & 8) != 0) {
            str2 = loadStatusView.getContext().getString(R.string.no_data_btn_hint);
            Intrinsics.checkNotNullExpressionValue(str2, "fun showEmptyView(\n     …k = click\n        )\n    }");
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            function0 = null;
        }
        loadStatusView.showEmptyView(i, str3, z2, str4, function0);
    }

    public final void showEmptyView(int i, String str, boolean z, String str2, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "hintText");
        Intrinsics.checkNotNullParameter(str2, "hintBtnText");
        this.loadStatus = LoadStatus.Empty;
        hideFullLoadingView();
        showView$default(this, i, str, (String) null, z, str2, function0, 4, (Object) null);
    }

    static /* synthetic */ void showView$default(LoadStatusView loadStatusView, int i, String str, String str2, boolean z, String str3, Function0 function0, int i2, Object obj) {
        loadStatusView.showView(i, str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? "" : str3, (i2 & 32) != 0 ? null : function0);
    }

    private final void showView(int i, String str, String str2, boolean z, String str3, Function0<Unit> function0) {
        Button button;
        ViewGroup viewGroup = this.clContent;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        TextView textView = this.tvHint;
        if (textView != null) {
            textView.setText(str);
        }
        CharSequence charSequence = str2;
        if (charSequence == null || charSequence.length() == 0) {
            TextView textView2 = this.tvHintDesc;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else {
            TextView textView3 = this.tvHintDesc;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            TextView textView4 = this.tvHintDesc;
            if (textView4 != null) {
                textView4.setText(charSequence);
            }
        }
        ImageView imageView = this.ivImage;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
        if (z) {
            Button button2 = this.btnHint;
            if (button2 != null) {
                button2.setVisibility(0);
            }
        } else {
            Button button3 = this.btnHint;
            if (button3 != null) {
                button3.setVisibility(8);
            }
        }
        Button button4 = this.btnHint;
        if (button4 != null) {
            button4.setText(str3);
        }
        if (function0 != null && (button = this.btnHint) != null) {
            button.setOnClickListener(new LoadStatusView$$ExternalSyntheticLambda0(function0));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showView$lambda-1$lambda-0  reason: not valid java name */
    public static final void m518showView$lambda1$lambda0(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$it");
        function0.invoke();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void showFullLoadingView$default(LoadStatusView loadStatusView, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = R.color.white;
        }
        loadStatusView.showFullLoadingView(i);
    }

    public final void showFullLoadingView(int i) {
        if (this.loadStatus == LoadStatus.Loaded) {
            ViewGroup viewGroup = this.clContent;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
        } else {
            ViewGroup viewGroup2 = this.clContent;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(0);
            }
        }
        getMFullLoadingView().addView((ViewGroup) this);
        getMFullLoadingView().loadAnimLayout();
        Context context = getContext();
        if (!(context == null || context.getResources() == null)) {
            getMFullLoadingView().setBackgroundColor(ContextCompat.getColor(getContext(), i));
        }
        Button button = this.btnHint;
        if (button != null) {
            button.setVisibility(8);
        }
    }

    public static /* synthetic */ void setContentBg$default(LoadStatusView loadStatusView, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = R.color.white;
        }
        loadStatusView.setContentBg(i);
    }

    public final void setContentBg(int i) {
        ViewGroup viewGroup = this.clContent;
        if (viewGroup != null) {
            viewGroup.setBackgroundResource(i);
        }
    }

    public final void setContentBgDrawable(int i) {
        ViewGroup viewGroup = this.clContent;
        if (viewGroup != null) {
            viewGroup.setBackgroundResource(i);
        }
    }

    public final void restoreView() {
        this.loadStatus = LoadStatus.Loaded;
        hideFullLoadingView();
        ViewGroup viewGroup = this.clContent;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public final void hideFullLoadingView() {
        getMFullLoadingView().dismissView();
    }

    public final void setHintText(String str) {
        Intrinsics.checkNotNullParameter(str, "hintText");
        TextView textView = this.tvHint;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
