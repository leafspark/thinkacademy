package com.wushuangtech.myvideoimprove.render.imageprocessing.filter.blend;

import com.wushuangtech.library.video.opengles.input.GLTextureOutputRenderer;
import com.wushuangtech.myvideoimprove.render.imageprocessing.filter.MultiInputFilter;
import com.yalantis.ucrop.view.CropImageView;

public class WaterMarklBlendFilter extends MultiInputFilter {
    private static final int NUM_OF_INPUTS = 2;
    private static final String TAG = "WaterMarklBlendFilter";
    private boolean bDirtyOne = false;
    private boolean bDirtyTwo = false;
    private boolean mIsVisible;
    private float mWaterMarkHeight;
    private float mWaterMarkWidth;
    private float x_eoffset = 1.0f;
    private float x_scale = 1.0f;
    private float x_soffset = CropImageView.DEFAULT_ASPECT_RATIO;
    private float y_eoffset = 1.0f;
    private float y_scale = 1.0f;
    private float y_soffset = CropImageView.DEFAULT_ASPECT_RATIO;

    public WaterMarklBlendFilter() {
        super(2);
    }

    /* access modifiers changed from: protected */
    public boolean initWithGLContext() {
        calcPosition();
        log(TAG, "Water mark args : " + this.x_soffset + " | " + this.x_eoffset + " | " + this.y_soffset + " | " + this.y_eoffset);
        return super.initWithGLContext();
    }

    /* access modifiers changed from: protected */
    public String getFragmentShader() {
        return controlVisible(this.mIsVisible);
    }

    /* access modifiers changed from: protected */
    public boolean handleSizeChange() {
        calcPosition();
        return super.handleSizeChange();
    }

    public synchronized void newTextureReady(int i, GLTextureOutputRenderer gLTextureOutputRenderer, boolean z) {
        if (!this.texturesReceived.contains(gLTextureOutputRenderer)) {
            this.texturesReceived.add(gLTextureOutputRenderer);
        }
        if (this.texturesReceived.size() == 1) {
            this.bDirtyOne = z;
        } else if (this.texturesReceived.size() == 2) {
            this.bDirtyTwo = z;
        }
        if (this.bDirtyOne && this.bDirtyTwo) {
            markAsDirty();
        }
        int lastIndexOf = this.filterLocations.lastIndexOf(gLTextureOutputRenderer);
        if (lastIndexOf <= 0) {
            this.mTextureIn = i;
        } else {
            this.texture[lastIndexOf - 1] = i;
        }
        if (this.texturesReceived.size() == 2) {
            onDrawFrame();
            this.bDirtyOne = false;
            this.bDirtyTwo = false;
            this.texturesReceived.clear();
        }
    }

    public void destroy() {
        super.destroy();
    }

    public void setWaterMarkArgs(boolean z, float f, float f2, float f3, float f4) {
        this.mIsVisible = z;
        this.mWaterMarkWidth = f;
        this.mWaterMarkHeight = f2;
        this.x_soffset = f3;
        this.y_soffset = f4;
        reInitialize();
    }

    private String controlVisible(boolean z) {
        log(TAG, "controlVisibile : " + this.x_scale + " | " + this.y_scale + " | " + this.x_soffset + " | " + this.x_eoffset + " | " + this.y_soffset + " | " + this.y_eoffset);
        if (!z) {
            return "precision mediump float;\nuniform sampler2D u_Texture0;\nuniform sampler2D u_Texture1;\nvarying vec2 v_TexCoord;\nvoid main(){\n   vec4 color2 = texture2D(u_Texture0,v_TexCoord);\n   vec4 color1;\n   vec2 texcoord2;\n    color1 = color2;\n   vec4 outputColor;\n   float a = color1.a + color2.a * (1.0 - color1.a);\n   outputColor.r = (color1.r * color1.a + color2.r * color2.a * (1.0 - color1.a))/a;\n   outputColor.g = (color1.g * color1.a + color2.g * color2.a * (1.0 - color1.a))/a;\n   outputColor.b = (color1.b * color1.a + color2.b * color2.a * (1.0 - color1.a))/a;\n   outputColor.a = a;\n   gl_FragColor = outputColor;\n}\n";
        }
        return "precision mediump float;\nuniform sampler2D u_Texture0;\nuniform sampler2D u_Texture1;\nvarying vec2 v_TexCoord;\nvoid main(){\n   vec4 color2 = texture2D(u_Texture0,v_TexCoord);\n   vec4 color1;\n   vec2 texcoord2;\n  if (v_TexCoord.x > " + this.x_soffset + " && " + "v_TexCoord" + ".x < " + this.x_eoffset + " && " + "v_TexCoord" + ".y >" + this.y_soffset + " && " + "v_TexCoord" + ".y < " + this.y_eoffset + ") {\n   texcoord2.x = (" + "v_TexCoord" + ".x - " + this.x_soffset + ") * " + this.x_scale + ";\n   texcoord2.y = (" + "v_TexCoord" + ".y - " + this.y_soffset + ") * " + this.y_scale + ";\n    color1 = texture2D(" + "u_Texture" + 1 + ",texcoord2);\n  } else \n    color1 = color2;\n   vec4 outputColor;\n   float a = color1.a + color2.a * (1.0 - color1.a);\n   outputColor.r = (color1.r * color1.a + color2.r * color2.a * (1.0 - color1.a))/a;\n   outputColor.g = (color1.g * color1.a + color2.g * color2.a * (1.0 - color1.a))/a;\n   outputColor.b = (color1.b * color1.a + color2.b * color2.a * (1.0 - color1.a))/a;\n   outputColor.a = a;\n   gl_FragColor = outputColor;\n}\n";
    }

    private void calcPosition() {
        if (this.mWaterMarkWidth == CropImageView.DEFAULT_ASPECT_RATIO || this.mWaterMarkHeight == CropImageView.DEFAULT_ASPECT_RATIO) {
            logE(TAG, "Calc water mark position failed! mMarkWidth is zero!");
            return;
        }
        this.x_scale = ((float) this.mWidth) / this.mWaterMarkWidth;
        this.y_scale = ((float) this.mHeight) / this.mWaterMarkHeight;
        this.x_eoffset = (this.mWaterMarkWidth / ((float) this.mWidth)) + this.x_soffset;
        this.y_eoffset = (this.mWaterMarkHeight / ((float) this.mHeight)) + this.y_soffset;
        log(TAG, "Calc water mark position, preview size : " + this.mWidth + " * " + this.mHeight + " | start location : " + this.x_soffset + " | " + this.y_soffset + " | water mark size :" + this.mWaterMarkWidth + " * " + this.mWaterMarkHeight);
    }
}
