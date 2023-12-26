package com.tal.app.thinkacademy.live.core.utils;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/utils/ServerDomain;", "Lcom/tal/app/thinkacademy/live/core/utils/Domain;", "code", "", "msg", "", "path", "(ILjava/lang/String;Ljava/lang/String;)V", "Companion", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveTrack.kt */
public final class ServerDomain extends Domain {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final ServerDomain NOT_FOUND = new ServerDomain(404, "文件找不到", "");

    @JvmStatic
    public static final ServerDomain find(int i, String str) {
        return Companion.find(i, str);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/utils/ServerDomain$Companion;", "", "()V", "NOT_FOUND", "Lcom/tal/app/thinkacademy/live/core/utils/ServerDomain;", "find", "code", "", "path", "", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LiveTrack.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ServerDomain find(int i, String str) {
            ServerDomain serverDomain;
            Intrinsics.checkNotNullParameter(str, "path");
            if (i == 404) {
                serverDomain = ServerDomain.NOT_FOUND;
            } else {
                serverDomain = new ServerDomain(i, "未知", str);
            }
            serverDomain.setPath(str);
            return serverDomain;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ServerDomain(int i, String str, String str2) {
        super(DomainType.LocalServer, i, str, str2);
        Intrinsics.checkNotNullParameter(str, "msg");
        Intrinsics.checkNotNullParameter(str2, "path");
    }
}
