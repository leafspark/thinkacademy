package com.tal.app.thinkacademy.lib.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/MainHandler;", "", "()V", "handler", "Landroid/os/Handler;", "post", "", "runnable", "Ljava/lang/Runnable;", "postDelay", "delayMills", "", "sendAtFrontOfQueue", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MainHandler.kt */
public final class MainHandler {
    public static final MainHandler INSTANCE = new MainHandler();
    private static final Handler handler = new Handler(Looper.getMainLooper());

    private MainHandler() {
    }

    public final void post(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Handler handler2 = handler;
        if (!(handler2 instanceof Handler)) {
            handler2.post(runnable);
        } else {
            AsynchronousInstrumentation.handlerPost(handler2, runnable);
        }
    }

    public final void postDelay(long j, Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        handler.postDelayed(runnable, j);
    }

    public final void sendAtFrontOfQueue(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Handler handler2 = handler;
        handler2.sendMessageAtFrontOfQueue(Message.obtain(handler2, runnable));
    }
}
