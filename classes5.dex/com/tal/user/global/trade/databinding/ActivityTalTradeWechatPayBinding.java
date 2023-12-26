package com.tal.user.global.trade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.user.global.trade.R;
import java.util.Objects;

public final class ActivityTalTradeWechatPayBinding implements ViewBinding {
    private final LinearLayout rootView;

    private ActivityTalTradeWechatPayBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTalTradeWechatPayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTalTradeWechatPayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_tal_trade_wechat_pay;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityTalTradeWechatPayBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new ActivityTalTradeWechatPayBinding((LinearLayout) view);
    }
}
