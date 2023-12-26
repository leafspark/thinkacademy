package com.tal.app.thinkacademy.lib.util;

import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.lib.shareprefrence.SharePrefrenceCache;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/lib/util/SpUtils;", "", "()V", "mSpEngine", "Lcom/tal/app/thinkacademy/lib/shareprefrence/SharePrefrenceCache;", "engine", "Companion", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpUtils.kt */
public final class SpUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<SpUtils> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, SpUtils$Companion$instance$2.INSTANCE);
    private final SharePrefrenceCache mSpEngine;

    public /* synthetic */ SpUtils(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final SpUtils get() {
        return Companion.get();
    }

    private SpUtils() {
        this.mSpEngine = new SharePrefrenceCache(ShareDataManager.SPNAME_NOT_CLEAR);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/lib/util/SpUtils$Companion;", "", "()V", "instance", "Lcom/tal/app/thinkacademy/lib/util/SpUtils;", "getInstance", "()Lcom/tal/app/thinkacademy/lib/util/SpUtils;", "instance$delegate", "Lkotlin/Lazy;", "get", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SpUtils.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final SpUtils getInstance() {
            return (SpUtils) SpUtils.instance$delegate.getValue();
        }

        @JvmStatic
        public final SpUtils get() {
            return getInstance();
        }
    }

    public final SharePrefrenceCache engine() {
        return this.mSpEngine;
    }
}
