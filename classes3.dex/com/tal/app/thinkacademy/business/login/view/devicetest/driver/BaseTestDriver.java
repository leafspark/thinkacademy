package com.tal.app.thinkacademy.business.login.view.devicetest.driver;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0014\u0010\u0018\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\b\u0010\u001a\u001a\u00020\tH\u0016J\u001a\u0010\u001b\u001a\u00020\t2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/BaseTestDriver;", "", "mDriverOwner", "Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/DeviceTestDriverOwner;", "(Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/DeviceTestDriverOwner;)V", "getMDriverOwner", "()Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/DeviceTestDriverOwner;", "mFinishCallBlock", "Lkotlin/Function0;", "", "getMFinishCallBlock", "()Lkotlin/jvm/functions/Function0;", "setMFinishCallBlock", "(Lkotlin/jvm/functions/Function0;)V", "mResultCallBlock", "Lkotlin/Function1;", "", "getMResultCallBlock", "()Lkotlin/jvm/functions/Function1;", "setMResultCallBlock", "(Lkotlin/jvm/functions/Function1;)V", "load", "group", "Landroid/view/ViewGroup;", "nextCall", "block", "release", "resultCall", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseTestDriver.kt */
public abstract class BaseTestDriver {
    private final DeviceTestDriverOwner mDriverOwner;
    private Function0<Unit> mFinishCallBlock;
    private Function1<? super Boolean, Unit> mResultCallBlock;

    public BaseTestDriver(DeviceTestDriverOwner deviceTestDriverOwner) {
        Intrinsics.checkNotNullParameter(deviceTestDriverOwner, "mDriverOwner");
        this.mDriverOwner = deviceTestDriverOwner;
    }

    /* access modifiers changed from: protected */
    public final DeviceTestDriverOwner getMDriverOwner() {
        return this.mDriverOwner;
    }

    /* access modifiers changed from: protected */
    public final Function1<Boolean, Unit> getMResultCallBlock() {
        return this.mResultCallBlock;
    }

    /* access modifiers changed from: protected */
    public final void setMResultCallBlock(Function1<? super Boolean, Unit> function1) {
        this.mResultCallBlock = function1;
    }

    /* access modifiers changed from: protected */
    public final Function0<Unit> getMFinishCallBlock() {
        return this.mFinishCallBlock;
    }

    /* access modifiers changed from: protected */
    public final void setMFinishCallBlock(Function0<Unit> function0) {
        this.mFinishCallBlock = function0;
    }

    public void load(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        viewGroup.removeAllViews();
    }

    public void release() {
        this.mResultCallBlock = null;
        this.mFinishCallBlock = null;
    }

    public final void resultCall(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.mResultCallBlock = function1;
    }

    public final void nextCall(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.mFinishCallBlock = function0;
    }
}
