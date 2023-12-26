package com.tal.app.thinkacademy.business.study.study.vm;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.study.study.entity.AllSchoolsList;
import com.tal.app.thinkacademy.business.study.study.entity.ClassListEntity;
import com.tal.app.thinkacademy.business.study.study.entity.CurrentSchool;
import com.tal.app.thinkacademy.business.study.study.entity.RecordedClassList;
import com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList;
import com.tal.app.thinkacademy.business.study.study.entity.request.AllSchoolsRequest;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.entity.InitEntryInfoBean;
import com.tal.app.thinkacademy.common.entity.TimeZoneCheckEntity;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u0002002\u0006\u00104\u001a\u000205J\u0006\u00106\u001a\u000200J\u0006\u0010%\u001a\u000200J\u0016\u00107\u001a\u0002002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;J\u0006\u0010<\u001a\u000200J\u0010\u0010=\u001a\u0002002\b\u0010>\u001a\u0004\u0018\u000109J\u000e\u0010+\u001a\u0002002\u0006\u0010?\u001a\u000209R\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\"\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR\"\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\"\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010\t¨\u0006@"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/vm/StudyCenterVM;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "allSchools", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/business/study/study/entity/AllSchoolsList;", "getAllSchools", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setAllSchools", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "classList", "Lcom/tal/app/thinkacademy/business/study/study/entity/ClassListEntity;", "getClassList", "setClassList", "currentSchool", "Lcom/tal/app/thinkacademy/business/study/study/entity/CurrentSchool;", "getCurrentSchool", "setCurrentSchool", "initEntryInfoData", "Lcom/tal/app/thinkacademy/common/entity/InitEntryInfoBean;", "getInitEntryInfoData", "setInitEntryInfoData", "loginData", "Lcom/tal/app/thinkacademy/common/user/UserBean;", "getLoginData", "setLoginData", "mLoginDataJob", "Lkotlinx/coroutines/Job;", "getMLoginDataJob", "()Lkotlinx/coroutines/Job;", "setMLoginDataJob", "(Lkotlinx/coroutines/Job;)V", "mSwitchOptionsJob", "getMSwitchOptionsJob", "setMSwitchOptionsJob", "recordedClassList", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedClassList;", "getRecordedClassList", "setRecordedClassList", "switchOptions", "Lcom/tal/app/thinkacademy/business/study/study/entity/SwitchOptionsList;", "getSwitchOptions", "setSwitchOptions", "timeZoneCheck", "Lcom/tal/app/thinkacademy/common/entity/TimeZoneCheckEntity;", "getTimeZoneCheck", "setTimeZoneCheck", "getAllSchoolsData", "", "request", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/AllSchoolsRequest;", "getClassListData", "context", "Landroid/content/Context;", "getCurrentSchoolData", "getSwitchOptionsData", "category", "", "haveCourse", "", "initEntryInfo", "switchAccountLogin", "uid", "timeZone", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudyCenterVM.kt */
public final class StudyCenterVM extends BaseViewModel {
    private StateLiveData<AllSchoolsList> allSchools = new StateLiveData<>();
    private StateLiveData<ClassListEntity> classList = new StateLiveData<>();
    private StateLiveData<CurrentSchool> currentSchool = new StateLiveData<>();
    private StateLiveData<InitEntryInfoBean> initEntryInfoData = new StateLiveData<>();
    private StateLiveData<UserBean> loginData = new StateLiveData<>();
    private Job mLoginDataJob;
    private Job mSwitchOptionsJob;
    private StateLiveData<RecordedClassList> recordedClassList = new StateLiveData<>();
    private StateLiveData<SwitchOptionsList> switchOptions = new StateLiveData<>();
    private StateLiveData<TimeZoneCheckEntity> timeZoneCheck = new StateLiveData<>();

    public final StateLiveData<CurrentSchool> getCurrentSchool() {
        return this.currentSchool;
    }

    public final void setCurrentSchool(StateLiveData<CurrentSchool> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.currentSchool = stateLiveData;
    }

