package io.agora.rtc.gl;

import android.opengl.GLES20;
import com.yalantis.ucrop.view.CropImageView;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.utils.ThreadUtils;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class YuvConverter {
    private static final FloatBuffer DEVICE_RECTANGLE = GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
    private static final String OES_FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES tex;\nuniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      texture2D(tex, interp_tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      texture2D(tex, interp_tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      texture2D(tex, interp_tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      texture2D(tex, interp_tc + 1.5 * xUnit).rgb);\n}\n";
    private static final String RGB_FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D tex;\nuniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      texture2D(tex, interp_tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      texture2D(tex, interp_tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      texture2D(tex, interp_tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      texture2D(tex, interp_tc + 1.5 * xUnit).rgb);\n}\n";
    private static final FloatBuffer TEXTURE_RECTANGLE = GlUtil.createFloatBuffer(new float[]{CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f, 1.0f});
    private static final String VERTEX_SHADER = "varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\n\nuniform mat4 texMatrix;\n\nvoid main() {\n    gl_Position = in_pos;\n    interp_tc = (texMatrix * in_tc).xy;\n}\n";
    private int coeffsLoc;
    private long nativeHanlder = 0;
    private boolean released = false;
    private GlShader shader;
    private VideoFrame.TextureBuffer.Type shaderTextureType;
    private int texMatrixLoc;
    private final GlTextureFrameBuffer textureFrameBuffer;
    private final ThreadUtils.ThreadChecker threadChecker;
    private int xUnitLoc;

    private native long GPUFBOInit(int i, int i2);

    private native int GPUFBOReadFrame(long j, byte[] bArr, int i, int i2);

    private native void GPUFBORelease(long j);

    private native void GPUFBOResetFirstInit(long j);

    private native boolean GPUFBOValid();

    public YuvConverter() {
        ThreadUtils.ThreadChecker threadChecker2 = new ThreadUtils.ThreadChecker();
        this.threadChecker = threadChecker2;
        threadChecker2.checkIsOnValidThread();
        this.textureFrameBuffer = new GlTextureFrameBuffer(6408);
    }

    public VideoFrame.I420Buffer convert(VideoFrame.TextureBuffer textureBuffer) {
        int width = textureBuffer.getWidth();
        int height = textureBuffer.getHeight();
        int i = ((width + 7) / 8) * 8;
        int i2 = (height + 1) / 2;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect((height + i2 + 1) * i);
        convert(allocateDirect, width, height, i, textureBuffer.getTextureId(), RendererCommon.convertMatrixFromAndroidGraphicsMatrix(textureBuffer.getTransformMatrix()), textureBuffer.getType());
        int i3 = (i * height) + 0;
        int i4 = (i / 2) + i3;
        allocateDirect.position(0);
        allocateDirect.limit(i3);
        ByteBuffer slice = allocateDirect.slice();
        allocateDirect.position(i3);
        int i5 = i2 * i;
        allocateDirect.limit(i3 + i5);
        ByteBuffer slice2 = allocateDirect.slice();
        allocateDirect.position(i4);
        allocateDirect.limit(i4 + i5);
        return JavaI420Buffer.wrap(width, height, slice, i, slice2, i, allocateDirect.slice(), i, (Runnable) null);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public void convert(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, float[] fArr) {
        convert(byteBuffer, i, i2, i3, i4, fArr, VideoFrame.TextureBuffer.Type.OES);
    }

    private void initShader(VideoFrame.TextureBuffer.Type type) {
        String str;
        GlShader glShader = this.shader;
        if (glShader != null) {
            glShader.release();
        }
        int i = AnonymousClass1.$SwitchMap$io$agora$rtc$gl$VideoFrame$TextureBuffer$Type[type.ordinal()];
        if (i == 1) {
            str = OES_FRAGMENT_SHADER;
        } else if (i == 2) {
            str = RGB_FRAGMENT_SHADER;
        } else {
            throw new IllegalArgumentException("Unsupported texture type.");
        }
        this.shaderTextureType = type;
        GlShader glShader2 = new GlShader(VERTEX_SHADER, str);
        this.shader = glShader2;
        glShader2.useProgram();
        this.texMatrixLoc = this.shader.getUniformLocation("texMatrix");
        this.xUnitLoc = this.shader.getUniformLocation("xUnit");
        this.coeffsLoc = this.shader.getUniformLocation("coeffs");
        GLES20.glUniform1i(this.shader.getUniformLocation("tex"), 0);
        GlUtil.checkNoGLES2Error("Initialize fragment shader uniform values.");
        this.shader.setVertexAttribArray("in_pos", 2, DEVICE_RECTANGLE);
        this.shader.setVertexAttribArray("in_tc", 2, TEXTURE_RECTANGLE);
    }

    /* renamed from: io.agora.rtc.gl.YuvConverter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$agora$rtc$gl$VideoFrame$TextureBuffer$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.agora.rtc.gl.VideoFrame$TextureBuffer$Type[] r0 = io.agora.rtc.gl.VideoFrame.TextureBuffer.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$agora$rtc$gl$VideoFrame$TextureBuffer$Type = r0
                io.agora.rtc.gl.VideoFrame$TextureBuffer$Type r1 = io.agora.rtc.gl.VideoFrame.TextureBuffer.Type.OES     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$agora$rtc$gl$VideoFrame$TextureBuffer$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                io.agora.rtc.gl.VideoFrame$TextureBuffer$Type r1 = io.agora.rtc.gl.VideoFrame.TextureBuffer.Type.RGB     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.gl.YuvConverter.AnonymousClass1.<clinit>():void");
        }
    }

    private void convert(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, float[] fArr, VideoFrame.TextureBuffer.Type type) {
        int i5;
        int i6;
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        VideoFrame.TextureBuffer.Type type2 = type;
        this.threadChecker.checkIsOnValidThread();
        if (!this.released) {
            if (type2 != this.shaderTextureType) {
                initShader(type2);
            }
            this.shader.useProgram();
            if (i9 % 8 != 0) {
                throw new IllegalArgumentException("Invalid stride, must be a multiple of 8");
            } else if (i9 >= i7) {
                int i10 = (i7 + 3) / 4;
                int i11 = (i7 + 7) / 8;
                int i12 = (i8 + 1) / 2;
                int i13 = i8 + i12;
                if (byteBuffer.capacity() >= i9 * i13) {
                    float[] multiplyMatrices = RendererCommon.multiplyMatrices(fArr, RendererCommon.verticalFlipMatrix());
                    int i14 = i9 / 4;
                    this.textureFrameBuffer.setSize(i14, i13);
                    GLES20.glBindFramebuffer(36160, this.textureFrameBuffer.getFrameBufferId());
                    GlUtil.checkNoGLES2Error("glBindFramebuffer");
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(type.getGlTarget(), i4);
                    GLES20.glUniformMatrix4fv(this.texMatrixLoc, 1, false, multiplyMatrices, 0);
                    GLES20.glViewport(0, 0, i10, i8);
                    float f = (float) i7;
                    GLES20.glUniform2f(this.xUnitLoc, multiplyMatrices[0] / f, multiplyMatrices[1] / f);
                    GLES20.glUniform4f(this.coeffsLoc, 0.299f, 0.587f, 0.114f, CropImageView.DEFAULT_ASPECT_RATIO);
                    GLES20.glDrawArrays(5, 0, 4);
                    GLES20.glViewport(0, i8, i11, i12);
                    GLES20.glUniform2f(this.xUnitLoc, (multiplyMatrices[0] * 2.0f) / f, (multiplyMatrices[1] * 2.0f) / f);
                    GLES20.glUniform4f(this.coeffsLoc, -0.169f, -0.331f, 0.499f, 0.5f);
                    GLES20.glDrawArrays(5, 0, 4);
                    GLES20.glViewport(i9 / 8, i8, i11, i12);
                    GLES20.glUniform4f(this.coeffsLoc, 0.499f, -0.418f, -0.0813f, 0.5f);
                    GLES20.glDrawArrays(5, 0, 4);
                    int i15 = -1;
                    if (GPUFBOValid()) {
                        if (this.nativeHanlder == 0) {
                            this.nativeHanlder = GPUFBOInit(i14, i13);
                        }
                        i15 = GPUFBOReadFrame(this.nativeHanlder, byteBuffer.array(), i14, i13);
                    }
                    if (i15 != 0) {
                        i5 = 0;
                        i6 = 36160;
                        GLES20.glReadPixels(0, 0, i14, i13, 6408, 5121, byteBuffer);
                    } else {
                        i5 = 0;
                        i6 = 36160;
                    }
                    GlUtil.checkNoGLES2Error("YuvConverter.convert");
                    GLES20.glBindFramebuffer(i6, i5);
                    GLES20.glBindTexture(3553, i5);
                    GLES20.glBindTexture(type.getGlTarget(), i5);
                    return;
                }
                throw new IllegalArgumentException("YuvConverter.convert called with too small buffer");
            } else {
                throw new IllegalArgumentException("Invalid stride, must >= width");
            }
        } else {
            throw new IllegalStateException("YuvConverter.convert called on released object");
        }
    }

    public void release() {
        this.threadChecker.checkIsOnValidThread();
        this.released = true;
        GlShader glShader = this.shader;
        if (glShader != null) {
            glShader.release();
        }
        this.textureFrameBuffer.release();
        if (GPUFBOValid()) {
            GPUFBORelease(this.nativeHanlder);
        }
    }
}
