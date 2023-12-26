package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessLiveBarrageViewBinding implements ViewBinding {
    public final RelativeLayout rlLiveBusinessBarrageBottom;
    public final RelativeLayout rlLiveBusinessBarrageMiddle;
    public final RelativeLayout rlLiveBusinessBarrageParent;
    public final RelativeLayout rlLiveBusinessBarrageTop;
    private final RelativeLayout rootView;

    private LiveBusinessLiveBarrageViewBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5) {
        this.rootView = relativeLayout;
        this.rlLiveBusinessBarrageBottom = relativeLayout2;
        this.rlLiveBusinessBarrageMiddle = relativeLayout3;
        this.rlLiveBusinessBarrageParent = relativeLayout4;
        this.rlLiveBusinessBarrageTop = relativeLayout5;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessLiveBarrageViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessLiveBarrageViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_live_barrage_view;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessLiveBarrageViewBinding bind(View view) {
        int i = R.id.rl_live_business_barrage_bottom;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = R.id.rl_live_business_barrage_middle;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout2 != null) {
                RelativeLayout relativeLayout3 = (RelativeLayout) view;
                i = R.id.rl_live_business_barrage_top;
                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout4 != null) {
                    return new LiveBusinessLiveBarrageViewBinding(relativeLayout3, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
