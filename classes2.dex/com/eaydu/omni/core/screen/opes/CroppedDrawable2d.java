package com.eaydu.omni.core.screen.opes;

import com.eaydu.omni.core.screen.opes.Drawable2d;
import com.wushuangtech.utils.OmniLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class CroppedDrawable2d extends Drawable2d {
    private static final int SIZEOF_FLOAT = 4;
    private static final String TAG = "CroppedDrawable2d";
    private float mBottomCropped = 1.0f;
    private boolean mRecalculate = true;
    private float mTopCropped = 0.0f;
    private FloatBuffer mTweakedTexCoordArray;

    public CroppedDrawable2d(Drawable2d.Prefab prefab) {
        super(prefab);
    }

    public float getBottomCropped() {
        return this.mBottomCropped;
    }

    public void setBottomCropped(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new RuntimeException("invalid crop " + f);
        }
        this.mBottomCropped = f;
        this.mRecalculate = true;
    }

    public void setTopCropped(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new RuntimeException("invalid crop " + f);
        }
        this.mTopCropped = f;
        this.mRecalculate = true;
    }

    public FloatBuffer getTexCoordArray() {
        if (this.mRecalculate) {
            FloatBuffer texCoordArray = super.getTexCoordArray();
            int capacity = texCoordArray.capacity();
            if (this.mTweakedTexCoordArray == null) {
                int i = capacity * 4;
                OmniLog.amd(TAG, "getTexCoordArray allocateDirect invoked! allocType: " + i);
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
                allocateDirect.order(ByteOrder.nativeOrder());
                this.mTweakedTexCoordArray = allocateDirect.asFloatBuffer();
            }
            FloatBuffer floatBuffer = this.mTweakedTexCoordArray;
            for (int i2 = 0; i2 < capacity; i2++) {
                float f = texCoordArray.get(i2);
                if (i2 == 0 || i2 == 4) {
                    f = 0.0f;
                } else if (i2 == 2 || i2 == 6) {
                    f = 1.0f;
                } else if (i2 == 1 || i2 == 3) {
                    f = this.mBottomCropped;
                } else if (i2 == 5 || i2 == 7) {
                    f = 1.0f - this.mTopCropped;
                }
                floatBuffer.put(i2, f);
            }
            this.mRecalculate = false;
        }
        return this.mTweakedTexCoordArray;
    }
}
