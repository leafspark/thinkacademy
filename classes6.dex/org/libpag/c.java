package org.libpag;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.hardware.HardwareBuffer;

abstract class c {

    static class a {
        int a;
        int b;
        long c;
        private PAGDecoder d;

        a() {
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean a() {
            return this.d != null;
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean b() {
            return this.a > 0 && this.b > 0;
        }

        /* access modifiers changed from: package-private */
        public synchronized int c() {
            PAGDecoder pAGDecoder;
            pAGDecoder = this.d;
            return pAGDecoder == null ? 0 : pAGDecoder.numFrames();
        }

        /* access modifiers changed from: package-private */
        public synchronized void d() {
            PAGDecoder pAGDecoder = this.d;
            if (pAGDecoder != null) {
                pAGDecoder.release();
                this.d = null;
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void e() {
            d();
            this.a = 0;
            this.b = 0;
            this.c = 0;
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean a(int i) {
            PAGDecoder pAGDecoder;
            pAGDecoder = this.d;
            return pAGDecoder != null && pAGDecoder.checkFrameChanged(i);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean a(int i, HardwareBuffer hardwareBuffer) {
            PAGDecoder pAGDecoder;
            pAGDecoder = this.d;
            return (pAGDecoder == null || hardwareBuffer == null || !pAGDecoder.readFrame(i, hardwareBuffer)) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean a(Bitmap bitmap, int i) {
            PAGDecoder pAGDecoder;
            pAGDecoder = this.d;
            return (pAGDecoder == null || bitmap == null || !pAGDecoder.copyFrameTo(bitmap, i)) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean a(PAGComposition pAGComposition, int i, int i2, float f) {
            boolean z;
            float f2;
            int height;
            if (pAGComposition == null || i <= 0 || i2 <= 0 || f <= 0.0f) {
                z = false;
            } else {
                if (pAGComposition.width() >= pAGComposition.height()) {
                    f2 = ((float) i) * 1.0f;
                    height = pAGComposition.width();
                } else {
                    f2 = ((float) i2) * 1.0f;
                    height = pAGComposition.height();
                }
                PAGDecoder Make = PAGDecoder.Make(pAGComposition, f, f2 / ((float) height));
                this.d = Make;
                this.a = Make.width();
                this.b = this.d.height();
                this.c = pAGComposition.duration();
                z = true;
            }
            return z;
        }
    }

    protected static double a(int i, int i2) {
        if (i2 <= 1 || i < 0) {
            return 0.0d;
        }
        if (i >= i2 - 1) {
            return 1.0d;
        }
        return ((((double) i) * 1.0d) + 0.1d) / ((double) i2);
    }

    protected static Matrix a(int i, int i2, int i3, int i4, int i5) {
        Matrix matrix = new Matrix();
        if (i != 0 && i2 > 0 && i3 > 0 && i4 > 0 && i5 > 0) {
            float f = (float) i4;
            float f2 = (float) i2;
            float f3 = (f * 1.0f) / f2;
            float f4 = (float) i5;
            float f5 = (float) i3;
            float f6 = (1.0f * f4) / f5;
            if (i == 1) {
                matrix.setScale(f3, f6);
            } else if (i != 3) {
                float min = Math.min(f3, f6);
                matrix.setScale(min, min);
                if (f3 < f6) {
                    matrix.postTranslate(0.0f, (f4 - (f5 * min)) * 0.5f);
                } else {
                    matrix.postTranslate((f - (f2 * min)) * 0.5f, 0.0f);
                }
            } else {
                float max = Math.max(f3, f6);
                matrix.setScale(max, max);
                if (f3 > f6) {
                    matrix.postTranslate(0.0f, (f4 - (f5 * max)) * 0.5f);
                } else {
                    matrix.postTranslate((f - (f2 * max)) * 0.5f, 0.0f);
                }
            }
        }
        return matrix;
    }

    private static double a(double d, double d2) {
        return d - (((double) ((int) Math.floor(d / d2))) * d2);
    }

    protected static int a(double d, int i) {
        if (i <= 1) {
            return 0;
        }
        double a2 = a(d, 1.0d);
        if (a2 <= 0.0d && d != 0.0d) {
            a2 += 1.0d;
        }
        int floor = (int) Math.floor(a2 * ((double) i));
        return floor == i ? i - 1 : floor;
    }
}
