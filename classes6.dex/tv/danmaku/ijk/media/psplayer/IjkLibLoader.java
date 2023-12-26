package tv.danmaku.ijk.media.psplayer;

public interface IjkLibLoader {
    void loadLibrary(String str) throws UnsatisfiedLinkError, SecurityException;
}
