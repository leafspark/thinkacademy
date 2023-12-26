package com.tal.app.thinkacademy;

import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J&\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/DemoViewModel;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "liveData", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/TestData;", "getLiveData", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setLiveData", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "onPause", "", "onResume", "test", "appid", "", "lastDataVersion", "appVersionNumber", "systemName", "app_googleRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DemoViewModel.kt */
public final class DemoViewModel extends BaseViewModel {
    private StateLiveData<TestData> liveData = new StateLiveData<>();

    public final void test(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "appid");
        Intrinsics.checkNotNullParameter(str2, "lastDataVersion");
        Intrinsics.checkNotNullParameter(str3, "appVersionNumber");
        Intrinsics.checkNotNullParameter(str4, "systemName");
    }

    public final StateLiveData<TestData> getLiveData() {
        return this.liveData;
    }

    public final void setLiveData(StateLiveData<TestData> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.liveData = stateLiveData;
    }

    public void onResume() {
        DemoViewModel.super.onResume();
    }

    public void onPause() {
        DemoViewModel.super.onPause();
    }
}
