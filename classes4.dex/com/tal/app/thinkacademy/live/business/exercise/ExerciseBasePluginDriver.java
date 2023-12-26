package com.tal.app.thinkacademy.live.business.exercise;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b&\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/exercise/ExerciseBasePluginDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "runnable", "Ljava/lang/Runnable;", "onDestroy", "", "removePlugin", "delayMillis", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExerciseBasePluginDriver.kt */
public abstract class ExerciseBasePluginDriver extends BaseLivePluginDriver {
    private Handler handler;
    private Runnable runnable;

    public ExerciseBasePluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
    }

    /* access modifiers changed from: protected */
    public final Handler getHandler() {
        return this.handler;
    }

    /* access modifiers changed from: protected */
    public final void setHandler(Handler handler2) {
        this.handler = handler2;
    }

    public final void removePlugin(long j) {
        if (this.handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        }
        if (this.runnable == null) {
            this.runnable = new ExerciseBasePluginDriver$$ExternalSyntheticLambda0(this);
        }
        Handler handler2 = this.handler;
        if (handler2 != null) {
            Runnable runnable2 = this.runnable;
            Intrinsics.checkNotNull(runnable2);
            handler2.postDelayed(runnable2, j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: removePlugin$lambda-0  reason: not valid java name */
    public static final void m226removePlugin$lambda0(ExerciseBasePluginDriver exerciseBasePluginDriver) {
        Intrinsics.checkNotNullParameter(exerciseBasePluginDriver, "this$0");
        exerciseBasePluginDriver.destroy();
    }

    public void onDestroy() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
        }
        this.runnable = null;
    }
}
