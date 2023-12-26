package com.tal.app.thinkacademy.lib.commui.tab.common;

import com.tal.app.thinkacademy.lib.commui.tab.common.IXesTabLayout;

public interface IXesTab<D> extends IXesTabLayout.OnTabSelectedListener<D> {
    void resetHeight(int i);

    void setXesTabHintPoint(boolean z);

    void setXesTabInfo(D d);
}
