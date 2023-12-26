package com.wushuangtech.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLException;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.util.Log;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

public class MyGLUtils {
    public static final float[] IDENTITY_MATRIX;
    private static final int SIZEOF_FLOAT = 4;
    public static final String TAG = "MyGLUtils";

    static {
        float[] fArr = new float[16];
        IDENTITY_MATRIX = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    private MyGLUtils() {
    }

    public static int createProgram(String str, String str2) {
        int loadShader;
        int loadShader2 = loadShader(35633, str);
        int i = 0;
        if (loadShader2 == 0 || (loadShader = loadShader(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram == 0) {
            logE(TAG, "Could not create program");
            return 0;
        }
        GLES20.glAttachShader(glCreateProgram, loadShader2);
        GLES20.glAttachShader(glCreateProgram, loadShader);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            logE(TAG, "Could not link program: " + GLES20.glGetProgramInfoLog(glCreateProgram));
            GLES20.glDeleteProgram(0);
        } else {
            i = glCreateProgram;
        }
        GLES20.glDeleteShader(loadShader2);
        GLES20.glDeleteShader(loadShader);
        return i;
    }

    /* access modifiers changed from: protected */
    public String loadShaderFile(Resources resources, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream open = resources.getAssets().open(str);
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            while (true) {
                int read = open.read(bArr);
                if (-1 == read) {
                    return sb.toString().replaceAll("\\r\\n", "\n");
                }
                sb.append(new String(bArr, 0, read));
            }
        } catch (Exception unused) {
            return null;
        }
    }

    private static int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        String str2 = "Could not compile shader " + i + " | info : " + GLES20.glGetShaderInfoLog(glCreateShader);
        if (!OmniLog.DEBUG_MODE) {
            Log.e(TAG, str2);
            return 0;
        }
        throw new RuntimeException(str2);
    }

    public static FloatBuffer createFloatBuffer(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static int createTextureByRawData(ByteBuffer byteBuffer, int i, int i2, int i3) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        checkGles20Error("glGenTextures");
        GLES20.glBindTexture(3553, iArr[0]);
        checkGles20Error("loadImageTexture");
        GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i3, 5121, byteBuffer);
        checkGles20Error("glTexImage2D");
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glBindTexture(3553, 0);
        return iArr[0];
    }

    public static int createTextureByBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        GLES20.glBindTexture(3553, 0);
        return iArr[0];
    }

    public static int[] createWhiteTextureId(boolean z, int i, int i2) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        if (z) {
            GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, (Buffer) null);
        } else {
            GLES20.glTexImage2D(3553, 0, 6407, i, i2, 0, 6407, 33635, (Buffer) null);
        }
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        return iArr;
    }

    public static int createWhiteOESTextureId() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        return iArr[0];
    }

    public static int[] createFrameBuffer(int i, int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            logE(TAG, "Create frame buffer failed! width or height is zero!");
            return null;
        } else if (i == 0) {
            logE(TAG, "Create frame buffer failed! texture id is zero!");
            return null;
        } else {
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            GLES20.glBindFramebuffer(36160, iArr[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, new int[]{i}[0], 0);
            int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
            if (glCheckFramebufferStatus == 36053) {
                return iArr;
            }
            logE(TAG, "Failed to set up render buffer with status " + glCheckFramebufferStatus + " and error " + GLES20.glGetError());
            return null;
        }
    }

    public static int[] createPboBuffer(int i, int i2) {
        int[] iArr = new int[2];
        GLES20.glGenBuffers(2, iArr, 0);
        OmniLog.lp(TAG, "Create pbo buffer, width : " + i + " | height : " + i2);
        GLES20.glBindBuffer(35051, iArr[0]);
        int i3 = i * i2 * 4;
        GLES20.glBufferData(35051, i3, (Buffer) null, 35045);
        GLES20.glBindBuffer(35051, iArr[1]);
        GLES20.glBufferData(35051, i3, (Buffer) null, 35045);
        GLES20.glBindBuffer(35051, 0);
        return iArr;
    }

    public static void checkLocation(int i, String str) {
        if (i >= 0) {
            return;
        }
        if (!OmniLog.DEBUG_MODE) {
            logE(TAG, "checkLocation -> Unable to locate '" + str + "' in program");
            return;
        }
        throw new RuntimeException("Unable to locate '" + str + "' in program");
    }

    public static void checkEgl10Error(EGL10 egl10, String str, String str2) {
        int eglGetError;
        if (egl10 != null && (eglGetError = egl10.eglGetError()) != 12288) {
            String eGLErrorString = GLUtils.getEGLErrorString(eglGetError);
            logE(str, str2 + ": glError :" + eGLErrorString);
        }
    }

    public static void printlnEGLErrorMsg(String str, String str2, String str3) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            String eGLErrorString = GLUtils.getEGLErrorString(eglGetError);
            logE(str2, str3 + " <" + str + "> EGL error msg : " + eGLErrorString);
        }
    }

    private static void checkGles20Error(String str) {
        if (hasValidEgl10Context() || hasValidEgl14Context()) {
            if (Thread.currentThread().getName().startsWith("GLThread")) {
                int glGetError = GLES20.glGetError();
                if (glGetError == 0) {
                    return;
                }
                if (OmniLog.DEBUG_MODE) {
                    throw new GLException(glGetError);
                }
                try {
                    throw new GLException(glGetError);
                } catch (GLException unused) {
                    logE(TAG, "GLES20 Error (" + glesGetErrorModule() + ") (" + str + "): " + GLUtils.getEGLErrorString(glGetError));
                }
            } else if (OmniLog.DEBUG_MODE) {
                throw new GLException(-1, "call to OpenGL ES API outside GLThread : " + Thread.currentThread().getName());
            } else {
                try {
                    throw new GLException(-1, "call to OpenGL ES API outside GLThread : " + Thread.currentThread().getName());
                } catch (GLException unused2) {
                    logE(TAG, "GLES20 Error (" + glesGetErrorModule() + ") (" + str + "): call to OpenGL ES API outside GLThread");
                }
            }
        } else if (OmniLog.DEBUG_MODE) {
            throw new GLException(-1, "call to OpenGL ES API with no current context");
        } else {
            try {
                throw new GLException(-1, "call to OpenGL ES API with no current context");
            } catch (GLException unused3) {
                logE(TAG, "GLES20 Error (" + glesGetErrorModule() + ") (" + str + "): call to OpenGL ES API with no current context");
            }
        }
    }

    private static boolean hasValidEgl10Context() {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        return (egl10 == null || egl10.eglGetCurrentContext() == null || egl10.eglGetCurrentContext().equals(EGL10.EGL_NO_CONTEXT)) ? false : true;
    }

    private static boolean hasValidEgl14Context() {
        return EGL14.eglGetCurrentContext() == EGL14.EGL_NO_CONTEXT;
    }

    private static String glesGetErrorModule() {
        try {
            return String.valueOf(Thread.currentThread().getStackTrace()[4]);
        } catch (IndexOutOfBoundsException unused) {
            return "";
        }
    }

    private static void logE(String str, String str2) {
        OmniLog.e("<VRW> - " + str, str2);
    }
}
