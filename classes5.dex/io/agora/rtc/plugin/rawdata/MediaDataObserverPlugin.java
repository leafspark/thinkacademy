package io.agora.rtc.plugin.rawdata;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.eaydu.omni.logger.Logger;
import io.agora.rtc.plugin.rawdata.MediaPreProcessing;
import io.flutter.embedding.android.KeyboardMap;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class MediaDataObserverPlugin implements MediaPreProcessing.InternalProgressCallback {
    private static final int AUDIO_DEFAULT_BUFFER_SIZE = 2048;
    private static final String TAG = "MediaDataObserverPlugin";
    private static final int VIDEO_DEFAULT_BUFFER_SIZE = 307200;
    private static MediaDataObserverPlugin myAgent;
    public final ByteBuffer PRE_ALLOC_BYTE_BUFFER_FOR_AFTER_AUDIO_MIXING = ByteBuffer.allocateDirect(2048);
    public final ByteBuffer PRE_ALLOC_BYTE_BUFFER_FOR_AUDIO_CAPTURING = ByteBuffer.allocateDirect(2048);
    public final ByteBuffer PRE_ALLOC_BYTE_BUFFER_FOR_AUDIO_PLAYING = ByteBuffer.allocateDirect(2048);
    private boolean beCaptureVideoShot = false;
    private boolean beRenderVideoShot = false;
    private String captureFilePath = null;
    private int forBufferOverflowExceptionDebugging = 0;
    private int forBufferUnderflowExceptionDebugging = 0;
    private final CopyOnWriteArrayList<MediaDataAudioObserver> mAudioObserverList = new CopyOnWriteArrayList<>();
    private final Object mBufferLock = new Object();
    private final ConcurrentHashMap<Integer, ByteBuffer> mDecodedAudioBufferList = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Integer, ByteBuffer> mDecodedBufferList = new ConcurrentHashMap<>();
    private final CopyOnWriteArrayList<MediaDataVideoObserver> mVideoObserverList = new CopyOnWriteArrayList<>();
    OnRenderVideoShot onRenderVideoShot;
    private String renderFilePath = null;
    private int renderVideoShotUid;

    public interface OnRenderVideoShot {
        void onRenderVideoShot(String str);
    }

    public static class VideoDataCallbackOptions {
        public static boolean NEED_JAVA_LOCAL_VIDEO_DATA = true;
        public static boolean NEED_JAVA_REMOTE_VIDEO_DATA = true;
    }

    private MediaDataObserverPlugin() {
    }

    public static MediaDataObserverPlugin the() {
        if (myAgent == null) {
            synchronized (MediaDataObserverPlugin.class) {
                if (myAgent == null) {
                    myAgent = new MediaDataObserverPlugin();
                }
            }
        }
        return myAgent;
    }

    public void addVideoObserver(MediaDataVideoObserver mediaDataVideoObserver) {
        this.mVideoObserverList.add(mediaDataVideoObserver);
    }

    public void removeVideoObserver(MediaDataVideoObserver mediaDataVideoObserver) {
        this.mVideoObserverList.remove(mediaDataVideoObserver);
    }

    public void addAudioObserver(MediaDataAudioObserver mediaDataAudioObserver) {
        this.mAudioObserverList.add(mediaDataAudioObserver);
    }

    public void removeAudioObserver(MediaDataAudioObserver mediaDataAudioObserver) {
        this.mAudioObserverList.remove(mediaDataAudioObserver);
    }

    public void saveCaptureVideoSnapshot(String str) {
        this.beCaptureVideoShot = true;
        this.captureFilePath = str;
    }

    public void saveRenderVideoSnapshot(String str, int i, OnRenderVideoShot onRenderVideoShot2) {
        this.onRenderVideoShot = onRenderVideoShot2;
        this.beRenderVideoShot = true;
        this.renderFilePath = str;
        this.renderVideoShotUid = i;
    }

    @Deprecated
    public void allocateBuffer(int i) {
        allocateBuffer(i, 0, 0);
    }

    public void allocateBuffer(int i, int i2, int i3) {
        synchronized (this.mBufferLock) {
            if (this.mDecodedBufferList.containsKey(Integer.valueOf(i))) {
                ByteBuffer byteBuffer = this.mDecodedBufferList.get(Integer.valueOf(i));
                if (byteBuffer.capacity() < ((i2 * i3) * 3) / 2) {
                    this.mDecodedBufferList.remove(Integer.valueOf(i));
                    Logger.w("MediaDataObserverPlugin setVideoBuffer buffer size and capacity does not match, need to create a new one " + (((long) i) & KeyboardMap.kValueMask) + " " + byteBuffer, new Object[0]);
                }
                MediaPreProcessing.setVideoBuffer(i, byteBuffer);
                this.mDecodedBufferList.put(Integer.valueOf(i), byteBuffer);
                System.gc();
                return;
            }
            int i4 = i2 * i3;
            if (i4 < VIDEO_DEFAULT_BUFFER_SIZE) {
                i4 = VIDEO_DEFAULT_BUFFER_SIZE;
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect((i4 * 3) / 2);
            MediaPreProcessing.setVideoBuffer(i, allocateDirect);
            this.mDecodedBufferList.put(Integer.valueOf(i), allocateDirect);
            if (this.mDecodedAudioBufferList.containsKey(Integer.valueOf(i))) {
                MediaPreProcessing.setAudioMixingBuffer(i, this.mDecodedAudioBufferList.get(Integer.valueOf(i)));
                System.gc();
                return;
            }
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(2048);
            MediaPreProcessing.setAudioMixingBuffer(i, allocateDirect2);
            this.mDecodedAudioBufferList.put(Integer.valueOf(i), allocateDirect2);
            System.gc();
        }
    }

    public void removeBuffer(int i) {
        synchronized (this.mBufferLock) {
            this.mDecodedAudioBufferList.remove(Integer.valueOf(i));
            this.mDecodedBufferList.remove(Integer.valueOf(i));
            MediaPreProcessing.setAudioMixingBuffer(i, (ByteBuffer) null);
            MediaPreProcessing.setVideoBuffer(i, (ByteBuffer) null);
        }
    }

    public void removeAllBuffers() {
        synchronized (this.mBufferLock) {
            Integer[] numArr = (Integer[]) this.mDecodedAudioBufferList.keySet().toArray(new Integer[this.mDecodedAudioBufferList.size()]);
            Integer[] numArr2 = (Integer[]) this.mDecodedBufferList.keySet().toArray(new Integer[this.mDecodedBufferList.size()]);
            this.mDecodedAudioBufferList.clear();
            this.mDecodedBufferList.clear();
            for (Integer intValue : numArr) {
                int intValue2 = intValue.intValue();
                MediaPreProcessing.setAudioMixingBuffer(intValue2, (ByteBuffer) null);
                MediaPreProcessing.setVideoBuffer(intValue2, (ByteBuffer) null);
            }
            for (Integer intValue3 : numArr2) {
                int intValue4 = intValue3.intValue();
                MediaPreProcessing.setAudioMixingBuffer(intValue4, (ByteBuffer) null);
                MediaPreProcessing.setVideoBuffer(intValue4, (ByteBuffer) null);
            }
        }
        clearPreAllocatedBuffers();
        System.gc();
    }

    public void onCaptureVideoFrame(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j) {
        int i9;
        ByteBuffer byteBuffer;
        int i10 = i4;
        if (VideoDataCallbackOptions.NEED_JAVA_LOCAL_VIDEO_DATA) {
            try {
                if (!this.mVideoObserverList.isEmpty() && (byteBuffer = this.mDecodedBufferList.get(0)) != null) {
                    byte[] bArr = new byte[i10];
                    byteBuffer.limit(i10);
                    byteBuffer.get(bArr);
                    byteBuffer.flip();
                    Iterator<MediaDataVideoObserver> it = this.mVideoObserverList.iterator();
                    while (it.hasNext()) {
                        it.next().onCaptureVideoFrame(bArr, i, i2, i3, i4, i5, i6, i7, i8, j);
                    }
                    byteBuffer.put(bArr);
                    byteBuffer.flip();
                    if (this.beCaptureVideoShot) {
                        this.beCaptureVideoShot = false;
                        i9 = 0;
                        try {
                            getVideoSnapshot(i2, i3, i8, i4, bArr, this.captureFilePath, i5, i6, i7);
                        } catch (Exception e) {
                            e = e;
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
                i9 = 0;
                Logger.w("AgoraEngine onCaptureVideoFrame Exception " + e.getMessage(), new Object[i9]);
            }
        }
    }

    public void onRenderVideoFrame(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j) {
        int i10;
        ByteBuffer byteBuffer;
        int i11;
        MediaDataObserverPlugin mediaDataObserverPlugin = this;
        String str2 = str;
        int i12 = i;
        int i13 = i3;
        int i14 = i4;
        int i15 = i5;
        int i16 = i6;
        long j2 = j;
        if (VideoDataCallbackOptions.NEED_JAVA_REMOTE_VIDEO_DATA) {
            try {
                if (!mediaDataObserverPlugin.mVideoObserverList.isEmpty() && (byteBuffer = mediaDataObserverPlugin.mDecodedBufferList.get(Integer.valueOf(i))) != null) {
                    byte[] bArr = new byte[i15];
                    byteBuffer.limit(i15);
                    String str3 = " limit ";
                    String str4 = " position ";
                    String str5 = " capacity ";
                    byte[] bArr2 = bArr;
                    if (i15 > byteBuffer.remaining()) {
                        int i17 = mediaDataObserverPlugin.forBufferUnderflowExceptionDebugging;
                        if (i17 == 0 || i17 % 4 == 0) {
                            if (i17 < 200) {
                                try {
                                    i11 = 0;
                                    try {
                                        Logger.w("MediaDataObserverPlugin ForDebug buffer underflow, for user " + (((long) i12) & KeyboardMap.kValueMask) + " " + str2 + " " + i15 + " " + i13 + " " + i14 + " " + i16 + " " + j2 + ", buffer status: remaining " + byteBuffer.remaining() + str5 + byteBuffer.capacity() + str4 + byteBuffer.position() + str3 + byteBuffer.limit(), new Object[0]);
                                    } catch (Exception e) {
                                        e = e;
                                        i10 = i11;
                                        Logger.w("AgoraEngine onRenderVideoFrame Exception " + e.getMessage(), new Object[i10]);
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                }
                            }
                            mediaDataObserverPlugin = this;
                        }
                        mediaDataObserverPlugin.forBufferUnderflowExceptionDebugging++;
                        return;
                    }
                    byte[] bArr3 = bArr2;
                    byteBuffer.get(bArr3);
                    byteBuffer.flip();
                    byte[] bArr4 = bArr3;
                    Iterator<MediaDataVideoObserver> it = mediaDataObserverPlugin.mVideoObserverList.iterator();
                    while (it.hasNext()) {
                        byte[] bArr5 = bArr4;
                        it.next().onRenderVideoFrame(i, bArr5, i2, i3, i4, i5, i6, i7, i8, i9, j);
                        bArr4 = bArr5;
                        str5 = str5;
                        str4 = str4;
                        str3 = str3;
                    }
                    String str6 = str5;
                    String str7 = str4;
                    String str8 = str3;
                    byte[] bArr6 = bArr4;
                    if (i15 > byteBuffer.remaining()) {
                        int i18 = mediaDataObserverPlugin.forBufferOverflowExceptionDebugging;
                        if ((i18 == 0 || i18 % 4 == 0) && i18 < 200) {
                            i11 = 0;
                            try {
                                Logger.w("MediaDataObserverPlugin ForDebug buffer overflow, for user " + (((long) i12) & KeyboardMap.kValueMask) + " " + str2 + " " + i15 + " " + i13 + " " + i14 + " " + i16 + " " + j2 + ", buffer status: remaining " + byteBuffer.remaining() + str6 + byteBuffer.capacity() + str7 + byteBuffer.position() + str8 + byteBuffer.limit(), new Object[0]);
                            } catch (Exception e3) {
                                e = e3;
                                i10 = i11;
                                Logger.w("AgoraEngine onRenderVideoFrame Exception " + e.getMessage(), new Object[i10]);
                            }
                        }
                        mediaDataObserverPlugin.forBufferOverflowExceptionDebugging++;
                        return;
                    }
                    byte[] bArr7 = bArr6;
                    byteBuffer.put(bArr7);
                    byteBuffer.flip();
                    if (mediaDataObserverPlugin.beRenderVideoShot && i12 == mediaDataObserverPlugin.renderVideoShotUid) {
                        try {
                            mediaDataObserverPlugin.beRenderVideoShot = false;
                            i10 = 0;
                            try {
                                getVideoSnapshot(i3, i4, i9, i5, bArr7, mediaDataObserverPlugin.renderFilePath, i6, i7, i8);
                                OnRenderVideoShot onRenderVideoShot2 = mediaDataObserverPlugin.onRenderVideoShot;
                                if (onRenderVideoShot2 != null) {
                                    onRenderVideoShot2.onRenderVideoShot(mediaDataObserverPlugin.renderFilePath);
                                }
                            } catch (Exception e4) {
                                e = e4;
                                Logger.w("AgoraEngine onRenderVideoFrame Exception " + e.getMessage(), new Object[i10]);
                            }
                        } catch (Exception e5) {
                            e = e5;
                            i10 = 0;
                            Logger.w("AgoraEngine onRenderVideoFrame Exception " + e.getMessage(), new Object[i10]);
                        }
                    }
                }
            } catch (Exception e6) {
                e = e6;
                i10 = 0;
                Logger.w("AgoraEngine onRenderVideoFrame Exception " + e.getMessage(), new Object[i10]);
            }
        }
    }

    public void onRecordAudioFrame(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        int i7 = i6;
        if (!this.mAudioObserverList.isEmpty()) {
            byte[] bArr = new byte[i7];
            this.PRE_ALLOC_BYTE_BUFFER_FOR_AUDIO_CAPTURING.limit(i7);
            this.PRE_ALLOC_BYTE_BUFFER_FOR_AUDIO_CAPTURING.get(bArr);
            this.PRE_ALLOC_BYTE_BUFFER_FOR_AUDIO_CAPTURING.flip();
            Iterator<MediaDataAudioObserver> it = this.mAudioObserverList.iterator();
            while (it.hasNext()) {
                it.next().onRecordAudioFrame(bArr, i, i2, i3, i4, i5, j, i6);
            }
            this.PRE_ALLOC_BYTE_BUFFER_FOR_AUDIO_CAPTURING.put(bArr);
            this.PRE_ALLOC_BYTE_BUFFER_FOR_AUDIO_CAPTURING.flip();
        }
    }

    public void onPlaybackAudioFrame(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        int i7 = i6;
        if (!this.mAudioObserverList.isEmpty()) {
            byte[] bArr = new byte[i7];
            this.PRE_ALLOC_BYTE_BUFFER_FOR_AUDIO_PLAYING.limit(i7);
            this.PRE_ALLOC_BYTE_BUFFER_FOR_AUDIO_PLAYING.get(bArr);
            this.PRE_ALLOC_BYTE_BUFFER_FOR_AUDIO_PLAYING.flip();
            Iterator<MediaDataAudioObserver> it = this.mAudioObserverList.iterator();
            while (it.hasNext()) {
                it.next().onPlaybackAudioFrame(bArr, i, i2, i3, i4, i5, j, i6);
            }
            this.PRE_ALLOC_BYTE_BUFFER_FOR_AUDIO_PLAYING.put(bArr);
            this.PRE_ALLOC_BYTE_BUFFER_FOR_AUDIO_PLAYING.flip();
        }
    }

    public void onPlaybackAudioFrameBeforeMixing(int i, int i2, int i3, int i4, int i5, int i6, long j, int i7) {
        ByteBuffer byteBuffer;
        int i8 = i7;
        if (!this.mAudioObserverList.isEmpty() && (byteBuffer = this.mDecodedAudioBufferList.get(Integer.valueOf(i))) != null) {
            byte[] bArr = new byte[i8];
            byteBuffer.limit(i8);
            byteBuffer.get(bArr);
            byteBuffer.flip();
            Iterator<MediaDataAudioObserver> it = this.mAudioObserverList.iterator();
            while (it.hasNext()) {
                it.next().onPlaybackAudioFrameBeforeMixing(i, bArr, i2, i3, i4, i5, i6, j, i7);
            }
            byteBuffer.put(bArr);
            byteBuffer.flip();
        }
    }

    public void onMixedAudioFrame(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        int i7 = i6;
        if (!this.mAudioObserverList.isEmpty()) {
            byte[] bArr = new byte[i7];
            this.PRE_ALLOC_BYTE_BUFFER_FOR_AFTER_AUDIO_MIXING.limit(i7);
            this.PRE_ALLOC_BYTE_BUFFER_FOR_AFTER_AUDIO_MIXING.get(bArr);
            this.PRE_ALLOC_BYTE_BUFFER_FOR_AFTER_AUDIO_MIXING.flip();
            Iterator<MediaDataAudioObserver> it = this.mAudioObserverList.iterator();
            while (it.hasNext()) {
                it.next().onMixedAudioFrame(bArr, i, i2, i3, i4, i5, j, i6);
            }
            this.PRE_ALLOC_BYTE_BUFFER_FOR_AFTER_AUDIO_MIXING.put(bArr);
            this.PRE_ALLOC_BYTE_BUFFER_FOR_AFTER_AUDIO_MIXING.flip();
        }
    }

    public void onNeedToReconfigVideoBuffer(int i, int i2, int i3) {
        removeBuffer(i);
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        allocateBuffer(i, i2, i3);
    }

    private void getVideoSnapshot(int i, int i2, int i3, int i4, byte[] bArr, String str, int i5, int i6, int i7) {
        File file = new File(str);
        byte[] bArr2 = new byte[i4];
        swapYU12toYUV420SemiPlanar(bArr, bArr2, i, i2, i5, i6, i7);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        YuvImage yuvImage = new YuvImage(bArr2, 17, i, i2, new int[]{i5, i5});
        yuvImage.compressToJpeg(new Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), 100, byteArrayOutputStream);
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i3);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap decodeByteArray = BitmapFactoryInstrumentation.decodeByteArray(byteArray, 0, byteArray.length);
        Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
        }
        createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        createBitmap.recycle();
        decodeByteArray.recycle();
        try {
            fileOutputStream.close();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    private void swapYU12toYUV420SemiPlanar(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5) {
        int i6 = i3 * i2;
        System.arraycopy(bArr, 0, bArr2, 0, i6);
        int i7 = i6 / 4;
        int i8 = i6 + i7;
        for (int i9 = 0; i9 < i7; i9++) {
            int i10 = (i9 * 2) + i6;
            bArr2[i10 + 0] = bArr[i8 + i9];
            bArr2[i10 + 1] = bArr[i6 + i9];
        }
    }

    private void clearPreAllocatedBuffers() {
        this.PRE_ALLOC_BYTE_BUFFER_FOR_AUDIO_CAPTURING.clear();
        this.PRE_ALLOC_BYTE_BUFFER_FOR_AUDIO_PLAYING.clear();
        this.PRE_ALLOC_BYTE_BUFFER_FOR_AFTER_AUDIO_MIXING.clear();
    }
}
