package com.didi.hummer.component.view;

import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsAttribute;
import com.didi.hummer.annotation.JsMethod;
import com.didi.hummer.component.imageview.Image;
import com.didi.hummer.component.list.List;
import com.didi.hummer.component.scroller.HorizontalScroller;
import com.didi.hummer.component.scroller.Scroller;
import com.didi.hummer.component.viewpager.ViewPager;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.component.view.HummerLayoutExtendView;
import com.didi.hummer.render.style.HummerLayout;
import com.didi.hummer.render.style.HummerStyleUtils;

@Component("View")
public class View extends HummerLayoutExtendView {
    private static final String OVERFLOW_HIDDEN = "hidden";
    private static final String OVERFLOW_VISIBLE = "visible";

    @JsMethod("empty")
    public void empty() {
    }

    public View(HummerContext hummerContext, JSValue jSValue, String str) {
        super(hummerContext, jSValue, str);
    }

    @JsMethod("appendChild")
    public void appendChild(HMBase hMBase) {
        super.appendChild(hMBase);
        if (hMBase != null) {
            getNode().appendChild(hMBase.getNode());
            if ((hMBase instanceof Image) || (hMBase instanceof Scroller) || (hMBase instanceof HorizontalScroller) || (hMBase instanceof List) || (hMBase instanceof ViewPager)) {
                ((HummerLayout) getView()).setClipChildren(true);
            }
        }
    }

    @JsMethod("removeChild")
    public void removeChild(HMBase hMBase) {
        super.removeChild(hMBase);
        if (hMBase != null) {
            getNode().removeChild(hMBase.getNode());
        }
    }

    @JsMethod("removeAll")
    public void removeAll() {
        super.removeAll();
        getNode().removeAll();
    }

    @JsMethod("insertBefore")
    public void insertBefore(HMBase hMBase, HMBase hMBase2) {
        super.insertBefore(hMBase, hMBase2);
        if (hMBase != null && hMBase2 != null) {
            getNode().insertBefore(hMBase.getNode(), hMBase2.getNode());
            if ((hMBase instanceof Image) || (hMBase instanceof Scroller) || (hMBase instanceof HorizontalScroller) || (hMBase instanceof List) || (hMBase instanceof ViewPager)) {
                ((HummerLayout) getView()).setClipChildren(true);
            }
        }
    }

    @JsMethod("replaceChild")
    public void replaceChild(HMBase hMBase, HMBase hMBase2) {
        super.replaceChild(hMBase, hMBase2);
        if (hMBase != null && hMBase2 != null) {
            getNode().replaceChild(hMBase.getNode(), hMBase2.getNode());
            if ((hMBase instanceof Image) || (hMBase instanceof Scroller) || (hMBase instanceof HorizontalScroller) || (hMBase instanceof List) || (hMBase instanceof ViewPager)) {
                ((HummerLayout) getView()).setClipChildren(true);
            }
        }
    }

    @JsMethod("getElementById")
    @Deprecated
    public HMBase getElementById(String str) {
        return super.getElementById(str);
    }

    @JsMethod("layout")
    @Deprecated
    public void layout() {
        ((HummerLayout) getView()).requestLayout();
    }

    @JsAttribute({"overflow"})
    public void setOverflow(String str) {
        ((HummerLayout) getView()).setNeedClipChildren("hidden".equals(str));
    }

    public void resetStyle() {
        super.resetStyle();
        setOverflow("visible");
    }

    public boolean setStyle(String str, Object obj) {
        str.hashCode();
        if (!str.equals(HummerStyleUtils.Hummer.OVERFLOW)) {
            return false;
        }
        setOverflow((String) obj);
        return true;
    }
}
