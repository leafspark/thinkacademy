package com.tal.app.thinkacademy.business.login.presenter;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.login.config.LoginRepository;
import com.tal.app.thinkacademy.business.login.entity.LinkedAccount;
import com.tal.app.thinkacademy.business.login.entity.UseGetInfo;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.user.GradeStageList;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014JO\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0010\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u001f¢\u0006\u0002\u0010!R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/presenter/PersonalInfoViewModel;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "changeUser", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "", "getChangeUser", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setChangeUser", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "gradeStageList", "Lcom/tal/app/thinkacademy/common/user/GradeStageList;", "getGradeStageList", "setGradeStageList", "mUserGetInfo", "Lcom/tal/app/thinkacademy/business/login/entity/UseGetInfo;", "getMUserGetInfo", "setMUserGetInfo", "repository", "Lcom/tal/app/thinkacademy/business/login/config/LoginRepository;", "", "getUserInfo", "modifyUserBasicInfo", "avatar", "", "nickName", "firstName", "lastName", "grade", "", "linkedAccount", "", "Lcom/tal/app/thinkacademy/business/login/entity/LinkedAccount;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "Companion", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalInfoViewModel.kt */
public final class PersonalInfoViewModel extends BaseViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "PersonalInfoViewModel";
    private StateLiveData<Object> changeUser = new StateLiveData<>();
    private StateLiveData<GradeStageList> gradeStageList = new StateLiveData<>();
    private StateLiveData<UseGetInfo> mUserGetInfo = new StateLiveData<>();
    /* access modifiers changed from: private */
    public final LoginRepository repository = new LoginRepository();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/presenter/PersonalInfoViewModel$Companion;", "", "()V", "TAG", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PersonalInfoViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final StateLiveData<UseGetInfo> getMUserGetInfo() {
        return this.mUserGetInfo;
    }

    public final void setMUserGetInfo(StateLiveData<UseGetInfo> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.mUserGetInfo = stateLiveData;
    }

    public final void getUserInfo() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new PersonalInfoViewModel$getUserInfo$1(this)), (CoroutineStart) null, new PersonalInfoViewModel$getUserInfo$2(this, (Continuation<? super PersonalInfoViewModel$getUserInfo$2>) null), 2, (Object) null);
    }

    public final StateLiveData<GradeStageList> getGradeStageList() {
        return this.gradeStageList;
    }

    public final void setGradeStageList(StateLiveData<GradeStageList> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.gradeStageList = stateLiveData;
    }

    /* renamed from: getGradeStageList  reason: collision with other method in class */
    public final void m52getGradeStageList() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new PersonalInfoViewModel$getGradeStageList$1(this)), (CoroutineStart) null, new PersonalInfoViewModel$getGradeStageList$2(this, (Continuation<? super PersonalInfoViewModel$getGradeStageList$2>) null), 2, (Object) null);
    }

    public final StateLiveData<Object> getChangeUser() {
        return this.changeUser;
    }

    public final void setChangeUser(StateLiveData<Object> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.changeUser = stateLiveData;
    }

    public final void modifyUserBasicInfo(String str, String str2, String str3, String str4, Integer num, List<LinkedAccount> list) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new PersonalInfoViewModel$modifyUserBasicInfo$1(this)), (CoroutineStart) null, new PersonalInfoViewModel$modifyUserBasicInfo$2(this, str, str2, str3, str4, num, list, (Continuation<? super PersonalInfoViewModel$modifyUserBasicInfo$2>) null), 2, (Object) null);
    }
}
