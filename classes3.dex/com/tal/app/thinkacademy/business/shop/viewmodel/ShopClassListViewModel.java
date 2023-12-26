package com.tal.app.thinkacademy.business.shop.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassData;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassListRequestData;
import com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody;
import com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/viewmodel/ShopClassListViewModel;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "mRepository", "Lcom/tal/app/thinkacademy/business/shop/repository/ShopClassListRepository;", "mShopClassList", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassData;", "getMShopClassList", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "queryClazzByCourseId", "", "body", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopRequestCommonBody;", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassListRequestData;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassListViewModel.kt */
public final class ShopClassListViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final ShopClassListRepository mRepository = new ShopClassListRepository();
    private final StateLiveData<ShopClassData> mShopClassList = new StateLiveData<>();

    public final StateLiveData<ShopClassData> getMShopClassList() {
        return this.mShopClassList;
    }

    public final void queryClazzByCourseId(ShopRequestCommonBody<ShopClassListRequestData> shopRequestCommonBody) {
        Intrinsics.checkNotNullParameter(shopRequestCommonBody, "body");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ShopClassListViewModel$queryClazzByCourseId$1(this)), (CoroutineStart) null, new ShopClassListViewModel$queryClazzByCourseId$2(this, shopRequestCommonBody, (Continuation<? super ShopClassListViewModel$queryClazzByCourseId$2>) null), 2, (Object) null);
    }
}
