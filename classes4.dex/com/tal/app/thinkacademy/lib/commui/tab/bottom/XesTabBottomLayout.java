package com.tal.app.thinkacademy.lib.commui.tab.bottom;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.commui.tab.common.IXesTabLayout;
import com.tal.app.thinkacademy.lib.utils.XesDisplayUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XesTabBottomLayout extends FrameLayout implements IXesTabLayout<XesTabBottom, XesTabBottomInfo<?>> {
    private static final String TAG_TAB_BOTTOM = "TAG_TAB_BOTTOM";
    private static float tabBottomHeight = 50.0f;
    private float bottomAlpha;
    private String bottomLineColor;
    private float bottomLineHeight;
    private List<XesTabBottomInfo<?>> infoList;
    private XesTabBottomInfo<?> selectedInfo;
    private List<IXesTabLayout.OnTabSelectedListener<XesTabBottomInfo<?>>> tabSelectedChangeListeners;

    public static void clipBottomPadding(ViewGroup viewGroup) {
    }

    public XesTabBottomLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public XesTabBottomLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XesTabBottomLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tabSelectedChangeListeners = new ArrayList();
        this.bottomAlpha = 1.0f;
        this.bottomLineHeight = 0.5f;
        this.bottomLineColor = "#dfe0e1";
    }

    public void inflateInfo(List<XesTabBottomInfo<?>> list, boolean z) {
        if (!list.isEmpty()) {
            this.infoList = list;
            for (int childCount = getChildCount() - 1; childCount > 0; childCount--) {
                removeViewAt(childCount);
            }
            this.selectedInfo = null;
            addBackground(z);
            Iterator<IXesTabLayout.OnTabSelectedListener<XesTabBottomInfo<?>>> it = this.tabSelectedChangeListeners.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof XesTabBottom) {
                    it.remove();
                }
            }
            if (z) {
                createLeftTab(list);
            } else {
                createBottomTab(list);
            }
            fixContentView(z);
        }
    }

    private void createBottomTab(List<XesTabBottomInfo<?>> list) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        int dp2px = XesDisplayUtil.dp2px(tabBottomHeight, getResources());
        int displayWidthInPx = XesDisplayUtil.getDisplayWidthInPx(getContext()) / list.size();
        frameLayout.setTag(TAG_TAB_BOTTOM);
        for (int i = 0; i < list.size(); i++) {
            final XesTabBottomInfo xesTabBottomInfo = list.get(i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(displayWidthInPx, dp2px);
            layoutParams.gravity = 80;
            layoutParams.leftMargin = i * displayWidthInPx;
            XesTabBottom xesTabBottom = new XesTabBottom(getContext());
            this.tabSelectedChangeListeners.add(xesTabBottom);
            xesTabBottom.setXesTabInfo((XesTabBottomInfo<?>) xesTabBottomInfo);
            frameLayout.addView(xesTabBottom, layoutParams);
            xesTabBottom.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MethodInfo.onClickEventEnter(view, XesTabBottomLayout.class);
                    XesTabBottomLayout.this.onSelected(xesTabBottomInfo);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    MethodInfo.onClickEventEnd();
                }
            });
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        addTabLine(false);
        addView(frameLayout, layoutParams2);
    }

    private void createLeftTab(List<XesTabBottomInfo<?>> list) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        int dp2px = XesDisplayUtil.dp2px(tabBottomHeight, getResources());
        int displayHeightInPx = XesDisplayUtil.getDisplayHeightInPx(getContext()) / (list.size() + 2);
        frameLayout.setTag(TAG_TAB_BOTTOM);
        int i = 0;
        while (i < list.size()) {
            final XesTabBottomInfo xesTabBottomInfo = list.get(i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dp2px, displayHeightInPx);
            layoutParams.gravity = 8388611;
            i++;
            layoutParams.topMargin = i * displayHeightInPx;
            XesTabBottom xesTabBottom = new XesTabBottom(getContext());
            this.tabSelectedChangeListeners.add(xesTabBottom);
            xesTabBottom.setXesTabInfo((XesTabBottomInfo<?>) xesTabBottomInfo);
            FrameLayout frameLayout2 = new FrameLayout(getContext());
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dp2px, dp2px);
            layoutParams2.gravity = 16;
            frameLayout2.addView(xesTabBottom, layoutParams2);
            frameLayout.addView(frameLayout2, layoutParams);
            xesTabBottom.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MethodInfo.onClickEventEnter(view, XesTabBottomLayout.class);
                    XesTabBottomLayout.this.onSelected(xesTabBottomInfo);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    MethodInfo.onClickEventEnd();
                }
            });
        }
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams3.gravity = 8388611;
        addTabLine(true);
        addView(frameLayout, layoutParams3);
    }

    public void addTabSelectedChangeListener(IXesTabLayout.OnTabSelectedListener<XesTabBottomInfo<?>> onTabSelectedListener) {
        this.tabSelectedChangeListeners.add(onTabSelectedListener);
    }

    public void setTabAlpha(float f) {
        this.bottomAlpha = f;
    }

    public void setTabHeight(float f) {
        tabBottomHeight = f;
    }

    public void setBottomLineHeight(float f) {
        this.bottomLineHeight = f;
    }

    public void setBottomLineColor(String str) {
        this.bottomLineColor = str;
    }

    public XesTabBottom findTab(XesTabBottomInfo<?> xesTabBottomInfo) {
        ViewGroup viewGroup = (ViewGroup) findViewWithTag(TAG_TAB_BOTTOM);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof XesTabBottom) {
                XesTabBottom xesTabBottom = (XesTabBottom) childAt;
                if (xesTabBottom.getmTabInfo() == xesTabBottomInfo) {
                    return xesTabBottom;
                }
            }
        }
        return null;
    }

    public void defaultSelected(XesTabBottomInfo<?> xesTabBottomInfo) {
        onSelected(xesTabBottomInfo);
    }

    /* access modifiers changed from: private */
    public void onSelected(XesTabBottomInfo<?> xesTabBottomInfo) {
        for (IXesTabLayout.OnTabSelectedListener<XesTabBottomInfo<?>> onTabSelectedChange : this.tabSelectedChangeListeners) {
            onTabSelectedChange.onTabSelectedChange(this.infoList.indexOf(xesTabBottomInfo), this.selectedInfo, xesTabBottomInfo);
        }
        this.selectedInfo = xesTabBottomInfo;
    }

    private void addTabLine(boolean z) {
        FrameLayout.LayoutParams layoutParams;
        View view = new View(getContext());
        view.setBackgroundColor(Color.parseColor(this.bottomLineColor));
        if (z) {
            layoutParams = new FrameLayout.LayoutParams(XesDisplayUtil.dp2px(this.bottomLineHeight, getResources()) + 1, -1);
            layoutParams.gravity = 8388611;
            layoutParams.setMarginStart(XesDisplayUtil.dp2px(tabBottomHeight - this.bottomLineHeight, getResources()));
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, XesDisplayUtil.dp2px(this.bottomLineHeight, getResources()));
            layoutParams.gravity = 80;
            layoutParams.bottomMargin = XesDisplayUtil.dp2px(tabBottomHeight - this.bottomLineHeight, getResources());
        }
        addView(view, layoutParams);
        view.setAlpha(this.bottomAlpha);
    }

    private void addBackground(boolean z) {
        LayoutInflater from = LayoutInflater.from(getContext());
        int i = R.layout.xes_bottom_layout_bg;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, i, (ViewGroup) null);
        if (z) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(XesDisplayUtil.dp2px(tabBottomHeight, getResources()), -1);
            layoutParams.gravity = 8388611;
            addView(inflate, layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, XesDisplayUtil.dp2px(tabBottomHeight, getResources()));
            layoutParams2.gravity = 80;
            addView(inflate, layoutParams2);
        }
        inflate.setAlpha(this.bottomAlpha);
    }

    private void fixContentView(boolean z) {
        ViewGroup viewGroup;
        if ((getChildAt(0) instanceof ViewGroup) && (viewGroup = (ViewGroup) getChildAt(0)) != null) {
            if (z) {
                viewGroup.setPadding(XesDisplayUtil.dp2px(tabBottomHeight, getResources()), 0, 0, 0);
            } else {
                viewGroup.setPadding(0, 0, 0, XesDisplayUtil.dp2px(tabBottomHeight, getResources()));
            }
            viewGroup.setClipToPadding(false);
        }
    }
}
