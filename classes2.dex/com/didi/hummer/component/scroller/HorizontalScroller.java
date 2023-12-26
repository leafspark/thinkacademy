package com.didi.hummer.component.scroller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsMethod;
import com.didi.hummer.annotation.JsProperty;
import com.didi.hummer.component.R;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.render.component.view.FixedNoneBox;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.event.view.ScrollEvent;
import com.didi.hummer.render.style.HummerLayout;
import com.didi.hummer.render.style.HummerLayoutExtendUtils;
import com.didi.hummer.render.style.HummerStyleUtils;
import com.didi.hummer.render.utility.DPUtil;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component("HorizontalScroller")
public class HorizontalScroller extends HMBase<HScrollView> implements HMBase.PositionChangedListener {
    @JsProperty("bounces")
    public boolean bounces;
    private List<HMBase> children = new ArrayList();
    private Map<HMBase, FixedNoneBox> fixedNoneBoxMap = new HashMap();
    private HummerContext hummerContext;
    private HummerLayout layout;
    private JSCallback onScrollToBottomListener;
    private JSCallback onScrollToTopListener;
    /* access modifiers changed from: private */
    public ScrollEvent scrollEvent = new ScrollEvent();
    @JsProperty("showScrollBar")
    private boolean showScrollBar;

    @JsMethod("updateContentSize")
    @Deprecated
    public void updateContentSize() {
    }

    public HorizontalScroller(HummerContext hummerContext2, JSValue jSValue, String str) {
        super(hummerContext2, jSValue, str);
        this.hummerContext = hummerContext2;
    }

    /* access modifiers changed from: protected */
    public HScrollView createViewInstance(Context context) {
        LayoutInflater from = LayoutInflater.from(context);
        int i = R.layout.horizontal_scroll_view;
        HScrollView hScrollView = (HScrollView) (!(from instanceof LayoutInflater) ? from.inflate(i, (ViewGroup) null, false) : XMLParseInstrumentation.inflate(from, i, (ViewGroup) null, false));
        hScrollView.setClipChildren(false);
        hScrollView.setFillViewport(true);
        return hScrollView;
    }

    public void onCreate() {
        super.onCreate();
        initScrollView();
    }

    public void onDestroy() {
        super.onDestroy();
        ((HScrollView) getView()).release();
    }

    /* access modifiers changed from: protected */
    public void onStyleUpdated(Map<String, Object> map) {
        this.layout.getYogaNode().copyStyle(getYogaNode());
        this.layout.getYogaNode().setFlexDirection(YogaFlexDirection.ROW);
        adjustWidthAndHeight();
        adjustMinMaxWidthAndHeight();
    }

