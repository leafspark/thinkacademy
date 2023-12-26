package com.wushuangtech.myvideoimprove.render.imageprocessing;

import com.wushuangtech.library.video.opengles.GLRenderer;
import com.wushuangtech.utils.OmniLog;
import java.util.ArrayList;
import java.util.List;

public class FastImageProcessingPipeline {
    private final String TAG = ("FastImageProcessingPipeline" + "@" + Integer.toHexString(hashCode()));
    private boolean mDestroy;
    private final List<GLRenderer> mFiltersToDestroy = new ArrayList();
    private final List<GLRenderer> mRootRenderers = new ArrayList();

    public void addFilterToDestroy(GLRenderer gLRenderer) {
        if (gLRenderer != null) {
            this.mFiltersToDestroy.add(gLRenderer);
        }
    }

    public void addRootRenderer(GLRenderer gLRenderer) {
        if (gLRenderer != null) {
            this.mRootRenderers.add(gLRenderer);
        }
    }

    public void removeRootRenderer(GLRenderer gLRenderer) {
        if (gLRenderer != null) {
            this.mRootRenderers.remove(gLRenderer);
        }
    }

    public void startRendering() {
        if (this.mDestroy) {
            String str = this.TAG;
            OmniLog.i(OmniLog.VIDEO_RENDER_WATCH, str, "startRendering! size : " + this.mRootRenderers.size());
            this.mDestroy = false;
        }
    }

    public void stopRendering() {
        if (!this.mDestroy) {
            String str = this.TAG;
            OmniLog.i(OmniLog.VIDEO_RENDER_WATCH, str, "stopRendering! size : " + this.mRootRenderers.size());
            this.mDestroy = true;
        }
    }

    public boolean onDrawFrame() {
        if (this.mDestroy || this.mRootRenderers.size() <= 0) {
            return true;
        }
        for (GLRenderer next : this.mRootRenderers) {
            if (next != null && !next.onDrawFrame()) {
                return false;
            }
        }
        return true;
    }

    public void clearResource() {
        for (GLRenderer destroy : this.mFiltersToDestroy) {
            destroy.destroy();
        }
        this.mFiltersToDestroy.clear();
        this.mRootRenderers.clear();
    }
}
