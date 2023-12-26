package com.tal.app.thinkacademy.lib.commui.tab.common;

import android.view.ViewGroup;
import java.util.List;

public interface IXesTabLayout<Tab extends ViewGroup, D> {

    public interface OnTabSelectedListener<D> {
        void onTabSelectedChange(int i, D d, D d2);
    }

    void addTabSelectedChangeListener(OnTabSelectedListener<D> onTabSelectedListener);

    void defaultSelected(D d);

    Tab findTab(D d);

    void inflateInfo(List<D> list, boolean z);
}
