package com.wushuangtech.handler;

import android.text.TextUtils;
import com.wushuangtech.inter.OnVideoCameraPreviewFrameListener;
import com.wushuangtech.jni.RoomJni;
import com.wushuangtech.jni.callback.BaseRtcChannelSignalCallBack;
import com.wushuangtech.library.video.bean.VideoFrame;
import com.wushuangtech.utils.OmniLog;
import java.util.Arrays;

public class ContentInspectHandler extends BaseRtcChannelSignalCallBack implements OnVideoCameraPreviewFrameListener {
    private static final String TAG = "ContentInspectHandler";
    private boolean mEnabled;
    private final Object mLock = new Object();
    private VideoFrame mVideoFrame;

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0074, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int enableContentInspect(boolean r8, int r9) {
        /*
            r7 = this;
            r0 = 1000(0x3e8, float:1.401E-42)
            int r9 = r9 * r0
            if (r9 >= r0) goto L_0x0007
            r9 = 10000(0x2710, float:1.4013E-41)
        L_0x0007:
            java.lang.Object r0 = r7.mLock
            monitor-enter(r0)
            com.wushuangtech.jni.RoomJni r1 = com.wushuangtech.jni.RoomJni.getInstance()     // Catch:{ all -> 0x0075 }
            com.wushuangtech.jni.RoomJni$RoomNativeEvent r2 = com.wushuangtech.jni.RoomJni.RoomNativeEvent.ENABLE_REPORT_IMAGE     // Catch:{ all -> 0x0075 }
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0075 }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r8)     // Catch:{ all -> 0x0075 }
            r5 = 0
            r3[r5] = r4     // Catch:{ all -> 0x0075 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0075 }
            r6 = 1
            r3[r6] = r4     // Catch:{ all -> 0x0075 }
            r1.invokeNativeMethod(r2, r3)     // Catch:{ all -> 0x0075 }
            if (r8 == 0) goto L_0x0053
            boolean r8 = r7.mEnabled     // Catch:{ all -> 0x0075 }
            if (r8 == 0) goto L_0x002c
            monitor-exit(r0)     // Catch:{ all -> 0x0075 }
            return r5
        L_0x002c:
            r7.mEnabled = r6     // Catch:{ all -> 0x0075 }
            com.wushuangtech.library.GlobalHolder r8 = com.wushuangtech.library.GlobalHolder.getInstance()     // Catch:{ all -> 0x0075 }
            r8.addOnVideoCameraPreviewFrameListener(r7)     // Catch:{ all -> 0x0075 }
            com.wushuangtech.jni.RoomJni r8 = com.wushuangtech.jni.RoomJni.getInstance()     // Catch:{ all -> 0x0075 }
            r8.addCallback(r7)     // Catch:{ all -> 0x0075 }
            java.lang.String r8 = TAG     // Catch:{ all -> 0x0075 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0075 }
            r1.<init>()     // Catch:{ all -> 0x0075 }
            java.lang.String r2 = "Enable content inspect, interval = "
            r1.append(r2)     // Catch:{ all -> 0x0075 }
            r1.append(r9)     // Catch:{ all -> 0x0075 }
            java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x0075 }
            com.wushuangtech.utils.OmniLog.i(r8, r9)     // Catch:{ all -> 0x0075 }
            goto L_0x0073
        L_0x0053:
            boolean r8 = r7.mEnabled     // Catch:{ all -> 0x0075 }
            if (r8 != 0) goto L_0x0059
            monitor-exit(r0)     // Catch:{ all -> 0x0075 }
            return r5
        L_0x0059:
            r7.mEnabled = r5     // Catch:{ all -> 0x0075 }
            r8 = 0
            r7.mVideoFrame = r8     // Catch:{ all -> 0x0075 }
            com.wushuangtech.jni.RoomJni r8 = com.wushuangtech.jni.RoomJni.getInstance()     // Catch:{ all -> 0x0075 }
            r8.removeCallback(r7)     // Catch:{ all -> 0x0075 }
            com.wushuangtech.library.GlobalHolder r8 = com.wushuangtech.library.GlobalHolder.getInstance()     // Catch:{ all -> 0x0075 }
            r8.removeOnVideoCameraPreviewFrameListener(r7)     // Catch:{ all -> 0x0075 }
            java.lang.String r8 = TAG     // Catch:{ all -> 0x0075 }
            java.lang.String r9 = "Disable content inspect!"
            com.wushuangtech.utils.OmniLog.i(r8, r9)     // Catch:{ all -> 0x0075 }
        L_0x0073:
            monitor-exit(r0)     // Catch:{ all -> 0x0075 }
            return r5
        L_0x0075:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0075 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.handler.ContentInspectHandler.enableContentInspect(boolean, int):int");
    }

    public int contentInspectExtra(String str, int[] iArr) {
        synchronized (this.mLock) {
            if (!this.mEnabled) {
                return 0;
            }
            if (!TextUtils.isEmpty(str)) {
                if (iArr != null) {
                    String str2 = TAG;
                    OmniLog.i(str2, "Set content inspect extra, arguments = " + str + ", rate = " + Arrays.toString(iArr));
                    Object invokeNativeMethod = RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.SET_REPORT_IMAGE_PARAMS, str, iArr);
                    if (invokeNativeMethod == null) {
                        return 0;
                    }
                    int intValue = ((Integer) invokeNativeMethod).intValue();
                    return intValue;
                }
            }
            return -5;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void OnReportImageFireEvent() {
        /*
            r13 = this;
            java.lang.Object r0 = r13.mLock
            monitor-enter(r0)
            com.wushuangtech.library.video.bean.VideoFrame r1 = r13.mVideoFrame     // Catch:{ all -> 0x0095 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0095 }
            return
        L_0x0009:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0095 }
            int r10 = r1.width     // Catch:{ all -> 0x0095 }
            int r11 = r1.height     // Catch:{ all -> 0x0095 }
            int r4 = r1.mRotate     // Catch:{ all -> 0x0095 }
            r5 = 180(0xb4, float:2.52E-43)
            if (r4 != r5) goto L_0x001f
            byte[] r4 = r1.data     // Catch:{ all -> 0x0095 }
            byte[] r4 = rotateYUV420Degree180(r4, r10, r11)     // Catch:{ all -> 0x0095 }
            r1.data = r4     // Catch:{ all -> 0x0095 }
        L_0x001f:
            android.graphics.YuvImage r12 = new android.graphics.YuvImage     // Catch:{ all -> 0x0095 }
            byte[] r5 = r1.data     // Catch:{ all -> 0x0095 }
            r6 = 17
            r9 = 0
            r4 = r12
            r7 = r10
            r8 = r11
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0095 }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0095 }
            byte[] r5 = r1.data     // Catch:{ all -> 0x0095 }
            int r5 = r5.length     // Catch:{ all -> 0x0095 }
            r4.<init>(r5)     // Catch:{ all -> 0x0095 }
            int r5 = com.wushuangtech.library.GlobalConfig.mJpgQuality     // Catch:{ all -> 0x0095 }
            r6 = 100
            if (r5 < 0) goto L_0x003c
            if (r5 <= r6) goto L_0x003d
        L_0x003c:
            r5 = r6
        L_0x003d:
            android.graphics.Rect r6 = new android.graphics.Rect     // Catch:{ all -> 0x0095 }
            r7 = 0
            r6.<init>(r7, r7, r10, r11)     // Catch:{ all -> 0x0095 }
            boolean r5 = r12.compressToJpeg(r6, r5, r4)     // Catch:{ all -> 0x0095 }
            if (r5 != 0) goto L_0x0052
            java.lang.String r1 = TAG     // Catch:{ all -> 0x0095 }
            java.lang.String r2 = "Compress jpeg failed..."
            com.wushuangtech.utils.OmniLog.e(r1, r2)     // Catch:{ all -> 0x0095 }
            monitor-exit(r0)     // Catch:{ all -> 0x0095 }
            return
        L_0x0052:
            java.lang.String r5 = TAG     // Catch:{ all -> 0x0095 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0095 }
            r6.<init>()     // Catch:{ all -> 0x0095 }
            java.lang.String r8 = "Send image data, frame = "
            r6.append(r8)     // Catch:{ all -> 0x0095 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0095 }
            r6.append(r1)     // Catch:{ all -> 0x0095 }
            java.lang.String r1 = ", compress time = "
            r6.append(r1)     // Catch:{ all -> 0x0095 }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0095 }
            long r8 = r8 - r2
            r6.append(r8)     // Catch:{ all -> 0x0095 }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x0095 }
            com.wushuangtech.utils.OmniLog.i(r5, r1)     // Catch:{ all -> 0x0095 }
            byte[] r1 = r4.toByteArray()     // Catch:{ all -> 0x0095 }
            com.wushuangtech.jni.RoomJni r2 = com.wushuangtech.jni.RoomJni.getInstance()     // Catch:{ all -> 0x0095 }
            com.wushuangtech.jni.RoomJni$RoomNativeEvent r3 = com.wushuangtech.jni.RoomJni.RoomNativeEvent.SEND_IMAGE_DATA     // Catch:{ all -> 0x0095 }
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0095 }
            r4[r7] = r1     // Catch:{ all -> 0x0095 }
            r5 = 1
            int r1 = r1.length     // Catch:{ all -> 0x0095 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0095 }
            r4[r5] = r1     // Catch:{ all -> 0x0095 }
            r2.invokeNativeMethod(r3, r4)     // Catch:{ all -> 0x0095 }
            monitor-exit(r0)     // Catch:{ all -> 0x0095 }
            return
        L_0x0095:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0095 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.handler.ContentInspectHandler.OnReportImageFireEvent():void");
    }

    public void onPreviewFrame(byte[] bArr, int i, int i2, int i3, long j) {
        synchronized (this.mLock) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            if (this.mVideoFrame == null) {
                this.mVideoFrame = new VideoFrame();
            }
            if (!(this.mVideoFrame.width == i && this.mVideoFrame.height == i2 && this.mVideoFrame.mRotate == i3)) {
                this.mVideoFrame.width = i;
                this.mVideoFrame.height = i2;
                this.mVideoFrame.mRotate = i3;
            }
            this.mVideoFrame.data = bArr2;
        }
    }

    private static byte[] rotateYUV420Degree180(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = (i3 * 3) / 2;
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        for (int i6 = i3 - 1; i6 >= 0; i6--) {
            bArr2[i5] = bArr[i6];
            i5++;
        }
        for (int i7 = i4 - 1; i7 >= i3; i7 -= 2) {
            int i8 = i5 + 1;
            bArr2[i5] = bArr[i7 - 1];
            i5 = i8 + 1;
            bArr2[i8] = bArr[i7];
        }
        return bArr2;
    }
}
