package com.tal.app.thinkacademy.business.shop.viewmodel;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.shop.bean.TeacherDetailsHeader;
import com.tal.app.thinkacademy.business.shop.bean.request.TeacherDetailsList;
import com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/viewmodel/TeacherDetailsVm;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "mRepository", "Lcom/tal/app/thinkacademy/business/shop/repository/ShopClassListRepository;", "mTeacherDetailsHeader", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/business/shop/bean/TeacherDetailsHeader;", "getMTeacherDetailsHeader", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "mTeacherDetailsList", "Lcom/tal/app/thinkacademy/business/shop/bean/request/TeacherDetailsList;", "getMTeacherDetailsList", "getTeacherDetailsHeader", "", "teacherId", "", "getTeacherDetailsList", "context", "Landroid/content/Context;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherDetailsVm.kt */
public final class TeacherDetailsVm extends BaseViewModel {
    /* access modifiers changed from: private */
    public final ShopClassListRepository mRepository = new ShopClassListRepository();
    private final StateLiveData<TeacherDetailsHeader> mTeacherDetailsHeader = new StateLiveData<>();
    private final StateLiveData<TeacherDetailsList> mTeacherDetailsList = new StateLiveData<>();

    public final StateLiveData<TeacherDetailsHeader> getMTeacherDetailsHeader() {
        return this.mTeacherDetailsHeader;
    }

    public final void getTeacherDetailsHeader(int i) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new TeacherDetailsVm$getTeacherDetailsHeader$1(this)), (CoroutineStart) null, new TeacherDetailsVm$getTeacherDetailsHeader$2(this, i, (Continuation<? super TeacherDetailsVm$getTeacherDetailsHeader$2>) null), 2, (Object) null);
    }

    public final StateLiveData<TeacherDetailsList> getMTeacherDetailsList() {
        return this.mTeacherDetailsList;
    }

    public final void getTeacherDetailsList(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new TeacherDetailsVm$getTeacherDetailsList$1(this)), (CoroutineStart) null, new TeacherDetailsVm$getTeacherDetailsList$2(this, i, context, (Continuation<? super TeacherDetailsVm$getTeacherDetailsList$2>) null), 2, (Object) null);
    }
}
