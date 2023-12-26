package com.tal.app.thinkcademy.lib.commui.widget.likegroup;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J'\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00072\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190\n\"\u00020\u0019¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0014J\n\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001d\u001a\u00020\u0019H\u0002J\u0006\u0010\u001e\u001a\u00020\u0014J(\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J\u0019\u0010$\u001a\u00020\u00142\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010&R\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/FlyAnimGroup;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mElementArray", "", "[Ljava/lang/Integer;", "mFlyDistance", "mFlyList", "", "Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/FlyAnim;", "mSwingRange", "mViewRecyclePool", "Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/RecyclePool;", "addFlyAnim", "", "animView", "addFlyViews", "count", "urls", "", "(I[Ljava/lang/String;)V", "clearAll", "createFlyAnim", "url", "destroy", "onSizeChanged", "w", "h", "oldw", "oldh", "setFlyElements", "array", "([Ljava/lang/Integer;)V", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlyAnimGroup.kt */
public final class FlyAnimGroup extends FrameLayout {
    private Integer[] mElementArray;
    private int mFlyDistance;
    /* access modifiers changed from: private */
    public final List<FlyAnim> mFlyList;
    private int mSwingRange;
    /* access modifiers changed from: private */
    public final RecyclePool mViewRecyclePool;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FlyAnimGroup(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FlyAnimGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlyAnimGroup(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlyAnimGroup(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        RecyclePool recyclePool = new RecyclePool(20);
        this.mViewRecyclePool = recyclePool;
        this.mFlyList = new ArrayList();
        recyclePool.provider(new Function0<FlyAnim>() {
            public final FlyAnim invoke() {
                return new FlyAnim(new ImageView(context));
            }
        });
    }

    public final void setFlyElements(Integer[] numArr) {
        Intrinsics.checkNotNullParameter(numArr, "array");
        this.mElementArray = numArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void addFlyViews(int r9, java.lang.String... r10) {
        /*
            r8 = this;
            java.lang.String r0 = "urls"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            android.animation.AnimatorSet r0 = new android.animation.AnimatorSet
            r0.<init>()
            r1 = 0
            r2 = r1
        L_0x000c:
            if (r2 >= r9) goto L_0x004d
            int r3 = r10.length
            r4 = 0
            if (r3 <= r2) goto L_0x002f
            r3 = r10[r2]
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x001e
            r3 = 1
            goto L_0x001f
        L_0x001e:
            r3 = r1
        L_0x001f:
            if (r3 == 0) goto L_0x002f
            r3 = r10[r2]
            com.tal.app.thinkcademy.lib.commui.widget.likegroup.FlyAnim r3 = r8.createFlyAnim(r3)
            if (r3 != 0) goto L_0x002a
            goto L_0x003a
        L_0x002a:
            android.animation.ValueAnimator r4 = r3.createAnim()
            goto L_0x003a
        L_0x002f:
            com.tal.app.thinkcademy.lib.commui.widget.likegroup.FlyAnim r3 = r8.createFlyAnim()
            if (r3 != 0) goto L_0x0036
            goto L_0x003a
        L_0x0036:
            android.animation.ValueAnimator r4 = r3.createAnim()
        L_0x003a:
            if (r4 != 0) goto L_0x003d
            goto L_0x004a
        L_0x003d:
            android.animation.Animator r4 = (android.animation.Animator) r4
            android.animation.AnimatorSet$Builder r3 = r0.play(r4)
            r4 = 200(0xc8, double:9.9E-322)
            long r6 = (long) r2
            long r6 = r6 * r4
            r3.after(r6)
        L_0x004a:
            int r2 = r2 + 1
            goto L_0x000c
        L_0x004d:
            r0.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkcademy.lib.commui.widget.likegroup.FlyAnimGroup.addFlyViews(int, java.lang.String[]):void");
    }

    private final FlyAnim createFlyAnim() {
        FlyAnim obtain;
        Integer[] numArr = this.mElementArray;
        if (numArr == null || (obtain = this.mViewRecyclePool.obtain()) == null) {
            return null;
        }
        obtain.setImageResource(numArr[RangesKt.random(ArraysKt.getIndices((T[]) numArr), (Random) Random.Default)].intValue());
        addFlyAnim(obtain);
        return obtain;
    }

    private final FlyAnim createFlyAnim(String str) {
        FlyAnim obtain = this.mViewRecyclePool.obtain();
        if (obtain == null) {
            return null;
        }
        obtain.loadCircleImage(str);
        addFlyAnim(obtain);
        return obtain;
    }

    private final void addFlyAnim(FlyAnim flyAnim) {
        this.mFlyList.add(flyAnim);
        flyAnim.onAnimEnd(new FlyAnimGroup$addFlyAnim$1(this, flyAnim));
        flyAnim.setSwingRange(this.mSwingRange);
        flyAnim.setFlyDistance(this.mFlyDistance);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int access$dp2px = FlyAnimGroupKt.dp2px(context, 36.0f);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        addView(flyAnim.view(), new FrameLayout.LayoutParams(access$dp2px, FlyAnimGroupKt.dp2px(context2, 36.0f)));
    }

    public final void clearAll() {
        XesLog.it("FlyAnimGroup", new Object[]{"clear all"});
        removeAllViews();
        for (FlyAnim flyAnim : this.mFlyList) {
            flyAnim.cancel();
            this.mViewRecyclePool.recycle(flyAnim);
        }
        this.mFlyList.clear();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mSwingRange = i;
        this.mFlyDistance = i2;
    }

    public final void destroy() {
        removeAllViews();
        for (FlyAnim cancel : this.mFlyList) {
            cancel.cancel();
        }
        this.mFlyList.clear();
        this.mViewRecyclePool.destroy();
    }
}
