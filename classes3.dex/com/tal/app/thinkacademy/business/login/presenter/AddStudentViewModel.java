package com.tal.app.thinkacademy.business.login.presenter;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.login.config.LoginRepository;
import com.tal.app.thinkacademy.business.login.entity.AddNewStudent;
import com.tal.app.thinkacademy.business.login.entity.MasterUserBean;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.user.GradeStageList;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J=\u0010\u0003\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u001cJ\u0006\u0010\f\u001a\u00020\u0014J\u0006\u0010\u0010\u001a\u00020\u0014R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/presenter/AddStudentViewModel;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "addNewStudent", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/business/login/entity/AddNewStudent;", "getAddNewStudent", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setAddNewStudent", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "gradeStageList", "Lcom/tal/app/thinkacademy/common/user/GradeStageList;", "getGradeStageList", "setGradeStageList", "masterUserInfo", "Lcom/tal/app/thinkacademy/business/login/entity/MasterUserBean;", "getMasterUserInfo", "setMasterUserInfo", "repository", "Lcom/tal/app/thinkacademy/business/login/config/LoginRepository;", "", "nickName", "", "firstName", "lastName", "gradeId", "", "email", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddStudentViewModel.kt */
public final class AddStudentViewModel extends BaseViewModel {
    private StateLiveData<AddNewStudent> addNewStudent = new StateLiveData<>();
    private StateLiveData<GradeStageList> gradeStageList = new StateLiveData<>();
    private StateLiveData<MasterUserBean> masterUserInfo = new StateLiveData<>();
    /* access modifiers changed from: private */
    public final LoginRepository repository = new LoginRepository();

    public final StateLiveData<MasterUserBean> getMasterUserInfo() {
        return this.masterUserInfo;
    }

    public final void setMasterUserInfo(StateLiveData<MasterUserBean> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.masterUserInfo = stateLiveData;
    }

    /* renamed from: getMasterUserInfo  reason: collision with other method in class */
    public final void m45getMasterUserInfo() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new AddStudentViewModel$getMasterUserInfo$1(this)), (CoroutineStart) null, new AddStudentViewModel$getMasterUserInfo$2(this, (Continuation<? super AddStudentViewModel$getMasterUserInfo$2>) null), 2, (Object) null);
    }

    public final StateLiveData<AddNewStudent> getAddNewStudent() {
        return this.addNewStudent;
    }

    public final void setAddNewStudent(StateLiveData<AddNewStudent> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.addNewStudent = stateLiveData;
    }

    public final void addNewStudent(String str, String str2, String str3, Integer num, String str4) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new AddStudentViewModel$addNewStudent$1(this)), (CoroutineStart) null, new AddStudentViewModel$addNewStudent$2(this, str, str2, str3, num, str4, (Continuation<? super AddStudentViewModel$addNewStudent$2>) null), 2, (Object) null);
    }

    public final StateLiveData<GradeStageList> getGradeStageList() {
        return this.gradeStageList;
    }

    public final void setGradeStageList(StateLiveData<GradeStageList> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.gradeStageList = stateLiveData;
    }

    /* renamed from: getGradeStageList  reason: collision with other method in class */
    public final void m44getGradeStageList() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new AddStudentViewModel$getGradeStageList$1(this)), (CoroutineStart) null, new AddStudentViewModel$getGradeStageList$2(this, (Continuation<? super AddStudentViewModel$getGradeStageList$2>) null), 2, (Object) null);
    }
}
