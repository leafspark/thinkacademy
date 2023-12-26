package org.libpag;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.extra.tools.a;
import org.libpag.PAGAnimator;
import org.libpag.PAGFile;
import org.libpag.c;

public class PAGImageView extends View implements PAGAnimator.Listener {
    private volatile int A;
    private volatile int B;
    Paint C = null;
    private volatile boolean D = false;
    private volatile boolean E = false;
    private AtomicBoolean F = new AtomicBoolean(true);
    private boolean G = false;
    private PAGAnimator a;
    private float b = 30.0f;
    private final AtomicBoolean c = new AtomicBoolean(false);
    protected volatile c.a d = new c.a();
    private final Object e = new Object();
    private volatile Bitmap f;
    private volatile Bitmap g;
    private volatile HardwareBuffer h;
    private volatile Bitmap i;
    private volatile HardwareBuffer j;
    private Matrix k;
    private final ConcurrentHashMap l = new ConcurrentHashMap();
    private String m;
    private PAGComposition n;
    private int o = 2;
    private volatile Matrix p;
    private float q = 1.0f;
    private boolean r = false;
    private volatile boolean s = false;
    private int t;
    private int u = 0;
    int v = -1;
    long w = 0;
    private final ArrayList x = new ArrayList();
    private volatile int y;
    private volatile int z;

    public interface PAGImageViewListener {
        void onAnimationCancel(PAGImageView pAGImageView);

        void onAnimationEnd(PAGImageView pAGImageView);

        void onAnimationRepeat(PAGImageView pAGImageView);

        void onAnimationStart(PAGImageView pAGImageView);

        void onAnimationUpdate(PAGImageView pAGImageView);
    }

    static {
        a.b("pag");
    }

    public PAGImageView(Context context) {
        super(context);
        e();
    }

    private static native int ContentVersion(PAGComposition pAGComposition);

    @Deprecated
    public static long MaxDiskCache() {
        return PAGDiskCache.MaxDiskSize();
    }

