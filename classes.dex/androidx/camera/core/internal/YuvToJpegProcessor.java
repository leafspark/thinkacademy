package androidx.camera.core.internal;

import android.graphics.Rect;
import android.media.ImageWriter;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.core.util.Preconditions;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public class YuvToJpegProcessor implements CaptureProcessor {
    private static final String TAG = "YuvToJpegProcessor";
    private static final Rect UNINITIALIZED_RECT = new Rect(0, 0, 0, 0);
    private boolean mClosed = false;
    private Rect mImageRect = UNINITIALIZED_RECT;
    private ImageWriter mImageWriter;
    private final Object mLock = new Object();
    private final int mMaxImages;
    private int mProcessingImages = 0;
    private final int mQuality;

    public YuvToJpegProcessor(int i, int i2) {
        this.mQuality = i;
        this.mMaxImages = i2;
    }

    public void onOutputSurface(Surface surface, int i) {
        Preconditions.checkState(i == 256, "YuvToJpegProcessor only supports JPEG output format.");
        synchronized (this.mLock) {
            if (this.mClosed) {
                Logger.w(TAG, "Cannot set output surface. Processor is closed.");
            } else if (this.mImageWriter == null) {
                this.mImageWriter = ImageWriterCompat.newInstance(surface, this.mMaxImages, i);
            } else {
                throw new IllegalStateException("Output surface already set.");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: androidx.camera.core.ImageProxy} */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x013b  */
    public void process(androidx.camera.core.impl.ImageProxyBundle r18) {
        /*
            r17 = this;
            r1 = r17
            java.util.List r0 = r18.getCaptureIds()
            int r2 = r0.size()
            r3 = 0
            r4 = 1
            if (r2 != r4) goto L_0x0010
            r2 = r4
            goto L_0x0011
        L_0x0010:
            r2 = r3
        L_0x0011:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Processing image bundle have single capture id, but found "
            r5.append(r6)
            int r6 = r0.size()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            androidx.core.util.Preconditions.checkArgument(r2, r5)
            java.lang.Object r0 = r0.get(r3)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r2 = r18
            com.google.common.util.concurrent.ListenableFuture r0 = r2.getImageProxy(r0)
            boolean r2 = r0.isDone()
            androidx.core.util.Preconditions.checkArgument(r2)
            java.lang.Object r2 = r1.mLock
            monitor-enter(r2)
            android.media.ImageWriter r5 = r1.mImageWriter     // Catch:{ all -> 0x01b5 }
            boolean r6 = r1.mClosed     // Catch:{ all -> 0x01b5 }
            if (r6 != 0) goto L_0x004b
            r6 = r4
            goto L_0x004c
        L_0x004b:
            r6 = r3
        L_0x004c:
            android.graphics.Rect r7 = r1.mImageRect     // Catch:{ all -> 0x01b5 }
            if (r6 == 0) goto L_0x0055
            int r8 = r1.mProcessingImages     // Catch:{ all -> 0x01b5 }
            int r8 = r8 + r4
            r1.mProcessingImages = r8     // Catch:{ all -> 0x01b5 }
        L_0x0055:
            monitor-exit(r2)     // Catch:{ all -> 0x01b5 }
            r2 = 0
            java.lang.Object r8 = r0.get()     // Catch:{ InterruptedException -> 0x0137, ExecutionException -> 0x0135, all -> 0x0132 }
            androidx.camera.core.ImageProxy r8 = (androidx.camera.core.ImageProxy) r8     // Catch:{ InterruptedException -> 0x0137, ExecutionException -> 0x0135, all -> 0x0132 }
            if (r6 != 0) goto L_0x008e
            java.lang.String r0 = "YuvToJpegProcessor"
            java.lang.String r7 = "Image enqueued for processing on closed processor."
            androidx.camera.core.Logger.w(r0, r7)     // Catch:{ InterruptedException -> 0x012e, ExecutionException -> 0x012c, all -> 0x0128 }
            r8.close()     // Catch:{ InterruptedException -> 0x012e, ExecutionException -> 0x012c, all -> 0x0128 }
            java.lang.Object r7 = r1.mLock
            monitor-enter(r7)
            if (r6 == 0) goto L_0x007e
            int r0 = r1.mProcessingImages     // Catch:{ all -> 0x007c }
            int r2 = r0 + -1
            r1.mProcessingImages = r2     // Catch:{ all -> 0x007c }
            if (r0 != 0) goto L_0x007e
            boolean r0 = r1.mClosed     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x007e
            r3 = r4
            goto L_0x007e
        L_0x007c:
            r0 = move-exception
            goto L_0x008c
        L_0x007e:
            monitor-exit(r7)     // Catch:{ all -> 0x007c }
            if (r3 == 0) goto L_0x008b
            r5.close()
            java.lang.String r0 = "YuvToJpegProcessor"
            java.lang.String r2 = "Closed after completion of last image processed."
            androidx.camera.core.Logger.d(r0, r2)
        L_0x008b:
            return
        L_0x008c:
            monitor-exit(r7)     // Catch:{ all -> 0x007c }
            throw r0
        L_0x008e:
            android.media.Image r9 = r5.dequeueInputImage()     // Catch:{ InterruptedException -> 0x012e, ExecutionException -> 0x012c, all -> 0x0128 }
            java.lang.Object r0 = r0.get()     // Catch:{ InterruptedException -> 0x0126, ExecutionException -> 0x0124, all -> 0x0122 }
            r10 = r0
            androidx.camera.core.ImageProxy r10 = (androidx.camera.core.ImageProxy) r10     // Catch:{ InterruptedException -> 0x0126, ExecutionException -> 0x0124, all -> 0x0122 }
            int r0 = r10.getFormat()     // Catch:{ InterruptedException -> 0x011f, ExecutionException -> 0x011d, all -> 0x011a }
            r8 = 35
            if (r0 != r8) goto L_0x00a3
            r0 = r4
            goto L_0x00a4
        L_0x00a3:
            r0 = r3
        L_0x00a4:
            java.lang.String r8 = "Input image is not expected YUV_420_888 image format"
            androidx.core.util.Preconditions.checkState(r0, r8)     // Catch:{ InterruptedException -> 0x011f, ExecutionException -> 0x011d, all -> 0x011a }
            byte[] r12 = androidx.camera.core.internal.utils.ImageUtil.yuv_420_888toNv21(r10)     // Catch:{ InterruptedException -> 0x011f, ExecutionException -> 0x011d, all -> 0x011a }
            android.graphics.YuvImage r0 = new android.graphics.YuvImage     // Catch:{ InterruptedException -> 0x011f, ExecutionException -> 0x011d, all -> 0x011a }
            r13 = 17
            int r14 = r10.getWidth()     // Catch:{ InterruptedException -> 0x011f, ExecutionException -> 0x011d, all -> 0x011a }
            int r15 = r10.getHeight()     // Catch:{ InterruptedException -> 0x011f, ExecutionException -> 0x011d, all -> 0x011a }
            r16 = 0
            r11 = r0
            r11.<init>(r12, r13, r14, r15, r16)     // Catch:{ InterruptedException -> 0x011f, ExecutionException -> 0x011d, all -> 0x011a }
            android.media.Image$Plane[] r8 = r9.getPlanes()     // Catch:{ InterruptedException -> 0x011f, ExecutionException -> 0x011d, all -> 0x011a }
            r8 = r8[r3]     // Catch:{ InterruptedException -> 0x011f, ExecutionException -> 0x011d, all -> 0x011a }
            java.nio.ByteBuffer r8 = r8.getBuffer()     // Catch:{ InterruptedException -> 0x011f, ExecutionException -> 0x011d, all -> 0x011a }
            int r11 = r8.position()     // Catch:{ InterruptedException -> 0x011f, ExecutionException -> 0x011d, all -> 0x011a }
            androidx.camera.core.impl.utils.ExifOutputStream r12 = new androidx.camera.core.impl.utils.ExifOutputStream     // Catch:{ InterruptedException -> 0x011f, ExecutionException -> 0x011d, all -> 0x011a }
            androidx.camera.core.internal.YuvToJpegProcessor$ByteBufferOutputStream r13 = new androidx.camera.core.internal.YuvToJpegProcessor$ByteBufferOutputStream     // Catch:{ InterruptedException -> 0x011f, ExecutionException -> 0x011d, all -> 0x011a }
            r13.<init>(r8)     // Catch:{ InterruptedException -> 0x011f, ExecutionException -> 0x011d, all -> 0x011a }
            androidx.camera.core.impl.utils.ExifData r14 = getExifData(r10)     // Catch:{ InterruptedException -> 0x011f, ExecutionException -> 0x011d, all -> 0x011a }
            r12.<init>(r13, r14)     // Catch:{ InterruptedException -> 0x011f, ExecutionException -> 0x011d, all -> 0x011a }
            int r13 = r1.mQuality     // Catch:{ InterruptedException -> 0x011f, ExecutionException -> 0x011d, all -> 0x011a }
            r0.compressToJpeg(r7, r13, r12)     // Catch:{ InterruptedException -> 0x011f, ExecutionException -> 0x011d, all -> 0x011a }
            r10.close()     // Catch:{ InterruptedException -> 0x011f, ExecutionException -> 0x011d, all -> 0x011a }
            int r0 = r8.position()     // Catch:{ InterruptedException -> 0x0118, ExecutionException -> 0x0116 }
            r8.limit(r0)     // Catch:{ InterruptedException -> 0x0118, ExecutionException -> 0x0116 }
            r8.position(r11)     // Catch:{ InterruptedException -> 0x0118, ExecutionException -> 0x0116 }
            r5.queueInputImage(r9)     // Catch:{ InterruptedException -> 0x0118, ExecutionException -> 0x0116 }
            java.lang.Object r7 = r1.mLock
            monitor-enter(r7)
            if (r6 == 0) goto L_0x0105
            int r0 = r1.mProcessingImages     // Catch:{ all -> 0x0103 }
            int r2 = r0 + -1
            r1.mProcessingImages = r2     // Catch:{ all -> 0x0103 }
            if (r0 != 0) goto L_0x0105
            boolean r0 = r1.mClosed     // Catch:{ all -> 0x0103 }
            if (r0 == 0) goto L_0x0105
            r3 = r4
            goto L_0x0105
        L_0x0103:
            r0 = move-exception
            goto L_0x0114
        L_0x0105:
            monitor-exit(r7)     // Catch:{ all -> 0x0103 }
            if (r3 == 0) goto L_0x01b2
        L_0x0108:
            r5.close()
            java.lang.String r0 = "YuvToJpegProcessor"
            java.lang.String r2 = "Closed after completion of last image processed."
            androidx.camera.core.Logger.d(r0, r2)
            goto L_0x01b2
        L_0x0114:
            monitor-exit(r7)     // Catch:{ all -> 0x0103 }
            throw r0
        L_0x0116:
            r0 = move-exception
            goto L_0x0139
        L_0x0118:
            r0 = move-exception
            goto L_0x0139
        L_0x011a:
            r0 = move-exception
            r2 = r10
            goto L_0x015f
        L_0x011d:
            r0 = move-exception
            goto L_0x0120
        L_0x011f:
            r0 = move-exception
        L_0x0120:
            r2 = r10
            goto L_0x0139
        L_0x0122:
            r0 = move-exception
            goto L_0x012a
        L_0x0124:
            r0 = move-exception
            goto L_0x0130
        L_0x0126:
            r0 = move-exception
            goto L_0x0130
        L_0x0128:
            r0 = move-exception
            r9 = r2
        L_0x012a:
            r2 = r8
            goto L_0x015f
        L_0x012c:
            r0 = move-exception
            goto L_0x012f
        L_0x012e:
            r0 = move-exception
        L_0x012f:
            r9 = r2
        L_0x0130:
            r2 = r8
            goto L_0x0139
        L_0x0132:
            r0 = move-exception
            r9 = r2
            goto L_0x015f
        L_0x0135:
            r0 = move-exception
            goto L_0x0138
        L_0x0137:
            r0 = move-exception
        L_0x0138:
            r9 = r2
        L_0x0139:
            if (r6 == 0) goto L_0x018e
            java.lang.String r7 = "YuvToJpegProcessor"
            java.lang.String r8 = "Failed to process YUV -> JPEG"
            androidx.camera.core.Logger.e(r7, r8, r0)     // Catch:{ all -> 0x015e }
            android.media.Image r7 = r5.dequeueInputImage()     // Catch:{ all -> 0x015e }
            android.media.Image$Plane[] r0 = r7.getPlanes()     // Catch:{ all -> 0x015b }
            r0 = r0[r3]     // Catch:{ all -> 0x015b }
            java.nio.ByteBuffer r0 = r0.getBuffer()     // Catch:{ all -> 0x015b }
            r0.rewind()     // Catch:{ all -> 0x015b }
            r0.limit(r3)     // Catch:{ all -> 0x015b }
            r5.queueInputImage(r7)     // Catch:{ all -> 0x015b }
            r9 = r7
            goto L_0x018e
        L_0x015b:
            r0 = move-exception
            r9 = r7
            goto L_0x015f
        L_0x015e:
            r0 = move-exception
        L_0x015f:
            java.lang.Object r7 = r1.mLock
            monitor-enter(r7)
            if (r6 == 0) goto L_0x0174
            int r6 = r1.mProcessingImages     // Catch:{ all -> 0x0172 }
            int r8 = r6 + -1
            r1.mProcessingImages = r8     // Catch:{ all -> 0x0172 }
            if (r6 != 0) goto L_0x0174
            boolean r6 = r1.mClosed     // Catch:{ all -> 0x0172 }
            if (r6 == 0) goto L_0x0174
            r3 = r4
            goto L_0x0174
        L_0x0172:
            r0 = move-exception
            goto L_0x018c
        L_0x0174:
            monitor-exit(r7)     // Catch:{ all -> 0x0172 }
            if (r9 == 0) goto L_0x017a
            r9.close()
        L_0x017a:
            if (r2 == 0) goto L_0x017f
            r2.close()
        L_0x017f:
            if (r3 == 0) goto L_0x018b
            r5.close()
            java.lang.String r2 = "YuvToJpegProcessor"
            java.lang.String r3 = "Closed after completion of last image processed."
            androidx.camera.core.Logger.d(r2, r3)
        L_0x018b:
            throw r0
        L_0x018c:
            monitor-exit(r7)     // Catch:{ all -> 0x0172 }
            throw r0
        L_0x018e:
            java.lang.Object r7 = r1.mLock
            monitor-enter(r7)
            if (r6 == 0) goto L_0x01a3
            int r0 = r1.mProcessingImages     // Catch:{ all -> 0x01a1 }
            int r6 = r0 + -1
            r1.mProcessingImages = r6     // Catch:{ all -> 0x01a1 }
            if (r0 != 0) goto L_0x01a3
            boolean r0 = r1.mClosed     // Catch:{ all -> 0x01a1 }
            if (r0 == 0) goto L_0x01a3
            r3 = r4
            goto L_0x01a3
        L_0x01a1:
            r0 = move-exception
            goto L_0x01b3
        L_0x01a3:
            monitor-exit(r7)     // Catch:{ all -> 0x01a1 }
            if (r9 == 0) goto L_0x01a9
            r9.close()
        L_0x01a9:
            if (r2 == 0) goto L_0x01ae
            r2.close()
        L_0x01ae:
            if (r3 == 0) goto L_0x01b2
            goto L_0x0108
        L_0x01b2:
            return
        L_0x01b3:
            monitor-exit(r7)     // Catch:{ all -> 0x01a1 }
            throw r0
        L_0x01b5:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x01b5 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.internal.YuvToJpegProcessor.process(androidx.camera.core.impl.ImageProxyBundle):void");
    }

    public void close() {
        synchronized (this.mLock) {
            if (!this.mClosed) {
                this.mClosed = true;
                if (this.mProcessingImages != 0 || this.mImageWriter == null) {
                    Logger.d(TAG, "close() called while processing. Will close after completion.");
                } else {
                    Logger.d(TAG, "No processing in progress. Closing immediately.");
                    this.mImageWriter.close();
                }
            }
        }
    }

    public void onResolutionUpdate(Size size) {
        synchronized (this.mLock) {
            this.mImageRect = new Rect(0, 0, size.getWidth(), size.getHeight());
        }
    }

    private static ExifData getExifData(ImageProxy imageProxy) {
        ExifData.Builder builderForDevice = ExifData.builderForDevice();
        imageProxy.getImageInfo().populateExifData(builderForDevice);
        return builderForDevice.setImageWidth(imageProxy.getWidth()).setImageHeight(imageProxy.getHeight()).build();
    }

    private static final class ByteBufferOutputStream extends OutputStream {
        private final ByteBuffer mByteBuffer;

        ByteBufferOutputStream(ByteBuffer byteBuffer) {
            this.mByteBuffer = byteBuffer;
        }

        public void write(int i) throws IOException {
            if (this.mByteBuffer.hasRemaining()) {
                this.mByteBuffer.put((byte) i);
                return;
            }
            throw new EOFException("Output ByteBuffer has no bytes remaining.");
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            Objects.requireNonNull(bArr);
            if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
                throw new IndexOutOfBoundsException();
            } else if (i2 != 0) {
                if (this.mByteBuffer.remaining() >= i2) {
                    this.mByteBuffer.put(bArr, i, i2);
                    return;
                }
                throw new EOFException("Output ByteBuffer has insufficient bytes remaining.");
            }
        }
    }
}
