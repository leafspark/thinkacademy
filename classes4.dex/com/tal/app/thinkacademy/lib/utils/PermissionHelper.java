package com.tal.app.thinkacademy.lib.utils;

import android.os.Build;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.tbruyelle.rxpermissions3.Permission;
import com.tbruyelle.rxpermissions3.RxPermissions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0003J;\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0002\u0010\u000eJ;\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0002\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/PermissionHelper;", "", "()V", "isApiThan33", "", "request", "", "context", "Landroidx/fragment/app/FragmentActivity;", "permissions", "", "", "accept", "Lkotlin/Function1;", "(Landroidx/fragment/app/FragmentActivity;[Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "requestEach", "permission", "Lcom/tbruyelle/rxpermissions3/Permission;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PermissionHelper.kt */
public final class PermissionHelper {
    public static final PermissionHelper INSTANCE = new PermissionHelper();

    private PermissionHelper() {
    }

    private final boolean isApiThan33() {
        return Build.VERSION.SDK_INT >= 33;
    }

    public final void request(FragmentActivity fragmentActivity, String[] strArr, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "context");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(function1, "accept");
        if (strArr.length == 0) {
            function1.invoke(true);
            return;
        }
        List arrayList = new ArrayList();
        if (isApiThan33()) {
            boolean z = false;
            for (String str : strArr) {
                if (Intrinsics.areEqual(str, "android.permission.READ_EXTERNAL_STORAGE") || Intrinsics.areEqual(str, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    z = true;
                } else {
                    arrayList.add(str);
                }
            }
            if (z) {
                arrayList.add("android.permission.READ_MEDIA_IMAGES");
                arrayList.add("android.permission.READ_MEDIA_AUDIO");
                arrayList.add("android.permission.READ_MEDIA_VIDEO");
            }
        } else {
            CollectionsKt.addAll(arrayList, strArr);
        }
        Log.d("PermissionHelper", arrayList.toString());
        RxPermissions rxPermissions = new RxPermissions(fragmentActivity);
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr2 = (String[]) array;
        rxPermissions.request((String[]) Arrays.copyOf(strArr2, strArr2.length)).subscribe(new PermissionHelper$$ExternalSyntheticLambda1(function1));
    }

    /* access modifiers changed from: private */
    /* renamed from: request$lambda-1  reason: not valid java name */
    public static final void m123request$lambda1(Function1 function1, Boolean bool) {
        Intrinsics.checkNotNullParameter(function1, "$accept");
        Log.d("PermissionHelper", String.valueOf(bool));
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        function1.invoke(bool);
    }

    public final void requestEach(FragmentActivity fragmentActivity, String[] strArr, Function1<? super Permission, Unit> function1) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "context");
        Intrinsics.checkNotNullParameter(strArr, "permission");
        Intrinsics.checkNotNullParameter(function1, "accept");
        new RxPermissions(fragmentActivity).requestEach((String[]) Arrays.copyOf(strArr, strArr.length)).subscribe(new PermissionHelper$$ExternalSyntheticLambda0(function1));
    }

    /* access modifiers changed from: private */
    /* renamed from: requestEach$lambda-2  reason: not valid java name */
    public static final void m124requestEach$lambda2(Function1 function1, Permission permission) {
        Intrinsics.checkNotNullParameter(function1, "$accept");
        Intrinsics.checkNotNullExpressionValue(permission, "it");
        function1.invoke(permission);
    }
}
