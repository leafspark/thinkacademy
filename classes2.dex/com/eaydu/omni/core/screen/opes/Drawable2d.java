package com.eaydu.omni.core.screen.opes;

import java.nio.FloatBuffer;

public class Drawable2d {
    private static final FloatBuffer FULL_RECTANGLE_BUF;
    private static final float[] FULL_RECTANGLE_COORDS;
    private static final FloatBuffer FULL_RECTANGLE_TEX_BUF;
    private static final float[] FULL_RECTANGLE_TEX_COORDS;
    private static final FloatBuffer RECTANGLE_BUF;
    private static final float[] RECTANGLE_COORDS;
    private static final FloatBuffer RECTANGLE_TEX_BUF;
    private static final float[] RECTANGLE_TEX_COORDS;
    private static final int SIZEOF_FLOAT = 4;
    private static final FloatBuffer TRIANGLE_BUF;
    private static final float[] TRIANGLE_COORDS;
    private static final FloatBuffer TRIANGLE_TEX_BUF;
    private static final float[] TRIANGLE_TEX_COORDS;
    private int mCoordsPerVertex;
    private Prefab mPrefab;
    private FloatBuffer mTexCoordArray;
    private int mTexCoordStride;
    private FloatBuffer mVertexArray;
    private int mVertexCount;
    private int mVertexStride;

    public enum Prefab {
        TRIANGLE,
        RECTANGLE,
        FULL_RECTANGLE
    }

    static {
        float[] fArr = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
        TRIANGLE_COORDS = fArr;
        float[] fArr2 = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        TRIANGLE_TEX_COORDS = fArr2;
        TRIANGLE_BUF = GlUtil.createFloatBuffer(fArr);
        TRIANGLE_TEX_BUF = GlUtil.createFloatBuffer(fArr2);
        float[] fArr3 = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        RECTANGLE_COORDS = fArr3;
        float[] fArr4 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        RECTANGLE_TEX_COORDS = fArr4;
        RECTANGLE_BUF = GlUtil.createFloatBuffer(fArr3);
        RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(fArr4);
        float[] fArr5 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        FULL_RECTANGLE_COORDS = fArr5;
        float[] fArr6 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        FULL_RECTANGLE_TEX_COORDS = fArr6;
        FULL_RECTANGLE_BUF = GlUtil.createFloatBuffer(fArr5);
        FULL_RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(fArr6);
    }

    /* renamed from: com.eaydu.omni.core.screen.opes.Drawable2d$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$eaydu$omni$core$screen$opes$Drawable2d$Prefab;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.eaydu.omni.core.screen.opes.Drawable2d$Prefab[] r0 = com.eaydu.omni.core.screen.opes.Drawable2d.Prefab.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$eaydu$omni$core$screen$opes$Drawable2d$Prefab = r0
                com.eaydu.omni.core.screen.opes.Drawable2d$Prefab r1 = com.eaydu.omni.core.screen.opes.Drawable2d.Prefab.TRIANGLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$eaydu$omni$core$screen$opes$Drawable2d$Prefab     // Catch:{ NoSuchFieldError -> 0x001d }
                com.eaydu.omni.core.screen.opes.Drawable2d$Prefab r1 = com.eaydu.omni.core.screen.opes.Drawable2d.Prefab.RECTANGLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$eaydu$omni$core$screen$opes$Drawable2d$Prefab     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.eaydu.omni.core.screen.opes.Drawable2d$Prefab r1 = com.eaydu.omni.core.screen.opes.Drawable2d.Prefab.FULL_RECTANGLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.core.screen.opes.Drawable2d.AnonymousClass1.<clinit>():void");
        }
    }

    public Drawable2d(Prefab prefab) {
        int i = AnonymousClass1.$SwitchMap$com$eaydu$omni$core$screen$opes$Drawable2d$Prefab[prefab.ordinal()];
        if (i == 1) {
            this.mVertexArray = TRIANGLE_BUF;
            this.mTexCoordArray = TRIANGLE_TEX_BUF;
            this.mCoordsPerVertex = 2;
            this.mVertexStride = 2 * 4;
            this.mVertexCount = TRIANGLE_COORDS.length / 2;
        } else if (i == 2) {
            this.mVertexArray = RECTANGLE_BUF;
            this.mTexCoordArray = RECTANGLE_TEX_BUF;
            this.mCoordsPerVertex = 2;
            this.mVertexStride = 2 * 4;
            this.mVertexCount = RECTANGLE_COORDS.length / 2;
        } else if (i == 3) {
            this.mVertexArray = FULL_RECTANGLE_BUF;
            this.mTexCoordArray = FULL_RECTANGLE_TEX_BUF;
            this.mCoordsPerVertex = 2;
            this.mVertexStride = 2 * 4;
            this.mVertexCount = FULL_RECTANGLE_COORDS.length / 2;
        } else {
            throw new RuntimeException("Unknown shape " + prefab);
        }
        this.mTexCoordStride = 8;
        this.mPrefab = prefab;
    }

    public FloatBuffer getVertexArray() {
        return this.mVertexArray;
    }

    public FloatBuffer getTexCoordArray() {
        return this.mTexCoordArray;
    }

    public int getVertexCount() {
        return this.mVertexCount;
    }

    public int getVertexStride() {
        return this.mVertexStride;
    }

    public int getTexCoordStride() {
        return this.mTexCoordStride;
    }

    public int getCoordsPerVertex() {
        return this.mCoordsPerVertex;
    }

    public String toString() {
        if (this.mPrefab == null) {
            return "[Drawable2d: ...]";
        }
        return "[Drawable2d: " + this.mPrefab + "]";
    }
}
