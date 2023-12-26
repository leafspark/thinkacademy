package com.tal.app.thinkacademy.live.core.plugin.pluginview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.core.R;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseInteractBoxPluginView;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseVBLivePluginView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getBoxBg", "getBoxRatio", "", "inflate", "Landroid/view/View;", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseInteractBoxPluginView.kt */
public abstract class BaseInteractBoxPluginView<VB extends ViewBinding> extends BaseVBLivePluginView<VB> {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseInteractBoxPluginView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseInteractBoxPluginView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public float getBoxRatio() {
        return 1.3333334f;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseInteractBoxPluginView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseInteractBoxPluginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: protected */
    public View inflate() {
        if (!LiveAreaCompat.isSmallPad()) {
            return super.inflate();
        }
        LayoutInflater from = LayoutInflater.from(getContext());
        int i = R.layout.view_interact_box;
        ViewGroup viewGroup = this;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i, viewGroup, true) : XMLParseInstrumentation.inflate(from, i, viewGroup, true);
        inflate.setBackgroundResource(getBoxBg());
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.interact_box);
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        LiveAreaLayoutParams pptLp = LiveAreaContext.get().getPptLp();
        layoutParams.width = (int) (((float) pptLp.height) * getBoxRatio());
        layoutParams.height = pptLp.height;
        this.mBinding = createViewBinding(LayoutInflater.from(getContext()), frameLayout, true);
        return this;
    }

    public int getBoxBg() {
        return R.drawable.live_business_student_bg;
    }
}
