package com.wushuangtech.myvideoimprove.render.imageprocessing.beauty;

import android.opengl.GLES20;
import com.wushuangtech.library.video.opengles.BasicFilter;
import java.nio.FloatBuffer;

public class BeautifyFilter extends BasicFilter {
    private static final String BEAUTFY_SH = "   varying highp vec2 v_TexCoord;\n\n    uniform sampler2D u_Texture0;\n\n    const highp vec2 singleStepOffset = vec2(0.0018518518, 0.0012722646);\n    uniform highp vec4 params;\n    uniform highp float brightness;\n\n    const highp vec3 W = vec3(0.299, 0.587, 0.114);\n    const highp mat3 saturateMatrix = mat3(\n        1.1102, -0.0598, -0.061,\n        -0.0774, 1.0826, -0.1186,\n        -0.0228, -0.0228, 1.1772);\n    highp vec2 blurCoordinates[24];\n\n    highp float hardLight(highp float color) {\n    if (color <= 0.5)\n        color = color * color * 2.0;\n    else\n        color = 1.0 - ((1.0 - color)*(1.0 - color) * 2.0);\n    return color;\n}\n\n    void main(){\n    highp vec3 centralColor = texture2D(u_Texture0, v_TexCoord).rgb;\n    blurCoordinates[0] = v_TexCoord.xy + singleStepOffset * vec2(0.0, -10.0);\n    blurCoordinates[1] = v_TexCoord.xy + singleStepOffset * vec2(0.0, 10.0);\n    blurCoordinates[2] = v_TexCoord.xy + singleStepOffset * vec2(-10.0, 0.0);\n    blurCoordinates[3] = v_TexCoord.xy + singleStepOffset * vec2(10.0, 0.0);\n    blurCoordinates[4] = v_TexCoord.xy + singleStepOffset * vec2(5.0, -8.0);\n    blurCoordinates[5] = v_TexCoord.xy + singleStepOffset * vec2(5.0, 8.0);\n    blurCoordinates[6] = v_TexCoord.xy + singleStepOffset * vec2(-5.0, 8.0);\n    blurCoordinates[7] = v_TexCoord.xy + singleStepOffset * vec2(-5.0, -8.0);\n    blurCoordinates[8] = v_TexCoord.xy + singleStepOffset * vec2(8.0, -5.0);\n    blurCoordinates[9] = v_TexCoord.xy + singleStepOffset * vec2(8.0, 5.0);\n    blurCoordinates[10] = v_TexCoord.xy + singleStepOffset * vec2(-8.0, 5.0);\n    blurCoordinates[11] = v_TexCoord.xy + singleStepOffset * vec2(-8.0, -5.0);\n    blurCoordinates[12] = v_TexCoord.xy + singleStepOffset * vec2(0.0, -6.0);\n    blurCoordinates[13] = v_TexCoord.xy + singleStepOffset * vec2(0.0, 6.0);\n    blurCoordinates[14] = v_TexCoord.xy + singleStepOffset * vec2(6.0, 0.0);\n    blurCoordinates[15] = v_TexCoord.xy + singleStepOffset * vec2(-6.0, 0.0);\n    blurCoordinates[16] = v_TexCoord.xy + singleStepOffset * vec2(-4.0, -4.0);\n    blurCoordinates[17] = v_TexCoord.xy + singleStepOffset * vec2(-4.0, 4.0);\n    blurCoordinates[18] = v_TexCoord.xy + singleStepOffset * vec2(4.0, -4.0);\n    blurCoordinates[19] = v_TexCoord.xy + singleStepOffset * vec2(4.0, 4.0);\n    blurCoordinates[20] = v_TexCoord.xy + singleStepOffset * vec2(-2.0, -2.0);\n    blurCoordinates[21] = v_TexCoord.xy + singleStepOffset * vec2(-2.0, 2.0);\n    blurCoordinates[22] = v_TexCoord.xy + singleStepOffset * vec2(2.0, -2.0);\n    blurCoordinates[23] = v_TexCoord.xy + singleStepOffset * vec2(2.0, 2.0);\n\n    highp float sampleColor = centralColor.g * 22.0;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[0]).g;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[1]).g;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[2]).g;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[3]).g;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[4]).g;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[5]).g;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[6]).g;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[7]).g;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[8]).g;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[9]).g;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[10]).g;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[11]).g;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[12]).g * 2.0;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[13]).g * 2.0;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[14]).g * 2.0;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[15]).g * 2.0;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[16]).g * 2.0;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[17]).g * 2.0;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[18]).g * 2.0;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[19]).g * 2.0;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[20]).g * 3.0;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[21]).g * 3.0;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[22]).g * 3.0;\n    sampleColor += texture2D(u_Texture0, blurCoordinates[23]).g * 3.0;\n\n    sampleColor = sampleColor / 62.0;\n\n    highp float highPass = centralColor.g - sampleColor + 0.5;\n\n    for (int i = 0; i < 5; i++) {\n        highPass = hardLight(highPass);\n    }\n    highp float lumance = dot(centralColor, W);\n\n    highp float alpha = pow(lumance, params.r);\n\n    highp vec3 smoothColor = centralColor + (centralColor-vec3(highPass))*alpha*0.1;\n\n    smoothColor.r = clamp(pow(smoothColor.r, params.g), 0.0, 1.0);\n    smoothColor.g = clamp(pow(smoothColor.g, params.g), 0.0, 1.0);\n    smoothColor.b = clamp(pow(smoothColor.b, params.g), 0.0, 1.0);\n\n    highp vec3 lvse = vec3(1.0)-(vec3(1.0)-smoothColor)*(vec3(1.0)-centralColor);\n    highp vec3 bianliang = max(smoothColor, centralColor);\n    highp vec3 rouguang = 2.0*centralColor*smoothColor + centralColor*centralColor - 2.0*centralColor*centralColor*smoothColor;\n\n    gl_FragColor = vec4(mix(centralColor, lvse, alpha), 1.0);\n    gl_FragColor.rgb = mix(gl_FragColor.rgb, bianliang, alpha);\n    gl_FragColor.rgb = mix(gl_FragColor.rgb, rouguang, params.b);\n\n    highp vec3 satcolor = gl_FragColor.rgb * saturateMatrix;\n    gl_FragColor.rgb = mix(gl_FragColor.rgb, satcolor, params.a);\n    gl_FragColor.rgb = vec3(gl_FragColor.rgb + vec3(brightness));\n}";
    private int brightnessHandle;
    private float mBrightLevel;
    private final Object mLock = new Object();
    private FloatBuffer mParamsBuffer;
    private int paramsHandle;

