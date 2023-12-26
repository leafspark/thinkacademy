package com.tal.app.thinkacademy.live.abilitypack.allonstage.listenbody;

import com.tal.app.thinkacademy.live.abilitypack.allonstage.Type;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerBody;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0000H\u0016J\u0014\u0010\u0011\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J)\u0010\f\u001a\u00020\u00052!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00050\u0007J)\u0010\u0013\u001a\u00020\u00052!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00050\u0007R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R+\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000\u0001\u0003\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/listenbody/AllOnStageListenerBody;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerBody;", "()V", "exitCourseAction", "Lkotlin/Function0;", "", "mOnStageChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isOn", "onPermissionOpenControl", "Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/Type;", "type", "dispatch", "listener", "onExitCourse", "action", "onStageChanged", "Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/listenbody/ExitCourse;", "Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/listenbody/OnStageChanged;", "Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/listenbody/PermissionOpenControl;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStageListenerBody.kt */
public abstract class AllOnStageListenerBody extends ListenerBody<AllOnStageListenerBody> {
    private Function0<Unit> exitCourseAction;
    private Function1<? super Boolean, Unit> mOnStageChanged;
    private Function1<? super Type, Unit> onPermissionOpenControl;

    public /* synthetic */ AllOnStageListenerBody(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AllOnStageListenerBody() {
    }

    public void dispatch(AllOnStageListenerBody allOnStageListenerBody) {
        Function1<? super Type, Unit> function1;
        Intrinsics.checkNotNullParameter(allOnStageListenerBody, "listener");
        if (allOnStageListenerBody instanceof ExitCourse) {
            Function0<Unit> function0 = this.exitCourseAction;
            if (function0 != null) {
                function0.invoke();
            }
        } else if (allOnStageListenerBody instanceof OnStageChanged) {
            Function1<? super Boolean, Unit> function12 = this.mOnStageChanged;
            if (function12 != null) {
                function12.invoke(Boolean.valueOf(((OnStageChanged) allOnStageListenerBody).isOnStage()));
            }
        } else if ((allOnStageListenerBody instanceof PermissionOpenControl) && (function1 = this.onPermissionOpenControl) != null) {
            function1.invoke(((PermissionOpenControl) allOnStageListenerBody).getType());
        }
    }

    public final void onExitCourse(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        this.exitCourseAction = function0;
    }

    public final void onStageChanged(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.mOnStageChanged = function1;
    }

    public final void onPermissionOpenControl(Function1<? super Type, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.onPermissionOpenControl = function1;
    }
}
