package com.tal.app.thinkacademy.lib.utils;

import android.view.View;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0007J$\u0010\r\u001a\u00020\u0004*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0007¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/RxUnDoubleUtil;", "", "()V", "setOnCountClickListener", "", "Landroid/view/View;", "time", "", "count", "", "oneAction", "Lkotlin/Function0;", "action", "setOnUnDoubleClickListener", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RxUnDoubleUtil.kt */
public final class RxUnDoubleUtil {
    public static final RxUnDoubleUtil INSTANCE = new RxUnDoubleUtil();

    public final void setOnCountClickListener(View view, long j, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function0, "oneAction");
        Intrinsics.checkNotNullParameter(function02, "action");
        setOnCountClickListener$default(this, view, j, 0, function0, function02, 2, (Object) null);
    }

    public final void setOnCountClickListener(View view, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function0, "oneAction");
        Intrinsics.checkNotNullParameter(function02, "action");
        setOnCountClickListener$default(this, view, 0, 0, function0, function02, 3, (Object) null);
    }

    public final void setOnUnDoubleClickListener(View view, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function0, "action");
        setOnUnDoubleClickListener$default(this, view, 0, function0, 1, (Object) null);
    }

    private RxUnDoubleUtil() {
    }

    public static /* synthetic */ void setOnUnDoubleClickListener$default(RxUnDoubleUtil rxUnDoubleUtil, View view, long j, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 2000;
        }
        rxUnDoubleUtil.setOnUnDoubleClickListener(view, j, function0);
    }

    public final void setOnUnDoubleClickListener(View view, long j, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function0, "action");
        Observable.create(new RxUnDoubleUtil$$ExternalSyntheticLambda2(view)).throttleFirst(j, TimeUnit.MILLISECONDS).subscribe(new RxUnDoubleUtil$$ExternalSyntheticLambda4(function0));
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnUnDoubleClickListener$lambda-1  reason: not valid java name */
    public static final void m129setOnUnDoubleClickListener$lambda1(View view, ObservableEmitter observableEmitter) {
        Intrinsics.checkNotNullParameter(view, "$this_setOnUnDoubleClickListener");
        Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
        view.setOnClickListener(new RxUnDoubleUtil$$ExternalSyntheticLambda0(observableEmitter));
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnUnDoubleClickListener$lambda-1$lambda-0  reason: not valid java name */
    public static final void m130setOnUnDoubleClickListener$lambda1$lambda0(ObservableEmitter observableEmitter, View view) {
        Intrinsics.checkNotNullParameter(observableEmitter, "$emitter");
        observableEmitter.onNext("");
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnUnDoubleClickListener$lambda-2  reason: not valid java name */
    public static final void m131setOnUnDoubleClickListener$lambda2(Function0 function0, String str) {
        Intrinsics.checkNotNullParameter(function0, "$action");
        function0.invoke();
    }

    public static /* synthetic */ void setOnCountClickListener$default(RxUnDoubleUtil rxUnDoubleUtil, View view, long j, int i, Function0 function0, Function0 function02, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = 3000;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            i = 10;
        }
        rxUnDoubleUtil.setOnCountClickListener(view, j2, i, function0, function02);
    }

    public final void setOnCountClickListener(View view, long j, int i, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function0, "oneAction");
        Intrinsics.checkNotNullParameter(function02, "action");
        Ref.IntRef intRef = new Ref.IntRef();
        Observable.create(new RxUnDoubleUtil$$ExternalSyntheticLambda3(view, intRef)).throttleFirst(j, TimeUnit.MILLISECONDS).subscribe(new RxUnDoubleUtil$$ExternalSyntheticLambda5(intRef, function0, i, function02));
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnCountClickListener$lambda-4  reason: not valid java name */
    public static final void m126setOnCountClickListener$lambda4(View view, Ref.IntRef intRef, ObservableEmitter observableEmitter) {
        Intrinsics.checkNotNullParameter(view, "$this_setOnCountClickListener");
        Intrinsics.checkNotNullParameter(intRef, "$i");
        Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
        view.setOnClickListener(new RxUnDoubleUtil$$ExternalSyntheticLambda1(observableEmitter, intRef));
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnCountClickListener$lambda-4$lambda-3  reason: not valid java name */
    public static final void m127setOnCountClickListener$lambda4$lambda3(ObservableEmitter observableEmitter, Ref.IntRef intRef, View view) {
        Intrinsics.checkNotNullParameter(observableEmitter, "$emitter");
        Intrinsics.checkNotNullParameter(intRef, "$i");
        int i = intRef.element;
        intRef.element = i + 1;
        observableEmitter.onNext(Integer.valueOf(i));
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnCountClickListener$lambda-5  reason: not valid java name */
    public static final void m128setOnCountClickListener$lambda5(Ref.IntRef intRef, Function0 function0, int i, Function0 function02, Integer num) {
        Intrinsics.checkNotNullParameter(intRef, "$i");
        Intrinsics.checkNotNullParameter(function0, "$oneAction");
        Intrinsics.checkNotNullParameter(function02, "$action");
        if (intRef.element == 1) {
            function0.invoke();
        } else if (intRef.element >= i) {
            intRef.element = 1;
            function02.invoke();
        }
    }
}
