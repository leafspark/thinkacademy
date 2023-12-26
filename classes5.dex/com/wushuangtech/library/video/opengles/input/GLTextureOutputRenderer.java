package com.wushuangtech.library.video.opengles.input;

import android.opengl.GLES20;
import com.wushuangtech.library.video.opengles.GLRenderer;
import com.wushuangtech.library.video.opengles.output.GLTextureInputRenderer;
import com.wushuangtech.utils.MyGLUtils;
import java.util.ArrayList;
import java.util.List;

public abstract class GLTextureOutputRenderer extends GLRenderer {
    private boolean mDirty;
    private int[] mFrameBuffer;
    private OnFrameAvailableListener mOnFrameAvailableListener;
    private List<GLTextureInputRenderer> mTargets = new ArrayList();
    protected int[] mTextureOut;

    public interface OnFrameAvailableListener {
        void onFrameAvailable(int i, int i2);
    }

    public void setOnFrameAvailableListener(OnFrameAvailableListener onFrameAvailableListener) {
        this.mOnFrameAvailableListener = onFrameAvailableListener;
    }

    public int getFrameBufferTextureId() {
        int[] iArr = this.mTextureOut;
        if (iArr != null) {
            return iArr[0];
        }
        return 0;
    }

    public void addTarget(GLTextureInputRenderer gLTextureInputRenderer) {
        String str = this.TAG;
        logD(str, "Add next renderer : " + gLTextureInputRenderer);
        this.mTargets.add(gLTextureInputRenderer);
    }

    public void removeTarget(GLTextureInputRenderer gLTextureInputRenderer) {
        this.mTargets.remove(gLTextureInputRenderer);
    }

    /* access modifiers changed from: protected */
    public void markAsDirty() {
        this.mDirty = true;
    }

    public void destroy() {
        this.mDirty = false;
        deleteFrameBuffer();
        List<GLTextureInputRenderer> list = this.mTargets;
        if (list != null) {
            list.clear();
            this.mTargets = null;
        }
        super.destroy();
    }

    /* access modifiers changed from: protected */
    public boolean drawFrame() {
        boolean z;
        int[] iArr = this.mFrameBuffer;
        if (iArr == null || this.mTextureOut == null) {
            logE(this.TAG, "Draw frame failed! frameBuffer or texture is null");
            return false;
        }
        if (this.mDirty) {
            GLES20.glBindFramebuffer(36160, iArr[0]);
            super.drawFrame();
            OnFrameAvailableListener onFrameAvailableListener = this.mOnFrameAvailableListener;
            if (onFrameAvailableListener != null) {
                onFrameAvailableListener.onFrameAvailable(this.mWidth, this.mHeight);
            }
            GLES20.glBindFramebuffer(36160, 0);
            z = true;
        } else {
            z = false;
        }
        List<GLTextureInputRenderer> list = this.mTargets;
        if (list != null && list.size() > 0) {
            for (GLTextureInputRenderer next : this.mTargets) {
                if (next != null) {
                    next.newTextureReady(this.mTextureOut[0], this, z);
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean handleSizeChange() {
        if (!super.handleSizeChange()) {
            return false;
        }
        deleteFrameBuffer();
        return createFrameBuffer(this.mWidth, this.mHeight);
    }

    private void deleteFrameBuffer() {
        if (this.mFrameBuffer != null) {
            String str = this.TAG;
            logD(str, "Delete frame buffer! " + this.mFrameBuffer[0]);
            GLES20.glDeleteFramebuffers(1, this.mFrameBuffer, 0);
            this.mFrameBuffer = null;
        }
        int[] iArr = this.mTextureOut;
        if (iArr != null && iArr[0] != 0) {
            String str2 = this.TAG;
            logD(str2, "Delete frame buffer texture id! " + this.mTextureOut[0]);
            GLES20.glDeleteTextures(1, this.mTextureOut, 0);
            this.mTextureOut = null;
        }
    }

    private boolean createFrameBuffer(int i, int i2) {
        if (this.mFrameBuffer == null) {
            boolean z = getClass().getSimpleName().equals("WaterMarklBlendFilter") || getClass().getSimpleName().equals("ImageResourceInput");
            int[] createWhiteTextureId = MyGLUtils.createWhiteTextureId(z, i, i2);
            this.mTextureOut = createWhiteTextureId;
            int[] createFrameBuffer = MyGLUtils.createFrameBuffer(createWhiteTextureId[0], i, i2);
            if (createFrameBuffer == null) {
                GLES20.glDeleteTextures(1, createWhiteTextureId, 0);
                String str = this.TAG;
                logE(str, "Create frame buffer failed! " + this);
                return false;
            }
            this.mFrameBuffer = createFrameBuffer;
            String str2 = this.TAG;
            logD(str2, "Create frame buffer success! " + createFrameBuffer[0] + " | " + z + " | " + getClass().getSimpleName());
            String str3 = this.TAG;
            logD(str3, "Create frame buffer texture id! " + createWhiteTextureId[0] + " | " + i + " * " + i2 + " | " + this.mFrameBuffer);
        }
        return true;
    }
}
