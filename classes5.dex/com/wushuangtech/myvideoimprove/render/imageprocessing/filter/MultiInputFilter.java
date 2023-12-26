package com.wushuangtech.myvideoimprove.render.imageprocessing.filter;

import android.opengl.GLES20;
import com.wushuangtech.library.video.opengles.BasicFilter;
import com.wushuangtech.library.video.opengles.input.GLTextureOutputRenderer;
import java.util.ArrayList;
import java.util.List;

public abstract class MultiInputFilter extends BasicFilter {
    protected List<GLTextureOutputRenderer> filterLocations;
    private int numOfInputs;
    protected int[] texture;
    protected int[] textureHandle;
    protected List<GLTextureOutputRenderer> texturesReceived;

    public MultiInputFilter(int i) {
        this.numOfInputs = i;
        int i2 = i - 1;
        this.textureHandle = new int[i2];
        this.texture = new int[i2];
        this.texturesReceived = new ArrayList(i);
        this.filterLocations = new ArrayList(i);
    }

    public void clearRegisteredFilterLocations() {
        this.filterLocations.clear();
    }

    /* access modifiers changed from: protected */
    public void initShaderHandles() {
        super.initShaderHandles();
        int i = 0;
        while (i < this.numOfInputs - 1) {
            int[] iArr = this.textureHandle;
            int i2 = this.mProgramHandle;
            StringBuilder sb = new StringBuilder();
            sb.append("u_Texture");
            int i3 = i + 1;
            sb.append(i3);
            iArr[i] = GLES20.glGetUniformLocation(i2, sb.toString());
            i = i3;
        }
    }

    public synchronized void newTextureReady(int i, GLTextureOutputRenderer gLTextureOutputRenderer, boolean z) {
        if (!this.texturesReceived.contains(gLTextureOutputRenderer)) {
            this.texturesReceived.add(gLTextureOutputRenderer);
            if (z) {
                markAsDirty();
            }
        }
        int lastIndexOf = this.filterLocations.lastIndexOf(gLTextureOutputRenderer);
        if (lastIndexOf <= 0) {
            this.mTextureIn = i;
        } else {
            this.texture[lastIndexOf - 1] = i;
        }
        if (this.texturesReceived.size() == this.numOfInputs) {
            setWidth(gLTextureOutputRenderer.getWidth());
            setHeight(gLTextureOutputRenderer.getHeight());
            onDrawFrame();
            this.texturesReceived.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void passShaderValues() {
        super.passShaderValues();
        int i = 0;
        int i2 = 0;
        while (i < this.numOfInputs - 1) {
            switch (i) {
                case 0:
                    i2 = 33985;
                    break;
                case 1:
                    i2 = 33986;
                    break;
                case 2:
                    i2 = 33987;
                    break;
                case 3:
                    i2 = 33988;
                    break;
                case 4:
                    i2 = 33989;
                    break;
                case 5:
                    i2 = 33990;
                    break;
                case 6:
                    i2 = 33991;
                    break;
                case 7:
                    i2 = 33992;
                    break;
                case 8:
                    i2 = 33993;
                    break;
            }
            GLES20.glActiveTexture(i2);
            GLES20.glBindTexture(3553, this.texture[i]);
            int i3 = this.textureHandle[i];
            i++;
            GLES20.glUniform1i(i3, i);
        }
    }

    public void registerFilterLocation(GLTextureOutputRenderer gLTextureOutputRenderer) {
        if (!this.filterLocations.contains(gLTextureOutputRenderer)) {
            this.filterLocations.add(gLTextureOutputRenderer);
        }
    }

    public void registerFilterLocation(GLTextureOutputRenderer gLTextureOutputRenderer, int i) {
        if (this.filterLocations.contains(gLTextureOutputRenderer)) {
            this.filterLocations.remove(gLTextureOutputRenderer);
        }
        this.filterLocations.add(i, gLTextureOutputRenderer);
    }

    public void unregisterFilterLocation(GLTextureOutputRenderer gLTextureOutputRenderer) {
        if (gLTextureOutputRenderer != null && this.filterLocations.contains(gLTextureOutputRenderer)) {
            this.filterLocations.remove(gLTextureOutputRenderer);
        }
    }
}
