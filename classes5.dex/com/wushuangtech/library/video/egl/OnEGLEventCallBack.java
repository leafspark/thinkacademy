package com.wushuangtech.library.video.egl;

import com.wushuangtech.bean.CommonEventBean;

public interface OnEGLEventCallBack {
    void onEGLRendererError(int i);

    void onEGLRendererEvent(CommonEventBean commonEventBean);
}
