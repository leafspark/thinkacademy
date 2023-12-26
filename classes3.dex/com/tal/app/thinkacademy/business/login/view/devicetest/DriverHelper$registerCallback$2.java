package com.tal.app.thinkacademy.business.login.view.devicetest;

import com.tal.app.thinkacademy.business.login.view.devicetest.driver.BaseTestDriver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DriverHelper.kt */
final class DriverHelper$registerCallback$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BaseTestDriver $driver;
    final /* synthetic */ DriverHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DriverHelper$registerCallback$2(DriverHelper driverHelper, BaseTestDriver baseTestDriver) {
        super(0);
        this.this$0 = driverHelper;
        this.$driver = baseTestDriver;
    }

    public final void invoke() {
        int access$driverPos = this.this$0.driverPos(this.$driver);
        Function1 access$getMDriverLoadInterceptor$p = this.this$0.mDriverLoadInterceptor;
        boolean z = false;
        if (access$getMDriverLoadInterceptor$p != null && ((Boolean) access$getMDriverLoadInterceptor$p.invoke(Integer.valueOf(access$driverPos + 1))).booleanValue()) {
            z = true;
        }
        if (!z) {
            if (access$driverPos != this.this$0.mDrivers.size() - 1) {
                this.$driver.release();
                this.this$0.loadDriver(access$driverPos + 1);
                Function1 access$getMDriverFinishBlock$p = this.this$0.mDriverFinishBlock;
                if (access$getMDriverFinishBlock$p != null) {
                    access$getMDriverFinishBlock$p.invoke(Integer.valueOf(access$driverPos));
                    return;
                }
                return;
            }
            Function0 access$getMAllFinishBlock$p = this.this$0.mAllFinishBlock;
            if (access$getMAllFinishBlock$p != null) {
                access$getMAllFinishBlock$p.invoke();
            }
        }
    }
}
