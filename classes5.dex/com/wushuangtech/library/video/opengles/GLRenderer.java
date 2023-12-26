package com.wushuangtech.library.video.opengles;

import android.opengl.GLES20;
import com.wushuangtech.utils.MyGLUtils;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.utils.TextureRotationUtils;
import com.yalantis.ucrop.view.CropImageView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;

public abstract class GLRenderer {
    protected static final String ATTRIBUTE_POSITION = "a_Position";
    protected static final String ATTRIBUTE_TEXCOORD = "a_TexCoord";
    private static final int OPENGLES_DRAW_VERTEX_LEN = 4;
    private static final int OPENGLES_NUM_PER_TEXTURE = 2;
    private static final int OPENGLES_NUM_PER_VERTEX = 2;
    protected static final int OPENGLES_SIZEOF_FLOAT = 4;
    private static final int OPENGLES_SIZE_FOR_TEXTURE = 8;
    private static final int OPENGLES_SIZE_FOR_VERTEX = 8;
    protected static final String UNIFORM_TEXTURE0 = "u_Texture0";
    protected static final String UNIFORM_TEXTUREBASE = "u_Texture";
    protected static final String VARYING_TEXCOORD = "v_TexCoord";
    protected static FloatBuffer mTextureAllFlipBuffer;
    protected static FloatBuffer mTextureBuffer;
    protected static HashMap<String, FloatBuffer> mTextureBufferMap = new HashMap<>();
    protected static FloatBuffer mTextureHorizontalFlipBuffer;
    protected static FloatBuffer mTextureVerticalFlipBuffer;
    private static int mVboRef;
    private static FloatBuffer mVertextBuffer;
    protected String TAG = getRealAddress();
    private boolean mCustomSizeSet;
    protected int mHeight;
    protected boolean mInitialized;
    protected int mPositionHandle;
    protected int mProgramHandle;
    protected boolean mSizeChanged;
    protected int mStartX;
    protected int mStartY;
    protected int mTexCoordHandle;
    protected int mTextureHandle;
    protected int mTextureIn;
    private boolean mUserVbo;
    protected int mWidth;

    public interface OnGLRendererCallBack {
        int notifyHandleTextureData(byte[] bArr, int i, int i2, int i3, int i4, long j);
    }

    protected static void checkGLError(String str) {
    }

    private static void createVBO() {
    }

    /* access modifiers changed from: protected */
    public String getFragmentShader() {
        return "precision mediump float;\nuniform sampler2D u_Texture0;\nvarying vec2 v_TexCoord;\nvoid main(){\n   gl_FragColor = texture2D(u_Texture0,v_TexCoord);\n}\n";
    }

    /* access modifiers changed from: protected */
    public String getVertexShader() {
        return "attribute vec4 a_Position;\nattribute vec2 a_TexCoord;\nvarying vec2 v_TexCoord;\nvoid main() {\n  v_TexCoord = a_TexCoord;\n   gl_Position = a_Position;\n}\n";
    }

    static {
        initOpenglESVertex();
        initOpenglESTexture();
    }

