package com.wushuangtech.audiocore;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AudioFileDecoder implements Runnable {
    private static final String TAG = "AudioFileDecoder";
    private String mAudioMimeType;
    private boolean mFileOpened;
    private final Object mLock = new Object();
    private MediaCodec mMediaCodec;
    private MediaExtractor mMediaExtractor;
    private OnAudioFileEventCallBack mOnAudioFileEventCallBack;

    interface OnAudioFileEventCallBack {
    }

    public void run() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r0.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        r1 = r8.getInteger("sample-rate");
        r3 = r8.getInteger("channel-count");
        android.util.Log.d(TAG, "Audio file info : " + r1 + " * " + r1 + " | channel : " + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
        if (initAudioDecoder(r8) == false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0053, code lost:
        return -2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0055, code lost:
        r8 = r7.mLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        monitor-enter(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r7.mOnAudioFileEventCallBack = r9;
        r7.mMediaExtractor = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005c, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005d, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
        r0 = new android.media.MediaExtractor();
        r8 = getAudioFormatFromVideoFile(r0, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        if (r8 != null) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int openVideoFile(java.lang.String r8, com.wushuangtech.audiocore.AudioFileDecoder.OnAudioFileEventCallBack r9) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.mLock
            monitor-enter(r0)
            boolean r1 = r7.mFileOpened     // Catch:{ all -> 0x0061 }
            r2 = 0
            if (r1 == 0) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x0061 }
            return r2
        L_0x000a:
            monitor-exit(r0)     // Catch:{ all -> 0x0061 }
            android.media.MediaExtractor r0 = new android.media.MediaExtractor
            r0.<init>()
            android.media.MediaFormat r8 = r7.getAudioFormatFromVideoFile(r0, r8)
            if (r8 != 0) goto L_0x001b
            r0.release()
            r8 = -1
            return r8
        L_0x001b:
            java.lang.String r1 = "sample-rate"
            int r1 = r8.getInteger(r1)
            java.lang.String r3 = "channel-count"
            int r3 = r8.getInteger(r3)
            java.lang.String r4 = "AudioFileDecoder"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Audio file info : "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r6 = " * "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r1 = " | channel : "
            r5.append(r1)
            r5.append(r3)
            java.lang.String r1 = r5.toString()
            android.util.Log.d(r4, r1)
            boolean r8 = r7.initAudioDecoder(r8)
            if (r8 == 0) goto L_0x0055
            r8 = -2
            return r8
        L_0x0055:
            java.lang.Object r8 = r7.mLock
            monitor-enter(r8)
            r7.mOnAudioFileEventCallBack = r9     // Catch:{ all -> 0x005e }
            r7.mMediaExtractor = r0     // Catch:{ all -> 0x005e }
            monitor-exit(r8)     // Catch:{ all -> 0x005e }
            return r2
        L_0x005e:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x005e }
            throw r9
        L_0x0061:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0061 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.audiocore.AudioFileDecoder.openVideoFile(java.lang.String, com.wushuangtech.audiocore.AudioFileDecoder$OnAudioFileEventCallBack):int");
    }

    private MediaFormat getAudioFormatFromVideoFile(MediaExtractor mediaExtractor, String str) {
        try {
            mediaExtractor.setDataSource(new FileInputStream(new File(str)).getFD());
            int trackCount = mediaExtractor.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                String string = trackFormat.getString("mime");
                if (string != null && string.equals("audio/mp4a-latm")) {
                    mediaExtractor.selectTrack(i);
                    this.mAudioMimeType = string;
                    return trackFormat;
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean initAudioDecoder(MediaFormat mediaFormat) {
        try {
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(this.mAudioMimeType);
            createDecoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
            createDecoderByType.start();
            this.mMediaCodec = createDecoderByType;
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
