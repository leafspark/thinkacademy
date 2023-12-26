package com.linkedin.android.litr.io;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0002J \u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/linkedin/android/litr/io/WavMediaTarget;", "Lcom/linkedin/android/litr/io/MediaTarget;", "targetPath", "", "(Ljava/lang/String;)V", "outputStream", "Ljava/io/OutputStream;", "size", "", "tracks", "", "Landroid/media/MediaFormat;", "addTrack", "", "mediaFormat", "targetTrack", "getOutputFilePath", "release", "", "updateWavHeader", "writeSampleData", "buffer", "Ljava/nio/ByteBuffer;", "info", "Landroid/media/MediaCodec$BufferInfo;", "writeWavHeader", "channelCount", "sampleRate", "bytesPerSample", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: WavMediaTarget.kt */
public final class WavMediaTarget implements MediaTarget {
    private final OutputStream outputStream;
    private long size;
    private final String targetPath;
    private final List<MediaFormat> tracks = new ArrayList();

    public WavMediaTarget(String str) {
        Intrinsics.checkNotNullParameter(str, "targetPath");
        this.targetPath = str;
        this.outputStream = new FileOutputStream(new File(str));
    }

    public int addTrack(MediaFormat mediaFormat, int i) {
        Intrinsics.checkNotNullParameter(mediaFormat, "mediaFormat");
        if (this.tracks.size() != 0 || !mediaFormat.containsKey("mime") || !Intrinsics.areEqual(mediaFormat.getString("mime"), "audio/raw") || !mediaFormat.containsKey("channel-count") || !mediaFormat.containsKey("sample-rate")) {
            return -1;
        }
        this.tracks.add(mediaFormat);
        writeWavHeader(mediaFormat.getInteger("channel-count"), mediaFormat.getInteger("sample-rate"), 2);
        return 0;
    }

    public void writeSampleData(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        Intrinsics.checkNotNullParameter(bufferInfo, "info");
        long j = this.size + ((long) bufferInfo.size);
        this.size = j;
        if (j < 4294967295L) {
            this.outputStream.write(byteBuffer.array(), bufferInfo.offset, bufferInfo.size);
        } else {
            release();
            throw new IllegalStateException("WAV file size cannot exceed 4294967295 bytes");
        }
    }

    public void release() {
        this.outputStream.close();
        updateWavHeader();
    }

    public String getOutputFilePath() {
        return this.targetPath;
    }

    private final void writeWavHeader(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        byte[] array = ByteBuffer.allocate(14).order(ByteOrder.LITTLE_ENDIAN).putShort((short) i4).putInt(i5).putInt(i5 * i4 * i3).putShort((short) (i4 * i3)).putShort((short) (i3 * 8)).array();
        byte b = (byte) 70;
        byte b2 = (byte) 116;
        byte b3 = (byte) 97;
        this.outputStream.write(new byte[]{(byte) 82, (byte) 73, b, b, 0, 0, 0, 0, (byte) 87, (byte) 65, (byte) 86, (byte) 69, (byte) 102, (byte) 109, b2, (byte) 32, 16, 0, 0, 0, 1, 0, array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8], array[9], array[10], array[11], array[12], array[13], (byte) 100, b3, b2, b3, 0, 0, 0, 0});
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005d A[SYNTHETIC, Splitter:B:19:0x005d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateWavHeader() {
        /*
            r7 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r7.targetPath
            r0.<init>(r1)
            r1 = 8
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r1)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r2 = r2.order(r3)
            long r3 = r0.length()
            long r5 = (long) r1
            long r3 = r3 - r5
            int r1 = (int) r3
            java.nio.ByteBuffer r1 = r2.putInt(r1)
            long r2 = r0.length()
            r4 = 44
            long r4 = (long) r4
            long r2 = r2 - r4
            int r2 = (int) r2
            java.nio.ByteBuffer r1 = r1.putInt(r2)
            byte[] r1 = r1.array()
            r2 = 0
            java.io.RandomAccessFile r2 = (java.io.RandomAccessFile) r2
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x0057 }
            java.lang.String r4 = "rw"
            r3.<init>(r0, r4)     // Catch:{ IOException -> 0x0057 }
            r4 = 4
            r3.seek(r4)     // Catch:{ IOException -> 0x0052, all -> 0x004f }
            r0 = 0
            r2 = 4
            r3.write(r1, r0, r2)     // Catch:{ IOException -> 0x0052, all -> 0x004f }
            r4 = 40
            r3.seek(r4)     // Catch:{ IOException -> 0x0052, all -> 0x004f }
            r3.write(r1, r2, r2)     // Catch:{ IOException -> 0x0052, all -> 0x004f }
            r3.close()     // Catch:{ IOException -> 0x004e }
        L_0x004e:
            return
        L_0x004f:
            r0 = move-exception
            r2 = r3
            goto L_0x005b
        L_0x0052:
            r0 = move-exception
            r2 = r3
            goto L_0x0058
        L_0x0055:
            r0 = move-exception
            goto L_0x005b
        L_0x0057:
            r0 = move-exception
        L_0x0058:
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x0055 }
            throw r0     // Catch:{ all -> 0x0055 }
        L_0x005b:
            if (r2 == 0) goto L_0x0060
            r2.close()     // Catch:{ IOException -> 0x0060 }
        L_0x0060:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.linkedin.android.litr.io.WavMediaTarget.updateWavHeader():void");
    }
}
