package tv.danmaku.ijk.media.psplayer;

public abstract class AbstractMediaPlayer implements IMediaPlayer {
    /* access modifiers changed from: protected */
    public final void notifyOnCompletion() {
    }

    /* access modifiers changed from: protected */
    public final boolean notifyOnError(int i, int i2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean notifyOnInfo(int i, int i2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void notifyOnPrepared() {
    }

    /* access modifiers changed from: protected */
    public final void notifyOnVideoSizeChanged(int i, int i2, int i3, int i4) {
    }

    public void resetListeners() {
    }
}
