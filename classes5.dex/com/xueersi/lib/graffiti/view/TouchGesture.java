package com.xueersi.lib.graffiti.view;

import com.xueersi.lib.graffiti.EngineViewInterface;

public class TouchGesture {
    private Callback callback;
    private EngineViewInterface.ProduceCallBack produceCallBack;

    public interface Callback {
        boolean touchable();
    }

    public void setProduceCallBack(EngineViewInterface.ProduceCallBack produceCallBack2) {
        this.produceCallBack = produceCallBack2;
    }

    public void setCallback(Callback callback2) {
        this.callback = callback2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        if (r9 != 3) goto L_0x006f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(int r8, android.view.View r9, android.view.MotionEvent r10) {
        /*
            r7 = this;
            r9 = 0
            if (r10 != 0) goto L_0x0004
            return r9
        L_0x0004:
            com.xueersi.lib.graffiti.view.TouchGesture$Callback r0 = r7.callback
            if (r0 == 0) goto L_0x000f
            boolean r0 = r0.touchable()
            if (r0 != 0) goto L_0x000f
            return r9
        L_0x000f:
            int r9 = r10.getAction()
            com.xueersi.lib.graffiti.LocalCanvasSize r0 = com.xueersi.lib.graffiti.LocalCanvasSize.sdkInner()
            int r0 = r0.getWidth()
            float r0 = (float) r0
            com.xueersi.lib.graffiti.LocalCanvasSize r1 = com.xueersi.lib.graffiti.LocalCanvasSize.sdkInner()
            int r1 = r1.getHeight()
            float r1 = (float) r1
            float r2 = r10.getX()
            float r10 = r10.getY()
            r3 = 1
            if (r9 == 0) goto L_0x0061
            r4 = 3
            if (r9 == r3) goto L_0x0043
            r5 = 2
            if (r9 == r5) goto L_0x0039
            if (r9 == r4) goto L_0x0043
            goto L_0x006f
        L_0x0039:
            com.xueersi.lib.graffiti.EngineViewInterface$ProduceCallBack r9 = r7.produceCallBack
            if (r9 == 0) goto L_0x006f
            float r2 = r2 / r0
            float r10 = r10 / r1
            r9.onGraffitiUpdate(r8, r5, r2, r10)
            goto L_0x006f
        L_0x0043:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "采集用户触摸屏幕动作-松开或取消 "
            r5.append(r6)
            r5.append(r9)
            java.lang.String r9 = r5.toString()
            com.xueersi.lib.graffiti.utils.XesLog.info(r9)
            com.xueersi.lib.graffiti.EngineViewInterface$ProduceCallBack r9 = r7.produceCallBack
            if (r9 == 0) goto L_0x006f
            float r2 = r2 / r0
            float r10 = r10 / r1
            r9.onGraffitiUpdate(r8, r4, r2, r10)
            goto L_0x006f
        L_0x0061:
            java.lang.String r9 = "采集用户触摸屏幕动作-按下"
            com.xueersi.lib.graffiti.utils.XesLog.info(r9)
            com.xueersi.lib.graffiti.EngineViewInterface$ProduceCallBack r9 = r7.produceCallBack
            if (r9 == 0) goto L_0x006f
            float r2 = r2 / r0
            float r10 = r10 / r1
            r9.onGraffitiUpdate(r8, r3, r2, r10)
        L_0x006f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xueersi.lib.graffiti.view.TouchGesture.onTouchEvent(int, android.view.View, android.view.MotionEvent):boolean");
    }
}
