package com.tal.app.thinkacademy;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.databinding.ActivityDemoBinding;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/TestActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/DemoViewModel;", "Lcom/tal/app/thinkacademy/databinding/ActivityDemoBinding;", "()V", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "startObserve", "app_googleRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TestActivity.kt */
public final class TestActivity extends BaseVmActivity<DemoViewModel, ActivityDemoBinding> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TestActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            iArr[StateData.DataStatus.ERROR.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: protected */
    public ActivityDemoBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityDemoBinding inflate = ActivityDemoBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        TestActivity.super.onCreate(bundle);
        LoadStatusView loadStatusView = getBinding().lsView;
        Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.lsView");
        LoadStatusView.showFullLoadingView$default(loadStatusView, 0, 1, (Object) null);
        getMViewModel().test("androidMonitor", "0", "72001", "android");
    }

    public void startObserve() {
        TestActivity.super.startObserve();
        getMViewModel().getLiveData().observe((LifecycleOwner) this, new TestActivity$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-0  reason: not valid java name */
    public static final void m15startObserve$lambda0(TestActivity testActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(testActivity, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()];
        boolean z = true;
        if (i == 1) {
            testActivity.getBinding().lsView.hideFullLoadingView();
            TestData testData = (TestData) stateData.getData();
            if (testData == null || testData.getAllData() != 1) {
                z = false;
            }
            if (z) {
                LoadStatusView loadStatusView = testActivity.getBinding().lsView;
                Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.lsView");
                LoadStatusView.showEmptyView$default(loadStatusView, 0, (String) null, true, (String) null, TestActivity$startObserve$1$1.INSTANCE, 11, (Object) null);
                return;
            }
            testActivity.getBinding().lsView.restoreView();
        } else if (i == 2) {
            testActivity.getBinding().lsView.hideFullLoadingView();
            LoadStatusView loadStatusView2 = testActivity.getBinding().lsView;
            Intrinsics.checkNotNullExpressionValue(loadStatusView2, "binding.lsView");
            LoadStatusView.showErrorView$default(loadStatusView2, 0, (String) null, (String) null, (String) null, new TestActivity$startObserve$1$2(testActivity), 15, (Object) null);
        }
    }
}
