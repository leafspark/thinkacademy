package com.tal.app.thinkacademy.business.shop.classdetail;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailViewModel$requestShopCouponRecommend$1$3", "Lcom/tal/app/thinkacademy/lib/network/exception/IError;", "onError", "", "code", "", "msg", "", "onFail", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailViewModel.kt */
public final class ShopClassDetailViewModel$requestShopCouponRecommend$1$3 implements IError {
    final /* synthetic */ ShopClassDetailViewModel this$0;

    ShopClassDetailViewModel$requestShopCouponRecommend$1$3(ShopClassDetailViewModel shopClassDetailViewModel) {
        this.this$0 = shopClassDetailViewModel;
    }

    public void onFail(int i, String str) {
        this.this$0.getMShopCouponRecommendInfoBean().postFailure(i, str);
        XesLog.dt("ShopClassDetailViewModel", new Object[]{"requestShopCouponRecommend onFail code=" + i + ",msg=" + str});
    }

    public void onError(int i, String str) {
        this.this$0.getMShopCouponRecommendInfoBean().postError(i, str);
        XesLog.dt("ShopClassDetailViewModel", new Object[]{"requestShopCouponRecommend onError code=" + i + ",msg=" + str});
    }
}
