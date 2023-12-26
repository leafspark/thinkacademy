package com.wushuangtech.expansion.api;

import android.media.MediaPlayer;
import java.io.IOException;

public class MediaPlayerHelper {
    /* access modifiers changed from: private */
    public static MediaPlayer mMediaPlayer;

    public static void playSound(String str) {
        MediaPlayer mediaPlayer = mMediaPlayer;
        if (mediaPlayer == null) {
            MediaPlayer mediaPlayer2 = new MediaPlayer();
            mMediaPlayer = mediaPlayer2;
            mediaPlayer2.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    MediaPlayerHelper.mMediaPlayer.reset();
                    return false;
                }
            });
        } else {
            mediaPlayer.reset();
        }
        try {
            mMediaPlayer.setAudioStreamType(3);
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mediaPlayer) {
                }
            });
            mMediaPlayer.setDataSource(str);
            mMediaPlayer.prepare();
            mMediaPlayer.start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e2) {
            e2.printStackTrace();
        } catch (IllegalStateException e3) {
            e3.printStackTrace();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    public static void stop() {
        MediaPlayer mediaPlayer = mMediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
            mMediaPlayer.reset();
        }
    }

    public static void realese() {
        MediaPlayer mediaPlayer = mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
