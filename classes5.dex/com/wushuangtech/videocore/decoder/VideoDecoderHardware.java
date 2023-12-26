package com.wushuangtech.videocore.decoder;

import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import com.wushuangtech.library.video.bean.VideoFrame;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.videocore.VideoDecoder;
import com.wushuangtech.videocore.bean.VideoDecoderHardwareBean;
import java.nio.ByteBuffer;

public class VideoDecoderHardware {
    private static final String MIME_TYPE = "video/avc";
    private final String TAG;
    private byte[] mDecodedDatas;
    private MediaCodec mMediaCodec;
    private final boolean mSurfaceRender = false;

    public VideoDecoderHardware(String str) {
        this.TAG = str;
    }

    public VideoDecoderHardwareBean buildHardwareDecoderInfo(String str) {
        VideoDecoderHardwareBean videoDecoderHardwareBean = new VideoDecoderHardwareBean();
        videoDecoderHardwareBean.videoDecoderAddress = Integer.toHexString(hashCode());
        MediaCodec mediaCodec = this.mMediaCodec;
        videoDecoderHardwareBean.mediaCodecAddress = mediaCodec == null ? "null" : Integer.toHexString(mediaCodec.hashCode());
        videoDecoderHardwareBean.deviceId = str;
        videoDecoderHardwareBean.createTime = System.currentTimeMillis();
        return videoDecoderHardwareBean;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006e, code lost:
        if (r5 == null) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008f, code lost:
        if (r5 == null) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0091, code lost:
        r5.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0094, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean openHardwareDecoder(android.view.Surface r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 0
            android.media.MediaCodec r0 = r3.mMediaCodec     // Catch:{ IllegalStateException -> 0x0071, Exception -> 0x0050 }
            java.lang.String r1 = "video/avc"
            if (r0 != 0) goto L_0x000d
            android.media.MediaCodec r0 = android.media.MediaCodec.createDecoderByType(r1)     // Catch:{ IllegalStateException -> 0x0071, Exception -> 0x0050 }
            r3.mMediaCodec = r0     // Catch:{ IllegalStateException -> 0x0071, Exception -> 0x0050 }
        L_0x000d:
            android.media.MediaFormat r0 = android.media.MediaFormat.createVideoFormat(r1, r5, r6)     // Catch:{ IllegalStateException -> 0x0071, Exception -> 0x0050 }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ IllegalStateException -> 0x0071, Exception -> 0x0050 }
            r2 = 21
            if (r1 < r2) goto L_0x001f
            java.lang.String r1 = "color-format"
            r2 = 2135033992(0x7f420888, float:2.5791453E38)
            r0.setInteger(r1, r2)     // Catch:{ IllegalStateException -> 0x0071, Exception -> 0x0050 }
        L_0x001f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0071, Exception -> 0x0050 }
            r1.<init>()     // Catch:{ IllegalStateException -> 0x0071, Exception -> 0x0050 }
            java.lang.String r2 = "Open hardware decoder : "
            r1.append(r2)     // Catch:{ IllegalStateException -> 0x0071, Exception -> 0x0050 }
            r1.append(r5)     // Catch:{ IllegalStateException -> 0x0071, Exception -> 0x0050 }
            java.lang.String r5 = " | "
            r1.append(r5)     // Catch:{ IllegalStateException -> 0x0071, Exception -> 0x0050 }
            r1.append(r6)     // Catch:{ IllegalStateException -> 0x0071, Exception -> 0x0050 }
            java.lang.String r5 = r1.toString()     // Catch:{ IllegalStateException -> 0x0071, Exception -> 0x0050 }
            r3.logI(r5)     // Catch:{ IllegalStateException -> 0x0071, Exception -> 0x0050 }
            android.media.MediaCodec r5 = r3.mMediaCodec     // Catch:{ IllegalStateException -> 0x0071, Exception -> 0x0050 }
            r6 = 0
            r5.configure(r0, r6, r6, r4)     // Catch:{ IllegalStateException -> 0x0071, Exception -> 0x0050 }
            android.media.MediaCodec r5 = r3.mMediaCodec     // Catch:{ IllegalStateException -> 0x0071, Exception -> 0x0050 }
            r6 = 2
            r5.setVideoScalingMode(r6)     // Catch:{ IllegalStateException -> 0x0071, Exception -> 0x0050 }
            android.media.MediaCodec r5 = r3.mMediaCodec     // Catch:{ IllegalStateException -> 0x0071, Exception -> 0x0050 }
            r5.start()     // Catch:{ IllegalStateException -> 0x0071, Exception -> 0x0050 }
            r4 = 1
            return r4
        L_0x004e:
            r4 = move-exception
            goto L_0x0095
        L_0x0050:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x004e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r6.<init>()     // Catch:{ all -> 0x004e }
            java.lang.String r0 = "open hardware decoder Exception : "
            r6.append(r0)     // Catch:{ all -> 0x004e }
            java.lang.String r5 = r5.getLocalizedMessage()     // Catch:{ all -> 0x004e }
            r6.append(r5)     // Catch:{ all -> 0x004e }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x004e }
            r3.logE(r5)     // Catch:{ all -> 0x004e }
            android.media.MediaCodec r5 = r3.mMediaCodec
            if (r5 == 0) goto L_0x0094
            goto L_0x0091
        L_0x0071:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x004e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r6.<init>()     // Catch:{ all -> 0x004e }
            java.lang.String r0 = "open hardware decoder IllegalStateException : "
            r6.append(r0)     // Catch:{ all -> 0x004e }
            java.lang.String r5 = r5.getLocalizedMessage()     // Catch:{ all -> 0x004e }
            r6.append(r5)     // Catch:{ all -> 0x004e }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x004e }
            r3.logE(r5)     // Catch:{ all -> 0x004e }
            android.media.MediaCodec r5 = r3.mMediaCodec
            if (r5 == 0) goto L_0x0094
        L_0x0091:
            r5.release()
        L_0x0094:
            return r4
        L_0x0095:
            android.media.MediaCodec r5 = r3.mMediaCodec
            if (r5 == 0) goto L_0x009c
            r5.release()
        L_0x009c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.videocore.decoder.VideoDecoderHardware.openHardwareDecoder(android.view.Surface, int, int):boolean");
    }

