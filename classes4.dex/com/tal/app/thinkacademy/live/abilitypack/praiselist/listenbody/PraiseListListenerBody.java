package com.tal.app.thinkacademy.live.abilitypack.praiselist.listenbody;

import android.graphics.Bitmap;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerBody;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0000H\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004J\u001a\u0010\r\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004R\u001e\u0010\u0003\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/praiselist/listenbody/PraiseListListenerBody;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerBody;", "()V", "onScreenshotResultBlock", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "", "onScreenshotSaveResultBlock", "", "dispatch", "listener", "onScreenshotResult", "block", "onScreenshotSaveResult", "ScreenshotResult", "ScreenshotSaveResult", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PraiseListListenerBody.kt */
public class PraiseListListenerBody extends ListenerBody<PraiseListListenerBody> {
    private Function1<? super Bitmap, Unit> onScreenshotResultBlock;
    private Function1<? super Boolean, Unit> onScreenshotSaveResultBlock;

    public void dispatch(PraiseListListenerBody praiseListListenerBody) {
        Function1<? super Boolean, Unit> function1;
        Intrinsics.checkNotNullParameter(praiseListListenerBody, "listener");
        if (praiseListListenerBody instanceof ScreenshotResult) {
            Function1<? super Bitmap, Unit> function12 = this.onScreenshotResultBlock;
            if (function12 != null) {
                function12.invoke(((ScreenshotResult) praiseListListenerBody).getBitmap());
            }
        } else if ((praiseListListenerBody instanceof ScreenshotSaveResult) && (function1 = this.onScreenshotSaveResultBlock) != null) {
            function1.invoke(Boolean.valueOf(((ScreenshotSaveResult) praiseListListenerBody).getSuccess()));
        }
    }

    public final void onScreenshotResult(Function1<? super Bitmap, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.onScreenshotResultBlock = function1;
    }

    public final void onScreenshotSaveResult(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.onScreenshotSaveResultBlock = function1;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/praiselist/listenbody/PraiseListListenerBody$ScreenshotResult;", "Lcom/tal/app/thinkacademy/live/abilitypack/praiselist/listenbody/PraiseListListenerBody;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PraiseListListenerBody.kt */
    public static final class ScreenshotResult extends PraiseListListenerBody {
        private final Bitmap bitmap;

        public static /* synthetic */ ScreenshotResult copy$default(ScreenshotResult screenshotResult, Bitmap bitmap2, int i, Object obj) {
            if ((i & 1) != 0) {
                bitmap2 = screenshotResult.bitmap;
            }
            return screenshotResult.copy(bitmap2);
        }

        public final Bitmap component1() {
            return this.bitmap;
        }

        public final ScreenshotResult copy(Bitmap bitmap2) {
            return new ScreenshotResult(bitmap2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ScreenshotResult) && Intrinsics.areEqual(this.bitmap, ((ScreenshotResult) obj).bitmap);
        }

        public int hashCode() {
            Bitmap bitmap2 = this.bitmap;
            if (bitmap2 == null) {
                return 0;
            }
            return bitmap2.hashCode();
        }

        public String toString() {
            return "ScreenshotResult(bitmap=" + this.bitmap + ')';
        }

        public ScreenshotResult(Bitmap bitmap2) {
            this.bitmap = bitmap2;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/praiselist/listenbody/PraiseListListenerBody$ScreenshotSaveResult;", "Lcom/tal/app/thinkacademy/live/abilitypack/praiselist/listenbody/PraiseListListenerBody;", "success", "", "(Z)V", "getSuccess", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PraiseListListenerBody.kt */
    public static final class ScreenshotSaveResult extends PraiseListListenerBody {
        private final boolean success;

        public static /* synthetic */ ScreenshotSaveResult copy$default(ScreenshotSaveResult screenshotSaveResult, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = screenshotSaveResult.success;
            }
            return screenshotSaveResult.copy(z);
        }

        public final boolean component1() {
            return this.success;
        }

        public final ScreenshotSaveResult copy(boolean z) {
            return new ScreenshotSaveResult(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ScreenshotSaveResult) && this.success == ((ScreenshotSaveResult) obj).success;
        }

        public int hashCode() {
            boolean z = this.success;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "ScreenshotSaveResult(success=" + this.success + ')';
        }

        public ScreenshotSaveResult(boolean z) {
            this.success = z;
        }

        public final boolean getSuccess() {
            return this.success;
        }
    }
}
