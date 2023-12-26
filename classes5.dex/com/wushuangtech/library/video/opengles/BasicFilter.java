package com.wushuangtech.library.video.opengles;

import com.wushuangtech.library.video.opengles.input.GLTextureOutputRenderer;
import com.wushuangtech.library.video.opengles.output.GLTextureInputRenderer;

public abstract class BasicFilter extends GLTextureOutputRenderer implements GLTextureInputRenderer {
    public void newTextureReady(int i, GLTextureOutputRenderer gLTextureOutputRenderer, boolean z) {
        if (z) {
            markAsDirty();
        }
        this.mTextureIn = i;
        setWidth(gLTextureOutputRenderer.getWidth());
        setHeight(gLTextureOutputRenderer.getHeight());
        onDrawFrame();
    }
}