    @Deprecated
    public static void SetMaxDiskCache(long j2) {
        PAGDiskCache.SetMaxDiskSize(j2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, float f2, PAGFile.LoadListener loadListener) {
        setPath(str, f2);
        if (loadListener != null) {
            loadListener.onLoad((PAGFile) this.n);
        }
    }

    private void b() {
        PAGComposition pAGComposition;
        boolean z2 = true;
        boolean z3 = false;
        if (this.s) {
            this.s = false;
            z3 = true;
        }
        if (this.m == null && (pAGComposition = this.n) != null) {
            int ContentVersion = ContentVersion(pAGComposition);
            int i2 = this.v;
            if (i2 < 0 || i2 == ContentVersion) {
                z2 = z3;
            }
            this.v = ContentVersion;
            z3 = z2;
        }
        if (z3) {
            this.l.clear();
            if (!this.d.a()) {
                PAGComposition pAGComposition2 = this.n;
                if (pAGComposition2 == null) {
                    pAGComposition2 = a(this.m);
                }
                this.d.a(pAGComposition2, this.y, this.z, this.b);
            }
        }
    }

    private void c() {
        boolean z2 = this.D && isShown() && d();
        if (this.G != z2) {
            this.G = z2;
            if (z2) {
                PAGComposition pAGComposition = this.n;
                this.a.setDuration(pAGComposition != null ? pAGComposition.duration() : this.w);
                this.a.update();
                return;
            }
            this.a.setDuration(0);
        }
    }

    private boolean d() {
        return this.y > 0 && this.z > 0;
    }

    private void e() {
        this.C = new Paint(6);
        this.a = PAGAnimator.a(getContext(), this);
    }

    private void g() {
        int i2 = this.o;
        if (i2 != 0) {
            this.p = c.a(i2, this.d.a, this.d.b, this.y, this.z);
        }
    }

    private void h() {
        if (!this.d.b() && this.u == 0 && this.y > 0) {
            f();
        }
        if (this.d.b() && this.d.a()) {
            this.u = this.d.c();
        }
    }

    private void i() {
        synchronized (this.e) {
            this.f = null;
            this.g = null;
            this.i = null;
            if (Build.VERSION.SDK_INT >= 26) {
                if (this.h != null) {
                    this.h.close();
                    this.h = null;
                }
                if (this.j != null) {
                    this.j.close();
                    this.j = null;
                }
            }
        }
    }

    private void j() {
        if (a()) {
            this.d.d();
        }
    }

    public void addListener(PAGImageViewListener pAGImageViewListener) {
        synchronized (this) {
            this.x.add(pAGImageViewListener);
        }
    }

    public boolean cacheAllFramesInMemory() {
        return this.r;
    }

    public int currentFrame() {
        return this.t;
    }

    public Bitmap currentImage() {
        return this.f;
    }

    /* access modifiers changed from: protected */
    public void f() {
        synchronized (this.d) {
            if (!this.d.b()) {
                if (this.n == null) {
                    this.n = a(this.m);
                }
                if (this.d.a(this.n, this.y, this.z, this.b) && this.m != null) {
                    this.n = null;
                }
                if (!this.d.b()) {
                    return;
                }
            }
            g();
            this.c.set(false);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        super.finalize();
    }

    public boolean flush() {
        if (!this.d.b()) {
            f();
            if (!this.d.b()) {
                postInvalidate();
                return false;
            }
        }
        if (this.d.a()) {
            this.u = this.d.c();
        }
        int a2 = c.a(this.a.progress(), this.u);
        this.t = a2;
        if (!a(a2)) {
            this.E = false;
            return false;
        }
        this.E = false;
        postInvalidate();
        return true;
    }

    public PAGComposition getComposition() {
        if (this.m != null) {
            return null;
        }
        return this.n;
    }

    public String getPath() {
        return this.m;
    }

    public boolean isPlaying() {
        return this.a.isRunning();
    }

    public Matrix matrix() {
        return this.p;
    }

    public int numFrames() {
        h();
        return this.u;
    }

    public void onAnimationCancel(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.x);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGImageViewListener) it.next()).onAnimationCancel(this);
        }
    }

    public void onAnimationEnd(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.x);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGImageViewListener) it.next()).onAnimationEnd(this);
        }
    }

    public void onAnimationRepeat(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.x);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGImageViewListener) it.next()).onAnimationRepeat(this);
        }
    }

    public void onAnimationStart(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.x);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGImageViewListener) it.next()).onAnimationStart(this);
        }
    }

    public void onAnimationUpdate(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        PAGComposition pAGComposition;
        if (this.D) {
            if (this.G && (pAGComposition = this.n) != null) {
                pAGAnimator.setDuration(pAGComposition.duration());
            }
            flush();
            synchronized (this) {
                arrayList = new ArrayList(this.x);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((PAGImageViewListener) it.next()).onAnimationUpdate(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        this.D = true;
        super.onAttachedToWindow();
        c();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.D = false;
        super.onDetachedFromWindow();
        c();
        this.d.e();
        if (this.a.isRunning()) {
            i();
        }
        this.l.clear();
        this.v = -1;
        this.s = false;
        this.c.set(false);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!this.c.get() && this.f != null && !this.f.isRecycled()) {
            super.onDraw(canvas);
            int saveCount = canvas.getSaveCount();
            canvas.save();
            Matrix matrix = this.k;
            if (matrix != null) {
                canvas.concat(matrix);
            }
            if (this.p != null) {
                canvas.concat(this.p);
            }
            try {
                canvas.drawBitmap(this.f, 0.0f, 0.0f, this.C);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            canvas.restoreToCount(saveCount);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.c.set(true);
        this.d.e();
        this.A = i2;
        this.B = i3;
        this.y = (int) (this.q * ((float) i2));
        this.z = (int) (this.q * ((float) i3));
        i();
        this.E = true;
        c();
    }

    public void onVisibilityAggregated(boolean z2) {
        super.onVisibilityAggregated(z2);
        c();
    }

    public void pause() {
        this.a.cancel();
    }

    public void play() {
        this.a.a();
    }

    public void removeListener(PAGImageViewListener pAGImageViewListener) {
        synchronized (this) {
            this.x.remove(pAGImageViewListener);
        }
    }

    public float renderScale() {
        return this.q;
    }

    public int repeatCount() {
        return this.a.repeatCount();
    }

    public int scaleMode() {
        return this.o;
    }

    public void setCacheAllFramesInMemory(boolean z2) {
        this.s = z2 != this.r;
        this.r = z2;
    }

    public void setComposition(PAGComposition pAGComposition) {
        setComposition(pAGComposition, 30.0f);
    }

    public void setCurrentFrame(int i2) {
        int i3;
        h();
        if (this.u != 0 && this.d.b() && i2 >= 0 && i2 < (i3 = this.u)) {
            this.t = i2;
            this.a.setProgress(c.a(i2, i3));
            this.a.update();
        }
    }

    public void setMatrix(Matrix matrix) {
        this.p = matrix;
        this.o = 0;
        if (d()) {
            postInvalidate();
        }
    }

    public boolean setPath(String str) {
        return setPath(str, 30.0f);
    }

    public void setPathAsync(String str, PAGFile.LoadListener loadListener) {
        setPathAsync(str, 30.0f, loadListener);
    }

    public void setRenderScale(float f2) {
        if (this.q != f2) {
            if (f2 < 0.0f || f2 > 1.0f) {
                f2 = 1.0f;
            }
            this.q = f2;
            this.y = (int) (((float) this.A) * f2);
            this.z = (int) (((float) this.B) * f2);
            g();
            if (f2 < 1.0f) {
                Matrix matrix = new Matrix();
                this.k = matrix;
                float f3 = 1.0f / f2;
                matrix.setScale(f3, f3);
            }
        }
    }

    public void setRepeatCount(int i2) {
        this.a.setRepeatCount(i2);
    }

    public void setScaleMode(int i2) {
        if (i2 != this.o) {
            this.o = i2;
            if (d()) {
                g();
                postInvalidate();
                return;
            }
            this.p = null;
        }
    }

    public void setComposition(PAGComposition pAGComposition, float f2) {
        a((String) null, pAGComposition, f2);
    }

    public boolean setPath(String str, float f2) {
        PAGComposition a2 = a(str);
        a(str, a2, f2);
        return a2 != null;
    }

    public void setPathAsync(String str, float f2, PAGFile.LoadListener loadListener) {
        NativeTask.Run(new PAGImageView$$ExternalSyntheticLambda0(this, str, f2, loadListener));
    }

    private PAGComposition a(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("assets://")) {
            return PAGFile.Load(getContext().getAssets(), str.substring(9));
        }
        return PAGFile.Load(str);
    }

    private void a(String str, PAGComposition pAGComposition, float f2) {
        this.c.set(true);
        this.d.e();
        this.b = f2;
        this.p = null;
        i();
        this.m = str;
        this.n = pAGComposition;
        this.t = 0;
        this.a.setProgress(pAGComposition == null ? 0.0d : pAGComposition.getProgress());
        PAGComposition pAGComposition2 = this.n;
        long duration = pAGComposition2 == null ? 0 : pAGComposition2.duration();
        this.w = duration;
        if (this.G) {
            this.a.setDuration(duration);
        }
        this.a.update();
    }

    private boolean a() {
        if (this.d.b() && this.d.a()) {
            this.u = this.d.c();
        }
        return this.l.size() == this.u;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00e5, code lost:
        if (r7.r == false) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00e9, code lost:
        if (r7.f == null) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00eb, code lost:
        r7.l.put(java.lang.Integer.valueOf(r8), r7.f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00f6, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(int r8) {
        /*
            r7 = this;
            org.libpag.c$a r0 = r7.d
            boolean r0 = r0.b()
            r1 = 0
            if (r0 == 0) goto L_0x00fa
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.c
            boolean r0 = r0.get()
            if (r0 == 0) goto L_0x0013
            goto L_0x00fa
        L_0x0013:
            r7.b()
            r7.j()
            java.util.concurrent.ConcurrentHashMap r0 = r7.l
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            java.lang.Object r0 = r0.get(r2)
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            r2 = 1
            if (r0 == 0) goto L_0x002b
            r7.f = r0
            return r2
        L_0x002b:
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.c
            boolean r0 = r0.get()
            if (r0 == 0) goto L_0x0034
            return r1
        L_0x0034:
            org.libpag.c$a r0 = r7.d
            boolean r0 = r0.a()
            if (r0 != 0) goto L_0x003d
            return r1
        L_0x003d:
            boolean r0 = r7.E
            if (r0 != 0) goto L_0x004a
            org.libpag.c$a r0 = r7.d
            boolean r0 = r0.a(r8)
            if (r0 != 0) goto L_0x004a
            return r2
        L_0x004a:
            java.lang.Object r0 = r7.e
            monitor-enter(r0)
            android.graphics.Bitmap r3 = r7.g     // Catch:{ all -> 0x00f7 }
            r4 = 26
            if (r3 == 0) goto L_0x0057
            boolean r3 = r7.r     // Catch:{ all -> 0x00f7 }
            if (r3 == 0) goto L_0x0077
        L_0x0057:
            org.libpag.c$a r3 = r7.d     // Catch:{ all -> 0x00f7 }
            int r3 = r3.a     // Catch:{ all -> 0x00f7 }
            org.libpag.c$a r5 = r7.d     // Catch:{ all -> 0x00f7 }
            int r5 = r5.b     // Catch:{ all -> 0x00f7 }
            android.util.Pair r3 = org.libpag.a.a(r3, r5, r1)     // Catch:{ all -> 0x00f7 }
            java.lang.Object r5 = r3.first     // Catch:{ all -> 0x00f7 }
            if (r5 != 0) goto L_0x0069
            monitor-exit(r0)     // Catch:{ all -> 0x00f7 }
            return r1
        L_0x0069:
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5     // Catch:{ all -> 0x00f7 }
            r7.g = r5     // Catch:{ all -> 0x00f7 }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00f7 }
            if (r5 < r4) goto L_0x0077
            java.lang.Object r3 = r3.second     // Catch:{ all -> 0x00f7 }
            android.hardware.HardwareBuffer r3 = (android.hardware.HardwareBuffer) r3     // Catch:{ all -> 0x00f7 }
            r7.h = r3     // Catch:{ all -> 0x00f7 }
        L_0x0077:
            android.graphics.Bitmap r3 = r7.g     // Catch:{ all -> 0x00f7 }
            if (r3 != 0) goto L_0x007d
            monitor-exit(r0)     // Catch:{ all -> 0x00f7 }
            return r1
        L_0x007d:
            boolean r3 = r7.r     // Catch:{ all -> 0x00f7 }
            if (r3 != 0) goto L_0x00c3
            android.graphics.Bitmap r3 = r7.i     // Catch:{ all -> 0x00f7 }
            if (r3 != 0) goto L_0x00a7
            org.libpag.c$a r3 = r7.d     // Catch:{ all -> 0x00f7 }
            int r3 = r3.a     // Catch:{ all -> 0x00f7 }
            org.libpag.c$a r5 = r7.d     // Catch:{ all -> 0x00f7 }
            int r5 = r5.b     // Catch:{ all -> 0x00f7 }
            android.util.Pair r3 = org.libpag.a.a(r3, r5, r1)     // Catch:{ all -> 0x00f7 }
            java.lang.Object r5 = r3.first     // Catch:{ all -> 0x00f7 }
            if (r5 != 0) goto L_0x0097
            monitor-exit(r0)     // Catch:{ all -> 0x00f7 }
            return r1
        L_0x0097:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00f7 }
            if (r5 < r4) goto L_0x00a1
            java.lang.Object r4 = r3.second     // Catch:{ all -> 0x00f7 }
            android.hardware.HardwareBuffer r4 = (android.hardware.HardwareBuffer) r4     // Catch:{ all -> 0x00f7 }
            r7.j = r4     // Catch:{ all -> 0x00f7 }
        L_0x00a1:
            java.lang.Object r3 = r3.first     // Catch:{ all -> 0x00f7 }
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3     // Catch:{ all -> 0x00f7 }
            r7.i = r3     // Catch:{ all -> 0x00f7 }
        L_0x00a7:
            java.util.concurrent.atomic.AtomicBoolean r3 = r7.F     // Catch:{ all -> 0x00f7 }
            boolean r3 = r3.get()     // Catch:{ all -> 0x00f7 }
            if (r3 == 0) goto L_0x00b4
            android.graphics.Bitmap r3 = r7.g     // Catch:{ all -> 0x00f7 }
            android.hardware.HardwareBuffer r4 = r7.h     // Catch:{ all -> 0x00f7 }
            goto L_0x00b8
        L_0x00b4:
            android.graphics.Bitmap r3 = r7.i     // Catch:{ all -> 0x00f7 }
            android.hardware.HardwareBuffer r4 = r7.j     // Catch:{ all -> 0x00f7 }
        L_0x00b8:
            java.util.concurrent.atomic.AtomicBoolean r5 = r7.F     // Catch:{ all -> 0x00f7 }
            boolean r6 = r5.get()     // Catch:{ all -> 0x00f7 }
            r6 = r6 ^ r2
            r5.set(r6)     // Catch:{ all -> 0x00f7 }
            goto L_0x00c7
        L_0x00c3:
            android.hardware.HardwareBuffer r4 = r7.h     // Catch:{ all -> 0x00f7 }
            android.graphics.Bitmap r3 = r7.g     // Catch:{ all -> 0x00f7 }
        L_0x00c7:
            if (r4 == 0) goto L_0x00d3
            org.libpag.c$a r5 = r7.d     // Catch:{ all -> 0x00f7 }
            boolean r4 = r5.a((int) r8, (android.hardware.HardwareBuffer) r4)     // Catch:{ all -> 0x00f7 }
            if (r4 != 0) goto L_0x00e0
            monitor-exit(r0)     // Catch:{ all -> 0x00f7 }
            return r1
        L_0x00d3:
            org.libpag.c$a r4 = r7.d     // Catch:{ all -> 0x00f7 }
            boolean r4 = r4.a((android.graphics.Bitmap) r3, (int) r8)     // Catch:{ all -> 0x00f7 }
            if (r4 != 0) goto L_0x00dd
            monitor-exit(r0)     // Catch:{ all -> 0x00f7 }
            return r1
        L_0x00dd:
            r3.prepareToDraw()     // Catch:{ all -> 0x00f7 }
        L_0x00e0:
            r7.f = r3     // Catch:{ all -> 0x00f7 }
            monitor-exit(r0)     // Catch:{ all -> 0x00f7 }
            boolean r0 = r7.r
            if (r0 == 0) goto L_0x00f6
            android.graphics.Bitmap r0 = r7.f
            if (r0 == 0) goto L_0x00f6
            java.util.concurrent.ConcurrentHashMap r0 = r7.l
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            android.graphics.Bitmap r1 = r7.f
            r0.put(r8, r1)
        L_0x00f6:
            return r2
        L_0x00f7:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00f7 }
            throw r8
        L_0x00fa:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.libpag.PAGImageView.a(int):boolean");
    }

    public PAGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e();
    }

    public PAGImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        e();
    }
}
