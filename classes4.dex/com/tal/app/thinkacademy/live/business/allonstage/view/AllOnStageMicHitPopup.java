package com.tal.app.thinkacademy.live.business.allonstage.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.commui.baseview.popupwindow.EasyPopup;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.business.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/allonstage/view/AllOnStageMicHitPopup;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/popupwindow/EasyPopup;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStageMicHitPopup.kt */
public final class AllOnStageMicHitPopup extends EasyPopup {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "AllOnStageMicHitPopup";
    private Context mContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AllOnStageMicHitPopup(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
        setContentView(PadUtils.isPad(Utils.getApp()) ? R.layout.layout_mic_not_allow_open : R.layout.layout_mic_not_allow_phone).setFocusAndOutsideEnable(false).setKeyCodeBack(false).setBackgroundDimEnable(false).setWidth(this.mContext.getResources().getDimensionPixelOffset(PadUtils.isPad(Utils.getApp()) ? R.dimen.size_450dp : R.dimen.size_253dp)).setHeight(this.mContext.getResources().getDimensionPixelOffset(PadUtils.isPad(Utils.getApp()) ? R.dimen.size_114dp : R.dimen.size_94dp)).createPopup();
        View contentView = getContentView();
        if (contentView != null) {
            ((TextView) contentView.findViewById(R.id.tv_got_it)).setOnClickListener(new AllOnStageMicHitPopup$$ExternalSyntheticLambda0(this));
        }
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public final void setMContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mContext = context;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/allonstage/view/AllOnStageMicHitPopup$Companion;", "", "()V", "TAG", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AllOnStageMicHitPopup.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-1$lambda-0  reason: not valid java name */
    public static final void m183lambda1$lambda0(AllOnStageMicHitPopup allOnStageMicHitPopup, View view) {
        Intrinsics.checkNotNullParameter(allOnStageMicHitPopup, "this$0");
        allOnStageMicHitPopup.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
