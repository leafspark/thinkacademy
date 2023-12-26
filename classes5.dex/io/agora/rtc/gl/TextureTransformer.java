package io.agora.rtc.gl;

import android.opengl.GLES20;
import android.opengl.Matrix;
import io.agora.rtc.utils.ThreadUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TextureTransformer {
    public static final float[] IDENTITY_MATRIX;
    private static final String TAG = "TextureTransformer";
    private final GlRectDrawer drawer;
    private final ConcurrentLinkedQueue<Integer> freeSlots = new ConcurrentLinkedQueue<>();
    private final int maxBufferSlot;
    private final GlTextureFrameBuffer[] textureFrameBuffer;
    private final Map<Integer, Integer> textureId2SlotMap = new HashMap();
    private final ThreadUtils.ThreadChecker threadChecker;

    static {
        float[] fArr = new float[16];
        IDENTITY_MATRIX = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public TextureTransformer(int i) {
        ThreadUtils.ThreadChecker threadChecker2 = new ThreadUtils.ThreadChecker();
        this.threadChecker = threadChecker2;
        threadChecker2.checkIsOnValidThread();
        this.maxBufferSlot = Math.max(i, 1);
        this.textureFrameBuffer = new GlTextureFrameBuffer[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.textureFrameBuffer[i2] = new GlTextureFrameBuffer(6408);
            this.textureId2SlotMap.put(Integer.valueOf(this.textureFrameBuffer[i2].getTextureId()), Integer.valueOf(i2));
            this.freeSlots.offer(Integer.valueOf(i2));
        }
        this.drawer = new GlRectDrawer();
    }

    public int copy(int i, int i2, int i3, int i4) {
        int i5 = i2;
        this.threadChecker.checkIsOnValidThread();
        Integer poll = this.freeSlots.poll();
        if (poll == null) {
            return -1;
        }
        this.textureFrameBuffer[poll.intValue()].setSize(i3, i4);
        GLES20.glBindFramebuffer(36160, this.textureFrameBuffer[poll.intValue()].getFrameBufferId());
        GlUtil.checkNoGLES2Error("TextureHelper.glBindFramebuffer");
        GLES20.glClear(16384);
        if (i5 == 10) {
            this.drawer.drawRgb(i, IDENTITY_MATRIX, i3, i4, 0, 0, i3, i4);
        } else if (i5 == 11) {
            this.drawer.drawOes(i, IDENTITY_MATRIX, i3, i4, 0, 0, i3, i4);
        } else {
            throw new RuntimeException("Unknown texture type.");
        }
        GlUtil.checkNoGLES2Error("TextureHelper.draw");
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glFlush();
        int textureId = this.textureFrameBuffer[poll.intValue()].getTextureId();
        this.freeSlots.offer(this.textureId2SlotMap.get(Integer.valueOf(textureId)));
        return textureId;
    }

    public void release() {
        this.threadChecker.checkIsOnValidThread();
        for (int i = 0; i < this.maxBufferSlot; i++) {
            this.textureFrameBuffer[i].release();
        }
        this.drawer.release();
    }
}
