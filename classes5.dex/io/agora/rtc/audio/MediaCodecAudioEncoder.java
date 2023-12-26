package io.agora.rtc.audio;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import io.agora.rtc.internal.Logging;
import java.io.BufferedOutputStream;
import java.io.File;
import java.nio.ByteBuffer;

public class MediaCodecAudioEncoder {
    private String TAG = "MediaCodec Audio Encoder";
    private ByteBuffer mAACEncodedBuffer = ByteBuffer.allocateDirect(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    private MediaCodec mAACEncoder = null;
    private MediaFormat mAACFormat = null;
    private ByteBuffer[] mAACInputBuffers;
    private ByteBuffer[] mAACOutputBuffers;
    private String mCodecString = null;
    private ByteBuffer[] mInputBuffers;
    private MediaCodec mMediaCodec = null;
    private ByteBuffer[] mOutputBuffers;
    private MediaFormat mTrackFormat = null;
    private File outputFile = null;
    private BufferedOutputStream outputStream = null;

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00cb A[Catch:{ Exception -> 0x0142 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0103 A[Catch:{ Exception -> 0x0142 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0119 A[Catch:{ Exception -> 0x0142 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean createStreaming(java.lang.String r17, int r18, int r19, int r20) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            java.lang.String r5 = "audio/mp4a-latm"
            r6 = 0
            java.lang.String r7 = r1.TAG     // Catch:{ Exception -> 0x0142 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0142 }
            r8.<init>()     // Catch:{ Exception -> 0x0142 }
            java.lang.String r9 = "Recording aac with fs = "
            r8.append(r9)     // Catch:{ Exception -> 0x0142 }
            r8.append(r2)     // Catch:{ Exception -> 0x0142 }
            java.lang.String r9 = ", ch = "
            r8.append(r9)     // Catch:{ Exception -> 0x0142 }
            r8.append(r3)     // Catch:{ Exception -> 0x0142 }
            java.lang.String r9 = ", quality = "
            r8.append(r9)     // Catch:{ Exception -> 0x0142 }
            r8.append(r4)     // Catch:{ Exception -> 0x0142 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0142 }
            io.agora.rtc.internal.Logging.i(r7, r8)     // Catch:{ Exception -> 0x0142 }
            int r7 = r17.length()     // Catch:{ Exception -> 0x0142 }
            r8 = 3
            int r7 = r7 - r8
            java.lang.String r7 = r0.substring(r7)     // Catch:{ Exception -> 0x0142 }
            java.lang.String r9 = "3gp"
            boolean r9 = r7.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x0142 }
            r10 = 16000(0x3e80, float:2.2421E-41)
            r11 = 2
            java.lang.String r12 = "bitrate"
            java.lang.String r13 = "audio/amr-wb"
            java.lang.String r14 = "audio/3gpp"
            r15 = 1
            if (r9 != 0) goto L_0x0092
            java.lang.String r9 = "amr"
            boolean r9 = r7.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x0142 }
            if (r9 == 0) goto L_0x0058
            goto L_0x0092
        L_0x0058:
            java.lang.String r9 = "aac"
            boolean r7 = r7.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x0142 }
            if (r7 == 0) goto L_0x0091
            if (r4 == 0) goto L_0x006a
            if (r4 == r15) goto L_0x0068
            r10 = 50000(0xc350, float:7.0065E-41)
            goto L_0x006a
        L_0x0068:
            r10 = 25000(0x61a8, float:3.5032E-41)
        L_0x006a:
            android.media.MediaCodec r4 = android.media.MediaCodec.createEncoderByType(r5)     // Catch:{ Exception -> 0x0142 }
            r1.mMediaCodec = r4     // Catch:{ Exception -> 0x0142 }
            android.media.MediaFormat r4 = android.media.MediaFormat.createAudioFormat(r5, r2, r3)     // Catch:{ Exception -> 0x0142 }
            r1.mTrackFormat = r4     // Catch:{ Exception -> 0x0142 }
            java.lang.String r7 = "aac-profile"
            r4.setInteger(r7, r11)     // Catch:{ Exception -> 0x0142 }
            android.media.MediaFormat r4 = r1.mTrackFormat     // Catch:{ Exception -> 0x0142 }
            java.lang.String r7 = "sample-rate"
            r4.setInteger(r7, r2)     // Catch:{ Exception -> 0x0142 }
            android.media.MediaFormat r2 = r1.mTrackFormat     // Catch:{ Exception -> 0x0142 }
            java.lang.String r4 = "channel-count"
            r2.setInteger(r4, r3)     // Catch:{ Exception -> 0x0142 }
            android.media.MediaFormat r2 = r1.mTrackFormat     // Catch:{ Exception -> 0x0142 }
            r2.setInteger(r12, r10)     // Catch:{ Exception -> 0x0142 }
            r1.mCodecString = r5     // Catch:{ Exception -> 0x0142 }
            goto L_0x00bf
        L_0x0091:
            return r6
        L_0x0092:
            r4 = 8000(0x1f40, float:1.121E-41)
            if (r2 != r4) goto L_0x00aa
            android.media.MediaCodec r4 = android.media.MediaCodec.createEncoderByType(r14)     // Catch:{ Exception -> 0x0142 }
            r1.mMediaCodec = r4     // Catch:{ Exception -> 0x0142 }
            android.media.MediaFormat r2 = android.media.MediaFormat.createAudioFormat(r14, r2, r3)     // Catch:{ Exception -> 0x0142 }
            r1.mTrackFormat = r2     // Catch:{ Exception -> 0x0142 }
            r3 = 12200(0x2fa8, float:1.7096E-41)
            r2.setInteger(r12, r3)     // Catch:{ Exception -> 0x0142 }
            r1.mCodecString = r14     // Catch:{ Exception -> 0x0142 }
            goto L_0x00bf
        L_0x00aa:
            if (r2 != r10) goto L_0x00bf
            android.media.MediaCodec r4 = android.media.MediaCodec.createEncoderByType(r13)     // Catch:{ Exception -> 0x0142 }
            r1.mMediaCodec = r4     // Catch:{ Exception -> 0x0142 }
            android.media.MediaFormat r2 = android.media.MediaFormat.createAudioFormat(r13, r2, r3)     // Catch:{ Exception -> 0x0142 }
            r1.mTrackFormat = r2     // Catch:{ Exception -> 0x0142 }
            r3 = 23850(0x5d2a, float:3.3421E-41)
            r2.setInteger(r12, r3)     // Catch:{ Exception -> 0x0142 }
            r1.mCodecString = r13     // Catch:{ Exception -> 0x0142 }
        L_0x00bf:
            android.media.MediaCodec r2 = r1.mMediaCodec     // Catch:{ Exception -> 0x0142 }
            android.media.MediaFormat r3 = r1.mTrackFormat     // Catch:{ Exception -> 0x0142 }
            r4 = 0
            r2.configure(r3, r4, r4, r15)     // Catch:{ Exception -> 0x0142 }
            android.media.MediaCodec r2 = r1.mMediaCodec     // Catch:{ Exception -> 0x0142 }
            if (r2 == 0) goto L_0x00ce
            r2.start()     // Catch:{ Exception -> 0x0142 }
        L_0x00ce:
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0142 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0142 }
            r1.outputFile = r2     // Catch:{ Exception -> 0x0142 }
            r1.touch(r2)     // Catch:{ Exception -> 0x0142 }
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x00ee }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00ee }
            java.io.File r3 = r1.outputFile     // Catch:{ Exception -> 0x00ee }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00ee }
            r0.<init>(r2)     // Catch:{ Exception -> 0x00ee }
            r1.outputStream = r0     // Catch:{ Exception -> 0x00ee }
            java.lang.String r0 = r1.TAG     // Catch:{ Exception -> 0x00ee }
            java.lang.String r2 = "outputStream initialized"
            io.agora.rtc.internal.Logging.i(r0, r2)     // Catch:{ Exception -> 0x00ee }
            goto L_0x00f2
        L_0x00ee:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x0142 }
        L_0x00f2:
            java.lang.String r0 = r1.mCodecString     // Catch:{ Exception -> 0x0142 }
            r3 = 5
            r4 = 82
            r5 = 4
            r7 = 77
            r9 = 65
            r10 = 33
            r12 = 35
            r2 = 6
            if (r0 != r14) goto L_0x0119
            byte[] r0 = new byte[r2]     // Catch:{ Exception -> 0x0142 }
            r0[r6] = r12     // Catch:{ Exception -> 0x0142 }
            r0[r15] = r10     // Catch:{ Exception -> 0x0142 }
            r0[r11] = r9     // Catch:{ Exception -> 0x0142 }
            r0[r8] = r7     // Catch:{ Exception -> 0x0142 }
            r0[r5] = r4     // Catch:{ Exception -> 0x0142 }
            r2 = 10
            r0[r3] = r2     // Catch:{ Exception -> 0x0142 }
            java.io.BufferedOutputStream r2 = r1.outputStream     // Catch:{ Exception -> 0x0142 }
            r2.write(r0)     // Catch:{ Exception -> 0x0142 }
            goto L_0x0141
        L_0x0119:
            if (r0 != r13) goto L_0x0141
            r0 = 9
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x0142 }
            r0[r6] = r12     // Catch:{ Exception -> 0x0142 }
            r0[r15] = r10     // Catch:{ Exception -> 0x0142 }
            r0[r11] = r9     // Catch:{ Exception -> 0x0142 }
            r0[r8] = r7     // Catch:{ Exception -> 0x0142 }
            r0[r5] = r4     // Catch:{ Exception -> 0x0142 }
            r4 = 45
            r0[r3] = r4     // Catch:{ Exception -> 0x0142 }
            r3 = 87
            r0[r2] = r3     // Catch:{ Exception -> 0x0142 }
            r2 = 7
            r3 = 66
            r0[r2] = r3     // Catch:{ Exception -> 0x0142 }
            r2 = 8
            r3 = 10
            r0[r2] = r3     // Catch:{ Exception -> 0x0142 }
            java.io.BufferedOutputStream r2 = r1.outputStream     // Catch:{ Exception -> 0x0142 }
            r2.write(r0)     // Catch:{ Exception -> 0x0142 }
        L_0x0141:
            return r15
        L_0x0142:
            r0 = move-exception
            java.lang.String r2 = r1.TAG
            java.lang.String r3 = "Error when creating aac file encoder"
            io.agora.rtc.internal.Logging.e(r2, r3)
            r0.printStackTrace()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.audio.MediaCodecAudioEncoder.createStreaming(java.lang.String, int, int, int):boolean");
    }

    public void setChannelCount(int i) {
        try {
            this.mTrackFormat.setInteger("channel-count", i);
        } catch (Exception e) {
            Logging.e(this.TAG, "Error when setting aac file encoder channel count");
            e.printStackTrace();
        }
    }

    public void setSampleRate(int i) {
        try {
            this.mTrackFormat.setInteger("sample-rate", i);
        } catch (Exception e) {
            Logging.e(this.TAG, "Error when setting aac file encoder sample rate");
            e.printStackTrace();
        }
    }

    public void releaseStreaming() {
        try {
            MediaCodec mediaCodec = this.mMediaCodec;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.mMediaCodec.release();
                this.mMediaCodec = null;
            }
            BufferedOutputStream bufferedOutputStream = this.outputStream;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.flush();
                this.outputStream.close();
                this.outputStream = null;
            }
        } catch (Exception e) {
            Logging.e(this.TAG, "Error when releasing aac file encoder");
            e.printStackTrace();
        }
    }

    public void encodeFrame(byte[] bArr) {
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        try {
            int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(2000);
            if (dequeueInputBuffer != -1) {
                if (Build.VERSION.SDK_INT >= 21) {
                    byteBuffer2 = this.mMediaCodec.getInputBuffer(dequeueInputBuffer);
                } else {
                    ByteBuffer[] inputBuffers = this.mMediaCodec.getInputBuffers();
                    this.mInputBuffers = inputBuffers;
                    byteBuffer2 = inputBuffers[dequeueInputBuffer];
                }
                byteBuffer2.clear();
                byteBuffer2.put(bArr);
                this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, 0, 0);
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, 0);
            while (dequeueOutputBuffer >= 0) {
                int i = bufferInfo.size;
                if (Build.VERSION.SDK_INT >= 21) {
                    byteBuffer = this.mMediaCodec.getOutputBuffer(dequeueOutputBuffer);
                } else {
                    ByteBuffer[] outputBuffers = this.mMediaCodec.getOutputBuffers();
                    this.mOutputBuffers = outputBuffers;
                    byteBuffer = outputBuffers[dequeueOutputBuffer];
                }
                byteBuffer.position(bufferInfo.offset);
                byteBuffer.limit(bufferInfo.offset + i);
                String str = this.mCodecString;
                if (str == "audio/mp4a-latm") {
                    int i2 = i + 7;
                    byte[] bArr2 = new byte[i2];
                    addADTStoPacket(bArr2, i2);
                    byteBuffer.get(bArr2, 7, i);
                    byteBuffer.position(bufferInfo.offset);
                    this.outputStream.write(bArr2, 0, i2);
                } else if (str == "audio/3gpp" || str == "audio/amr-wb") {
                    byte[] bArr3 = new byte[i];
                    byteBuffer.get(bArr3, 0, i);
                    byteBuffer.position(bufferInfo.offset);
                    this.outputStream.write(bArr3, 0, i);
                }
                this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, 0);
            }
        } catch (Exception e) {
            Logging.e(this.TAG, "Error when encoding aac file");
            e.printStackTrace();
        }
    }

    private void addADTStoPacket(byte[] bArr, int i) {
        bArr[0] = -1;
        bArr[1] = -7;
        bArr[2] = (byte) 84;
        bArr[3] = (byte) (64 + (i >> 11));
        bArr[4] = (byte) ((i & 2047) >> 3);
        bArr[5] = (byte) (((i & 7) << 5) + 31);
        bArr[6] = -4;
    }

    private void touch(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean createAACStreaming(int i, int i2, int i3) {
        try {
            String str = this.TAG;
            Logging.i(str, "Encoding aac with fs = " + i + ", bitrate = " + i3);
            this.mAACEncoder = MediaCodec.createEncoderByType("audio/mp4a-latm");
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i, i2);
            this.mAACFormat = createAudioFormat;
            createAudioFormat.setInteger("aac-profile", 2);
            this.mAACFormat.setInteger("sample-rate", i);
            this.mAACFormat.setInteger("channel-count", i2);
            this.mAACFormat.setInteger("bitrate", i3);
            this.mAACEncoder.configure(this.mAACFormat, (Surface) null, (MediaCrypto) null, 1);
            MediaCodec mediaCodec = this.mAACEncoder;
            if (mediaCodec != null) {
                mediaCodec.start();
            }
            return true;
        } catch (Exception e) {
            Logging.e(this.TAG, "Error when creating aac encode stream");
            e.printStackTrace();
            return false;
        }
    }

    public boolean setAACEncodeBitrate(int i) {
        String str = this.TAG;
        Logging.w(str, "Set hw aac bitrate = " + i);
        try {
            MediaCodec mediaCodec = this.mAACEncoder;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.mAACFormat.setInteger("bitrate", i);
                this.mAACEncoder.configure(this.mAACFormat, (Surface) null, (MediaCrypto) null, 1);
                this.mAACEncoder.start();
            }
            return true;
        } catch (Exception e) {
            Logging.e(this.TAG, "Error when setting aac encode bitrate");
            e.printStackTrace();
            return false;
        }
    }

    public void releaseAACStreaming() {
        try {
            MediaCodec mediaCodec = this.mAACEncoder;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.mAACEncoder.release();
                this.mAACEncoder = null;
            }
        } catch (Exception e) {
            Logging.e(this.TAG, "Error when releasing aac encode stream");
            e.printStackTrace();
        }
    }

    public int encodeAACFrame(byte[] bArr) {
        ByteBuffer byteBuffer;
        int i;
        ByteBuffer byteBuffer2;
        int i2 = 0;
        try {
            int dequeueInputBuffer = this.mAACEncoder.dequeueInputBuffer(2000);
            if (dequeueInputBuffer != -1) {
                if (Build.VERSION.SDK_INT >= 21) {
                    byteBuffer2 = this.mAACEncoder.getInputBuffer(dequeueInputBuffer);
                } else {
                    ByteBuffer[] inputBuffers = this.mAACEncoder.getInputBuffers();
                    this.mAACInputBuffers = inputBuffers;
                    byteBuffer2 = inputBuffers[dequeueInputBuffer];
                }
                byteBuffer2.clear();
                byteBuffer2.put(bArr);
                this.mAACEncoder.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, 0, 0);
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mAACEncoder.dequeueOutputBuffer(bufferInfo, 0);
            if (dequeueOutputBuffer < 0) {
                return 0;
            }
            int i3 = bufferInfo.size;
            if (Build.VERSION.SDK_INT >= 21) {
                byteBuffer = this.mAACEncoder.getOutputBuffer(dequeueOutputBuffer);
            } else {
                ByteBuffer[] outputBuffers = this.mAACEncoder.getOutputBuffers();
                this.mAACOutputBuffers = outputBuffers;
                byteBuffer = outputBuffers[dequeueOutputBuffer];
            }
            if ((bufferInfo.flags & 2) == 2) {
                i = 0;
            } else {
                i = bufferInfo.size;
            }
            try {
                byteBuffer.position(bufferInfo.offset);
                byteBuffer.limit(bufferInfo.offset + i3);
                this.mAACEncodedBuffer.position(0);
                this.mAACEncodedBuffer.put(byteBuffer);
                this.mAACEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                return i;
            } catch (Exception e) {
                e = e;
                i2 = i;
                Logging.e(this.TAG, "Error when encoding aac stream");
                e.printStackTrace();
                return i2;
            }
        } catch (Exception e2) {
            e = e2;
            Logging.e(this.TAG, "Error when encoding aac stream");
            e.printStackTrace();
            return i2;
        }
    }
}
