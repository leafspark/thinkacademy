package com.tal.app.thinkacademy.business.study.study;

import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.business.study.study.PrepareClassActivity;
import com.tal.app.thinkacademy.business.study.study.dialog.CheckInSuccessDialog;
import com.tal.app.thinkacademy.business.study.study.entity.CheckInData;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 6, 0})
/* compiled from: LiveData.kt */
public final class PrepareClassActivity$startObserve$$inlined$observe$4<T> implements Observer<T> {
    final /* synthetic */ PrepareClassActivity this$0;

    public PrepareClassActivity$startObserve$$inlined$observe$4(PrepareClassActivity prepareClassActivity) {
        this.this$0 = prepareClassActivity;
    }

    public final void onChanged(T t) {
        CheckInData checkInData;
        StateData stateData = (StateData) t;
        this.this$0.hideLoading();
        int i = PrepareClassActivity.WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()];
        boolean z = false;
        if (i != 1) {
            if (i == 2) {
                XesLog.it("PrepareClassActivity - prepareCheckInData ->", new Object[]{stateData.getData()});
            }
        } else if (stateData.getData() != null) {
            if (this.this$0.mCheckInSuccessDialog == null) {
                PrepareClassActivity prepareClassActivity = this.this$0;
                Context context = (Context) this.this$0;
                Integer num = null;
                if (!(stateData == null || (checkInData = (CheckInData) stateData.getData()) == null)) {
                    num = checkInData.getRightCoin();
                }
                prepareClassActivity.mCheckInSuccessDialog = new CheckInSuccessDialog(context, num);
            }
            CheckInSuccessDialog access$getMCheckInSuccessDialog$p = this.this$0.mCheckInSuccessDialog;
            if (access$getMCheckInSuccessDialog$p != null && !access$getMCheckInSuccessDialog$p.isShowing()) {
                z = true;
            }
            if (z) {
                CheckInSuccessDialog access$getMCheckInSuccessDialog$p2 = this.this$0.mCheckInSuccessDialog;
                if (access$getMCheckInSuccessDialog$p2 != null) {
                    access$getMCheckInSuccessDialog$p2.show();
                }
                Handler access$getMHandler$p = this.this$0.mHandler;
                if (access$getMHandler$p != null) {
                    access$getMHandler$p.postDelayed(new PrepareClassActivity$startObserve$4$1(this.this$0), 3000);
                }
            }
        }
    }
}
