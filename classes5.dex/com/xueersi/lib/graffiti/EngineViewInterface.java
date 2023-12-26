package com.xueersi.lib.graffiti;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.xueersi.lib.graffiti.core.RenderServer;
import com.xueersi.lib.graffiti.entity.DrawActionParams;
import com.xueersi.lib.graffiti.entity.RestoreSceneEntity;
import com.xueersi.lib.graffiti.img.LoadImageManager;
import com.xueersi.lib.graffiti.utils.MainHandler;
import com.xueersi.lib.graffiti.utils.XesLog;
import com.xueersi.lib.graffiti.view.CanvasView;
import com.xueersi.lib.graffiti.view.CanvasViewContainer;
import com.xueersi.lib.graffiti.view.TouchGesture;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public interface EngineViewInterface {

    public interface CallBack {
        void onViewReady(boolean z, int i, int i2);
    }

    public interface ProduceCallBack {
        public static final int ACTION_DOWN = 1;
        public static final int ACTION_MOVE = 2;
        public static final int ACTION_UP = 3;

        void onGraffitiUpdate(int i, int i2, float f, float f2);
    }

    void clear();

    void clearToCanvas(int i);

    View createView(Context context);

    void destroy();

    void drawGraffiti(String str, DrawActionParams drawActionParams);

    void drawShape(String str, DrawActionParams drawActionParams, int i);

    void drawShape(String str, List<DrawActionParams> list, int i);

    void drawTemp(String str, DrawActionParams drawActionParams, boolean z);

    void invalidateLayer(int i, int i2);

    void resetGraffiti(String str, Map<Integer, List<DrawActionParams>> map);

    void restoreScene(String str, RestoreSceneEntity restoreSceneEntity);

    void setCallBack(CallBack callBack);

    void setCanvasTag(String str);

    void setProduceCallBack(ProduceCallBack produceCallBack);

    void updateSubCanvas(String str, WXWBAction wXWBAction, int i);

    public static class DefaultViewImp implements EngineViewInterface, LoadImageManager.OnLoadListener, RenderServer {
        /* access modifiers changed from: private */
        public CallBack callBack;
        /* access modifiers changed from: private */
        public WXTGraffitiEngineImpl engine;
        private ProduceCallBack mProduceCallBack;
        /* access modifiers changed from: private */
        public WeakReference<CanvasView> mRealViewRef;
        /* access modifiers changed from: private */
        public String mTag;
        private MainHandler mainHandler = new MainHandler(Looper.getMainLooper());

        public void onReady(WXWBAction wXWBAction, Drawable drawable) {
            invalidateLayer(wXWBAction.getCanvasId(), 0);
        }

        public void onPlaceHolder(WXWBAction wXWBAction, Drawable drawable) {
            invalidateLayer(wXWBAction.getCanvasId(), 0);
        }

        public void addView(RenderServer.Level level, View view) {
            WeakReference<CanvasView> weakReference = this.mRealViewRef;
            if (weakReference != null && weakReference.get() != null) {
                if (view.getParent() instanceof ViewGroup) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                ((CanvasView) this.mRealViewRef.get()).addView(view);
            }
        }

        public <T extends View> T findViewById(int i) {
            WeakReference<CanvasView> weakReference = this.mRealViewRef;
            if (weakReference == null || weakReference.get() == null) {
                return null;
            }
            return ((CanvasView) this.mRealViewRef.get()).findViewById(i);
        }

        public void removeView(View view) {
            WeakReference<CanvasView> weakReference = this.mRealViewRef;
            if (weakReference != null && weakReference.get() != null) {
                ((CanvasView) this.mRealViewRef.get()).removeView(view);
            }
        }

        class CanvasViewWrapper extends CanvasViewContainer {
            private int dispatchHeight;
            private int dispatchWidth;

            public CanvasViewWrapper(Context context) {
                super(context);
            }

            public CanvasViewWrapper(Context context, AttributeSet attributeSet) {
                super(context, attributeSet);
            }

            public CanvasViewWrapper(Context context, AttributeSet attributeSet, int i) {
                super(context, attributeSet, i);
            }

            /* access modifiers changed from: protected */
            public void onSizeChanged(int i, int i2, int i3, int i4) {
                super.onSizeChanged(i, i2, i3, i4);
                LocalCanvasSize.sdkInner().setLocalCanvasSize(DefaultViewImp.this.mTag, i, i2);
                if (DefaultViewImp.this.callBack != null) {
                    if (i <= 0 || i2 <= 0) {
                        if (i == 0 || i2 == 0) {
                            DefaultViewImp.this.callBack.onViewReady(false, i, i2);
                        }
                    } else if (!(this.dispatchWidth == i && this.dispatchHeight == i2)) {
                        DefaultViewImp.this.callBack.onViewReady(true, i, i2);
                    }
                    this.dispatchWidth = i;
                    this.dispatchHeight = i2;
                }
            }

            /* access modifiers changed from: protected */
            public void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                if (DefaultViewImp.this.callBack != null) {
                    DefaultViewImp.this.callBack.onViewReady(false, 0, 0);
                    this.dispatchWidth = 0;
                    this.dispatchHeight = 0;
                }
            }

            /* access modifiers changed from: protected */
            public void onAttachedToWindow() {
                super.onAttachedToWindow();
                if (DefaultViewImp.this.callBack != null) {
                    int measuredWidth = getMeasuredWidth();
                    int measuredHeight = getMeasuredHeight();
                    if (measuredWidth > 0 && measuredHeight > 0) {
                        DefaultViewImp.this.callBack.onViewReady(true, measuredWidth, measuredHeight);
                        this.dispatchWidth = measuredWidth;
                        this.dispatchHeight = measuredHeight;
                    }
                }
            }
        }

        public DefaultViewImp(WXTGraffitiEngineImpl wXTGraffitiEngineImpl) {
            this.engine = wXTGraffitiEngineImpl;
        }

        public void setCanvasTag(String str) {
            this.mTag = str;
        }

        public View createView(Context context) {
            CanvasViewWrapper canvasViewWrapper = new CanvasViewWrapper(context);
            canvasViewWrapper.setEngine(this.engine);
            this.mRealViewRef = new WeakReference<>(canvasViewWrapper);
            TouchGesture touchGesture = new TouchGesture();
            touchGesture.setCallback(new TouchGesture.Callback() {
                public boolean touchable() {
                    return DefaultViewImp.this.engine.getSetting().isTouchable();
                }
            });
            touchGesture.setProduceCallBack(this.mProduceCallBack);
            canvasViewWrapper.setTouchGesture(touchGesture);
            return canvasViewWrapper;
        }

        public void clear() {
            WeakReference<CanvasView> weakReference = this.mRealViewRef;
            if (weakReference != null && weakReference.get() != null) {
                this.mainHandler.post(new Runnable() {
                    public void run() {
                        if (DefaultViewImp.this.mRealViewRef.get() != null) {
                            ((CanvasView) DefaultViewImp.this.mRealViewRef.get()).clearAll();
                        }
                    }
                });
            }
        }

        public void setCallBack(CallBack callBack2) {
            this.callBack = callBack2;
        }

        public void setProduceCallBack(ProduceCallBack produceCallBack) {
            this.mProduceCallBack = produceCallBack;
        }

        public void destroy() {
            this.mainHandler.post(new Runnable() {
                public void run() {
                    if (DefaultViewImp.this.mRealViewRef != null) {
                        if (DefaultViewImp.this.mRealViewRef.get() != null) {
                            ((CanvasView) DefaultViewImp.this.mRealViewRef.get()).destroy();
                        }
                        DefaultViewImp.this.mRealViewRef.clear();
                    }
                }
            });
        }

        public void clearToCanvas(final int i) {
            if (this.mRealViewRef != null) {
                this.mainHandler.post(new Runnable() {
                    public void run() {
                        if (DefaultViewImp.this.mRealViewRef != null && DefaultViewImp.this.mRealViewRef.get() != null) {
                            ((CanvasView) DefaultViewImp.this.mRealViewRef.get()).clearCanvas(i);
                        }
                    }
                });
            }
        }

        public void updateSubCanvas(final String str, final WXWBAction wXWBAction, final int i) {
            if (this.mRealViewRef != null) {
                this.mainHandler.post(new Runnable() {
                    public void run() {
                        if (DefaultViewImp.this.mRealViewRef != null && DefaultViewImp.this.mRealViewRef.get() != null) {
                            if (i != 12) {
                                ((CanvasView) DefaultViewImp.this.mRealViewRef.get()).updateSubCanvas(str, wXWBAction);
                            } else {
                                ((CanvasView) DefaultViewImp.this.mRealViewRef.get()).deleteSubCanvas(str, wXWBAction);
                            }
                        }
                    }
                });
            }
        }

        public void drawTemp(final String str, final DrawActionParams drawActionParams, final boolean z) {
            if (this.mRealViewRef != null) {
                this.mainHandler.post(new Runnable() {
                    public void run() {
                        if (DefaultViewImp.this.mRealViewRef != null && DefaultViewImp.this.mRealViewRef.get() != null) {
                            ((CanvasView) DefaultViewImp.this.mRealViewRef.get()).drawTempPoint(str, drawActionParams, z);
                        }
                    }
                });
            }
        }

        public void invalidateLayer(final int i, int i2) {
            if (this.mRealViewRef != null) {
                this.mainHandler.post(new Runnable() {
                    public void run() {
                        if (DefaultViewImp.this.mRealViewRef != null && DefaultViewImp.this.mRealViewRef.get() != null) {
                            ((CanvasView) DefaultViewImp.this.mRealViewRef.get()).invalidateShapeLayer(i);
                        }
                    }
                });
            }
        }

        public void resetGraffiti(final String str, final Map<Integer, List<DrawActionParams>> map) {
            if (this.mRealViewRef != null) {
                this.mainHandler.post(new Runnable() {
                    public void run() {
                        if (DefaultViewImp.this.mRealViewRef != null && DefaultViewImp.this.mRealViewRef.get() != null) {
                            ((CanvasView) DefaultViewImp.this.mRealViewRef.get()).resetGraffiti(str, map);
                        }
                    }
                });
            }
        }

        public void drawGraffiti(final String str, final DrawActionParams drawActionParams) {
            if (this.mRealViewRef != null) {
                this.mainHandler.post(new Runnable() {
                    public void run() {
                        if (DefaultViewImp.this.mRealViewRef != null && DefaultViewImp.this.mRealViewRef.get() != null) {
                            DrawActionParams drawActionParams = drawActionParams;
                            if (drawActionParams == null || drawActionParams.getLastAction() == null) {
                                if (XesLog.isEnabled()) {
                                    XesLog.d("drawGraffiti数据异常");
                                }
                            } else if (drawActionParams.getDrawableObject() != null) {
                                ((CanvasView) DefaultViewImp.this.mRealViewRef.get()).updateGraffiti(str, drawActionParams.getLastAction().getCanvasId(), drawActionParams);
                            } else {
                                ((CanvasView) DefaultViewImp.this.mRealViewRef.get()).clearGraffiti(str, drawActionParams.getLastAction().getCanvasId());
                                if (XesLog.isEnabled()) {
                                    XesLog.d("触发单独清除涂鸦");
                                }
                            }
                        } else if (XesLog.isEnabled()) {
                            XesLog.d("CanvasView被回收");
                        }
                    }
                });
            }
        }

        public void drawShape(final String str, final DrawActionParams drawActionParams, final int i) {
            if (this.mRealViewRef != null) {
                this.mainHandler.post(new Runnable() {
                    public void run() {
                        DrawActionParams drawActionParams;
                        if (DefaultViewImp.this.mRealViewRef != null && DefaultViewImp.this.mRealViewRef.get() != null && (drawActionParams = drawActionParams) != null && drawActionParams.getLastAction() != null) {
                            if (i == 3) {
                                ((CanvasView) DefaultViewImp.this.mRealViewRef.get()).deleteShape(str, drawActionParams.getLastAction().getCanvasId(), drawActionParams);
                            } else {
                                ((CanvasView) DefaultViewImp.this.mRealViewRef.get()).updateShape(str, drawActionParams.getLastAction().getCanvasId(), drawActionParams);
                            }
                        }
                    }
                });
            }
        }

        public void drawShape(final String str, final List<DrawActionParams> list, final int i) {
            if (this.mRealViewRef != null) {
                this.mainHandler.post(new Runnable() {
                    public void run() {
                        List list;
                        if (DefaultViewImp.this.mRealViewRef != null && DefaultViewImp.this.mRealViewRef.get() != null && (list = list) != null && !list.isEmpty()) {
                            if (i == 3) {
                                ((CanvasView) DefaultViewImp.this.mRealViewRef.get()).deleteShape(str, list);
                            } else {
                                ((CanvasView) DefaultViewImp.this.mRealViewRef.get()).updateShape(str, list);
                            }
                        }
                    }
                });
            }
        }

        public void restoreScene(final String str, final RestoreSceneEntity restoreSceneEntity) {
            if (this.mRealViewRef != null) {
                this.mainHandler.post(new Runnable() {
                    public void run() {
                        if (DefaultViewImp.this.mRealViewRef != null && DefaultViewImp.this.mRealViewRef.get() != null) {
                            ((CanvasView) DefaultViewImp.this.mRealViewRef.get()).restoreScene(str, restoreSceneEntity);
                        }
                    }
                });
            }
        }
    }
}
