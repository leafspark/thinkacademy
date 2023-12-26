package com.tal.app.thinkacademy.business.login.presenter;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.login.config.TempClassRepository;
import com.tal.app.thinkacademy.business.login.entity.ClassListEntity;
import com.tal.app.thinkacademy.business.login.entity.CurriculumListData;
import com.tal.app.thinkacademy.business.login.entity.NicknameBean;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/presenter/TempClassViewModel;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "_nickNameLiveData", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/business/login/entity/NicknameBean;", "_tempClassLiveData", "Lcom/tal/app/thinkacademy/business/login/entity/ClassListEntity;", "nickNameLiveData", "getNickNameLiveData", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "repository", "Lcom/tal/app/thinkacademy/business/login/config/TempClassRepository;", "tempClassLiveData", "getTempClassLiveData", "getNicknameInfo", "", "getStudentCurriculumList", "data", "Lcom/tal/app/thinkacademy/business/login/entity/CurriculumListData;", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TempClassViewModel.kt */
public final class TempClassViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public StateLiveData<NicknameBean> _nickNameLiveData = new StateLiveData<>();
    /* access modifiers changed from: private */
    public StateLiveData<ClassListEntity> _tempClassLiveData = new StateLiveData<>();
    /* access modifiers changed from: private */
    public final TempClassRepository repository = new TempClassRepository();

    public final StateLiveData<ClassListEntity> getTempClassLiveData() {
        return this._tempClassLiveData;
    }

    public final void getStudentCurriculumList(CurriculumListData curriculumListData) {
        Intrinsics.checkNotNullParameter(curriculumListData, DbParams.KEY_DATA);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new TempClassViewModel$getStudentCurriculumList$1(this)), (CoroutineStart) null, new TempClassViewModel$getStudentCurriculumList$2(this, curriculumListData, (Continuation<? super TempClassViewModel$getStudentCurriculumList$2>) null), 2, (Object) null);
    }

    public final StateLiveData<NicknameBean> getNickNameLiveData() {
        return this._nickNameLiveData;
    }

    public final void getNicknameInfo() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new TempClassViewModel$getNicknameInfo$1(this)), (CoroutineStart) null, new TempClassViewModel$getNicknameInfo$2(this, (Continuation<? super TempClassViewModel$getNicknameInfo$2>) null), 2, (Object) null);
    }
}
