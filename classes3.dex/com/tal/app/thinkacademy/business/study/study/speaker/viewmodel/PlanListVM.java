package com.tal.app.thinkacademy.business.study.study.speaker.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity;
import com.tal.app.thinkacademy.business.study.study.entity.ClassCalendarEntity;
import com.tal.app.thinkacademy.business.study.study.entity.JumpParamsEntity;
import com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity;
import com.tal.app.thinkacademy.business.study.study.entity.TeachMethodEntity;
import com.tal.app.thinkacademy.business.study.study.entity.request.SyncHomeWork;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020+J\u0006\u0010-\u001a\u00020+J\u0010\u0010.\u001a\u00020+2\b\u0010/\u001a\u0004\u0018\u00010\u000bJ\u000e\u00100\u001a\u00020+2\u0006\u00101\u001a\u000202J\u000e\u0010#\u001a\u00020+2\u0006\u00103\u001a\u000204J\u0010\u00105\u001a\u00020+2\b\u00101\u001a\u0004\u0018\u000102J\u000e\u00106\u001a\u00020+2\u0006\u00107\u001a\u000208J\u001a\u00109\u001a\u00020+2\b\u0010/\u001a\u0004\u0018\u00010\u000b2\b\u0010:\u001a\u0004\u0018\u00010\u000bR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\"\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR6\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00160\u0015j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0016`\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\"\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\tR\"\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\"\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010\tR\u000e\u0010)\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/viewmodel/PlanListVM;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "classCalendar", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/business/study/study/entity/ClassCalendarEntity;", "getClassCalendar", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setClassCalendar", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "classCalendarKey", "", "homeWorkJumpUrl", "Lcom/tal/app/thinkacademy/business/study/study/entity/AssignmentEntity;", "getHomeWorkJumpUrl", "setHomeWorkJumpUrl", "homeWorkSyc", "", "getHomeWorkSyc", "setHomeWorkSyc", "mPlanListJob", "Ljava/util/HashMap;", "Lkotlinx/coroutines/Job;", "Lkotlin/collections/HashMap;", "getMPlanListJob", "()Ljava/util/HashMap;", "setMPlanListJob", "(Ljava/util/HashMap;)V", "nicknameKey", "planListKey", "previewQuestionJumpUrl", "getPreviewQuestionJumpUrl", "setPreviewQuestionJumpUrl", "recordedCalendar", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedCalendarListEntity;", "getRecordedCalendar", "setRecordedCalendar", "teachMethodData", "Lcom/tal/app/thinkacademy/business/study/study/entity/TeachMethodEntity;", "getTeachMethodData", "setTeachMethodData", "teachMethodKey", "cancelAll", "", "cancelPlanList", "cancelTeachMethod", "getClassCalendarInfo", "classId", "getPreQuestionJumpUrl", "jumpParamsEntity", "Lcom/tal/app/thinkacademy/business/study/study/entity/JumpParamsEntity;", "studentCourseId", "", "requestHomeWorkJumpUrl", "requestSycHomeWork", "syncHomeWork", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/SyncHomeWork;", "requestTeachMethod", "orderNum", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlanListVM.kt */
public final class PlanListVM extends BaseViewModel {
    private StateLiveData<ClassCalendarEntity> classCalendar = new StateLiveData<>();
    private final String classCalendarKey = "planlist";
    private StateLiveData<AssignmentEntity> homeWorkJumpUrl = new StateLiveData<>();
    private StateLiveData<Object> homeWorkSyc = new StateLiveData<>();
    private HashMap<String, Job> mPlanListJob = new HashMap<>();
    private final String nicknameKey = "nickname";
    private final String planListKey = "planlist";
    private StateLiveData<String> previewQuestionJumpUrl = new StateLiveData<>();
    private StateLiveData<RecordedCalendarListEntity> recordedCalendar = new StateLiveData<>();
    private StateLiveData<TeachMethodEntity> teachMethodData = new StateLiveData<>();
    private final String teachMethodKey = "teachmethod";

    public final HashMap<String, Job> getMPlanListJob() {
        return this.mPlanListJob;
    }

    public final void setMPlanListJob(HashMap<String, Job> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.mPlanListJob = hashMap;
    }

