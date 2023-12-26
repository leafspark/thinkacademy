package com.didi.hummer.component.viewpager;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsAttribute;
import com.didi.hummer.annotation.JsMethod;
import com.didi.hummer.annotation.JsProperty;
import com.didi.hummer.component.R;
import com.didi.hummer.component.viewpager.CyclePagerAdapter;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.util.DebugUtil;
import com.didi.hummer.lifecycle.IFullLifeCycle;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.style.HummerNode;
import com.didi.hummer.render.style.HummerStyleUtils;
import com.huawei.multimedia.audiokit.config.ResultCode;
import com.zhpan.bannerview.BannerViewPager;
import com.zhpan.bannerview.holder.ViewHolder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component("ViewPager")
public class ViewPager extends HMBase<BannerViewPager<Object, ViewHolder>> implements IFullLifeCycle {
    private static final String STYLE_ALPHA_FACTOR = "alphaFactor";
    private static final String STYLE_AUTO_PLAY = "autoPlay";
    private static final String STYLE_CAN_LOOP = "canLoop";
    private static final String STYLE_EDGE_SPACING = "edgeSpacing";
    private static final String STYLE_ITEM_SPACING = "itemSpacing";
    private static final String STYLE_LOOP_INTERVAL = "loopInterval";
    private static final String STYLE_SCALE_FACTOR = "scaleFactor";
    private CyclePagerAdapter adapter;
    private float alphaFactor = 0.5f;
    private boolean autoPlay;
    /* access modifiers changed from: private */
    public boolean canLoop;
    private int cornerRadius;
    /* access modifiers changed from: private */
    public float edgeSpacing;
    /* access modifiers changed from: private */
    public boolean isDataSetting;
    private float itemSpacing;
    private int loopInterval;
    @JsProperty("data")
    public List<Object> mData = new ArrayList();
    private JSCallback mOnItemClickListener;
    private JSCallback mOnItemViewCallback;
    /* access modifiers changed from: private */
    public JSCallback mOnPageChangeListener;
    /* access modifiers changed from: private */
    public JSCallback mOnPageScrollListener;
    /* access modifiers changed from: private */
    public JSCallback mOnPageScrollStateChangeListener;
    private float scaleFactor = 0.85f;

    public void onStart() {
    }

    public void onStop() {
    }

    public ViewPager(HummerContext hummerContext, JSValue jSValue) {
        super(hummerContext, jSValue, (String) null);
        HummerStyleUtils.addNonDpStyle(STYLE_LOOP_INTERVAL);
        HummerStyleUtils.addNonDpStyle(STYLE_SCALE_FACTOR);
        HummerStyleUtils.addNonDpStyle(STYLE_ALPHA_FACTOR);
        CyclePagerAdapter cyclePagerAdapter = new CyclePagerAdapter(hummerContext, hummerContext.getObjectPool());
        this.adapter = cyclePagerAdapter;
        cyclePagerAdapter.setOnItemClickListener(new ViewPager$$ExternalSyntheticLambda0(this));
        getView().getViewPager().setOverScrollMode(2);
        getView().setScrollDuration(ResultCode.KARAOKE_SUCCESS).setCanLoop(false).setIndicatorVisibility(8).setHolderCreator(new ViewPager$$ExternalSyntheticLambda1(this)).setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int i, float f, int i2) {
                if (ViewPager.this.mOnPageScrollListener != null) {
                    if (((double) f) >= 0.5d) {
                        i++;
                    }
                    ViewPager.this.mOnPageScrollListener.call(Integer.valueOf(i), Float.valueOf(f));
                }
            }

            public void onPageSelected(int i) {
                ViewPager.this.refreshNodeTree();
                if (ViewPager.this.mOnPageChangeListener != null && !ViewPager.this.isDataSetting) {
                    ViewPager.this.mOnPageChangeListener.call(Integer.valueOf(i), Integer.valueOf(ViewPager.this.mData.size()));
                }
            }

