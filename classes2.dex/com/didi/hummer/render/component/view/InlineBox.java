package com.didi.hummer.render.component.view;

import android.content.Context;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.render.style.HummerLayout;
import com.facebook.yoga.YogaFlexDirection;
import java.util.ArrayList;
import java.util.List;

public class InlineBox extends HMBase<HummerLayout> {
    private List<HMBase> children = new ArrayList();

    public InlineBox(HummerContext hummerContext) {
        super(hummerContext, (JSValue) null, (String) null);
        onCreate();
    }

    /* access modifiers changed from: protected */
    public HummerLayout createViewInstance(Context context) {
        return new HummerLayout(context);
    }

    public void onCreate() {
        super.onCreate();
        ((HummerLayout) getView()).setClipChildren(false);
        getYogaNode().setFlexDirection(YogaFlexDirection.ROW);
    }

    public void onDestroy() {
        super.onDestroy();
        if (getView() != null) {
            ((HummerLayout) getView()).removeAllViews();
        }
    }

    public void add(HMBase hMBase) {
        ((HummerLayout) getView()).addView(hMBase);
        ((HummerLayout) getView()).setClipChildren(true);
        this.children.add(hMBase);
    }

    public void remove(HMBase hMBase) {
        ((HummerLayout) getView()).removeView(hMBase);
        this.children.remove(hMBase);
    }

    public boolean isChildrenEmpty() {
        return this.children.size() == 0;
    }

    public void insertBefore(HMBase hMBase, HMBase hMBase2) {
        ((HummerLayout) getView()).insertBefore(hMBase, hMBase2);
        this.children.add(this.children.indexOf(hMBase2), hMBase);
    }

    public void replace(HMBase hMBase, HMBase hMBase2) {
        ((HummerLayout) getView()).replaceView(hMBase, hMBase2);
        this.children.set(this.children.indexOf(hMBase2), hMBase);
    }

    public HMBase getSubview(String str) {
        return ((HummerLayout) getView()).getViewById(str);
    }

    public List<HMBase> getChildren() {
        return this.children;
    }
}
