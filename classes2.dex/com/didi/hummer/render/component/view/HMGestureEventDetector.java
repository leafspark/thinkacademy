package com.didi.hummer.render.component.view;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.render.event.EventManager;
import com.didi.hummer.render.event.base.Event;
import com.didi.hummer.render.event.base.TraceEvent;
import com.didi.hummer.render.event.guesture.LongPressEvent;
import com.didi.hummer.render.event.guesture.PanEvent;
import com.didi.hummer.render.event.guesture.PinchEvent;
import com.didi.hummer.render.event.guesture.SwipeEvent;
import com.didi.hummer.render.event.guesture.TapEvent;
import com.didi.hummer.render.event.guesture.TouchEvent;
import com.didi.hummer.render.event.guesture.common.GestureUtils;
import com.didi.hummer.tools.EventTracer;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;

class HMGestureEventDetector {
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public EventManager eventManager;
    /* access modifiers changed from: private */
    public HummerContext hummerContext;
    /* access modifiers changed from: private */
    public MotionEvent latestMotionEvent;
    /* access modifiers changed from: private */
    public GestureDetector mGestureDetector;
    /* access modifiers changed from: private */
    public ScaleGestureDetector mScaleGestureDetector;
    /* access modifiers changed from: private */
    public View view;
    /* access modifiers changed from: private */
    public String viewId;