    public final StateLiveData<ClassCalendarEntity> getClassCalendar() {
        return this.classCalendar;
    }

    public final void setClassCalendar(StateLiveData<ClassCalendarEntity> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.classCalendar = stateLiveData;
    }

    public final void getClassCalendarInfo(String str) {
        this.mPlanListJob.put(this.classCalendarKey, BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new PlanListVM$getClassCalendarInfo$1(this)), (CoroutineStart) null, new PlanListVM$getClassCalendarInfo$2(this, str, (Continuation<? super PlanListVM$getClassCalendarInfo$2>) null), 2, (Object) null));
    }

    public final StateLiveData<TeachMethodEntity> getTeachMethodData() {
        return this.teachMethodData;
    }

    public final void setTeachMethodData(StateLiveData<TeachMethodEntity> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.teachMethodData = stateLiveData;
    }

    public final void requestTeachMethod(String str, String str2) {
        this.mPlanListJob.put(this.teachMethodKey, BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new PlanListVM$requestTeachMethod$1(this)), (CoroutineStart) null, new PlanListVM$requestTeachMethod$2(this, str, str2, (Continuation<? super PlanListVM$requestTeachMethod$2>) null), 2, (Object) null));
    }

    public final StateLiveData<AssignmentEntity> getHomeWorkJumpUrl() {
        return this.homeWorkJumpUrl;
    }

    public final void setHomeWorkJumpUrl(StateLiveData<AssignmentEntity> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.homeWorkJumpUrl = stateLiveData;
    }

    public final void requestHomeWorkJumpUrl(JumpParamsEntity jumpParamsEntity) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new PlanListVM$requestHomeWorkJumpUrl$1(this)), (CoroutineStart) null, new PlanListVM$requestHomeWorkJumpUrl$2(this, jumpParamsEntity, (Continuation<? super PlanListVM$requestHomeWorkJumpUrl$2>) null), 2, (Object) null);
    }

    public final StateLiveData<Object> getHomeWorkSyc() {
        return this.homeWorkSyc;
    }

    public final void setHomeWorkSyc(StateLiveData<Object> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.homeWorkSyc = stateLiveData;
    }

    public final void requestSycHomeWork(SyncHomeWork syncHomeWork) {
        Intrinsics.checkNotNullParameter(syncHomeWork, "syncHomeWork");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new PlanListVM$requestSycHomeWork$1()), (CoroutineStart) null, new PlanListVM$requestSycHomeWork$2(this, syncHomeWork, (Continuation<? super PlanListVM$requestSycHomeWork$2>) null), 2, (Object) null);
    }

    public final StateLiveData<String> getPreviewQuestionJumpUrl() {
        return this.previewQuestionJumpUrl;
    }

    public final void setPreviewQuestionJumpUrl(StateLiveData<String> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.previewQuestionJumpUrl = stateLiveData;
    }

    public final void getPreQuestionJumpUrl(JumpParamsEntity jumpParamsEntity) {
        Intrinsics.checkNotNullParameter(jumpParamsEntity, "jumpParamsEntity");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new PlanListVM$getPreQuestionJumpUrl$1(this)), (CoroutineStart) null, new PlanListVM$getPreQuestionJumpUrl$2(this, jumpParamsEntity, (Continuation<? super PlanListVM$getPreQuestionJumpUrl$2>) null), 2, (Object) null);
    }

    public final StateLiveData<RecordedCalendarListEntity> getRecordedCalendar() {
        return this.recordedCalendar;
    }

    public final void setRecordedCalendar(StateLiveData<RecordedCalendarListEntity> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.recordedCalendar = stateLiveData;
    }

    public final void getRecordedCalendar(long j) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new PlanListVM$getRecordedCalendar$1(this)), (CoroutineStart) null, new PlanListVM$getRecordedCalendar$2(this, j, (Continuation<? super PlanListVM$getRecordedCalendar$2>) null), 2, (Object) null);
    }

    public final void cancelPlanList() {
        Job job = this.mPlanListJob.get(this.planListKey);
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void cancelTeachMethod() {
        Job job = this.mPlanListJob.get(this.teachMethodKey);
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void cancelAll() {
        CoroutineScopeKt.cancel$default(ViewModelKt.getViewModelScope((ViewModel) this), (CancellationException) null, 1, (Object) null);
    }
}
