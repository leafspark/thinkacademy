package com.tal.app.thinkacademy.live.business.allonstage;

import com.tal.app.thinkacademy.live.abilitypack.allonstage.AllOnStageViewModel;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.Type;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.listenbody.AllOnStageListenerBody;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/listenbody/AllOnStageListenerBody;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStagePluginDriver.kt */
final class AllOnStagePluginDriver$observeListener$1 extends Lambda implements Function1<AllOnStageListenerBody, Unit> {
    final /* synthetic */ AllOnStagePluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AllOnStagePluginDriver$observeListener$1(AllOnStagePluginDriver allOnStagePluginDriver) {
        super(1);
        this.this$0 = allOnStagePluginDriver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AllOnStageListenerBody) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(AllOnStageListenerBody allOnStageListenerBody) {
        Intrinsics.checkNotNullParameter(allOnStageListenerBody, "$this$observeListener");
        final AllOnStagePluginDriver allOnStagePluginDriver = this.this$0;
        allOnStageListenerBody.onExitCourse(new Function0<Unit>() {
            public final void invoke() {
                AllOnStageViewModel access$getMViewModel$p = allOnStagePluginDriver.mViewModel;
                if (access$getMViewModel$p != null) {
                    access$getMViewModel$p.exitCourse();
                }
            }
        });
        final AllOnStagePluginDriver allOnStagePluginDriver2 = this.this$0;
        allOnStageListenerBody.onPermissionOpenControl(new Function1<Type, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Type) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Type type) {
                Intrinsics.checkNotNullParameter(type, "it");
                BaseAllOnStagePluginView access$getMPluginView$p = allOnStagePluginDriver2.mPluginView;
                if (access$getMPluginView$p != null) {
                    access$getMPluginView$p.showOpenPermissionControl(type);
                }
            }
        });
    }
}
