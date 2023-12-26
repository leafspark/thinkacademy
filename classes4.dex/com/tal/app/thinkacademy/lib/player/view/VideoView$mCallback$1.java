package com.tal.app.thinkacademy.lib.player.view;

import android.view.SurfaceHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/tal/app/thinkacademy/lib/player/view/VideoView$mCallback$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoView.kt */
public final class VideoView$mCallback$1 implements SurfaceHolder.Callback {
    final /* synthetic */ VideoView this$0;

    VideoView$mCallback$1(VideoView videoView) {
        this.this$0 = videoView;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(surfaceHolder, "holder");
        surfaceHolder.setKeepScreenOn(true);
        SurfaceCallback access$getMListener$p = this.this$0.mListener;
        if (access$getMListener$p != null) {
            access$getMListener$p.onSurfaceChanged(surfaceHolder, i, i2, i3);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Intrinsics.checkNotNullParameter(surfaceHolder, "holder");
        this.this$0.mSurfaceHolder = surfaceHolder;
        SurfaceCallback access$getMListener$p = this.this$0.mListener;
        if (access$getMListener$p != null) {
            access$getMListener$p.onSurfaceCreated(surfaceHolder);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Intrinsics.checkNotNullParameter(surfaceHolder, "holder");
        SurfaceCallback access$getMListener$p = this.this$0.mListener;
        if (access$getMListener$p != null) {
            access$getMListener$p.onSurfaceDestroyed(surfaceHolder);
        }
    }
}
