package tv.danmaku.ijk.media.psplayer;

import android.view.Surface;
import android.view.SurfaceHolder;

public interface IMediaPlayer {
    public static final int PSBuffering = 4;
    public static final int PSChannelNotExist = 7;
    public static final int PSCompleted = 5;
    public static final int PSDispatchFailed = -102;
    public static final int PSDispatchNoValidPlayline = -105;
    public static final int PSDispatchServerConnFailed = -106;
    public static final int PSDispatchServerError = -107;
    public static final int PSError = -1;
    public static final int PSIdle = 0;
    public static final int PSLoginError = -105;
    public static final int PSPaused = 3;
    public static final int PSPlayerError = -100;
    public static final int PSPreparing = 1;
    public static final int PSServer403 = -103;
    public static final int PSStarted = 2;
    public static final int PSTring = 6;

    void pause() throws IllegalStateException;

    void seekTo(long j) throws IllegalStateException;

    void setDisplay(SurfaceHolder surfaceHolder);

    void setScreenOnWhilePlaying(boolean z);

    void setSurface(Surface surface);

    void setVolume(float f, float f2);

    void start() throws IllegalStateException;

    void stop() throws IllegalStateException;
}
