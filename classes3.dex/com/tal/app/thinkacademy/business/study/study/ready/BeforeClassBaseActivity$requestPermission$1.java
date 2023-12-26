package com.tal.app.thinkacademy.business.study.study.ready;

import com.tbruyelle.rxpermissions3.Permission;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "VM", "Lcom/tal/app/thinkacademy/business/study/study/ready/ReadyClassBaseVM;", "VB", "Landroidx/viewbinding/ViewBinding;", "it", "Lcom/tbruyelle/rxpermissions3/Permission;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BeforeClassBaseActivity.kt */
final class BeforeClassBaseActivity$requestPermission$1 extends Lambda implements Function1<Permission, Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $block;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BeforeClassBaseActivity$requestPermission$1(Function1<? super Boolean, Unit> function1) {
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