    private void initScrollView() {
        HummerLayout hummerLayout = new HummerLayout(getContext());
        this.layout = hummerLayout;
        hummerLayout.getYogaNode().setFlexDirection(YogaFlexDirection.ROW);
        this.layout.addOnLayoutChangeListener(new HorizontalScroller$$ExternalSyntheticLambda0(this));
        ((HScrollView) getView()).addView(this.layout);
        getYogaNode().setOverflow(YogaOverflow.SCROLL);
        getYogaNode().setMeasureFunction((YogaMeasureFunction) null);
        getYogaNode().addChildAt(this.layout.getYogaNode(), 0);
        ((HScrollView) getView()).setHorizontalScrollBarEnabled(false);
        ((HScrollView) getView()).setOnScrollListener(new OnScrollListener() {
            public void onScrollStarted() {
                if (HorizontalScroller.this.mEventManager.contains(ScrollEvent.HM_EVENT_TYPE_SCROLL)) {
                    HorizontalScroller.this.scrollEvent.setType(ScrollEvent.HM_EVENT_TYPE_SCROLL);
                    HorizontalScroller.this.scrollEvent.setState(1);
                    HorizontalScroller.this.scrollEvent.setOffsetX(0.0f);
                    HorizontalScroller.this.scrollEvent.setOffsetY(0.0f);
                    HorizontalScroller.this.scrollEvent.setDx(0.0f);
                    HorizontalScroller.this.scrollEvent.setDy(0.0f);
                    HorizontalScroller.this.scrollEvent.setTimestamp(System.currentTimeMillis());
                    HorizontalScroller.this.mEventManager.dispatchEvent(ScrollEvent.HM_EVENT_TYPE_SCROLL, HorizontalScroller.this.scrollEvent);
                }
            }

            public void onScrollFinished() {
                if (HorizontalScroller.this.mEventManager.contains(ScrollEvent.HM_EVENT_TYPE_SCROLL)) {
                    HorizontalScroller.this.scrollEvent.setType(ScrollEvent.HM_EVENT_TYPE_SCROLL);
                    HorizontalScroller.this.scrollEvent.setState(3);
                    HorizontalScroller.this.scrollEvent.setTimestamp(System.currentTimeMillis());
                    HorizontalScroller.this.mEventManager.dispatchEvent(ScrollEvent.HM_EVENT_TYPE_SCROLL, HorizontalScroller.this.scrollEvent);
                }
            }

            public void onScrollUp() {
                if (HorizontalScroller.this.mEventManager.contains(ScrollEvent.HM_EVENT_TYPE_SCROLL)) {
                    HorizontalScroller.this.scrollEvent.setType(ScrollEvent.HM_EVENT_TYPE_SCROLL);
                    HorizontalScroller.this.scrollEvent.setState(4);
                    HorizontalScroller.this.scrollEvent.setTimestamp(System.currentTimeMillis());
                    HorizontalScroller.this.mEventManager.dispatchEvent(ScrollEvent.HM_EVENT_TYPE_SCROLL, HorizontalScroller.this.scrollEvent);
                }
            }

            public void onScrollChanged(View view, int i, int i2, int i3, int i4) {
                if (HorizontalScroller.this.mEventManager.contains(ScrollEvent.HM_EVENT_TYPE_SCROLL)) {
                    HorizontalScroller.this.scrollEvent.setType(ScrollEvent.HM_EVENT_TYPE_SCROLL);
                    HorizontalScroller.this.scrollEvent.setState(2);
                    HorizontalScroller.this.scrollEvent.setOffsetX(DPUtil.px2dpF(HorizontalScroller.this.getContext(), (float) i));
                    HorizontalScroller.this.scrollEvent.setOffsetY(DPUtil.px2dpF(HorizontalScroller.this.getContext(), (float) i2));
                    HorizontalScroller.this.scrollEvent.setDx(DPUtil.px2dpF(HorizontalScroller.this.getContext(), (float) i3));
                    HorizontalScroller.this.scrollEvent.setDy(DPUtil.px2dpF(HorizontalScroller.this.getContext(), (float) i4));
                    HorizontalScroller.this.scrollEvent.setTimestamp(System.currentTimeMillis());
                    HorizontalScroller.this.mEventManager.dispatchEvent(ScrollEvent.HM_EVENT_TYPE_SCROLL, HorizontalScroller.this.scrollEvent);
                }
            }
        });
        ((HScrollView) getView()).setOnScrollToTopListener(new HorizontalScroller$$ExternalSyntheticLambda2(this));
        ((HScrollView) getView()).setOnScrollToBottomListener(new HorizontalScroller$$ExternalSyntheticLambda1(this));
    }

    public /* synthetic */ void lambda$initScrollView$0$HorizontalScroller(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        adjustWidthAndHeight();
    }

    public /* synthetic */ void lambda$initScrollView$1$HorizontalScroller() {
        JSCallback jSCallback = this.onScrollToTopListener;
        if (jSCallback != null) {
            jSCallback.call(new Object[0]);
        }
    }

    public /* synthetic */ void lambda$initScrollView$2$HorizontalScroller() {
        JSCallback jSCallback = this.onScrollToBottomListener;
        if (jSCallback != null) {
            jSCallback.call(new Object[0]);
        }
    }

