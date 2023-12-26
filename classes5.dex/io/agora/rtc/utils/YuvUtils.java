package io.agora.rtc.utils;

import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import android.util.Log;
import io.agora.rtc.gl.JavaI420Buffer;
import io.agora.rtc.gl.VideoFrame;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class YuvUtils {
    public static final int I420 = 35;
    public static final int NV21 = 17;
    private static final String TAG = "YuvUtils";

    public static boolean supportedImageFormat(Image image) {
        int format = image.getFormat();
        return format == 17 || format == 35 || format == 842094169;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] getImageData(android.media.Image r20, int r21) {
        /*
            r0 = r21
            r1 = 17
            r2 = 35
            if (r0 == r2) goto L_0x0013
            if (r0 != r1) goto L_0x000b
            goto L_0x0013
        L_0x000b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "only support COLOR_FormatI420 and COLOR_FormatNV21"
            r0.<init>(r1)
            throw r0
        L_0x0013:
            boolean r3 = supportedImageFormat(r20)
            if (r3 == 0) goto L_0x00de
            android.graphics.Rect r3 = r20.getCropRect()
            int r4 = r20.getFormat()
            int r5 = r3.width()
            int r6 = r3.height()
            android.media.Image$Plane[] r7 = r20.getPlanes()
            int r8 = r5 * r6
            int r4 = android.graphics.ImageFormat.getBitsPerPixel(r4)
            int r4 = r4 * r8
            int r4 = r4 / 8
            byte[] r4 = new byte[r4]
            r9 = 0
            r10 = r7[r9]
            int r10 = r10.getRowStride()
            byte[] r10 = new byte[r10]
            r11 = 1
            r12 = r9
            r13 = r12
            r14 = r11
        L_0x0045:
            int r15 = r7.length
            if (r12 >= r15) goto L_0x00dd
            r15 = 2
            if (r12 == 0) goto L_0x0066
            if (r12 == r11) goto L_0x005c
            if (r12 == r15) goto L_0x0050
            goto L_0x0068
        L_0x0050:
            if (r0 != r2) goto L_0x0058
            double r13 = (double) r8
            r15 = 4608308318706860032(0x3ff4000000000000, double:1.25)
            double r13 = r13 * r15
            int r13 = (int) r13
            goto L_0x0067
        L_0x0058:
            if (r0 != r1) goto L_0x0068
            r13 = r8
            goto L_0x0064
        L_0x005c:
            if (r0 != r2) goto L_0x0060
            r13 = r8
            goto L_0x0067
        L_0x0060:
            if (r0 != r1) goto L_0x0068
            int r13 = r8 + 1
        L_0x0064:
            r14 = r15
            goto L_0x0068
        L_0x0066:
            r13 = r9
        L_0x0067:
            r14 = r11
        L_0x0068:
            r15 = r7[r12]
            java.nio.ByteBuffer r15 = r15.getBuffer()
            r16 = r7[r12]
            int r16 = r16.getRowStride()
            r17 = r7[r12]
            int r1 = r17.getPixelStride()
            if (r12 != 0) goto L_0x007f
            r17 = r9
            goto L_0x0081
        L_0x007f:
            r17 = r11
        L_0x0081:
            int r2 = r5 >> r17
            int r9 = r6 >> r17
            int r11 = r3.top
            int r11 = r11 >> r17
            int r11 = r11 * r16
            int r0 = r3.left
            int r0 = r0 >> r17
            int r0 = r0 * r1
            int r11 = r11 + r0
            r15.position(r11)
            r0 = 0
        L_0x0095:
            if (r0 >= r9) goto L_0x00cf
            r11 = 1
            if (r1 != r11) goto L_0x00a4
            if (r14 != r11) goto L_0x00a4
            r15.get(r4, r13, r2)
            int r13 = r13 + r2
            r18 = r3
            r3 = r2
            goto L_0x00bc
        L_0x00a4:
            int r17 = r2 + -1
            int r17 = r17 * r1
            r18 = r3
            int r3 = r17 + 1
            r11 = 0
            r15.get(r10, r11, r3)
        L_0x00b0:
            if (r11 >= r2) goto L_0x00bc
            int r19 = r11 * r1
            byte r19 = r10[r19]
            r4[r13] = r19
            int r13 = r13 + r14
            int r11 = r11 + 1
            goto L_0x00b0
        L_0x00bc:
            int r11 = r9 + -1
            if (r0 >= r11) goto L_0x00ca
            int r11 = r15.position()
            int r11 = r11 + r16
            int r11 = r11 - r3
            r15.position(r11)
        L_0x00ca:
            int r0 = r0 + 1
            r3 = r18
            goto L_0x0095
        L_0x00cf:
            r18 = r3
            int r12 = r12 + 1
            r0 = r21
            r1 = 17
            r2 = 35
            r9 = 0
            r11 = 1
            goto L_0x0045
        L_0x00dd:
            return r4
        L_0x00de:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "can't convert Image to byte array, format "
            r1.append(r2)
            int r2 = r20.getFormat()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.utils.YuvUtils.getImageData(android.media.Image, int):byte[]");
    }

    public static boolean writeNV21ToFile(byte[] bArr, int i, int i2, String str) {
        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, (int[]) null);
        Rect rect = new Rect(0, 0, i, i2);
        try {
            File file = new File(str);
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            yuvImage.compressToJpeg(rect, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            Log.e(TAG, e.toString());
            return false;
        }
    }

    public static void writeRawData(byte[] bArr, String str) {
        if (bArr != null && bArr.length != 0) {
            try {
                File file = new File(str);
                file.createNewFile();
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                bufferedOutputStream.write(bArr);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            } catch (IOException e) {
                Log.e(TAG, e.toString());
            }
        }
    }

    public static void write420ImageToFile(Image image, String str) {
        if (image != null) {
            try {
                YuvImage yuvImage = new YuvImage(yuv420toNV21(image), 17, image.getWidth(), image.getHeight(), (int[]) null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                yuvImage.compressToJpeg(new Rect(0, 0, image.getWidth(), image.getHeight()), 100, byteArrayOutputStream);
                File file = new File(str);
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e) {
                Log.e(TAG, e.toString());
            }
        }
    }

    public static byte[] yuv420toNV21(Image image) {
        int i;
        Rect cropRect = image.getCropRect();
        int format = image.getFormat();
        int width = cropRect.width();
        int height = cropRect.height();
        Image.Plane[] planes = image.getPlanes();
        int i2 = width * height;
        byte[] bArr = new byte[((ImageFormat.getBitsPerPixel(format) * i2) / 8)];
        int i3 = 0;
        byte[] bArr2 = new byte[planes[0].getRowStride()];
        int i4 = 1;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1;
        while (i5 < planes.length) {
            if (i5 != 0) {
                if (i5 == i4) {
                    i6 = i2 + 1;
                } else if (i5 == 2) {
                    i6 = i2;
                }
                i7 = 2;
            } else {
                i6 = i3;
                i7 = i4;
            }
            ByteBuffer buffer = planes[i5].getBuffer();
            int rowStride = planes[i5].getRowStride();
            int pixelStride = planes[i5].getPixelStride();
            int i8 = i5 == 0 ? i3 : i4;
            int i9 = width >> i8;
            int i10 = height >> i8;
            int i11 = width;
            int i12 = height;
            buffer.position(((cropRect.top >> i8) * rowStride) + ((cropRect.left >> i8) * pixelStride));
            for (int i13 = 0; i13 < i10; i13++) {
                if (pixelStride == 1 && i7 == 1) {
                    buffer.get(bArr, i6, i9);
                    i6 += i9;
                    i = i9;
                } else {
                    i = ((i9 - 1) * pixelStride) + 1;
                    buffer.get(bArr2, 0, i);
                    for (int i14 = 0; i14 < i9; i14++) {
                        bArr[i6] = bArr2[i14 * pixelStride];
                        i6 += i7;
                    }
                }
                if (i13 < i10 - 1) {
                    buffer.position((buffer.position() + rowStride) - i);
                }
            }
            i5++;
            width = i11;
            height = i12;
            i3 = 0;
            i4 = 1;
        }
        return bArr;
    }

    static class Plane {
        private ByteBuffer buffer;
        private int pixelStride;
        private int rowStride;

        public Plane(ByteBuffer byteBuffer, int i, int i2) {
            this.buffer = byteBuffer;
            this.rowStride = i;
            this.pixelStride = i2;
        }

        public ByteBuffer getBuffer() {
            return this.buffer;
        }

        public int getRowStride() {
            return this.rowStride;
        }

        public int getPixelStride() {
            return this.pixelStride;
        }
    }

    public static byte[] yuv420toNV21(byte[] bArr, int i, int i2) {
        return yuv420toNV21((VideoFrame.I420Buffer) JavaI420Buffer.createYUV(bArr, i, i2), i, i2);
    }

    public static byte[] yuv420toNV21(VideoFrame.I420Buffer i420Buffer, int i, int i2) {
        int i3;
        int i4 = i;
        int i5 = i2;
        int i6 = 0;
        Rect rect = new Rect(0, 0, i4, i5);
        int i7 = 3;
        int i8 = 1;
        int i9 = 2;
        Plane[] planeArr = {new Plane(i420Buffer.getDataY(), i420Buffer.getStrideY(), 1), new Plane(i420Buffer.getDataU(), i420Buffer.getStrideU(), 1), new Plane(i420Buffer.getDataV(), i420Buffer.getStrideV(), 1)};
        int i10 = i4 * i5;
        byte[] bArr = new byte[((ImageFormat.getBitsPerPixel(35) * i10) / 8)];
        byte[] bArr2 = new byte[planeArr[0].getRowStride()];
        int i11 = 0;
        int i12 = 0;
        int i13 = 1;
        while (i11 < i7) {
            if (i11 == 0) {
                i12 = i6;
                i13 = i8;
            } else if (i11 == i8) {
                i12 = i10 + 1;
                i13 = i9;
            } else if (i11 == i9) {
                i13 = i9;
                i12 = i10;
            }
            ByteBuffer buffer = planeArr[i11].getBuffer();
            int rowStride = planeArr[i11].getRowStride();
            int pixelStride = planeArr[i11].getPixelStride();
            int i14 = i11 == 0 ? i6 : i8;
            int i15 = i4 >> i14;
            int i16 = i5 >> i14;
            buffer.position(((rect.top >> i14) * rowStride) + ((rect.left >> i14) * pixelStride));
            int i17 = 0;
            while (i17 < i16) {
                if (pixelStride == 1 && i13 == 1) {
                    buffer.get(bArr, i12, i15);
                    i12 += i15;
                    i3 = i15;
                } else {
                    i3 = ((i15 - 1) * pixelStride) + 1;
                    buffer.get(bArr2, 0, i3);
                    for (int i18 = 0; i18 < i15; i18++) {
                        bArr[i12] = bArr2[i18 * pixelStride];
                        i12 += i13;
                    }
                }
                if (i17 < i16 - 1) {
                    buffer.position((buffer.position() + rowStride) - i3);
                }
                i17++;
                int i19 = i2;
            }
            i11++;
            i4 = i;
            i5 = i2;
            i6 = 0;
            i7 = 3;
            i9 = 2;
            i8 = 1;
        }
        return bArr;
    }

    public static void writeRgbaToFile(Buffer buffer, int i, int i2, String str) {
        try {
            File file = new File(str);
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(buffer);
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 50, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            Log.e(TAG, e.toString());
        }
    }
}
