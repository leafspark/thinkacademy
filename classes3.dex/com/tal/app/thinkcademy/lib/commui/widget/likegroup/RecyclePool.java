package com.tal.app.thinkcademy.lib.commui.widget.likegroup;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007J\u0014\u0010\u000f\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0007R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/RecyclePool;", "", "maxCacheCount", "", "(I)V", "mProvider", "Lkotlin/Function0;", "Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/FlyAnim;", "mRecyclePool", "", "getMaxCacheCount", "()I", "destroy", "", "obtain", "provider", "recycle", "anim", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlyAnimGroup.kt */
final class RecyclePool {
    private Function0<FlyAnim> mProvider;
    private final List<FlyAnim> mRecyclePool = new ArrayList();
    private final int maxCacheCount;

    public RecyclePool(int i) {
        this.maxCacheCount = i;
    }

    public final int getMaxCacheCount() {
        return this.maxCacheCount;
    }

    public final FlyAnim obtain() {
        FlyAnim flyAnim = (FlyAnim) CollectionsKt.removeFirstOrNull(this.mRecyclePool);
        if (flyAnim != null) {
            return flyAnim;
        }
        Function0<FlyAnim> function0 = this.mProvider;
        if (function0 == null) {
            return null;
        }
        return function0.invoke();
    }

    public final void provider(Function0<FlyAnim> function0) {
        Intrinsics.checkNotNullParameter(function0, "provider");
        this.mProvider = function0;
    }

    public final void recycle(FlyAnim flyAnim) {
        Intrinsics.checkNotNullParameter(flyAnim, "anim");
        this.mRecyclePool.add(flyAnim);
        if (this.mRecyclePool.size() > this.maxCacheCount) {
            CollectionsKt.removeFirst(this.mRecyclePool);
        }
    }

    public final void destroy() {
        this.mRecyclePool.clear();
        this.mProvider = null;
    }
}
