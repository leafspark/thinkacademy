package com.tal.app.thinkacademy.business.study.study.ready;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.study.study.entity.CheckInData;
import com.tal.app.thinkacademy.business.study.study.entity.ReadyClassBean;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import com.tal.app.thinkacademy.lib.player.widget.RtcTest;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.lib.utils.StickyLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J3\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00120\u0016J?\u0010\u001a\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u00142#\u0010\u0015\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00120\u0016J\u001a\u0010\u001e\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010\u0014J\u0006\u0010%\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/ready/ReadyClassLiveVM;", "Lcom/tal/app/thinkacademy/business/study/study/ready/ReadyClassBaseVM;", "()V", "mEnableRtcTest", "", "mNetTestState", "Lcom/tal/app/thinkacademy/lib/utils/StickyLiveData;", "", "getMNetTestState", "()Lcom/tal/app/thinkacademy/lib/utils/StickyLiveData;", "mReadyClassBean", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/business/study/study/entity/ReadyClassBean;", "getMReadyClassBean", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "mRtcTest", "Lcom/tal/app/thinkacademy/lib/player/widget/RtcTest;", "modifyDisplayName", "", "nickName", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "requestCheckIn", "planId", "classId", "Lcom/tal/app/thinkacademy/business/study/study/entity/CheckInData;", "requestPrepareData", "setupRtc", "token", "uid", "", "startRtcCheck", "rtcToken", "stopRtcCheck", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReadyClassLiveVM.kt */
public final class ReadyClassLiveVM extends ReadyClassBaseVM {
    /* access modifiers changed from: private */
    public boolean mEnableRtcTest;
    private final StickyLiveData<Integer> mNetTestState = new StickyLiveData<>();
    private final StateLiveData<ReadyClassBean> mReadyClassBean = new StateLiveData<>();
    private RtcTest mRtcTest;

    public final StickyLiveData<Integer> getMNetTestState() {
        return this.mNetTestState;
    }

    public final StateLiveData<ReadyClassBean> getMReadyClassBean() {
        return this.mReadyClassBean;
    }

    public final void startRtcCheck(String str) {
        Unit unit;
        String uid;
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        long j = 0;
        if (!(userInfoEntity == null || (uid = userInfoEntity.getUid()) == null)) {
            j = Long.parseLong(uid);
        }
        if (str == null) {
            unit = null;
        } else {
            this.mEnableRtcTest = true;
            setupRtc(str, j);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            log("RTC检测未触发，rtcToken或uid为空。 rtcToken = " + str + " ,studentId = " + j);
        }
    }

    private final void setupRtc(String str, long j) {
        log("开始rtc检测");
        if (this.mRtcTest == null) {
            ReadyClassLiveVM readyClassLiveVM = this;
            Application app = Utils.getApp();
            Intrinsics.checkNotNullExpressionValue(app, "getApp()");
            this.mRtcTest = new RtcTest(app, j);
        }
        RtcTest rtcTest = this.mRtcTest;
        if (rtcTest != null) {
            rtcTest.setupRtc(str, new ReadyClassLiveVM$setupRtc$2(this));
        }
        RtcTest rtcTest2 = this.mRtcTest;
        if (rtcTest2 != null) {
            rtcTest2.enableLastMileProbeTest();
        }
    }

    public final void stopRtcCheck() {
        this.mEnableRtcTest = false;
        RtcTest rtcTest = this.mRtcTest;
        if (rtcTest != null) {
            rtcTest.disableLastMileProbeTest();
        }
        RtcTest rtcTest2 = this.mRtcTest;
        if (rtcTest2 != null) {
            rtcTest2.destroyRtc();
        }
        this.mRtcTest = null;
    }

    public final void requestPrepareData(String str, String str2) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ReadyClassLiveVM$requestPrepareData$1(this)), (CoroutineStart) null, new ReadyClassLiveVM$requestPrepareData$2(str, str2, this, (Continuation<? super ReadyClassLiveVM$requestPrepareData$2>) null), 2, (Object) null);
    }

    public final void requestCheckIn(String str, String str2, Function1<? super CheckInData, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ReadyClassLiveVM$requestCheckIn$1(function1)), (CoroutineStart) null, new ReadyClassLiveVM$requestCheckIn$2(str, str2, function1, (Continuation<? super ReadyClassLiveVM$requestCheckIn$2>) null), 2, (Object) null);
    }

    public final void modifyDisplayName(String str, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        if (str != null) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ReadyClassLiveVM$modifyDisplayName$1$1(function1)), (CoroutineStart) null, new ReadyClassLiveVM$modifyDisplayName$1$2(str, function1, (Continuation<? super ReadyClassLiveVM$modifyDisplayName$1$2>) null), 2, (Object) null);
        }
    }
}
