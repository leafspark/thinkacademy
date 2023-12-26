package com.tal.app.thinkacademy.business.shop;

import android.widget.LinearLayout;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeNativeFragment.kt */
final class ShopHomeNativeFragment$initTimeZone$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ShopHomeNativeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopHomeNativeFragment$initTimeZone$1(ShopHomeNativeFragment shopHomeNativeFragment) {
        super(0);
        this.this$0 = shopHomeNativeFragment;
    }

    public final void invoke() {
        LinearLayout linearLayout = this.this$0.getBinding().llTimeZoneTip;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        ShopHomeNativeFragment shopHomeNativeFragment = this.this$0;
        String string = ShareDataManager.getInstance().getString("school_code", LiveUrls.SCHOOL_CODE_US, ShareDataManager.SHAREDATA_NOT_CLEAR);
        Intrinsics.checkNotNullExpressionValue(string, "getInstance()\n          …ager.SHAREDATA_NOT_CLEAR)");
        shopHomeNativeFragment.mSchoolCode = string;
    }
}