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
import com.didi.hummer.component.refresh.HummerFooter;
import com.didi.hummer.component.refresh.HummerHeader;
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
import com.didi.hummer.render.utility.YogaNodeUtil;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaUnit;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component("Scroller")
public class Scroller extends HMBase<SmartRefreshLayout> implements HMBase.PositionChangedListener {
    @JsProperty("bounces")
    public boolean bounces;
    private List<HMBase> children = new ArrayList();
    private Map<HMBase, FixedNoneBox> fixedNoneBoxMap = new HashMap();
    private HummerContext hummerContext;
    private HummerFooter hummerFooter;
    private HummerHeader hummerHeader;
    private HummerLayout layout;
    /* access modifiers changed from: private */
    @JsProperty("onLoadMore")
    public JSCallback loadMoreCallback;
    @JsProperty("loadMoreView")
    private HMBase loadMoreView;
    private JSCallback onScrollToBottomListener;
    private JSCallback onScrollToTopListener;
    /* access modifiers changed from: private */
    @JsProperty("onRefresh")
    public JSCallback refreshCallback;
    private SmartRefreshLayout refreshLayout;
    @JsProperty("refreshView")
    private HMBase refreshView;
    /* access modifiers changed from: private */
    public ScrollEvent scrollEvent = new ScrollEvent();
    private VScrollView scrollView;
    @JsProperty("showScrollBar")
    private boolean showScrollBar;

    @JsMethod("updateContentSize")
    @Deprecated
    public void updateContentSize() {
    }

    public Scroller(HummerContext hummerContext2, JSValue jSValue, String str) {
        super(hummerContext2, jSValue, str);
        this.hummerContext = hummerContext2;
    }

    /* access modifiers changed from: protected */
    public SmartRefreshLayout createViewInstance(Context context) {
        LayoutInflater from = LayoutInflater.from(context);
        int i = R.layout.scroll_view;
        VScrollView vScrollView = (VScrollView) (!(from instanceof LayoutInflater) ? from.inflate(i, (ViewGroup) null, false) : XMLParseInstrumentation.inflate(from, i, (ViewGroup) null, false));
        this.scrollView = vScrollView;
        vScrollView.setClipChildren(false);
        this.scrollView.setFillViewport(true);
        SmartRefreshLayout smartRefreshLayout = new SmartRefreshLayout(context);
        this.refreshLayout = smartRefreshLayout;
        smartRefreshLayout.setEnableRefresh(false);
        this.refreshLayout.setEnableLoadMore(false);
        this.refreshLayout.setEnableOverScrollDrag(true);
        this.refreshLayout.setRefreshContent(this.scrollView);
        this.hummerHeader = new HummerHeader(context);
        this.hummerFooter = new HummerFooter(context);
        this.refreshLayout.setRefreshHeader(this.hummerHeader);
        this.refreshLayout.setRefreshFooter(this.hummerFooter);
        this.hummerHeader.setOnRefreshListener(new HummerHeader.OnRefreshListener() {
            public void onRefreshStarted() {
                if (Scroller.this.refreshCallback != null) {
                    Scroller.this.refreshCallback.call(1);
                }
            }

            public void onRefreshing() {
                if (Scroller.this.refreshCallback != null) {
                    Scroller.this.refreshCallback.call(2);
                }
            }

            public void onRefreshFinished() {
                if (Scroller.this.refreshCallback != null) {
                    Scroller.this.refreshCallback.call(0);
                }
            }
        });
        this.hummerFooter.setOnLoadListener(new HummerFooter.OnLoadListener() {
            public void onLoadFinished() {
            }

            public void onLoadStarted() {
            }

            public void onLoading() {
                if (Scroller.this.loadMoreCallback != null) {
                    Scroller.this.loadMoreCallback.call(1);
                }
            }
        });
        return this.refreshLayout;
    }

    public void onCreate() {
        super.onCreate();
        initScrollView();
    }

    public void onDestroy() {
        super.onDestroy();
        this.scrollView.release();
    }

    /* access modifiers changed from: protected */
    public void onStyleUpdated(Map<String, Object> map) {
        this.layout.getYogaNode().copyStyle(getYogaNode());
        adjustWidthAndHeight();
        adjustMinMaxWidthAndHeight();
    }

