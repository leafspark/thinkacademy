package com.linkedin.android.litr.filter.video.gl;

import com.linkedin.android.litr.filter.Transform;
import com.linkedin.android.litr.filter.video.gl.parameter.ShaderParameter;

public class DefaultVideoFrameRenderFilter extends VideoFrameRenderFilter {
    public DefaultVideoFrameRenderFilter() {
        this((Transform) null);
    }

    public DefaultVideoFrameRenderFilter(Transform transform) {
        super("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main()\n{\ngl_Position = uMVPMatrix * aPosition;\nvTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main()\n{\ngl_FragColor = texture2D(sTexture, vTextureCoord);\n}", (ShaderParameter[]) null, transform);
    }
}
