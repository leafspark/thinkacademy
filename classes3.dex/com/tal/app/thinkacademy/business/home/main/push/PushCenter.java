package com.tal.app.thinkacademy.business.home.main.push;

import android.os.Bundle;
import com.tal.app.thinkacademy.business.home.main.Tag;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/push/PushCenter;", "", "()V", "mCurrentPayloadList", "", "", "mMainAlive", "", "consume", "isMainAlive", "jump", "", "payload", "savePayloadMsg", "setMainAlive", "alive", "Companion", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PushCenter.kt */
public final class PushCenter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<PushCenter> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, PushCenter$Companion$instance$2.INSTANCE);
    private final List<String> mCurrentPayloadList;
    private boolean mMainAlive;

    public /* synthetic */ PushCenter(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final PushCenter get() {
        return Companion.get();
    }

    private PushCenter() {
        this.mCurrentPayloadList = new ArrayList();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/push/PushCenter$Companion;", "", "()V", "instance", "Lcom/tal/app/thinkacademy/business/home/main/push/PushCenter;", "getInstance", "()Lcom/tal/app/thinkacademy/business/home/main/push/PushCenter;", "instance$delegate", "Lkotlin/Lazy;", "get", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PushCenter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final PushCenter getInstance() {
            return (PushCenter) PushCenter.instance$delegate.getValue();
        }

        @JvmStatic
        public final PushCenter get() {
            return getInstance();
        }
    }

    public final void setMainAlive(boolean z) {
        this.mMainAlive = z;
    }

    public final boolean isMainAlive() {
        return this.mMainAlive;
    }

    public final void savePayloadMsg(String str) {
        Intrinsics.checkNotNullParameter(str, "payload");
        this.mCurrentPayloadList.add(str);
    }

    public final boolean consume() {
        String str = (String) CollectionsKt.removeFirstOrNull(this.mCurrentPayloadList);
        if (str == null) {
            return false;
        }
        XesLog.s(Tag.PUSH, new Object[]{Intrinsics.stringPlus("分发推送 payload:", str)});
        jump(str);
        return true;
    }

    private final void jump(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("router", str);
        XesRoute.getInstance().navigation("/app/notification_activity", bundle, 337641472);
    }
}
