package tv.danmaku.ijk.media.psplayer;

public interface OnDecodeStuckListener {
    void onDecodeStuckEnd(PSMediaPlayer pSMediaPlayer);

    void onDecodeStuckStart(PSMediaPlayer pSMediaPlayer);
}
