package com.tal.app.thinkacademy.business.study.study.ready;

import android.text.TextUtils;
import com.tbruyelle.rxpermissions3.Permission;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tbruyelle/rxpermissions3/Permission;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BeforeClassLiveActivity.kt */
final class BeforeClassLiveActivity$permissionListener$1 extends Lambda implements Function1<Permission, Unit> {
    final /* synthetic */ BeforeClassLiveActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BeforeClassLiveActivity$permissionListener$1(BeforeClassLiveActivity beforeClassLiveActivity) {
        super(1);
        this.this$0 = beforeClassLiveActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Permission) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Permission permission) {
        Intrinsics.checkNotNullParameter(permission, "it");
        int i = 1;
        this.this$0.hasCheckPermission = true;
        if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
            BeforeClassBaseActivity.log$default(this.this$0, "在未展示，拦截权限请求：" + permission.name + " - " + permission.granted, (Boolean) null, 2, (Object) null);
            return;
        }
        if (TextUtils.equals(permission.name, "android.permission.RECORD_AUDIO")) {
            BeforeClassBaseActivity.log$default(this.this$0, Intrinsics.stringPlus("麦克风权限请求 garden=", permission), (Boolean) null, 2, (Object) null);
            i = 0;
        } else {
            BeforeClassBaseActivity.log$default(this.this$0, Intrinsics.stringPlus("相机权限请求 garden=", permission), (Boolean) null, 2, (Object) null);
        }
        if (permission.granted) {
            ((EnvTestItemView) this.this$0.mCheckList.get(i)).setStatus(2);
        } else {
            ((EnvTestItemView) this.this$0.mCheckList.get(i)).setStatus(3);
        }
    }
}
