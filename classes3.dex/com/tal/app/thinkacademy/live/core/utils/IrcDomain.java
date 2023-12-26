package com.tal.app.thinkacademy.live.core.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/utils/IrcDomain;", "Lcom/tal/app/thinkacademy/live/core/utils/Domain;", "code", "", "msg", "", "(ILjava/lang/String;)V", "Companion", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveTrack.kt */
public final class IrcDomain extends Domain {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final IrcDomain IrcDisConnected = new IrcDomain(1005, "服务器断开连接");
    public static final IrcDomain IrcFailed = new IrcDomain(1004, "服务器连接失败");
    public static final IrcDomain IrcOut = new IrcDomain(1001, "被踢出房间");
    public static final IrcDomain IrcUnKnow = new IrcDomain(1002, "未知网络");
    public static final IrcDomain IrcUnavailable = new IrcDomain(1003, "网络不可用");

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/utils/IrcDomain$Companion;", "", "()V", "IrcDisConnected", "Lcom/tal/app/thinkacademy/live/core/utils/IrcDomain;", "IrcFailed", "IrcOut", "IrcUnKnow", "IrcUnavailable", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LiveTrack.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IrcDomain(int i, String str) {
        super(DomainType.Irc, i, str, (String) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "msg");
    }
}
