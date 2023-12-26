package com.didi.hummer.component.list;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsAttribute;
import com.didi.hummer.annotation.JsMethod;
import com.didi.hummer.annotation.JsProperty;
import com.didi.hummer.component.R;
import com.didi.hummer.component.input.FocusUtil;
import com.didi.hummer.component.input.KeyboardUtil;
import com.didi.hummer.component.list.HMListAdapter;
import com.didi.hummer.component.list.decoration.GridSpacingItemDecoration;
import com.didi.hummer.component.list.decoration.LinearSpacingItemDecoration;
import com.didi.hummer.component.list.decoration.StaggeredGridSpacingItemDecoration;
import com.didi.hummer.component.refresh.HummerFooter;
import com.didi.hummer.component.refresh.HummerHeader;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.util.DebugUtil;
import com.didi.hummer.pool.ObjectPool;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.event.view.ScrollEvent;
import com.didi.hummer.render.style.HummerNode;
import com.didi.hummer.render.style.HummerStyleUtils;
import com.didi.hummer.render.utility.DPUtil;
import com.didi.hummer.render.utility.YogaNodeUtil;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.android.YogaLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

@Component("List")
public class List extends HMBase<SmartRefreshLayout> {
    private static final int DIRECTION_HORIZONTAL = 2;
    private static final int DIRECTION_VERTICAL = 1;
    private static final int MODE_GRID = 2;
    private static final int MODE_LIST = 1;
    private static final int MODE_WATERFALL = 3;
    private HMListAdapter adapter;
    private int bottomSpacing;
    @JsProperty("bounces")
    public boolean bounces;
    private int column = 2;
    private int direction = 1;
    private HummerFooter hummerFooter;
    private HummerHeader hummerHeader;
    private ObjectPool instanceManager;
    /* access modifiers changed from: private */
    public boolean isLoadingMore;
    /* access modifiers changed from: private */
    public boolean isScrollStarted = false;
    private RecyclerView.ItemDecoration itemDecoration;
    private int itemSpacing;
    private RecyclerView.LayoutManager layoutManager;
    private int leftSpacing;
    private int lineSpacing;
    /* access modifiers changed from: private */
    @JsProperty("onLoadMore")
    public JSCallback loadMoreCallback;
    @JsProperty("loadMoreView")
    private HMBase loadMoreView;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (List.this.mEventManager.contains(ScrollEvent.HM_EVENT_TYPE_SCROLL) && List.this.isScrollStarted) {
                int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
                int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                List.this.scrollEvent.setType(ScrollEvent.HM_EVENT_TYPE_SCROLL);
                List.this.scrollEvent.setState(2);
                List.this.scrollEvent.setOffsetX(DPUtil.px2dpF(List.this.getContext(), (float) computeHorizontalScrollOffset));
                List.this.scrollEvent.setOffsetY(DPUtil.px2dpF(List.this.getContext(), (float) computeVerticalScrollOffset));
                List.this.scrollEvent.setDx(DPUtil.px2dpF(List.this.getContext(), (float) i));
                List.this.scrollEvent.setDy(DPUtil.px2dpF(List.this.getContext(), (float) i2));
                List.this.scrollEvent.setTimestamp(System.currentTimeMillis());
                List.this.mEventManager.dispatchEvent(ScrollEvent.HM_EVENT_TYPE_SCROLL, List.this.scrollEvent);
                List.this.hideKeyboardIfNeed(i, i2);
            }
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            List.super.onScrollStateChanged(recyclerView, i);
            if (List.this.mEventManager.contains(ScrollEvent.HM_EVENT_TYPE_SCROLL)) {
                if (i == 0) {
                    boolean unused = List.this.isScrollStarted = false;
                    List.this.scrollEvent.setType(ScrollEvent.HM_EVENT_TYPE_SCROLL);
                    List.this.scrollEvent.setState(3);
                    List.this.scrollEvent.setOffsetX(0.0f);
                    List.this.scrollEvent.setOffsetY(0.0f);
                    List.this.scrollEvent.setDx(0.0f);
                    List.this.scrollEvent.setDy(0.0f);
                    List.this.scrollEvent.setTimestamp(System.currentTimeMillis());
                    List.this.mEventManager.dispatchEvent(ScrollEvent.HM_EVENT_TYPE_SCROLL, List.this.scrollEvent);
                    List.this.refreshNodeTree();
                } else if (i == 1) {
                    boolean unused2 = List.this.isScrollStarted = true;
                    List.this.scrollEvent.setType(ScrollEvent.HM_EVENT_TYPE_SCROLL);
                    List.this.scrollEvent.setState(1);
                    List.this.scrollEvent.setOffsetX(0.0f);
                    List.this.scrollEvent.setOffsetY(0.0f);
                    List.this.scrollEvent.setDx(0.0f);
                    List.this.scrollEvent.setDy(0.0f);
                    List.this.scrollEvent.setTimestamp(System.currentTimeMillis());
                    List.this.mEventManager.dispatchEvent(ScrollEvent.HM_EVENT_TYPE_SCROLL, List.this.scrollEvent);
                } else if (i == 2) {
                    List.this.scrollEvent.setType(ScrollEvent.HM_EVENT_TYPE_SCROLL);
                    List.this.scrollEvent.setState(4);
                    List.this.scrollEvent.setTimestamp(System.currentTimeMillis());
                    List.this.mEventManager.dispatchEvent(ScrollEvent.HM_EVENT_TYPE_SCROLL, List.this.scrollEvent);
                }
            }
        }
    };
    private int mode = 1;
    private boolean needUpdateEdgeSpacing = true;
    private boolean needUpdateLineSpacing = true;
    private boolean needUpdateMode = true;
    @JsProperty("onCreate")
    private JSCallback onCreate;
    @JsProperty("onRegister")
    private JSCallback onRegister;
    @JsProperty("onUpdate")
    private JSCallback onUpdate;
    /* access modifiers changed from: private */
    public RecyclerView recyclerView;
    private YogaNode recyclerViewNode;
    /* access modifiers changed from: private */
    @JsProperty("onRefresh")
    public JSCallback refreshCallback;
    private SmartRefreshLayout refreshLayout;
    @JsProperty("refreshView")
    private HMBase refreshView;
    private int rightSpacing;
    /* access modifiers changed from: private */
    public ScrollEvent scrollEvent = new ScrollEvent();
    @JsProperty("showScrollBar")
    private boolean showScrollBar;
    private int topSpacing;

    public List(HummerContext hummerContext, JSValue jSValue, String str) {
        super(hummerContext, jSValue, str);
        this.instanceManager = hummerContext.getObjectPool();
    }

    /* access modifiers changed from: protected */
    public SmartRefreshLayout createViewInstance(Context context) {
        LayoutInflater from = LayoutInflater.from(context);
        int i = R.layout.recycler_view;
        RecyclerView recyclerView2 = (RecyclerView) (!(from instanceof LayoutInflater) ? from.inflate(i, (ViewGroup) null, false) : XMLParseInstrumentation.inflate(from, i, (ViewGroup) null, false));
        this.recyclerView = recyclerView2;
        recyclerView2.setOverScrollMode(2);
        this.recyclerView.setClipChildren(false);
        this.recyclerView.setOnTouchListener(new List$$ExternalSyntheticLambda0(context));
        SmartRefreshLayout smartRefreshLayout = new SmartRefreshLayout(context);
        this.refreshLayout = smartRefreshLayout;
        smartRefreshLayout.setEnableRefresh(false);
        this.refreshLayout.setEnableLoadMore(false);
        this.refreshLayout.setEnableOverScrollDrag(true);
        this.refreshLayout.setRefreshContent(this.recyclerView);
        this.hummerHeader = new HummerHeader(context);
        this.hummerFooter = new HummerFooter(context);
        this.refreshLayout.setRefreshHeader(this.hummerHeader);
        this.refreshLayout.setRefreshFooter(this.hummerFooter);
        this.hummerHeader.setOnRefreshListener(new HummerHeader.OnRefreshListener() {
            public void onRefreshStarted() {
                if (List.this.refreshCallback != null) {
                    List.this.refreshCallback.call(1);
                }
            }

            public void onRefreshing() {
                if (List.this.refreshCallback != null) {
                    List.this.refreshCallback.call(2);
                }
            }

            public void onRefreshFinished() {
                if (List.this.refreshCallback != null) {
                    List.this.refreshCallback.call(0);
                }
            }
        });
        this.hummerFooter.setOnLoadListener(new HummerFooter.OnLoadListener() {
            public void onLoadFinished() {
            }

            public void onLoadStarted() {
            }

            public void onLoading() {
                boolean unused = List.this.isLoadingMore = true;
                if (List.this.loadMoreCallback != null) {
                    List.this.loadMoreCallback.call(1);
                }
            }
        });
        return this.refreshLayout;
    }

    static /* synthetic */ boolean lambda$createViewInstance$0(Context context, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        FocusUtil.clearFocus(context);
        return false;
    }

    public void onCreate() {
        super.onCreate();
        this.recyclerView.addOnScrollListener(this.mOnScrollListener);
        HMListAdapter hMListAdapter = new HMListAdapter(getContext(), this.instanceManager);
        this.adapter = hMListAdapter;
        this.recyclerView.setAdapter(hMListAdapter);
        YogaNode createYogaNode = YogaNodeUtil.createYogaNode();
        this.recyclerViewNode = createYogaNode;
        createYogaNode.setMeasureFunction(new YogaLayout.ViewMeasureFunction());
        this.recyclerViewNode.setData(this.recyclerView);
        this.recyclerViewNode.setFlexGrow(1.0f);
        getYogaNode().setMeasureFunction((YogaMeasureFunction) null);
        getYogaNode().addChildAt(this.recyclerViewNode, 0);
    }

    public void onDestroy() {
        super.onDestroy();
        HMListAdapter hMListAdapter = this.adapter;
        if (hMListAdapter != null) {
            hMListAdapter.destroy();
        }
    }

    /* access modifiers changed from: protected */
    public void onStyleUpdated(Map<String, Object> map) {
        if (this.needUpdateMode) {
            initLayoutManager();
        }
        if (this.needUpdateLineSpacing) {
            initLineSpacing();
        }
        if (this.needUpdateEdgeSpacing) {
            initEdgeSpacing();
        }
        this.needUpdateMode = false;
        this.needUpdateLineSpacing = false;
        this.needUpdateEdgeSpacing = false;
    }

    private void initLayoutManager() {
        int i = this.mode;
        int i2 = 1;
        if (i == 2) {
            if (this.direction == 2) {
                i2 = 0;
            }
            this.layoutManager = new GridLayoutManager(getContext(), this.column, i2, false);
        } else if (i != 3) {
            if (this.direction == 2) {
                i2 = 0;
            }
            this.layoutManager = new LinearLayoutManager(getContext(), i2, false);
        } else {
            if (this.direction == 2) {
                i2 = 0;
            }
            this.layoutManager = new StaggeredGridLayoutManager(this.column, i2) {
                private Method markItemDecorInsetsDirty = null;
                private boolean reflectError = false;

                public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                    if (this.markItemDecorInsetsDirty == null && !this.reflectError) {
                        try {
                            Method declaredMethod = RecyclerView.class.getDeclaredMethod("markItemDecorInsetsDirty", new Class[0]);
                            this.markItemDecorInsetsDirty = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                            this.reflectError = true;
                        }
                    }
                    if (this.markItemDecorInsetsDirty != null && state.willRunSimpleAnimations()) {
                        try {
                            this.markItemDecorInsetsDirty.invoke(List.this.recyclerView, new Object[0]);
                        } catch (IllegalAccessException e2) {
                            e2.printStackTrace();
                        } catch (InvocationTargetException e3) {
                            e3.printStackTrace();
                        }
                    }
                    List.super.onLayoutChildren(recycler, state);
                }

                public void requestSimpleAnimationsInNextLayout() {
                    List.super.requestSimpleAnimationsInNextLayout();
                    Method method = this.markItemDecorInsetsDirty;
                    if (method != null) {
                        try {
                            method.invoke(List.this.recyclerView, new Object[0]);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            };
        }
        this.recyclerView.setLayoutManager(this.layoutManager);
    }

    private void initLineSpacing() {
        RecyclerView.ItemDecoration itemDecoration2 = this.itemDecoration;
        int i = this.mode;
        if (i != 2) {
            if (i != 3) {
                if (this.lineSpacing > 0) {
                    this.itemDecoration = new LinearSpacingItemDecoration(this.lineSpacing, false);
                }
            } else if (this.lineSpacing > 0 || this.itemSpacing > 0) {
                this.itemDecoration = new StaggeredGridSpacingItemDecoration(this.column, this.lineSpacing, this.itemSpacing, false);
            }
        } else if (this.lineSpacing > 0 || this.itemSpacing > 0) {
            this.itemDecoration = new GridSpacingItemDecoration(this.column, this.lineSpacing, this.itemSpacing, false);
        }
        if (this.itemDecoration != null) {
            if (itemDecoration2 != null) {
                this.recyclerView.removeItemDecoration(itemDecoration2);
            }
            this.recyclerView.addItemDecoration(this.itemDecoration);
        }
    }

    private void initEdgeSpacing() {
        int i = this.leftSpacing;
        if (i > 0 || this.rightSpacing > 0 || this.topSpacing > 0 || this.bottomSpacing > 0) {
            this.recyclerView.setPadding(i, this.topSpacing, this.rightSpacing, this.bottomSpacing);
            this.recyclerView.setClipToPadding(false);
        }
    }

    /* access modifiers changed from: private */
    public void hideKeyboardIfNeed(int i, int i2) {
        int i3;
        int i4 = this.direction;
        if (i4 == 1) {
            i3 = Math.abs(i2);
        } else {
            i3 = i4 == 2 ? Math.abs(i) : 0;
        }
        if (i3 > 20 && (((SmartRefreshLayout) getView()).getContext() instanceof Activity)) {
            Activity activity = (Activity) ((SmartRefreshLayout) getView()).getContext();
            if (activity.getCurrentFocus() != null && activity.getCurrentFocus().getWindowToken() != null) {
                KeyboardUtil.hideKeyboard(activity.getCurrentFocus());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @com.didi.hummer.annotation.JsAttribute({"mode"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setMode(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -213632750(0xfffffffff3443912, float:-1.5546382E31)
            r2 = 2
            r3 = 3
            if (r0 == r1) goto L_0x002a
            r1 = 3181382(0x308b46, float:4.458066E-39)
            if (r0 == r1) goto L_0x0020
            r1 = 3322014(0x32b09e, float:4.655133E-39)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "list"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 0
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "grid"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = r2
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "waterfall"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = r3
            goto L_0x0035
        L_0x0034:
            r5 = -1
        L_0x0035:
            r0 = 1
            if (r5 == r2) goto L_0x003d
            if (r5 == r3) goto L_0x003c
            r2 = r0
            goto L_0x003d
        L_0x003c:
            r2 = r3
        L_0x003d:
            int r5 = r4.mode
            if (r5 == r2) goto L_0x0067
            r4.mode = r2
            r4.needUpdateMode = r0
            if (r2 != r3) goto L_0x0067
            int r5 = r4.lineSpacing
            r1 = 1090519040(0x41000000, float:8.0)
            if (r5 > 0) goto L_0x0057
            android.content.Context r5 = r4.getContext()
            int r5 = com.didi.hummer.render.utility.DPUtil.dp2px(r5, r1)
            r4.lineSpacing = r5
        L_0x0057:
            int r5 = r4.itemSpacing
            if (r5 > 0) goto L_0x0065
            android.content.Context r5 = r4.getContext()
            int r5 = com.didi.hummer.render.utility.DPUtil.dp2px(r5, r1)
            r4.itemSpacing = r5
        L_0x0065:
            r4.needUpdateLineSpacing = r0
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hummer.component.list.List.setMode(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @com.didi.hummer.annotation.JsAttribute({"scrollDirection"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setScrollDirection(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = -1984141450(0xffffffff89bc6776, float:-4.5356648E-33)
            r2 = 2
            if (r0 == r1) goto L_0x001a
            r1 = 1387629604(0x52b58c24, float:3.89870125E11)
            if (r0 == r1) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.String r0 = "horizontal"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0024
            r4 = r2
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "vertical"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0024
            r4 = 0
            goto L_0x0025
        L_0x0024:
            r4 = -1
        L_0x0025:
            r0 = 1
            if (r4 == r2) goto L_0x0029
            r2 = r0
        L_0x0029:
            int r4 = r3.direction
            if (r4 == r2) goto L_0x0031
            r3.direction = r2
            r3.needUpdateMode = r0
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hummer.component.list.List.setScrollDirection(java.lang.String):void");
    }

    @JsAttribute({"column"})
    public void setColumn(int i) {
        if (this.column != i) {
            this.column = i;
            int i2 = this.mode;
            if (i2 == 2 || i2 == 3) {
                this.needUpdateMode = true;
                this.needUpdateLineSpacing = true;
            }
        }
    }

    @JsAttribute({"lineSpacing"})
    public void setLineSpacing(int i) {
        if (this.lineSpacing != i) {
            this.lineSpacing = i;
            this.needUpdateLineSpacing = true;
        }
    }

    @JsAttribute({"itemSpacing"})
    public void setItemSpacing(int i) {
        if (this.itemSpacing != i) {
            this.itemSpacing = i;
            int i2 = this.mode;
            if (i2 == 2 || i2 == 3) {
                this.needUpdateLineSpacing = true;
            }
        }
    }

    @JsAttribute({"leftSpacing"})
    public void setLeftSpacing(int i) {
        if (this.leftSpacing != i) {
            this.leftSpacing = i;
            this.needUpdateEdgeSpacing = true;
        }
    }

    @JsAttribute({"rightSpacing"})
    public void setRightSpacing(int i) {
        if (this.rightSpacing != i) {
            this.rightSpacing = i;
            this.needUpdateEdgeSpacing = true;
        }
    }

    @JsAttribute({"topSpacing"})
    public void setTopSpacing(int i) {
        if (this.topSpacing != i) {
            this.topSpacing = i;
            this.needUpdateEdgeSpacing = true;
        }
    }

    @JsAttribute({"bottomSpacing"})
    public void setBottomSpacing(int i) {
        if (this.bottomSpacing != i) {
            this.bottomSpacing = i;
            this.needUpdateEdgeSpacing = true;
        }
    }

    public void setRefreshView(HMBase hMBase) {
        this.refreshView = hMBase;
        this.refreshLayout.setEnableRefresh(true);
        this.hummerHeader.addHeaderView(hMBase);
    }

    public void setLoadMoreView(HMBase hMBase) {
        this.loadMoreView = hMBase;
        this.refreshLayout.setEnableLoadMore(true);
        this.hummerFooter.addFooterView(hMBase);
    }

    public void setOnRefresh(JSCallback jSCallback) {
        this.refreshCallback = jSCallback;
    }

    public void setOnLoadMore(JSCallback jSCallback) {
        this.loadMoreCallback = jSCallback;
    }

    public void setOnRegister(JSCallback jSCallback) {
        this.adapter.setTypeCallback(jSCallback);
    }

    public void setOnCreate(JSCallback jSCallback) {
        this.adapter.setCreateCallback(jSCallback);
    }

    public void setOnUpdate(JSCallback jSCallback) {
        this.adapter.setUpdateCallback(jSCallback);
    }

    public void setShowScrollBar(boolean z) {
        this.showScrollBar = z;
        int i = this.direction;
        if (i == 1) {
            this.recyclerView.setVerticalScrollBarEnabled(z);
        } else if (i == 2) {
            this.recyclerView.setHorizontalScrollBarEnabled(z);
        }
    }

    public void setBounces(boolean z) {
        this.refreshLayout.setEnableOverScrollDrag(z);
    }

    @JsMethod("refresh")
    public void refresh(int i) {
        if (!this.isLoadingMore) {
            this.refreshLayout.resetNoMoreData();
        }
        YogaNode yogaNode = this.recyclerViewNode;
        if (yogaNode != null) {
            yogaNode.dirty();
        }
        HMListAdapter hMListAdapter = this.adapter;
        if (hMListAdapter != null) {
            hMListAdapter.refresh(i, this.isLoadingMore);
        }
        this.isLoadingMore = false;
        refreshNodeTree();
    }

    @JsMethod("stopPullRefresh")
    public void stopPullRefresh() {
        this.refreshLayout.finishRefresh(30);
    }

    @JsMethod("stopLoadMore")
    public void stopLoadMore(boolean z) {
        if (z) {
            this.refreshLayout.finishLoadMore();
            this.refreshLayout.resetNoMoreData();
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

    @JsMethod("scrollTo")
    public void scrollTo(Object obj, Object obj2) {
        this.recyclerView.scrollTo((int) HummerStyleUtils.convertNumber(obj), (int) HummerStyleUtils.convertNumber(obj2));
    }

    @JsMethod("scrollBy")
    public void scrollBy(Object obj, Object obj2) {
        this.recyclerView.scrollBy((int) HummerStyleUtils.convertNumber(obj), (int) HummerStyleUtils.convertNumber(obj2));
    }

    @JsMethod("scrollToPosition")
    public void scrollToPosition(int i) {
        LinearLayoutManager linearLayoutManager = this.layoutManager;
        if (linearLayoutManager instanceof LinearLayoutManager) {
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    @JsMethod("dbg_getDescription")
    public void dbg_getDescription(JSCallback jSCallback, int i) {
        refreshNodeTree();
        super.dbg_getDescription(jSCallback, i);
    }

    /* access modifiers changed from: private */
    public void refreshNodeTree() {
        if (DebugUtil.isDebuggable()) {
            ((SmartRefreshLayout) getView()).post(new List$$ExternalSyntheticLambda1(this));
        }
    }

    public /* synthetic */ void lambda$refreshNodeTree$1$List() {
        HummerNode node;
        getNode().removeAll();
        HMBase hMBase = this.refreshView;
        if (hMBase != null) {
            hMBase.getNode().setAlias("Header");
            getNode().appendChild(this.refreshView.getNode());
        }
        int lastVisibleItemPosition = ListUtil.getLastVisibleItemPosition(this.layoutManager);
        for (int firstVisibleItemPosition = ListUtil.getFirstVisibleItemPosition(this.layoutManager); firstVisibleItemPosition <= lastVisibleItemPosition; firstVisibleItemPosition++) {
            HMListAdapter.ViewHolder findViewHolderForAdapterPosition = this.recyclerView.findViewHolderForAdapterPosition(firstVisibleItemPosition);
            if ((findViewHolderForAdapterPosition instanceof HMListAdapter.ViewHolder) && (node = findViewHolderForAdapterPosition.getNode()) != null) {
                node.setAlias(String.valueOf(firstVisibleItemPosition));
                getNode().appendChild(node);
            }
        }
        HMBase hMBase2 = this.loadMoreView;
        if (hMBase2 != null) {
            hMBase2.getNode().setAlias("Footer");
            getNode().appendChild(this.loadMoreView.getNode());
        }
    }

    public void resetStyle() {
        super.resetStyle();
        setMode("list");
        setScrollDirection("vertical");
        setColumn(2);
        setShowScrollBar(false);
    }

    public boolean setStyle(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1625116241:
                if (str.equals(HummerStyleUtils.Hummer.LINE_SPACING)) {
                    c = 0;
                    break;
                }
                break;
            case -1354837162:
                if (str.equals(HummerStyleUtils.Hummer.COLUMN)) {
                    c = 1;
                    break;
                }
                break;
            case 3357091:
                if (str.equals(HummerStyleUtils.Hummer.MODE)) {
                    c = 2;
                    break;
                }
                break;
            case 26501767:
                if (str.equals(HummerStyleUtils.Hummer.RIGHT_SPACING)) {
                    c = 3;
                    break;
                }
                break;
            case 1022176152:
                if (str.equals(HummerStyleUtils.Hummer.BOTTOM_SPACING)) {
                    c = 4;
                    break;
                }
                break;
            case 1108022844:
                if (str.equals(HummerStyleUtils.Hummer.LEFT_SPACING)) {
                    c = 5;
                    break;
                }
                break;
            case 1489010990:
                if (str.equals(HummerStyleUtils.Hummer.TOP_SPACING)) {
                    c = 6;
                    break;
                }
                break;
            case 1614714674:
                if (str.equals(HummerStyleUtils.Hummer.SCROLL_DIRECTION)) {
                    c = 7;
                    break;
                }
                break;
            case 1748891056:
                if (str.equals(HummerStyleUtils.Hummer.ITEM_SPACING)) {
                    c = 8;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                setLineSpacing((int) ((Float) obj).floatValue());
                break;
            case 1:
                setColumn((int) ((Float) obj).floatValue());
                break;
            case 2:
                setMode(String.valueOf(obj));
                break;
            case 3:
                setRightSpacing((int) ((Float) obj).floatValue());
                break;
            case 4:
                setBottomSpacing((int) ((Float) obj).floatValue());
                break;
            case 5:
                setLeftSpacing((int) ((Float) obj).floatValue());
                break;
            case 6:
                setTopSpacing((int) ((Float) obj).floatValue());
                break;
            case 7:
                setScrollDirection(String.valueOf(obj));
                break;
            case 8:
                setItemSpacing((int) ((Float) obj).floatValue());
                break;
            default:
                return false;
        }
        return true;
    }
}