    private void adjustWidthAndHeight() {
        if (getYogaNode().getWidth().unit == YogaUnit.AUTO) {
            this.layout.getYogaNode().setWidthAuto();
        } else {
            this.layout.getYogaNode().setWidthPercent(100.0f);
        }
        if (getYogaNode().getHeight().unit == YogaUnit.AUTO) {
            this.layout.getYogaNode().setHeightAuto();
        } else {
            this.layout.getYogaNode().setHeightPercent(100.0f);
        }
    }

    private void adjustMinMaxWidthAndHeight() {
        this.layout.getYogaNode().setMinWidth(Float.NaN);
        this.layout.getYogaNode().setMaxWidth(Float.NaN);
        this.layout.getYogaNode().setMinHeight(Float.NaN);
        this.layout.getYogaNode().setMaxHeight(Float.NaN);
    }

    @JsMethod("appendChild")
    public void appendChild(HMBase hMBase) {
        if (hMBase != null) {
            hMBase.getJSValue().protect();
            hMBase.setPositionChangedListener(this);
            this.children.add(hMBase);
            getNode().appendChild(hMBase.getNode());
            if (hMBase.getPosition() == HummerLayoutExtendUtils.Position.FIXED) {
                this.hummerContext.getContainer().addView(hMBase);
                FixedNoneBox fixedNoneBox = new FixedNoneBox(this.hummerContext);
                this.fixedNoneBoxMap.put(hMBase, fixedNoneBox);
                hMBase = fixedNoneBox;
            }
            this.layout.addView(hMBase);
        }
    }

    @JsMethod("removeChild")
    public void removeChild(HMBase hMBase) {
        if (hMBase != null) {
            hMBase.getJSValue().unprotect();
            hMBase.setPositionChangedListener((HMBase.PositionChangedListener) null);
            this.children.remove(hMBase);
            getNode().removeChild(hMBase.getNode());
            if (this.fixedNoneBoxMap.containsKey(hMBase)) {
                this.hummerContext.getContainer().removeView(hMBase);
                this.layout.removeView(this.fixedNoneBoxMap.remove(hMBase));
                return;
            }
            this.layout.removeView(hMBase);
        }
    }

    @JsMethod("removeAll")
    public void removeAll() {
        for (Map.Entry next : this.fixedNoneBoxMap.entrySet()) {
            this.hummerContext.getContainer().removeView((HMBase) next.getKey());
            this.layout.removeView((FixedNoneBox) next.getValue());
        }
        this.fixedNoneBoxMap.clear();
        for (HMBase next2 : this.children) {
            next2.getJSValue().unprotect();
            next2.setPositionChangedListener((HMBase.PositionChangedListener) null);
        }
        this.children.clear();
        getNode().removeAll();
        this.layout.removeAllViews();
    }

    @JsMethod("insertBefore")
    public void insertBefore(HMBase hMBase, HMBase hMBase2) {
        if (hMBase != null && hMBase2 != null) {
            hMBase.getJSValue().protect();
            hMBase.setPositionChangedListener(this);
            this.children.add(hMBase);
            getNode().insertBefore(hMBase.getNode(), hMBase2.getNode());
            if (hMBase.getPosition() == HummerLayoutExtendUtils.Position.FIXED) {
                this.hummerContext.getContainer().addView(hMBase);
                FixedNoneBox fixedNoneBox = new FixedNoneBox(this.hummerContext);
                this.fixedNoneBoxMap.put(hMBase, fixedNoneBox);
                hMBase = fixedNoneBox;
            }
            if (this.fixedNoneBoxMap.containsKey(hMBase2)) {
                hMBase2 = this.fixedNoneBoxMap.get(hMBase2);
            }
            this.layout.insertBefore(hMBase, hMBase2);
        }
    }

