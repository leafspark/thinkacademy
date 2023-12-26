package com.tal.app.thinkacademy.common.network;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/tal/app/thinkacademy/common/network/BaseUrlEx;", "", "()V", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseUrlEx.kt */
public class BaseUrlEx {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static ENVIRONMENTAL environment = ENVIRONMENTAL.TEST;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/common/network/BaseUrlEx$Companion;", "", "()V", "environment", "Lcom/tal/app/thinkacademy/common/network/ENVIRONMENTAL;", "getEnvironment", "()Lcom/tal/app/thinkacademy/common/network/ENVIRONMENTAL;", "setEnvironment", "(Lcom/tal/app/thinkacademy/common/network/ENVIRONMENTAL;)V", "updateEnv", "", "env", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BaseUrlEx.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ENVIRONMENTAL getEnvironment() {
            return BaseUrlEx.environment;
        }

        public final void setEnvironment(ENVIRONMENTAL environmental) {
            Intrinsics.checkNotNullParameter(environmental, "<set-?>");
            BaseUrlEx.environment = environmental;
        }

        public final void updateEnv(ENVIRONMENTAL environmental) {
            Intrinsics.checkNotNullParameter(environmental, "env");
            setEnvironment(environmental);
        }
    }
}
