package com.tal.app.thinkacademy.business.login.view.devicetest;

import com.tbruyelle.rxpermissions3.Permission;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tbruyelle/rxpermissions3/Permission;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceTestActivity.kt */
final class DeviceTestActivity$requestPermission$1 extends Lambda implements Function1<Permission, Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $block;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceTestActivity$requestPermission$1(Function1<? super Boolean, Unit> function1) {
        super(1);
        this.$block = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Permission) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Permission permission) {
        Intrinsics.checkNotNullParameter(permission, "it");
        this.$block.invoke(Boolean.valueOf(permission.granted));
    }
}
