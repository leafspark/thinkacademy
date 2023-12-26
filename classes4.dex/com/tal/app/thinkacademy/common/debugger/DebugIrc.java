package com.tal.app.thinkacademy.common.debugger;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/common/debugger/DebugIrc;", "", "mHandler", "Lcom/tal/app/thinkacademy/common/debugger/IrcDispatchHandler;", "(Lcom/tal/app/thinkacademy/common/debugger/IrcDispatchHandler;)V", "dispatchIrc", "", "msg", "", "ircKey", "ircMsg", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DebugIrc.kt */
public final class DebugIrc {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static DebugIrc mInstance;
    private final IrcDispatchHandler mHandler;

    @JvmStatic
    public static final void destroy() {
        Companion.destroy();
    }

    @JvmStatic
    public static final void init(IrcDispatchHandler ircDispatchHandler) {
        Companion.init(ircDispatchHandler);
    }

    public DebugIrc(IrcDispatchHandler ircDispatchHandler) {
        Intrinsics.checkNotNullParameter(ircDispatchHandler, "mHandler");
        this.mHandler = ircDispatchHandler;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/common/debugger/DebugIrc$Companion;", "", "()V", "mInstance", "Lcom/tal/app/thinkacademy/common/debugger/DebugIrc;", "destroy", "", "get", "init", "handler", "Lcom/tal/app/thinkacademy/common/debugger/IrcDispatchHandler;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DebugIrc.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void init(IrcDispatchHandler ircDispatchHandler) {
            Intrinsics.checkNotNullParameter(ircDispatchHandler, "handler");
        }

        private Companion() {
        }

        public final DebugIrc get() {
            return DebugIrc.mInstance;
        }

        @JvmStatic
        public final void destroy() {
            DebugIrc.mInstance = null;
        }
    }

    public final void dispatchIrc(String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
        XesLog.et("模拟Irc", "非Debug环境被触发");
    }

    public final void dispatchIrc(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "ircKey");
        Intrinsics.checkNotNullParameter(str2, "ircMsg");
        this.mHandler.dispatchIrcMessage(str, str2);
    }
}