    private static void initOpenglESTexture() {
        checkGLError("initOpenglESTexture start");
        TextureRotationUtils.Rotation rotation = TextureRotationUtils.Rotation.NORMAL;
        float[] rotation2 = TextureRotationUtils.getRotation(rotation, false, false);
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(rotation2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        mTextureBuffer = asFloatBuffer;
        asFloatBuffer.put(rotation2).position(0);
        float[] rotation3 = TextureRotationUtils.getRotation(rotation, false, true);
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(rotation3.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        mTextureVerticalFlipBuffer = asFloatBuffer2;
        asFloatBuffer2.put(rotation3).position(0);
        float[] rotation4 = TextureRotationUtils.getRotation(rotation, true, false);
        FloatBuffer asFloatBuffer3 = ByteBuffer.allocateDirect(rotation4.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        mTextureHorizontalFlipBuffer = asFloatBuffer3;
        asFloatBuffer3.put(rotation4).position(0);
        float[] rotation5 = TextureRotationUtils.getRotation(rotation, true, true);
        FloatBuffer asFloatBuffer4 = ByteBuffer.allocateDirect(rotation5.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        mTextureAllFlipBuffer = asFloatBuffer4;
        asFloatBuffer4.put(rotation5).position(0);
        checkGLError("initOpenglESTexture end");
    }

    private static void initOpenglESVertex() {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        mVertextBuffer = asFloatBuffer;
        asFloatBuffer.put(new float[]{-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f}).position(0);
    }

    /* access modifiers changed from: protected */
    public void setWidth(int i) {
        if (!this.mCustomSizeSet && this.mWidth != i) {
            this.mWidth = i;
            this.mSizeChanged = true;
        }
    }

    /* access modifiers changed from: protected */
    public void setHeight(int i) {
        if (!this.mCustomSizeSet && this.mHeight != i) {
            this.mHeight = i;
            this.mSizeChanged = true;
        }
    }

    public void setTextureId(int i) {
        this.mTextureIn = i;
    }

    public void setRenderSize(int i, int i2) {
        if (i != 0 && i2 != 0) {
            if (i != this.mWidth || i2 != this.mHeight) {
                this.mWidth = i;
                this.mHeight = i2;
                this.mCustomSizeSet = true;
                this.mSizeChanged = true;
            }
        }
    }

    public int getTextureId() {
        return this.mTextureIn;
    }

    /* access modifiers changed from: protected */
    public FloatBuffer getVertextBuffer() {
        return mVertextBuffer;
    }

    /* access modifiers changed from: protected */
    public FloatBuffer getTextureBuffer() {
        if (getClass().getSimpleName().equals("ImageResourceInput")) {
            return mTextureVerticalFlipBuffer;
        }
        return mTextureBuffer;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void reInitialize() {
        this.mInitialized = false;
    }

    /* renamed from: com.wushuangtech.library.video.opengles.GLRenderer$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$wushuangtech$utils$TextureRotationUtils$Rotation;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.wushuangtech.utils.TextureRotationUtils$Rotation[] r0 = com.wushuangtech.utils.TextureRotationUtils.Rotation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$wushuangtech$utils$TextureRotationUtils$Rotation = r0
                com.wushuangtech.utils.TextureRotationUtils$Rotation r1 = com.wushuangtech.utils.TextureRotationUtils.Rotation.ROTATION_90     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$wushuangtech$utils$TextureRotationUtils$Rotation     // Catch:{ NoSuchFieldError -> 0x001d }
                com.wushuangtech.utils.TextureRotationUtils$Rotation r1 = com.wushuangtech.utils.TextureRotationUtils.Rotation.ROTATION_180     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$wushuangtech$utils$TextureRotationUtils$Rotation     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.wushuangtech.utils.TextureRotationUtils$Rotation r1 = com.wushuangtech.utils.TextureRotationUtils.Rotation.ROTATION_270     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$wushuangtech$utils$TextureRotationUtils$Rotation     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.wushuangtech.utils.TextureRotationUtils$Rotation r1 = com.wushuangtech.utils.TextureRotationUtils.Rotation.NORMAL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.library.video.opengles.GLRenderer.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public FloatBuffer getTextureBuffer(TextureRotationUtils.Rotation rotation, boolean z, boolean z2) {
        int i = AnonymousClass1.$SwitchMap$com$wushuangtech$utils$TextureRotationUtils$Rotation[rotation.ordinal()];
        String str = i != 1 ? i != 2 ? i != 3 ? "0" : "270" : "180" : "90";
        String str2 = "true";
        String str3 = z ? str2 : "false";
        if (!z2) {
            str2 = "false";
        }
        String str4 = str + "_" + str3 + "_" + str2;
        FloatBuffer floatBuffer = mTextureBufferMap.get(str4);
        if (floatBuffer != null) {
            return floatBuffer;
        }
        float[] rotation2 = TextureRotationUtils.getRotation(rotation, z, z2);
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(rotation2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(rotation2).position(0);
        mTextureBufferMap.put(str4, asFloatBuffer);
        return asFloatBuffer;
    }

    public boolean onDrawFrame() {
        checkGLError("onDrawFrame start");
        if (this.mWidth == 0 || this.mHeight == 0) {
            logE(this.TAG, "Width or height is zero!");
            return false;
        } else if (this.mTextureIn == 0) {
            logE(this.TAG, "Texture id is zero!");
            return false;
        } else {
            if (!this.mInitialized) {
                if (!initWithGLContext()) {
                    logE(this.TAG, "Init context failed!");
                    return false;
                }
                this.mInitialized = true;
            }
            if (this.mSizeChanged) {
                if (!handleSizeChange()) {
                    logE(this.TAG, "Handle size changed failed!");
                    return false;
                }
                this.mSizeChanged = false;
            }
            checkGLError("onDrawFrame end");
            return drawFrame();
        }
    }

    public void destroy() {
        log(this.TAG, "Destroy renderer invoked!");
        int i = this.mTextureIn;
        if (i != 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
            this.mTextureIn = 0;
        }
        int i2 = this.mProgramHandle;
        if (i2 != 0) {
            GLES20.glDeleteProgram(i2);
            this.mProgramHandle = 0;
        }
        this.mPositionHandle = 0;
        this.mTexCoordHandle = 0;
    }

    /* access modifiers changed from: protected */
    public boolean initWithGLContext() {
        log(this.TAG, "Init With GLContext begin!");
        int i = this.mProgramHandle;
        if (i != 0) {
            GLES20.glDeleteProgram(i);
            this.mProgramHandle = 0;
        }
        int createProgram = MyGLUtils.createProgram(getVertexShader(), getFragmentShader());
        if (createProgram == 0) {
            return false;
        }
        this.mProgramHandle = createProgram;
        bindShaderAttributes();
        initShaderHandles();
        String str = this.TAG;
        log(str, "Init With GLContext success! program : " + this.mProgramHandle);
        return true;
    }

    private void bindShaderAttributes() {
        GLES20.glBindAttribLocation(this.mProgramHandle, 0, ATTRIBUTE_POSITION);
        GLES20.glBindAttribLocation(this.mProgramHandle, 1, ATTRIBUTE_TEXCOORD);
    }

    /* access modifiers changed from: protected */
    public void initShaderHandles() {
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgramHandle, ATTRIBUTE_POSITION);
        this.mPositionHandle = glGetAttribLocation;
        MyGLUtils.checkLocation(glGetAttribLocation, ATTRIBUTE_POSITION);
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.mProgramHandle, ATTRIBUTE_TEXCOORD);
        this.mTexCoordHandle = glGetAttribLocation2;
        MyGLUtils.checkLocation(glGetAttribLocation2, ATTRIBUTE_TEXCOORD);
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.mProgramHandle, UNIFORM_TEXTURE0);
        this.mTextureHandle = glGetUniformLocation;
        MyGLUtils.checkLocation(glGetUniformLocation, UNIFORM_TEXTURE0);
        if (this.mUserVbo) {
            createVBO();
        }
        checkGLError("initShaderHandles end");
    }

    /* access modifiers changed from: protected */
    public boolean handleSizeChange() {
        String str = this.TAG;
        log(str, "Handle size change begin! " + this.mWidth + " * " + this.mHeight);
        if (this.mWidth == 0 || this.mHeight == 0) {
            logE(this.TAG, "width or height is zero!");
            return false;
        }
        log(this.TAG, "Handle size change success!");
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean drawFrame() {
        if (this.mProgramHandle == 0) {
            logE(this.TAG, "Program is zero!");
            return false;
        }
        GLES20.glClear(16640);
        GLES20.glClearColor(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
        GLES20.glUseProgram(this.mProgramHandle);
        GLES20.glViewport(this.mStartX, this.mStartY, this.mWidth, this.mHeight);
        passVertexAttribPointer();
        passShaderValues();
        GLES20.glDrawArrays(5, 0, 4);
        checkGLError("drawFrame glDrawArrays");
        drawFrameEnd();
        checkGLError("drawFrame end");
        return true;
    }

    /* access modifiers changed from: protected */
    public void passVertexAttribPointer() {
        if (this.mUserVbo) {
            int capacity = getVertextBuffer().capacity() * 4;
            GLES20.glBindBuffer(34962, mVboRef);
            GLES20.glEnableVertexAttribArray(this.mPositionHandle);
            GLES20.glEnableVertexAttribArray(this.mTexCoordHandle);
            GLES20.glVertexAttribPointer(this.mPositionHandle, 2, 5126, false, 8, 0);
            GLES20.glVertexAttribPointer(this.mTexCoordHandle, 2, 5126, false, 8, capacity);
        } else {
            FloatBuffer vertextBuffer = getVertextBuffer();
            FloatBuffer textureBuffer = getTextureBuffer();
            GLES20.glEnableVertexAttribArray(this.mPositionHandle);
            GLES20.glEnableVertexAttribArray(this.mTexCoordHandle);
            GLES20.glVertexAttribPointer(this.mPositionHandle, 2, 5126, false, 8, vertextBuffer);
            GLES20.glVertexAttribPointer(this.mTexCoordHandle, 2, 5126, false, 8, textureBuffer);
        }
        checkGLError("passVertexAttribPointer end");
    }

    /* access modifiers changed from: protected */
    public void passShaderValues() {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.mTextureIn);
        GLES20.glUniform1i(this.mTextureHandle, 0);
    }

    /* access modifiers changed from: protected */
    public void drawFrameEnd() {
        if (this.mUserVbo) {
            GLES20.glBindBuffer(34962, 0);
        }
        GLES20.glDisableVertexAttribArray(this.mPositionHandle);
        GLES20.glDisableVertexAttribArray(this.mTexCoordHandle);
        checkGLError("drawFrameEnd end");
    }

    /* access modifiers changed from: protected */
    public void log(String str, String str2) {
        OmniLog.i(OmniLog.VIDEO_RENDER_WATCH, str, str2);
    }

    /* access modifiers changed from: protected */
    public void logD(String str, String str2) {
        OmniLog.debugD(OmniLog.VIDEO_RENDER_WATCH, str, str2);
    }

    /* access modifiers changed from: protected */
    public void logE(String str, String str2) {
        OmniLog.e(OmniLog.VIDEO_RENDER_WATCH, str, str2);
    }

    private String getRealAddress() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode());
    }
}
