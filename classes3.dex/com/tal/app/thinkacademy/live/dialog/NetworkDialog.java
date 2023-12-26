package com.tal.app.thinkacademy.live.dialog;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/live/dialog/NetworkDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "exitState", "Lcom/tal/app/thinkacademy/live/dialog/NetworkState;", "mClickListener", "Landroid/view/View$OnClickListener;", "setGotItClickCall", "", "listener", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetworkDialog.kt */
public final class NetworkDialog extends BaseDialog {
    private NetworkState exitState = NetworkState.GOOD;
    private View.OnClickListener mClickListener;

    public NetworkDialog(Context context) {
        super(context);
        contentView(R.layout.live_business_dialog_network);
        dimAmount(0.0f);
        canceledOnTouchOutside(false);
        LiveAreaLayoutParams pptLp = LiveAreaContext.get().getPptLp();
        layoutParams(new FrameLayout.LayoutParams(pptLp.width, -2));
        gravity(8388691);
        offset(pptLp.left, 0);
        TextView textView = (TextView) findViewById(R.id.tvExit);
        if (textView != null) {
            textView.setOnClickListener(new NetworkDialog$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m513_init_$lambda0(NetworkDialog networkDialog, View view) {
        Intrinsics.checkNotNullParameter(networkDialog, "this$0");
        networkDialog.dismiss();
        View.OnClickListener onClickListener = networkDialog.mClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void setGotItClickCall(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "listener");
        this.mClickListener = onClickListener;
    }
}