    private void initScrollView() {
        HummerLayout hummerLayout = new HummerLayout(getContext());
        this.layout = hummerLayout;
        hummerLayout.addOnLayoutChangeListener(new Scroller$$ExternalSyntheticLambda0(this));
        this.scrollView.addView(this.layout);
        YogaNode createYogaNode = YogaNodeUtil.createYogaNode();
        createYogaNode.setData(this.scrollView);
        createYogaNode.addChildAt(this.layout.getYogaNode(), 0);
        createYogaNode.setOverflow(YogaOverflow.SCROLL);
        getYogaNode().setMeasureFunction((YogaMeasureFunction) null);
        getYogaNode().setFlexShrink(1.0f);
        getYogaNode().addChildAt(createYogaNode, 0);
        this.scrollView.setVerticalScrollBarEnabled(false);
        this.scrollView.setOnScrollListener(new OnScrollListener() {
            public void onScrollStarted() {
                if (Scroller.this.mEventManager.contains(ScrollEvent.HM_EVENT_TYPE_SCROLL)) {
                    Scroller.this.scrollEvent.setType(ScrollEvent.HM_EVENT_TYPE_SCROLL);
                    Scroller.this.scrollEvent.setState(1);
                    Scroller.this.scrollEvent.setOffsetX(0.0f);
                    Scroller.this.scrollEvent.setOffsetY(0.0f);
                    Scroller.this.scrollEvent.setDx(0.0f);
                    Scroller.this.scrollEvent.setDy(0.0f);
                    Scroller.this.scrollEvent.setTimestamp(System.currentTimeMillis());
                    Scroller.this.mEventManager.dispatchEvent(ScrollEvent.HM_EVENT_TYPE_SCROLL, Scroller.this.scrollEvent);
                }
            }

            public void onScrollFinished() {
                if (Scroller.this.mEventManager.contains(ScrollEvent.HM_EVENT_TYPE_SCROLL)) {
                    Scroller.this.scrollEvent.setType(ScrollEvent.HM_EVENT_TYPE_SCROLL);
                    Scroller.this.scrollEvent.setState(3);
                    Scroller.this.scrollEvent.setTimestamp(System.currentTimeMillis());
                    Scroller.this.mEventManager.dispatchEvent(ScrollEvent.HM_EVENT_TYPE_SCROLL, Scroller.this.scrollEvent);
                }
            }

            public void onScrollUp() {
                if (Scroller.this.mEventManager.contains(ScrollEvent.HM_EVENT_TYPE_SCROLL)) {
                    Scroller.this.scrollEvent.setType(ScrollEvent.HM_EVENT_TYPE_SCROLL);
                    Scroller.this.scrollEvent.setState(4);
                    Scroller.this.scrollEvent.setTimestamp(System.currentTimeMillis());
                    Scroller.this.mEventManager.dispatchEvent(ScrollEvent.HM_EVENT_TYPE_SCROLL, Scroller.this.scrollEvent);
                }
            }

            public void onScrollChanged(View view, int i, int i2, int i3, int i4) {
                if (Scroller.this.mEventManager.contains(ScrollEvent.HM_EVENT_TYPE_SCROLL)) {
                    Scroller.this.scrollEvent.setType(ScrollEvent.HM_EVENT_TYPE_SCROLL);
                    Scroller.this.scrollEvent.setState(2);
                    Scroller.this.scrollEvent.setOffsetX(DPUtil.px2dpF(Scroller.this.getContext(), (float) i));
                    Scroller.this.scrollEvent.setOffsetY(DPUtil.px2dpF(Scroller.this.getContext(), (float) i2));
                    Scroller.this.scrollEvent.setDx(DPUtil.px2dpF(Scroller.this.getContext(), (float) i3));
                    Scroller.this.scrollEvent.setDy(DPUtil.px2dpF(Scroller.this.getContext(), (float) i4));
                    Scroller.this.scrollEvent.setTimestamp(System.currentTimeMillis());
                    Scroller.this.mEventManager.dispatchEvent(ScrollEvent.HM_EVENT_TYPE_SCROLL, Scroller.this.scrollEvent);
                }
            }
        });
        this.scrollView.setOnScrollToTopListener(new Scroller$$ExternalSyntheticLambda2(this));
        this.scrollView.setOnScrollToBottomListener(new Scroller$$ExternalSyntheticLambda1(this));
    }

    public /* synthetic */ void lambda$initScrollView$0$Scroller(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        adjustWidthAndHeight();
    }

    public /* synthetic */ void lambda$initScrollView$1$Scroller() {
        JSCallback jSCallback = this.onScrollToTopListener;
        if (jSCallback != null) {
            jSCallback.call(new Object[0]);
        }
    }

    public /* synthetic */ void lambda$initScrollView$2$Scroller() {
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
        this.scrollView.setVerticalScrollBarEnabled(z);
    }

    public void setRefreshView(HMBase hMBase) {
        this.refreshLayout.setEnableRefresh(true);
        this.hummerHeader.addHeaderView(hMBase);
    }

    public void setLoadMoreView(HMBase hMBase) {
        this.refreshLayout.setEnableLoadMore(true);
        this.hummerFooter.addFooterView(hMBase);
    }

    public void setOnRefresh(JSCallback jSCallback) {
        this.refreshCallback = jSCallback;
    }

    public void setOnLoadMore(JSCallback jSCallback) {
        this.loadMoreCallback = jSCallback;
    }

    @JsMethod("stopPullRefresh")
    public void stopPullRefresh() {
        this.refreshLayout.finishRefresh(30);
    }

    @JsMethod("stopLoadMore")
    public void stopLoadMore(boolean z) {
        if (z) {
            this.refreshLayout.finishLoadMore();
        } else {
            this.refreshLayout.finishLoadMoreWithNoMoreData();
        }
        JSCallback jSCallback = this.loadMoreCallback;
        if (jSCallback != null) {
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(z ? 0 : 2);
            jSCallback.call(objArr);
        }
    }

    public void setBounces(boolean z) {
        this.refreshLayout.setEnableOverScrollDrag(z);
    }

    @JsMethod("scrollTo")
    public void scrollTo(Object obj, Object obj2) {
        this.scrollView.smoothScrollTo((int) HummerStyleUtils.convertNumber(obj), (int) HummerStyleUtils.convertNumber(obj2));
    }

    @JsMethod("scrollBy")
    public void scrollBy(Object obj, Object obj2) {
        this.scrollView.smoothScrollBy((int) HummerStyleUtils.convertNumber(obj), (int) HummerStyleUtils.convertNumber(obj2));
    }

    @JsMethod("scrollToTop")
    public void scrollToTop() {
        this.scrollView.fullScroll(33);
    }

    @JsMethod("scrollToBottom")
    public void scrollToBottom() {
        this.scrollView.fullScroll(130);
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
