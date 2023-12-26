package com.eaydu.omni.core.screen.opes;

import com.eaydu.omni.core.screen.opes.Drawable2d;

public class MainFrameRect {
    private Texture2dProgram mProgram;
    private final CroppedDrawable2d mRectDrawable = new CroppedDrawable2d(Drawable2d.Prefab.FULL_RECTANGLE);

    public MainFrameRect(Texture2dProgram texture2dProgram) {
        this.mProgram = texture2dProgram;
    }

    public void release(boolean z) {
        Texture2dProgram texture2dProgram = this.mProgram;
        if (texture2dProgram != null) {
            if (z) {
                texture2dProgram.release();
            }
            this.mProgram = null;
        }
    }

    public Texture2dProgram getProgram() {
        return this.mProgram;
    }

    public void changeProgram(Texture2dProgram texture2dProgram) {
        this.mProgram.release();
        this.mProgram = texture2dProgram;
    }

    public void setBottomCropped(float f) {
        this.mRectDrawable.setBottomCropped(f);
    }

    public void setTopCropped(float f) {
        this.mRectDrawable.setTopCropped(f);
    }

    public int createTextureObject() {
        return this.mProgram.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        this.mProgram.draw(GlUtil.IDENTITY_MATRIX, this.mRectDrawable.getVertexArray(), 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), fArr, this.mRectDrawable.getTexCoordArray(), i, this.mRectDrawable.getTexCoordStride());
    }
}