    public HMGestureEventDetector(HMBase hMBase) {
        if (hMBase != null && hMBase.getView() != null) {
            this.hummerContext = (HummerContext) hMBase.getContext();
            this.eventManager = hMBase.getEventManager();
            this.view = hMBase.getView();
            this.viewId = hMBase.getViewID();
            this.context = this.view.getContext();
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                init();
            } else {
                this.view.post(new HMGestureEventDetector$$ExternalSyntheticLambda2(this));
            }
        }
    }

    /* access modifiers changed from: private */
    public void init() {
        this.mGestureDetector = new GestureDetector(this.context, new GestureDetector.SimpleOnGestureListener() {
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (!HMGestureEventDetector.this.eventManager.contains(Event.HM_EVENT_TYPE_SWIPE)) {
                    return false;
                }
                SwipeEvent access$100 = HMGestureEventDetector.this.makeSwipeEvent(motionEvent2);
                float x = motionEvent.getX();
                float x2 = motionEvent2.getX();
                float y = motionEvent.getY();
                float y2 = motionEvent2.getY();
                if (x - x2 > 120.0f && Math.abs(f) > 0.0f) {
                    access$100.setDirection(2);
                } else if (x2 - x > 120.0f && Math.abs(f) > 0.0f) {
                    access$100.setDirection(1);
                } else if (y - y2 > 120.0f && Math.abs(f2) > 0.0f) {
                    access$100.setDirection(4);
                } else if (y2 - y > 120.0f && Math.abs(f2) > 0.0f) {
                    access$100.setDirection(8);
                }
                HMGestureEventDetector.this.eventManager.dispatchEvent(Event.HM_EVENT_TYPE_SWIPE, access$100);
                return true;
            }
        });
        this.mScaleGestureDetector = new ScaleGestureDetector(this.context, new ScaleGestureDetector.SimpleOnScaleGestureListener() {
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                if (!HMGestureEventDetector.this.eventManager.contains(Event.HM_EVENT_TYPE_PINCH)) {
                    return false;
                }
                float max = Math.max(0.1f, Math.min(scaleGestureDetector.getScaleFactor(), 5.0f));
                HMGestureEventDetector hMGestureEventDetector = HMGestureEventDetector.this;
                PinchEvent access$300 = hMGestureEventDetector.makePinchEvent(hMGestureEventDetector.latestMotionEvent);
                access$300.setScale(max);
                HMGestureEventDetector.this.eventManager.dispatchEvent(Event.HM_EVENT_TYPE_PINCH, access$300);
                return true;
            }
        });
        this.view.setOnTouchListener(new View.OnTouchListener() {
            private float downX = 0.0f;
            private float downY = 0.0f;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                EventTracer.traceEvent(HMGestureEventDetector.this.hummerContext.getNamespace(), EventTracer.EventName.HUMMER_SDK_TRACE_EVENT, TraceEvent.makeTraceGestureEvent(Event.HM_EVENT_TYPE_TOUCH, HMGestureEventDetector.this.view, HMGestureEventDetector.this.viewId));
                PanEvent panEvent = null;
                TouchEvent access$700 = HMGestureEventDetector.this.eventManager.contains(Event.HM_EVENT_TYPE_TOUCH) ? HMGestureEventDetector.this.makeTouchEvent(view.getContext(), motionEvent) : null;
                if (HMGestureEventDetector.this.eventManager.contains(Event.HM_EVENT_TYPE_PAN)) {
                    panEvent = HMGestureEventDetector.this.makePanEvent(motionEvent);
                }
                int action = motionEvent.getAction();
                if (action == 0) {
                    MotionEvent unused = HMGestureEventDetector.this.latestMotionEvent = MotionEvent.obtain(motionEvent);
                    if (panEvent != null) {
                        this.downX = motionEvent.getRawX();
                        this.downY = motionEvent.getRawY();
                    }
                } else if (action != 2) {
                    MotionEvent unused2 = HMGestureEventDetector.this.latestMotionEvent = MotionEvent.obtain(motionEvent);
                } else if (panEvent != null) {
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    panEvent.setTranslation(GestureUtils.findTranslationInMotionEvent(HMGestureEventDetector.this.context, rawX - this.downX, rawY - this.downY));
                    this.downX = rawX;
                    this.downY = rawY;
                }
                if (access$700 != null) {
                    HMGestureEventDetector.this.eventManager.dispatchEvent(Event.HM_EVENT_TYPE_TOUCH, access$700);
                    z = true;
                } else {
                    z = false;
                }
                if (panEvent != null) {
                    HMGestureEventDetector.this.eventManager.dispatchEvent(Event.HM_EVENT_TYPE_PAN, panEvent);
                    z = true;
                }
                if (HMGestureEventDetector.this.eventManager.contains(Event.HM_EVENT_TYPE_TAP) || HMGestureEventDetector.this.eventManager.contains(Event.HM_EVENT_TYPE_LONG_PRESS)) {
                    return false;
                }
                if (HMGestureEventDetector.this.eventManager.contains(Event.HM_EVENT_TYPE_SWIPE)) {
                    HMGestureEventDetector.this.mGestureDetector.onTouchEvent(motionEvent);
                    z = true;
                }
                if (!HMGestureEventDetector.this.eventManager.contains(Event.HM_EVENT_TYPE_PINCH)) {
                    return z;
                }
                HMGestureEventDetector.this.mScaleGestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });
    }

    public void initClickListener(String str) {
        if (this.hummerContext != null && this.eventManager != null && this.view != null && !TextUtils.isEmpty(str)) {
            if (str.equals(Event.HM_EVENT_TYPE_TAP)) {
                this.view.setOnClickListener(new HMGestureEventDetector$$ExternalSyntheticLambda0(this));
            }
            if (str.equals(Event.HM_EVENT_TYPE_LONG_PRESS)) {
                this.view.setOnLongClickListener(new HMGestureEventDetector$$ExternalSyntheticLambda1(this));
            }
        }
    }

    public /* synthetic */ void lambda$initClickListener$0$HMGestureEventDetector(View view2) {
        EventTracer.traceEvent(this.hummerContext.getNamespace(), EventTracer.EventName.HUMMER_SDK_TRACE_EVENT, TraceEvent.makeTraceGestureEvent(Event.HM_EVENT_TYPE_TAP, this.view, this.viewId));
        if (this.eventManager.contains(Event.HM_EVENT_TYPE_TAP)) {
            this.eventManager.dispatchEvent(Event.HM_EVENT_TYPE_TAP, makeTapEvent(this.view.getContext(), this.latestMotionEvent));
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view2);
    }

    public /* synthetic */ boolean lambda$initClickListener$1$HMGestureEventDetector(View view2) {
        EventTracer.traceEvent(this.hummerContext.getNamespace(), EventTracer.EventName.HUMMER_SDK_TRACE_EVENT, TraceEvent.makeTraceGestureEvent(Event.HM_EVENT_TYPE_LONG_PRESS, this.view, this.viewId));
        if (!this.eventManager.contains(Event.HM_EVENT_TYPE_LONG_PRESS)) {
            return true;
        }
        this.eventManager.dispatchEvent(Event.HM_EVENT_TYPE_LONG_PRESS, makeLongPressEvent(this.view.getContext(), this.latestMotionEvent));
        return true;
    }

    /* access modifiers changed from: private */
    public TouchEvent makeTouchEvent(Context context2, MotionEvent motionEvent) {
        TouchEvent touchEvent = new TouchEvent();
        touchEvent.setTimestamp(System.currentTimeMillis());
        touchEvent.setType(Event.HM_EVENT_TYPE_TOUCH);
        touchEvent.setState(GestureUtils.findStateInMotionEvent(motionEvent));
        touchEvent.setPosition(GestureUtils.findPositionInMotionEvent(context2, motionEvent));
        return touchEvent;
    }

    /* access modifiers changed from: private */
    public PanEvent makePanEvent(MotionEvent motionEvent) {
        PanEvent panEvent = new PanEvent();
        panEvent.setTimestamp(System.currentTimeMillis());
        panEvent.setType(Event.HM_EVENT_TYPE_PAN);
        panEvent.setState(GestureUtils.findStateInMotionEvent(motionEvent));
        return panEvent;
    }

    /* access modifiers changed from: private */
    public SwipeEvent makeSwipeEvent(MotionEvent motionEvent) {
        SwipeEvent swipeEvent = new SwipeEvent();
        swipeEvent.setTimestamp(System.currentTimeMillis());
        swipeEvent.setType(Event.HM_EVENT_TYPE_SWIPE);
        swipeEvent.setState(GestureUtils.findStateInMotionEvent(motionEvent));
        return swipeEvent;
    }

    /* access modifiers changed from: private */
    public PinchEvent makePinchEvent(MotionEvent motionEvent) {
        PinchEvent pinchEvent = new PinchEvent();
        pinchEvent.setTimestamp(System.currentTimeMillis());
        pinchEvent.setType(Event.HM_EVENT_TYPE_PINCH);
        pinchEvent.setState(GestureUtils.findStateInMotionEvent(motionEvent));
        return pinchEvent;
    }

    private TapEvent makeTapEvent(Context context2, MotionEvent motionEvent) {
        TapEvent tapEvent = new TapEvent();
        tapEvent.setTimestamp(System.currentTimeMillis());
        tapEvent.setType(Event.HM_EVENT_TYPE_TAP);
        tapEvent.setState(GestureUtils.findStateInMotionEvent(motionEvent));
        tapEvent.setPosition(GestureUtils.findPositionInMotionEvent(context2, motionEvent));
        return tapEvent;
    }

    private LongPressEvent makeLongPressEvent(Context context2, MotionEvent motionEvent) {
        LongPressEvent longPressEvent = new LongPressEvent();
        longPressEvent.setTimestamp(System.currentTimeMillis());
        longPressEvent.setType(Event.HM_EVENT_TYPE_LONG_PRESS);
        longPressEvent.setState(GestureUtils.findStateInMotionEvent(motionEvent));
        longPressEvent.setPosition(GestureUtils.findPositionInMotionEvent(context2, motionEvent));
        return longPressEvent;
    }
}