    /* access modifiers changed from: protected */
    public String getFragmentShader() {
        return BEAUTFY_SH;
    }

    public BeautifyFilter() {
        markAsDirty();
        setBrightLevel(0.56f);
        setAmount(0.24f);
    }

    /* access modifiers changed from: protected */
    public FloatBuffer getTextureBuffer() {
        return mTextureHorizontalFlipBuffer;
    }

    /* access modifiers changed from: protected */
    public void initShaderHandles() {
        super.initShaderHandles();
        this.paramsHandle = GLES20.glGetUniformLocation(this.mProgramHandle, "params");
        this.brightnessHandle = GLES20.glGetUniformLocation(this.mProgramHandle, "brightness");
    }

    public void destroy() {
        super.destroy();
        this.paramsHandle = 0;
        this.brightnessHandle = 0;
    }

    /* access modifiers changed from: protected */
    public void passShaderValues() {
        super.passShaderValues();
        synchronized (this.mLock) {
            GLES20.glUniform4fv(this.paramsHandle, 1, this.mParamsBuffer);
        }
        GLES20.glUniform1f(this.brightnessHandle, this.mBrightLevel);
    }

    public void setBrightLevel(float f) {
        this.mBrightLevel = (f - 8.0f) * 0.6f;
    }

    public void setAmount(float f) {
        synchronized (this.mLock) {
            this.mParamsBuffer = FloatBuffer.wrap(new float[]{1.0f - (0.6f * f), 1.0f - (f * 0.3f), 0.241f, 0.241f});
        }
    }
}
