package com.tal.app.thinkacademy.business.shop.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.login.config.LoginRepository;
import com.tal.app.thinkacademy.business.login.entity.AccountListEntity;
import com.tal.app.thinkacademy.business.login.entity.AddNewStudent;
import com.tal.app.thinkacademy.business.shop.bean.UserInfo;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.user.GradeStageList;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J=\u0010\n\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010(\u001a\u0004\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010&¢\u0006\u0002\u0010,J\u0006\u0010\u000e\u001a\u00020$J\u0006\u0010\u0006\u001a\u00020$J\u0006\u0010\u0014\u001a\u00020$J\u0013\u0010-\u001a\u0004\u0018\u00010\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010.J=\u0010/\u001a\u00020$2\b\u00100\u001a\u0004\u0018\u00010&2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010(\u001a\u0004\u0018\u00010&2\b\u00101\u001a\u0004\u0018\u00010*¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020$2\b\u00104\u001a\u0004\u0018\u00010&R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\"\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\tR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/viewmodel/SeletedStudentViewModel;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "accountList", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/business/login/entity/AccountListEntity;", "getAccountList", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setAccountList", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "addNewStudent", "Lcom/tal/app/thinkacademy/business/login/entity/AddNewStudent;", "getAddNewStudent", "setAddNewStudent", "checkUserInfo", "Lcom/tal/app/thinkacademy/business/shop/bean/UserInfo;", "getCheckUserInfo", "setCheckUserInfo", "gradeStageList", "Lcom/tal/app/thinkacademy/common/user/GradeStageList;", "getGradeStageList", "setGradeStageList", "loginData", "Lcom/tal/app/thinkacademy/common/user/UserBean;", "getLoginData", "setLoginData", "modifyUserInfo", "", "getModifyUserInfo", "setModifyUserInfo", "repository", "Lcom/tal/app/thinkacademy/business/login/config/LoginRepository;", "getRepository", "()Lcom/tal/app/thinkacademy/business/login/config/LoginRepository;", "repository$delegate", "Lkotlin/Lazy;", "", "nickName", "", "firstName", "lastName", "gradeId", "", "email", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getUserInfoApi", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "modifyUserBasicInfo", "avatar", "grade", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "switchLogin", "uid", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SeletedStudentViewModel.kt */
public class SeletedStudentViewModel extends BaseViewModel {
    private StateLiveData<AccountListEntity> accountList = new StateLiveData<>();
    private StateLiveData<AddNewStudent> addNewStudent = new StateLiveData<>();
    private StateLiveData<UserInfo> checkUserInfo = new StateLiveData<>();
    private StateLiveData<GradeStageList> gradeStageList = new StateLiveData<>();
    private StateLiveData<UserBean> loginData = new StateLiveData<>();
    private StateLiveData<Object> modifyUserInfo = new StateLiveData<>();
    private final Lazy repository$delegate = LazyKt.lazy(SeletedStudentViewModel$repository$2.INSTANCE);

    /* access modifiers changed from: private */
    public final LoginRepository getRepository() {
        return (LoginRepository) this.repository$delegate.getValue();
    }

    public final StateLiveData<AccountListEntity> getAccountList() {
        return this.accountList;
    }

    public final void setAccountList(StateLiveData<AccountListEntity> stateLiveData) {
        this.accountList = stateLiveData;
    }

    /* renamed from: getAccountList  reason: collision with other method in class */
    public final void m355getAccountList() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new SeletedStudentViewModel$getAccountList$1(this)), (CoroutineStart) null, new SeletedStudentViewModel$getAccountList$2(this, (Continuation<? super SeletedStudentViewModel$getAccountList$2>) null), 2, (Object) null);
    }

    public final StateLiveData<UserInfo> getCheckUserInfo() {
        return this.checkUserInfo;
    }

    public final void setCheckUserInfo(StateLiveData<UserInfo> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.checkUserInfo = stateLiveData;
    }

    public final void checkUserInfo() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new SeletedStudentViewModel$checkUserInfo$1(this)), (CoroutineStart) null, new SeletedStudentViewModel$checkUserInfo$2(this, (Continuation<? super SeletedStudentViewModel$checkUserInfo$2>) null), 2, (Object) null);
    }

    public final StateLiveData<UserBean> getLoginData() {
        return this.loginData;
    }

    public final void setLoginData(StateLiveData<UserBean> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.loginData = stateLiveData;
    }

    public final void switchLogin(String str) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new SeletedStudentViewModel$switchLogin$1(this)), (CoroutineStart) null, new SeletedStudentViewModel$switchLogin$2(this, str, (Continuation<? super SeletedStudentViewModel$switchLogin$2>) null), 2, (Object) null);
    }

    public final StateLiveData<AddNewStudent> getAddNewStudent() {
        return this.addNewStudent;
    }

    public final void setAddNewStudent(StateLiveData<AddNewStudent> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.addNewStudent = stateLiveData;
    }

    public final void addNewStudent(String str, String str2, String str3, Integer num, String str4) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new SeletedStudentViewModel$addNewStudent$1(this)), (CoroutineStart) null, new SeletedStudentViewModel$addNewStudent$2(this, str, str2, str3, num, str4, (Continuation<? super SeletedStudentViewModel$addNewStudent$2>) null), 2, (Object) null);
    }

    public final StateLiveData<Object> getModifyUserInfo() {
        return this.modifyUserInfo;
    }

    public final void setModifyUserInfo(StateLiveData<Object> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.modifyUserInfo = stateLiveData;
    }

    public final void modifyUserBasicInfo(String str, String str2, String str3, String str4, Integer num) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new SeletedStudentViewModel$modifyUserBasicInfo$1(this)), (CoroutineStart) null, new SeletedStudentViewModel$modifyUserBasicInfo$2(this, str, str2, str3, str4, num, (Continuation<? super SeletedStudentViewModel$modifyUserBasicInfo$2>) null), 2, (Object) null);
    }

    public final StateLiveData<GradeStageList> getGradeStageList() {
        return this.gradeStageList;
    }

    public final void setGradeStageList(StateLiveData<GradeStageList> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.gradeStageList = stateLiveData;
    }

    /* renamed from: getGradeStageList  reason: collision with other method in class */
    public final void m356getGradeStageList() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new SeletedStudentViewModel$getGradeStageList$1(this)), (CoroutineStart) null, new SeletedStudentViewModel$getGradeStageList$2(this, (Continuation<? super SeletedStudentViewModel$getGradeStageList$2>) null), 2, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0074 A[PHI: r10 
      PHI: (r10v2 java.lang.Object) = (r10v5 java.lang.Object), (r10v1 java.lang.Object) binds: [B:18:0x0071, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getUserInfoApi(kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.shop.bean.UserInfo> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.business.shop.viewmodel.SeletedStudentViewModel$getUserInfoApi$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.tal.app.thinkacademy.business.shop.viewmodel.SeletedStudentViewModel$getUserInfoApi$1 r0 = (com.tal.app.thinkacademy.business.shop.viewmodel.SeletedStudentViewModel$getUserInfoApi$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.shop.viewmodel.SeletedStudentViewModel$getUserInfoApi$1 r0 = new com.tal.app.thinkacademy.business.shop.viewmodel.SeletedStudentViewModel$getUserInfoApi$1
            r0.<init>(r9, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003e
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0074
        L_0x002e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0036:
            java.lang.Object r2 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r2 = (com.tal.app.thinkacademy.common.network.NetData) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0067
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r10)
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r10 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r10 = r10.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r6 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r10 = com.tal.app.thinkacademy.lib.network.Api.create(r10, r6)
            com.tal.app.thinkacademy.business.shop.ShopApi r10 = (com.tal.app.thinkacademy.business.shop.ShopApi) r10
            com.tal.app.thinkacademy.business.shop.bean.request.UserInfoRequest r6 = new com.tal.app.thinkacademy.business.shop.bean.request.UserInfoRequest
            com.tal.app.thinkacademy.business.shop.bean.request.Headers r7 = new com.tal.app.thinkacademy.business.shop.bean.request.Headers
            r8 = 3
            r7.<init>(r5, r5, r8, r5)
            r6.<init>(r7)
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r10 = r10.getUserInfo(r6, r0)
            if (r10 != r1) goto L_0x0067
            return r1
        L_0x0067:
            com.tal.app.thinkacademy.lib.restful.HiResponse r10 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r10
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r10 = r2.transform(r10, r0)
            if (r10 != r1) goto L_0x0074
            return r1
        L_0x0074:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.viewmodel.SeletedStudentViewModel.getUserInfoApi(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