    public void closeHardwareDecoder() {
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mMediaCodec.release();
            this.mMediaCodec = null;
        }
    }

    public boolean decodingFrame(VideoFrame videoFrame, VideoDecoder videoDecoder) {
        boolean z;
        if (this.mMediaCodec == null) {
            return true;
        }
        if (!dequeueInputData(videoFrame.data, videoFrame.timeStamp * 1000)) {
            return false;
        }
        try {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, 0);
            if (dequeueOutputBuffer == -2) {
                try {
                    MediaFormat outputFormat = this.mMediaCodec.getOutputFormat();
                    int integer = outputFormat.getInteger("width");
                    int integer2 = outputFormat.getInteger("height");
                    logI("MediaCode format changed! " + integer + " | " + integer2);
                } catch (Exception unused) {
                }
            } else if (dequeueOutputBuffer == -3) {
                logI("MediaCode buffer changed!");
            }
            while (dequeueOutputBuffer >= 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 21) {
                        z = handleOutputDataOnLollipop(videoDecoder, bufferInfo, dequeueOutputBuffer);
                    } else {
                        z = handleOutputData(videoDecoder, bufferInfo, dequeueOutputBuffer);
                    }
                    if (!z) {
                        return false;
                    }
                    this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    try {
                        bufferInfo = new MediaCodec.BufferInfo();
                        dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, 0);
                    } catch (Exception e) {
                        logE("decodingFrame -> dequeueOutputBuffer exception! " + e.getLocalizedMessage());
                        return false;
                    }
                } catch (Exception e2) {
                    logE("Release output buffer exception! " + e2.getLocalizedMessage());
                    return false;
                }
            }
            videoDecoder.onVideoFrameDecoded();
            return true;
        } catch (Exception e3) {
            logE("Dequeue output buffer exception! " + e3.getLocalizedMessage());
            return false;
        }
    }

    private boolean dequeueInputData(byte[] bArr, long j) {
        try {
            int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(50000);
            if (dequeueInputBuffer < 0) {
                return true;
            }
            try {
                ByteBuffer byteBuffer = this.mMediaCodec.getInputBuffers()[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(bArr, 0, bArr.length);
                this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j, 0);
                return true;
            } catch (Exception e) {
                logE("Queue input buffer exception! " + e.getLocalizedMessage());
                return false;
            }
        } catch (Exception e2) {
            logE("Dequeue input buffer exception: " + e2.getLocalizedMessage());
            return false;
        }
    }

    private boolean handleOutputDataOnLollipop(VideoDecoder videoDecoder, MediaCodec.BufferInfo bufferInfo, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        try {
            Image outputImage = this.mMediaCodec.getOutputImage(i);
            if (outputImage != null) {
                outputImage.getFormat();
            }
            return handleDataFromImage(outputImage, videoDecoder, bufferInfo.presentationTimeUs / 1000);
        } catch (Exception unused) {
            logE("Handle output data on lollipop exception -> get output image failed!");
            return false;
        }
    }

    private boolean handleOutputData(VideoDecoder videoDecoder, MediaCodec.BufferInfo bufferInfo, int i) {
        ByteBuffer byteBuffer = this.mMediaCodec.getOutputBuffers()[i];
        if (byteBuffer == null) {
            return true;
        }
        MediaFormat outputFormat = this.mMediaCodec.getOutputFormat();
        byteBuffer.position(bufferInfo.offset);
        byte[] bArr = this.mDecodedDatas;
        if (bArr == null || bArr.length != bufferInfo.size) {
            this.mDecodedDatas = new byte[bufferInfo.size];
        }
        byteBuffer.get(this.mDecodedDatas);
        byte[] bArr2 = this.mDecodedDatas;
        int length = bArr2.length;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr2, 0, bArr3, 0, length);
        if (outputFormat.getInteger("color-format") == 21) {
            videoDecoder.renderYuvDecodedFrame(bArr3, outputFormat.getInteger("width"), outputFormat.getInteger("height"));
        }
        return true;
    }

    private boolean handleDataFromImage(Image image, VideoDecoder videoDecoder, long j) {
        int i;
        int i2 = 1;
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        int i3 = 0;
        try {
            Rect cropRect = image.getCropRect();
            int format = image.getFormat();
            int width = cropRect.width();
            int height = cropRect.height();
            Image.Plane[] planes = image.getPlanes();
            int i4 = width * height;
            byte[] bArr = new byte[((ImageFormat.getBitsPerPixel(format) * i4) / 8)];
            byte[] bArr2 = new byte[planes[0].getRowStride()];
            int i5 = 0;
            int i6 = 0;
            while (i5 < planes.length) {
                if (i5 == 0) {
                    i6 = i3;
                } else if (i5 == i2) {
                    i6 = i4;
                } else if (i5 == 2) {
                    i6 = (int) (((double) i4) * 1.25d);
                }
                ByteBuffer buffer = planes[i5].getBuffer();
                int rowStride = planes[i5].getRowStride();
                int pixelStride = planes[i5].getPixelStride();
                int i7 = i5 == 0 ? i3 : i2;
                int i8 = width >> i7;
                int i9 = height >> i7;
                Image.Plane[] planeArr = planes;
                buffer.position(((cropRect.top >> i7) * rowStride) + ((cropRect.left >> i7) * pixelStride));
                for (int i10 = 0; i10 < i9; i10++) {
                    if (pixelStride == 1) {
                        buffer.get(bArr, i6, i8);
                        i6 += i8;
                        i = i8;
                    } else {
                        i = ((i8 - 1) * pixelStride) + 1;
                        buffer.get(bArr2, 0, i);
                        for (int i11 = 0; i11 < i8; i11++) {
                            bArr[i6] = bArr2[i11 * pixelStride];
                            i6++;
                        }
                    }
                    if (i10 < i9 - 1) {
                        buffer.position((buffer.position() + rowStride) - i);
                    }
                }
                i5++;
                planes = planeArr;
                i3 = 0;
                i2 = 1;
            }
            videoDecoder.renderYuvDecodedFrame(bArr, width, height);
            int i12 = width / 2;
            videoDecoder.reportYuvDecodedFrame(bArr, width, height, width, i12, i12, false, j);
            return true;
        } catch (Exception unused) {
            logE("handleDataFromImage -> parse Image failed!");
            return false;
        }
    }

    private void logI(String str) {
        OmniLog.rv_i(this.TAG, str);
    }

    private void logE(String str) {
        OmniLog.e("RVW", this.TAG, str);
    }
}
