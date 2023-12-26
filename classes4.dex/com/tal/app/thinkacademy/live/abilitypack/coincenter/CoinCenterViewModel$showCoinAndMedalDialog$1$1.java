package com.tal.app.thinkacademy.live.abilitypack.coincenter;

import android.content.Context;
import android.view.LayoutInflater;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/live/abilitypack/coincenter/CoinCenterViewModel$showCoinAndMedalDialog$1$1", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessAllMedalsBinding;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoinCenterViewModel.kt */
public final class CoinCenterViewModel$showCoinAndMedalDialog$1$1 extends BaseBindDialog<LiveBusinessAllMedalsBinding> {
    CoinCenterViewModel$showCoinAndMedalDialog$1$1(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public LiveBusinessAllMedalsBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LiveBusinessAllMedalsBinding inflate = LiveBusinessAllMedalsBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
