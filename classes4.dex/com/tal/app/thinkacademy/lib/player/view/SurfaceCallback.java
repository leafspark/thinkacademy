package com.tal.app.thinkacademy.lib.player.view;

import android.view.SurfaceHolder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/view/SurfaceCallback;", "", "onSurfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "onSurfaceCreated", "onSurfaceDestroyed", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SurfaceCallback.kt */
public interface SurfaceCallback {
    void onSurfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3);

    void onSurfaceCreated(SurfaceHolder surfaceHolder);

    void onSurfaceDestroyed(SurfaceHolder surfaceHolder);
}
