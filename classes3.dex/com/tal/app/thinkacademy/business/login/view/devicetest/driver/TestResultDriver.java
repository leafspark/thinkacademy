package com.tal.app.thinkacademy.business.login.view.devicetest.driver;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/TestResultDriver;", "Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/BaseTestDriver;", "owner", "Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/DeviceTestDriverOwner;", "(Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/DeviceTestDriverOwner;)V", "load", "", "group", "Landroid/view/ViewGroup;", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TestResultDriver.kt */
public final class TestResultDriver extends BaseTestDriver {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TestResultDriver(DeviceTestDriverOwner deviceTestDriverOwner) {
        super(deviceTestDriverOwner);
        Intrinsics.checkNotNullParameter(deviceTestDriverOwner, "owner");
    }

    public void load(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        super.load(viewGroup);
        LayoutInflater from = LayoutInflater.from(getMDriverOwner().getContext());
        int i = R.layout.layout_device_test_result_driver;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i, viewGroup) : XMLParseInstrumentation.inflate(from, i, viewGroup);
        DeviceTestDriverOwner mDriverOwner = getMDriverOwner();
        boolean testSuccess = mDriverOwner.getDeviceTestResult().testSuccess();
        ((ImageView) inflate.findViewById(R.id.iv_result_state)).setImageResource(testSuccess ? R.drawable.ic_device_test_result_success : R.drawable.ic_device_test_result_fail);
        ((TextView) inflate.findViewById(R.id.tv_result_msg)).setText(mDriverOwner.getContext().getString(testSuccess ? R.string.your_equipment_meets_the_needs_of_class : R.string.your_equipment_does_not_fully_meet_the_needs_of_class));
        ((TextView) inflate.findViewById(R.id.tv_result_hint)).setVisibility(testSuccess ? 8 : 0);
        ((TextView) inflate.findViewById(R.id.tv_back)).setOnClickListener(new TestResultDriver$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: load$lambda-1$lambda-0  reason: not valid java name */
    public static final void m163load$lambda1$lambda0(TestResultDriver testResultDriver, View view) {
        Intrinsics.checkNotNullParameter(testResultDriver, "this$0");
        Function0<Unit> mFinishCallBlock = testResultDriver.getMFinishCallBlock();
        if (mFinishCallBlock != null) {
            mFinishCallBlock.invoke();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
