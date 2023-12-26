package com.tal.app.thinkacademy.business.home.main.vm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.business.home.main.api.HomeRepository;
import com.tal.app.thinkacademy.business.home.main.bean.SchoolCode;
import com.tal.app.thinkacademy.common.ApiUrl;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.entity.GetSchoolListRequest;
import com.tal.app.thinkacademy.common.imconfig.ImConfigApi;
import com.tal.app.thinkacademy.common.imconfig.SchoolListInfo;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0013\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/vm/LaunchViewModel;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "repository", "Lcom/tal/app/thinkacademy/business/home/main/api/HomeRepository;", "schoolCode", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/business/home/main/bean/SchoolCode;", "getSchoolCode", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setSchoolCode", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "schoolListInfo", "Lcom/tal/app/thinkacademy/common/imconfig/SchoolListInfo;", "getSchoolListInfo", "setSchoolListInfo", "", "countryCode", "", "getSchoolList", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LaunchViewModel.kt */
public final class LaunchViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final HomeRepository repository = new HomeRepository();
    private StateLiveData<SchoolCode> schoolCode = new StateLiveData<>();
    private StateLiveData<SchoolListInfo> schoolListInfo = new StateLiveData<>();

    public final StateLiveData<SchoolCode> getSchoolCode() {
        return this.schoolCode;
    }

    public final void setSchoolCode(StateLiveData<SchoolCode> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.schoolCode = stateLiveData;
    }

    public final void getSchoolCode(String str) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new LaunchViewModel$getSchoolCode$1(this)), (CoroutineStart) null, new LaunchViewModel$getSchoolCode$2(this, str, (Continuation<? super LaunchViewModel$getSchoolCode$2>) null), 2, (Object) null);
    }

    public final StateLiveData<SchoolListInfo> getSchoolListInfo() {
        return this.schoolListInfo;
    }

    public final void setSchoolListInfo(StateLiveData<SchoolListInfo> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.schoolListInfo = stateLiveData;
    }

    public final void getSchoolList() {
        Call schoolList = ((ImConfigApi) Api.create(ImConfigApi.class)).getSchoolList(Intrinsics.stringPlus(ApiUrl.INSTANCE.getBASE_URL(), "v1/config/allCampusWithConfigs"), new GetSchoolListRequest((String) null, 1, (DefaultConstructorMarker) null));
        Callback launchViewModel$getSchoolList$1 = new LaunchViewModel$getSchoolList$1(this, new LaunchViewModel$getSchoolList$2(this));
        if (!(schoolList instanceof Call)) {
            schoolList.enqueue(launchViewModel$getSchoolList$1);
        } else {
            Retrofit2Instrumentation.enqueue(schoolList, launchViewModel$getSchoolList$1);
        }
    }
}
