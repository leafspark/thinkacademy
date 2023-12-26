package com.tal.app.thinkacademy.common.base.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;

public class XesFragmentTabView extends FrameLayout {
    private int currentPosition;
    private XesTabViewAdapter mAdapter;

    public XesFragmentTabView(Context context) {
        super(context);
    }

    public XesFragmentTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public XesFragmentTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public XesTabViewAdapter getAdapter() {
        return this.mAdapter;
    }

    public void setAdapter(XesTabViewAdapter xesTabViewAdapter) {
        if (this.mAdapter == null && xesTabViewAdapter != null) {
            this.mAdapter = xesTabViewAdapter;
            this.currentPosition = -1;
        }
    }

    public void setCurrentItem(int i) {
        if (i >= 0 && i < this.mAdapter.getCount() && this.currentPosition != i) {
            this.currentPosition = i;
            this.mAdapter.instantiateItem(this, i);
        }
    }

    public int getCurrentItem() {
        return this.currentPosition;
    }

    public Fragment getCurrentFragment() {
        XesTabViewAdapter xesTabViewAdapter = this.mAdapter;
        if (xesTabViewAdapter != null) {
            return xesTabViewAdapter.getCurrentFragment();
        }
        throw new IllegalArgumentException("please call setAdapter first.");
    }
}
