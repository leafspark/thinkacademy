package com.linkedin.android.litr.io;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.linkedin.android.litr.exception.MediaTargetException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.LinkedList;

public class MediaMuxerMediaTarget implements MediaTarget {
    private static final String TAG = "MediaMuxerMediaTarget";
    boolean isStarted;
    private MediaFormat[] mediaFormatsToAdd;
    MediaMuxer mediaMuxer;
    private int numberOfTracksToAdd;
    private String outputFilePath;
    private ParcelFileDescriptor parcelFileDescriptor;
    LinkedList<MediaSample> queue;
    private int trackCount;

    public MediaMuxerMediaTarget(Context context, Uri uri, int i, int i2, int i3) throws MediaTargetException {
        MediaMuxer mediaMuxer2;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "rwt");
                this.parcelFileDescriptor = openFileDescriptor;
                if (openFileDescriptor != null) {
                    mediaMuxer2 = new MediaMuxer(this.parcelFileDescriptor.getFileDescriptor(), i3);
                } else {
                    throw new IOException("Inaccessible URI " + uri);
                }
            } else if (!"file".equalsIgnoreCase(uri.getScheme()) || uri.getPath() == null) {
                throw new MediaTargetException(MediaTargetException.Error.UNSUPPORTED_URI_TYPE, uri, i3, new Throwable());
            } else {
                mediaMuxer2 = new MediaMuxer(uri.getPath(), i3);
            }
            init(mediaMuxer2, i, i2);
        } catch (IllegalArgumentException e) {
            throw new MediaTargetException(MediaTargetException.Error.INVALID_PARAMS, uri, i3, (Throwable) e);
        } catch (IOException e2) {
            releaseFileDescriptor();
            throw new MediaTargetException(MediaTargetException.Error.IO_FAILUE, uri, i3, (Throwable) e2);
        }
    }

    public MediaMuxerMediaTarget(String str, int i, int i2, int i3) throws MediaTargetException {
        this.outputFilePath = str;
        try {
            init(new MediaMuxer(str, i3), i, i2);
        } catch (IllegalArgumentException e) {
            throw new MediaTargetException(MediaTargetException.Error.INVALID_PARAMS, str, i3, (Throwable) e);
        } catch (IOException e2) {
            throw new MediaTargetException(MediaTargetException.Error.IO_FAILUE, str, i3, (Throwable) e2);
        }
    }

    private void init(MediaMuxer mediaMuxer2, int i, int i2) throws IllegalArgumentException {
        this.trackCount = i;
        this.mediaMuxer = mediaMuxer2;
        mediaMuxer2.setOrientationHint(i2);
        this.numberOfTracksToAdd = 0;
        this.isStarted = false;
        this.queue = new LinkedList<>();
        this.mediaFormatsToAdd = new MediaFormat[i];
    }

    public int addTrack(MediaFormat mediaFormat, int i) {
        this.mediaFormatsToAdd[i] = mediaFormat;
        int i2 = this.numberOfTracksToAdd + 1;
        this.numberOfTracksToAdd = i2;
        if (i2 == this.trackCount) {
            Log.d(TAG, "All tracks added, starting MediaMuxer, writing out " + this.queue.size() + " queued samples");
            for (MediaFormat addTrack : this.mediaFormatsToAdd) {
                this.mediaMuxer.addTrack(addTrack);
            }
            this.mediaMuxer.start();
            this.isStarted = true;
            while (!this.queue.isEmpty()) {
                MediaSample removeFirst = this.queue.removeFirst();
                this.mediaMuxer.writeSampleData(removeFirst.targetTrack, removeFirst.buffer, removeFirst.info);
            }
        }
        return i;
    }

    public void writeSampleData(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (!this.isStarted) {
            this.queue.addLast(new MediaSample(i, byteBuffer, bufferInfo));
        } else if (byteBuffer == null) {
            Log.e(TAG, "Trying to write a null buffer, skipping");
        } else {
            this.mediaMuxer.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }

    public void release() {
        this.mediaMuxer.release();
        releaseFileDescriptor();
    }

    public String getOutputFilePath() {
        String str = this.outputFilePath;
        return str != null ? str : "";
    }

    private void releaseFileDescriptor() {
        try {
            ParcelFileDescriptor parcelFileDescriptor2 = this.parcelFileDescriptor;
            if (parcelFileDescriptor2 != null) {
                parcelFileDescriptor2.close();
                this.parcelFileDescriptor = null;
            }
        } catch (IOException unused) {
        }
    }

    private class MediaSample {
        /* access modifiers changed from: private */
        public ByteBuffer buffer;
        /* access modifiers changed from: private */
        public MediaCodec.BufferInfo info;
        /* access modifiers changed from: private */
        public int targetTrack;

        private MediaSample(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            this.targetTrack = i;
            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
            this.info = bufferInfo2;
            bufferInfo2.set(0, bufferInfo.size, bufferInfo.presentationTimeUs, bufferInfo.flags);
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity());
            this.buffer = allocate;
            allocate.put(byteBuffer);
            this.buffer.flip();
        }
    }
}
