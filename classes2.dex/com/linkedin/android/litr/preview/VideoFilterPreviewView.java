package com.linkedin.android.litr.preview;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import com.linkedin.android.litr.preview.VideoPreviewRenderer;

public class VideoFilterPreviewView extends GLSurfaceView {
    public VideoFilterPreviewView(Context context) {
        this(context, (AttributeSet) null);
    }

    public VideoFilterPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setEGLContextFactory(new PreviewEglContextFactory());
        setEGLConfigChooser(new PreviewEglConfigChooser());
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        super.setRenderer(renderer);
        if (renderer instanceof VideoPreviewRenderer) {
            ((VideoPreviewRenderer) renderer).setPreviewRenderListener(new VideoPreviewRenderer.PreviewRenderListener() {
                public void onRenderRequested() {
                    VideoFilterPreviewView.this.requestRender();
                }

                public void onEventQueued(Runnable runnable) {
                    VideoFilterPreviewView.this.queueEvent(runnable);
                }
            });
        }
    }
}
