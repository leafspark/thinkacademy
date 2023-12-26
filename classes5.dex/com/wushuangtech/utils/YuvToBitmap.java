package com.wushuangtech.utils;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.wushuangtech.library.GlobalHolder;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class YuvToBitmap {
    protected static final int FORMAT_ABGR = 4;
    protected static final int FORMAT_I420 = 5;
    protected static final int FORMAT_NV21 = 1;
    protected static final int FORMAT_RGBA = 3;
    private static final String TAG = "YuvToBitmap";

    public static class VideoFrame {
        public byte[] m_data;
        public int rotate;
        public long timeStamp;
        public byte[] u_data;
        public int u_stride;
        public byte[] v_data;
        public int v_stride;
        public int videoHeight;
        public int videoWidth;
        public byte[] y_data;
        public int y_stride;

        public VideoFrame() {
            this.videoWidth = 0;
            this.videoHeight = 0;
            this.y_data = null;
            this.u_data = null;
            this.v_data = null;
            this.m_data = null;
            this.y_stride = 0;
            this.u_stride = 0;
            this.v_stride = 0;
            this.timeStamp = 0;
            this.rotate = 0;
        }

        public VideoFrame(int i, int i2, byte[] bArr, int i3, int i4, int i5, int i6) {
            this.videoWidth = i;
            this.videoHeight = i2;
            this.m_data = bArr;
            this.y_stride = i3;
            this.u_stride = i4;
            this.v_stride = i5;
            this.timeStamp = 0;
            this.rotate = i6;
        }

        public VideoFrame(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3, int i3, int i4, int i5) {
            this.videoWidth = i;
            this.videoHeight = i2;
            this.m_data = null;
            this.y_data = bArr;
            this.u_data = bArr2;
            this.v_data = bArr3;
            this.y_stride = i3;
            this.u_stride = i4;
            this.v_stride = i5;
            this.timeStamp = 0;
        }
    }

    public static Bitmap getLocalBitmap(VideoFrame videoFrame) {
        return NV21ToBitmap(Nv12ToNv21(GlobalHolder.getInstance().getYuvManager().transToNV12(videoFrame.m_data, 5, videoFrame.videoWidth, videoFrame.videoHeight, false, 0), videoFrame.videoWidth, videoFrame.videoHeight), videoFrame.videoWidth, videoFrame.videoHeight);
    }

    public static Bitmap Yuv420ToBitmap(VideoFrame videoFrame) {
        int i = videoFrame.videoWidth & -16;
        ByteBuffer allocate = ByteBuffer.allocate(((videoFrame.videoHeight * i) * 3) / 2);
        int i2 = 0;
        for (int i3 = 0; i3 < videoFrame.videoHeight; i3++) {
            allocate.put(videoFrame.y_data, i2, i);
            i2 += videoFrame.y_stride;
        }
        int i4 = videoFrame.videoHeight / 2;
        int i5 = i / 2;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < i4; i8++) {
            for (int i9 = 0; i9 < i5; i9++) {
                allocate.put(videoFrame.v_data, i7 + i9, 1);
                allocate.put(videoFrame.u_data, i6 + i9, 1);
            }
            i6 += videoFrame.u_stride;
            i7 += videoFrame.v_stride;
        }
        return NV21ToBitmap(allocate.array(), i, videoFrame.videoHeight);
    }

    public static Bitmap NV21ToBitmap(byte[] bArr, int i, int i2) {
        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, (int[]) null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
        Bitmap decodeByteArray = BitmapFactoryInstrumentation.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return decodeByteArray;
    }

    public static Bitmap I420ToBitmap(byte[] bArr, int i, int i2) {
        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, (int[]) null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
        Bitmap decodeByteArray = BitmapFactoryInstrumentation.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return decodeByteArray;
    }

    public static byte[] Yuv420ToJpegConvert(VideoFrame videoFrame, int i) throws FileNotFoundException {
        byte[] transToNV12 = GlobalHolder.getInstance().getYuvManager().transToNV12(videoFrame.m_data, 5, videoFrame.videoWidth, videoFrame.videoHeight, false, videoFrame.rotate);
        if (videoFrame.rotate == 90 || videoFrame.rotate == 270) {
            byte[] Nv12ToNv21 = Nv12ToNv21(transToNV12, videoFrame.videoHeight, videoFrame.videoWidth);
            if (Nv12ToNv21 != null) {
                return NV21ToJpeg(Nv12ToNv21, videoFrame.videoHeight, videoFrame.videoWidth, i);
            }
            return null;
        }
        byte[] Nv12ToNv212 = Nv12ToNv21(transToNV12, videoFrame.videoWidth, videoFrame.videoHeight);
        if (Nv12ToNv212 != null) {
            return NV21ToJpeg(Nv12ToNv212, videoFrame.videoWidth, videoFrame.videoHeight, i);
        }
        return null;
    }

    public static byte[] NV21ToJpeg(byte[] bArr, int i, int i2, int i3) throws FileNotFoundException {
        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, (int[]) null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        if (!yuvImage.compressToJpeg(new Rect(0, 0, i, i2), i3, byteArrayOutputStream)) {
            OmniLog.e(TAG, "NV21ToJpeg error...");
            return null;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArray;
    }

    public static byte[] Nv12ToNv21(byte[] bArr, int i, int i2) {
        int i3;
        if (bArr == null) {
            return null;
        }
        int i4 = i * i2;
        byte[] bArr2 = new byte[((i4 * 3) / 2)];
        System.arraycopy(bArr, 0, bArr2, 0, i4);
        int i5 = 0;
        while (true) {
            i3 = i4 / 2;
            if (i5 >= i3) {
                break;
            }
            int i6 = i4 + i5;
            bArr2[i6 - 1] = bArr[i6];
            i5 += 2;
        }
        for (int i7 = 0; i7 < i3; i7 += 2) {
            int i8 = i4 + i7;
            bArr2[i8] = bArr[i8 - 1];
        }
        return bArr2;
    }

    public static void backyuv(byte[] bArr, int i, int i2, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str, true);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