            public void onPageScrollStateChanged(int i) {
                if (ViewPager.this.mOnPageScrollStateChangeListener != null) {
                    ViewPager.this.mOnPageScrollStateChangeListener.call(Integer.valueOf(i));
                }
            }
        });
    }

    public /* synthetic */ void lambda$new$0$ViewPager(int i) {
        int realPosition = this.adapter.getRealPosition(getView().getViewPager().getCurrentItem());
        if (i == realPosition) {
            JSCallback jSCallback = this.mOnItemClickListener;
            if (jSCallback != null) {
                jSCallback.call(Integer.valueOf(i));
            }
        } else if (i == realPosition - 1 || i == realPosition + 1) {
            setCurrentItem(i);
        }
    }

    public /* synthetic */ ViewHolder lambda$new$1$ViewPager() {
        return new EmptyViewHolder();
    }

    /* access modifiers changed from: protected */
    public BannerViewPager<Object, ViewHolder> createViewInstance(Context context) {
        return new BannerViewPager<Object, ViewHolder>(context) {
            private int startX;
            private int startY;

            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                if (getCurrentItem() == 0 && getViewPager().getChildCount() == 0) {
                    return true;
                }
                processMotionEventConflict(motionEvent);
                motionEvent.offsetLocation(-ViewPager.this.edgeSpacing, 0.0f);
                try {
                    return getViewPager().dispatchTouchEvent(motionEvent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return true;
                }
            }

            /* access modifiers changed from: protected */
            public void processMotionEventConflict(MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            int x = (int) motionEvent.getX();
                            if (Math.abs(x - this.startX) * 2 < Math.abs(((int) motionEvent.getY()) - this.startY)) {
                                getParent().requestDisallowInterceptTouchEvent(false);
                                return;
                            } else if (ViewPager.this.canLoop) {
                                return;
                            } else {
                                if (getViewPager().getCurrentItem() == 0 && x - this.startX > 0) {
                                    getParent().requestDisallowInterceptTouchEvent(false);
                                    return;
                                } else if (getViewPager().getCurrentItem() == getList().size() - 1 && x - this.startX < 0) {
                                    getParent().requestDisallowInterceptTouchEvent(false);
                                    return;
                                } else {
                                    return;
                                }
                            }
                        } else if (action != 3) {
                            if (action == 4) {
                                startLoop();
                                return;
                            }
                            return;
                        }
                    }
                    startLoop();
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return;
                }
                stopLoop();
                this.startX = (int) motionEvent.getX();
                this.startY = (int) motionEvent.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        };
    }

    public void onResume() {
        getView().startLoop();
    }

    public void onPause() {
        getView().stopLoop();
    }

    public void onStyleUpdated(Map<String, Object> map) {
        initPageStyle();
    }

    private void initPageStyle() {
        int i = 0;
        boolean z = this.autoPlay && this.loopInterval > 0;
        if (!z) {
            getView().stopLoop();
        }
        BannerViewPager view = getView();
        if (this.edgeSpacing > 0.0f) {
            i = 2;
        }
        view.setPageStyle(i).setRevealWidth((int) (this.edgeSpacing - this.itemSpacing)).setAutoPlay(z).setInterval(this.loopInterval).setRoundCorner(this.cornerRadius);
        int i2 = (int) this.itemSpacing;
        if (i2 != getView().getViewPager().getPageMargin()) {
            getView().setPageMargin(i2);
        }
        if (this.canLoop != this.adapter.isCanLoop()) {
            getView().setCanLoop(this.canLoop);
            this.adapter.setCanLoop(this.canLoop);
            if (!this.mData.isEmpty()) {
                setData(this.mData);
            }
        }
    }

    public void setData(List<Object> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (list.isEmpty() || (list.get(0) instanceof String) || this.mOnItemViewCallback != null) {
            this.isDataSetting = true;
            this.mData = list;
            getView().create(list);
            if (this.edgeSpacing > 0.0f) {
                if (this.scaleFactor > 0.0f || this.alphaFactor > 0.0f) {
                    getView().setPageTransformer(new ScaleAndAlphaTransformer(this.scaleFactor, this.alphaFactor));
                } else {
                    getView().setPageTransformer((ViewPager.PageTransformer) null);
                }
            }
            this.adapter.setData(list);
            getView().getViewPager().setAdapter(this.adapter);
            this.isDataSetting = false;
            setCurrentItem(0);
            refreshNodeTree();
        }
    }

    @JsMethod("setCurrentItem")
    public void setCurrentItem(int i) {
        if (i >= 0 && this.adapter.getItemCount() > 0) {
            getView().setCurrentItem(Math.min(i, this.adapter.getItemCount() - 1));
        }
    }

    @JsMethod("onPageChange")
    public void onPageChange(JSCallback jSCallback) {
        this.mOnPageChangeListener = jSCallback;
    }

    @JsMethod("onPageScroll")
    public void onPageScroll(JSCallback jSCallback) {
        this.mOnPageScrollListener = jSCallback;
    }

    @JsMethod("onPageScrollStateChange")
    public void onPageScrollStateChange(JSCallback jSCallback) {
        this.mOnPageScrollStateChangeListener = jSCallback;
    }

    @JsMethod("onItemClick")
    public void onItemClick(JSCallback jSCallback) {
        this.mOnItemClickListener = jSCallback;
    }

    @JsMethod("onItemView")
    public void onItemView(JSCallback jSCallback) {
        this.mOnItemViewCallback = jSCallback;
        this.adapter.setOnItemViewCallback(jSCallback);
    }

    @JsMethod("dbg_getDescription")
    public void dbg_getDescription(JSCallback jSCallback, int i) {
        refreshNodeTree();
        super.dbg_getDescription(jSCallback, i);
    }

    /* access modifiers changed from: private */
    public void refreshNodeTree() {
        if (DebugUtil.isDebuggable()) {
            getView().post(new ViewPager$$ExternalSyntheticLambda2(this));
        }
    }

    public /* synthetic */ void lambda$refreshNodeTree$2$ViewPager() {
        HummerNode node;
        getNode().removeAll();
        int min = Math.min(getView().getViewPager().getChildCount(), this.adapter.getItemCount());
        int currentItem = getView().getCurrentItem();
        if (min > 1 && currentItem < min - 1) {
            currentItem++;
        }
        for (int i = (min <= 1 || currentItem <= 0) ? currentItem : currentItem - 1; i <= currentItem; i++) {
            if (getView().getViewPager().getChildAt(i) != null) {
                Object tag = getView().getViewPager().getChildAt(i).getTag(R.id.holder_id);
                if ((tag instanceof CyclePagerAdapter.ViewHolder) && (node = ((CyclePagerAdapter.ViewHolder) tag).getNode()) != null) {
                    node.setAlias(String.valueOf(i));
                    getNode().appendChild(node);
                }
            }
        }
    }

    @JsAttribute({"itemSpacing"})
    public void setItemSpacing(float f) {
        this.itemSpacing = f;
    }

    @JsAttribute({"edgeSpacing"})
    public void setEdgeSpacing(float f) {
        this.edgeSpacing = f;
    }

    @JsAttribute({"canLoop"})
    public void setCanLoop(boolean z) {
        this.canLoop = z;
    }

    @JsAttribute({"autoPlay"})
    public void setAutoPlay(boolean z) {
        this.autoPlay = z;
    }

    @JsAttribute({"loopInterval"})
    public void setLoopInterval(int i) {
        this.loopInterval = i;
    }

    @JsAttribute({"scaleFactor"})
    public void setScaleFactor(float f) {
        this.scaleFactor = f;
    }

    @JsAttribute({"alphaFactor"})
    public void setAlphaFactor(float f) {
        this.alphaFactor = f;
    }

    public void setBorderRadius(float f) {
        this.cornerRadius = (int) f;
    }

    public void resetStyle() {
        super.resetStyle();
        getView().setPageStyle(0).setPageMargin(0).setRevealWidth(0).setCanLoop(false).setAutoPlay(false).setInterval(0).setRoundCorner(0).setPageTransformer((ViewPager.PageTransformer) null);
        this.adapter.setCanLoop(false);
    }

    public boolean setStyle(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1210167495:
                if (str.equals(STYLE_SCALE_FACTOR)) {
                    c = 0;
                    break;
                }
                break;
            case -1181511738:
                if (str.equals(STYLE_EDGE_SPACING)) {
                    c = 1;
                    break;
                }
                break;
            case -1111610487:
                if (str.equals(STYLE_LOOP_INTERVAL)) {
                    c = 2;
                    break;
                }
                break;
            case 323197005:
                if (str.equals(STYLE_ALPHA_FACTOR)) {
                    c = 3;
                    break;
                }
                break;
            case 549540500:
                if (str.equals(STYLE_CAN_LOOP)) {
                    c = 4;
                    break;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    c = 5;
                    break;
                }
                break;
            case 1438608771:
                if (str.equals(STYLE_AUTO_PLAY)) {
                    c = 6;
                    break;
                }
                break;
            case 1748891056:
                if (str.equals("itemSpacing")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                setScaleFactor(((Float) obj).floatValue());
                break;
            case 1:
                setEdgeSpacing(((Float) obj).floatValue());
                break;
            case 2:
                setLoopInterval((int) ((Float) obj).floatValue());
                break;
            case 3:
                setAlphaFactor(((Float) obj).floatValue());
                break;
            case 4:
                setCanLoop(((Boolean) obj).booleanValue());
                break;
            case 5:
                if (obj instanceof Float) {
                    setBorderRadius(((Float) obj).floatValue());
                    break;
                }
                break;
            case 6:
                setAutoPlay(((Boolean) obj).booleanValue());
                break;
            case 7:
                setItemSpacing(((Float) obj).floatValue());
                break;
            default:
                return false;
        }
        return true;
    }

    public class EmptyViewHolder implements ViewHolder<Object> {
        public void onBind(View view, Object obj, int i, int i2) {
        }

        public EmptyViewHolder() {
        }

        public int getLayoutId() {
            return R.layout.viewpager_empty_view;
        }
    }
}
