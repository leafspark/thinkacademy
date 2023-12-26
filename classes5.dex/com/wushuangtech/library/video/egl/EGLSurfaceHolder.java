package com.wushuangtech.library.video.egl;

import android.opengl.EGLSurface;
import com.wushuangtech.library.video.bean.MediaCodecSurface;
import com.wushuangtech.utils.OmniLog;
import java.util.ArrayList;
import java.util.List;

public class EGLSurfaceHolder {
    private String TAG = "EGLSurfaceHolder";
    private BaseEGL mBaseEGL;
    private OnEGLSurfaceHolderCallBack mEGLEventCallBack;
    private List<EGLSurfaceWrap> mEGLSurfaceList;

    public interface OnEGLSurfaceHolderCallBack {
        boolean onEGLSurfaceHolderDrawFrame(EGLSurfaceWrap eGLSurfaceWrap);
    }

    public EGLSurfaceHolder(BaseEGL baseEGL, OnEGLSurfaceHolderCallBack onEGLSurfaceHolderCallBack) {
        this.mEGLEventCallBack = onEGLSurfaceHolderCallBack;
        this.mEGLSurfaceList = new ArrayList();
        this.mBaseEGL = baseEGL;
    }

    public void setTAG(String str) {
        this.TAG = str + "::" + this.TAG;
    }

    public EGLSurfaceWrap getEGLSurface(Object obj) {
        List<EGLSurfaceWrap> list = this.mEGLSurfaceList;
        if (!(list == null || obj == null)) {
            for (EGLSurfaceWrap next : list) {
                if (next.window == obj) {
                    return next;
                }
            }
        }
        return null;
    }

