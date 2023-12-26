package com.tal.user.global.trade.base;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.user.global.trade.R;

public class TalTradeLoadingDialog extends AlertDialog {
    public TalTradeLoadingDialog(Context context) {
        super(context, R.style.TalTradeChangeIdentityDialogStyle);
        initView();
    }

    protected TalTradeLoadingDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        initView();
    }

    protected TalTradeLoadingDialog(Context context, int i) {
        super(context, i);
        initView();
    }

    private void initView() {
        getWindow().setLayout(600, 400);
        View inflate = XMLParseInstrumentation.inflate(getContext().getApplicationContext(), R.layout.dialog_tal_trade_loading, (ViewGroup) null);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        setView(inflate);
    }
}