    public final void getCurrentSchoolData() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new StudyCenterVM$getCurrentSchoolData$1(this)), (CoroutineStart) null, new StudyCenterVM$getCurrentSchoolData$2(this, (Continuation<? super StudyCenterVM$getCurrentSchoolData$2>) null), 2, (Object) null);
    }

    public final StateLiveData<AllSchoolsList> getAllSchools() {
        return this.allSchools;
    }

    public final void setAllSchools(StateLiveData<AllSchoolsList> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.allSchools = stateLiveData;
    }

    public final void getAllSchoolsData(AllSchoolsRequest allSchoolsRequest) {
        Intrinsics.checkNotNullParameter(allSchoolsRequest, "request");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new StudyCenterVM$getAllSchoolsData$1(this)), (CoroutineStart) null, new StudyCenterVM$getAllSchoolsData$2(this, allSchoolsRequest, (Continuation<? super StudyCenterVM$getAllSchoolsData$2>) null), 2, (Object) null);
    }

    public final StateLiveData<ClassListEntity> getClassList() {
        return this.classList;
    }

    public final void setClassList(StateLiveData<ClassListEntity> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.classList = stateLiveData;
    }

    public final void getClassListData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new StudyCenterVM$getClassListData$1(this)), (CoroutineStart) null, new StudyCenterVM$getClassListData$2(this, context, (Continuation<? super StudyCenterVM$getClassListData$2>) null), 2, (Object) null);
    }

    public final StateLiveData<SwitchOptionsList> getSwitchOptions() {
        return this.switchOptions;
    }

    public final void setSwitchOptions(StateLiveData<SwitchOptionsList> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.switchOptions = stateLiveData;
    }

    public final Job getMSwitchOptionsJob() {
        return this.mSwitchOptionsJob;
    }

    public final void setMSwitchOptionsJob(Job job) {
        this.mSwitchOptionsJob = job;
    }

    public final void getSwitchOptionsData(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "category");
        Job job = this.mSwitchOptionsJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.mSwitchOptionsJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new StudyCenterVM$getSwitchOptionsData$1(this)), (CoroutineStart) null, new StudyCenterVM$getSwitchOptionsData$2(this, str, z, (Continuation<? super StudyCenterVM$getSwitchOptionsData$2>) null), 2, (Object) null);
    }

    public final StateLiveData<UserBean> getLoginData() {
        return this.loginData;
    }

    public final void setLoginData(StateLiveData<UserBean> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.loginData = stateLiveData;
    }

    public final Job getMLoginDataJob() {
        return this.mLoginDataJob;
    }

    public final void setMLoginDataJob(Job job) {
        this.mLoginDataJob = job;
    }

    public final void switchAccountLogin(String str) {
        Job job = this.mLoginDataJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.mLoginDataJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new StudyCenterVM$switchAccountLogin$1(this)), (CoroutineStart) null, new StudyCenterVM$switchAccountLogin$2(this, str, (Continuation<? super StudyCenterVM$switchAccountLogin$2>) null), 2, (Object) null);
    }

    public final StateLiveData<InitEntryInfoBean> getInitEntryInfoData() {
        return this.initEntryInfoData;
    }

    public final void setInitEntryInfoData(StateLiveData<InitEntryInfoBean> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.initEntryInfoData = stateLiveData;
    }

    public final void initEntryInfo() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new StudyCenterVM$initEntryInfo$1(this)), (CoroutineStart) null, new StudyCenterVM$initEntryInfo$2(this, (Continuation<? super StudyCenterVM$initEntryInfo$2>) null), 2, (Object) null);
    }

    public final StateLiveData<TimeZoneCheckEntity> getTimeZoneCheck() {
        return this.timeZoneCheck;
    }

    public final void setTimeZoneCheck(StateLiveData<TimeZoneCheckEntity> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.timeZoneCheck = stateLiveData;
    }

    public final void timeZoneCheck(String str) {
        Intrinsics.checkNotNullParameter(str, "timeZone");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new StudyCenterVM$timeZoneCheck$1(this)), (CoroutineStart) null, new StudyCenterVM$timeZoneCheck$2(this, str, (Continuation<? super StudyCenterVM$timeZoneCheck$2>) null), 2, (Object) null);
    }

    public final StateLiveData<RecordedClassList> getRecordedClassList() {
        return this.recordedClassList;
    }

    public final void setRecordedClassList(StateLiveData<RecordedClassList> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.recordedClassList = stateLiveData;
    }

    /* renamed from: getRecordedClassList  reason: collision with other method in class */
    public final void m492getRecordedClassList() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new StudyCenterVM$getRecordedClassList$1(this)), (CoroutineStart) null, new StudyCenterVM$getRecordedClassList$2(this, (Continuation<? super StudyCenterVM$getRecordedClassList$2>) null), 2, (Object) null);
    }
}