    public boolean addEGLSurface(EGLSurfaceType eGLSurfaceType, Object obj) {
        if (obj == null) {
            return true;
        }
        EGLSurfaceWrap eGLSurfaceWrap = new EGLSurfaceWrap();
        eGLSurfaceWrap.setTAG(this.TAG);
        if (!(this.mEGLSurfaceList == null || this.mBaseEGL == null)) {
            eGLSurfaceWrap.mType = eGLSurfaceType;
            if (obj instanceof EGLSurface) {
                eGLSurfaceWrap.eglSurface14 = (EGLSurface) obj;
                eGLSurfaceWrap.window = obj;
            } else if (obj instanceof javax.microedition.khronos.egl.EGLSurface) {
                eGLSurfaceWrap.eglSurface11 = (javax.microedition.khronos.egl.EGLSurface) obj;
                eGLSurfaceWrap.window = obj;
            } else if (obj instanceof MediaCodecSurface) {
                MediaCodecSurface mediaCodecSurface = (MediaCodecSurface) obj;
                EGLSurfaceWrap createWindowEGLSurface = this.mBaseEGL.createWindowEGLSurface(mediaCodecSurface.getSurface());
                if (createWindowEGLSurface == null) {
                    logE("Update EGLSurface, create encode EGLSurface failed! window=" + obj);
                    return false;
                }
                createWindowEGLSurface.mType = eGLSurfaceType;
                createWindowEGLSurface.mWindowId = mediaCodecSurface.getId();
                eGLSurfaceWrap = createWindowEGLSurface;
            } else {
                eGLSurfaceWrap = this.mBaseEGL.createWindowEGLSurface(obj);
                if (eGLSurfaceWrap == null) {
                    logE("Update EGLSurface, create display EGLSurface failed! window=" + obj);
                    return false;
                }
                eGLSurfaceWrap.mType = eGLSurfaceType;
            }
            this.mEGLSurfaceList.add(eGLSurfaceWrap);
            StringBuilder sb = new StringBuilder();
            sb.append("EGLSurface create success! window=");
            sb.append(obj);
            sb.append(",wrap=");
            sb.append(eGLSurfaceWrap.toString());
            sb.append(",size=");
            List<EGLSurfaceWrap> list = this.mEGLSurfaceList;
            sb.append(list == null ? "null" : Integer.valueOf(list.size()));
            logI(sb.toString());
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean releaseEGLSurface(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.wushuangtech.library.video.egl.BaseEGL r1 = r7.mBaseEGL
            if (r1 == 0) goto L_0x00e1
            java.util.List<com.wushuangtech.library.video.egl.EGLSurfaceWrap> r1 = r7.mEGLSurfaceList
            if (r1 == 0) goto L_0x00e1
            int r1 = r1.size()
            if (r1 > 0) goto L_0x0014
            goto L_0x00e1
        L_0x0014:
            boolean r1 = r8 instanceof com.wushuangtech.library.video.bean.MediaCodecSurface
            r2 = 0
            r3 = -1
            if (r1 == 0) goto L_0x0040
            java.util.List<com.wushuangtech.library.video.egl.EGLSurfaceWrap> r1 = r7.mEGLSurfaceList
            java.util.Iterator r1 = r1.iterator()
            r4 = r2
        L_0x0021:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x005f
            java.lang.Object r5 = r1.next()
            com.wushuangtech.library.video.egl.EGLSurfaceWrap r5 = (com.wushuangtech.library.video.egl.EGLSurfaceWrap) r5
            r6 = r8
            com.wushuangtech.library.video.bean.MediaCodecSurface r6 = (com.wushuangtech.library.video.bean.MediaCodecSurface) r6
            java.lang.String r6 = r6.getId()
            java.lang.String r5 = r5.mWindowId
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x003d
            goto L_0x0060
        L_0x003d:
            int r4 = r4 + 1
            goto L_0x0021
        L_0x0040:
            java.util.List<com.wushuangtech.library.video.egl.EGLSurfaceWrap> r1 = r7.mEGLSurfaceList
            java.util.Iterator r1 = r1.iterator()
            r4 = r2
        L_0x0047:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x005f
            java.lang.Object r5 = r1.next()
            com.wushuangtech.library.video.egl.EGLSurfaceWrap r5 = (com.wushuangtech.library.video.egl.EGLSurfaceWrap) r5
            java.lang.Object r5 = r5.window
            boolean r5 = r5.equals(r8)
            if (r5 == 0) goto L_0x005c
            goto L_0x0060
        L_0x005c:
            int r4 = r4 + 1
            goto L_0x0047
        L_0x005f:
            r4 = r3
        L_0x0060:
            java.lang.String r1 = "EGLSurface release failed! window="
            if (r4 != r3) goto L_0x0077
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.logE(r8)
            return r2
        L_0x0077:
            java.util.List<com.wushuangtech.library.video.egl.EGLSurfaceWrap> r2 = r7.mEGLSurfaceList
            java.lang.Object r2 = r2.remove(r4)
            com.wushuangtech.library.video.egl.EGLSurfaceWrap r2 = (com.wushuangtech.library.video.egl.EGLSurfaceWrap) r2
            if (r2 != 0) goto L_0x0082
            return r0
        L_0x0082:
            com.wushuangtech.library.video.egl.BaseEGL r3 = r7.mBaseEGL
            boolean r3 = r3.destoryEGLSurface(r2)
            java.lang.String r4 = ", size="
            java.lang.String r5 = ", wrap="
            if (r3 == 0) goto L_0x00b9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "EGLSurface release success! window="
            r1.append(r3)
            r1.append(r8)
            r1.append(r5)
            java.lang.String r8 = r2.toString()
            r1.append(r8)
            r1.append(r4)
            java.util.List<com.wushuangtech.library.video.egl.EGLSurfaceWrap> r8 = r7.mEGLSurfaceList
            int r8 = r8.size()
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r7.logI(r8)
            goto L_0x00e1
        L_0x00b9:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            r3.append(r8)
            r3.append(r5)
            java.lang.String r8 = r2.toString()
            r3.append(r8)
            r3.append(r4)
            java.util.List<com.wushuangtech.library.video.egl.EGLSurfaceWrap> r8 = r7.mEGLSurfaceList
            int r8 = r8.size()
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            r7.logE(r8)
        L_0x00e1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.library.video.egl.EGLSurfaceHolder.releaseEGLSurface(java.lang.Object):boolean");
    }

    public void destroy() {
        List<EGLSurfaceWrap> list = this.mEGLSurfaceList;
        if (!(list == null || this.mBaseEGL == null)) {
            for (EGLSurfaceWrap destoryEGLSurface : list) {
                this.mBaseEGL.destoryEGLSurface(destoryEGLSurface);
            }
        }
        List<EGLSurfaceWrap> list2 = this.mEGLSurfaceList;
        if (list2 != null) {
            list2.clear();
            this.mEGLSurfaceList = null;
        }
        this.mBaseEGL = null;
        this.mEGLEventCallBack = null;
    }

    public boolean renderEGLSurface(EGLSurfaceWrap eGLSurfaceWrap) {
        return renderEGLSurface(eGLSurfaceWrap, true);
    }

    public boolean renderEGLSurface(EGLSurfaceWrap eGLSurfaceWrap, boolean z) {
        if (!(eGLSurfaceWrap == null || this.mBaseEGL == null)) {
            if (!eGLSurfaceWrap.mValid) {
                String str = this.TAG;
                OmniLog.e(str, "eglSurfaceWrap:" + eGLSurfaceWrap.toString());
                return false;
            } else if (!this.mBaseEGL.makeCurrent(eGLSurfaceWrap)) {
                eGLSurfaceWrap.updateRenderStatus(-1);
                return true;
            } else {
                OnEGLSurfaceHolderCallBack onEGLSurfaceHolderCallBack = this.mEGLEventCallBack;
                if (onEGLSurfaceHolderCallBack != null && !onEGLSurfaceHolderCallBack.onEGLSurfaceHolderDrawFrame(eGLSurfaceWrap)) {
                    eGLSurfaceWrap.updateRenderStatus(-2);
                    return true;
                } else if (!z) {
                    return true;
                } else {
                    if (!this.mBaseEGL.swapBuffers(eGLSurfaceWrap)) {
                        eGLSurfaceWrap.updateRenderStatus(-3);
                        return true;
                    }
                    eGLSurfaceWrap.updateRenderStatus(0);
                }
            }
        }
        return true;
    }

    private void logI(String str) {
        OmniLog.i(OmniLog.VIDEO_RENDER_WATCH, this.TAG, str);
    }

    private void logE(String str) {
        OmniLog.e(OmniLog.VIDEO_RENDER_WATCH, this.TAG, str);
    }
}
