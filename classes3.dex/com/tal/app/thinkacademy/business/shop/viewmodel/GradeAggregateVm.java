package com.tal.app.thinkacademy.business.shop.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.home.main.shop.bean.LeaveInfoPostBodyData;
import com.tal.app.thinkacademy.business.shop.bean.GradeAggregateClassListData;
import com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo;
import com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTitleNode;
import com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.user.GradeStageList;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\f\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#JG\u0010\u0018\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010 2\b\u0010%\u001a\u0004\u0018\u00010 2\b\u0010&\u001a\u0004\u0018\u00010 2\b\u0010'\u001a\u0004\u0018\u00010 2\b\u0010(\u001a\u0004\u0018\u00010 2\b\u0010)\u001a\u0004\u0018\u00010*¢\u0006\u0002\u0010+R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\t¨\u0006-"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/viewmodel/GradeAggregateVm;", "Lcom/tal/app/thinkacademy/business/shop/viewmodel/SeletedStudentViewModel;", "()V", "classList", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateClassListData;", "getClassList", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setClassList", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "gradeStageLists", "Lcom/tal/app/thinkacademy/common/user/GradeStageList;", "getGradeStageLists", "setGradeStageLists", "mMainDetail", "Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateDetailInfo;", "getMMainDetail", "setMMainDetail", "postLeaveInfoResult", "", "getPostLeaveInfoResult", "setPostLeaveInfoResult", "repository", "Lcom/tal/app/thinkacademy/business/shop/repository/ShopClassListRepository;", "submitIntention", "getSubmitIntention", "setSubmitIntention", "", "node", "Lcom/tal/app/thinkacademy/business/shop/bean/gradeaggregatenode/GradeAggregateTitleNode;", "getMainDetail", "pageId", "", "postLeaveInfo", "data", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/LeaveInfoPostBodyData;", "yearGroup", "day", "time", "email", "name", "subStatus", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "Companion", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateVm.kt */
public final class GradeAggregateVm extends SeletedStudentViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "GradeAggregateVm";
    private StateLiveData<GradeAggregateClassListData> classList = new StateLiveData<>();
    private StateLiveData<GradeStageList> gradeStageLists = new StateLiveData<>();
    private StateLiveData<GradeAggregateDetailInfo> mMainDetail = new StateLiveData<>();
    private StateLiveData<Object> postLeaveInfoResult = new StateLiveData<>();
    /* access modifiers changed from: private */
    public final ShopClassListRepository repository = new ShopClassListRepository();
    private StateLiveData<Object> submitIntention = new StateLiveData<>();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/viewmodel/GradeAggregateVm$Companion;", "", "()V", "TAG", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GradeAggregateVm.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final StateLiveData<Object> getSubmitIntention() {
        return this.submitIntention;
    }

    public final void setSubmitIntention(StateLiveData<Object> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.submitIntention = stateLiveData;
    }

    public final void submitIntention(String str, String str2, String str3, String str4, String str5, Integer num) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new GradeAggregateVm$submitIntention$1(this)), (CoroutineStart) null, new GradeAggregateVm$submitIntention$2(this, str, str2, str3, str4, str5, num, (Continuation<? super GradeAggregateVm$submitIntention$2>) null), 2, (Object) null);
    }

    public final StateLiveData<GradeStageList> getGradeStageLists() {
        return this.gradeStageLists;
    }

    public final void setGradeStageLists(StateLiveData<GradeStageList> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.gradeStageLists = stateLiveData;
    }

    /* renamed from: getGradeStageLists  reason: collision with other method in class */
    public final void m354getGradeStageLists() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new GradeAggregateVm$getGradeStageLists$1(this)), (CoroutineStart) null, new GradeAggregateVm$getGradeStageLists$2(this, (Continuation<? super GradeAggregateVm$getGradeStageLists$2>) null), 2, (Object) null);
    }

    public final StateLiveData<GradeAggregateDetailInfo> getMMainDetail() {
        return this.mMainDetail;
    }

    public final void setMMainDetail(StateLiveData<GradeAggregateDetailInfo> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.mMainDetail = stateLiveData;
    }

    public final void getMainDetail(String str) {
        Intrinsics.checkNotNullParameter(str, "pageId");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new GradeAggregateVm$getMainDetail$1(this)), (CoroutineStart) null, new GradeAggregateVm$getMainDetail$2(this, str, (Continuation<? super GradeAggregateVm$getMainDetail$2>) null), 2, (Object) null);
    }

    public final StateLiveData<GradeAggregateClassListData> getClassList() {
        return this.classList;
    }

    public final void setClassList(StateLiveData<GradeAggregateClassListData> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.classList = stateLiveData;
    }

    public final void getClassList(GradeAggregateTitleNode gradeAggregateTitleNode) {
        Intrinsics.checkNotNullParameter(gradeAggregateTitleNode, "node");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new GradeAggregateVm$getClassList$1(this)), (CoroutineStart) null, new GradeAggregateVm$getClassList$2(this, gradeAggregateTitleNode, (Continuation<? super GradeAggregateVm$getClassList$2>) null), 2, (Object) null);
    }

    public final StateLiveData<Object> getPostLeaveInfoResult() {
        return this.postLeaveInfoResult;
    }

    public final void setPostLeaveInfoResult(StateLiveData<Object> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.postLeaveInfoResult = stateLiveData;
    }

    public final void postLeaveInfo(LeaveInfoPostBodyData leaveInfoPostBodyData) {
        Intrinsics.checkNotNullParameter(leaveInfoPostBodyData, DbParams.KEY_DATA);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new GradeAggregateVm$postLeaveInfo$1(this)), (CoroutineStart) null, new GradeAggregateVm$postLeaveInfo$2(this, leaveInfoPostBodyData, (Continuation<? super GradeAggregateVm$postLeaveInfo$2>) null), 2, (Object) null);
    }
}
