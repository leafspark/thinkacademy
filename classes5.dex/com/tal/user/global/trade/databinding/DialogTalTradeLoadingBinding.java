package com.tal.user.global.trade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.user.global.trade.R;
import com.tal.user.global.trade.widget.TalTradeLoadingView;

public final class DialogTalTradeLoadingBinding implements ViewBinding {
    public final TalTradeLoadingView loadingDialogTrade;
    private final ConstraintLayout rootView;
    public final TextView tvDialogTradeLoading;

    private DialogTalTradeLoadingBinding(ConstraintLayout constraintLayout, TalTradeLoadingView talTradeLoadingView, TextView textView) {
        this.rootView = constraintLayout;
        this.loadingDialogTrade = talTradeLoadingView;
        this.tvDialogTradeLoading = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogTalTradeLoadingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogTalTradeLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.dialog_tal_trade_loading;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogTalTradeLoadingBinding bind(View view) {
        int i = R.id.loading_dialog_trade;
        TalTradeLoadingView talTradeLoadingView = (TalTradeLoadingView) view.findViewById(i);
        if (talTradeLoadingView != null) {
            i = R.id.tv_dialog_trade_loading;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                return new DialogTalTradeLoadingBinding((ConstraintLayout) view, talTradeLoadingView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
