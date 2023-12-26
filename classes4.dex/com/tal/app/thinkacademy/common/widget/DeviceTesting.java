package com.tal.app.thinkacademy.common.widget;

import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u0010\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/common/widget/DeviceTesting;", "", "()V", "TAG_DEVICE_TEST", "", "TAG_TEST_RESULT", "TAG_TEST_STEP", "getTestingResult", "getTestingStep", "", "isTestFinished", "", "saveTestingResult", "", "step", "saveTestingStep", "setTestFinished", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceTesting.kt */
public final class DeviceTesting {
    public static final DeviceTesting INSTANCE = new DeviceTesting();
    private static final String TAG_DEVICE_TEST = "device_test_tag";
    private static final String TAG_TEST_RESULT = "device_test_result";
    private static final String TAG_TEST_STEP = "device_test_step";

    private DeviceTesting() {
    }

    public final boolean isTestFinished() {
        return ShareDataManager.getInstance().getBoolean(TAG_DEVICE_TEST, false, ShareDataManager.SHAREDATA_NOT_CLEAR);
    }

    public final void setTestFinished() {
        ShareDataManager.getInstance().put(TAG_DEVICE_TEST, true, ShareDataManager.SHAREDATA_NOT_CLEAR);
        saveTestingStep(0);
    }

    public final void saveTestingStep(int i) {
        ShareDataManager.getInstance().put(TAG_TEST_STEP, i, ShareDataManager.SHAREDATA_NOT_CLEAR);
    }

    public final int getTestingStep() {
        return ShareDataManager.getInstance().getInt(TAG_TEST_STEP, 0, ShareDataManager.SHAREDATA_NOT_CLEAR);
    }

    public final void saveTestingResult(String str) {
        Intrinsics.checkNotNullParameter(str, "step");
        ShareDataManager.getInstance().put(TAG_TEST_RESULT, str, ShareDataManager.SHAREDATA_NOT_CLEAR);
    }

    public final String getTestingResult() {
        String string = ShareDataManager.getInstance().getString(TAG_TEST_RESULT, "", ShareDataManager.SHAREDATA_NOT_CLEAR);
        Intrinsics.checkNotNullExpressionValue(string, "getInstance()\n          …ager.SHAREDATA_NOT_CLEAR)");
        return string;
    }
}
