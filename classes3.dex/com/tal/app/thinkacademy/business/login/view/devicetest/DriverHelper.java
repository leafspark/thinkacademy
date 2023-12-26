package com.tal.app.thinkacademy.business.login.view.devicetest;

import android.view.ViewGroup;
import com.tal.app.thinkacademy.business.login.entity.DeviceTestResult;
import com.tal.app.thinkacademy.business.login.view.devicetest.driver.BaseTestDriver;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0012J\u0014\u0010\u0015\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0006\u0010\u0017\u001a\u00020\tJ)\u0010\u0018\u001a\u00020\u00072!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00070\u000bJ)\u0010\u001c\u001a\u00020\u00072!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\r0\u000bJ\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J>\u0010\u001e\u001a\u00020\u000726\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00070\u000fJ\u0018\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\"J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\tH\u0002J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u0006\u0010%\u001a\u00020\u0007J\u0006\u0010&\u001a\u00020\u0007R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/devicetest/DriverHelper;", "", "mGroup", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "mAllFinishBlock", "Lkotlin/Function0;", "", "mCurrentStep", "", "mDriverFinishBlock", "Lkotlin/Function1;", "mDriverLoadInterceptor", "", "mDriverResultBlock", "Lkotlin/Function2;", "mDrivers", "", "Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/BaseTestDriver;", "addDriver", "driver", "allFinishCall", "block", "currentStep", "driverFinishCall", "Lkotlin/ParameterName;", "name", "index", "driverLoadInterceptor", "driverPos", "driverResultCall", "result", "load", "step", "Lcom/tal/app/thinkacademy/business/login/entity/DeviceTestResult;", "loadDriver", "registerCallback", "release", "reloadCurrent", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DriverHelper.kt */
public final class DriverHelper {
    /* access modifiers changed from: private */
    public Function0<Unit> mAllFinishBlock;
    private int mCurrentStep;
    /* access modifiers changed from: private */
    public Function1<? super Integer, Unit> mDriverFinishBlock;
    /* access modifiers changed from: private */
    public Function1<? super Integer, Boolean> mDriverLoadInterceptor;
    /* access modifiers changed from: private */
    public Function2<? super Integer, ? super Boolean, Unit> mDriverResultBlock;
    /* access modifiers changed from: private */
    public final List<BaseTestDriver> mDrivers = new ArrayList();
    private final ViewGroup mGroup;

    public DriverHelper(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "mGroup");
        this.mGroup = viewGroup;
    }

    public final void driverResultCall(Function2<? super Integer, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        this.mDriverResultBlock = function2;
    }

    public final void driverLoadInterceptor(Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.mDriverLoadInterceptor = function1;
    }

    public final void driverFinishCall(Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.mDriverFinishBlock = function1;
    }

    public final void allFinishCall(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.mAllFinishBlock = function0;
    }

    public final void addDriver(BaseTestDriver baseTestDriver) {
        Intrinsics.checkNotNullParameter(baseTestDriver, "driver");
        this.mDrivers.add(baseTestDriver);
        registerCallback(baseTestDriver);
    }

    private final void registerCallback(BaseTestDriver baseTestDriver) {
        baseTestDriver.resultCall(new DriverHelper$registerCallback$1(this, baseTestDriver));
        baseTestDriver.nextCall(new DriverHelper$registerCallback$2(this, baseTestDriver));
    }

    /* access modifiers changed from: private */
    public final int driverPos(BaseTestDriver baseTestDriver) {
        return this.mDrivers.indexOf(baseTestDriver);
    }

    public final void load(int i, DeviceTestResult deviceTestResult) {
        if (i != 0) {
            int i2 = 0;
            while (i2 < i) {
                int i3 = i2 + 1;
                if (i2 == 0) {
                    Function2<? super Integer, ? super Boolean, Unit> function2 = this.mDriverResultBlock;
                    if (function2 != null) {
                        function2.invoke(0, Boolean.valueOf(deviceTestResult == null ? false : deviceTestResult.getNetwork()));
                    }
                    Function1<? super Integer, Unit> function1 = this.mDriverFinishBlock;
                    if (function1 != null) {
                        function1.invoke(0);
                    }
                } else if (i2 == 1) {
                    Function2<? super Integer, ? super Boolean, Unit> function22 = this.mDriverResultBlock;
                    if (function22 != null) {
                        function22.invoke(1, Boolean.valueOf(deviceTestResult == null ? false : deviceTestResult.getMic()));
                    }
                    Function1<? super Integer, Unit> function12 = this.mDriverFinishBlock;
                    if (function12 != null) {
                        function12.invoke(1);
                    }
                } else if (i2 == 2) {
                    Function2<? super Integer, ? super Boolean, Unit> function23 = this.mDriverResultBlock;
                    if (function23 != null) {
                        function23.invoke(2, Boolean.valueOf(deviceTestResult == null ? false : deviceTestResult.getCamera()));
                    }
                    Function1<? super Integer, Unit> function13 = this.mDriverFinishBlock;
                    if (function13 != null) {
                        function13.invoke(2);
                    }
                }
                i2 = i3;
            }
        }
        loadDriver(i);
    }

    /* access modifiers changed from: private */
    public final void loadDriver(int i) {
        this.mCurrentStep = i;
        List<BaseTestDriver> list = this.mDrivers;
        boolean z = true;
        if (1 > i || i >= list.size()) {
            z = false;
        }
        if (!z) {
            i = 0;
        }
        list.get(i).load(this.mGroup);
    }

    public final void release() {
        for (BaseTestDriver release : this.mDrivers) {
            release.release();
        }
        this.mDrivers.clear();
        this.mDriverResultBlock = null;
        this.mDriverFinishBlock = null;
    }

    public final int currentStep() {
        return this.mCurrentStep;
    }

    public final void reloadCurrent() {
        BaseTestDriver baseTestDriver = this.mDrivers.get(this.mCurrentStep);
        baseTestDriver.release();
        registerCallback(baseTestDriver);
        baseTestDriver.load(this.mGroup);
    }
}