    @JsMethod("replaceChild")
    public void replaceChild(HMBase hMBase, HMBase hMBase2) {
        if (hMBase != null && hMBase2 != null) {
            hMBase.getJSValue().protect();
            hMBase.setPositionChangedListener(this);
            hMBase2.getJSValue().unprotect();
            hMBase2.setPositionChangedListener((HMBase.PositionChangedListener) null);
            this.children.add(hMBase);
            this.children.remove(hMBase2);
            getNode().replaceChild(hMBase.getNode(), hMBase2.getNode());
            if (hMBase.getPosition() == HummerLayoutExtendUtils.Position.FIXED) {
                this.hummerContext.getContainer().addView(hMBase);
                FixedNoneBox fixedNoneBox = new FixedNoneBox(this.hummerContext);
                this.fixedNoneBoxMap.put(hMBase, fixedNoneBox);
                hMBase = fixedNoneBox;
            }
            if (this.fixedNoneBoxMap.containsKey(hMBase2)) {
                this.hummerContext.getContainer().removeView(hMBase2);
                hMBase2 = this.fixedNoneBoxMap.get(hMBase2);
            }
            this.layout.replaceView(hMBase, hMBase2);
        }
    }

    @JsMethod("getElementById")
    @Deprecated
    public HMBase getSubview(String str) {
        HMBase viewById = this.layout.getViewById(str);
        if (viewById == null) {
            Iterator<Map.Entry<HMBase, FixedNoneBox>> it = this.fixedNoneBoxMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                HMBase hMBase = (HMBase) it.next().getKey();
                if (hMBase.getViewID().equals(str)) {
                    viewById = hMBase;
                    break;
                }
            }
        }
        if (viewById != null) {
            viewById.getJSValue().protect();
        }
        return viewById;
    }

    @JsMethod("layout")
    @Deprecated
    public void layout() {
        this.layout.requestLayout();
    }

    public void setShowScrollBar(boolean z) {
        ((HScrollView) getView()).setHorizontalScrollBarEnabled(z);
    }

    @JsMethod("scrollTo")
    public void scrollTo(Object obj, Object obj2) {
        ((HScrollView) getView()).smoothScrollTo((int) HummerStyleUtils.convertNumber(obj), (int) HummerStyleUtils.convertNumber(obj2));
    }

    @JsMethod("scrollBy")
    public void scrollBy(Object obj, Object obj2) {
        ((HScrollView) getView()).smoothScrollBy((int) HummerStyleUtils.convertNumber(obj), (int) HummerStyleUtils.convertNumber(obj2));
    }

    @JsMethod("scrollToTop")
    public void scrollToTop() {
        ((HScrollView) getView()).fullScroll(17);
    }

    @JsMethod("scrollToBottom")
    public void scrollToBottom() {
        ((HScrollView) getView()).fullScroll(66);
    }

    @JsMethod("setOnScrollToTopListener")
    public void setOnScrollToTopListener(JSCallback jSCallback) {
        this.onScrollToTopListener = jSCallback;
    }

    @JsMethod("setOnScrollToBottomListener")
    public void setOnScrollToBottomListener(JSCallback jSCallback) {
        this.onScrollToBottomListener = jSCallback;
    }

    public void dispatchChildPositionChanged(HMBase hMBase, HummerLayoutExtendUtils.Position position, HummerLayoutExtendUtils.Position position2) {
        if (position == HummerLayoutExtendUtils.Position.FIXED && position2 == HummerLayoutExtendUtils.Position.YOGA && this.fixedNoneBoxMap.containsKey(hMBase)) {
            this.hummerContext.getContainer().removeView(hMBase);
            this.layout.replaceView(hMBase, this.fixedNoneBoxMap.remove(hMBase));
        }
        if (position == HummerLayoutExtendUtils.Position.YOGA && position2 == HummerLayoutExtendUtils.Position.FIXED) {
            FixedNoneBox fixedNoneBox = new FixedNoneBox(this.hummerContext);
            this.fixedNoneBoxMap.put(hMBase, fixedNoneBox);
            this.layout.replaceView(fixedNoneBox, hMBase);
            this.hummerContext.getContainer().addView(hMBase);
        }
    }

    public void resetStyle() {
        super.resetStyle();
        setShowScrollBar(false);
    }
}
